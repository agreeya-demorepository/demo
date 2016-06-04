(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function loginController(dataService, userService, toaster, $cookieStore, $window) {
    var model = this;
    model.Username = "";
    model.Password = "";
    model.isLoggedIn = false;
    model.fullName = "";
    if($cookieStore.get('userContext')){
      var context = $cookieStore.get('userContext');
      model.Username = context.userName;
      if(context.firstName != ""){
        model.fullName = context.userContext.firstName + ' ' + context.userContext.lastName;
      } else {
        model.fullName = context.userContext.userName;
      }

      model.isLoggedIn = true;
    };
    model.validateLogin = function(userName, psd) {
      var userContext;
      userService.validateUser(userName, psd).then(function(userResponse){
        if(userResponse) {
          toaster.pop('success', "Login", "You are successfully logged in.");
          model.isLoggedIn = true;
           $cookieStore.put("userContext", userResponse);
           var context = $cookieStore.get('userContext');
           console.log("Get the context from cookieStore");
           console.log(context);
           if(context.firstName != ""){
             model.fullName = context.userContext.firstName + ' ' + context.userContext.lastName;
           } else {
             model.fullName = context.userContext.userName;
           }
           //model.$router.navigate(['UserHomePage']);
           //$window.location.href = "#/userHome";
        } else {
         toaster.pop('error', "Login", "Wrong credentials! Please try again.");
         model.isLoggedIn = false;
        }
      }, function(error){
        toaster.pop('error', "Login", "Wrong credentials! Please try again.");
        model.isLoggedIn = false;
      });
    };

    model.logout = function() {
      userService.logoutUser().then(function(userResponse){
          if(userResponse){
            if(userResponse.status == "0"){
              $cookieStore.remove('userContext');
              model.isLoggedIn = false;
              //model.$router.navigate(['Home']);
              //$window.location.href = "#/";
              location.href="#/home";
            } else {
              toaster.pop('error', "Logout", userResponse.message);
              model.isLoggedIn = true;
            }
          }
      });

    }
  }

  module.component("loginControl", {
    templateUrl: "./app/templates/loginControl.html",
    controllerAs: "model",
    controller: ['dataService', 'userService', 'toaster', '$cookieStore', '$window', loginController],
    bindings: {
      $router: '<'
    }
  });
}());

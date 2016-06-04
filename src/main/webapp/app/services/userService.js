(function() {
  'use strict';
  var module = angular.module("chhsDemo");
  module.factory("userService", ["dataService", "$q", "$cookieStore", function(dataService, $q, $cookieStore){
    var userService = {};

    userService.validateUser = function(userName, password) {
      var deferred = $q.defer();
      dataService.validateUser(userName, password).then(function(userResponse){
        console.log("User response data: ", userResponse);
          deferred.resolve(userResponse);
      }, function(errors){
        deferred.reject();
      });
      return deferred.promise;
    }

    ///Logout call for current userName
    userService.logoutUser = function(){
      var deferred = $q.defer();
      var context = $cookieStore.get('userContext');
      if(context){
        dataService.logoutUser(context).then(function(userResponse){
          console.log("User response data: ", userResponse);
            deferred.resolve(userResponse);
        }, function(errors){
          deferred.reject();
        });
      } else {
        deferred.reject();
      }

      return deferred.promise;
    }

    return userService;
  }]);
}());

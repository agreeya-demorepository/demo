(function(angular) {
  'use strict';
  var module = angular.module("chhsDemo");

  function homePageController($cookieStore) {
    var model = this;

    model.GoToFamilyRegistration = function() {
      model.$router.navigate(['FamilyRegistration', 'FamilyRegistrationEligibility']);
    }

    if($cookieStore.get('userContext')){
      var context = $cookieStore.get('userContext');
      model.$router.navigate(['UserHomePage']);
    };
  }

  module.component("homePage", {
    templateUrl: "./app/templates/home.html",
    controllerAs: "model",
    controller: ['$cookieStore', homePageController],
    bindings: {
      $router: '<'
    }
  });
}(window.angular));

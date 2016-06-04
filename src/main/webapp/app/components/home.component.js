(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function homePageController() {
    var model = this;

    model.GoToFamilyRegistration = function() {
      model.$router.navigate(['FamilyRegistration', 'FamilyRegistrationEligibility']);
    }
  }

  module.component("homePage", {
    templateUrl: "./app/templates/home.html",
    controllerAs: "model",
    controller: [homePageController],
    bindings: {
      $router: '<'
    }
  });
}());

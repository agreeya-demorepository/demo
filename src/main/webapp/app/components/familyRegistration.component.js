(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function familyRegistrationController() {
    var model = this;

  }

  module.component("familyRegistration", {
    templateUrl: "./app/templates/familyRegistrationMain.html",
    $routeConfig: [
      {path: "/familyRegistrationEligibility", component: "familyRegistrationEligibility", name: "FamilyRegistrationEligibility", useAsDefault: true},
      {path: "/familyRegistrationProfile", component: "familyRegistrationProfile", name: "FamilyRegistrationProfile"}
    ],
    controllerAs: "model",
    controller: [familyRegistrationController]
  });

}());

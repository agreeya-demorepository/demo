(function(angular) {
  'use strict';
  var module = angular.module("chhsDemo");

  function familyRegistrationEligibilityController(toaster) {
    var model = this;
    model.homeStudy = {
      value: "no"
    }
    model.priorTraining = {
      value: "no"
    }
    model.GoTo = function(){
      if(model.homeStudy.value.toLowerCase() === "yes" && model.priorTraining.value.toLowerCase() === "yes"){
        model.$router.navigate(['FamilyRegistrationProfile']);
      } else {
        toaster.pop('error', "Eligibility Criteria to become Foster Parent", "Selected criteria does not match!");
        console.log("Selected criteria does not match");
        location.href="#/home";
      }
    }
  }

  module.component("familyRegistrationEligibility", {
    templateUrl: './app/templates/familyRegistrationEligibility.html',
    controllerAs: "model",
    controller: ["toaster", familyRegistrationEligibilityController],
    bindings: {
      $router: '<'
    }
  })

}(window.angular));

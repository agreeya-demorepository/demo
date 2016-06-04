(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function familyRegistrationProfileController() {
    var model = this;

    model.SaveRegistrationProfileData = function(){
      alert("Got it");
    }
  }

  module.component("familyRegistrationProfile", {
    templateUrl: './app/templates/familyRegistrationProfile.html',
    constrollerAs: "model",
    controller: [familyRegistrationProfileController]
  });



}());

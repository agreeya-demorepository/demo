(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function userPersonalInformationController(toaster) {
    var model = this;
   

  }

  module.component("userPersonalInformation", {
      templateUrl: './app/templates/userPersonalInformation.html',
    controllerAs: "model",
    controller: ["toaster", userPersonalInformationController],
    bindings: {
      $router: '<'
    }
  })

}());

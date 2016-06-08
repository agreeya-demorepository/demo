(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function userLicenseController($cookieStore, toaster, userService) {
    var model = this;

    var context = {};
    if ($cookieStore.get('userContext')) {
        var _context = $cookieStore.get('userContext');
        context = _context.userContext;
        //debugger;
    };

    model.updateUserLicense = function () {

      

        var userProfileData = JSON.stringify({ userContext: context, licenceDetails: model.licenceDetails, registrationStage: 4 });
        userService.UpdateAccountDetails(userProfileData).then(function (userAccountDetailsResponse) {
            if (userAccountDetailsResponse.status == "0") {
                console.log("User License response: ", userAccountDetailsResponse);
                toaster.pop("success", "License Details", userAccountDetailsResponse.message);
                $cookieStore.put("licenceDetails", model.licenceDetails);
                model.$router.navigate(["UserAccountDetails"])
            } else {
                console.log("User Account Details response: ", userAccountDetailsResponse.Error);
                toaster.pop("error", "License Details", userAccountDetailsResponse.message);
            }

        }, function (error) {
            console.log("User License response: ", error);
            toaster.pop("error", "Register Profile", "Error in profile registration.");
        });
    }
  }

  module.component("userLicense", {
      templateUrl: './app/templates/userLicense.html',
    controllerAs: "model",
    controller: ["$cookieStore", "toaster", "userService", userLicenseController],
    bindings: {
      $router: '<'
    }
  })

}());

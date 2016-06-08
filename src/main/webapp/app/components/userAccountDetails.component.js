(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function userAccountDetailsController(toaster, $cookieStore, userService) {
    var model = this;
    var context = {};
    var _userName = '';
    if ($cookieStore.get('userContext')) {
        var _context = $cookieStore.get('userContext');
        context = _context.userContext;
        _userName = context.userName;
        //debugger;
    };

    //var userData = JSON.stringify({ userName: _userName });
    //debugger;
    //userService.GetAccountDetails(userData).then(function (userDataResponse) {
    //    debugger;
    //}, function (error) {
    //    console.log("User registration response: ", error);
    //    toaster.pop("error", "Register Profile", "Error in profile registration.");
    //});

      //function call on click of "Save" button. It will execute service function to save data in database
    model.updateAccountProfile = function () {

        model.personalProfile.training = "y";
        model.personalProfile.homestudy = "y";

        var userProfileData = JSON.stringify({ userContext: context, personalProfile: model.personalProfile, registrationStage: 1 });
        userService.UpdateAccountDetails(userProfileData).then(function (userAccountDetailsResponse) {
            if (userAccountDetailsResponse.status == "0") {
                console.log("User Account Details response: ", userAccountDetailsResponse);
                toaster.pop("success", "Account Details", userAccountDetailsResponse.message);
                $cookieStore.put("personalProfile", model.personalProfile);
                model.$router.navigate(["UserPersonalInformation"])
            } else {
                console.log("User Account Details response: ", userAccountDetailsResponse.Error);
                toaster.pop("error", "Account Details", userAccountDetailsResponse.message);
            }

        }, function (error) {
            console.log("User registration response: ", error);
            toaster.pop("error", "Register Profile", "Error in profile registration.");
        });
    }
  }

  module.component("userAccountDetails", {
    templateUrl: './app/templates/userAccountDetails.html',
    controllerAs: "model",
    controller: ["toaster", '$cookieStore', 'userService', userAccountDetailsController],
    bindings: {
      $router: '<'
    }
  })

}());

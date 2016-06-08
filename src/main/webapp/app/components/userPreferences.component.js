(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function userPreferencesController($cookieStore, toaster, userService) {
    var model = this;
    
    var context = {};
    if ($cookieStore.get('userContext')) {
        var _context = $cookieStore.get('userContext');
        context = _context.userContext;
        //debugger;
    };

    model.familyDetails = {};

    model.ageGroups = ["3-5 years", "6-8 years", "9-11 years", "12-15 years"];
    
    model.kid1AgeGroup = model.ageGroups[0];
    model.kid2AgeGroup = model.ageGroups[0];

    model.kids = ["1", "2"];
    model.familyDetails.numberOfKids = model.kids[0];

      //default
    model.familyDetails.haveKids = "yes";
    model.familyDetails.numberOfKids = "1";

    model.setKidsSection = function () {
        model.hasTwoKids = false;
        if(model.familyDetails.numberOfKids == "2")
        {
            model.hasTwoKids = true;
        }
    }

    model.updatePreferences = function () {

        var userKids = [{ kidName: model.kid1Name, age: model.kid1AgeGroup, hobbies: model.kid1Hobbies }, { kidName: model.kid2Name, age: model.kid2AgeGroup, hobbies: model.kid2Hobbies }]
        model.familyDetails.kids = userKids;
        var userProfileData = JSON.stringify({ userContext: context, familyDetails: model.familyDetails, registrationStage: 3 });
        userService.UpdateAccountDetails(userProfileData).then(function (userAccountDetailsResponse) {
            if (userAccountDetailsResponse.status == "0") {
                console.log("User Preferences response: ", userAccountDetailsResponse);
                toaster.pop("success", "User Preferences", userAccountDetailsResponse.message);
                $cookieStore.put("familyDetails", model.familyDetails);
                model.$router.navigate(["UserLicense"])
            } else {
                console.log("User Preferences response: ", userAccountDetailsResponse.Error);
                toaster.pop("error", "User Preferences", userAccountDetailsResponse.message);
            }

        }, function (error) {
            console.log("User registration response: ", error);
            toaster.pop("error", "Register Profile", "Error in profile registration.");
        });
    }
  }

  module.component("userPreferences", {
      templateUrl: './app/templates/userPreferences.html',
    controllerAs: "model",
    controller: ["$cookieStore", "toaster", "userService", userPreferencesController],
    bindings: {
      $router: '<'
    }
  })

}());

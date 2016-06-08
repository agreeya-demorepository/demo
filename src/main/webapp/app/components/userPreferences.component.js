(function() {
  'use strict';
  var module = angular.module("chhsDemo");

  function userPreferencesController($cookieStore, toaster, userService) {
    var model = this;
    
    var context = {};
    var _personalProfile = {};
    var _personalDetails = {};
    var _spouseDetails = {};
    var _userName = '';
    if ($cookieStore.get('userContext')) {
        var _context = $cookieStore.get('userContext');
        context = _context.userContext;
        _userName = context.userName;
        //debugger;
    };

    if ($cookieStore.get('personalProfile')) {
        _personalProfile = $cookieStore.get('personalProfile');
    };
    if ($cookieStore.get('personalDetails')) {
        _personalDetails = $cookieStore.get('personalDetails');
    };
    
    model.familyDetails = {};

    var userInfo = {};
    var userData = JSON.stringify({ userName: _userName });
    userService.GetAccountDetails(userData).then(function (userDataResponse) {
        userInfo = userDataResponse;
        if (userInfo.user != null) {
            model.familyDetails = userInfo.user.familyDetails;

            if (_personalProfile == null) {
                _personalProfile = model.personalProfile;
            }
            if (_personalDetails == null) {
                _personalDetails = model.personalDetails;
            }

            if(!model.familyDetails.haveKids || model.familyDetails.haveKids=="")
            {
                //default
                model.familyDetails.haveKids = "n";
            }
        }
    }, function (error) {
        console.log("User Info response: ", error);
        toaster.pop("error", "Unable to fetch user info", "Error in profile registration.");
    });

    model.ageGroups = ["3-5 years", "6-8 years", "9-11 years", "12-15 years"];
    
    model.kid1AgeGroup = model.ageGroups[0];
    model.kid2AgeGroup = model.ageGroups[0];

    model.kids = ["1", "2"];
    model.familyDetails.numberOfKids = model.kids[0];


     
    

   
    model.validatePreferences = function () {
        var valid = true;
        if (!model.familyDetails.description || model.familyDetails.description == "")
        {
            valid = false;
        }
        if (model.familyDetails.haveKids == "y")
        {
            if (model.familyDetails.numberOfKids == "1") {
                if(!model.kid1Name || model.kid1Name =='' || !model.kid1Hobbies || model.kid1Hobbies=='')
                {
                    valid = false;
                }
            }
            if (model.familyDetails.numberOfKids == "2") {
                if (!model.kid1Name || model.kid1Name == '' || !model.kid1Hobbies || model.kid1Hobbies == '') {
                    valid = false;
                }
                if (!model.kid2Name || model.kid2Name == '' || !model.kid2Hobbies || model.kid2Hobbies == '') {
                    valid = false;
                }
            }

            if (!model.familyDetails.kidsPref || model.familyDetails.kidsPref=="")
            {
                valid = false;
            }
        }
        return valid;
    }

    model.setKidsSection = function () {
        model.hasTwoKids = false;
        if (model.familyDetails.numberOfKids == "2") {
            model.hasTwoKids = true;
        }
    }

    model.updatePreferences = function () {

        if (model.validatePreferences()) {
            var userKids = [];
            if (model.familyDetails.haveKids == "y") {
                if (model.familyDetails.numberOfKids == "2") {
                    userKids = [{ kidName: model.kid1Name, age: model.kid1AgeGroup, hobbies: model.kid1Hobbies }, { kidName: model.kid2Name, age: model.kid2AgeGroup, hobbies: model.kid2Hobbies }];
                }
                else {
                    userKids = [{ kidName: model.kid1Name, age: model.kid1AgeGroup, hobbies: model.kid1Hobbies }];
                }
            }

            model.familyDetails.kids = userKids;
            var userProfileData = JSON.stringify({ userContext: context, personalProfile: _personalProfile, personalDetails: _personalDetails, familyDetails: model.familyDetails, registrationStage: 3 });
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
                toaster.pop("error", "Register Profile", "Error in fetching user profile.");
            });
        }
        else {
            toaster.pop("error", "User Preferences", "Please provide mandatory information");
            return false;
        }

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

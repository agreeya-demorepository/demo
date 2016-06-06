(function (angular) {
    'use strict';
    var module = angular.module("chhsDemo");

    function familyRegistrationProfileController($cookieStore, userService, toaster) {
        var model = this;
        model.confirmPassword = "";
        model.personalProfile = {
            homestudy: "y",
            training: "y",
            useremail: "",
            userName: "",
            password: ""
        }

        //function call on click of "Save" button. It will execute service function to save data in database
        model.SaveRegistrationProfileData = function () {
            var userProfileData = JSON.stringify({
                personalProfile: model.personalProfile,
                registrationStage: 1
            });
            userService.SaveRegistrationProfileData(userProfileData).then(function (userRegistrationResponse) {
                if (userRegistrationResponse.status == "0") {
                    console.log("User registration response: ", userRegistrationResponse);
                    toaster.pop("success", "Register Profile", userRegistrationResponse.message);
                    $cookieStore.put("personalProfile", model.personalProfile);
                    $cookieStore.put("userContext", userRegistrationResponse);
                    model.$router.navigate(["FamilyRegistrationProfileStep2"])
                } else {
                    console.log("User registration response: ", userRegistrationResponse.Error);
                    toaster.pop("error", "Register Profile", userRegistrationResponse.message);
                }

            }, function (error) {
                console.log("User registration response: ", error);
                toaster.pop("error", "Register Profile", "Error in profile registration.");
            });
        }
    };


    //controller for step 2:
    function familyRegistrationProfileStep2Controller($cookieStore, userService, toaster) {
        var model = this;
        model.genders = [{
            Id: 1,
            Name: 'Male'
                }, {
            Id: 2,
            Name: 'Female'
                }];
        model.maritalStatus = [
            {
                Id: 1,
                Name: 'Single'
          }, {
                Id: 2,
                Name: 'Married'
          }, {
                Id: 3,
                Name: 'Divorced'
          }
        ];
        model.ddlSpouseGender = "";
        model.ddlGenderValue = "";
        model.ddlMaritalStatusValue = "";
        model.personalDetails = {
            contactNo: "",
            dob: "",
            firstName: "",
            gender: "",
            hobbies: "",
            income: "",
            lastName: "",
            maritalStatus: "",
            occupation: "",
            preference: "",
            race: "",
            religion: "",
            spouseDetails: {
                contactNo: "",
                dob: "",
                firstName: "",
                gender: "",
                hobbies: "",
                income: "",
                lastName: "",
                maritalStatus: "",
                occupation: "",
                preference: "",
                race: "",
                religion: ""
            }
        };

        //function call on click of "Save" button. It will execute service function to save data in database
        model.SaveRegistrationProfileData = function () {
            model.personalDetails.maritalStatus = $("#MaritalStatusSelector").val();
            model.personalDetails.gender = $("#genderSelector").val();
            model.personalDetails.spouseDetails.gender = $("#spouseGenderSelector").val();

            if ($cookieStore.get("personalProfile")) {
                var personalProfileData = $cookieStore.get("personalProfile");

                var userProfileData = JSON.stringify({
                    personalProfile: personalProfileData,
                    personalDetails: model.personalDetails,
                    registrationStage: 2
                });
                userService.SaveRegistrationProfileData(userProfileData).then(function (userRegistrationResponse) {
                    if (userRegistrationResponse.status == "0") {
                        console.log("User registration response: ", userRegistrationResponse);
                        toaster.pop("success", "Register Profile", userRegistrationResponse.message);
                        $cookieStore.put("personalDetails", model.personalDetails);
                        if ($cookieStore.get("userContext")) {
                            $cookieStore.remove("userContext");
                        }
                        $cookieStore.put("userContext", userRegistrationResponse);
                        model.$router.navigate(["FamilyRegistrationProfileStep3"]);
                    } else {
                        console.log("User registration response: ", userRegistrationResponse.Error);
                        toaster.pop("error", "Register Profile", userRegistrationResponse.message);
                    }

                }, function (error) {
                    console.log("User registration response: ", error);
                    toaster.pop("error", "Register Profile", "Error in profile registration.");
                });
            } else {
                toaster.pop("error", "Register Profile", "Your profile is not yet register.");
            }

        };

        //function call on click of "Save & Exit" button. It will execute service function to save data in database
        model.SaveRegistrationProfileDataAndExit = function () {
            model.personalDetails.maritalStatus = $("#MaritalStatusSelector").val();
            model.personalDetails.gender = $("#genderSelector").val();
            model.personalDetails.spouseDetails.gender = $("#spouseGenderSelector").val();

            if ($cookieStore.get("personalProfile")) {
                var personalProfileData = $cookieStore.get("personalProfile");

                var userProfileData = JSON.stringify({
                    personalProfile: personalProfileData,
                    personalDetails: model.personalDetails,
                    registrationStage: 2
                });
                userService.SaveRegistrationProfileData(userProfileData).then(function (userRegistrationResponse) {
                    if (userRegistrationResponse.status == "0") {
                        console.log("User registration response: ", userRegistrationResponse);
                        toaster.pop("success", "Register Profile", userRegistrationResponse.message);
                        $cookieStore.remove("personalProfile");
                        if ($cookieStore.get("userContext")) {
                            $cookieStore.remove("userContext");
                        }
                        $cookieStore.put("userContext", userRegistrationResponse);
                        model.$router.navigate(["RegistrationThankYou"]);
                    } else {
                        console.log("User registration response: ", userRegistrationResponse.Error);
                        toaster.pop("error", "Register Profile", userRegistrationResponse.message);
                    }

                }, function (error) {
                    console.log("User registration response: ", error);
                    toaster.pop("error", "Register Profile", "Error in profile registration.");
                });
            } else {
                toaster.pop("error", "Register Profile", "Your profile is not yet register.");
            }

        }
    }

    //Controller for step 3
    function familyRegistrationProfileStep3Controller($cookieStore, userService, toaster) {
        var model = this;
        model.haveKids = "no"
        model.numberOfKids = 0;
        model.kid1 = {
            kidName: "",
            age: "0",
            hobbies: ""
        };
        model.kid2 = {
            kidName: "",
            age: "0",
            hobbies: ""
        };
        model.kids = [];
        model.showKidsDetails = function () {
            var numberOfKids = $("#ddl_numofKids").val();
            model.numberOfKids = numberOfKids;
            //console.log(numberOfKids);
        }


        model.familyDetails = {
            description: "",
            numberOfKids: "",
            kidsPref: "",
            haveKids: "",
            kids: []
        }

        model.ddlNumberOfKids = [
            {
                Id: 1,
                Kid: '1'
            },
            {
                Id: 2,
                Kid: '2'
            }
  ];
        model.kidsAgeGroups = [
            {
                Id: 1,
                ageGroup: '1-5'
            },
            {
                Id: 2,
                ageGroup: '6-10'
            },
            {
                Id: 3,
                ageGroup: '11-15'
            },
            {
                Id: 4,
                ageGroup: '15-20'
            },
            {
                Id: 5,
                ageGroup: ' > 20'
            },
];

        //function call on click of "Save" button. It will execute service function to save data in database
        model.SaveRegistrationProfileData = function () {

            if ($cookieStore.get("personalProfile") && $cookieStore.get("personalDetails")) {
                var personalProfileData = $cookieStore.get("personalProfile");
                var personalDetailsData = $cookieStore.get("personalDetails");

                model.kids.push(model.kid1);
                model.kids.push(model.kid2);
                model.familyDetails.kids = model.kids;

                var userProfileData = JSON.stringify({
                    personalProfile: personalProfileData,
                    personalDetails: personalDetailsData,
                    familyDetails: model.familyDetails,
                    registrationStage: 3
                });
                userService.SaveRegistrationProfileData(userProfileData).then(function (userRegistrationResponse) {
                    if (userRegistrationResponse.status == "0") {
                        console.log("User registration response: ", userRegistrationResponse);
                        toaster.pop("success", "Register Profile", userRegistrationResponse.message);
                        $cookieStore.put("familyDetails", model.familyDetails);
                        if ($cookieStore.get("userContext")) {
                            $cookieStore.remove("userContext");
                        }
                        $cookieStore.put("userContext", userRegistrationResponse);
                        model.$router.navigate(["FamilyRegistrationProfileStep4"]);
                    } else {
                        console.log("User registration response: ", userRegistrationResponse.Error);
                        toaster.pop("error", "Register Profile", userRegistrationResponse.message);
                    }

                }, function (error) {
                    console.log("User registration response: ", error);
                    toaster.pop("error", "Register Profile", "Error in profile registration.");
                });
            } else {
                toaster.pop("error", "Register Profile", "Your profile is not yet register.");
            }

        };

        //function call on click of "Save & Exit" button. It will execute service function to save data in database
        model.SaveRegistrationProfileDataAndExit = function () {

            if ($cookieStore.get("personalProfile") && $cookieStore.get("personalDetails")) {
                var personalProfileData = $cookieStore.get("personalProfile");
                var personalDetailsData = $cookieStore.get("personalDetails");

                model.kids.push(model.kid1);
                model.kids.push(model.kid2);
                model.familyDetails.kids = model.kids;

                var userProfileData = JSON.stringify({
                    personalProfile: personalProfileData,
                    personalDetails: personalDetailsData,
                    familyDetails: model.familyDetails,
                    registrationStage: 3
                });
                userService.SaveRegistrationProfileData(userProfileData).then(function (userRegistrationResponse) {
                    if (userRegistrationResponse.status == "0") {
                        console.log("User registration response: ", userRegistrationResponse);
                        toaster.pop("success", "Register Profile", userRegistrationResponse.message);
                        $cookieStore.remove("personalProfile");
                        $cookieStore.remove("personalDetails");
                        if ($cookieStore.get("userContext")) {
                            $cookieStore.remove("userContext");
                        }
                        $cookieStore.put("userContext", userRegistrationResponse);
                        model.$router.navigate(["RegistrationThankYou"]);
                    } else {
                        console.log("User registration response: ", userRegistrationResponse.Error);
                        toaster.pop("error", "Register Profile", userRegistrationResponse.message);
                    }

                }, function (error) {
                    console.log("User registration response: ", error);
                    toaster.pop("error", "Register Profile", "Error in profile registration.");
                });
            } else {
                toaster.pop("error", "Register Profile", "Your profile is not yet register.");
            }
        }

    } //familyRegistrationProfileStep3Controller ends here

    //Controller for step 4
    function familyRegistrationProfileStep4Controller($cookieStore, userService, toaster) {
        var model = this;
        model.haveFosterLicense = "no";
        
        model.licenceDetails = {
            agencyContact: "",
            agencyWorker: 0,
            dateOfIssue: "",
            licenceNo: ""
	    }

        //function call on click of "Save" button. It will execute service function to save data in database
        model.SaveRegistrationProfileData = function () {

            if ($cookieStore.get("personalProfile") && $cookieStore.get("personalDetails") && $cookieStore.get("familyDetails")) {
                var personalProfileData = $cookieStore.get("personalProfile");
                var personalDetailsData = $cookieStore.get("personalDetails");
                var familyDetailsData = $cookieStore.get("familyDetails");


                var userProfileData = JSON.stringify({
                    personalProfile: personalProfileData,
                    personalDetails: personalDetailsData,
                    familyDetails: familyDetailsData,
                    licenceDetails: model.licenceDetails,
                    registrationStage: 4
                });
                userService.SaveRegistrationProfileData(userProfileData).then(function (userRegistrationResponse) {
                    if (userRegistrationResponse.status == "0") {
                        console.log("User registration response: ", userRegistrationResponse);
                        toaster.pop("success", "Register Profile", userRegistrationResponse.message);
                        
                        $cookieStore.remove("personalProfile");
                        $cookieStore.remove("personalDetails");
                        $cookieStore.remove("familyDetails");
                        if ($cookieStore.get("userContext")) {
                            $cookieStore.remove("userContext");
                        }
                        $cookieStore.put("userContext", userRegistrationResponse);
                        model.$router.navigate(["RegistrationThankYou"]);
                    } else {
                        console.log("User registration response: ", userRegistrationResponse.Error);
                        toaster.pop("error", "Register Profile", userRegistrationResponse.message);
                    }

                }, function (error) {
                    console.log("User registration response: ", error);
                    toaster.pop("error", "Register Profile", "Error in profile registration.");
                });
            } else {
                toaster.pop("error", "Register Profile", "Your profile is not yet register.");
            }

        };//SaveRegistrationProfileData function ends here
    };
    
    
    //Thank you page controller
    function familyRegistrationProfileThankYouController($cookieStore) {
        var model = this;
        
        model.GotoMyPage = function() {
            if($cookieStore.get("userContext")){
                model.$router.navigate(["UserHomePage"]);
            } else {
                model.$router.navigate(["Home"]);
            }
            
        }
    }



    module.component("familyRegistrationProfile", {
        templateUrl: "./app/templates/familyRegistrationProfile.html",
        controllerAs: "model",
        controller: ["$cookieStore", "userService", "toaster", familyRegistrationProfileController],
        bindings: {
            $router: '<'
        }
    });


    module.component("familyRegistrationProfileStep2", {
        templateUrl: "./app/templates/familyRegistrationProfileStep2.html",
        controllerAs: "model",
        controller: ["$cookieStore", "userService", "toaster", familyRegistrationProfileStep2Controller],
        bindings: {
            $router: '<'
        }
    });

    module.component("familyRegistrationProfileStep3", {
        templateUrl: "./app/templates/familyRegistrationProfileStep3.html",
        controllerAs: "model",
        controller: ["$cookieStore", "userService", "toaster", familyRegistrationProfileStep3Controller],
        bindings: {
            $router: '<'
        }
    });

    module.component("familyRegistrationProfileStep4", {
        templateUrl: "./app/templates/familyRegistrationProfileStep4.html",
        controllerAs: "model",
        controller: ["$cookieStore", "userService", "toaster", familyRegistrationProfileStep4Controller],
        bindings: {
            $router: '<'
        }
    });
    
    module.component("familyRegistrationProfileThankYou", {
       templateUrl: "./app/templates/familyRegistrationProfileThankYou.html",
        controllerAs: "model",
        controller: ["$cookieStore", familyRegistrationProfileThankYouController],
        bindings: {
            $router: "<"
        }
    });

}(window.angular));
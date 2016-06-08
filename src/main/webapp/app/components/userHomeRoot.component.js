(function () {
    'use strict';
    var module = angular.module("chhsDemo");

    function userHomeRootController() {
        var model = this;

        //model.GoToUserAccountDetails = function () {
        //    model.$router.navigate(['UserHomeRoot', 'UserAccountDetails']);
        //}
        model.tabA = "active";


        model.setActive = function (tabNo) {
            model.tabA = "";
            model.tabB = "";
            model.tabC = "";
            model.tabD = "";
            model.tabE = "";

            switch (tabNo) {
                case 1:
                    model.tabA = "active";
                    break;
                case 2:
                    model.tabB = "active";
                    break;
                case 3:
                    model.tabC = "active";
                    break;
                case 4:
                    model.tabD = "active";
                    break;
                case 5:
                    model.tabE = "active";
                    break;
                default:
                    model.tabA = "active";
                    break;
            }



        }

    }

    module.component("userHomeRoot", {
        templateUrl: './app/templates/userHomeRoot.html',
        $routeConfig: [
            { path: "/userStatus", component: "userStatus", name: "UserStatus", useAsDefault: true },
            { path: "/userAccountDetails", component: "userAccountDetails", name: "UserAccountDetails" },
            { path: "/userPersonalInformation", component: "userPersonalInformation", name: "UserPersonalInformation" },
            { path: "/userPreferences", component: "userPreferences", name: "UserPreferences" },
            { path: "/userLicense", component: "userLicense", name: "UserLicense" },
            {path: "/childFacilities", component: "childResidentialFacilities", name: "SearchChildResidentialFacilities"},
            {path: "/fosterCareAgencies", component: "fosterCareAgencies", name: "SearchFosterCareAgencies"},
            {path: "/mails", component: "userInbox", name: "UserInbox"},
        ],
        controllerAs: "model",
        controller: [userHomeRootController]
    });
}());

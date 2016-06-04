(function() {
   "use strict";

   var module = angular.module("chhsDemo");
   function mainController(dataService, userService, toaster) {
     var model = this;

     dataService.getResponse().then(function(data){
       console.log(data);
     });
   }





   module.component("movieApp", {
      templateUrl: "./app/templates/main.html",
      $routeConfig: [
          {path: "/", component: "homePage", name: "Home", useAsDefault: true},
          {path: "/home", component: "homePage", name: "HomePage"},
          {path: "/familyRegistration/...", component: "familyRegistration", name: "FamilyRegistration"},
          {path: "/list", component: "movieList", name: "List"},
          {path: "/about", component: "appAbout", name: "About"},
          {path: "/detail/:id", component: "movieDetails", name: "Details"},
          {path: "/userHome", component: "userHome", name: "UserHomePage"},
          {path: "/**", redirectTo: ["List"]}
      ],
      controllerAs: "model",
      controller: ["dataService", "userService", "toaster", mainController]
   });

}());

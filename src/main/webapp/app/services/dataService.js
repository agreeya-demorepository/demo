(function(angular) {
  'use strict';
  var module = angular.module("chhsDemo");

  module.factory("dataService", ["$http", "$resource", "$q", function ($http, $resource, $q) {
    var dataService = {};
    dataService.fetchMovies = function() {
            return $http.get("./app/data/movies.json").then(function (response) {
                return response.data;
            })
        }
    dataService.getUser = function() {
      return $http.get("http://localhost:8080/chhs/rest/contextinit/createusercontext").then(function (response) {
          console.log("User data");
          console.log(response.data);
          return response.data;
      })
    }
    dataService.validateUser = function(username, password) {
      var deferred = $q.defer();
      var userData = JSON.stringify({userName: username, password: password});
      $.post( "http://localhost:8080/chhs/rest/contextinit/createusercontext", userData, function( data ) {
        var userResponse = JSON.parse(data);
        console.log(userResponse);
        deferred.resolve(userResponse);
      })
      .fail(function(error) {
        console.log(error);
        deferred.reject();
      });

      return deferred.promise;
       
  };

  dataService.logoutUser = function(userContext) {
    var deferred = $q.defer();
    var userData = JSON.stringify(userContext);
    $.post( "http://localhost:8080/chhs/rest/contextinit/userlogout", userData, function( data ) {
      var userResponse = JSON.parse(data);
      console.log(userResponse);
      deferred.resolve(userResponse);
    })
    .fail(function(error) {
      console.log(error);
      deferred.reject();
    });

    return deferred.promise;
  }
    dataService.getResponse = function(){
      return $http.get("http://rest-service.guides.spring.io/greeting").then(function (response) {
        console.log("CORS CAll: ", response.data);
        return response.data;
      });
    }

    dataService.fetchFacilities = function() {
        return $http.get("./app/data/facilities.json").then(function (response) {
          console.log("Facilities data: ", response)
            return response.data;
        }, function(error){
          console.log("Error in getting facilities");
        });
    };

    //Save user registration data in database.
    dataService.SaveRegistrationProfileData = function(registrationData) {
      var deferred = $q.defer();
      $.post( "http://localhost:8080/chhs/rest/member/register", registrationData, function( registrationResponse ) {
        var userRegistrationResponse = JSON.parse(registrationResponse);
        console.log(userRegistrationResponse);
        deferred.resolve(userRegistrationResponse);
      })
      .fail(function(error) {
        console.log(error);
        deferred.reject();
      });

      return deferred.promise;
    }; //SaveRegistrationProfileData function ends here


    return dataService;
  }]);
}(window.angular));

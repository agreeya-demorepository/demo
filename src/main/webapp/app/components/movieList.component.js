(function(){
    "use strict";

    var module = angular.module("chhsDemo");

    function movieController(dataService, CacheFactory) {

      var userContext;

         // Check to make sure the cache doesn't already exist
         if (!CacheFactory.get('userContext')) {
           userContext = CacheFactory('userContext');
         } else {
           userContext = CacheFactory.get('userContext');
         };
         userContext.put('context', {
            sessionId: '234asdfaswr3we4'
        });
        var _context = userContext.get('context');
        console.log("Get the context from cache");
        console.log(_context.sessionId);
         var model = this;
        model.message = "Wonderful";
        model.movies = [];
        model.facilities = [];

        model.$onInit = function () {
            dataService.fetchMovies().then(function(movies){
              model.movies = movies;
            });

        }

        model.changeMessage = function(){
            model.message = "New message on click of change message button";
        }

        model.upRating= function(movie) {
            if(movie.rating < 5){
                movie.rating += 1;
            }
        }
        model.downRating= function(movie) {
            if(movie.rating > 1){
                movie.rating -= 1;
            }
        }

        var columnDefs = [
        {headerName: "Facility Type", field: "facility_type", width: 200},
        {headerName: "Facility Number", field: "facility_number", width: 100},
        {headerName: "Facility Name", field: "facility_name", width: 200},
        {headerName: "Facility License Type", field: "licensee", width: 120},
        {headerName: "Facility Contact", field: "facility_telephone_number", width: 100},
        {headerName: "Address", field: "facility_address", width: 200}
        ];

        var rowData = [];
    var gridOptions = {
        columnDefs: columnDefs,
        rowData: null,
        enableSorting: true,
        enableFiltering: true,
        onGridReady: function() {
          dataService.fetchFacilities().then(function(facilities){
            console.log("Facilites:");
            console.log(facilities);
            console.log(facilities.status);
            if(facilities.status == 0){
              model.facilities = facilities.facilities.pojoList;
              gridOptions.api.setRowData(model.facilities);
            } else {
              gridOptions.api.setRowData(null);
            }

          }, function(error){
            console.log("Error coo!");
          });

            //gridOptions.columnApi.sizeColumnsToFit(800);
            //gridOptions.columnApi.setColumnVisible('facility_address', false);
        }
    };

        model.gridOptions = gridOptions;

    }
module.component("movieList", {
    templateUrl: "./app/templates/movieList.html",
    controllerAs: "model",
    controller: ["dataService", "CacheFactory", movieController]
  });
}())

(function () {
    "use strict";
    var module=angular.module("chhsDemo");

    module.component("movieRating", {
       templateUrl: "./app/templates/movieRating.html",
       bindings: {
           value: "<"
       },
       transclude: true,
       controllerAs: "model",
       controller: function () {
        var model = this;
        model.$onInit = function() {
          model.entries = new Array(model.value);
        };
        model.$onChanges = function(){
            model.entries = new Array(model.value);
        };
       }
    });
}());

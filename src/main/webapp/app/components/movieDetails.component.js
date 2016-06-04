(function(){
    "use strict";
    var module = angular.module("chhsDemo");

    module.component("movieDetails", {
       templateUrl: "./app/templates/movieDetails.html",
       $canActivate: function($timeout){
         return $timeout(function(){
             return true;
         }, 1000)
       },
       controllerAs: "model",
       controller: function(CacheFactory) {
           var model = this;
           var userContext;
           userContext = CacheFactory.get('userContext');

           var _context = userContext.get('context');
           console.log("In Detail page: Get the context from cache");
           console.log(_context.sessionId);
           model.$routerOnActivate = function(next) {
               model.id = next.params.id;
           }
       }
    });
}());

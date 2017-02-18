/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    angular.module('cdstoreApp').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state("home", {
                url: "/",
                templateUrl: "app/features/home/home.html"
            })

            .state("cds", {
                url: "/cds",
                templateUrl: "app/features/cd/cds.html"
        })

    })
}());
/**
 * Created by Administrator on 17/02/2017.
 */
(function() {
    angular.module('cdStore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/cd");

        $stateProvider.state("cd", {
            url: "/cd",
            templateUrl: "app/feature/cd/cd.html"
        }).state("singlecd", {
            url: "/singlecd",
            templateUrl: "app/deature/singlecd/singlecd.html"
        })
    });
}());

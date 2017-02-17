"use strict";

(function () {
    angular.module('cdStore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/cd");
        $stateProvider.state("cd", {
            url: "/cd",
            templateUrl: "app/feature/cd/cd.html"
        })
    });
}());
/**
 * Created by Administrator on 17/02/2017.
 */
"use strict";

(function () {

    angular.module('cdStore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/cd");

        $stateProvider.state("cd", {
            url: "/cd",
            templateUrl: "app/feature/cd/cds.html"
        }).state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        })
    });
}());
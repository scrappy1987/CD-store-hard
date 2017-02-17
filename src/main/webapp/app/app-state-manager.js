/**
 * Created by Administrator on 17/02/2017.
 */

"use strict";

(function () {

    angular.module('cdStore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/cd");

        $stateProvider.state("cd", {
            url: "/cd",
            templateUrl: "app/features/cd/cds.html"
        })
    });
}());
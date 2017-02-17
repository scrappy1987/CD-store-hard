/**
 * Created by Administrator on 17/02/2017.
 */
"use strict";

(function () {

    angular.module("cdStore").service("cdDal", ["dal", CDDal]);

    function CDDal (dal) {

        this.getCDs = function () {
            return dal.http.GET("rest/cdstore/json");
        };

        this.saveCD = function (cdToSave) {
            return dal.http.POST("rest/cdstore/json", cdToSave);
        };

        this.updateCD = function (cdToUpdate) {
            return dal.http.PUT("rest/cdstore/json/", cdToUpdate);
        };

        this.deleteCD = function (cdToDelete) {
            return dal.http.DELETE("/rest/cdstore/json/", cdToDelete);
        };

    }
}());
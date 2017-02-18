/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    function cdDal (dal) {

        this.getCDs = function() {
            return dal.http.GET("rest/cdstore/json");
        };

        this.newCD = function(cdToCreate) {
            return dal.http.POST("rest/cdstore/json", cdToCreate);
        };

        this.updateCD = function(cdToUpdate) {
            return dal.http.PUT("rest/cdstore/json", cdToUpdate);
        };

        this.deleteCD = function(cdToDelete) {
            return dal.http.DELETE("rest/cdstore/json", cdToDelete);
        }
    }
    angular.module('cdstoreApp').service('cdDal', ['dal', cdDal]);
}());
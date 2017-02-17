/**
 * Created by Administrator on 17/02/2017.
 */
(function(){

    angular.module("cdStore").service("cdDal",["dal",CdDal]);

    function CdDal(dal) {

        this.getAllCds = function()
        {
            return dal.http.GET("rest/cdstore/json");
        };

        this.getSingleCd = function(cdId)
        {
            return dal.http.GET("rest/cdstore/json/",cdId);
        };

        this.deleteCD = function(cdId)
        {
            return dal.http.DELETE("rest/cdstore/json/", cdId);
        };

        this.addCd = function(newCd)
        {
            return dal.http.POST("rest/cdstore/json", newCd);
        };

        this.updateCD = function(cdUpdate)
        {
            return dal.http.PUT("rest/cdstore/json/", cdUpdate);
        };
    }
}());
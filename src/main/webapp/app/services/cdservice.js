/**
 * Created by Administrator on 17/02/2017.
 */
(function(){
    var CdService = function(cdDal)
    {
        var factory = {};

        factory.getAllCds = function()
        {
            return cdDal.getAllCds();
        };

        factory.getSingleCd = function(cdId)
        {
            return cdDal.getSingleCd(cdId);
        };
        return factory;
    };
    angular.module('cdStore').factory('cdService',['cdDal',CdService]);
}());
/**
 * Created by Administrator on 17/02/2017.
 */

(function() {

    var CDService =  function(cdDal) {

        this.getCDs = function()
        {
            return cdDal.getCDs();
        };

        this.saveCD = function(cdToAdd)
        {
            return cdDal.saveCD(cdToAdd);
        };

        this.deleteCD = function(cdToRemove)
        {
            return cdDal.deleteCD(cdToRemove);
        };
    };
    
    angular.module('cdStore').service('cdService', ['cdDal', CDService]);
}());
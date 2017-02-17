/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    var CDService =  function(cdDal) {

        this.getCDs = function()
        {
            return cdDal.getCDs();
        };
    };

    angular.module('cdStore').service('cdService', ['cdDal', CDService]);
}());
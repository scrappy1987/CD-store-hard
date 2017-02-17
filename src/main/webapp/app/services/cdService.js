/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    var cdService = function(cdDal) {

        this.getBooks = function() {
            return cdDal.getCDs();
        }
    };
    angular.module('cdstoreApp').service('cdService', ['cdDal', cdService()]);
}());
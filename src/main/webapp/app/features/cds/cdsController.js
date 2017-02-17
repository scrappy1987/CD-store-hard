/**
 * Created by Administrator on 17/02/2017.
 */
(function() {
   var cdsController = function(cdService) {

       var vm = this;

       vm.cds = [];

       function init() {
           cdService.getCDs().then(function (results) {
               vm.cds = results;
           }, function (error) {
               vm.error = true;
               vm.errorMessage = error;
           })
       }

       init();

   };

   angular.module('cdstoreApp').controller('cdsController', ['cdService', cdsController]);
}());
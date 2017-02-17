/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    var CdController =  function(cdService)
    {
        var vm = this;

        vm.reverse =false;

        vm.doSort = function()
        {
            vm.sortby = 'Title';
            vm.reverse= !vm.reverse
        };

        function init() {
            cdService.getCds().then(function (results) {
                console.log("In cd controller about to return data to the client with results " + results);
                vm.books  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();
    };
    angular.module('cdStore').controller('CdController', ['cdService', CdController]);
}());
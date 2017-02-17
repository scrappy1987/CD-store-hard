/**
 * Created by Administrator on 17/02/2017.
 */
(function()
{
    var CdController = function(cdService)
    {
        var vm = this;
        vm.cds = [];

        function init(){
            cdService.getAllCds().then(function(results){
                vm.cds = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }


        init();
    };
    angular.module('cdStore').controller('CdController',['cdService',CdController]);
}());
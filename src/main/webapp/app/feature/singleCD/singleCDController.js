/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    var SingleCDController = function (cdService)
    {
        var vm = this;
        vm.cd = null;
        vm.cdId = 1;

        vm.getSingleCd = function(id)
        {
            vm.cdId = id;
            cd = cdService.getSingleCd(vm.cdId);
        }

    };

    angular.module('cdStore').controller('singleCdController',['$scope','$state','cdService',SingleCDController]);
}());
/**
 * Created by Administrator on 17/02/2017.
 */

(function() {
    var CDController =  function(cdService)
    {
        var vm = this;

        vm.sortBy = 'Artist';
        vm.reverse = false;
        vm.cds = [];

        vm.doSort = function(propName)
        {
            if(vm.sortBy == propName){
                vm.reverse= !vm.reverse;
            } else {
                vm.reverse = false;
            }
            vm.sortBy = propName;

        };

        vm.addNewCD = function()
        {
            var newCD = {
                artist : vm.newArtist,
                song: vm.newSong,
                genre : vm.newGenre
            };
            console.log(newCD);
            cdService.saveCD(newCD).then(function() {
                console.log("In cd controller about to add new cd data");
                clearInput();
                init();
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.removeCD = function(index)
        {
            cdService.deleteCD(vm.cds[index]).then(function () {
                console.log("In cd controller about to remove data");
                init();
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        function init(){
            cdService.getCDs().then(function (results) {
                console.log("In cd controller about to return data to the client with results " + results);
                vm.cds  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        function clearInput(){
            vm.newArtist = "";
            vm.newSong = "";
            vm.newGenre = "";
        }

        init();

    };
    angular.module('cdStore').controller('cdController', ['cdService', CDController]);
}());
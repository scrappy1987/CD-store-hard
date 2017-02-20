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
                "artist" : vm.newArtist,
                "song": vm.newSong,
                "genre" : vm.newGenre
            };
            console.log(newCD);
            cdService.saveCD(newCD);
            init();
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

        init();

    };
    angular.module('cdStore').controller('cdController', ['cdService', CDController]);
}());
/**
 * Created by Administrator on 17/02/2017.
 */
(function() {

    var CDController =  function(cdService)
    {
        var vm = this;

        vm.reverse =false;

        vm.list = ["joe", "joe2", "joe3"]

        vm.cds = [
            {
                "id": 1,
                "artist": "fguoisrnfgsfn",
                "song": "Pure Morning",
                "genre": "Rock"
            },
            {
                "id": 2,
                "artist": "fguoin",
                "song": "Pure Mong",
                "genre": "Rocklll"
            }
        ];

        vm.doSort = function()
        {
            vm.sortby = 'song';
            vm.reverse= !vm.reverse
        };

        function init() {
            /*
            cdService.getCDs().then(function (results) {
                vm.cds  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });*/

            vm.cds = [
                {
                    "id": 1,
                    "artist": "fguoisrnfgsfn",
                    "song": "Pure Morning",
                    "genre": "Rock"
                },
                {
                    "id": 2,
                    "artist": "fguoin",
                    "song": "Pure Mong",
                    "genre": "Rocklll"
                }
            ]
        }

        init();
    };
    angular.module('cdStore').controller('CDController', ['cdService', CDController]);
}());
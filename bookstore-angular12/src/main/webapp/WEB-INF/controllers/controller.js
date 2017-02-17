(function()
{
	var myControllerMethods = function($scope)
	{
		$scope.testString = "Default";

		$scope.storeText()
		{
			testString = $scope.button1;
		}

		$scope.setValue()
		{

		}
	}

	// Into the module "bookstore", ad a controller called "bookstorecontroller". Into this, we pass the scope and
								// all the methods that we need
	angular.module('bookstore').controller('bookStoreController',['$scope', "myControllerMethods"])
}());
'use strict';
app.controller('MainCtrl',['$scope','$http', function($scope,$http) {

	$scope.activePlatform = "x360";
	$scope.games = [];
	$scope.platforms = [];

	$http.get("/rest/game" + $scope.offset + "-" + $scope.pageSize).sucess(

	function(data, status, headers, config) {
		$scope.games = data;
	}).error(
			function(data, status, headers, config) {
				alert("unable to retrieve data for " + $scope.offset + "-"
						+ $scope.pageSize);
			});

	$http.get("/rest/platform" + $scope.offset + "-" + $scope.pageSize).sucess(
			function(data, status, headers, config) {
				$scope.platform = data;
			}).error(
			function(data, status, headers, config) {
				alert("unable to retrieve data for " + $scope.offset + "-"
						+ $scope.pageSize);
			});

}]);
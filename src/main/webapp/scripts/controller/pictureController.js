collectionsApp.controller('pictureController', function($scope, pictureService,
		userService, $state, $modal, $log) {

	$scope.init = function() {
		userService.getCurrentUser(function(response) {
			$scope.currentUser = response.data;
			if ($scope.currentUser === "") {
				$state.transitionTo('login');
			}
		});
		pictureService.getAllPictures(function(response) {
			$scope.pictures = response.data;
		});

	}
	$scope.open = function(picture, callback) {
		modalInstance = $modal.open({
			templateUrl : '/view/pictureDetails.html',
			controller : 'pictureDetailsController',
			size : 'lg',
			resolve : {
				picture : function() {
					return picture;
				}
			}
		});
		modalInstance.result.then(function(result) {
			if (result === 'success') {
				pictureService.getAllPictures(function(response) {
					$scope.pictures = response.data;
				});
			}
		});
	}

});

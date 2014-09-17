collectionsApp.controller('pictureDetailsController', function($scope,
		$modalInstance, pictureService, picture) {

	$scope.init = function() {
		$scope.picture = picture;
		pictureService.getPictureStyles(function(response) {
			$scope.styles = response.data;
		});
		pictureService.getPictureGenres(function(response) {
			$scope.genres = response.data;
		});
		pictureService.getPictureTechnique(function(response) {
			$scope.techniques = response.data;
		});
	}

	$scope.save = function() {
		pictureService.save($scope.picture, onSave);
	}

	$scope.deletePicture = function() {
		pictureService.deletePicture($scope.picture, onDelete);
	}

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	}

	onSave = function(response) {
		status = response.data.status;
		if (status === 'success') {
			$modalInstance.close(status);
		} else {
			alert("DEBUG ALERT: SAVE FAIL");
		}
	}

	onDelete = function(response) {
		status = response.data.status;
		if (status === 'success') {
			$modalInstance.close(status);
		} else {
			alert("DEBUG ALERT: DELETE FAIL");
		}
	}

});
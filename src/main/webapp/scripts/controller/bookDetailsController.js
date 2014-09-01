collectionsApp.controller('bookDetailsController', function($scope, $modalInstance, bookService, book) {

	$scope.init = function () {
		$scope.book = book;
	}
	
	$scope.save = function() {
		bookService.save($scope.book, onSave);
	}

	$scope.deleteBook = function() {
		bookService.deleteBook($scope.book, onDelete);
	}

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	}

	onSave = function(response) {
		status = response.data.status;
		if (status === 'success') {
			$modalInstance.close(status);
		} else {
			alert("DEBUG ALERT: SAVE/DELETE FAIL");
		}
	}
	
	onDelete = function(response) {
		status = response.data.status;
		if (status === 'success') {
			$modalInstance.close(status);
		} else {
			alert("DEBUG ALERT: SAVE/DELETE FAIL");
		}
	}

});
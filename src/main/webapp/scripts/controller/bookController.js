collectionsApp.controller('bookController', function($scope, bookService, userService,
		$state, $modal, $log) {

	$scope.init = function() {
		userService.getCurrentUser(getCurrentUser);
		bookService.getAllBooks(onInit);
	}

	$scope.open = function(book, callback) {
		modalInstance = $modal.open({
			templateUrl : '/view/bookDetails.html',
			controller : 'bookDetailsController',
			size : 'lg',
			resolve : {
				book : function() {
					return book;
				}
			}
		});

		modalInstance.result.then(function(result) {
			if (result === 'success') {
				bookService.getAllBooks(onInit);
			}
		});
	}

	onInit = function(response) {
		$scope.books = response.data;
	}

	getCurrentUser = function(response) {
		$scope.currentUser = response.data;
		if ($scope.currentUser === "") {
			$state.transitionTo('login');
		}
	}

});
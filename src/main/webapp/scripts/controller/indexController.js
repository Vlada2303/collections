collectionsApp.controller('indexController', function($scope, userService,
		$state) {

	$scope.checkAuth = function() {
		userService.getCurrentUser(onGet);
	}

	onGet = function(response) {
		if ((response.data.role === "ROLE_ADMIN")
				|| (response.data.role === "ROLE_USER")) {
			$state.transitionTo('user');
		} else {
			$state.transitionTo('home');
		}
	}
});

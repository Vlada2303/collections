collectionsApp.controller('loginController', function($scope, userService, $state) {
    $scope.login = function() {
        userService.login($scope.user, onLogin);
        $scope.alert = false;
    };

    onLogin = function(response) {
        if (response.data.status === 'success') {
            $state.transitionTo('user');
        } else {
            $scope.alert = true;
        }
    };

}); 
collectionsApp.controller('loginController', function($scope, userService, $state) {
    $scope.alerts = [];

    $scope.login = function() {
        userService.login($scope.user, onLogin);
    }
    addAlert = function() {
        $scope.alerts.push({
            message : 'Bad credentials. Please try again.',
            type : 'danger'
        });
    }
    $scope.closeAlerts = function() {
        $scope.alerts = [];
    }
    onLogin = function(response) {
        if (response.data.status === 'success') {
            $state.transitionTo('user');
        } else {
            $scope.user.curentPassword = "";
            $scope.closeAlerts();
            addAlert();
        }
    };

});
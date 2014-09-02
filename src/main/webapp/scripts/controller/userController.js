collectionsApp.controller('userController', function($scope, userService, $timeout, $state) {

    $scope.alerts = [];
    var timer = false;

    $scope.password = {
        newPassword : "",
        repeatedNewPassword : "",
        currentPassword : "",
    }

    $scope.init = function() {
        userService.getCurrentUser(getCurrentUser);
    }

    $scope.save = function() {
        if (timer) {
            $timeout.cancel(timer)
        }
        timer = $timeout(function() {
            userService.edit($scope.currentUser);
            $scope.addAlert();
            if (timer) {
                $timeout.cancel(timer)
            }
            timer = $timeout(function() {
                $scope.closeAlerts();
            }, 2000)
        }, 500)

    }

    $scope.changePassword = function() {
        if ($scope.password.newPassword === $scope.password.repeatedNewPassword) {
            userService.changePassword($scope.password.newPassword, $scope.password.currentPassword);
        }
    }

    getCurrentUser = function(response) {
        $scope.currentUser = response.data;
        if ($scope.currentUser === "") {
            $state.transitionTo('login');
        }
    }

    $scope.profileEditStatus;
    $scope.changePasswordStatus;

    $scope.addAlert = function() {
        $scope.alerts.push({
            message : 'Details changed successfully!',
            type : 'success'
        });
    }

    $scope.closeAlerts = function() {
        $scope.alerts = [];
    }
});
collectionsApp.controller('userController', function($scope, userService, $timeout, $state) {
    
    var timer = false;          //timer is undefined if in init

    $scope.init = function() {

        $scope.alerts = [];

        $scope.years = [];

        $scope.password = {
            newPassword : "",
            repeatedNewPassword : "",
            currentPassword : "",
        }

        userService.getCurrentUser(getCurrentUser);
        generateYears();
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
            $scope.password.newPassword = "";
            $scope.password.repeatedNewPassword = "";
            $scope.password.currentPassword = "";
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

    generateYears = function() {
        for (i = 1914; i <= 2014; i++) {
            $scope.years.push(i);
        }
    }

    $scope.$watch("currentUser.dateOfBirth", function(dateOfBirth) {
        if (dateOfBirth) {
            $scope.save();
        }
    })

});
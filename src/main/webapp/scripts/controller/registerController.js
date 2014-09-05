collectionsApp.controller('registerController', function($scope, userService, $state) {
    $scope.register = function(){
         userService.register($scope.user, onRegister);
    };
    onRegister = function (response) {
        if (response.data.status === 'success') {
            $state.transitionTo('home');
        }
    };
});
collectionsApp.controller('registerController', function($scope, userService, $state) {
    $scope.register = function(){
         userService.register($scope.user, onRegister);
    $scope.alert = false;
    };
    onRegister = function (response) {
        if (response.data.status === 'success') {
            $state.transitionTo('home');
        } else {
            $scope.alert = true;
        }
    };
    
 
});
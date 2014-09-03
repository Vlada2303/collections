collectionsApp.controller('indexController', function($scope, userService, $state, $translate) {

    $scope.checkAuth = function() {
        userService.getCurrentUser(onGet);
    }

    $scope.changeLanguage = function(langKey) {
        $translate.use(langKey);
    };

    onGet = function(response) {
        if ((response.data.role === "ROLE_ADMIN") || (response.data.role === "ROLE_USER")) {
            $state.transitionTo('user');
        } else {
            $state.transitionTo('home');
        }
    }
});

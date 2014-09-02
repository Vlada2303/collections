collectionsApp.directive('formSelect', function(){
    return {
        restrict: 'E',
        replace: true,
        scope: {
            model: '=',
            name: '@',
            options: '='
        },
        templateUrl: '/directives/formSelect.html',
        link: function(scope, attrs, element) {
        }
    }
});
collectionsApp.directive('formSelectYear', function(){
    return {
        restrict: 'E',
        replace: true,
        scope: {
            model: '=',
            name: '@',
            options: '='
        },
        templateUrl: '/directives/formSelectYear.html',
        link: function(scope, attrs, element) {
        }
    }
});
collectionsApp.directive('formTextArea', function(){
	return {
		restrict: 'E',
		replace: true,
		scope: {
			model: '=',
			callback: '&',
			name: '@',
			size: '@'
		},
		templateUrl: '/directives/formTextArea.html',
        link: function(scope, attrs, element) {
        	
        }
	}
});
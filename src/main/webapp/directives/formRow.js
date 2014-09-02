collectionsApp.directive('formRow', function(){
	return {
		restrict: 'E',
		replace: true,
		scope: {
			model: '=',
			callback: '&',
			name: '@',
			size: '@',
			type: '@',
			icon: '@'
		},
		templateUrl: '/directives/formRow.html',
        link: function(scope, attrs, element) {
        	
        }
	}
});
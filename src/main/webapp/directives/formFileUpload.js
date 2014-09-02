	collectionsApp.directive('formFileUpload', [function(){
		return {
			restrict: 'E',
			replace: true,
			scope: {
				name: '@',
				fileread: '=',
				callback: '='
			},
			templateUrl: '/directives/formFileUpload.html',
	        link: function(scope, element, attrs) {
	        	var input = element.find("input")[0];
	        	input.addEventListener("change", function(changeEvent){
	        		var reader = new FileReader();
	        		reader.onload = function (loadEvent) {
	        			scope.$apply(function () {
	        	            scope.fileread = loadEvent.target.result;
	        	            scope.callback();
	        	        });
	        		}
	        		reader.readAsDataURL(changeEvent.target.files[0]);

	        	})
	        }
	    }
	}]);
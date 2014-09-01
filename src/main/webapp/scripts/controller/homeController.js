collectionsApp.controller('homeController', function($scope, userService,
		$state) {
	$scope.myInterval = 5000;
	var slides = $scope.slides = [];
	$scope.addSlide = function() {
		var newWidth = 600 + slides.length;
		slides.push({
			image : 'public/carousel/slide1.jpg',
			text : ''
		});
		slides.push({
			image : 'public/carousel/slide2.jpg',
			text : ''
		});
		slides.push({
			image : 'public/carousel/slide3.jpg',
			text : ''
		});
	};
	for (var i = 0; i < 1; i++) {
		$scope.addSlide();
	}
});
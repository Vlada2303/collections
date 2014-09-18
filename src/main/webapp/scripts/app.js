var collectionsApp = angular.module('collectionsApp', [ 'ui.router',
		'ui.bootstrap', 'translationService' ]);

collectionsApp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.when('', '/home').otherwise('/home');

	$stateProvider.state('home', {
		url : '/home',
		templateUrl : '/view/home.html',
		controller : 'homeController'
	}).state('register', {
		url : '/register',
		templateUrl : '/view/register.html',
		controller : 'registerController'
	}).state('login', {
		url : '/login',
		templateUrl : '/view/login.html',
		controller : 'loginController'
	}).state('user', {
		url : '/user',
		templateUrl : '/view/user.html',
		controller : 'userController'
	}).state('book', {
		url : '/book',
		templateUrl : '/view/book.html',
		controller : 'bookController'
	}).state('picture', {
		url : '/picture',
		templateUrl : '/view/proba.html',
		controller : 'pictureController'
	})

});
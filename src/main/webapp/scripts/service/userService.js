collectionsApp.service('userService', function($http) {
	return {
		login : function(user, callback) {
			$http.post('/user/login', user).then(callback);
		},
		register : function(user, callback) {
			$http.post('/user/save', user).then(callback);
		},
		getCurrentUser : function(callback) {
			$http.get('/user/getCurentUser').then(callback);
		},

		edit : function(currentUser) {
			$http.post('/user/edit', currentUser);
		},
		
		changePassword : function(newPassword, currentPassword) {
			$http.get('/user/changePassword/'+newPassword+'/'+currentPassword);
		}

	};
});
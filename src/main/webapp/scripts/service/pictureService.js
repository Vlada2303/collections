collectionsApp.service('pictureService', function($http){
	return{
		save : function(picture, callback) {
			$http.post('/picture/save',picture).then(callback);
		},
		getAllPictures : function(callback){
			$http.get('/picture/getAllPictures').then(callback);
		},
		deletePicture : function(picture, callback){
			$http.post('/picture/delete', picture).then(callback);
		},
		getPictureStyles : function (callback){
			$http.get('/picture/getPictureStyles').then(callback);
		},
		getPictureGenres : function(callback){
			$http.get('/picture/getPictureGenres').then(callback);
		},
		getPictureTechniques : function (callback){
			$http.get('/picture/getPictureTechniques').then(callback);
		},
	}
})
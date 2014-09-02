collectionsApp.service('bookService', function($http) {
    return {
        save : function(book, callback) {
            $http.post('/book/save', book).then(callback);
        },

        getAllBooks : function(callback) {
            $http.get('/book/getAllBooks').then(callback);
        },

        deleteBook : function(book, callback) {
            $http.post('/book/delete', book).then(callback);
        },

        getCoverTypes : function(callback) {
            $http.get('/book/getCoverTypes').then(callback);
        },

        getGenreTypes : function(callback) {
            $http.get('/book/getGenreTypes').then(callback);
        }
    };
});
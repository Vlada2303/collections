collectionsApp.controller('bookDetailsController', function($scope, $modalInstance, bookService, book) {

    $scope.init = function() {
        $scope.book = book;
        bookService.getCoverTypes(onInitGetCovers);
        bookService.getGenreTypes(onInitGetGenres);
    }

    $scope.save = function() {
        bookService.save($scope.book, onSave);
    }

    $scope.deleteBook = function() {
        bookService.deleteBook($scope.book, onDelete);
    }

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    }

    onSave = function(response) {
        status = response.data.status;
        if (status === 'success') {
            $modalInstance.close(status);
        } else {
            alert("DEBUG ALERT: SAVE FAIL");
        }
    }

    onDelete = function(response) {
        status = response.data.status;
        if (status === 'success') {
            $modalInstance.close(status);
        } else {
            alert("DEBUG ALERT: DELETE FAIL");
        }
    }

    onInitGetCovers = function(response) {
        $scope.covers = response.data;
    }

    onInitGetGenres = function(response) {
        $scope.genres = response.data;
    }

});
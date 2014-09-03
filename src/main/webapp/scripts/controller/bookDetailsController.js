collectionsApp.controller('bookDetailsController' , function($scope, $modalInstance, bookService, book, $translate) {

    $scope.init = function() {
        $scope.book = book;
        bookService.getCoverTypes(function(response) {
            $scope.covers = response.data;
        });
        bookService.getGenreTypes(function(response) {
            $scope.genres = response.data;
        });
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

});
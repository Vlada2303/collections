var collectionsApp = angular.module('collectionsApp', [ 'ui.router', 'ui.bootstrap', 'pascalprecht.translate' ]);

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
    })

})

.config(function($translateProvider) {

    $translateProvider.translations('en', {
        "APPLICATION" : "Collections",
        "SIGN_IN" : "Sign in",
        "REGISTER" : "Register",
        "HOME_HEADLINE_ONE": "Log everything at one place",
        "HOME_PARAGRAPH_ONE" : "Books, vinyls and compact disks! From now on make a catalog of all your important stuff at one place and access it anywhere in the world! Easy to use, friendly user interface, secure and responsive deign. All you need!",
        "HOME_HEADLINE_TWO": "This project is dedicated to Jorge Luis Borges",
        "HOME_PARAGRAPH_TWO" : "In 1955, he was nominated to the directorship of National Library of the Argentine Republic. By the late 1950s, he had become completely blind.",
        "HOME_COLUMN_ONE" : "On your smart phone",
        "HOME_COLUMN_TEXT_ONE" : "Collections will soon be available on your smartphone. Our developers are working full time and we expect that beta version will bi out of production next month!",
        "HOME_COLUMN_TWO" : "Plans for the future",
        "HOME_COLUMN_TEXT_TWO" : "We plan to develop solution for general purpose cataloguing project. That meens that not only books, vinyls and compact discs will be available but new categories will be user adable. For exaple cars, guns, swords and etc. Mecca for hoarders! :)",
        "HOME_COLUMN_THREE" : "We are hiring",
        "HOME_COLUMN_TEXT_TREE" : "If you are a web developer with 1+ year(s) of experience in Java, JavaScript, Srping and AngularJS feel free to contact us and we will make an interview appointment as soon as possible.",
        "CONTACT_BUTTON" : "Contact us!",
        "EMAIL" : "Email:",
        "PASSWORD" : "Password:",
        "FIRST_NAME" : "First name:",
        "LAST_NAME" : "Last name:",
        "COUNTRY" : "Country:",
        "CITY" : "City:",
        "AGE" : "Age:",
        "ABOUT" : "About:",
        "EDIT_PROFILE" : "Edit profile",
        "CHANGE_PASSWORD" : "Change password",
        "YEAR_OF_BIRTH" : "Year of birth:",
        "AVATAR_PHOTO" : "Avatar photo:",
        "NEW_PASSWORD" : "New:",
        "CURRENT_PASSWORD" : "Current:",
        "REPEAT_PASSWORD" : "Repeat",
        "SAVE" : "Save",
        "CANCEL" : "Cancel",
        "BOOK_COLLECTION" : "Book collection",
        "HOME_PROFILE" : "Home",
        "LOGOUT" : "Logout",
        "EDIT" : "Edit",
        "ADD_NEW_BOOK" : "Add new book",
        "LANGUAGE" : "Language:",
        "SERIES" : "Series:",
        "EDITION_STATMENT" : "Edition Statement:",
        "ISBN" : "ISBN:",
        "COVER" : "Cover:",
        "TITLE" : "Title:",
        "AUTHOR" : "Author:",
        "YEAR" : "Year:",
        "PUBLISHER" : "Publisher:",
        "CITY_OF_PUBLISHING" : "City of Publishing:",
        "GENRE" : "Genre:",
        "BOOK_COVER_IMAGE" : "Book Cover Image:",
        "LIST_TITLE" : "Title",
        "LIST_AUTHOR" : "Author",
        "LIST_ACTION" : "Action",
        "LIST_ID" : "ID",
        "LIST_YEAR" : "Year",
        "LIST_PUBLISHER" : "Publisher",
        "LIST_CITY_OF_PUBLISHING" : "City of Publishing",
        "LIST_GENRE" : "Genre",
        "LIST_BOOK_COVER_IMAGE" : "Book Cover Image",
        "BOOK_DETAILS" : "Book details",
        "HARDCOVER" : "Hardcover",
        "PAPERBACK" : "Paperback",
        "FICTION" : "Fiction",
        "NONFICTION" : "Non-fiction"
    })

    $translateProvider.useStaticFilesLoader({
        prefix : 'locale-',
        suffix : '.json'
    })
    $translateProvider.preferredLanguage('en');
});
var app = angular.module('jobRegistrator', ['ngRoute', 'ngResource']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'pages/home.html',
            controller: 'homeController'
        })
        .when('/report', {
            templateUrl: 'pages/report.html',
            controller: 'reportController'
        });

});
app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
}]);

app.controller('homeController', ['$scope', '$resource', '$http', function ($scope, $resource, $http) {
    $scope.createWorker = function () {
        var data = 'first_name=' + $scope.firstName + '&last_name=' + $scope.lastName;
        $http.post('/workers', data)
            .success(function (data, status, headers, config) {

            })
            .error(function (data, status, headers, config) {
            });
    };
}]);

app.controller('reportController', ['$scope', '$resource', function ($scope, $resource) {
    $scope.report = $resource("/report");
    $scope.reportResult = $scope.report.get();
    $scope.covertMillisToHours = function (millis) {
        return millis / ( 60 * 60);
    }
}]);

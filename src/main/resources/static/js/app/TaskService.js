(function () {
    'use strict';

    angular.module('buzz').factory('TaskService',
        ["$http", function ($http) {
            var service = {};

            service.getTaskById = function (taskId) {
                var url = "/task/findById/" + taskId;
                return $http.get(url);
            }

            service.getAllTasks = function () {
                return $http.get("/task/findAll");
            }

            service.saveTask = function (task) {
                return $http.post("/task/create", task);
            }

            service.getTitles = function() {
                return $http.get("/titles");
            }

            return service;
        }])
})();

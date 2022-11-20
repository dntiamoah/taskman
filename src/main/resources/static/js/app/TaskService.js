(function () {
    'use strict';

    angular.module('buzz').factory('TaskService',
        ["$http", function ($http) {
            var service = {};

            service.getTaskById = function (taskId) {
                var url = "/tasks/findById/" + taskId;
                return $http.get(url);
            }

            service.getAllTasks = function () {
                return $http.get("/tasks/findAll");
            }

            service.saveTask = function (task) {
                return $http.post("/tasks/create", task);
            }

            service.getTitles = function() {
                return $http.get("/titles");
            }

            service.getAllOrderBy = function(sortByDir) {
                return $http.get("/tasks/findAllOrderBy/" + sortByDir);
            }

            return service;
        }])
})();

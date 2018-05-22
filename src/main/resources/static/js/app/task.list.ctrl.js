(function () {
    'use strict';

    angular.module('buzz')
        .controller('ListController', ['$scope', '$state', '$stateParams', 'TaskService',
            function ($scope, $state, $stateParams, TaskService) {

                $scope.task;
                $scope.errorMessage = null;
                $scope.allTasks = null;
                $scope.sortBy;

                TaskService.getAllTasks().then(function (tasks) {
                    $scope.allTasks = tasks.data;
                }, function (error) {
                    $scope.errorMessage = error;
                });


                $scope.addTask = function () {
                    $state.go('addTask');
                };

                $scope.editTask = function (task) {
                    $state.go('editTask', {taskId: task.id})
                };

                $scope.orderTasks = function () {
                    TaskService.getAllOrderBy($scope.sortBy).then(function (tasks) {
                        $scope.allTasks = tasks.data;
                    }, function (error) {
                        $scope.errorMessage = error;
                    })
                }
            }]
        )
})();
(function () {
    'use strict';

    angular.module('buzz').controller('AddController', ['$scope', '$state', 'TaskService',
        function ($scope, $state, TaskService) {

            var taskCtrl = this;
            taskCtrl.cancelAction = cancelAction;
            taskCtrl.saveTask = saveTask;

            taskCtrl.errorMessage;
            taskCtrl.action = "New";
            taskCtrl.task = {};
            taskCtrl.titles;

            function cancelAction() {
                listTasks();
            }

            function saveTask(task) {
                TaskService.saveTask(task)
                    .then(
                        function () {
                            listTasks();
                        }, function (error) {
                            taskCtrl.errorMessage = error;
                        }
                    );
            }

            function listTasks() {
                $state.go('task');
            }
        }])
})();

(function () {
    'use strict';

    angular.module('buzz').controller('EditController', ['$scope', '$state', '$stateParams', 'TaskService',
        function ($scope, $state, $stateParams, TaskService) {
        var taskCtrl = this;
        taskCtrl.cancelAction = cancelAction;
        taskCtrl.saveTask = saveTask;

        taskCtrl.action = "Edit";
        taskCtrl.taskId = $stateParams.taskId;
        taskCtrl.task = {};
        taskCtrl.errorMessage;
        taskCtrl.addresss = [];


        // find the task to edit
        TaskService.getTaskById(taskCtrl.taskId)
            .then(
                function (task) {
                    taskCtrl.task = task.data;
                    if (task.scheduleDate) {
                        taskCtrl.task.scheduleDate = new Date(task.scheduleDate);
                    }
                },
                function (error) {
                    taskCtrl.errorMessage = error;
                }
            );


        function cancelAction() {
            listTasks();
        }

        function saveTask(task) {
            TaskService.saveTask(task)
                .then(
                    function () {
                        listTasks();
                    },
                    function (error) {
                        taskCtrl.errorMessage = error;
                    }
                );
        }

        function listTasks() {
            $state.go('task');
        }
    }])
})();

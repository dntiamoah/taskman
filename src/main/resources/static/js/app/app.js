angular.module('buzz', ['ui.router', 'ui.bootstrap'])
    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/task');

        $stateProvider

            .state('task', {
                url: '/task',
                templateUrl: '/views/tasklist.html',
                controller: 'ListController'
            })

            .state('addTask', {
                url: '/task/new',
                templateUrl: '/views/taskedit.html',
                controller: 'AddController as taskCtrl',
                params: {
                    task: {},
                    address: {}
                }
            })

            .state('editTask', {
                url: '/task/edit/:taskId',
                templateUrl: '/views/taskedit.html',
                controller: 'EditController as taskCtrl',
            })

    });

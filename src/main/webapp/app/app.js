var containerCatalogMgmtApp = angular.module('ContainerCatalogMgmtApp', ['patternfly.navigation', 'ui.router', "ContainerCatalogMgmtApp.ContainerProduct", "ContainerCatalogMgmtApp.ContainerRepository"]);
containerCatalogMgmtApp.config(function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('home');

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/home.html'
            })
            .state('products', {
                url: '/products',
                templateUrl: 'partials/container-products.html',
                controller: 'ContainerProductCtrl'
            })
            .state('repositories', {
                url: '/repositories',
                templateUrl: 'partials/container-repositories.html',
                controller: 'ContainerRepositoryCtrl'
            })
            .state('repository-edit', {
                url: '/repository/:id',
                templateUrl: 'partials/container-repository-edit.html',
                controller: 'ContainerRepositoryCtrl'
            })
    })
    .controller('vertNavWithRouterController', ['$scope',
        function($scope) {
            $scope.navigationItems = [
                {
                    title: "Container Products",
                    iconClass: "fa fa-product-hunt",
                    uiSref: "products",
                    uiSrefOptions: { }
                },
                {
                    title: "Container Repositories",
                    iconClass: "fa fa-archive",
                    uiSref: "repositories"
                }
            ];
            $scope.handleNavigateClickRouter = function(item) {

            };
        }
    ]);

containerCatalogMgmtApp.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);
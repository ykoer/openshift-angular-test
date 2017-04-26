var containerRepository = angular.module("ContainerCatalogMgmtApp.ContainerRepository", ['ui.grid', 'ui.grid.pagination','ContainerCatalogMgmtApp.services']);

containerRepository.controller('ContainerRepositoryCtrl', ['$scope', '$http', '$state', 'RepositoryListService', function($scope, $http, $state, RepositoryListService) {
    var today = new Date();
    $scope.gridOptions = {
        enableFiltering: false, // column-based filtering
        enablePaginationControls: true,
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
            $scope.gridApi.grid.registerRowsProcessor($scope.singleFilter, 200);
        },

        paginationPageSizes: [10, 20, 50],
        paginationPageSize: 20,
        enableHorizontalScrollbar: 0, // NEVER
        columnDefs: [
            {
                name: 'Registry',
                field: 'registry',
                width: 250,
                enableFiltering: true,
                enableHiding: false
            },
            {
                name: 'Repository',
                field: 'repository',
                enableFiltering: true,
                enableHiding: false
            },
            {
                name: '',
                field:"edit",
                width: 120,
                enableSorting: false,
                enableHiding: false,
                cellTemplate: "templates/edit-template.html"
            }
        ]
    };

    RepositoryListService.get(function(data) {
        $scope.gridOptions.data = data.processed;
    });

    $scope.onclickEdit = function(row) {

        $state.go('repository-edit',{id: row._id});
    };

    $scope.filter = function() {
        $scope.gridApi.grid.refresh();
    };

    $scope.singleFilter = function(renderableRows) {

        var matcher = new RegExp($scope.filterValue, "i");
        renderableRows.forEach(function(row) {
            var match = false;
            ['registry','repository'].forEach(function(field) {
                if (row.entity[field] && row.entity[field].match(matcher)) {
                    match = true;
                }
            });

            if (!match) {
                row.visible = false;
            }
        });
        return renderableRows;

    };


}]);
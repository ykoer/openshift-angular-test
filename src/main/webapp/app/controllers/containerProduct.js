var containerProduct = angular.module("ContainerCatalogMgmtApp.ContainerProduct", ['ui.grid', 'ui.grid.pagination','ContainerCatalogMgmtApp.services']);

containerProduct.controller('ContainerProductCtrl', ['$scope', '$http', 'ProductListService', function($scope, $http, ProductListService) {
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
        columnDefs: [{
                name: 'Product Name',
                field: 'name',
                width: 300,
                enableFiltering: true
            },
            {
                name: 'Description',
                field: 'short_description',
                enableFiltering: true
            }
        ]
    };

    ProductListService.get(function(data) {
        $scope.gridOptions.data = data.processed;
    });

    $scope.buttonClick = function(value) {
        alert('ID: ' + value);
    };

    $scope.filter = function() {
        $scope.gridApi.grid.refresh();
    };

    $scope.singleFilter = function(renderableRows) {

        var matcher = new RegExp($scope.filterValue, "i");
        renderableRows.forEach(function(row) {
            var match = false;
            ['name','short_description'].forEach(function(field) {
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
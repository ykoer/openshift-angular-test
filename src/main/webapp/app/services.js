'use strict';

angular.module('ContainerCatalogMgmtApp.services', ['ngResource'])
    .factory('FormService', ['$resource', function($resource) {
        return $resource('rest/form/:resourceType', {}, {
            get: {
                method: 'GET',
                isArray: true
            }
        });
    }])

    .factory('ProductListService', ['$resource', function($resource) {
        return $resource('rest/products?page=:page', {}, {
            get: {
                method: 'GET',
                isArray: false
            }
        });
    }])

    .factory('RepositoryListService', ['$resource', function($resource) {
            return $resource('rest/repositories?page=:page', {}, {
                get: {
                    method: 'GET',
                    isArray: false
                }
            });
        }]);
let host = "https://polyjava6-4528b-default-rtdb.firebaseio.com";
const app = angular.module("myApp", []);

app.controller("myController", function ($scope, $http) {
    $scope.form = {}
    $scope.items = {}
    $scope.reset = function () {
        $scope.form = {gender: "true",contry: "Vn" }
        $scope.key = null;
        $scope.load_all();
    }
    $scope.load_all = function () {
        var url = `${host}/student.json`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("sucsess", resp);
        }).catch(error => {
            console.log("error", error);
        });
    }

    $scope.edit = function (key) {
        var url = `${host}/student/${key}.json`;
        $http.get(url).then(resp=>{
            $scope.form = resp.data;
            $scope.key = key;
            console.log("sus",resp.data);
        }).catch(error =>{
            console.log("err",error);
        });
    }
    $scope.create = function(){
        var url = `${host}/student.json`;
        var student = angular.copy($scope.form);
        $http.post(url,student).then(resp=>{
            $scope.reset();
        });
    }

    $scope.update = function(){
        var url = `${host}/student/${$scope.key}.json`
        var item = angular.copy($scope.form);
        $http.put(url,item).then(resp=>{
            $scope.items[$scope.key] = resp.data;
            $scope.reset();
        }).catch(error=>{
            console.log("srr",error);
        });
    }
    $scope.delete = function(key){
        var url = `${host}/student/${key}.json`
        $http.delete(url).then(resp=>{
            $scope.items[key].delete;
            $scope.reset();
        });
    }

    $scope.load_all();
    $scope.reset();
})

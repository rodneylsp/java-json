/**
 * 
 */

angular.module("agendaApp", []);
angular.module("agendaApp").controller("agendaController", function ($scope){
	
	$scope.contato = {nome:"Rodney", telefone:"9986-8441"}
	
	$scope.contatos = [
	                   {nome:"Joao", telefone:"9999-6666"},
	                   {nome:"Maria", telefone:"9999-8888"},
	                   {nome:"Ana", telefone:"9999-2222"}
	];
	
	
	
});
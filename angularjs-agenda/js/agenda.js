/**
 *
 */

angular.module("agendaApp", ["ngMessages"]);
angular.module("agendaApp").controller("agendaController", function ($scope){

	$scope.contato = undefined;

	$scope.contatos = [
   {nome:"Joao", telefone:"9999-6666", cor:"yellow"},
   {nome:"Maria", telefone:"9999-8888", cor:"blue"},
   {nome:"Ana", telefone:"9999-2222", cor:"red"}
	];

	$scope.operadoras = [
		{nome: "Oi", codigo:31, categoria: "Celular"},
		{nome: "Vivo", codigo:14, categoria: "Celular"},
		{nome: "Tim", codigo:21, categoria: "Fixo"}
	];

	$scope.classe1 = "selecionado";
	$scope.classe2 = "negrito";

	$scope.adicionarContato = function(contato){
		$scope.contatos.push(angular.copy(contato));
		delete $scope.contato;
		$scope.contatoForm.$setPristine();
	};

	$scope.apagarContato = function(contatos){
		$scope.contatos = contatos.filter(function (contato){
			if(!contato.selecionado) return contato;
		});
	};

	$scope.isContatoSelecionado = function(contatos) {
		return contatos.some(function (contato){
			return contato.selecionado;
		});
	};


});

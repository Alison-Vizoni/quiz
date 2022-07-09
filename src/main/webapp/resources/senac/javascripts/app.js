$(function () {
    $('.js-toggle').bind('click', function (event) {
        $('.js-sidebar, .js-content').toggleClass('is-toggled');
        event.preventDefault();
    });
});

function openModal(quiz) {
    console.log(quiz);
}


//window.onload = function () {
//    var responde = document.getElementById("card_responde");
//    var explora = document.getElementById("card_explora");
//    var cadQuestao = document.getElementById("card_cad_questao");
//    var cadQuiz = document.getElementById("card_cad_quiz");
//
//    el.onclick = sayHello;
//}
//
//function sayHello() {
//    alert("Hello");
//}

function respondeQuiz() {
	window.location.href = "http://localhost:8080/quiz/logado/inicioResponderQuiz.xhtml";
//	window.location.href = "http://localhost:8080/quiz/logado/inicioResponderQuiz.xhtml?jftfdi=&jffi=logado%2FinicioResponderQuiz.xhtml";
}
function explraConteudo() {
	window.location.href = "http://localhost:8080/quiz/exploraConteudo.xhtml";
//	window.location.href = "http://localhost:8080/quiz/exploraConteudo.xhtml?jftfdi=&jffi=exploraConteudo";
}
function cadastraQuestao() {
	window.location.href = "http://localhost:8080/quiz/logado/cadastroQuestao.xhtml";
//	window.location.href = "http://localhost:8080/quiz/logado/cadastroQuestoesSinglePage.xhtml?jftfdi=&jffi=logado%2FcadastroQuestoesSinglePage";
}
function cadastraQuiz() {
	window.location.href = "http://localhost:8080/quiz/logado/cadastroQuiz.xhtml";
//	window.location.href = "http://localhost:8080/quiz/logado/pesquisaQuestoes.xhtml?jftfdi=&jffi=logado%2FpesquisaQuestoes";
}



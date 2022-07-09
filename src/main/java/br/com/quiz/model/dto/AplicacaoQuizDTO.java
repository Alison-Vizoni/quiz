package br.com.quiz.model.dto;

import java.util.Date;

public class AplicacaoQuizDTO {
	
	private Long idAplicacaoQuiz;
	private String tituloQuiz;
	private Date dataAplicacao;
	private Integer quantidadeTotalDePessoas;
	private Integer quantidadeDePessoasQueResponderam;
	
	public AplicacaoQuizDTO(Long idAplicacaoQuiz, String tituloQuiz, Date dataAplicacao,
			Integer quantidadeTotalDePessoas, Integer quantidadeDePessoasQueResponderam) {
		super();
		this.idAplicacaoQuiz = idAplicacaoQuiz;
		this.tituloQuiz = tituloQuiz;
		this.dataAplicacao = dataAplicacao;
		this.quantidadeTotalDePessoas = quantidadeTotalDePessoas;
		this.quantidadeDePessoasQueResponderam = quantidadeDePessoasQueResponderam;
	}

	public AplicacaoQuizDTO() {
		super();
	}

	public Long getIdAplicacaoQuiz() {
		return idAplicacaoQuiz;
	}

	public void setIdAplicacaoQuiz(Long idAplicacaoQuiz) {
		this.idAplicacaoQuiz = idAplicacaoQuiz;
	}

	public String getTituloQuiz() {
		return tituloQuiz;
	}

	public void setTituloQuiz(String tituloQuiz) {
		this.tituloQuiz = tituloQuiz;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public Integer getQuantidadeTotalDePessoas() {
		return quantidadeTotalDePessoas;
	}

	public void setQuantidadeTotalDePessoas(Integer quantidadeTotalDePessoas) {
		this.quantidadeTotalDePessoas = quantidadeTotalDePessoas;
	}

	public Integer getQuantidadeDePessoasQueResponderam() {
		return quantidadeDePessoasQueResponderam;
	}

	public void setQuantidadeDePessoasQueResponderam(Integer quantidadeDePessoasQueResponderam) {
		this.quantidadeDePessoasQueResponderam = quantidadeDePessoasQueResponderam;
	}
	
}

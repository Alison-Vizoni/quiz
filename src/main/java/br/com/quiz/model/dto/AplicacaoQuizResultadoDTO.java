package br.com.quiz.model.dto;

public class AplicacaoQuizResultadoDTO {
	
	private String nomeUsuario;
	private String emailUsuario;
	private Integer quantidadeTotalDeAcertos;
	private Integer totalDePerguntas;
	
	public AplicacaoQuizResultadoDTO(String nomeUsuario, String emailUsuario, Integer quantidadeTotalDeAcertos, Integer totalDePerguntas) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.quantidadeTotalDeAcertos = quantidadeTotalDeAcertos;
		this.totalDePerguntas = totalDePerguntas;
	}

	public AplicacaoQuizResultadoDTO() {
		super();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Integer getQuantidadeTotalDeAcertos() {
		return quantidadeTotalDeAcertos;
	}

	public void setQuantidadeTotalDeAcertos(Integer quantidadeTotalDeAcertos) {
		this.quantidadeTotalDeAcertos = quantidadeTotalDeAcertos;
	}

	public Integer getTotalDePerguntas() {
		return totalDePerguntas;
	}

	public void setTotalDePerguntas(Integer totalDePerguntas) {
		this.totalDePerguntas = totalDePerguntas;
	}

}

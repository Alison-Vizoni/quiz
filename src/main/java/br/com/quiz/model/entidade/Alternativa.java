/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.entidade;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "alternativa")
public class Alternativa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "Text", nullable = false)
	private String texto;

	@Column(name = "status_correta")
	private boolean statusCorreta;

	@Column(name = "status_ativo")
	private Boolean statusAtivo = true;

	@ManyToOne
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;

	@OneToMany(mappedBy = "alternativa", cascade = CascadeType.ALL)
	private Set<AplicacaoQuizResultado> aplicacaoQuizResultado;

	public Alternativa() {
	}

	public Alternativa(String texto, boolean statusCorreta) {
		this.texto = texto;
		this.statusCorreta = statusCorreta;
	}

	public Alternativa(String texto, boolean statusCorreta, Boolean statusAtivo) {
		super();
		this.texto = texto;
		this.statusCorreta = statusCorreta;
		this.statusAtivo = statusAtivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isStatusCorreta() {
		return statusCorreta;
	}

	public void setStatusCorreta(boolean statusCorreta) {
		this.statusCorreta = statusCorreta;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Set<AplicacaoQuizResultado> getAplicacaoQuizResultado() {
		return aplicacaoQuizResultado;
	}

	public void setAplicacaoQuizResultado(Set<AplicacaoQuizResultado> aplicacaoQuizResultado) {
		this.aplicacaoQuizResultado = aplicacaoQuizResultado;
	}

	public Boolean getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(Boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Alternativa)) {
			return false;
		}
		Alternativa other = (Alternativa) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.quiz.entidade.Alternativa[ id=" + id + " ]";
	}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.entidade;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "alternativa")
public class Alternativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String texto;
    
    @Column(name = "status_correta")
    private boolean statusCorreta;

    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;
    
    @OneToMany(mappedBy = "id.alternativa")
    private Set<AplicacaoQuiz> aplicacaoQuiz;
    
    public Alternativa() {
    }

    public Alternativa(String texto, boolean statusCorreta) {
        this.texto = texto;
        this.statusCorreta = statusCorreta;
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

    public Set<AplicacaoQuiz> getAplicacaoQuiz() {
        return aplicacaoQuiz;
    }

    public void setAplicacaoQuiz(Set<AplicacaoQuiz> aplicacaoQuiz) {
        this.aplicacaoQuiz = aplicacaoQuiz;
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

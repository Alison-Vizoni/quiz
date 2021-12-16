/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author alison
 */
@Embeddable
public class AplicacaoQuizResultadoPK implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_alternativa")
    private Alternativa alternativa;
    
    @ManyToOne
    @JoinColumn(name = "id_aplicacao_quiz")
    private AplicacaoQuiz aplicacaoQuiz;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public AplicacaoQuiz getAplicacaoQuiz() {
        return aplicacaoQuiz;
    }

    public void setAplicacaoQuiz(AplicacaoQuiz aplicacaoQuiz) {
        this.aplicacaoQuiz = aplicacaoQuiz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alternativa, usuario, aplicacaoQuiz);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AplicacaoQuizResultadoPK that = (AplicacaoQuizResultadoPK) obj;
        return Objects.equals(this.aplicacaoQuiz, that.aplicacaoQuiz) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(alternativa, that.alternativa);
    }
}

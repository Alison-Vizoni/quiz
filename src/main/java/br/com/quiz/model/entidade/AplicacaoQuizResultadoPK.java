/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 * https://www.baeldung.com/jpa-many-to-many
 * @author alison
 */
@Embeddable
public class AplicacaoQuizResultadoPK implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
    
    @Column(name = "id_alternativa", nullable = false)
    private Long idAlternativa;
    
    @Column(name = "id_aplicacao_quiz", nullable = false)
    private Long idAplicacaoQuiz;

    public AplicacaoQuizResultadoPK() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdAlternativa() {
        return idAlternativa;
    }

    public void setIdAlternativa(Long idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public Long getIdAplicacaoQuiz() {
        return idAplicacaoQuiz;
    }

    public void setIdAplicacaoQuiz(Long idAplicacaoQuiz) {
        this.idAplicacaoQuiz = idAplicacaoQuiz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlternativa, idUsuario, idAplicacaoQuiz);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AplicacaoQuizResultadoPK that = (AplicacaoQuizResultadoPK) obj;
        return Objects.equals(this.idAplicacaoQuiz, that.idAplicacaoQuiz) &&
                Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idAlternativa, that.idAlternativa);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "aplicacao_quiz_resultado")
public class AplicacaoQuizResultado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private AplicacaoQuizResultadoPK id;
    
    @Column(name = "data_resolucao")
    @Temporal(TemporalType.DATE)
    private Date dataResolucao;
    
    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @MapsId("idAlternativa")
    @JoinColumn(name = "id_alternativa")
    private Alternativa alternativa;
    
    @ManyToOne
    @MapsId("idAplicacaoQuiz")
    @JoinColumn(name = "id_aplicacao_quiz")
    private AplicacaoQuiz aplicacaoQuiz;

    public AplicacaoQuizResultado() {
    }

    public AplicacaoQuizResultado(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }
    
    public AplicacaoQuizResultadoPK getId() {
        return id;
    }

    public void setId(AplicacaoQuizResultadoPK id) {
        this.id = id;
    }

    public Date getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

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
}

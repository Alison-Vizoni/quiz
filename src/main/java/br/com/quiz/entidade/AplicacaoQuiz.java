/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "aplicacao_quiz")
public class AplicacaoQuiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_aplicacao")
    private Date dataAplicacao;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;
    
    @OneToMany(mappedBy = "id.aplicacaoQuiz")
    private Set<QuizResultado> quizResultado;

    public AplicacaoQuiz() {
    }

    public AplicacaoQuiz(Date dataAplicacao, String descricao) {
        this.dataAplicacao = dataAplicacao;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<QuizResultado> getQuizResultado() {
        return quizResultado;
    }

    public void setQuizResultado(Set<QuizResultado> quizResultado) {
        this.quizResultado = quizResultado;
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
        if (!(object instanceof AplicacaoQuiz)) {
            return false;
        }
        AplicacaoQuiz other = (AplicacaoQuiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.quiz.entidade.AplicacaoQuiz[ id=" + id + " ]";
    }

}

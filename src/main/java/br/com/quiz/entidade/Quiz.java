/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String categoria;
    private String assunto;
    
    @Column(name = "visibilidade_privada")
    private boolean visibilidadePrivada;
    
    @Column(name = "data_criacao")
    private Date dataCriacao;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_proprietario")
    private Usuario usuarioProprietario;
    
    @OneToMany(mappedBy = "quiz")
    private Set<AplicacaoQuiz> quizzesAplicados;
    
    @OneToMany(mappedBy = "id.quiz")
    private Set<QuizResultado> quizResultado;

    public Quiz() {
    }

    public Quiz(String categoria, String assunto, boolean visibilidadePrivada, Date dataCriacao) {
        this.categoria = categoria;
        this.assunto = assunto;
        this.visibilidadePrivada = visibilidadePrivada;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public boolean isVisibilidadePrivada() {
        return visibilidadePrivada;
    }

    public void setVisibilidadePrivada(boolean visibilidadePrivada) {
        this.visibilidadePrivada = visibilidadePrivada;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuarioProprietario() {
        return usuarioProprietario;
    }

    public void setUsuarioProprietario(Usuario usuarioProprietario) {
        this.usuarioProprietario = usuarioProprietario;
    }

    public Set<AplicacaoQuiz> getQuizzesAplicados() {
        return quizzesAplicados;
    }

    public void setQuizzesAplicados(Set<AplicacaoQuiz> quizzesAplicados) {
        this.quizzesAplicados = quizzesAplicados;
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
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.quiz.entidade.Quiz[ id=" + id + " ]";
    }
    
}

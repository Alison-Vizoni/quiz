
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    
    @Column(name = "visibilidade_privada")
    private boolean visibilidadePrivada;
    
    @Column(name = "data_criacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_proprietario")
    private Usuario usuarioProprietario;
    
    @OneToMany(mappedBy = "quiz")
    private Set<AplicacaoQuiz> quizzesAplicados;
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "quiz_pergunta",
        joinColumns = @JoinColumn(name = "id_quiz"),
        inverseJoinColumns = @JoinColumn(name = "id_pergunta"))
    private List<Pergunta> perguntas;
    
    @ManyToMany(mappedBy = "quizzes", cascade = CascadeType.PERSIST)
    private Set<Categoria> categorias;
    
    public Quiz() {
    }

    public Quiz(String titulo, boolean visibilidadePrivada, Date dataCriacao) {
        this.titulo = titulo;
        this.visibilidadePrivada = visibilidadePrivada;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
    
    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
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

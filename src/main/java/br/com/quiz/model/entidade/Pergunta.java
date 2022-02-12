/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "pergunta")
public class Pergunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String assunto;
    private String texto;
    
    @Column(name = "visibilidade_privada")
    private boolean visibilidadePrivada;
    
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_proprietario")
    private Usuario usuarioProprietario;
    
    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Alternativa> alternativas;
    
    @ManyToMany
    @JoinColumn(name = "id_quiz")
    private List<Quiz> quiz;
    
    public Pergunta() {
    }

    public Pergunta(String assunto, String texto, boolean visibilidadePrivada, Date dataCriacao) {
        this.assunto = assunto;
        this.texto = texto;
        this.visibilidadePrivada = visibilidadePrivada;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuarioProprietario() {
        return usuarioProprietario;
    }

    public void setUsuarioProprietario(Usuario usuarioProprietario) {
        this.usuarioProprietario = usuarioProprietario;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
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
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.quiz.entidade.Pergunta[ id=" + id + " ]";
    }
    
}

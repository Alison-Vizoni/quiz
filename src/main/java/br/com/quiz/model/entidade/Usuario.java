/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author alison
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
    @OneToMany(mappedBy = "usuarioProprietario")
    private List<Pergunta> pergunta;
    
    @OneToMany(mappedBy = "usuarioProprietario")
    private List<Quiz> quizzes;
    
    @OneToMany(mappedBy = "usuarioAplicador")
    private Set<AplicacaoQuiz> aplicacoesQuizzes;
    
    @OneToOne(mappedBy = "usuario")
    private Login login;
    
    @OneToMany(mappedBy = "usuario")
    private Set<AplicacaoQuizResultado> quizResultados;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pergunta> getPergunta() {
        return pergunta;
    }

    public void setPergunta(List<Pergunta> pergunta) {
        this.pergunta = pergunta;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Set<AplicacaoQuiz> getAplicacoesQuizzes() {
        return aplicacoesQuizzes;
    }

    public void setAplicacoesQuizzes(Set<AplicacaoQuiz> aplicacoesQuizzes) {
        this.aplicacoesQuizzes = aplicacoesQuizzes;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Set<AplicacaoQuizResultado> getQuizResultados() {
        return quizResultados;
    }

    public void setQuizResultados(Set<AplicacaoQuizResultado> quizResultados) {
        this.quizResultados = quizResultados;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.quiz.entidade.Usuario[ id=" + id + " ]";
    }
    
}

package br.com.quiz.controle;

import br.com.quiz.model.bo.AplicacaoQuizBO;
import br.com.quiz.model.dao.AplicacaoQuizDaoImpl;
import br.com.quiz.model.dao.AplicacaoQuizResultadoDao;
import br.com.quiz.model.dao.AplicacaoQuizResultadoDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import java.io.IOException;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "aplicacaoQuizResultadoC")
@ViewScoped
public class AplicacaoQuizResultadoController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Logger logger = LoggerFactory.logger(getClass());
    private AplicacaoQuizDaoImpl AplicacaoQuizDao;
    private AplicacaoQuizResultado aplicacaoQuizResultado;
    private AplicacaoQuizResultadoDao aplicacaoQuizResultadoDao;
    private AplicacaoQuiz aplicacaoQuiz;
    private List<AplicacaoQuizResultado> resultados;
    private Session sessao;
    private Quiz quiz;

    public AplicacaoQuizResultadoController() {
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
    }

    public void pesquisaAplicacaoQuizPorUsuario() {
        sessao = HibernateUtil.abrirSessao();
        resultados = removeQuizDuplicado(aplicacaoQuizResultadoDao.pesquisarPorIdUsuario(LoginController.usuarioSessao().getId(), sessao));
        sessao.close();
    }

    public List<AplicacaoQuizResultado> removeQuizDuplicado(List<AplicacaoQuizResultado> listaQuizUsuario) {
        List<AplicacaoQuizResultado> noDuplicates = new ArrayList<>();
        List idDuplicates = new ArrayList<>();
        List<AplicacaoQuizResultado> listaVerifcada = listaQuizUsuario;
        for (int i = 0; i < listaQuizUsuario.size(); i++) {
            if (!idDuplicates.contains(listaQuizUsuario.get(i).getAplicacaoQuiz().getQuiz().getId())) {
                idDuplicates.add(listaQuizUsuario.get(i).getAplicacaoQuiz().getQuiz().getId());
                noDuplicates.add(listaQuizUsuario.get(i));
            }
        }
        return noDuplicates;
    }

    public AplicacaoQuizResultado getAplicacaoQuizResultado() {
        return aplicacaoQuizResultado;
    }

    public void setAplicacaoQuizResultado(AplicacaoQuizResultado aplicacaoQuizResultado) {
        this.aplicacaoQuizResultado = aplicacaoQuizResultado;
    }

    public AplicacaoQuiz getAplicacaoQuiz() {
        return aplicacaoQuiz;
    }

    public void setAplicacaoQuiz(AplicacaoQuiz aplicacaoQuiz) {
        this.aplicacaoQuiz = aplicacaoQuiz;
    }

    public List<AplicacaoQuizResultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<AplicacaoQuizResultado> resultados) {
        this.resultados = resultados;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

}

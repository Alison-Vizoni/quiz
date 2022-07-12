package br.com.quiz.controle;

import br.com.quiz.model.bo.AplicacaoQuizBO;
import br.com.quiz.model.dao.AplicacaoQuizDaoImpl;
import br.com.quiz.model.dao.AplicacaoQuizResultadoDao;
import br.com.quiz.model.dao.AplicacaoQuizResultadoDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dto.AplicacaoQuizResultadoDTO;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import br.com.quiz.model.entidade.Usuario;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
    private List<AplicacaoQuizResultado> resultadosModal;
    private Session sessao;
    private Quiz quiz;
    
    private Set<AplicacaoQuizResultadoDTO> aplicacaoQuizResultadoDTO;

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
        converterParaAplicacaoQuizResultadoDTO(listaQuizUsuario);

        return noDuplicates;
    }
    
    private void converterParaAplicacaoQuizResultadoDTO(List<AplicacaoQuizResultado> aplicacoesRespondidas) {
    	aplicacaoQuizResultadoDTO = new HashSet<AplicacaoQuizResultadoDTO>();
    	Set<Usuario> usuarios = new HashSet<>();
    	for (AplicacaoQuizResultado usuariosDuplicados : aplicacoesRespondidas) {
			usuarios.add(usuariosDuplicados.getUsuario());
		}
    	
    	for (Usuario usuario : usuarios) {
    		Integer quantidadeTotalDeAcertos = 0;
    		for (AplicacaoQuizResultado respostas : aplicacoesRespondidas) {
    			if (respostas.getUsuario().getId() == usuario.getId() &&
    					respostas.getAlternativa().isStatusCorreta()) {
    				quantidadeTotalDeAcertos++;
    			}
    		}
    		AplicacaoQuizResultadoDTO resultadosDto = new AplicacaoQuizResultadoDTO();
    		if(!aplicacoesRespondidas.isEmpty()) {
    			resultadosDto.setNomeUsuario(usuario.getNome());
    			resultadosDto.setEmailUsuario(usuario.getEmail());
    			resultadosDto.setQuantidadeTotalDeAcertos(quantidadeTotalDeAcertos);
    			resultadosDto.setTotalDePerguntas(aplicacoesRespondidas.get(0).getAplicacaoQuiz().getQuiz().getPerguntas().size());
    		}
    		aplicacaoQuizResultadoDTO.add(resultadosDto);
		}
	}

    public void pesquisaAplicacaoQuizResultadoPorId(Long id) {
 
        sessao = HibernateUtil.abrirSessao();
        resultadosModal = null;
        resultadosModal = removeQuizDuplicado(aplicacaoQuizResultadoDao.pesquisarPorIdAplicacaoQuiz(id, sessao));
        sessao.close();
    }

    public String resultadoFinalUsuario(Long idAplicacao, Long idUsuario) {
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
        sessao = HibernateUtil.abrirSessao();
        List<AplicacaoQuizResultado> aplicacaoQuizResultado = null;
        String resultado = "";
        try {
            aplicacaoQuizResultado = aplicacaoQuizResultadoDao
                    .pesquisarPorId(idAplicacao, idUsuario, sessao);
        } catch (Exception e) {
        } finally {
            sessao.close();
        }

        aplicacaoQuiz = null;
        
        resultado =  formataRespostaFinal(aplicacaoQuizResultado);
        aplicacaoQuizResultado = null;
        return resultado;
    }
    

    public String formataRespostaFinal(List<AplicacaoQuizResultado> aplicacaoQuizResultado) {
        int totalRespostasCorretas = 0;
        for (int i = 0; i < aplicacaoQuizResultado.size(); i++) {
            totalRespostasCorretas += aplicacaoQuizResultado.get(i).getAlternativa().isStatusCorreta() ? 1 : 0;
        }

        return totalRespostasCorretas + "/" + aplicacaoQuizResultado.size();
    }
    
    public String formatarData (Date data) {
        String dateFormat = new SimpleDateFormat("dd-MM-yyyy").format(data);
        return dateFormat;
    }
    
    
    public int totalQuizRespondidos(Long idAplicacaoQuiz) {
        sessao = HibernateUtil.abrirSessao();
        int totalQuizRespondidos = removeQuizDuplicado(aplicacaoQuizResultadoDao.pesquisarPorIdAplicacaoQuiz(idAplicacaoQuiz, sessao)).size();
        sessao.close();
        return totalQuizRespondidos;
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

    public List<AplicacaoQuizResultado> getResultadosModal() {
        return resultadosModal;
    }

    public void setResultadosModal(List<AplicacaoQuizResultado> resultadosModal) {
        this.resultadosModal = resultadosModal;
    }

	public Set<AplicacaoQuizResultadoDTO> getAplicacaoQuizResultadoDTO() {
		if (aplicacaoQuizResultadoDTO == null) {
			aplicacaoQuizResultadoDTO = new HashSet<AplicacaoQuizResultadoDTO>();
		}
		return aplicacaoQuizResultadoDTO;
	}

	public void setAplicacaoQuizResultadoDTO(Set<AplicacaoQuizResultadoDTO> aplicacaoQuizResultadoDTO) {
		this.aplicacaoQuizResultadoDTO = aplicacaoQuizResultadoDTO;
	}
    

}

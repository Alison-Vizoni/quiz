/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Login;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import br.com.quiz.model.entidade.Usuario;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author alison.vizoni
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Categoria.class);
            cfg.addAnnotatedClass(Pergunta.class);
            cfg.addAnnotatedClass(Alternativa.class);
            cfg.addAnnotatedClass(Quiz.class);
            cfg.addAnnotatedClass(AplicacaoQuiz.class);
            cfg.addAnnotatedClass(AplicacaoQuizResultado.class);
            cfg.addAnnotatedClass(Usuario.class);
            cfg.addAnnotatedClass(Login.class);

            cfg.configure("/META-INF/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            SESSION_FACTORY = cfg.buildSessionFactory(build.build());

        } catch (Exception e) {
            System.err.println("Erro ao abrir conexão HibernateUtil " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session abrirSessao() {
        return SESSION_FACTORY.openSession();
    }

}

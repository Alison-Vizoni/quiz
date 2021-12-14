/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.dao;

import br.com.quiz.entidade.Categoria;
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

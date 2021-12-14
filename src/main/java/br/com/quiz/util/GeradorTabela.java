/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.util;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alison.vizoni
 */

public class GeradorTabela{
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("quizPU");
        emf.close();
    }
}
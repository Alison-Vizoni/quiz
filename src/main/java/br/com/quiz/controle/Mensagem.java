/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.controle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author alison.vizoni
 */
public class Mensagem {
    
    public static void sucesso(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
    }
    
    public static void erro(String mensagem){
         FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(FacesMessage.SEVERITY_ERROR, "", mensagem));
    }
    
}

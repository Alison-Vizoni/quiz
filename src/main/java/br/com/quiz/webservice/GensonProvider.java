/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.webservice;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author alison.vizoni
 */
@Provider
public class GensonProvider implements ContextResolver<Genson>{
    
    private Genson genson = new GensonBuilder().setSkipNull(true).create();
    
    @Override
    public Genson getContext(Class<?> type) {
        return genson;
    }
    
}

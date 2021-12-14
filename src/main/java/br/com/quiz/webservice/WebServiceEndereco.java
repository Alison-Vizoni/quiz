/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 *
 * @author Silvio
 */
public class WebServiceEndereco {

    private Client client;
    private WebResource webResource;

    public WebServiceEndereco() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        //Utilizado para imprimir as operacoes no console
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://viacep.com.br/ws/");
    }

//    public Endereco pesquisarCep(String cep) {
//        return webResource.path(cep).path("/json").get(Endereco.class);
//    }
//    
//    public static void main(String[] args) {
//        WebServiceEndereco web = new WebServiceEndereco();
//        Endereco end = web.pesquisarCep("99999-999");
//        System.out.println("XXXXXX " + end);
//    }
}

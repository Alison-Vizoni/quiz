/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.util;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author alison.vizoni
 */
public class GeradorUtil {
    
    public static String gerarNome(){
        String[] nomes = {"Alexandre", "Eduardo", "Henrique", "Murilo", "Theo"};
        int indice = (int) (Math.random() * nomes.length);
        return nomes[indice].toString();
    }
    
    public static String gerarNumero(int quantidade){
        
        String numeroAleatorio = "";
        for (int i = 0; i < quantidade; i++) {
            numeroAleatorio += (int) (Math.random() * 10);
        }
        return numeroAleatorio;
    }
    
    private static String formatField(String value, String inputMask) {
        try {
            MaskFormatter mask = new MaskFormatter(inputMask);
            mask.setValueContainsLiteralCharacters(false);
            value = mask.valueToString(value);
        } catch (ParseException ex) {
            System.out.println("Erro ao formatar mascara " + ex.getMessage());
        }
        return value;
    }
    
    public static String gerarCnpj(){
        return formatField(gerarNumero(14), "##.###.###/####-##");
    }
    
    public static String gerarCartaoCredito() {
        return formatField(gerarNumero(12), "####-####-####-####");
    }
    
    public static String gerarCidade() {
        String cidade;
        int indice;
        String[] cidades = {"Florianópolis", "São José", "Palhoça", "São Bento", "Biguaçu", "Curitiba", "Urupema",
            "Tijucas", "Balneário", "Camboriú", "Santo Antônio", "Lapa", "Portal", "Matinhos"};
        indice = (int) (Math.random() * cidades.length);
        cidade = cidades[indice];
        return cidade;
    }
    
    public static String gerarUF() {
        String uf;
        int indice;
        String[] estados = {"RS", "SC", "PR", "SP", "BA", "AC", "ES", "AM", "CE", "GO", "SE", "MT", "TO", "RJ"};
        indice = (int) (Math.random() * estados.length);
        uf = estados[indice];
        return uf;
    }
    
    public static String gerarCaracter(int qtd) {
        String palavra = "";
        int indice;
        String[] caracteres = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " "};

        for (int i = 0; i < qtd; i++) {
            indice = (int) (Math.random() * caracteres.length);
            palavra += caracteres[indice];
        }
        return palavra;
    }
    
    public static String gerarTeleCeluar() {
        return formatField("4899" + gerarNumero(7), "(##)#####-####");
    }
    
    public static String gerarNomeCategoria(){
        String[] nomes = {"CategoriaUtil123", "CategoriaTest45", "CategoriaValendo", "CategoriaNome", "GerarNomeCategoria"};
        int indice = (int) (Math.random() * nomes.length);
        return nomes[indice].toString();
    }
    
    public static String gerarNomeSubCategoria(){
        String[] nomes = {"SubCategoriaUtil123", "SubCategoriaTest45", "SubCategoriaValendo", "SubCategoriaNome", "SubGerarNomeCategoria"};
        int indice = (int) (Math.random() * nomes.length);
        return nomes[indice].toString();
    }
}

package br.com.quiz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Utils {

    /**
     * Método para verificar se uma String não é nula nem vazia
     *
     * @param string Campo a ser verificado
     * @return true se a String for válida
     */
    public static boolean stringValida(String string) {
        boolean retorno = false;
        if (null != string && !string.trim().isEmpty()) {
            retorno = true;
        }
        return retorno;
    }

    public static boolean isTodosElementosIguais(ArrayList lista) {
        return new HashSet<String>(lista).size() == 1;
    }

//	public static boolean dataValida(LocalDate data) {
//		boolean retorno = false;
//		LocalDate dataAtual = LocalDate.now();
//		if (data == null || data.isAfter(dataAtual)) {
//			retorno = true;		
//		}
//		return retorno;		
//	}
//	/**
//	 * Método para verificar se alguma "Alternativa" deixou de ser preenchida pelo usuário
//	 * 
//	 * @param alt1 Primeira alternativa
//	 * @param alt2 Segunda alternativa
//	 * @param alt3 Terceira alternativa
//	 * @param alt4 Quarta alternativa
//	 * @param alt5 Quinta alternativa
//	 * @return false se alguma alternativa tiver o texto do placeholder
//	 */
//	public static boolean alternativaValida(String alt1, String alt2, String alt3, String alt4,String alt5) {
//		boolean retorno = true;
//		
//		if (alt1.equalsIgnoreCase(Constants.ALTERNATIVA_1)
//				|| alt2.equalsIgnoreCase(Constants.ALTERNATIVA_2)
//				|| alt3.equalsIgnoreCase(Constants.ALTERNATIVA_3)
//				|| alt4.equalsIgnoreCase(Constants.ALTERNATIVA_4)
//				|| alt5.equalsIgnoreCase(Constants.ALTERNATIVA_5)) {			
//			retorno = false;			
//		}
//		return retorno;		
//	}
    /**
     *
     * Utiliza os métodos trim() e replaceAll() da classe String para formatar
     * texto
     *
     * @param texto
     * @return String formatada com no máximo 1 espaço entre as palavras e sem
     * espaços em branco no início e no fim do texto.
     */
    public static String formataEspacoUnico(String texto) {

        return texto.replaceAll("\\s+", " ").trim();

    }

}

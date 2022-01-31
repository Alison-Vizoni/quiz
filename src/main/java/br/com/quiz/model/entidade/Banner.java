
package br.com.quiz.model.entidade;

/**
 *
 * @author alf_a
 */
public class Banner {
    
    private String imagem;
    private String titulo;
    private String texto;

    public Banner(String imagem, String titulo, String texto) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Banner() {
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }   
    
}

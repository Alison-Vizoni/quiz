package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "bannerC")
@RequestScoped
public class BannerController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> images;
//    private String banner;

    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            images.add("banner_" + i + ".png");
        }
    }

    public List<String> getImages() {
        return images;
    }
    
//        public List<String> getImages() {
//        return banner;
//    }
    
//    private final static String TEXTO_1 = "Quando terminar de montar seu quiz, é só incluir o email de quem irá responder seu questionário e clicar. Está pronto!";
//    private final static String TEXTO_2 = "Com poucos cliques você você tem acesso ao conteúdo da plataforma e pode explorar nossas ferramentas";
//    private final static String TEXTO_3 = "Aqui você monta seus questionários de forma prática e sem perder tempo";
//    
//    private final static String TITULO_1 = "Mande seu quiz para quem você quiser";
//    private final static String TITULO_2 = "Acesso rápido e simples";
//    private final static String TITULO_3 = "Otimize seu tempo";
//
//    
//    private List<Banner> banners;
//    private Banner banner;
//
//    @PostConstruct
//    public void init() {
//        banners = new ArrayList<>();
//        for (int i = 1; i <= 3; i++) {
//            banner.setImagem("banner_" + i + ".png");
////            String texto = "TEXTO_";
////            banner.setTexto(texto + i);
////            String titulo = "TITULO_";
////            banner.setTexto(titulo + i);
//            
//            banners.add(banner);
//        }
//    }
//

//
//    public List<Banner> getBanners() {
//        return banners;
//    }
//
//    public void setBanners(List<Banner> banners) {
//        this.banners = banners;
//    }
//
//    public Banner getBanner() {
//        if (banner == null) {
//            banner = new Banner();
//        }
//        return banner;
//    }
//
//    public void setBanner(Banner banner) {
//        this.banner = banner;
//    } 
    
}

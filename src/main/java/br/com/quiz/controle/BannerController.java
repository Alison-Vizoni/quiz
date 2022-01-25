package br.com.quiz.controle;

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
public class BannerController {
    
    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("banner_" + i + ".png");
        }
    }

    public List<String> getImages() {
        return images;
    }

}

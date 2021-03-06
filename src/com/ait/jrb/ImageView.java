package com.ait.jrb;

import java.util.ArrayList;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImageView {
	private ArrayList<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("boat" + i + ".jpg");
        }
    }
 
    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
    	this.images =images;
    }
}

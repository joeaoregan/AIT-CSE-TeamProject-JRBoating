package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.ImageView;

class ImageViewTest {
	
	ImageView imageView;

	@BeforeEach
	void setUp() throws Exception {
		imageView = new ImageView();
		imageView.init();
	}
	
	@Test
	void testImages() {
		ArrayList<String> images = new ArrayList<String>();
		imageView.setImages(images);
		assertEquals(images, imageView.getImages());
	}
}

package com.nt;

import java.util.Random;

public class Rotator {
	private String links[]={"http://www.raymonds.com",
			                "http://www.panasonic.com",
			                "http://www.samsung.com",
			                "http://www.nataraz.in",
			                "http://www.nareshit.com"};
	
	private String images[]={"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg"};
	
	public String[] getLinks() {
		return links;
	}
	public void setLinks(String[] links) {
		this.links = links;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	
	int counter=0;
	public void nextAdvertisement(){
		Random rad=new Random();
		counter=rad.nextInt(5); 
	}
	public String getImage(){
		return images[counter];
	}
	public String getLink(){
		return links[counter];
	}
	
}

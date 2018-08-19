
package com.ait.jrb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "boatDetailsBean")
@SessionScoped
public class BoatDetailsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	//private String[] actions = {"DetailsCanalBarge.jsf", "DetailsCanoe.jsf", "DetailsCruiser.jsf", "DetailsSailingBoat.jsf"};
	private String[] actions = {"DetailsCanalBarge", "DetailsCanoe", "DetailsCruiser", "DetailsSailingBoat"};
	private String[] pageName = {"Canal Barge", "Canoe", "Cruiser", "Sailing Boat"};
	private String title;
	private int index;
		
	public BoatDetailsBean() {
		title=pageName[index];
	}
	
	public String pageTitle() {
		return pageName[index];
	}
	
	public String currentBoatDetails() {
		return actions[getIndex()];
	}
	
	public String previousButton() {
		index--;
		
		if (index < 0) {
			index = actions.length-1;
		}

		return "BoatDetails";
		//return null;
	}
	
	public String nextButton() {
		index++;
		
		if (index >= actions.length) {
			index = 0;
		}

		return "BoatDetails";
		//return null;
	}
	/*
	public String previousButton() {
		index--;
		
		if (index < 0) {
			index = actions.length-1;
		}

		return actions[index];
	}
	
	public String nextButton() {
		index++;
		
		if (index >= actions.length) {
			index = 0;
		}

		return actions[index];
	}
*/
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
/*
	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		BoatDetailsBean.index = index;
	}
*/
}

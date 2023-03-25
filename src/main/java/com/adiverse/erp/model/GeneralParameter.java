package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.*;

public class GeneralParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, String> general = new HashMap<String, String>() {
		{
			put("seema", "spmsaa4@gmail.com");
			put("namita", "namita131996@gmail.com");

		}
	};

	public Map<String, String> getGeneral() {
		return general;
	}

	public void setGeneral(Map<String, String> general) {
		this.general = general;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

//Map<String,String> general=new HashMap<>();
//
//public Map<String, String> getGeneral() {
//	return general;
//}
//
//public void setGeneral(Map<String, String> general) {
//	this.general = general;
//}
//
//
//private void data() 
//{
//	
//general.put("seema","spmsaa4@gmail.com");
//general.put("namitha","anamita1996@gmail.com");
//general.put("keerthana","keerthanakr555@gmail.com");
//general.put("soumya","jonnalasrisowmya@gmail.com");
//general.put("sameera","sameera@adiversetech.com");
//}
//
//private String status;
//
//public String getStatus() {
//	return status;
//}
//
//public void setStatus(String status) {
//	this.status = status;
//}
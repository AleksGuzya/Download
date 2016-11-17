package com.bionic.edu.web;

import java.util.logging.Logger;

import org.springframework.web.client.RestTemplate;

import com.bionic.edu.dao.Merchant;

public class ClientApp {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(ClientApp.class.getName());
		
		
	    Merchant merchant = new RestTemplate().
	         getForObject("http://localhost:8080/BionicPracticeREST/merchant/1", Merchant.class);
	        logger.info("===== Merchant Info =====");
	        logger.info("id = " + merchant.getId());
	        logger.severe("name = " + merchant.getName());
	        logger.severe("charge = " + merchant.getCharge());
	    }

}

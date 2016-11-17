package com.bionic.edu.web;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.bionic.edu.dao.Merchant;
import com.bionic.edu.dao.MerchantList;

public class MerchantClient {

	public static void main(String[] args) {
		MerchantList listObj = new RestTemplate()
				.getForObject("http://localhost:8080/BionicPracticeREST/allMerchants", MerchantList.class);
		List<Merchant> list = listObj.getMerchants();
		for (Merchant m : list) {
			System.out.println(m.getName());
		}
	}

}

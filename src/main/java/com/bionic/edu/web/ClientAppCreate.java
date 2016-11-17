package com.bionic.edu.web;

import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bionic.edu.dao.Merchant;
import com.bionic.edu.dao.MerchantList;

public class ClientAppCreate {

	public static void main(String[] args) {
		try {
			Merchant merchant = new Merchant();
			merchant.setAccount("test12345");
			merchant.setBankName("testBank");
			merchant.setCharge(2.1);
			merchant.setMinSum(100.0);
			merchant.setName("AnyMerchant");
			merchant.setPeriod((short) 1);
			merchant.setSwift("testSWIFT");
			String url = "http://localhost:8080/BionicPracticeREST/newMerchant";
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject(url, merchant, Merchant.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		MerchantList listObj = new RestTemplate().getForObject("http://localhost:8080/BionicPracticeREST/allMerchants",
				MerchantList.class);
		List<Merchant> list = listObj.getMerchants();
		for (Merchant m : list) {
			System.out.println(m.getName());
		}
	}

}
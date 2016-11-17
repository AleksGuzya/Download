package com.bionic.edu.dao;

import java.util.ArrayList;
import java.util.List;

public class MerchantList {

	private List<Merchant> merchants;

	public MerchantList() {
		merchants = new ArrayList<Merchant>();
	}
	
	public List<Merchant> getMerchants() {
		return merchants;
	}
	
	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
	}

}

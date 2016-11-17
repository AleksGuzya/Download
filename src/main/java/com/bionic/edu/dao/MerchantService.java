package com.bionic.edu.dao;

import java.util.List;

public interface MerchantService {

	public Merchant findById(int id);
	public List<Merchant> findAll();
	
	public void save(Merchant merchant);
	public void update(Merchant merchant);
	
	public List<SumReport> getSumReport();

}

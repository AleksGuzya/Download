package com.bionic.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {

	@Inject
	private MerchantDao merchantDao;

	public Merchant findById(int id) {
		return merchantDao.findById(id);
	}

	public List<Merchant> findAll() {
		return merchantDao.findAll();
	}

	@Override
	public void save(Merchant merchant) {
		merchantDao.save(merchant);
	}

	@Override
	public void update(Merchant merchant) {
		merchantDao.update(merchant);
	}

	@Override
	public List<SumReport> getSumReport() {
		return merchantDao.getSumReport();
	}

}

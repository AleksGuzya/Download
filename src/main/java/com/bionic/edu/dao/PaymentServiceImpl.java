package com.bionic.edu.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
    @Inject
    private PaymentDao paymentDao;
    
    public List<Payment> findByMerchantId(int id){
    	return paymentDao.findByMerchantId(id);
    }

    public double getPaymentSum(){
    	return paymentDao.getPaymentSum();
    }
    
    public Payment findById(int id){
    	return paymentDao.findById(id);
    }

	@Override
	public List<Payment> getAll() {
		return paymentDao.getAll();
	}
    
    
 
}

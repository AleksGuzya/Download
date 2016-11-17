package com.bionic.edu.dao;

import java.util.List;

public interface PaymentService {
	public List<Payment> findByMerchantId(int id);
	public double getPaymentSum();
	public Payment findById(int id);
	public List<Payment> getAll();
}

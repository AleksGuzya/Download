package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	
	
    @PersistenceContext
    private EntityManager em;
    
    public List<Payment> findByMerchantId(int id){
    	TypedQuery<Payment> query = em.createQuery("SELECT p FROM Payment p WHERE p.merchantId = " + id, Payment.class);
    	return query.getResultList();
    }

    public double getPaymentSum(){
    	TypedQuery<Double> query = em.createQuery("SELECT SUM(p.sumPayed) FROM Payment p", Double.class);
    	return query.getSingleResult();
    }
    
    public Payment findById(int id){
    	return em.find(Payment.class, id);
    }
    
    public List<Payment> getAll() {
    	TypedQuery<Payment> query = em.createQuery("SELECT p FROM Payment p", Payment.class);
    	List<Payment> list = null;
    	list = query.getResultList();
    	return list;    
    }

}

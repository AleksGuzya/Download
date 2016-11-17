package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MerchantDaoImpl implements MerchantDao{

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public Merchant findById(int id) {
		Merchant m = null;
    	m = em.find(Merchant.class, id);
    	return m;

	}

	@Override
	public List<Merchant> findAll() {
		TypedQuery<Merchant> query = em.createQuery("SELECT m FROM Merchant m", Merchant.class);
    	List<Merchant> listM = null;
    	listM = query.getResultList();
    	return listM;    

	}

	@Override
	public void save(Merchant merchant) {
		em.persist(merchant);
	}

	@Override
	public void update(Merchant merchant) {
		em.merge(merchant);
	}

	@Override
	public List<SumReport> getSumReport() {				
		String txt = "SELECT new com.bionic.edu.dao.SumReport(p.merchant.name, SUM(p.sumPayed)) ";
        txt += "FROM Payment p GROUP BY p.merchant.name";
		TypedQuery<SumReport> query = em.createQuery(txt, SumReport.class);
		return query.getResultList();
	}

}

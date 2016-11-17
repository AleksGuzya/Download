package com.bionic.edu.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionic.edu.dao.Merchant;
import com.bionic.edu.dao.MerchantList;
import com.bionic.edu.dao.MerchantService;
import com.bionic.edu.dao.Payment;
import com.bionic.edu.dao.PaymentService;
import com.bionic.edu.dao.SumReport;

@RestController
public class MerchantRestController {

	@Inject
	MerchantService mercService;
	
	@Autowired
	PaymentService paymentService;
	

	@GetMapping("/allMerchants")
	public ResponseEntity<List<Merchant>> allMerchants() {
		List<Merchant> list = mercService.findAll();
		return new ResponseEntity<List<Merchant>>(list, HttpStatus.OK);
	}
	
//	public MerchantList allMerchants() {
//		MerchantList list = new MerchantList();
//		list.setMerchants(mercService.findAll());
//		return list;
//	}

	@GetMapping("/merchant/{id}")
	public Merchant getMerchantById(@PathVariable int id) {
		Merchant merchant = mercService.findById(id);
		return merchant;
	}

	@PostMapping("/newMerchant")
	public ResponseEntity<Merchant> postMerchant(@RequestBody Merchant merchant) {
		mercService.save(merchant);
		return new ResponseEntity<Merchant>(merchant, HttpStatus.CREATED);
	}

	@PutMapping("/updateMerchant/{id}")
	public ResponseEntity<Merchant> updateEmployee(@PathVariable("id") int id, @RequestBody Merchant merchant) {
		mercService.update(merchant);
		return new ResponseEntity<Merchant>(merchant, HttpStatus.OK);
	}

	@GetMapping("/getReport")
	public ResponseEntity<List<SumReport>> getReport() {
		List<SumReport> list = mercService.getSumReport();
		return new ResponseEntity<List<SumReport>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/allPayments")
	public ResponseEntity<List<Payment>> allPayments() {
		List<Payment> list = paymentService.getAll();
		list.forEach(p -> System.out.println(p.getGoods()));
		return new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
	}

}

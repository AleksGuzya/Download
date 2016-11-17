package com.bionic.edu.dao;

public class SumReport {

	private String merchName;
	private double sumPayed;

	public SumReport(String merchName, double sumPayed) {
		this.merchName = merchName;
		this.sumPayed = sumPayed;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public double getSumPayed() {
		return sumPayed;
	}

	public void setSumPayed(double sumPayed) {
		this.sumPayed = sumPayed;
	}
	
	
	
	
	
}

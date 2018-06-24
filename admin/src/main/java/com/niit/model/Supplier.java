package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Supplier {
	@Id
	@GeneratedValue
	private int supplierId;
	private String supplierAddress;
	private String supplierName;
	public int getsupplierId() {
		return supplierId;
	}
	public void setsupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}






package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;

	boolean flag = true;

	@RequestMapping("/Supplier")
	public String showSupplier(Model m) {
		List<Supplier> listSuppliries = supplierDAO.getSuppliries();
		m.addAttribute("listSuppliries", listSuppliries);

		for (Supplier supplier : listSuppliries) {
			System.out.println(supplier.getSupplierName() + ",");
		}
		flag = false;
		return "Supplier";
	}

	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("suppname") String suppname, @RequestParam("suppadd") String suppadd,
			Model m) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(suppname);
		supplier.setSupplierAddress(suppadd);

		supplierDAO.addSupplier(supplier);
		List<Supplier> listSuppliries = supplierDAO.getSuppliries();
		m.addAttribute("listSuppliries", listSuppliries);
		flag = false;
		return "Supplier";
	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliries=supplierDAO.getSuppliries();
		m.addAttribute("listSuppliries",listSuppliries);
		flag=false;
		return "Supplier";
	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		
		List<Supplier> listSuppliries=supplierDAO.getSuppliries();
		m.addAttribute("listSuppliries",listSuppliries);
		m.addAttribute("supplierInfo",supplier);
		
		return "updatesupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplierInDB(@RequestParam("suppid") int supplierId,@RequestParam("suppname") String supplierName,
			@RequestParam("suppadd") String supplieraddress,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplieraddress);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliries=supplierDAO.getSuppliries();
		m.addAttribute("listSuppliries",listSuppliries);
		
		return "Supplier";
	}
}


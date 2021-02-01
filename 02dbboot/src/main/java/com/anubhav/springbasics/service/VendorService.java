package com.anubhav.springbasics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anubhav.springbasics.entity.IAddressPersistence;
import com.anubhav.springbasics.entity.IVendorPersistence;
import com.anubhav.springbasics.entity.Vendor;

@RestController
public class VendorService {
	
	@Autowired
	private IVendorPersistence vendor;
	@Autowired
	private IAddressPersistence addr;
	
	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {
		return vendor.findAll();
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor payload) {
		return vendor.save(payload);
	}
	
	@RequestMapping("/vendor/{id}")
	public Vendor getVendor(@PathVariable("id") Long Id) {
		Optional<Vendor> searchResult = vendor.findById(Id);
		if(!searchResult.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", "", "");
		}
		return searchResult.get();
	}
	
	@PutMapping("/vendor/{id}")
	public Vendor updateVendor(@RequestBody Vendor payload,@PathVariable Long id) {
		Optional<Vendor> updateVendor =  vendor.findById(id);
		if(!updateVendor.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", "", "");
		}
		return vendor.save(payload);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE, path="/vendor/{id}")
	public String deleteVendor(@PathVariable("id") Long Id) {
		
		Optional<Vendor> searchVendor =  vendor.findById(Id);
		if(!searchVendor.isPresent()) {
			return "not found";
		}
		
		 vendor.deleteById(Id);
		 return "";
		 		
	}
	
	//test using http://localhost:8080/vendor/search?lastName=Oberoy
	@RequestMapping("/vendor/search")
	public List<Vendor> searchVendor(@RequestParam String lastName) {
		return vendor.findByLastName(lastName);
		
	}
		
	//test using http://localhost:8080/vendor/gstNo/gstin
	@RequestMapping("/vendor/gstNo/{gstNo}")
	public List<Vendor> getVendorByGST(@PathVariable("gstNo") String GSTNo) {
		return vendor.lookupVendorByGSTNo(GSTNo);
		
	}
	
}

package com.anubhav.springbasics.entity;

import java.util.List;

import org.springframework.data.jpa.repository.*;


public interface IVendorPersistence extends JpaRepository<Vendor, Long> {

	@Query(nativeQuery=true, value="SELECT * FROM public.vendor where lower(GST_NO) like %?1% ")
	List<Vendor> lookupVendorByGSTNo(String GSTNo);
	
	List<Vendor> findByLastName(String lastName);
}

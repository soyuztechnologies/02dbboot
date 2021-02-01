package com.anubhav.springbasics.entity;



import org.springframework.data.jpa.repository.*;


public interface IAddressPersistence extends JpaRepository<address, Long> {

	
}

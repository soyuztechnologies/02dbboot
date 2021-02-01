package com.anubhav.springbasics.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import com.anubhav.springbasics.entity.address;

@Entity
@Table(name = "vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, name="ID")
	private Long id;
	@Column(nullable = false, name="FIRST_NAME")
	private String firstName;
	@Column(nullable = false, name="LAST_NAME")
	private String lastName;
	@Column(nullable = false, name="COMPANY_NAME")
	private String companyName;
	@Column(nullable = false, name="WEBSITE")
	private String webSite;
	@Column(nullable = false, name="EMAILID")
	private String emailId;
	@Column(nullable = false, name="GST_NO")
	private String gstNumber;
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "vendor",referencedColumnName="ID")
    private List<address> addresses =  new ArrayList<>();
    
	public List<address> getAddresses() {
		return (List<address>) addresses;
	}

	public void setAddresses(List<address> addresses) {
		this.addresses = (List<address>) addresses;
	}

	public Vendor() {
		
	}
	
	public Vendor(Long id, String firstName, String lastName, String companyName, String webSite, String emailId,
			String gSTNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.webSite = webSite;
		this.emailId = emailId;
		this.gstNumber = gSTNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", firstName=" + firstName + ", companyName=" + companyName + "]";
	}
	
	
}

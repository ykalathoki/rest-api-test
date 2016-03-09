package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Customer model class.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
@SuppressWarnings("serial")
@Entity
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String customerName;
	private String mobileNumber;
	private String address;

	
	public Customer() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Customer builder inner class
	 */
	public static class Builder {
		private Long id;
		private String customerName;
		private String mobileNumber;
		private String address;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder customerName(String customerName) {
			this.customerName = customerName;
			return this;
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

	private Customer(Builder builder) {
		this.id = builder.id;
		this.customerName = builder.customerName;
		this.mobileNumber = builder.mobileNumber;
		this.address = builder.address;
	}
}

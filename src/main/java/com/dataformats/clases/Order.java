package com.dataformats.clases;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;

@CsvRecord(separator=";")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 402477691075896789L;
	
	@DataField(pos=1)
	private String provider;
	@DataField(pos=2)
	private String orderId;
	@DataField(pos=3)
	private String country;
	@DataField(pos=4)
	private String total;
	@DataField(pos=5)
	private String approved;
	@DataField(pos=6)
	private String itemsQuantity;
	@Link
	private Client client;
	
	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}
	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * @return the approved
	 */
	public String getApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(String approved) {
		this.approved = approved;
	}
	/**
	 * @return the itemsQuantity
	 */
	public String getItemsQuantity() {
		return itemsQuantity;
	}
	/**
	 * @param itemsQuantity the itemsQuantity to set
	 */
	public void setItemsQuantity(String itemsQuantity) {
		this.itemsQuantity = itemsQuantity;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [provider=" + provider + ", orderId=" + orderId + ", country=" + country + ", total=" + total
				+ ", approved=" + approved + ", itemsQuantity=" + itemsQuantity + ", client=" + client.toString() + "]";
	}
	
	
}

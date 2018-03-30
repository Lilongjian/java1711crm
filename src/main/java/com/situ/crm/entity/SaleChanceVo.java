package com.situ.crm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SaleChanceVo implements Serializable {

    private String customerName;

    private String linkMan;

    private String createMan;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createTimeS;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createTimeE;

    private Integer status;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public Date getCreateTimeS() {
		return createTimeS;
	}

	public void setCreateTimeS(Date createTimeS) {
		this.createTimeS = createTimeS;
	}

	public Date getCreateTimeE() {
		return createTimeE;
	}

	public void setCreateTimeE(Date createTimeE) {
		this.createTimeE = createTimeE;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SaleChanceVo [customerName=" + customerName + ", linkMan=" + linkMan + ", createMan=" + createMan
				+ ", createTimeS=" + createTimeS + ", createTimeE=" + createTimeE + ", status=" + status + "]";
	}
    
    

}
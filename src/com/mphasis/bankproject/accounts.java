package com.mphasis.bankproject;

public class accounts {

	private int accno;
	private String cName; 
	private String cNumber;
	private String cUname;
	private String ePsw;
	private int cbal ;
	
	
	public accounts(int accno,String cName,String cNumber,String cUname,String ePsw,int cbal) {
		this.accno = accno;
		this.cName = cName;
		this.cNumber = cNumber;
		this.cUname = cUname;
		this.ePsw = ePsw;
		this.cbal = cbal;
		
	}


	public int getAccno() {
		return accno;
	}


	public void setAccno(int accno) {
		this.accno = accno;
	}


	public accounts() {
		super();
		
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getcNumber() {
		return cNumber;
	}


	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}


	public String getcUname() {
		return cUname;
	}


	public void setcUname(String cUname) {
		this.cUname = cUname;
	}


	public String getePsw() {
		return ePsw;
	}


	public void setePsw(String ePsw) {
		this.ePsw = ePsw;
	}


	public int getCbal() {
		return cbal;
	}


	public void setCbal(int cbal) {
		this.cbal = cbal;
	}
	
}

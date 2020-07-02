package com.zefuinha.xml.dominio;

import lombok.Data;

@Data
public class Document {
	
	private String vendorId;
	private String docTypeId;
	private String accNo;
	private String stmtDate;
	private CustData customer;
			
}

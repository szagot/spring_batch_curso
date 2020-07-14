package com.zefuinha.xml.dominio;

import lombok.Data;

@Data
public class Document {
	
	private String VendorId;
	private String DocTypeId;
	private String AccNo;
	private String StmtDate;
	private CustData CustData;
	private String PayDetails;
	private String NumberOfPages;
	private String Skipped;
			
}

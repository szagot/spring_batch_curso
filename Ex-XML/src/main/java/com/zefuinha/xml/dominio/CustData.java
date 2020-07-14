package com.zefuinha.xml.dominio;

import java.util.List;

import lombok.Data;

@Data
public class CustData {

	private String Name;
	private String Phone;
	private String City;
	private String Region;
	private String PostalCode;
	private String Country;
	private List<String> Addrs;
	
}

package com.dene;

import java.util.List;

public class Gunlukver� {
	
	private String tarih;;
	private double deger;
	
	
	
	@Override
	public String toString() {
		return "Borsa �stanbul: [tarih=" + tarih + ", deger=" + deger + "]";
	}



	public String getTarih() {
		return tarih;
	}



	public void setTarih(String tarih) {
		this.tarih = tarih;
	}



	public double getDeger() {
		return deger;
	}



	public void setDeger(double deger) {
		this.deger = deger;
	}



	public Gunlukver�() {
		
	}



	public Gunlukver�(String tarih, double deger) {
		
		
		this.tarih = tarih;
		this.deger = deger;
	}
	
	
	
	
	
	
	

}

package br.com.zenke.investimentos.utils;

public class ValidaTicker {
	
	public static boolean validaTickerAcao (String ticker) {
		
		try {
			ticker.trim();
			
			if (ticker.length() == 5) { 
				
				if (ticker.substring(4).contains("3") || 
					ticker.substring(4).contains("4") ||
					ticker.substring(4).contains("6"))
					return true;
				else {
					return false;
				}
						
			}else if (ticker.length() == 6) {
				
				System.out.print(ticker.substring(4,5));
				if (ticker.substring(4,6).contains("11")) { 
					return true;
				}
				
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}catch(Exception e) {
			
			return false;
		}
	}
	
	public static boolean validaTickerFII (String ticker) {
		
		ticker.trim();
		
		if (ticker.length() == 6) {
			if (ticker.substring(4,6).contains("11")) {
				return true;
		
			} else return false;
		}
		else return false;
	}
}
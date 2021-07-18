package br.com.zenke.investimentos.utils;

public abstract class ValidaTicker {
	
	public static boolean validaTickerAcao (String ticker) {
		
		try {
			if (ticker.trim().length() == 5)
				return ticker.substring(4).contains("3") ||
				       ticker.substring(4).contains("4") ||
				       ticker.substring(4).contains("6");

			else if (ticker.length() == 6)
				return ticker.substring(4, 6).contains("11");

			else return false;

		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean validaTickerFII (String ticker) {
		
		if (ticker.trim().length() == 6)
			return ticker.substring(4, 6).contains("11");
		else return false;
	}
}
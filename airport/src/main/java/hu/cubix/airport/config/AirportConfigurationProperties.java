package hu.cubix.airport.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 17.
// @ConfiguratiopnProperties annotációt használunk, ahol a prefix "airport"
// és a @Value értékeknek megfelelően létrehozunk osztály adattagokat és gettereket és settereket állítunk be nekik

//23.
// @Component annotáció is kell neki, hogy be tudja injektálni

@ConfigurationProperties(prefix = "airport")
@Component
public class AirportConfigurationProperties {
	
	// 19.
	// A root-ban pedig a Discountot hozzuk létre
	
	private Discount discount;
	
	
	public Discount getDiscount() {
		return discount;
	}


	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


	public static class Discount{
		
		// 18.
		// osztály adattagként létrehozunk egy Special-t és ehhez is készítünk gettert és settert
		
		private Special special;
		
		
		
		public Special getSpecial() {
			return special;
		}



		public void setSpecial(Special special) {
			this.special = special;
		}



		public static class Special{			
			
			private int limit;
			private int lowerPercent;
			private int higherPercent;
			
			public int getLimit() {
				return limit;
			}
			public void setLimit(int limit) {
				this.limit = limit;
			}
			public int getLowerPercent() {
				return lowerPercent;
			}
			public void setLowerPercent(int lowerPercent) {
				this.lowerPercent = lowerPercent;
			}
			public int getHigherPercent() {
				return higherPercent;
			}
			public void setHigherPercent(int higherPercent) {
				this.higherPercent = higherPercent;
			}
			
		}
		
	}

}

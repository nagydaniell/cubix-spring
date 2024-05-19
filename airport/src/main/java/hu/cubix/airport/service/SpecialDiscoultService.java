package hu.cubix.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hu.cubix.airport.config.AirportConfigurationProperties;
import hu.cubix.airport.config.AirportConfigurationProperties.Discount.Special;

// 5.
// Ez már egy kicsit okosabb és 1000 dollár felett 15 %-ot ad
// Ha futtatjuk a kódot azért nem működik így mert még nem egy Spring Bean ez az osztály

// 6. 
// viszont ha csak így hagyjuk akkor hibára fog futni, mert két Bean is a getDiscountPercent methodot 
// akarja futtatni és a foprogram nem tudja eldöntneni, hogy melyiket kell elindítnaia
// ezért két konfig osztályt kell készíteni külön, egyiket a Default-, másikat a SpecialDiscountService-nek 
// külön package-be kerülnek a service osztályok, updattel kell átkaolni őket, hogy a refractort elvégezze magától

// 9.
// @Service mivel a config fileok léteznek ezért már nincs szükség a @Service annotációra
public class SpecialDiscoultService implements DiscountService{

	// 14.
	// Ehhez használhatjuk a @Value annotációt és át tudjuk mozgatni ezeket az értékeket member variable-be és ezeket be tudjuk injektálni
	// az elméletben benne vannak ezek is. Bele kell írni őket az application.propertiesbe
	
	// 16.
	// A 15. után újra működnie kell a programnak
	// De ezek helyett az @Value annotációk helyett lehet használni egy AirportConfigurationProperties osztályt, amit a .config package-be teszünk
	
	// 20.
	// kicseréljük az egész kódot úgy hogy simán csak beinjektáljuk az AirportConfigurationProperties-t config néven...
	
//	@Value("${airport.discount.special.limit}")
//	private int limit;
//	@Value("${airport.discount.special.lowerPercent}")
//	private int lowerPercent;
//	@Value("${airport.discount.special.higherPercent}")
//	private int higherPercent;
	
	// ... és az egyszerűség kedvéért @Autowired-el mint osztály adattag
	@Autowired 
	private AirportConfigurationProperties config;
	
	@Override
	public int getDiscountPercent(int totalPice) {
		
		// 13.
		// A 12. feladat után a programnak futnia kell, a 13 után szeretnénk még okosabbá tenni ezt a feltételt és nem beleírni az  
		// 1000 dolláros limitet vagy a 15/10 %-os kedvezményt. Inkább beletennénk a configurációs file-ba
		
		// 15. - átírjuk az értékeket 
		// return totalPice > 1000 ? 15 : 10;
		// return totalPice > limit ? higherPercent : lowerPercent;
		
		// 21.
		// beconfigoljuk ezt a sort: config.getDiscount().getSpecial() és utána exrtaktoljuk mint local variable alt+shift+L
		// újra átírjuk a return értékeket a gettereken keresztül
		Special specialConifg = config.getDiscount().getSpecial();
		return totalPice > specialConifg.getLimit() ? specialConifg.getHigherPercent() : specialConifg.getLowerPercent();
		
		// 22. 
		// ez után az a baja, hogy a AirportConfigurationProperties config nem @Component úgyhogy azt is meg kell adni.
		
	}

}

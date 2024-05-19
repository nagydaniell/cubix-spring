package hu.cubix.airport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.airport.service.DefaultDiscountService;
import hu.cubix.airport.service.DiscountService;
import hu.cubix.airport.service.SpecialDiscoultService;

// 8.

// A @Configuration annotációval kell megadni, hogy ez egy Config file-lesz
// és ez a config lesz felelős azért, hogy visszaadjon egy DiscontService Beant ami itt a SpecialDiscountService
// mivel ez egy Bean ezért a @Bean annotáció szükséges ide

// 11. mivel kért configuration is ugyan arra a DiscountService Interface-re mutat azért még mindidg nem fog működni, szóval 
// a ProdConfiguration-nek csak akkor szabad elgogadottnak lennie, ha a Prod Profile aktív

// 12. ha most futtatjuk akkor már menni fog, viszont a @Profile("prod") annotáció nincs használatban, ezért ezt meg kell írnunk a 
// a resources mappában található "application.properties"-be

@Configuration
@Profile("prod")
public class ProdConfiguration {
	
	@Bean
	public DiscountService discountService() {
		
		return new SpecialDiscoultService();
		
	}

}

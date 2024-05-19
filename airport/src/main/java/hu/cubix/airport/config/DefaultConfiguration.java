package hu.cubix.airport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.airport.service.DefaultDiscountService;
import hu.cubix.airport.service.DiscountService;

// 7.

// A @Configuration annotációval kell megadni, hogy ez egy Config file-lesz
// és ez a config lesz felelős azért, hogy visszaadjon egy DiscontService Beant ami itt a DefaultDiscountService
// mivel ez egy Bean ezért a @Bean annotáció szükséges ide

//12. mivel kért configuration is ugyan arra a DiscountService Interface-re mutat azért még mindidg nem fog működni, szóval 
//a ProdConfiguration-nek csak akkor szabad elgogadottnak lennie, ha a Prod Profile NEM aktív

@Configuration
@Profile("!prod")
public class DefaultConfiguration {
	
	@Bean
	public DiscountService discountService() {
		
		return new DefaultDiscountService();
		
	}

}

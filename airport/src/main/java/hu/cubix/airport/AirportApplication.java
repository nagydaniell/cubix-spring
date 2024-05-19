package hu.cubix.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.airport.service.PriceService;

@SpringBootApplication
public class AirportApplication implements CommandLineRunner{
	
	// 4.
	
	// futtatunk pár kódot és a PriceService ide lesz beinjektálva. Az injektálást most nem konstruktoron keresztül tesszük meg, hanem
	// most az @Autowired annotáció segítségével, hogy mind a kettőre lássunk példát
	@Autowired
	PriceService priceService;
	
	// A priceService-hez nem férünk hozzá a statikus methodon belül, mert az egy member variable, ezért implementálnunk kell a
	// CommandLineRunner interfacet és...

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

	// ... és itt hívjuk meg a priceService-t az eredeti árral (ez az elméletben van benne, hogy pontosan mit csinál)
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(priceService.getFinalPrice(100));
		System.out.println(priceService.getFinalPrice(2000));
		
	}
	
	// test modification

}

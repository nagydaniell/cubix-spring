package hu.cubix.airport.service;

import org.springframework.stereotype.Service;

//3.
// ez is egy Spring Bean lesz a Service használatával

@Service
public class PriceService {

	// hogyan is fog működni:
	// használni fogja a DiscountService-t
	
	// a kérdés, hogyan fogjuk ezt be injektálni. Erre két lehetőségünk van
	// @Autowired annotáció az egyik opció, hogy eléírjuk
	// a másik lehetőség, hogy készítünk hozzá egy konstruktort, mert konstruktorként később tudunk "Mock objectet" használni	
	private DiscountService discountService;
	
	

	public PriceService(DiscountService discountService) {
		super();
		this.discountService = discountService;
	}



	// alkalmas lesz arra, hogy megadja a végső árat egy adott ár helyett
	// ez a DefaultDescountService-t fogja használni, hogy kiszámolja a végső árat
	public int getFinalPrice(int price) {

		// mivel double-el osztunk viszont intet vár vissza ezért int-be castoljuk vissza
		return (int) (price / 100.0 * (100 - discountService.getDiscountPercent(price)));

	}

}

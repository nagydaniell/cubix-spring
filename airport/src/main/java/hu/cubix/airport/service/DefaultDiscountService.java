package hu.cubix.airport.service;

import org.springframework.stereotype.Service;

//2.
// csináljunk ebből az osztályból egy spring beant, ezt már az után csináljuk, hogy megírtuk az implementációt
//a Service jobban megfelel a business logic használatához, mint a Component

//10.
//@Service mivel a config fileok léteznek ezért már nincs szükség a @Service annotációra
public class DefaultDiscountService implements DiscountService{

	// ez az osztály egy implementációs osztály az előző interfacenek
	
	@Override
	public int getDiscountPercent(int totalPice) {
		
		return 10; // 10%-ot adunk
		
	}	

}

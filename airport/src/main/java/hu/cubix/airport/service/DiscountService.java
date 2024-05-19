package hu.cubix.airport.service;

// 1.
public interface DiscountService {
	
	// ez az interface visszaad egy integert százalékban
	public int getDiscountPercent(int totalPice); // total Price az erdeti ára

}

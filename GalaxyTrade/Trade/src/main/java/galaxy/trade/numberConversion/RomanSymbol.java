package galaxy.trade.numberConversion;

import java.util.HashMap;
import java.util.Map;

public enum RomanSymbol {
	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	private Integer arabicNumber;
	
	private RomanSymbol(Integer arabicNumber) {
		this.arabicNumber = arabicNumber;
	}
	
	private static final Map<Integer, RomanSymbol> romanSymbols = new HashMap<>();
	
	static {
		for (RomanSymbol romanSymbol : values()) romanSymbols.put(romanSymbol.getArabicNumber(), romanSymbol);
	}
	
	public Integer getArabicNumber() {
		return this.arabicNumber;
	}
	
	public static RomanSymbol getRomanSymbol(Integer arabicNumber) {
		return romanSymbols.get(arabicNumber);
	}
	
	public static RomanSymbol getRomanSymbol(char romanNumber) {
		try {
			RomanSymbol romanSymbol = RomanSymbol.valueOf(Character.toString(romanNumber).toUpperCase());
			return romanSymbol;
		}
		catch(IllegalArgumentException exp) {
			InvalidRomanNumberException exception = new InvalidRomanNumberException(InvalidRomanNumberException.InvalidRomanNumber, String.format("Inavlid roman number %c", romanNumber));
			throw exception;
		}
	}
}

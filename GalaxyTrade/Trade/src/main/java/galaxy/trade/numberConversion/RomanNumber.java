package galaxy.trade.numberConversion;
import java.util.ArrayList;
import java.util.List;

public class RomanNumber {
	String romanNumber;
	public RomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;
	}
	public int convertToArabic() {
		List<RomanSymbol> romanNumberList = validateForValidRomanNumber();
		
		if (romanNumberList.size() == 1) {
			return romanNumberList.get(0).getArabicNumber();
		}
		else {
			RomanNumberValidationRules validationRules = new RomanNumberValidationRules();
			validationRules.isValid(romanNumberList);
			return convertToArabic(romanNumberList);
		}
	}

	private List<RomanSymbol> validateForValidRomanNumber() {
		
		List<RomanSymbol> romanNumberList = new ArrayList<RomanSymbol>();
		for(char individualRomanNumber : romanNumber.toCharArray()) {
			romanNumberList.add(RomanSymbol.getRomanSymbol(individualRomanNumber));
		}
		return romanNumberList;
	}

	private int convertToArabic(List<RomanSymbol> romanNumberList) {
		boolean isFirstTimeIndex = true;
		int previousNumber = 0;
		int currentNumber = 0;
		int calcualtedArabicNumber = 0;
		
		for(RomanSymbol individualRomanNumber : romanNumberList) {
			
			if (isFirstTimeIndex) {
				isFirstTimeIndex = false;
				previousNumber = individualRomanNumber.getArabicNumber();
				calcualtedArabicNumber = previousNumber;
				continue;
			}
			
			currentNumber = individualRomanNumber.getArabicNumber();
			
			if(previousNumber < currentNumber) {
				calcualtedArabicNumber = calcualtedArabicNumber - previousNumber + (currentNumber - previousNumber);
			}
			else {
				calcualtedArabicNumber = calcualtedArabicNumber + currentNumber;
			}
			
			previousNumber = currentNumber;
		}

		return calcualtedArabicNumber;
	}

	
}

package galaxy.trade.numberConversion;

import java.util.ArrayList;
import java.util.List;

public class RomanNumberValidationRules {
	private static final List<RomanSymbol> notToBeRepeatedRomanNumbers = getNotToBeRepeatedRomanNumbers();
	
	private static List<RomanSymbol> getNotToBeRepeatedRomanNumbers() {
		List<RomanSymbol> notToBeRepeatedRomanNumbers = new ArrayList<RomanSymbol>();
		notToBeRepeatedRomanNumbers.add(RomanSymbol.D);
		notToBeRepeatedRomanNumbers.add(RomanSymbol.L);
		notToBeRepeatedRomanNumbers.add(RomanSymbol.V);
		return notToBeRepeatedRomanNumbers;
	}
	
	private static final List<RomanSymbol> notToBeRunningForFourtimesRomanNumber = getNotToBeRunningForFourtimesRomanNumber();
	
	private static List<RomanSymbol> getNotToBeRunningForFourtimesRomanNumber() {
		List<RomanSymbol> notToBeRunningForFourtimesRomanNumber = new ArrayList<RomanSymbol>();
		notToBeRunningForFourtimesRomanNumber.add(RomanSymbol.I);
		notToBeRunningForFourtimesRomanNumber.add(RomanSymbol.X);
		notToBeRunningForFourtimesRomanNumber.add(RomanSymbol.C);
		notToBeRunningForFourtimesRomanNumber.add(RomanSymbol.M);
		return notToBeRunningForFourtimesRomanNumber;
	}
	
	public boolean isValid(List<RomanSymbol> romanNumberList){
		validateForNotToBeRepeatedRomanNumbers(romanNumberList);
		validateForNotToBeRunningForFourtimesRomanNumber(romanNumberList);
		return true;
	}
	
	private void validateForNotToBeRepeatedRomanNumbers(List<RomanSymbol> romanNumberList){
		
		RomanSymbol previousRomanSymbol = null;
		for(RomanSymbol individualRomanNumber : romanNumberList) {
			if (notToBeRepeatedRomanNumbers.contains(individualRomanNumber)) {
				if (individualRomanNumber.equals(previousRomanSymbol)) {
					throw new InvalidRomanNumberException(InvalidRomanNumberException.NotToBeRepeatedRomanNumber, "Not to be repeated roman number");
				}
				else {
					previousRomanSymbol = individualRomanNumber;
				}
			}
			else {
				previousRomanSymbol = null;
			}
		}
	}

	private void validateForNotToBeRunningForFourtimesRomanNumber(List<RomanSymbol> romanNumberList){
		RomanSymbol previousRomanSymbol = null;
		int numberOfTimesFound = 4;
		for(RomanSymbol individualRomanNumber : romanNumberList) {
			if (notToBeRunningForFourtimesRomanNumber.contains(individualRomanNumber)) {
				if (individualRomanNumber.equals(previousRomanSymbol)) {
					numberOfTimesFound--;
					if(numberOfTimesFound == 0) {
						throw new InvalidRomanNumberException(InvalidRomanNumberException.NotToBeRunningForFourtimesRomanNumber, "Not to be running more than four times");
					}
				}
				else {
					previousRomanSymbol = individualRomanNumber;
					numberOfTimesFound--;
				}
			}
			else {
				previousRomanSymbol = null;
				numberOfTimesFound = 4;
			}
		}
		
	}

	

}

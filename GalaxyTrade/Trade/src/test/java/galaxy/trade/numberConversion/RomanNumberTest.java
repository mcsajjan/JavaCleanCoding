package galaxy.trade.numberConversion;

import galaxy.trade.numberConversion.InvalidRomanNumberException;
import galaxy.trade.numberConversion.RomanNumber;
import junit.framework.TestCase;

public class RomanNumberTest extends TestCase {

	public void testConvertRomanNumberToIndoArabic(){
		assertEquals(1, this.getRomanNumber("I").convertToArabic());
		assertEquals(5,  this.getRomanNumber("V").convertToArabic());
		assertEquals(10,  this.getRomanNumber("X").convertToArabic());
		assertEquals(50,  this.getRomanNumber("L").convertToArabic());
		assertEquals(100,  this.getRomanNumber("C").convertToArabic());
		assertEquals(500,  this.getRomanNumber("D").convertToArabic());
		assertEquals(1000,  this.getRomanNumber("M").convertToArabic());
	}
	public void testConvertTwoDigitRomanNumberToIndoArabicWithFirstNumberLessThanSecond(){
		assertEquals(4,  this.getRomanNumber("IV").convertToArabic());
		assertEquals(9,  this.getRomanNumber("IX").convertToArabic());
		assertEquals(40,  this.getRomanNumber("XL").convertToArabic());
		assertEquals(90,  this.getRomanNumber("XC").convertToArabic());
	}
	
	public void testConvertTwoDigitRomanNumberToIndoArabicWithFirstNumberGreaterThanSecond(){
		assertEquals(6,  this.getRomanNumber("VI").convertToArabic());
		assertEquals(11,  this.getRomanNumber("XI").convertToArabic());
		assertEquals(60,  this.getRomanNumber("LX").convertToArabic());
		assertEquals(110,  this.getRomanNumber("CX").convertToArabic());
	}
	
	public void testConvertThreeDigitRomanNumberToIndoArabic(){
		assertEquals(14,  this.getRomanNumber("IXV").convertToArabic());
		assertEquals(16,  this.getRomanNumber("XVI").convertToArabic());
		assertEquals(45,  this.getRomanNumber("XLV").convertToArabic());
		assertEquals(111,  this.getRomanNumber("CXI").convertToArabic());
	}
	
	public void testConvertAnyRomanNumberToIndoArabic(){
		assertEquals(2006,  this.getRomanNumber("MMVI").convertToArabic());
		assertEquals(1944,  this.getRomanNumber("MCMXLIV").convertToArabic());
		assertEquals(1903,  this.getRomanNumber("MCMIII").convertToArabic());
	}
	
	public void testValidationForInvalidRomanNumber(){
		try	{
			 this.getRomanNumber("A").convertToArabic();
			assertTrue(false);
		} catch (InvalidRomanNumberException exp) {
			assertEquals(InvalidRomanNumberException.InvalidRomanNumber, exp.getErrorCode());
		}
	}

	public void testValidationForNonRepeatedRomanNumber(){
		try	{
			 this.getRomanNumber("DD").convertToArabic();
			assertTrue(false);
		} catch (InvalidRomanNumberException exp) {
			assertEquals(InvalidRomanNumberException.NotToBeRepeatedRomanNumber, exp.getErrorCode());
		}
	}
	
	public void testValidationForFourTimesRunningRomanNumber(){
		try	{
			 this.getRomanNumber("XXXX").convertToArabic();
			assertTrue(false);
		} catch (InvalidRomanNumberException exp) {
			assertEquals(InvalidRomanNumberException.NotToBeRunningForFourtimesRomanNumber, exp.getErrorCode());
		}
	}
	
	private RomanNumber getRomanNumber(String romanString) {
		RomanNumber romanNumber = new RomanNumber(romanString);
		return romanNumber;
	}
}

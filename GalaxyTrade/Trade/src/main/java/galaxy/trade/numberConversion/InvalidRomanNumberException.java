package galaxy.trade.numberConversion;

import galaxy.trade.common.GalaxyTradeException;

public class InvalidRomanNumberException extends GalaxyTradeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int InvalidRomanNumber = 100;
	public static final int NotToBeRepeatedRomanNumber = 101;

	public static final int NotToBeRunningForFourtimesRomanNumber = 102;
	public InvalidRomanNumberException(int code, String message) {
		super(code, message);
	}
}

package galaxy.trade.common;

public class GalaxyTradeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4950715114990649951L;
	
	int errorCode = 0;
	public GalaxyTradeException(int code, String message) {
		super(message);
		this.errorCode = code;
	}
	
	public GalaxyTradeException(String message) {
		super(message);
		this.errorCode = -1;
	}

	public int getErrorCode(){
		return errorCode;
	}
}

package galaxy.trade;

public class Result<T> {
	private T t;
	private boolean isValid;
	private String errorMessage;
	
	public void add(T t) {
		this.t = t;
	}
	
	public void setValidationStatusTo(boolean isValid) {
		this.isValid = isValid;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public T getValue() {
		return t;
	}
}

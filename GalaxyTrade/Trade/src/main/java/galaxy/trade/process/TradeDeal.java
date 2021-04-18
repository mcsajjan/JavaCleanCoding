package galaxy.trade.process;

import java.util.HashMap;
import java.util.List;

import galaxy.trade.numberConversion.RomanNumber;

public class TradeDeal {
	private TradeItems tradeItems;
	private List<TradeCreditRate> tradeCreditRates;
	private HashMap<CreditType, Float> creditValue;
	
	public TradeDeal(TradeItems tradeItems, List<TradeCreditRate> tradeCreditRates) {
		this.tradeItems = tradeItems;
		this.tradeCreditRates = tradeCreditRates;
		this.creditValue = new HashMap<CreditType, Float>();
		this.calculateCreditValues();
	}
	
	private void calculateCreditValues() {
		for(TradeCreditRate creditRate : tradeCreditRates) {
			if (creditRate.getTradeItemsPresentWithCredit().size() > 0) {
				RomanNumber romanNumber = new RomanNumber(generateRomanNumber(creditRate.getTradeItemsPresentWithCredit()));
				float arabicNumber = romanNumber.convertToArabic();
				creditValue.put(creditRate.getCreditType(), creditRate.getRate()/arabicNumber);
			}
			else {
				creditValue.put(creditRate.getCreditType(), (float)creditRate.getRate());
			}
		}
	}
	
	public TradeItems getTradeItems() {
		return tradeItems;
	}
	
	public int getPrice(TradeOrder tradeOrder) {
		if (tradeOrder.getOrderedTradeItems().size() == 0) {
			return 0;
		}
		RomanNumber romanNumber = new RomanNumber(generateRomanNumber(tradeOrder.getOrderedTradeItems()));
		float arabicNumber = romanNumber.convertToArabic();
		if (creditValue.containsKey(tradeOrder.getCreditType())) {
			arabicNumber = arabicNumber * creditValue.get(tradeOrder.getCreditType());
		}
		return Math.round(arabicNumber);
	}


	private String generateRomanNumber(List<String> orderedTradeItems) {
		String romanNumber = "";
		for(String orderedTradeItem : orderedTradeItems){
			romanNumber += this.tradeItems.getItem(orderedTradeItem);
		}
		return romanNumber;
	}
}

package galaxy.trade.process;

import java.util.ArrayList;
import java.util.List;

import galaxy.trade.common.GalaxyTradeException;

public class TradeOrder {
	private TradeItems tradeItems;
	private List<String> orderedTradeItems;
	private CreditType creditType;
	
	public TradeOrder(TradeItems tradeItems) {
		this.orderedTradeItems = new ArrayList<String>();
		this.tradeItems = tradeItems;
	}
	public List<String> getOrderedTradeItems() {
		return orderedTradeItems;
	}
	public void addTradeItem(String orderedTradeItem) {
		if (this.tradeItems.contains(orderedTradeItem)){
			this.orderedTradeItems.add(orderedTradeItem);
		}
		else {
			throw new GalaxyTradeException("Invalid iteam");
		}
	}
	public CreditType getCreditType() {
		return creditType;
	}
	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}
	
	@Override
	public String toString() {
		String tradeItems = "";
		for(String tradeItem : orderedTradeItems) {
			tradeItems += " " + tradeItem;
		}
		if(creditType != null && creditType != CreditType.Unknown) {
			tradeItems += " " + creditType.toString();
		}
		return tradeItems;
	}
}

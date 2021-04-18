package galaxy.trade.process;

import java.util.ArrayList;
import java.util.List;

import galaxy.trade.common.GalaxyTradeException;

public class TradeCreditRate {
	private TradeItems tradeItems;
	private List<String> tradeItemsPresentWithCredit;
	private CreditType creditType;
	private int rate;
	
	public TradeCreditRate(TradeItems tradeItems) {
		this.tradeItemsPresentWithCredit = new ArrayList<String>();
		this.tradeItems = tradeItems;
		this.creditType = CreditType.Unknown;
	}
	
	public List<String> getTradeItemsPresentWithCredit() {
		return tradeItemsPresentWithCredit;
	}

	public void addTradeItem(String tradeItem) {
		if(this.tradeItems.contains(tradeItem)) {
			this.tradeItemsPresentWithCredit.add(tradeItem);
		}
		else {
			throw new GalaxyTradeException("Invalid trade item");
		}
	}

	public CreditType getCreditType() {
		return creditType;
	}

	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


	
}

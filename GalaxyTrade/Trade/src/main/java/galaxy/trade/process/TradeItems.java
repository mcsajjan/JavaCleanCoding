package galaxy.trade.process;

import java.util.HashMap;

public class TradeItems {
	HashMap<String, Character> tradeItems;
	
	public TradeItems() {
		this.tradeItems = new HashMap<String, Character>();
	}
	
	public void AddTradeItem(String itemName, char romanSymbol){
		this.tradeItems.put(itemName, romanSymbol);
	}
	
	public char getItem(String itemName) {
		return tradeItems.get(itemName);
	}
	
	public boolean contains(String itemName) {
		return tradeItems.containsKey(itemName);
	}
}

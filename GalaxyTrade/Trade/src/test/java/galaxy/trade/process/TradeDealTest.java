package galaxy.trade.process;

import java.util.ArrayList;
import java.util.List;

import galaxy.trade.process.CreditType;
import galaxy.trade.process.TradeCreditRate;
import galaxy.trade.process.TradeDeal;
import galaxy.trade.process.TradeItems;
import galaxy.trade.process.TradeOrder;
import junit.framework.TestCase;

public class TradeDealTest extends TestCase{
	
	TradeItems tradeItems;
	List<TradeCreditRate> creditRates;
	
	public void setUp() {
		tradeItems = new TradeItems();
		tradeItems.AddTradeItem("glob", 'I');
		tradeItems.AddTradeItem("prok", 'V');
		tradeItems.AddTradeItem("pish", 'X');
		tradeItems.AddTradeItem("tegj", 'L');
		
		creditRates = new ArrayList<TradeCreditRate>();
	}
	public void testGetPriceForNotHavingCredits() {
		TradeCreditRate creditRate = new TradeCreditRate(tradeItems);
		creditRates.add(creditRate);
		
		TradeDeal tradeDeal = new TradeDeal(tradeItems, creditRates);
		
		TradeOrder tradeOrder = new TradeOrder(tradeItems);
		tradeOrder.addTradeItem("pish");
		tradeOrder.addTradeItem("tegj");
		tradeOrder.addTradeItem("glob");
		tradeOrder.addTradeItem("glob");
		
		assertEquals(42, tradeDeal.getPrice(tradeOrder));
	}
	
	
	public void testGetPriceForHavingCredits1() {
		TradeCreditRate creditRate = new TradeCreditRate(tradeItems);
		creditRate.addTradeItem("glob");
		creditRate.addTradeItem("glob");
		creditRate.setCreditType(CreditType.Silver);
		creditRate.setRate(34);
		creditRates.add(creditRate);
		
		TradeDeal tradeDeal = new TradeDeal(tradeItems, creditRates);
		
		TradeOrder tradeOrder = new TradeOrder(tradeItems);
		tradeOrder.addTradeItem("glob");
		tradeOrder.addTradeItem("prok");
		tradeOrder.setCreditType(CreditType.Silver);
		
		assertEquals(68, tradeDeal.getPrice(tradeOrder));
	}
	
	public void testGetPriceForHavingCredits2() {
		TradeCreditRate creditRate = new TradeCreditRate(tradeItems);
		creditRate.addTradeItem("glob");
		creditRate.addTradeItem("prok");
		creditRate.setCreditType(CreditType.Gold);
		creditRate.setRate(57800);
		creditRates.add(creditRate);
		
		TradeDeal tradeDeal = new TradeDeal(tradeItems, creditRates);
		
		TradeOrder tradeOrder = new TradeOrder(tradeItems);
		tradeOrder.addTradeItem("glob");
		tradeOrder.addTradeItem("prok");
		tradeOrder.setCreditType(CreditType.Gold);
		
		assertEquals(57800, tradeDeal.getPrice(tradeOrder));
	}
	
	public void testGetPriceForHavingCredits3() {
		TradeCreditRate creditRate = new TradeCreditRate(tradeItems);
		creditRate.addTradeItem("pish");
		creditRate.addTradeItem("pish");
		creditRate.setCreditType(CreditType.Iron);
		creditRate.setRate(3910);
		creditRates.add(creditRate);
		
		TradeDeal tradeDeal = new TradeDeal(tradeItems, creditRates);
		
		TradeOrder tradeOrder = new TradeOrder(tradeItems);
		tradeOrder.addTradeItem("glob");
		tradeOrder.addTradeItem("prok");
		tradeOrder.setCreditType(CreditType.Iron);
		
		assertEquals(782, tradeDeal.getPrice(tradeOrder));
	}
}

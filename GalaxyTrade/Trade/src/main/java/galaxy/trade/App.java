package galaxy.trade;

import galaxy.trade.process.TradeDeal;
import galaxy.trade.process.TradeOrder;

public class App 
{
    public static void main( String[] args )
    {
		try {
			InputTradeDetails inputTradeDetails = new InputTradeDetails();
		    TradeDetailsParser tradeDataParser = new TradeDetailsParser();
		    
		    Result<TradeDeal> tradeDealOrError = tradeDataParser.createTradeDeal(inputTradeDetails.getTradeDealDetails());
		    if(tradeDealOrError.isValid()) {
		    	TradeDeal tradeDeal = tradeDealOrError.getValue();
		    	for(String tradeOrder : inputTradeDetails.getTradeOrderDetails()) {
			    	Result<TradeOrder> tradeOrderOrError = tradeDataParser.createTradeOrder(tradeOrder, tradeDeal.getTradeItems());
			    	if(tradeOrderOrError.isValid()) {
			    		TradeOrder order = tradeOrderOrError.getValue();
			    		int arabicValue = tradeDeal.getPrice(order);
			    		System.out.println(order.toString() + " is " + arabicValue);
			    	}
			    	else {
			    		System.out.println("I have no idea what you are talking about");
			    	}
		    	}
		    }
		    else {
		    	System.out.println(tradeDealOrError.getErrorMessage());
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
package galaxy.trade;

import java.util.ArrayList;
import java.util.List;

import galaxy.trade.common.GalaxyTradeException;
import galaxy.trade.process.CreditType;
import galaxy.trade.process.TradeCreditRate;
import galaxy.trade.process.TradeDeal;
import galaxy.trade.process.TradeItems;
import galaxy.trade.process.TradeOrder;

public class TradeDetailsParser {

	public Result<TradeDeal> createTradeDeal(String dealInformation) {
		Result<TradeDeal> result = new Result<TradeDeal>();
		try
		{
			TradeItems tradeItems = this.getAllTadeItems(dealInformation);
			TradeDeal tradeDeal = new TradeDeal(tradeItems, this.getAllTadeCreaditRates(dealInformation, tradeItems));
			result.add(tradeDeal);
			result.setValidationStatusTo(true);
		}
		catch (GalaxyTradeException exp) {
			result.setValidationStatusTo(false);
			result.setErrorMessage(exp.getMessage());
		}
		catch (Exception exp) {
			result.setValidationStatusTo(false);
			result.setErrorMessage(exp.getMessage());
		}
		return result;
	}
	
	private TradeItems getAllTadeItems(String dealInformation){
		String[] individualDeals = dealInformation.split("\n");
		TradeItems tradeItems = new TradeItems();
		
		for(String individualDeal : individualDeals) {
			if (individualDeal.indexOf(" is ") > 0) {
				String[] parsedDealInfomration = individualDeal.split(" ");
				
				if(parsedDealInfomration.length == 3) {
					tradeItems.AddTradeItem(parsedDealInfomration[0], parsedDealInfomration[2].charAt(0));
				}
			}
		}
		return tradeItems;
	}
	
	private List<TradeCreditRate> getAllTadeCreaditRates(String dealInformation, TradeItems tradeItems){
		String[] individualDeals = dealInformation.split("\n");
		List<TradeCreditRate> creditRates = new ArrayList<TradeCreditRate>();
		TradeCreditRate creditRate;
			
		for(String individualDeal : individualDeals) {
			if (individualDeal.indexOf(" is ") > 0) {
				String[] parsedDealInfomration = individualDeal.split(" ");
				
				if(parsedDealInfomration.length == 6) {
					if (parsedDealInfomration[5].equals("Credits")){
						creditRate = new TradeCreditRate(tradeItems);
						creditRate.addTradeItem(parsedDealInfomration[0]);
						creditRate.addTradeItem(parsedDealInfomration[1]);
						creditRate.setCreditType(CreditType.valueOf(parsedDealInfomration[2]));
						creditRate.setRate(Integer.parseInt(parsedDealInfomration[4]));
						creditRates.add(creditRate);
					}
					else {
						throw new GalaxyTradeException("Invalid format");
					}
				}
			}
		}
		return creditRates;
	}

	
	public Result<TradeOrder> createTradeOrder(String orderDetails, TradeItems tradeItems) {
		Result<TradeOrder> result = new Result<TradeOrder>();
		TradeOrder tradeOrder;
		try
		{
			if (orderDetails.indexOf("how ") > -1 && orderDetails.indexOf("?") > 0) {
				if (orderDetails.indexOf("is") > 0) {
					String orderData = orderDetails.substring(orderDetails.indexOf("is")+2).replace("?", "").trim();
					String[] ordersInfomration = orderData.split(" ");
					tradeOrder = new TradeOrder(tradeItems);
					for (String orderInfo : ordersInfomration){
						if(isItCreditType(orderInfo)){
							tradeOrder.setCreditType(CreditType.valueOf(orderInfo));
						}
						else {
							tradeOrder.addTradeItem(orderInfo);
						}
					}
					result.add(tradeOrder);
				}
				else {
					throw new GalaxyTradeException("Invalid format");
				}
			}
			result.setValidationStatusTo(true);
		}
		catch (GalaxyTradeException exp) {
			result.setValidationStatusTo(false);
			result.setErrorMessage(exp.getMessage());
		}
		catch (Exception exp) {
			result.setValidationStatusTo(false);
			result.setErrorMessage(exp.getMessage());
		}
		return result;
	}
	
	private boolean isItCreditType(String info) {
		boolean isItCredieType = false;
		for(CreditType creditType : CreditType.values()){
			if(info.equals(creditType.toString())){
				isItCredieType = true;
				break;
			}
		}
		return isItCredieType;
	}
}

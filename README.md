# JavaCleanCoding
Application has 3 main components
galaxy.trade.numberConversion: This has the logic of Arabic to Roman conversion
galaxy.trade.process: This is the cored domain logic of galaxy trading. It does not include human readable format of trade
galaxy.trade: readable syntax

Domain Language:
TradeItems: Items(metals or dirts) which needs to be sold. Ex: glob, prok
CreditType: Credit type can be Silver, Gold or Iron
TradeCreditRate: Price of the trade item and credit type. Ex: glob glob Silver is 34 Credits
TradeDeal: Contract information. Basically contract contains information of TradeItems and TradeCreditRate
TradeOrder: Order for which price is needed. Ex: how much is pish tegj glob glob ?

Input is form InputData.txt which is under resources. Output is console.

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices)==0: return 0 
        #最低买入价格
        min_price = max(prices)
        max_profit = 0
        for price in prices:
            if price<min_price:
                min_price = price
            elif price-min_price>max_profit:
                max_profit = price-min_price
        return max_profit
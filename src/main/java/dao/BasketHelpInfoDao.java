package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import model.Basket;
import model.BasketHelpInfo;

public class BasketHelpInfoDao {
	public ArrayList<BasketHelpInfo> getListOfBasketHelpInfo(Basket basket){
		
		ArrayList<BasketHelpInfo> baskets= new ArrayList<BasketHelpInfo>();
		ArticalDao articalDao = new ArticalDao();
		Iterator it = basket.getBoughtArticls().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        BasketHelpInfo basketHelpInfo = new BasketHelpInfo( articalDao.findById((Integer)pair.getKey()), (Double)pair.getValue());
	        baskets.add(basketHelpInfo); 
	        
	    }
		
		return baskets;
	}
	public double ukupnaCena(ArrayList<BasketHelpInfo> korpa) {
		double ukupna = 0;
		for(BasketHelpInfo help : korpa) {
			ukupna += help.getPrice();
		}
		return ukupna;
	}
}

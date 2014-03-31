import java.util.HashMap;
import java.util.Map;

public class Coffee extends MenuOptionsHelper {

	private Map<String, Integer> coffeeIngredients = new HashMap<String, Integer>();
	private PricesOfIngredients pricesOfIngredients = new PricesOfIngredients();
	private String item = COFFEE;
	
	public String getItemName() {
		return item;
	}


	Coffee(){
		setCoffeeIngredients();
	}

	public double calculateCost() {
		Map<String, Double> pricesMap = pricesOfIngredients.getPricesMap();
		double cost = 0.0;
		for (String ingredients : coffeeIngredients.keySet()) {

			int numberOfUnits = coffeeIngredients.get(ingredients);
			double unitPrice = pricesMap.get(ingredients);
			cost = cost + ((numberOfUnits) * unitPrice);
		}
		return cost;
	}

	public void setCoffeeIngredients() {

		coffeeIngredients.put(Ingredients.COFFEE, 3);
		coffeeIngredients.put(Ingredients.SUGAR, 1);
		coffeeIngredients.put(Ingredients.CREAM, 1);
	}

	public Map getIngredients() {

		return coffeeIngredients;
	}
}

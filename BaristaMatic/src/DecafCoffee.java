import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class DecafCoffee extends MenuOptionsHelper {

	private Map<String, Integer> decafcoffeeIngredients = new HashMap<String, Integer>();
	private PricesOfIngredients pricesOfIngredients = new PricesOfIngredients();
	private String item = DECAF_COFFEE;

	public String getItemName() {
		return item;
	}

	DecafCoffee() {
		setDecafCoffeeIngredients();
	}

	public double calculateCost() {
		Map<String, Double> pricesMap = pricesOfIngredients.getPricesMap();
		double cost = 0.0;
		for (String ingredients : decafcoffeeIngredients.keySet()) {

			int numberOfUnits = decafcoffeeIngredients.get(ingredients);
			double unitPrice = pricesMap.get(ingredients);
			cost = cost + ((numberOfUnits) * unitPrice);
		}
		DecimalFormat decForm = new DecimalFormat("#.###");
		return Double.valueOf(decForm.format(cost));
	}

	public void setDecafCoffeeIngredients() {

		decafcoffeeIngredients.put(Ingredients.DECAF_COFFEE, 3);
		decafcoffeeIngredients.put(Ingredients.SUGAR, 1);
		decafcoffeeIngredients.put(Ingredients.CREAM, 1);
	}

	public Map getIngredients() {

		return decafcoffeeIngredients;
	}
}

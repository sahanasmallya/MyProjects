import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Cappuccino extends MenuOptionsHelper {

	private Map<String, Integer> cappuccinoIngredients = new HashMap<String, Integer>();
	private PricesOfIngredients pricesOfIngredients = new PricesOfIngredients();
	private String item = CAPPUCCINO;

	public String getItemName() {
		return item;
	}

	Cappuccino() {
		setCappuccinoIngredients();
	}

	public double calculateCost() {
		Map<String, Double> pricesMap = pricesOfIngredients.getPricesMap();
		double cost = 0.0;
		for (String ingredients : cappuccinoIngredients.keySet()) {

			int numberOfUnits = cappuccinoIngredients.get(ingredients);
			double unitPrice = pricesMap.get(ingredients);
			cost = cost + ((numberOfUnits) * unitPrice);
		}
		DecimalFormat decForm = new DecimalFormat("#.###");
		return Double.valueOf(decForm.format(cost));
	}

	public void setCappuccinoIngredients() {

		cappuccinoIngredients.put(Ingredients.ESPRESSO, 2);
		cappuccinoIngredients.put(Ingredients.STEAMED_MILK, 1);
		cappuccinoIngredients.put(Ingredients.FOAMED_MILK, 1);
	}

	public Map getIngredients() {

		return cappuccinoIngredients;
	}
}

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CaffeAmericano extends MenuOptionsHelper {

	private Map<String, Integer> caffeAmericanoIngredients = new HashMap<String, Integer>();
	private PricesOfIngredients pricesOfIngredients = new PricesOfIngredients();
	private String item = CAFFE_AMERICANO;

	public String getItemName() {
		return item;
	}

	CaffeAmericano() {
		setCaffeAmericanoIngredients();
	}

	public double calculateCost() {
		Map<String, Double> pricesMap = pricesOfIngredients.getPricesMap();
		double cost = 0.0;
		for (String ingredients : caffeAmericanoIngredients.keySet()) {

			int numberOfUnits = caffeAmericanoIngredients.get(ingredients);
			double unitPrice = pricesMap.get(ingredients);
			cost = cost + ((numberOfUnits) * unitPrice);
		}
		DecimalFormat decForm = new DecimalFormat("#.###");
		return Double.valueOf(decForm.format(cost));
	}

	public void setCaffeAmericanoIngredients() {

		caffeAmericanoIngredients.put(Ingredients.ESPRESSO, 3);
	}

	public Map getIngredients() {

		return caffeAmericanoIngredients;
	}
}

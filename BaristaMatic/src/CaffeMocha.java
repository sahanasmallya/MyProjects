import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CaffeMocha extends MenuOptionsHelper {

	private Map<String, Integer> caffeMochaIngredients = new HashMap<String, Integer>();
	private PricesOfIngredients pricesOfIngredients = new PricesOfIngredients();
	private String item = CAFFE_MOCHA;

	public String getItemName() {
		return item;
	}

	CaffeMocha() {
		setCaffeMochaIngredients();
	}

	public double calculateCost() {
		Map<String, Double> pricesMap = pricesOfIngredients.getPricesMap();
		double cost = 0.0;
		for (String ingredients : caffeMochaIngredients.keySet()) {

			int numberOfUnits = caffeMochaIngredients.get(ingredients);
			double unitPrice = pricesMap.get(ingredients);
			cost = cost + ((numberOfUnits) * unitPrice);
		}
		DecimalFormat decForm = new DecimalFormat("#.###");
		return Double.valueOf(decForm.format(cost));
	}

	public void setCaffeMochaIngredients() {

		caffeMochaIngredients.put(Ingredients.ESPRESSO, 1);
		caffeMochaIngredients.put(Ingredients.COCOA, 1);
		caffeMochaIngredients.put(Ingredients.STEAMED_MILK, 1);
		caffeMochaIngredients.put(Ingredients.WHIPPED_CREAM, 1);

	}

	public Map getIngredients() {

		return caffeMochaIngredients;
	}
}

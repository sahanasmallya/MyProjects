import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CaffeLatte extends MenuOptionsHelper {

	private Map<String, Integer> caffeLatteIngredients = new HashMap<String, Integer>();
	private PricesOfIngredients pricesOfIngredients = new PricesOfIngredients();
	private String item = CAFFE_LATTE;

	public String getItemName() {
		return item;
	}

	CaffeLatte() {
		setCafeLatteIngredients();
	}

	public double calculateCost() {
		Map<String, Double> pricesMap = pricesOfIngredients.getPricesMap();
		double cost = 0.0;
		for (String ingredients : caffeLatteIngredients.keySet()) {

			int numberOfUnits = caffeLatteIngredients.get(ingredients);
			double unitPrice = pricesMap.get(ingredients);
			cost = cost + ((numberOfUnits) * unitPrice);
		}
		DecimalFormat decForm = new DecimalFormat("#.###");
		return Double.valueOf(decForm.format(cost));
	}

	public void setCafeLatteIngredients() {

		caffeLatteIngredients.put(Ingredients.ESPRESSO, 2);
		caffeLatteIngredients.put(Ingredients.STEAMED_MILK, 1);
		
	}

	public Map getIngredients() {

		return caffeLatteIngredients;
	}
}

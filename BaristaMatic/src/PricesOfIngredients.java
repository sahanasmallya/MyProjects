import java.util.HashMap;
import java.util.Map;

public class PricesOfIngredients {

	private Map<String, Double> pricesMap = new HashMap<>();

	public PricesOfIngredients() {
		setPricesMap() ;
	}

	public Map<String, Double> getPricesMap() {
		return this.pricesMap;
	}

	public void setPricesMap() {
		this.pricesMap.put(Ingredients.COCOA, COST_OF_COCOA_UNIT);
		this.pricesMap.put(Ingredients.COFFEE, COST_OF_COFFEE_UNIT);
		this.pricesMap.put(Ingredients.CREAM, COST_OF_CREAM_UNIT);
		this.pricesMap.put(Ingredients.DECAF_COFFEE, COST_OF_DECAF_COFFEE_UNIT);
		this.pricesMap.put(Ingredients.ESPRESSO, COST_OF_ESPRESSO_UNIT);
		this.pricesMap.put(Ingredients.FOAMED_MILK, COST_OF_FOAMED_MILK_UNIT);
		this.pricesMap.put(Ingredients.STEAMED_MILK, COST_OF_STEAMED_MILK_UNIT);
		this.pricesMap.put(Ingredients.SUGAR, COST_OF_SUGAR_UNIT);
		this.pricesMap.put(Ingredients.WHIPPED_CREAM,
				COST_OF_WHIPPED_CREAM_UNIT);

	}

	private double COST_OF_COCOA_UNIT = 0.90;
	private double COST_OF_COFFEE_UNIT = 0.75;
	private double COST_OF_CREAM_UNIT = 0.25;
	private double COST_OF_DECAF_COFFEE_UNIT = 0.75;
	private double COST_OF_ESPRESSO_UNIT = 1.10;
	private double COST_OF_FOAMED_MILK_UNIT = 0.35;
	private double COST_OF_STEAMED_MILK_UNIT = 0.35;
	private double COST_OF_SUGAR_UNIT = 0.25;
	private double COST_OF_WHIPPED_CREAM_UNIT = 1.00;

	public double getCOST_OF_COCOA_UNIT() {
		return COST_OF_COCOA_UNIT;
	}

	public double getCOST_OF_COFFEE_UNIT() {
		return COST_OF_COFFEE_UNIT;
	}

	public double getCOST_OF_CREAM_UNIT() {
		return COST_OF_CREAM_UNIT;
	}

	public double getCOST_OF_DECAF_COFFEE_UNIT() {
		return COST_OF_DECAF_COFFEE_UNIT;
	}

	public double getCOST_OF_ESPRESSO_UNIT() {
		return COST_OF_ESPRESSO_UNIT;
	}

	public double getCOST_OF_FOAMED_MILK_UNIT() {
		return COST_OF_FOAMED_MILK_UNIT;
	}

	public double getCOST_OF_STEAMED_MILK_UNIT() {
		return COST_OF_STEAMED_MILK_UNIT;
	}

	public double getCOST_OF_SUGAR_UNIT() {
		return COST_OF_SUGAR_UNIT;
	}

	public double getCOST_OF_WHIPPED_CREAM_UNIT() {
		return COST_OF_WHIPPED_CREAM_UNIT;
	}

}

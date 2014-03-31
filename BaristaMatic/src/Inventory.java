import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {

	private  Map<String, Integer> inventoryMap = new TreeMap<>();

	public Map<String, Integer> getInventoryMap() {
		return inventoryMap;
	}

	public Inventory() {
		setInventoryInitially();
	}

	public void setInventoryInitially() {
		inventoryMap.put(Ingredients.COCOA, 10);
		inventoryMap.put(Ingredients.COFFEE, 10);
		inventoryMap.put(Ingredients.CREAM, 10);
		inventoryMap.put(Ingredients.DECAF_COFFEE, 10);
		inventoryMap.put(Ingredients.ESPRESSO, 10);
		inventoryMap.put(Ingredients.FOAMED_MILK, 10);
		inventoryMap.put(Ingredients.STEAMED_MILK, 10);
		inventoryMap.put(Ingredients.SUGAR, 10);
		inventoryMap.put(Ingredients.WHIPPED_CREAM, 10);
	}

	public void updateInventory(String ingredient, int unitsConsumed) {
		if (inventoryMap.containsKey(ingredient)) {
			int unitsRemaining = inventoryMap.get(ingredient) - unitsConsumed;
			inventoryMap.put(ingredient, unitsRemaining);
		} else {
			try {
				throw new Exception("Invalid entry into the inventories ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

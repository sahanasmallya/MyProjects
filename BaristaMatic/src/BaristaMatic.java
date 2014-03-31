import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaristaMatic {

	Inventory inventory = new Inventory();
	Map<String, Integer> inventoryMap = new TreeMap<String, Integer>();


	BaristaMatic() {
		setInventoryMap(getInventoryMap());
	}

	public void setInventoryMap(Map<String, Integer> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}

	public Map<String, Integer> getInventoryMap() {
		return inventory.getInventoryMap();
	}

	private void listMenu(boolean isStartUp) {
		boolean isAvail = true;
		System.out.println("-------------------------------------------------");
		System.out.println("Menu:");
		System.out.println("-------------------------------------------------");
		MenuOptionsHelper menuOptionsHelper = new MenuOptionsHelper();
		for (int i = 1; i <= 6; i++) {
			isAvail = true;
			menuOptionsHelper.setChoiceMade(i);
			MenuOptions menuOptions = menuOptionsHelper.getChoicesImpl();
			double cost = menuOptions.calculateCost();
			Map<String, Integer> ingredientsMap = menuOptions.getIngredients();

			for (String ingredient : ingredientsMap.keySet()) {
				if (inventoryMap.containsKey(ingredient)) {
					if (inventoryMap.get(ingredient) < ingredientsMap
							.get(ingredient) && !isStartUp)
						isAvail = false;

				}

			}

			System.out.print(i + "," + menuOptions.getItemName() + ",$" + cost
					+ "," + isAvail + "\n");

		}

	}

	private void listInventory() {

		System.out.println("Inventory:");
		System.out
				.println("--------------------------------------------------");
		for (String inventory : inventoryMap.keySet()) {
			System.out.print(inventory + ", " + inventoryMap.get(inventory)
					+ "\n");

		}
	}

	public static void main(String[] args) {
		BaristaMatic baristaMatic = new BaristaMatic();
		baristaMatic.listInventory();
		baristaMatic.listMenu(true);
		baristaMatic.getUserInput();

	}

	private void getUserInput() {
		System.out.println("--------------------------------------------");
		List<String> outOfStockDrinks = new ArrayList();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		BaristaMatic baristaMatic = new BaristaMatic();
		try {
			String key = "";
			int option = 0;
			List<String> allowableCommands = getAllowableChoicesList();
			while (((key = bufferedReader.readLine()) != null)) {
				if (!allowableCommands.contains(key)) {
					System.out.println("Invalid selection:" + "<" + key + ">");
					baristaMatic.listInventory();
					baristaMatic.listMenu(false);
					continue;
				}
				if (!key.equalsIgnoreCase("r")&&!key.equalsIgnoreCase("q"))
					option = Integer.parseInt(key);

				if (key.equalsIgnoreCase("r")) {
					baristaMatic.refillInventory();
					baristaMatic.listInventory();
					baristaMatic.listMenu(true);
				} else if ((key.equalsIgnoreCase("q"))) {
					outOfStockDrinks.clear();
					baristaMatic.processInventoryUpdate(option,outOfStockDrinks);
					baristaMatic.listMenu(false);
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}


	private void refillInventory() {
		inventory.setInventoryInitially();
	}

	private List<String> getAllowableChoicesList() {
		List<String> myList = new ArrayList();
		for (int i = 1; i <= 6; i++)
			myList.add("" + i);
		myList.add("q");
		myList.add("r");
		myList.add("Q");
		myList.add("R");
		return myList;
	}

	private void processInventoryUpdate(int option, List<String> outOfStockDrinks) {
		int unitsRemaining = 0;
		MenuOptionsHelper menuOptionsHelper = new MenuOptionsHelper();
		menuOptionsHelper.setChoiceMade(option);
		menuOptionsHelper = (MenuOptionsHelper) menuOptionsHelper
				.getChoicesImpl();
		Map<String, Integer> ingredientsMap = menuOptionsHelper
				.getIngredients();
		BaristaMatic baristaMatic = new BaristaMatic();
		baristaMatic.listInventory();
		System.out.println("-----------------------------------------------");
		baristaMatic.listMenu(true);
		if (outOfStockDrinks.contains(menuOptionsHelper.getItemName())){
			System.out.println("Out of stock:" + "<"
					+ menuOptionsHelper.getItemName() + ">");
		System.out.println("-----------------------------------------------");
		}
		else{
		System.out.println("Dispensing:" + menuOptionsHelper.getItemName()
				+ "\n-----------------------------------------------");
		}
		System.out.println("Inventory-----------------------------------------------");
		for (String ingredient : ingredientsMap.keySet()) {
			if (inventoryMap.containsKey(ingredient)) {
				if (inventoryMap.get(ingredient) >= ingredientsMap
						.get(ingredient)) {
					unitsRemaining = inventoryMap.get(ingredient)
							- ingredientsMap.get(ingredient);
					inventoryMap.put(ingredient, unitsRemaining);
				} else if (!outOfStockDrinks.contains(menuOptionsHelper
						.getItemName())) {
					outOfStockDrinks.add(menuOptionsHelper.getItemName());
					System.out.println("Out of stock:" + "<"
							+ menuOptionsHelper.getItemName() + ">");
					System.out
							.println("-----------------------------------------------");
				}
			}
		}

		for (String inventory : inventoryMap.keySet()) {
			System.out.print(inventory + ", " + inventoryMap.get(inventory)
					+ "\n");

		}
		baristaMatic.setInventoryMap(inventoryMap);
	}
}

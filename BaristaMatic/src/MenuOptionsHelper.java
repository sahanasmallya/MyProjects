import java.util.Map;
import java.util.TreeMap;

public class MenuOptionsHelper implements MenuOptions {

	int choiceMade = 0;
	MenuOptionsHelper menuOptionsHelper;
	Map<Integer, String> optionNumbers = new TreeMap();

	public int getChoiceMade() {
		return choiceMade;
	}

	public void setChoiceMade(int choiceMade) {
		this.choiceMade = choiceMade;
	}

	public MenuOptions getChoicesImpl() {

		if (choiceMade == 1)
			menuOptionsHelper = new CaffeAmericano();
		if (choiceMade == 2)
			menuOptionsHelper = new CaffeLatte();
		if (choiceMade == 3)
			menuOptionsHelper = new CaffeMocha();
		if (choiceMade == 4)
			menuOptionsHelper = new Cappuccino();
		if (choiceMade == 5)
			menuOptionsHelper = new Coffee();
		if (choiceMade == 6)
			menuOptionsHelper = new DecafCoffee();
		return menuOptionsHelper;
	}

	public double calculateCost() {
		return menuOptionsHelper.calculateCost();
	}

	public void setOptionNumbers() {
		optionNumbers.put(1, CAFFE_AMERICANO);
		optionNumbers.put(2, CAFFE_LATTE);
		optionNumbers.put(3, CAFFE_MOCHA);
		optionNumbers.put(4, CAPPUCCINO);
		optionNumbers.put(5, COFFEE);
		optionNumbers.put(6, DECAF_COFFEE);

	}

	@Override
	public String getItemName() {
		return "";
	}

	@Override
	public Map<String, Integer> getIngredients() {
		return null;
	}
}

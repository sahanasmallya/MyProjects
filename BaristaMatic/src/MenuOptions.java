import java.util.Map;


public interface MenuOptions {

	String CAFFE_AMERICANO = "Caffe Americano";
	String CAFFE_LATTE = "Caffe Latte";
	String CAFFE_MOCHA = "Caffe Mocha";
	String CAPPUCCINO = "Cappuccino";
	String COFFEE = "Coffee";
	String DECAF_COFFEE = "Decaf Coffee";
	
	MenuOptions getChoicesImpl();
	double calculateCost();
	void setOptionNumbers();
	String getItemName();
	Map<String,Integer> getIngredients();
	
}

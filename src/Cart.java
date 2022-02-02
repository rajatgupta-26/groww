import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {

    Map<Product, Double> selectedProducts = new ConcurrentHashMap<>();

    public void updateItemsToCart(Product product, Double quantity, Operations operations) throws Exception{
        switch (operations){
            case REMOVE:
                if(!selectedProducts.containsKey(product) || selectedProducts.get(product) < quantity){
                    throw new Exception("Invalid quantity update");
                }
                break;
            case ADD:
                selectedProducts.put(product, selectedProducts.getOrDefault(product, 0D) +quantity);
        }

    }

    public Map<Product, Double> getCart(){
        return selectedProducts;
    }
}

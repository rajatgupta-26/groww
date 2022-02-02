import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private static final Map<Product, Double> inventory = new ConcurrentHashMap<>();

    void updateInventory(Product product, Double quantity, Operations operation) throws Exception{
        switch(operation){
            case ADD:
                inventory.put(product, inventory.getOrDefault(product, 0D) + quantity);
                break;
            case REMOVE:
                if(!inventory.containsKey(product) || inventory.get(product) < quantity){
                    throw new Exception(" invalid inventory");
                }
                inventory.put(product, inventory.get(product)-quantity);
                break;
        }
    }

    public void showCurrentInventory(){
        System.out.println("Name | Price | Available Quantity" );
        for(Product product : inventory.keySet()){
            System.out.println(product.getName() + " | " + product.getPrice() + " | " + inventory.get(product));
        }
    }

    public Map<Product, Double> getInventory(){
        return inventory;
    }

    void addItemsToInventoryInBulk(Map<Product, Double> items) throws Exception{
        for(Product item : items.keySet()){
            updateInventory(item, items.get(item), Operations.ADD);
        }
        System.out.println("Bulk update of inventory successful ");
    }



}

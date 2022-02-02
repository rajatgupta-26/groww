import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Driver {
    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) throws Exception {
        Product p1 = createProduct("p1", Denomination.FIVE);
        Map<Product, Double> addItems = new ConcurrentHashMap<>();
        addItems.put(p1, 10.0);
        addItems.put(createProduct("p2", Denomination.TEN),  20.0);
        addItems.put(createProduct("p3", Denomination.HUNDRED),  6.0);

        inventory.addItemsToInventoryInBulk(addItems);

        inventory.showCurrentInventory();

        inventory.updateInventory(p1, 3D, Operations.REMOVE);

        inventory.updateInventory(p1, 60D, Operations.ADD);

        inventory.showCurrentInventory();
    }

    static Product createProduct(String name, Denomination price){
        return new Product(name, price);
    }

}

public class Product {

    private String name;
    private Denomination price;

    public Product(String name, Denomination price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price.getValue();
    }

    public String getName(){
        return name;
    }
}

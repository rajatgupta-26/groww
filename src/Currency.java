import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Currency {

    private static final Map<Denomination, Double> currency_inventory = new HashMap<>();

    public void updateCurrency(Denomination denomination, Double count, Operations operations) throws Exception {
        switch(operations){
            case ADD:
                currency_inventory.put(denomination, currency_inventory.getOrDefault(denomination, 0.0) + count);
                break;
            case REMOVE:
                if(!currency_inventory.containsKey(denomination) || currency_inventory.get(denomination) < count){
                    throw new Exception("Currency to sufficient to carry on transaction");
                }
                currency_inventory.put(denomination, currency_inventory.get(denomination)-count);
                break;
        }
    }


    public void calculateCurrency(Map<Denomination, Double> userInput, Map<Product, Double> selectedProducts) throws Exception {
        double providedAmount = 0.0;
        double requiredAmount = 0.0;

        for(Denomination denomination : userInput.keySet()){
            providedAmount += denomination.getValue() * userInput.get(denomination);
        }

        for(Product product : selectedProducts.keySet()){
            requiredAmount += product.getPrice() * selectedProducts.get(product);
        }

        if(requiredAmount > providedAmount){
            throw new Exception("Amount Provided is less ");
        }

        if(providedAmount == requiredAmount){

            for(Denomination denomination : userInput.keySet()){
                updateCurrency(denomination, userInput.get(denomination), Operations.ADD);
            }

            System.out.println(" Inventory updated successfully. Transaction complete!!");
            return;
        }

        double returnAmount = providedAmount-requiredAmount;

        // return money is not there - Error
        // rest all - Success

//        ArrayList<Double> denomiantions = new ArrayList<>();
//        for(Denomination d : Denomination.values()){
//            denomiantions.add(d.getValue());
//        }
//        Collections.sort(denomiantions, Collections.reverseOrder());
//
//        Map<Double, Double> returnMoney = new HashMap<>();
//
//        for(double d: denomiantions){
//            if(d <= requiredAmount){
//                returnMoney.put(d, returnAmount / d);
//                requiredAmount %= d;
//            }
//        }
//
//        if(requiredAmount > 0){
//            throw new Exception("Can't fullfil transcaction with given currency");
//        }
//
//
//        Map<Denomination, Double> denominationDoubleMap = calculateReturnCurrency(returnAmount);




    }

    private Map<Denomination, Double> calculateReturnCurrency(double returnAmount) {
        return null;
    }

}

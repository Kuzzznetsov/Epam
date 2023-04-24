package Inner.Model;

import Inner.Exeption.NegativeArgumentException;
import Inner.Exeption.PatternArgumentException;
import Inner.Exeption.PositiveArgumentException;

public class Purchase {
    private final Product product;
    private final int unitsNumber;

    public Purchase(Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = correctUnitsNumber(unitsNumber);
        getCost(unitsNumber, product);
    }
    public Purchase(Product product, String unitsNumber) {
        this.product = product;
        this.unitsNumber = correctUnitsNumber(unitsNumber);
        getCost(this.unitsNumber, product);
    }

    public static int correctUnitsNumber(String unitsNumber){
        int temp = 0;
        if(!(unitsNumber.matches("\\d+"))){
           throw new PatternArgumentException(unitsNumber);
        }else {
            temp = Integer.parseInt(unitsNumber);
            correctUnitsNumber(temp);
        }
        return temp;
    }

    public static int correctUnitsNumber(int unitsNumber){
        if(unitsNumber<0){
            throw new NegativeArgumentException(unitsNumber+"", "unitsNumber" );
        }
        return unitsNumber;
    }

    public void getCost(int unitsNumber, Product product){
        long sum = (long) unitsNumber * product.getPrice().getValue();
        if(sum > Integer.MAX_VALUE){
           throw new PositiveArgumentException(Integer.MAX_VALUE+"", sum+"", product.getName());
        }
    }

    @Override
    public String toString() {
        return  product + ";" + unitsNumber;
    }
}

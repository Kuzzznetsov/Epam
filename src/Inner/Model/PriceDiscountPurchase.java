package Inner.Model;

import Inner.Exeption.NegativeArgumentException;
import Inner.Exeption.PatternArgumentException;
import Inner.Exeption.PositiveArgumentException;

public class PriceDiscountPurchase extends Purchase {

    private int discount;


    public PriceDiscountPurchase(Product product, int unitsNumber, int discount) {
        super(product, unitsNumber);
        this.discount = isVoledDiscount(discount,product);
        getCost(unitsNumber,product);
    }

    public PriceDiscountPurchase(Product product, String unitsNumber, String discount) {
        super(product, unitsNumber);
        this.discount = getValidValue(discount,product);
        getCost(unitsNumber,product);
    }

    public static int getValidValue (String str, Product product) {
        int sum = 0;
        if (!(str.matches("\\d+\\.\\d\\d"))){
            throw new PatternArgumentException(str);
        }
        else {
            String[] temp = str.split("\\.");
            sum = Integer.parseInt(temp[0])*100 + Integer.parseInt(temp[1]);
            isVoledDiscount(sum, product);
        }
        return sum;
    }

    public void getCost(String unitsNumber, Product product){
        long sum = (long)Integer.parseInt(unitsNumber) * (product.getPrice().getValue() - this.discount);
        if(sum > Integer.MAX_VALUE){
            throw new PositiveArgumentException(Integer.MAX_VALUE+"", sum+"", product.getName());
        }
    }
    @Override
    public void getCost(int unitsNumber, Product product){
        long sum = (long) unitsNumber * (product.getPrice().getValue() - this.discount);
        if(sum > Integer.MAX_VALUE){
            throw new PositiveArgumentException(Integer.MAX_VALUE+"", sum+"", product.getName());
        }
    }

    public static int isVoledDiscount (int discount, Product product) {
        if(discount < 0 ){
            throw new NegativeArgumentException("discount ",""+discount);
        }
        if(discount > product.getPrice().getValue()){
            throw new PositiveArgumentException(product.getPrice().getValue()+"", discount+"", "discount" );
        }
        return discount;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + discount;
    }
}

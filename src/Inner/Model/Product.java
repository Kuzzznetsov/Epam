package Inner.Model;

import Inner.Exeption.NegativeArgumentException;
import Inner.Exeption.PatternArgumentException;

public class Product {
    private final String name;
    private final Byn price;

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public  Product(String name, Byn price) {
        this.name = correctName(name);
        this.price = correctPrice(price);
    }

    public static Byn correctPrice(Byn price) {
        if (price.getValue() < 0) {
            throw new NegativeArgumentException(price.getValue() + "", "Coins");
        }
        return price;
    }

    public static String correctName(String name){
        if(!(name.matches("[a-zA-Z]+"))){
            throw new PatternArgumentException(name);
        }
        return name;
    }

    @Override
    public String toString() {
        return "name - " + name + ", price - " + price;
    }
}

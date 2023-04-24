package Inner.Model;

import Inner.Exeption.CoinsOutBountOfExeption;
import Inner.Exeption.NegativeArgumentException;
import Inner.Exeption.PatternArgumentException;
import Inner.Exeption.PositiveArgumentException;


public class Byn {
    final int value;

    public int getValue() {
        return value;
    }

    public Byn(int value) {
        if (value < 0) {
            throw new NegativeArgumentException( value +"", "coins" );
        }
        this.value = value;
    }

    public Byn(Byn byn){
        this(byn.getValue());
    }
    public Byn(int rubs, int coins){
        this(getValidValue(rubs,coins));
    }
    public Byn(String strByn){
        this(getValidValue(strByn));
    }

    public static int getValidValue (String str) {
       if (!(str.matches("\\d+\\.\\d\\d"))){
           throw new PatternArgumentException(str);
       }
       else {
           String[] temp = str.split("\\.");
           int sum = getValidValue(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
           return sum;
       }
    }


    private static int getValidValue(int rubs, int coins){
        if(rubs < 0){
            throw new NegativeArgumentException(rubs + "", " rubs");
        }
        if(coins < 0){
            throw new NegativeArgumentException(coins + "", "coins");
        }
        if(coins > 99){
            throw new CoinsOutBountOfExeption(coins + "");
        }
        long max = rubs * 100L + coins;
        if(max > Integer.MAX_VALUE){
            throw new PositiveArgumentException("coins", Integer.MAX_VALUE+"", max+"" );
        }
        return (int)max;
    }

    @Override
    public String toString() {
        return "value= " + value;
    }
}

package Inner.Exeption;

import Inner.Model.Byn;

public class NegativeArgumentException extends IllegalArgumentException{

    public NegativeArgumentException(String value, String sObject) {
        super(sObject + " should be more than 0, but your value is " + value);
    }
}

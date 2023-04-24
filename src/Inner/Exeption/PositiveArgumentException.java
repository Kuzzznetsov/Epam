package Inner.Exeption;

public class PositiveArgumentException extends IllegalArgumentException{
    public PositiveArgumentException(String max, String value,  String s) {
        super(s + " should be less than " + max + " but your value is " + value);
    }
}

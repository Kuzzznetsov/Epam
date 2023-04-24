package Inner.Exeption;

public class PatternArgumentException extends IllegalArgumentException{

    public PatternArgumentException (String str){
       super(str + "String does not match");
    }
}

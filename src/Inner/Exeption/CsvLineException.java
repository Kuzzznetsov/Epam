package Inner.Exeption;

public class CsvLineException  extends IllegalArgumentException{
    public CsvLineException (String str){
        super(str + "Values does not match");
    }
}

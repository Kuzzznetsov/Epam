package Inner.Exeption;

public class CoinsOutBountOfExeption extends IllegalArgumentException{
    public CoinsOutBountOfExeption(String s) {
        super(s + "Can not be more then 100");
    }
}

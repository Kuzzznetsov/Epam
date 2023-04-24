package Inner.Model;

import Inner.Exeption.PatternArgumentException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class WrapperDate {

    private Date date;

    public Date getDate() {
        return date;
    }

    public WrapperDate(String date) {
        this.date = correctData(date);
    }

    public Date correctData(String str){
        if(str.matches("^(18|19|20)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")){
            DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
            try {
                Date date = formatter.parse(str);
                return date;
            } catch (ParseException e ){
                return null;
            }
        }else{
            throw new PatternArgumentException(str);
        }
    }

    public String convert (Date date){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        return format1.format(date);
    }

    public DayOfWeek dayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int temp =  calendar.get(Calendar.DAY_OF_WEEK);
        if(temp == 1) {
            return DayOfWeek.of(7);
        }
        return DayOfWeek.of(temp-1);
    }

    @Override
    public String toString() {
        return "date = " + convert(date) ;
    }
}

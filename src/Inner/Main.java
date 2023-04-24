package Inner;

import Inner.Exeption.CsvLineException;
import Inner.Exeption.PatternArgumentException;
import Inner.Model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Map<DayOfWeek, List<Purchase>> dayPurchasesMap = new EnumMap<>(DayOfWeek.class);
        //Map <DayOfWeek , Purchase> firstPurchasesMap = new HashMap<>();
        List<WrapperEntry> wrapperEntryList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("File"));
        String string = "";
        while (((string = bufferedReader.readLine())) != null) {
            try {
                WrapperEntry wrapperEntry = WrapperEntry.gerValidEntry(string);
                wrapperEntryList.add(wrapperEntry);
            } catch (CsvLineException | PatternArgumentException e) {
                System.out.println(e);
            }
        }

        for (int i = 0; i < wrapperEntryList.size(); i++) {
            if(!(dayPurchasesMap.containsKey(wrapperEntryList.get(i).getDate().dayOfWeek()))){
                List<Purchase> purchaseList = new ArrayList<>();
                purchaseList.add(wrapperEntryList.get(i).getPurchase());
                dayPurchasesMap.put(wrapperEntryList.get(i).getDate().dayOfWeek(), purchaseList);
            } else {
                List<Purchase> day = dayPurchasesMap.get(wrapperEntryList.get(i).getDate().dayOfWeek());
                day.add(wrapperEntryList.get(i).getPurchase());
                dayPurchasesMap.replace(wrapperEntryList.get(i).getDate().dayOfWeek(), day);
            }
        }
        for (Map.Entry<DayOfWeek, List<Purchase>> s  :dayPurchasesMap.entrySet()){
            System.out.println(s);
        }
    }
}

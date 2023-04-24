package Inner.Model;

import Inner.Exeption.CsvLineException;

import java.text.ParseException;

public class WrapperEntry {
    private final WrapperDate date;
    private final Purchase purchase;

    public WrapperDate getDate() {
        return date;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public WrapperEntry(WrapperDate date, Purchase purchase) {
        this.date = date;
        this.purchase = purchase;
    }

    public static WrapperEntry gerValidEntry(String csv) throws CsvLineException {
        String[] values = csv.split(";", 2);
        if (values.length < 2) {
            throw new CsvLineException(csv);
        }
        WrapperDate date1 = new WrapperDate(values[0]);
        Purchase purchase1 = PurchasesFactory.getPurchaseFromFactory(values[1]);
        return new WrapperEntry(date1,purchase1);
    }

    @Override
    public String toString() {
        return "WrapperEntry{" +
                "date=" + date +
                ", purchase=" + purchase +
                '}';
    }
}

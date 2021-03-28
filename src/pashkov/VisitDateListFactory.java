package pashkov;

import java.time.LocalDate;
import java.util.*;

public class VisitDateListFactory extends VisitDate {

    private final List<VisitDate> visitDateList = new ArrayList<>();
    private final Random RD = new Random();

    public List<VisitDate> addDates() {
        VisitDate visitDate1 = new VisitDate((LocalDate.of(2020, 8, 12)),
                (LocalDate.of(2020, 9, 30)));
        visitDateList.add(visitDate1);
        VisitDate visitDate2 = new VisitDate((LocalDate.of(2020, 11, 9)),
                (LocalDate.of(2020, 12, 12)));
        visitDateList.add(visitDate2);
        VisitDate visitDate4 = new VisitDate((LocalDate.of(2021, 2, 12)),
                (LocalDate.of(2021, 2, 15)));
        visitDateList.add(visitDate4);
        VisitDate visitDate3 = new VisitDate((LocalDate.of(2021, 1, 4)),
                (LocalDate.of(2021, 1, 12)));
        visitDateList.add(visitDate3);
        VisitDate visitDate5 = new VisitDate((LocalDate.of(2021, 3, 12)),
                (LocalDate.of(2021, 3, 18)));
        visitDateList.add(visitDate5);
        VisitDate visitDate6 = new VisitDate((LocalDate.of(2021, 3, 25)));
        visitDateList.add(visitDate6);
        visitDateList.sort(new Comparator<VisitDate>() {
            @Override
            public int compare(VisitDate o1, VisitDate o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });
        return visitDateList;
    }

    public List<VisitDate> getVisitDateList() {
        return visitDateList;
    }
}

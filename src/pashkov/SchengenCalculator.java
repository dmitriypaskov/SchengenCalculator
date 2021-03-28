package pashkov;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SchengenCalculator {

    private final int schengenWindowDuration = 180;
    private final LocalDate windowClosing = LocalDate.now();
    private final LocalDate openingWindow = LocalDate.now().minusDays(schengenWindowDuration);
    private final VisitDateListFactory visitList = new VisitDateListFactory();

    public void calculateDays() {
        visitList.addDates();
        int sumOfDays = 0;
        if (!(visitList.getVisitDateList() == null)) {
            int visitDaysCount;
            for (int i = 0; i < visitList.getVisitDateList().size(); i++) {
                if (visitList.getVisitDateList().get(visitList.getVisitDateList().size() - 1).getFinish() == null) {
                    visitList.getVisitDateList().get(visitList.getVisitDateList().size() - 1).setFinish(windowClosing);
                } else if (visitList.getVisitDateList().get(i).getStart() == null ||
                        visitList.getVisitDateList().get(i).getFinish() == null) {
                    throw new IllegalArgumentException("Invalid dates, date field is empty");
                } else if (ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getStart(),
                        visitList.getVisitDateList().get(i).getFinish()) < 0) {
                    throw new IllegalArgumentException("Incorrect dates check-in date must be less than check-out date");
                } else if (ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getStart(), windowClosing) < 0 ||
                        ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getFinish(), windowClosing) < 0) {
                    throw new IllegalArgumentException("Wrong date, date has not come yet");
                }
                if (ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getFinish(), openingWindow) > 0) {
                    continue;
                } else if (ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getFinish(), openingWindow) < 0 &&
                        ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getStart(), openingWindow) > 0) {
                    visitDaysCount = (int) ChronoUnit.DAYS.between(openingWindow,
                            visitList.getVisitDateList().get(i).getFinish());
                } else {
                    visitDaysCount = (int) ChronoUnit.DAYS.between(visitList.getVisitDateList().get(i).getStart(),
                            visitList.getVisitDateList().get(i).getFinish());
                }
                sumOfDays += visitDaysCount;
            }
            if (schengenWindowDuration / 2 >= sumOfDays) {
                System.out.println("The tourist is in the territory of the EU by law. Days left : " +
                        (schengenWindowDuration / 2 - sumOfDays));
            } else System.out.println("It is illegal for a person to stay in the EU. For " +
                    Math.abs(schengenWindowDuration / 2 - sumOfDays) + " days .");
        }
    }
}

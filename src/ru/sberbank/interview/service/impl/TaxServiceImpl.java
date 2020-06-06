package ru.sberbank.intertview.service.impl;

import ru.sberbank.intertview.Range;
import ru.sberbank.intertview.service.TaxService;

import java.util.List;

public class TaxServiceImpl implements TaxService {

    /* Диапазоны
     * от 0 до 10 тыс = 10%
     *
     * от 10 тыс до 50 тыс = 20%
     *
     * выше 50 тыс = 25%
     *
     *
     * 15000:
     * 1) 10 тыс = 10%
     * 2) 5 тыс = 20%
     *
     *
     * 60000:
     * 1) 10 тыс = 10% - 1000
     * 2) 40 тыс = 20% - 8000
     * 3) 10 тыс = 25% - 2500
     * */

    private List<Range> rangeList;

    public TaxServiceImpl(List<Range> rangeList) {
        this.rangeList = rangeList;
    }

    @Override
    public double getTax(double salary) {

        /*
         * Range 1: 0 to 10
         * Salary: 60
         * result = 10 * percent
         *
         *
         * Range 2: 10 to 50
         * Salary: 60
         * result = (end - start) * percent
         *
         *
         * Range 3: 50 ....
         * result = (salary - start) * percent
         *
         * */

        return rangeList
                .stream()
                .filter(range -> isAcceptableRange(salary, range))
                .map(range -> getTaxForRange(salary, range))
                .reduce(Double::sum)
                .get();
    }

    private boolean isAcceptableRange(double salary, Range range) {
        return salary - range.getStart() > 0;
    }

    private Double getTaxForRange(double salary, Range range) {
        if (range.getEnd() - range.getStart() < salary) {
            return (range.getEnd() - range.getStart()) * range.getPercent();
        } else {
            return (salary - range.getStart()) * range.getPercent();
        }
    }
}

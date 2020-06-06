package ru.sberbank.interview;

import ru.sberbank.interview.model.Range;
import ru.sberbank.intertview.service.TaxService;
import ru.sberbank.interview.service.impl.TaxServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.POSITIVE_INFINITY;

public class Main {

    public static void main(String[] args) {

        List<Range> rangeList = new ArrayList<>();
        rangeList.add(new Range(0, 10000, 0.1));
        rangeList.add(new Range(10000, 50000, 0.2));
        rangeList.add(new Range(50000, POSITIVE_INFINITY, 0.25));

        TaxService taxService = new TaxServiceImpl(rangeList);

        System.out.println(taxService.getTax(5000));
        System.out.println(taxService.getTax(15000));
        System.out.println(taxService.getTax(60000));
        System.out.println(taxService.getTax(70000));

    }
}

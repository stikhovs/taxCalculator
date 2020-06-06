package ru.sberbank.intertview;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Range {

    private final double start;
    private final double end;
    private final double percent;

}

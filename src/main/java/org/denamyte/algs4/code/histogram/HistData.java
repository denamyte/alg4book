package org.denamyte.algs4.code.histogram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class HistData {

    private final Collection<HistUnit> data;

    @Data
    @AllArgsConstructor
    public static class HistUnit {
        private final String caption;
        private final int value;
    }

}

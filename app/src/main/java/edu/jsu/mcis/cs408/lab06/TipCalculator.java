package edu.jsu.mcis.cs408.lab06;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TipCalculator {
    public static BigDecimal calculateTip (BigDecimal bill, BigDecimal tip, BigDecimal people) {
        return bill.multiply(tip.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)
                .add(BigDecimal.valueOf(1))).divide(people, 2, RoundingMode.HALF_UP);
    }
}
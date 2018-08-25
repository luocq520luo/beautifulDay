package com.find.job.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberUtils {
    private NumberUtils() {

    }

    public static Double round(Double number) {
        return round(number, 2);
    }

    public static Double round(String number) {
        if (number == null) {
            return 0d;
        } else {
            return round(Double.valueOf(number), 2);
        }
    }

    public static Double round(Double number, int scale) {
        if (number == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(number).setScale(scale, BigDecimal.ROUND_HALF_UP);
        return decimal.doubleValue();
    }

    public static Double floor(Double number) {
        return floor(number, 2);
    }

    public static Double floor(Double number, int scale) {
        if (number == null) {
            return null;
        }
        BigDecimal decimal = new BigDecimal(number).setScale(scale, BigDecimal.ROUND_FLOOR);
        return decimal.doubleValue();
    }

    public static Double holdScaleDecimal(Double number, int scale) {
        if (number == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(scale);
        df.setGroupingSize(0);
        df.setRoundingMode(RoundingMode.FLOOR);
        return Double.valueOf(df.format(number));
    }

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return
     */
    public static String getRandomFileName(String type) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        int temp = (int) (Math.random() * 100000);
        while (temp / 10000 < 1) {
            temp = (int) (Math.random() * 100000);
        }
        return type + sf.format(date) + temp;
    }

    /**
     * 不足半个算半个，大于半个算一个
     *
     * @param d
     * @return
     */
    public static Double halfOrOne(Double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        Double flag = d % d.intValue();
        if (Double.isNaN(flag) || Double.isInfinite(flag)) {
            return d;
        }
        Double result;
        if (flag < 0.0001d) {
            result = d;
        } else if (Math.abs(flag - 0.5) < 0.0001d) {
            result = d;
        } else if (flag > 0.5) {
            result = d - d % d.intValue() + 1;
        } else {
            result = d - d % d.intValue() + 0.5;
        }
        return round(result, 1);
    }
}

package com.just.see.justsee.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiyoung on 2016/7/9.
 *
 */
public class DateFormat {

    /**
     * second -
     *
     * @param date
     * @return
     */
    public static String forMatDate(String date) {
        Date mdate = new Date(Long.parseLong(date) * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(mdate);
    }
}

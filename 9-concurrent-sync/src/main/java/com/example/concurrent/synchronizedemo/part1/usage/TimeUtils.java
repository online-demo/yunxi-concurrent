package com.example.concurrent.synchronizedemo.part1.usage;
import	java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-07-22 19:57
 * @Description: 当前时间
 */
public class TimeUtils {
    public static String currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}

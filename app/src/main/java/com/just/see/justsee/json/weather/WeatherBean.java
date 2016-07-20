package com.just.see.justsee.json.weather;

import java.util.List;

/**
 * Created by xiyoung on 2016/7/11.
 */
public class WeatherBean {

    /**
     * resultcode : 200
     * reason : 查询成功!
     * result : {"sk":{"temp":"21","wind_direction":"西风","wind_strength":"2级","humidity":"4%","time":"14:25"},"today":{"city":"天津","date_y":"2014年03月21日","week":"星期五","temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","dressing_index":"较冷","dressing_advice":"建议着大衣、呢外套加毛衣、卫衣等服装。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"适宜","exercise_index":"较适宜","drying_index":""},"future":[{"temperature":"28℃~36℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"南风3-4级","week":"星期一","date":"20140804"},{"temperature":"28℃~36℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"东南风3-4级","week":"星期二","date":"20140805"},{"temperature":"27℃~35℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"东南风3-4级","week":"星期三","date":"20140806"},{"temperature":"27℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4级","week":"星期四","date":"20140807"},{"temperature":"27℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东北风4-5级","week":"星期五","date":"20140808"},{"temperature":"26℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"北风4-5级","week":"星期六","date":"20140809"},{"temperature":"26℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"北风4-5级","week":"星期日","date":"20140810"}]}
     * error_code : 0
     */

    public String resultcode;
    public String reason;
    /**
     * sk : {"temp":"21","wind_direction":"西风","wind_strength":"2级","humidity":"4%","time":"14:25"}
     * today : {"city":"天津","date_y":"2014年03月21日","week":"星期五","temperature":"8℃~20℃","weather":"晴转霾","weather_id":{"fa":"00","fb":"53"},"wind":"西南风微风","dressing_index":"较冷","dressing_advice":"建议着大衣、呢外套加毛衣、卫衣等服装。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"适宜","exercise_index":"较适宜","drying_index":""}
     * future : [{"temperature":"28℃~36℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"南风3-4级","week":"星期一","date":"20140804"},{"temperature":"28℃~36℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"东南风3-4级","week":"星期二","date":"20140805"},{"temperature":"27℃~35℃","weather":"晴转多云","weather_id":{"fa":"00","fb":"01"},"wind":"东南风3-4级","week":"星期三","date":"20140806"},{"temperature":"27℃~34℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4级","week":"星期四","date":"20140807"},{"temperature":"27℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东北风4-5级","week":"星期五","date":"20140808"},{"temperature":"26℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"北风4-5级","week":"星期六","date":"20140809"},{"temperature":"26℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"北风4-5级","week":"星期日","date":"20140810"}]
     */

    public Result result;
    public int error_code;

    public static class Result {
        @Override
        public String toString() {
            return "Result{" +
                    "sk=" + sk +
                    ", today=" + today +
                    ", future=" + future +
                    '}';
        }

        /**
         * temp : 21
         * wind_direction : 西风
         * wind_strength : 2级
         * humidity : 4%
         * time : 14:25
         */

        public Sk sk;
        /**
         * city : 天津
         * date_y : 2014年03月21日
         * week : 星期五
         * temperature : 8℃~20℃
         * weather : 晴转霾
         * weather_id : {"fa":"00","fb":"53"}
         * wind : 西南风微风
         * dressing_index : 较冷
         * dressing_advice : 建议着大衣、呢外套加毛衣、卫衣等服装。
         * uv_index : 中等
         * comfort_index :
         * wash_index : 较适宜
         * travel_index : 适宜
         * exercise_index : 较适宜
         * drying_index :
         */

        public Today today;
        /**
         * temperature : 28℃~36℃
         * weather : 晴转多云
         * weather_id : {"fa":"00","fb":"01"}
         * wind : 南风3-4级
         * week : 星期一
         * date : 20140804
         */

        public List<Future> future;

        public static class Sk {
            public String temp;
            public String wind_direction;
            public String wind_strength;
            public String humidity;
            public String time;
        }

        public static class Today {
            public String city;
            public String date_y;
            public String week;
            public String temperature;
            public String weather;

            @Override
            public String toString() {
                return "Today{" +
                        "city='" + city + '\'' +
                        ", date_y='" + date_y + '\'' +
                        ", week='" + week + '\'' +
                        ", temperature='" + temperature + '\'' +
                        ", weather='" + weather + '\'' +
                        ", weather_id=" + weather_id +
                        ", wind='" + wind + '\'' +
                        ", dressing_index='" + dressing_index + '\'' +
                        ", dressing_advice='" + dressing_advice + '\'' +
                        ", uv_index='" + uv_index + '\'' +
                        ", comfort_index='" + comfort_index + '\'' +
                        ", wash_index='" + wash_index + '\'' +
                        ", travel_index='" + travel_index + '\'' +
                        ", exercise_index='" + exercise_index + '\'' +
                        ", drying_index='" + drying_index + '\'' +
                        '}';
            }

            /**
             * fa : 00
             * fb : 53
             */

            public WeatherId weather_id;
            public String wind;
            public String dressing_index;
            public String dressing_advice;
            public String uv_index;
            public String comfort_index;
            public String wash_index;
            public String travel_index;
            public String exercise_index;
            public String drying_index;

            public static class WeatherId {
                public String fa;
                public String fb;
            }
        }

        public static class Future {
            public String temperature;
            public String weather;
            /**
             * fa : 00
             * fb : 01
             */

            public WeatherId weather_id;
            public String wind;
            public String week;
            public String date;

            public static class WeatherId {
                public String fa;
                public String fb;
            }
        }
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}

package com.just.see.justsee.json.daxiang;

import java.io.Serializable;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class DaXiangInfo implements Serializable{

    /**
     * article : {"id":"689","title":"真问真答：中国古代的锁安全吗","headpic":"http://static.idaxiang.org/5b08516936b6a7c20d9ffcc76b456466_thumb.jpeg","raw_headpic":"http://static.idaxiang.org/5b08516936b6a7c20d9ffcc76b456466.jpeg","author":"何苞旦","brief":"","read_num":"4049","wechat_url":"http://mp.weixin.qq.com/s?__biz=MjM5NzQwNjcyMQ==&mid=2651006060&idx=1&sn=8abe1cac172bd284e810f17dfc9bbf03#rd","url":"","create_time":"1467820800","update_time":"1467900912"}
     */

    public Body body;
    /**
     * code : 0
     * message :
     */

    public Head head;

    public static class Body {
        /**
         * id : 689
         * title : 真问真答：中国古代的锁安全吗
         * headpic : http://static.idaxiang.org/5b08516936b6a7c20d9ffcc76b456466_thumb.jpeg
         * raw_headpic : http://static.idaxiang.org/5b08516936b6a7c20d9ffcc76b456466.jpeg
         * author : 何苞旦
         * brief : 富文本样式
         * read_num : 4049
         * wechat_url : http://mp.weixin.qq.com/s?__biz=MjM5NzQwNjcyMQ==&mid=2651006060&idx=1&sn=8abe1cac172bd284e810f17dfc9bbf03#rd
         * url :
         * create_time : 1467820800
         * update_time : 1467900912
         */

        public Article article;

        public static class Article {
            public String id;
            public String title;
            public String headpic;
            public String raw_headpic;
            public String author;
            public String brief;//富文本
            public String content;
            public String read_num;
            public String wechat_url;
            public String url;
            public String create_time;
            public String update_time;
        }
    }

    public static class Head {
        public int code;
        public String message;
    }
}

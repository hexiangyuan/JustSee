package com.just.see.justsee.api.urls;

/**
 * Created by 何祥源 on 16/7/15.
 * Desc:
 */
public class QBUrl extends Url {
    //http://m2.qiushibaike.com/article/list/suggest?page=3&type=refresh&count=30&readarticles=[116989092,116990889,116989071]&rqcnt=17&r=8360f2af1468565260892
//    http://m2.qiushibaike.com/article/list/text?page=1&count=30&readarticles=[116994826,116985282,116984123,116986774]&rqcnt=32&r=8360f2af1468566108259
//    GET
    //头像Url
//    http://pic.qiushibaike.com/system/avtnew/1458/14588028/medium/20141210115153.jpg
    public static final String QB_URL = "http://m2.qiushibaike.com/";
    public static final String QB_HEAD_ICON_URL = "http://pic.qiushibaike.com/system/avtnew/1458/14588028/medium/";

    public static String getQBHeadIconUrl(String headIcon) {
        return QB_HEAD_ICON_URL + headIcon;
    }
}

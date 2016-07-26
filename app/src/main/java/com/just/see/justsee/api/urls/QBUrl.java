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
//    http://pic.qiushibaike.com/system/pictures/11704/117040118/medium/app117033622.jpg
//    http://tribe-pic.qiushibaike.com/FmbDDAOzV43ov60TSzPdiLO5V_nV?imageView2/2/w/500/q/80
//    http://pic.qiushibaike.com/system/avtnew/532/5323714/thumb/20140809001823.webp
//    http://pic.qiushibaike.com/system/avtnew//1458/14588028/medium/20141210115153.jpg
//    http://pic.qiushibaike.com/system/avtnew/3207/32073714/thumb/20160630014202.webp
//    http://pic.qiushibaike.com/system/avtnew/2195/21957479/thumb/20160710180846.webp
//    http://pic.qiushibaike.com/system/avtnew/3174/31746089/thumb/20160508092756.webp uid uid前三位
//    http://pic.qiushibaike.com/system/pictures/11709/117097423/medium/app117097423.webp id + id 前三位
    public static final String QB_URL = "http://m2.qiushibaike.com/";
    public static final String QB_HEAD_ICON_URL = "http://pic.qiushibaike.com/system/avtnew/";
    public static final String QB_USER_IMAGE = " http://pic.qiushibaike.com/system/pictures/";

    public static String getQBHeadIconUrl(String uid, String headIcon) {
        String uid4 = uid.substring(0, 4);
        return QB_HEAD_ICON_URL + uid4 + "/" + uid + "/" + "thumb/" + headIcon;
    }

    public static String getQBUserImage(String id, String image) {
        String uid5 = id.substring(0, 5);
        return QB_USER_IMAGE + uid5 + "/" + id + "/" + "medium/" + image;
    }
}

package com.just.see.justsee.json.QBBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 何祥源 on 16/7/19.
 * Desc:
 */
public class QBContent implements Serializable {

    public int count;
    public int total;
    public int page;
    public int err;
    public List<ItemsBean> items;

    public static class ItemsBean {
        public String format;
        public String image;
        public int published_at;
        public String tag;
        public UserBean user;
        public Object image_size;
        public int id;
        public HotCommentBean hot_comment;
        public VotesBean votes;
        public int created_at;
        public String content;
        public String state;
        public int comments_count;
        public boolean allow_comment;
        public int share_count;
        public String type;

        public static class UserBean {
            public int avatar_updated_at;
            public int uid;
            public int last_visited_at;
            public int created_at;
            public String state;
            public String last_device;
            public String role;
            public String login;
            public int id;
            public String icon;
        }

        public static class HotCommentBean {
            public String status;
            public int user_id;
            public int floor;
            public String ip;
            public String created_at;
            public int comment_id;
            public int like_count;
            public int pos;
            public String content;
            public String source;
            public Object score;
            public int parent_id;
            public int anonymous;
            public int neg;
            public int article_id;
            public UserBean user;

            public static class UserBean {
                public int avatar_updated_at;
                public int uid;
                public int last_visited_at;
                public int created_at;
                public String state;
                public String last_device;
                public String role;
                public String login;
                public int id;
                public String icon;
            }
        }

        public static class VotesBean {
            public int down;
            public int up;
        }
    }
}

package com.just.see.justsee.json;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */
public class EzbuyProduct implements Serializable{

    public String jsonrpc;
    public int id;
    public List<ResultBean> result;

    public static class ResultBean {
        public int productId;
        public String type;
        public String url;
        public String name;
        public String price;
        public String picture;
        public int favouriteCount;
        public String originCode;
        public String priceWithSymbol;
        public String vendorName;
        public String altProductName;
        public String customerLocalPrice;
        public boolean isEzBuy;
        public String originalLocalUnitPrice;
        public String discountRate;
        public boolean isCashOffProduct;
    }
}

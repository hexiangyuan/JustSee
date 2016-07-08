package com.just.see.justsee.util;

/**
 * Created by 何祥源 on 16/7/6.
 * Desc:
 */

import android.widget.Toast;

import com.just.see.justsee.JustSeeApplication;

/**
 * Created by 何祥源 on 16/6/27.
 * Desc:如果每次都Toast.makeToast来显示Toast的话,
 * 一、方面写法麻烦
 * 二、是多次调用Toast会使Toast一直浮在界面最上层,影响交互,
 * 这里是封装一个ToastUtil:
 */
public class ToastUtil {

    private static Toast toast = null;

    /**
     * 弹出Toast
     *
     * @param text     toast信息
     * @param duration Toast.LENGTH_LONG;Toast.LENGTH_SHORT;
     */
    private static void show(CharSequence text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(JustSeeApplication.getInstance(), text, duration);
        } else {
            toast.setText(text);
            toast.setDuration(duration);
        }
        toast.show();
    }

    private static void show(int resId, int duration) {
        if (toast == null) {
            toast = Toast.makeText(JustSeeApplication.getInstance(), resId, duration);
        } else {
            toast.setText(resId);
            toast.setDuration(duration);
        }
        toast.show();
    }

    /**
     * Toast 短时间的显示
     *
     * @param resId String 资源文件
     */
    public static void showToast(int resId) {
        show(resId, Toast.LENGTH_SHORT);
    }

    /**
     * Toast 短时间显示
     *
     * @param text String字符串
     */
    public static void showToast(String text) {
        show(text, Toast.LENGTH_SHORT);
    }

    /**
     * 长时间Toast展示
     *
     * @param resId String id
     */
    public static void showLongToast(int resId) {
        show(resId, Toast.LENGTH_LONG);
    }

    /**
     * 长时间Toast展示
     *
     * @param text String 字符串
     */
    public static void showLongToast(String text) {
        show(text, Toast.LENGTH_LONG);
    }
}

package com.duan.musicoco.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;

/**
 * Created by DuanJiaNing on 2017/4/2.
 */

public class ColorUtils {

    /**
     * 获得一个随机的颜色
     *
     * @return 颜色
     */
    public static int getRandomColor() {
        int r = (int) (Math.random() * 255); //产生一个255以内的整数
        int g = (int) (Math.random() * 255); //产生一个255以内的整数
        int b = (int) (Math.random() * 255); //产生一个255以内的整数
        return Color.rgb(r, g, b);
    }

    /**
     * 获得一个比较暗的随机颜色
     *
     * @return 颜色
     */
    public static int getRandomBrunetColor() {
        int r = (int) (Math.random() * 100); //产生一个100以内的整数
        int g = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        return Color.rgb(r, g, b);
    }

    /**
     * 获得图片中出现最多的颜色
     * 0 活力颜色
     * 1 亮的活力颜色
     * 2 暗的活力颜色
     * 3 柔和颜色
     * 4 亮的柔和颜色
     * 5 暗的柔和颜色
     *
     * @param bitmap       图片
     * @param defaultColor 默认颜色
     * @return 大小为 6 的数组
     */
    public static void getColorFormBitmap(@NonNull Bitmap bitmap, int defaultColor, int[] colors) {

        if (colors.length != 6)
            return;

        Palette palette;
        palette = new Palette.Builder(bitmap).generate();

        Palette.Swatch swatch;
        int color;

        if ((swatch = palette.getVibrantSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[0] = color;

        if ((swatch = palette.getLightVibrantSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[1] = color;

        if ((swatch = palette.getDarkVibrantSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[2] = color;

        if ((swatch = palette.getMutedSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[3] = color;

        if ((swatch = palette.getLightMutedSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[4] = color;

        if ((swatch = palette.getDarkMutedSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[5] = color;

    }

    /**
     * 获得图片中出现最多的颜色
     * 0 亮的活力颜色
     * 1 亮的柔和颜色
     *
     * @param bitmap       图片
     * @param defaultColor 默认颜色
     * @return 大小为 2 的数组
     */
    public static void get2ColorFormBitmap(@NonNull Bitmap bitmap, int defaultColor, int[] colors) {

        if (colors.length != 2)
            return;

        Palette palette;
        palette = new Palette.Builder(bitmap).generate();

        Palette.Swatch swatch;
        int color;

        if ((swatch = palette.getLightVibrantSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[0] = color;

        if ((swatch = palette.getLightMutedSwatch()) != null)
            color = swatch.getRgb();
        else color = defaultColor;
        colors[1] = color;

    }

    /**
     * 获得图片中出现最多的颜色
     * 0 暗的活力颜色
     * 1 暗的活力颜色 对应适合的字体颜色
     * 2 暗的柔和颜色
     * 3 暗的柔和颜色 对应适合的字体颜色
     *
     * @param bitmap       图片
     * @param defaultColor 默认颜色
     * @return 大小为 4 的数组
     */
    public static void get2ColorWithTextFormBitmap(@NonNull Bitmap bitmap, int defaultColor, int defaultTextColor, int[] colors) {

        if (colors.length != 4)
            return;

        Palette palette;
        palette = new Palette.Builder(bitmap).generate();

        Palette.Swatch swatch;
        int color = defaultColor;
        int textColor = defaultTextColor;

        if ((swatch = palette.getDarkVibrantSwatch()) != null) {
            color = swatch.getRgb();
            textColor = swatch.getTitleTextColor();
        }
        colors[0] = color;
        colors[1] = textColor;

        color = defaultColor;
        textColor = defaultTextColor;

        if ((swatch = palette.getDarkMutedSwatch()) != null) {
            color = swatch.getRgb();
            textColor = swatch.getTitleTextColor();
        }
        colors[2] = color;
        colors[3] = textColor;

    }
}

package com.wallapp.test;

import android.graphics.Bitmap;

import com.wallapp.fragments.Point;
import com.wallapp.fragments.Thumbnail;
import com.wallapp.fragments.ThumbnailType;
import com.wallapp.fragments.ThumbnailUtils;
import com.wallapp.store.StaticVars;
import com.wallapp.utils.GradientUtils;
import com.wallapp.utils.MetricsUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WallAppTest {
    GradientUtils gradientUtils = new GradientUtils();
    ThumbnailUtils thumbnailUtils = new ThumbnailUtils();
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getBitmapTest() throws Exception{
        Bitmap bitmap = gradientUtils.getGradient(100,100);
        assertNull(bitmap);
    }
    @Test
    public void constantsTests(){
        assertEquals(1280, StaticVars.HDWidth);
        assertEquals(720, StaticVars.HDHeight);
        assertEquals(1920, StaticVars.FHDWidth);
        assertEquals(1080, StaticVars.FHDHeight);
        assertEquals(2880, StaticVars.MAXWidth);
        assertEquals(1680, StaticVars.MAXHeight);
    }
    @Test
    public void testBitmapCapabilities(){
        int[] colors = new int[100];
        for (int i = 0; i < 100; i++) {
            colors[i] = (0xFF << 24) | (i << 16) | (i << 8) | i;
        }
        for (int i = 0; i < 100; i++) {

            assertEquals(100, colors.length);
        }
    }
    @Test
    public void insertGradientTest(){
        List<String> list_gradient = new ArrayList<>();
        gradientUtils.insertGradient(list_gradient,"blueSkyColor");
        assertEquals(1, list_gradient.size());
    }
    @Test
    public void getParametersTest(){
        assertEquals(1280, MetricsUtils.getHDWidth());
        assertEquals(720, MetricsUtils.getHDHeight());
        assertEquals(1920, MetricsUtils.getFullHDWidth());
        assertEquals(1080, MetricsUtils.getFullHDHeight());
        assertEquals(2880, MetricsUtils.getMaxWidth());
        assertEquals(1680, MetricsUtils.getMaxHeight());
    }
    @Test
    public void thumbnailUtils_calculateArea() {
        assertNotNull(thumbnailUtils);

        // given
        Thumbnail triangle = getAnyTriangle();

        // when
        double area = thumbnailUtils.calculateArea(triangle);

        // then
        assertTrue(area == 4);
    }

    @Test
    public void thumbnailUtils_calculateDistance() {
        assertNotNull(thumbnailUtils);

        // given
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 4);

        // when
        int distance = thumbnailUtils.getDistance(p1, p2);

        // then
        assertTrue(distance == 5);
    }

    @Test
    public void thumbnailUtils_getType_Equilateral() {
        assertNotNull(thumbnailUtils);

        // given
        Thumbnail triangle = getEquilateralTriangle();

        // when
        ThumbnailType type = thumbnailUtils.getType(triangle);

        // then
        assertEquals(type, ThumbnailType.EQUILATERAL);
    }

    @Test
    public void thumbnailUtils_getType_Isosceles() {
        assertNotNull(thumbnailUtils);

        // given
        Thumbnail triangle = getIsoscelesTriangle();

        // when
        ThumbnailType type = thumbnailUtils.getType(triangle);

        // then
        assertEquals(type, ThumbnailType.ISOSCELES);
    }

    @Test
    public void thumbnailUtils_getType_Right() {
        assertNotNull(thumbnailUtils);

        // given
        Thumbnail triangle = getRightTriangle();

        // when
        ThumbnailType type = thumbnailUtils.getType(triangle);

        // then
        assertEquals(type, ThumbnailType.RIGHT);
    }

    @Test
    public void thumbnailUtils_getType_Any() {
        assertNotNull(thumbnailUtils);

        // given
        Thumbnail triangle = getAnyTriangle();

        // when
        ThumbnailType type = thumbnailUtils.getType(triangle);

        // then
        assertEquals(type, ThumbnailType.ANY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void thumbnailUtils_getType_ThrowsError() {
        assertNotNull(thumbnailUtils);

        // given
        Point point = new Point(1, 1);
        Thumbnail triangle = new Thumbnail(point, point, point);

        // when
        thumbnailUtils.getType(triangle);
    }

    private Thumbnail getEquilateralTriangle() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 1);
        return new Thumbnail(a, b, c);
    }

    private Thumbnail getIsoscelesTriangle() {
        Point a = new Point(2, 1);
        Point b = new Point(4, 3);
        Point c = new Point(4, 1);
        return new Thumbnail(a, b, c);
    }

    private Thumbnail getRightTriangle() {
        Point a = new Point(1, 2);
        Point b = new Point(3, 1);
        Point c = new Point(4, 4);
        return new Thumbnail(a, b, c);
    }

    private Thumbnail getAnyTriangle() {
        Point a = new Point(1, 3);
        Point b = new Point(2, 5);
        Point c = new Point(4, 1);
        return new Thumbnail(a, b, c);
    }
}

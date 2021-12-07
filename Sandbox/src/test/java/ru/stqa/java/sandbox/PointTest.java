package ru.stqa.java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistance () {
        Point p1 = new Point (0.0, 0.0);
        Point p2 = new Point (0.0, 0.0);
        Assert.assertEquals(p1.distance(p2), 0.0);
    }

    @Test (priority = 1)
    public void test1Distance () {
        Point p1 = new Point (0.0, 0.1);
        Point p2 = new Point (0.1, 0.9);
        Assert.assertEquals(p1.distance(p2), 0.806225774829855);
    }

    @Test (priority = 2)
    public void test2Distance () {
        Point p1 = new Point (0.0, -0.1);
        Point p2 = new Point (-0.1, -0.9);
        Assert.assertEquals(p1.distance(p2), 0.806225774829855);
    }

    @Test (priority = 3)
    public void test3Distance () {
        Point p1 = new Point (1.0, 9.0);
        Point p2 = new Point (-10.0, 0.11);
        Assert.assertEquals(p1.distance(p2), 14.143270484580292);
    }

    @Test (priority = 4)
    public void test4Distance () {
        Point p1 = new Point (0.0, 1.0);
        Point p2 = new Point (1.0, 10.0);
        Assert.assertEquals(p1.distance(p2), 9.055385138137417);
    }

    @Test (priority = 5)
    public void test5Distance () {
        Point p1 = new Point (0.0, -1.0);
        Point p2 = new Point (-1.0, -10);
        Assert.assertEquals(p1.distance(p2), 9.055385138137417);
    }

    @Test (priority = 6)
    public void test6Distance () {
        Point p1 = new Point (9.0, -9.0);
        Point p2 = new Point (10.0, -0.6);
        Assert.assertEquals(p1.distance(p2), 8.459314393022641);
    }

    @Test (priority = 7)
    public void test7Distance () {
        Point p1 = new Point (19.0, 9.99);
        Point p2 = new Point (-0.1, 0.0);
        Assert.assertEquals(p1.distance(p2), 21.55481616715856);
    }

    @Test (priority = 8)
    public void test8Distance () {
        Point p1 = new Point (19.0, 9.99);
        Point p2 = new Point (-0.1, 0.0);
        Assert.assertEquals(p1.distance(p2), 21.55481616715856);
    }

    @Test (priority = 9)
    public void test9Distance () {
        Point p1 = new Point (9.0, -9.99);
        Point p2 = new Point (0.0, 10.0);
        Assert.assertEquals(p1.distance(p2), 21.922593368486314);
    }

    @Test (priority = 10)
    public void test10Distance () {
        Point p1 = new Point (-9.0, -15.0);
        Point p2 = new Point (-9.9, 5.0);
        Assert.assertEquals(p1.distance(p2), 20.020239758804088);
    }

    @Test (priority = 11)
    public void test11Distance () {
        Point p1 = new Point (-5.0, 100.1);
        Point p2 = new Point (0.0, -5.0);
        Assert.assertEquals(p1.distance(p2), 105.21886712942693);
    }

    @Test (priority = 12)
    public void test12Distance () {
        Point p1 = new Point (0.1, 10.1);
        Point p2 = new Point (10.0, -5.55);
        Assert.assertEquals(p1.distance(p2), 18.518436759078774);
    }

    @Test (priority = 13)
    public void test13Distance () {
        Point p1 = new Point (-0.99, -10.1);
        Point p2 = new Point (10.1, -1.0);
        Assert.assertEquals(p1.distance(p2), 14.345664850399928);
    }
}

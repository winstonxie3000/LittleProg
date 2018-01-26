package com.math;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

public class StringCalUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void plus() {
        Assert.assertEquals("1887",StringCalUtil.plus("999","888"));
        Assert.assertEquals("201",StringCalUtil.plus("199","2"));
    }

    @org.junit.Test
    public void minus() {
        String a1 = StringCalUtil.minus("1123","87");
        Assert.assertEquals("1036",a1);
        String a2 = StringCalUtil.minus("123","87");
        Assert.assertEquals("36",a2);
        String a3 = StringCalUtil.minus("3398","87");
        Assert.assertEquals("3311",a3);
        String a4 = StringCalUtil.minus("183","171");
        Assert.assertEquals("12",a4);
        String a5 = StringCalUtil.minus("124","114");
        Assert.assertEquals("10",a5);
        String a6 = StringCalUtil.minus("464","435");
        Assert.assertEquals("29",a6);
    }

    @org.junit.Test
    public void multiple() {
    }

    @org.junit.Test
    public void divide() {

        List<String> result;

        result = StringCalUtil.divide("183456","19");
        Assert.assertEquals(result.get(0),"9655");
        Assert.assertEquals(result.get(1),"11");

        result = StringCalUtil.divide("324325","23");
        Assert.assertEquals(result.get(0),"14101");
        Assert.assertEquals(result.get(1),"2");

        result = StringCalUtil.divide("464574","435");
        Assert.assertEquals(result.get(0),"1067");
        Assert.assertEquals(result.get(1),"429");

        result = StringCalUtil.divide("3534643645","234");
        Assert.assertEquals(result.get(0),"15105314");
        Assert.assertEquals(result.get(1),"169");

        result = StringCalUtil.divide("15","3");
        Assert.assertEquals(result.get(0),"5");
        Assert.assertEquals(result.get(1),"0");

        result = StringCalUtil.divide("150","3");
        Assert.assertEquals(result.get(0),"50");
        Assert.assertEquals(result.get(1),"0");

        result = StringCalUtil.divide("90000","15");
        Assert.assertEquals(result.get(0),"6000");
        Assert.assertEquals(result.get(1),"0");
    }

    @org.junit.Test
    public void singleDivide() {

        List<String> result;

        result = StringCalUtil.singleDivide("124","19");
        Assert.assertEquals(result.get(0),"6");
        Assert.assertEquals(result.get(1),"10");

        result = StringCalUtil.singleDivide("464","435");
        Assert.assertEquals(result.get(0),"1");
        Assert.assertEquals(result.get(1),"29");

        result = StringCalUtil.singleDivide("105","19");
        Assert.assertEquals(result.get(0),"5");
        Assert.assertEquals(result.get(1),"10");

        result = StringCalUtil.singleDivide("0","19");
        Assert.assertEquals(result.get(0),"0");
        Assert.assertEquals(result.get(1),"0");

        result = StringCalUtil.singleDivide("00","19");
        Assert.assertEquals(result.get(0),"0");
        Assert.assertEquals(result.get(1),"0");
    }

    @org.junit.Test
    public void noMoreThan() {

        boolean a1 = StringCalUtil.noMoreThan("95", "105");
        Assert.assertTrue(a1);
    }


    @org.junit.Test
    public void multiple1() {
    }

    @org.junit.Test
    public void index() {
        String a1 = StringCalUtil.index("2","10");
        Assert.assertEquals("1024",a1);
        String a2 = StringCalUtil.index("5","4");
        Assert.assertEquals("625",a2);
        String a3 = StringCalUtil.index("2","77232917");
        Assert.assertEquals("5260135901548373507240989882880128665550339802823173859498280903068732154297080822113666536277588451226982968856178217713019432250183803863127814770651880849955223671128444598191663757884322717271293251735781376",a3);
    }

    @org.junit.Test
    public void lessThan() {

        boolean lessThan1 = StringCalUtil.lessThan("23423", "23424");
        Assert.assertTrue(lessThan1);
        boolean lessThan2 = StringCalUtil.lessThan("1", "23423");
        Assert.assertTrue(lessThan2);
        boolean lessThan3 = StringCalUtil.lessThan("1342", "2");
        Assert.assertFalse(lessThan3);
        boolean lessThan4 = StringCalUtil.lessThan("0000", "19");
        Assert.assertTrue(lessThan4);
    }

    @org.junit.Test
    public void isExactDivide() {
        Assert.assertTrue(StringCalUtil.isExactDivide("15","3"));
        Assert.assertTrue(StringCalUtil.isExactDivide("12325","5"));
        Assert.assertFalse(StringCalUtil.isExactDivide("7","3"));
    }
}
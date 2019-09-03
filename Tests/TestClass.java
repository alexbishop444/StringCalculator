import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestClass {
    Calculator add = new Calculator();
    @Test
    public void Return0() {
        int actual = add.Add("");
        int expected = 0;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void returnsNumber() {
        int actual = add.Add("1");
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addsTwoNumbers() {
        int actual = add.Add("2","2");
        int expected = 4;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addsMultipleNumbers() {
        int actual = add.Add("3","5","3","9");
        int expected = 20;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void regexTest() {
        int actual = add.Add("3\n5\n3,9");
        int expected = 20;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void regexTest2() {
        int actual = add.Add("//;\n1;2");
        int expected = 3;
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void negativeNumbers() {
        int actual = add.Add("-1,2,-3");
        String expected = "Throws exception with Negatives not allowed: -1, -3 ";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void biggerNumbers() {
        int actual = add.Add("1000,1001,2");
        int expected = 2;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void delimiters() {
        int actual = add.Add("//[***]\n1***2***3");
        int expected = 6;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void delimitersMultiple() {
        int actual = add.Add("//[*][%]\n1*2%3");
        int expected = 6;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void delimitersLongerThanOneChar() {
        int actual = add.Add("//[***][#][%]\n1***2#3%4");
        int expected = 10;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void delimitersWithNumbers() {
        int actual = add.Add("//[*1*][%]\n1*1*2%3");
        int expected = 6;
        Assert.assertEquals(expected,actual);
    }
}

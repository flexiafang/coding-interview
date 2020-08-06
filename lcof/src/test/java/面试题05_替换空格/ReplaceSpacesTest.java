package 面试题05_替换空格;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class ReplaceSpacesTest {

    private ReplaceSpaces solution;
    private String s;
    private String expected;

    @Before
    public void setUp() throws Exception {
        solution = new ReplaceSpaces();
        s = "We are happy.";
        expected = "We%20are%20happy.";
    }

    @Test
    public void replaceSpaces1() {
        Assert.assertEquals(expected, solution.replaceSpaces1(s));
    }

    @Test
    public void replaceSpaces2() {
        Assert.assertEquals(expected, solution.replaceSpaces2(s));
    }
}
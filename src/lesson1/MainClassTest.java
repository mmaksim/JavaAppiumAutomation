package lesson1;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber() {
        Assert.assertEquals("метод getLocalNumber возвращает число 14",
                14, mainClass.getLocalNumber());
    }

    @Test
    public void testGetClassNumber() {
        Assert.assertTrue("метод getClassNumber возвращает число больше 45",
                mainClass.getClassNumber() > 45);
    }

    @Test
    public void testGetClassString() {
        Assert.assertTrue("метод getClassString возвращает строку, в которой есть подстрока hello или Hello",
                mainClass.getClassString().contains("hello") || mainClass.getClassString().contains("Hello"));
    }
}

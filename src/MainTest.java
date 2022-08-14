import com.sun.javafx.stage.StageHelper;
import org.junit.Test;

public class MainTest extends CoreTestCase{

    MathHelper math = new MathHelper();

    int a = 5;
    int b = 11;

    @Test
    public void myFirstTest(){
        int a = math.multiply(this.a);
        int b = math.multiply(this.a, this.b);

        double number = 10.0/3.0;
        System.out.println(a);
        System.out.println(b);
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(number+15);
        typeString();
    }

    public void typeString(){
        System.out.println("hello form typeString()");
    }
}

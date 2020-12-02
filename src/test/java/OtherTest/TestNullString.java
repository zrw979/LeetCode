package OtherTest;

import org.junit.Test;

/**
 * @ProjectName: leetCode
 * @Package: OtherTest
 * @ClassName: NullStringTest
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/17 14:21
 * @Version: 1.0
 */
public class TestNullString {

    @Test
    public void test1() {
        String str1 = null;
        String str3 = "";
//        未初始化的变量str2
//        String str2 ;
//        System.out.println(str2);

//        报空指针异常
//        System.out.println(str1.equals(null));

        //return true
        System.out.println(str1 == null);
        System.out.println(str3 == null);
        System.out.println(str3.equals(null));
        System.out.println(str3 == "");
        System.out.println(str3.equals(""));
        System.out.println(str3.equals(null));
    }

}

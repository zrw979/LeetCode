package OtherTest;

import bean.CompareStudent;
import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: leetCode
 * @Package: OtherTest
 * @ClassName: TestCompare
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/10/6 15:54
 * @Version: 1.0
 */
public class TestCompare {
    @Test
    public void test() {
        //默认字典序 逐个字母字典序比较 相同在比较长度
        List<CompareStudent> list = new ArrayList<>();
        list.add(new CompareStudent("zxcv", 1, true));
        list.add(new CompareStudent("qwert", 2, true));
        list.add(new CompareStudent("asdfgh", 3, true));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        list.sort(new Comparator<CompareStudent>() {
            @Override
            public int compare(CompareStudent o1, CompareStudent o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);
    }
}

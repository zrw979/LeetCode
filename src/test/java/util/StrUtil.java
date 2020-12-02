package util;

import java.util.Date;
import java.util.Random;

/**
 * @ProjectName: leetCode
 * @Package: util
 * @ClassName: StrUtil
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/11/9 9:27
 * @Version: 1.0
 */
public class StrUtil {
    public static String getRandomLetterStr(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random(new Date().getTime());
        for (int i = 0; i < length; i++) {
            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写还是小写
            builder.append((char) (choice + random.nextInt(26)));
        }
        return builder.toString();
    }
}

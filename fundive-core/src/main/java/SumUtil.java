/**
 * @author suwen.yang
 * @date 2016/11/15
 */

public class SumUtil {

    public static Long sum(Iterable<Integer> values){
        long res = 0;
        for (Integer value : values) {
            res += value;
        }
        return res;
    }

}

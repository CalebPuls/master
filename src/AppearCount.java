import java.util.*;

/**
 * @author
 * @Description 对应第一题，独一无二的出现次数
 * @create 2022-05-07 9:22
 */
public class AppearCount {
    //时间复杂度O（2n）
    public boolean count(int[] nums){
        Set<Integer> set = new HashSet<>();     //用于存储有不重复的数有几个
        Set<Integer> testSet = new HashSet<>(); //用于验证重复的次数是否相同
        Map<Integer,Integer> map = new HashMap<>(); //存储每个数字出现的次数
        for (int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            set.add(i);
        }
        /*
        在这里本来是想用map.values()得到一个集合，然后遍历这个集合是否有重复就可以得到结果
        但是在类型转换上出了问题，希望老师稍微讲一下这个，
         */

        Iterator iterator =  set.iterator();
        while (iterator.hasNext()){
            if (!testSet.add(map.get(iterator.next()))){
                return false;
            }
        }
        return true;
    }
}

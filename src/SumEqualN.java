import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author
 * @Description
 * @create 2022-05-07 10:34
 */

//双指针
public class SumEqualN {
    public List<List<Integer>> sum(int n){
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (n == 1){
            list.add(1);
            lists.add(list);
            return lists;
        }
        int half = n/2+1;
        int sum = 0;
        int left=1,right=2;
        list.add(left);
        sum = left;

        for (;right<=half&&left<right;++right){
            sum += right;
            list.add(right);
            if (sum == n){
                List<Integer> temp = new ArrayList<>();
                for (int i:list){
                    temp.add(i);
                }
                lists.add(temp);

            }else if (sum<n){

            }else {
                sum -= left;
                list.remove(0);
                ++left;
                while (sum > n){
                    sum -= left;
                    list.remove(0);
                    ++left;
                }
                if(sum == n){
                    List<Integer> temp = new ArrayList<>();
                    for (int i:list){
                        temp.add(i);
                    }
                    lists.add(temp);
                    sum -= left;
                    list.remove(0);
                    ++left;
                }
            }
        }
        return lists;
    }
}

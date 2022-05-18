import java.util.*;

/**
 * @author
 * @Description
 * @create 2022-05-07 11:19
 */


public class MaxValue {
    //这个地方知道要用贪心算法，但是在处理输入的时候有问题，不从外部输入，直接在内部修改时，可以得到正确答案
    //具体问题在下面有注释，希望老师解答
    public int searchMax(){
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入总预算：");
        int budget = 100;//scanner.nextInt();
        System.out.print("请输入物资总数：");
        int n = 5;//scanner.nextInt();
        List<Integer> gaps = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        String[] strings = new String[]{"77 92","22 22","29 36","50 46","99 90"};
        for (int i=0;i<n;++i){
            int number = i+1;
            System.out.println("请输入第"+number+"种物资的价格与使用价值：");
            /**
             * 这里如果使用
             * String s = scanner.nextLine()
             * 第42行的String value = s.substring(0,j); 中的value就会变成“”，在我还没输入的时候就会提醒报错
             * 51行的int valueNum = Integer.parseInt(value);中的value不能是“”，但是我都还没键盘输入
             * 请老师讲一下
             */
            String s = strings[i];

            int j=0;
            for (;j<s.length();++j){
                if (s.charAt(j) == ' '){
                    break;
                }
            }

            String value = s.substring(0,j);        //得到物资价格

            /**
             * 这里我觉得应该直接用String useValue =s.substring(j+1,s.length());就可以了
             * 但是这样写就会报错，下标越界-1，没想通，希望老师讲一下
             */

            String useValue =s.substring(j,s.length());//得到物资使用价值
            useValue = useValue.trim();
            int valueNum = Integer.parseInt(value);
            int useValueNum = Integer.parseInt(useValue);
            //得到使用价值与价值之差
            int gap = useValueNum-valueNum;

            gaps.add(gap);
            map.put(gap,valueNum);
        }
        Collections.sort(gaps);
        for (int i=gaps.size()-1;i>=0;--i){
            int gap = gaps.get(i);
            int value = map.get(gap);
            while (budget-value>0){
                budget -= value;
                res += value+gap;
            }
        }

        return  res;
    }
}

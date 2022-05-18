import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author
 * @Description
 * @create 2022-05-18 11:24
 */
public class Exam {
    public static void main(String[] args) throws IOException {
        Exam exam = new Exam();
        int[] sorces = new int[]{2,2,2,2,2,2,2,2,2,2,
                                4,4,4,4,4,4,4,4,4,4,
                                8,8,8,8,8};
        System.out.print("请输入员工分数：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        exam.recursion(0,0,n,sorces,0);
        System.out.println(exam.count);
    }
    private int count = 0;
    private void recursion(int post,int sorce,int target,int[] sorces,int wrong){

        if(sorce == target){
            ++count;
            return;
        }
        if (sorce>target || wrong>=3 || post>24)return;
        //该题目做对了
        recursion(post+1,sorce+sorces[post],target,sorces,wrong);
        //该题目做错了
        recursion(post+1,sorce,target,sorces,wrong+1);
    }
}

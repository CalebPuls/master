import sun.reflect.generics.tree.VoidDescriptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author
 * @Description
 * @create 2022-05-18 11:45
 */
public class Project {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int S1 = Integer.parseInt(s[0]);
        int S2 = Integer.parseInt(s[1]);
        int S3 = Integer.parseInt(s[2]);
        String[] values = br.readLine().split(" ");
        //每个项目价值的int数组
        int[] v = new int[m];
        //存放每个项目所需人力的二维数组
        int[][] p = new int[m][3];
        for(int i=0;i<m;++i){
            //将string转换成int
            v[i] = Integer.parseInt(values[i]);
            String[] ps = br.readLine().split(" ");
            for(int j=0;j<3;++j){
                p[i][j] = Integer.parseInt(ps[j]);
            }
        }
        recursion(m,0,p,S1,S2,S3,v,0);
        System.out.println(max);
    }
    private static int max = 0;
    public static void recursion(int m,int post,int[][]p,int S1,int S2,int S3,int[] v,int value){
        if (S1<0||S2<0||S3<0)return;
        if (value>max)max=value;
        if (post == m)return;;
        //做了该项目
        recursion(m,post+1,p,S1-p[post][0],S2-p[post][1],S3-p[post][2],v,value+v[post]);
        //不做该项目
        recursion(m,post+1,p,S1,S2,S3,v,value);
    }

}

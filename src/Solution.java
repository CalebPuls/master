import java.util.*;

/**
 * @author
 * @Description
 * @create 2022-05-12 15:04
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
//        System.out.println(solution.res);
//        Set set = new HashSet();
//        int n=5;
//        boolean[][] square = new boolean[n][n];
//        for(int i=0;i<n;++i){
//            boolean temp = i%2==0?true:false;
//            for(int j=0;j<n;++j){
//                square[i][j] = j%2==0?temp:!temp;
//            }
//        }
//        for(int i=0;i<n;++i){
//            for(int j=0;j<n;++j){
//                System.out.print(square[i][j]+"\t");
//            }
//            System.out.println();
//        }
    }
    private List<List<String>> res = new LinkedList<>();
    private List<String> list = new LinkedList<>();
    private List<Integer> Qpost = new LinkedList<>();
    private List<List<Integer>> Qposts = new LinkedList<>();
    private Set<Integer> set = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        recursion(n,0,0);
        for(List<Integer> li : Qposts){
            for(int i:li){
                String s = "";
                for(int j=0;j<n;++j){
                    if(j == i)s+="Q";
                    else s+=".";
                }
                list.add(s);
            }
            res.add(list);
        }
        return res;
    }
    private void recursion(int n,int row,int q){
        if(q == n){
            Qposts.add(new LinkedList(Qpost));
            return;
        }
        //将上一行的斜边变成不能放皇后
        boolean[] col = new boolean[n];
        for(int i=0;i<Qpost.size();++i){
            int post = Qpost.get(i);
            int gap = q-i;//计算扩张大小,每一层扩张大小不同
            if(post-gap>=0)col[post-gap] = true;
            if(post+gap<n)col[post+gap] = true;
        }
        for(int j=0;j<n;++j){
            //该列能否放皇后
            if(!col[j]&&!Qpost.contains(j)){
                Qpost.add(j);
                recursion(n,row+1,q+1);
                Qpost.remove(Qpost.size()-1);

            }
        }
    }
}

import com.sun.org.apache.xpath.internal.SourceTree;
import myclass.TreeNode;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author
 * @Description
 * @create 2022-05-10 17:08
 */
public class Tencent {
    //{1,2,3},[[2,4],[1,2]]
    //{2,1,3,#,4},[[3,2],[1,4],[1,3],[4,2],[2,1]]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("}");

        //获得一个int[]的层序二叉树
        String[] stingTree = strings[0].replace("{","").split(",");
        int[] intTree = new int[stingTree.length];
        //存放每个节点编号，对应的下标值
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<intTree.length;++i){
            if ("#".equals(stingTree[i])){
                intTree[i]=-1;
                continue;
            }
            intTree[i] = 0;
            map.put(stingTree[i],i);
        }

        //获得操做，的一个字符串数组每个字符串是 [x，y的形式
        String operate = strings[1].substring(2,strings[1].length()-1);
        String[] operates = operate.split("]");
        operates[0] = operates[0].substring(1);
        for (int i=1;i<operates.length;++i)
            operates[i] = operates[i].substring(2);


//        for (int i:intTree) System.out.println(i);
//        for (String s:operates) System.out.println(s);

        //得到了，单个节点全被操作了一次的二叉树数组
        for (String s:operates){
            String number = s.charAt(0) + "";
            intTree[map.get(number)] ^= Integer.parseInt(s.charAt(2)+"");
        }

        TreeNode result = bulidTree(0,intTree,0);
        Deque<TreeNode> que = new LinkedList<>();
        que.addLast(result);
        System.out.print("{");
        while (!que.isEmpty()){
            TreeNode tree = que.pollFirst();


            if (tree.left!=null)que.addLast(tree.left);
            if (tree.right!=null)que.addLast(tree.right);
            if (que.isEmpty())
                System.out.print(tree.val);
            else{
                if (tree.val == -1) {
                    System.out.print("#" + ",");
                } else {
                    System.out.print(tree.val + ",");
                }
            }

        }
        System.out.println("}");
    }

    //通过数组，得到完全被操作过后的树
    public static TreeNode bulidTree(int ix,int[] trees,int a){
        if (ix>=trees.length)return  null;
        if (trees[ix]==-1)return new TreeNode(-1);
        a ^= trees[ix];
        TreeNode tree = new TreeNode(a);
        tree.left = bulidTree(ix*2+1,trees,a);
        tree.right = bulidTree(ix*2+2,trees,a);
        return tree;
    }

}

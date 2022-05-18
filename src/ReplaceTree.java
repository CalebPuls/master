import myclass.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @Description 华为的替换树的笔试题
 * @create 2022-05-10 9:14
 */
public class ReplaceTree {
    public static void main(String[] args) throws IOException {
        //处理输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stringTree1 = br.readLine().replace("[","").
                replace("]","").split(",");

        String[] path = br.readLine().split("/");
        String[] stringTree2 = br.readLine().replace("[","").
                replace("]","").split(",");

        //创建输入的两颗树
        TreeNode tree1 = buildTree(stringTree1,0);
        TreeNode tree2 = buildTree(stringTree2,0);

        //替换树
        TreeNode result = replacTree(tree1,tree2,path,1);

        //层序遍历得到，要求的输出
        Deque<TreeNode> que = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        que.addLast(result);
        while (!que.isEmpty()){
            TreeNode tree = que.pollFirst();
            list.add(tree.val);
            if (tree.left!=null)que.addLast(tree.left);
            if (tree.right!=null)que.addLast(tree.right);
        }
        System.out.println(list);
    }

    //通过数组和ix关系创建树
    public static TreeNode buildTree(String[] stringTrees,int ix){
        if (ix>=stringTrees.length||"0".equals(stringTrees[ix]))return null;
        TreeNode root = new TreeNode(Integer.parseInt(stringTrees[ix]));
        root.left = buildTree(stringTrees,2*ix+1);
        root.right = buildTree(stringTrees,2*ix+2);
        return root;
    }

    //根据路径替换树
    public static TreeNode replacTree(TreeNode tree1,TreeNode tree2,String[] path,int post){
        if(post>=path.length)return tree1;
        if (tree1.val == Integer.parseInt(path[post])){
            if(post == path.length-1)return tree2;
            tree1.left = replacTree(tree1.left,tree2,path,post+1);
            tree1.right = replacTree(tree1.right,tree2,path,post+1);
        }
        return tree1;
    }
}

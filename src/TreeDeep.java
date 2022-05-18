import myclass.TreeNode;

/**
 * @author
 * @Description 二叉树最大深度
 * @create 2022-05-07 10:19
 */
public class TreeDeep {
    //DFS递归
    public int Deep(TreeNode tree){
        if (tree == null){
            return 0;
        }
        int leftCount = Deep(tree.left)+1;
        int rightCount = Deep(tree.right)+1;
        return Math.max(leftCount,rightCount);
    }
}

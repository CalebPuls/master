import java.util.*;

/**
 * @author
 * @Description
 * @create 2022-05-18 15:46
 */
public class Sudkou {
    public static void main(String[] args) {
        Sudkou sudkou = new Sudkou();
        char[][] board =
               {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        sudkou.solveSudoku(board);
    }
    public void solveSudoku(char[][] board) {
        List<Set<Character>> col = new ArrayList<>();
        for(int i=0;i<9;++i){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<9;++j){
                set.add(board[j][i]);
            }
            col.add(new HashSet<>(set));
        }
        char[] nums = new char[]{'1','2','3','4','5','6','7','8','9'};
        recursion(0,0,board,new HashSet<>(),col,nums);
        for (char[] cs : board){
            for (char c : cs)
                System.out.print(c+"\t");
            System.out.println();
        }
    }
    private boolean res = false;
    //对每一列进行枚举
    public void recursion(int col,int row,char[][]board,Set<Character> rows,List<Set<Character>> cols,char[] nums){
        if(col==9){
            if (row == 9)return;
            recursion(0,row+1,board,new HashSet<>(),cols,nums);
        }
        //这一行刚开始遍历
        if (col==0){
            for (char c : board[row]){
                if (c!='.')rows.add(c);
            }
        }



    }
    public  void reCol(int col,char[] rows,Set<Character> row,List<Set<Character>> cols,char[] nums){
        if (col == 9)return;

    }
}

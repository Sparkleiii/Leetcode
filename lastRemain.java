import java.util.ArrayList;
import java.util.List;

public class lastRemain {
    public static int lastRemaining(int n, int m) {
        //递归？
        //初始状态
        //循环状态
        //递归公式
        //模拟链表
        /*List<Integer> nlist = new ArrayList<>();
        for(int i =0;i<=n;i++){
            nlist.add(i);
        }
        // 终止循环的条件，链表长度为1
        int index = 0;
        while(n!=1){
            //计算删除的index
            index = (index+m-1) % n;
            nlist.remove(index);
            System.out.println(nlist);
            n--;
        }

        return nlist.get(0);*/
        // 什么原理？
        // 约瑟夫环问题
        //反过来求
/**
 * 0,1,2,3,4,0,1,2,3,4  3=(0+3)%5
 * 3,4,0,1,3,4,0,1      0=(1+3)%4
 * 1,3,4,1,3,4          1=(1+3)%3
 * 1,3,1,3              1=(0+3)%2
 * 3                    0
 */
        int flag = 0;
        for(int i=2; i <=n;i++){
            flag = (flag + m)%i;
            System.out.println(flag);
        }
        return flag;
    }


    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
int i=1;
int sum=5;
        System.out.println(test(5,1));

    }
    /***
     * 可供的实现方法;
     * 1： 递归：
     * 2： 栈： 操作 （不知道违不违反规则）
     * 3： 新建链表法;(迭代法)
     * 4：
     */

    //todo  1： 递归：

    /***
     * 每次递归传入的参数就在递归的过程中定死了；不会改变！！！
     * 然后倒着进行每次计算
     */
    public  static  int test(int sum,int i){

        if (i>5)return sum;

        sum=sum*i;
        i++;
        test(sum, i);
        System.out.println("sum=sum*i:"+"sum: "+sum+"i:"+i);
        return sum;


    }
}
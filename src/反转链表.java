import java.util.Stack;

public class 反转链表 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        /***
         * 只能选一个输出方法输出；因为对源链表做出了修改/
         */
        sout(head);
        System.out.println();
        //   sout(reverseDiGui(head));
      //  sout(reverseXinJianLianBiao(head));
//sout(reverseZhan(head));
sout(reverseDieDaiFa(head));
        //  sout(reverseZhan1(head));


        //sout(head);


        //sout(test(head));
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void sout(Node head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
    }


    /****
     * @param head
     * @return 反序列的链表
     * 思路： 倒着赋值;递归的特性
     * 把一个链表前后分开，后面是倒序过后的链表
     */
    public static Node reverseDiGui(Node head) {
        if (head==null||head.next==null)return head;//递归的返回条件为空就返
        Node rehead =reverseDiGui(head.next);//触底。直接寻找到7-》9
        //对传入的参数做处理，将本次的参数倒置，并将参数剪短，控制每次处理参数为两个
        head.next.next=head;
        head.next=null;
        return  rehead;
    }

    /***
     * // 栈： 操作（integer） （不知道违不违反规则）
     * @param head 传入值
     * @return 新的头节点
     *  rehead 重新赋值的链表中 负责遍历操作时使用
     *  header 💥记录重新赋值的链表的头节点位置，不然返回值不能操作（输出本质还是一次遍历） 这不会导致无法输出
     */

    public static Node reverseZhan(Node head) {
        Node rehead = head; //做新节点遍历重新赋值操作
        Node header = head;//💥记录头节点位置；
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (head != null) {
            stack.push(head.value);
            head = head.next;
            i++;
        }//将链表元素全部写入
        while (i != 0) {
            rehead.value = stack.pop();
            rehead = rehead.next;
            i--;
        }

        return header;//返回的是末尾值
    }

    /***
     * // 栈： 操作（Node）
     * @param head 传入值
     * @return 新的头节点
     *  head 重新赋值的链表中 负责遍历操作时使用；直接在源链表上操作
     *  temp💥记录重新赋值的链表的头节点位置，不然返回值不能操作（输出本质还是一次遍历） 这不会导致无法输出
     */
    public static Node reverseZhan1(Node head) {

        Stack<Node> stack = new Stack<>();
        //压栈     1.把链表中的节点入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (!stack.isEmpty()) head = stack.pop();
        else return null;//创建头节点记录位置
        Node temp = head;  //💥head记录头指针位置；temp做遍历
        while (!stack.isEmpty()) {
            temp.next = stack.pop();//pop出来的是一串 所以可以直接在next节点上重新覆盖，以达到重写目的
            temp = temp.next; //在下一个节点做操作等同于截断
        }
        temp.next = null;//将最后一个截断只要他的一个节点；不然就循环了
        return head;

    }
    /***
     *新建链表法
     * 把链表每次循坏要处理的后节点（head.next一串）保存下到新节点（temp）后
     * 然后做交换
     * 把后节点还回来
     * @param head
     * @return
     */

    public static Node reverseXinJianLianBiao(Node head) {
        Node rehead=null;
        while (head!=null) {
            Node temp = head.next;//把要取出的节点的后节点保存
            head.next=rehead;//把要取出的节点的后节点断开
            rehead=head;//给新结点赋值
            head=temp;//还回来后节点
        }
        return rehead;
    }
    //todo 迭代法
    /***
     * curr 指向链表的当前节点，next 保存curr节点的下一个节点
     * （因为是单链表，不保存的话，改变方向之后就找不到旧节点的下个节点了）
     *，prev刚开始值为空，保存当前节点的前一个节点。
     * 等同于新建链表
     */
    public static Node reverseDieDaiFa(Node head){
        Node prev=null;
        while (head!=null) {

            Node next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}

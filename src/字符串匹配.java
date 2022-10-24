import java.util.Arrays;

public class 字符串匹配 {
    //todo 暴力解法 挨个匹配

    public static void main(String[] args) {
//        char[] sun = "ababaaababaa".toCharArray();
//        char[] father = "werawrfababaaaababaaadaababaaababaaggasd".toCharArray();
//        System.out.println(Arrays.toString(next(sun)));
//        System.out.println(KMP(next(sun), sun, father));
       char[] test = "aaaa".toCharArray();
        char[] test1 = "aaabcaaaa".toCharArray();
        System.out.println(Arrays.toString(next(test)));
        System.out.println(KMP(next(test), test, test1));
        System.out.println(BaoLi(test, test1));
    }

    /****
     * next算法：
     * 第一位的next值为0，第二位的next值为1，后面求解每一位的next值时，
     * 根据前一位进行比较。首先将前一位与其next值对应的内容进行比较，
     * 如果相等，则该位的next值就是前一位的next值加上1；
     * 如果不等，💥向前继续寻找next值对应的内容来与前一位进行比较，  //向前寻找（next数组前移一位）不是类推！！！！！
     * 直到找到某个位上内容的next值对应的内容与前一位相等为止，则这个位对应的值加上1即为需求的next值；
     * 如果找到第一位都没有找到与前一位相等的内容，那么需求的位上的next值即为1。
     *
     * @param sun 要使用next算法处理的字串
     * @return 处理好的字串的next值
     */
    public static int[] next(char[] sun) {
        int[] next = new int[sun.length];
        int i = 1;
        int j;
        while (i < next.length) {
            j = i - 1;
            while (true) {
                if (next[j] == 0 || sun[i - 1] == sun[next[j] - 1]) {
                    next[i] = next[j] + 1;
                    break;
                }
                j = next[j] - 1;
            }
            i++;


        }
        return next;
    }

    /***
     * KMP算法
     * @param next 处理好的next数组
     * @param sun   子串
     * @param father 父串
     * @return 是否匹配
     */
    public static boolean KMP(int[] next, char[] sun, char[] father) {
        int i = 0;
        int j = 0;
        while (i < father.length) {
            if (father[i] == sun[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else j = next[j - 1];//回溯的值是对应next数组的前一位！
                /**
                 * 解释：j = next[j - 1];
                 * 目标串S：abdababxqweqwer
                 * 模式串T：abdababy
                 * 对应next[0, 1, 1, 1, 2, 3, 2, 3]
                 * 应该移动到如下
                 * abdababxqweqwer
                 * 11111abdababy    💥   j=7时：x！=y 重赋值时 j=2  sun[2]=d此时：j=next[j-1]=>j=next[7-1]=>j=2.
                 */
            }
            if (j == sun.length) return true;
        }
        return false;
    }
    public static boolean BaoLi(char[] sun , char[] father){
        int i = 0;
        int j = 0;
        while (i < father.length) {
            if (father[i] == sun[j]) {
                i++;
                j++;
            }else {
                j=0;
                i++;
            }
            if (j== sun.length)return true;
        }
        return false;
    }
}

package me.stormma.nowcoder.bytedance._2018;

import java.util.*;

/**
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型
 * <p>
 * <p>
 * 输出描述:
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 * <p>
 * 输入例子1:
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 * <p>
 * 输出例子1:
 * 1
 * 0
 * 2
 * <p>
 * 例子说明1:
 * 样例解释:
 * 有5个用户，喜好值为分别为1、2、3、3、5，
 * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 *
 * @author stormma
 * @date 2018/03/08
 */
public class Question1 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int n = in.nextInt();
        int[] aux = new int[n + 1];
        for (int i = 1; i < aux.length; i++) {
            aux[i] = in.nextInt();
        }
        int cnt = in.nextInt();
        //new Question1().solve1(aux, cnt);
        new Question1().solve2(aux, cnt);
    }

    public void solve1(int[] aux, int cnt) {
        for (int i = 0; i < cnt; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int k = in.nextInt();
            int res = 0;
            for (int j = left; j <= right; j++) {
                if (aux[j] == k) res++;
            }
            System.out.println(res);
        }
    }

    public void solve2(int[] aux, int cnt) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 1; i < aux.length; i++) {
            if (index.get(aux[i]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                index.put(aux[i], list);
            } else {
                //index.get(aux[i]).add(i);
                List<Integer> list = index.get(aux[i]);
                list.add(i);
                index.put(aux[i], list);
            }
        }
        for (int i = 0; i < cnt; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int k = in.nextInt();
            int t, x;
            int ans = (t = binarySearch(index.get(k), right, false)) - (x = binarySearch(index.get(k), left, true)) + 1;
            System.out.println(x + "------->" + t);
            System.out.println(ans);
        }
    }



    private int binarySearch(List<Integer> list, int target, boolean isLeft) {
        int low = 0, high = list.size() - 1;
        while (true) {
            boolean flag = false;
            if (low <= high) {
                int mid = (low + high) >> 1;
                if (list.get(mid) > target) {
                    high = mid - 1;
                    flag = true;
                } else if (list.get(mid) < target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            if (low > high) return flag ? high + 1 : low - 1;
        }
        // [1]
        // 0
        // mid = 0
        // low = 1 high = 0;
        //
        //
        // return isLeft ? low + 1 : low - 1;
    }
}

// 0 + 0 / 2 = 0
// low = 1, high = 0;

// 1 > 0
// high = -1

// low = 0;


//[5]
// 2,
//5 > 2
// ans = min(mid, ans)
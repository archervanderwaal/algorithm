package me.stormma.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串有限自动机匹配算法实现
 * @author stormma
 * @date 2018/03/25
 */
public class StringAutomaton {

    /**
     * 待匹配模式
     */
    private String pattern;

    private static Map<Integer, Map<Character, Integer>> stateTransferTable;

    private static final int CHARACTER_SIZE = 26;

    public StringAutomaton(String pattern) {
        this.pattern = pattern;
    }

    public StringAutomaton build() {
        stateTransferTable = new HashMap<>();
        int length = pattern.length();
        for (int state = 0; state <= length; state++) {
            for (int k = 0; k < CHARACTER_SIZE; k++) {
                char ch = (char) ('a' + k);
                int nextState = findMaxMatchLength(pattern.substring(0, state) + ch);
                if (stateTransferTable.get(state) == null) {
                    Map<Character, Integer> map = new HashMap<>();
                    map.put(ch, nextState);
                    stateTransferTable.put(state, map);
                } else {
                    stateTransferTable.get(state).put(ch, nextState);
                }
            }
        }
        return this;
    }

    /**
     * 计算dummy字符串的后缀与pattern前缀最大匹配长度
     * @param dummy
     * @return
     */
    private int findMaxMatchLength(String dummy) {
        int maxMatchLength = 0, tmp = 0;
        while (tmp < dummy.length() && tmp < pattern.length()) {
            int i = 0;
            for (; i <= tmp; i++) {
                if (dummy.charAt(dummy.length() - 1 - tmp + i) != pattern.charAt(i)) {
                    break;
                }
            }
            if (i - 1 == tmp) {
                maxMatchLength = tmp + 1;
            }
            tmp++;
        }
        return maxMatchLength;
    }

    public int match(String txt) {
        Integer currentState = 0;
        int hit = -1;
        for (char ch : txt.toCharArray()) {
            hit++;
            Map<Character, Integer> map = stateTransferTable.get(currentState);
            Integer preState = currentState;
            currentState = map.get(ch);
            if (currentState == null) {
                throw new IllegalArgumentException("匹配出错, 请检查输入文本是否包含不支持的字符!");
            }
            if (currentState == pattern.length()) {
                return hit - pattern.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StringAutomaton automaton = new StringAutomaton("abababaca");
        String txt = "ababababacaba";
        System.out.println(automaton.build().match(txt));
    }
}

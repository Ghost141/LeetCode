package traing.prob726;

import java.util.*;

/**
 * Number of Atoms
 * Link: https://leetcode.com/problems/number-of-atoms/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Atom>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        char[] chars = formula.toCharArray();
        for (int i = 0; i < chars.length;) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                int j = i + 1;
                while (j < chars.length && !Character.isUpperCase(chars[j]) && !Character.isDigit(chars[j])
                        && chars[j] != '(' && chars[j] != ')') {
                    j++;
                }
                String atom = formula.substring(i, j);
                i = j;
                j = i;
                while (j < formula.length() && Character.isDigit(chars[j])) j++;
                if (j != i) {
                    int num = Integer.valueOf(formula.substring(i, j));
                    stack.peek().computeIfAbsent(atom, (Atom::new)).count += num;
                } else { // only one.
                    stack.peek().computeIfAbsent(atom, (Atom::new)).count += 1;
                }
                i = j;
            } else if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                int j = i + 1;
                while (j < formula.length() && Character.isDigit(chars[j])) j++;
                int num = 1;
                if (j != i + 1) {
                    num = Integer.valueOf(formula.substring(i + 1, j));
                }
                Map<String, Atom> map = stack.pop();
                for (Map.Entry<String, Atom> entry : map.entrySet()) {
                    stack.peek().computeIfAbsent(entry.getKey(), (Atom::new)).count += entry.getValue().count * num;
                }
                i = j;
            }
        }
        ArrayList<Atom> values = new ArrayList<>(stack.pop().values());
        Collections.sort(values);
        StringBuilder builder = new StringBuilder();
        for (Atom atom : values) {
            builder.append(atom.title);
            if (atom.count > 1) {
                builder.append(atom.count);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countOfAtoms("Mg(OH)2"));
    }

    class Atom implements Comparable<Atom> {
        String title;
        int count = 0;

        public Atom(String title) {
            this.title = title;
        }

        @Override
        public int compareTo(Atom o) {
            return this.title.compareTo(o.title);
        }
    }
}

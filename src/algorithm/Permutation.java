package algorithm;

import java.util.List;

/**
 * Given a string s, output all permutation of its character.
 *
 * @author zhaokai
 */
public class Permutation {
    public List<String> permutation(String s) {
        _permutation(s.split(""), 0, s.length() - 1);
        return null;
    }

    private void _permutation(String[] data, int first, int end) {
        if (first == end) {
            for (int j = 0; j <= end; j++) {
                System.out.print(data[j]);
            }
            System.out.println();
        }

        for (int i = first; i <= end; i++) {
            swap(data, i, first);
            _permutation(data, first + 1, end);
            swap(data, i, first);
        }
    }

    private String[] swap(String[] data, int a, int b) {
        String s = data[b];
        data[b] = data[a];
        data[a] = s;

        return data;
    }

    public static void main(String[] args) {
        final Permutation permutation = new Permutation();

        permutation.permutation("abc");

    }
}

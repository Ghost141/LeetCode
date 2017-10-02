package traing.prob174;

import utils.DataGenerator;

/**
 * Dungeon Game
 * Link: https://leetcode.com/problems/dungeon-game/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        dungeon[m - 1][n - 1] = Math.max(1, dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) dungeon[i][n - 1] = Math.max(1, dungeon[i + 1][n - 1] - dungeon[i][n - 1]);
        for (int i = n - 2; i >= 0; i--) dungeon[m - 1][i] = Math.max(1, dungeon[m - 1][i + 1] - dungeon[m - 1][i]);
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                dungeon[i][j] = Math.min(
                        Math.max(1, dungeon[i + 1][j] - dungeon[i][j]),
                        Math.max(1, dungeon[i][j + 1] - dungeon[i][j]));
        return dungeon[0][0];
    }

    public int calculateMinimumHPDP(int[][] dun) {
        int m = dun.length;
        int n = dun[0].length;
        int i,j;



        dun[m-1][n-1]=Math.max(1,1-dun[m-1][n-1]);

        for(i=m-2;i>=0;i--) dun[i][n-1] = Math.max(1,dun[i+1][n-1]-dun[i][n-1]);
        for(i=n-2;i>=0;i--) dun[m-1][i] = Math.max(1,dun[m-1][i+1]-dun[m-1][i]);

        for(i=m-2;i>=0;i--)
            for(j=n-2;j>=0;j--)
                dun[i][j]=Math.min(
                        Math.max(1,dun[i+1][j]-dun[i][j]),
                        Math.max(1,dun[i][j+1]-dun[i][j]));



        return dun[0][0];

    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.calculateMinimumHP(DataGenerator.createIntMatrix("-2,-3,3|-5,-10,1|10,30,-5")));
        System.out.println(s.calculateMinimumHPDP(DataGenerator.createIntMatrix("100")));
    }
}

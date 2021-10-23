public class coinChange {
    // infinite permutations
    public static int infiPermutations(int[] coins, int tar, String asf) {
        if(tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < coins.length; i++) {
            if(tar - coins[i] >= 0) {
                count += infiPermutations(coins, tar - coins[i], asf + coins[i]);
            }
        }

        return count;
    }
    //=========================================================================
    //infinite combinations
    public static int infiCombinations(int[] coins, int tar, int idx, String asf) {
        if(tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < coins.length; i++) {
            if(tar - coins[i] >= 0) {
                count += infiCombinations(coins, tar - coins[i], i, asf + coins[i]);
            }
        }
        return count;
    }

    //============================================================================
    //single combination
    public static int singleCombination(int[] coins, int tar, int idx, String asf) {
        if(tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < coins.length; i++) {
            if(tar - coins[i] >= 0) {
                count += singleCombination(coins, tar - coins[i], i + 1, asf + coins[i]);
            }
        }
        return count;
    }

    //========================================================================================
    //single permutation


    //using space
    public static int singlePermutation(int[] coins, int tar, boolean[] visited, String asf) {
        if(tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < coins.length; i++) {
            if(tar - coins[i] >= 0) {
                if(!visited[i]) {
                    visited[i] = true;
                    count += singlePermutation(coins, tar - coins[i], visited, asf + coins[i]);
                    visited[i] = false;
                }
            }
        }
        return count;
    }

    //without space
    public static int singlePermutation01(int[] coins, int tar, String asf) {
        if(tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < coins.length; i++) {
            if(tar - coins[i] >= 0) {
                if(coins[i] > 0) {
                    int val = coins[i];
                    coins[i] -= val;
                    count += singlePermutation01(coins, tar - val, asf + val);
                    coins[i] = val;
                }
            }
        }
        return count;
    }

    //===========================================================================================

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 7};
        // System.out.println(infiPermutations(coins, 10, ""));
        // System.out.println(infiCombinations(coins, 10, 0, ""));
        // System.out.println(singleCombination(coins, 10, 0, ""));
        boolean [] visited = new boolean[coins.length];
        //System.out.println(singlePermutation(coins, 10, visited, ""));
        System.out.println(singlePermutation01(coins, 10, ""));
    }
}
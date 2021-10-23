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

    //subsequence method
    public static int infiPermutationsSubseq(int[] coins, int idx, int tar, String asf) {
        if(tar == 0 || idx >= coins.length) {
            if(tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0) {
            count += infiPermutationsSubseq(coins, 0, tar - coins[idx], asf + coins[idx]);
        }

        count += infiPermutationsSubseq(coins, idx + 1, tar, asf);

        return count;
    }

    //===========================================================================================
    public static int singleCombinationSubseq(int[] coins, int idx, int tar, String asf) {
        if(tar == 0 || idx >= coins.length) {
            if(tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0) {
            count += singleCombinationSubseq(coins, idx + 1, tar - coins[idx], asf + coins[idx]);
        }
        count += singleCombinationSubseq(coins, idx + 1, tar, asf);

        return count;
    }

    //============================================================================================
    public static int infiCombinationSubseq(int[] coins, int idx, int tar, String asf) {
        if(tar == 0 || idx >= coins.length) {
            if(tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0) {
            count += infiCombinationSubseq(coins, idx, tar - coins[idx], asf + coins[idx]);
        }
        count += infiCombinationSubseq(coins, idx + 1, tar, asf);

        return count;
    }

    //=================================================================================================
    public static int singlePermutationSubseq(int[] coins, int idx, int tar, String asf, boolean[] vis) {
        if(tar == 0 || idx >= coins.length) {
            if(tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0) {
            if(!vis[idx]) {
                vis[idx] = true;
                count += singlePermutationSubseq(coins, 0, tar - coins[idx], asf + coins[idx], vis);
                vis[idx] = false;
            }
        }
        count += singlePermutationSubseq(coins, idx + 1, tar, asf, vis);

        return count;
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 7};
        // System.out.println(infiPermutations(coins, 10, ""));
        // System.out.println(infiCombinations(coins, 10, 0, ""));
        // System.out.println(singleCombination(coins, 10, 0, ""));
        boolean [] visited = new boolean[coins.length];
        //System.out.println(singlePermutation(coins, 10, visited, ""));
        //System.out.println(singlePermutation01(coins, 10, ""));
        //System.out.println(singleCombinationSubseq(coins, 0, 10, ""));
        //System.out.println(infiCombinationSubseq(coins, 0, 10, ""));
        //System.out.println(infiPermutationsSubseq(coins, 0, 10, ""));
        //System.out.println(singlePermutationSubseq(coins, 0, 10, "", visited));
    }
}
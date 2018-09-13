/**
A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For more info: https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
*/

//Detected time complexity: O(N + M)

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int sLength = S.length();
        int pLength = P.length;
        int[] results = new int[pLength];
        int[][] prefixes = new int[sLength][4];
        
        for (int i = 0; i < sLength; i++) {
            char c = S.charAt(i);
            switch (c) {
                case 'A': prefixes[i][0] = 1;
                    break;
                case 'C': prefixes[i][1] = 1;
                    break;
                case 'G': prefixes[i][2] = 1;
                    break;
                case 'T': prefixes[i][3] = 1;
                    break;
            }
        }
        
        for (int i = 1; i < sLength; i++) {
            for (int j = 0; j < 4; j++) {
                prefixes[i][j] += prefixes[i - 1][j];
            }
        }
        
        for (int i = 0; i < pLength; i++) {
            int p = P[i];
            int q = Q[i];
            for (int j = 0; j < 4; j++) {
                int rightEnd = prefixes[q][j];
                int leftEnd = 0;
                if (p - 1 >= 0)
                    leftEnd = prefixes[p - 1][j];
                
                if (rightEnd - leftEnd > 0) {
                    results[i] = j + 1;
                    break;
                }
            }
        }
        return results;
    }
}



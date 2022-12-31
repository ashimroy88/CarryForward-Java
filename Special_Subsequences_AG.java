//Problem Description
//You have given a string A having Uppercase English letters.
//You have to find how many times subsequence "AG" is there in the given string.
//NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
//Input Format
//First and only argument is a string A.
//
//Output Format
//Return an integer denoting the answer. v
//Example Input
//Input 1:
// A = "ABCGAG"
//Input 2:
// A = "GAB"
//Example Output
//Output 1:
// 3
//Output 2:
// 0


//Array_support:
public class Special_Subsequences_AG {
    public int solve(String A) {
        int count_A=0;
        int ans=0;

        int mod=(int)(Math.pow(10,9))+7;

        for(int i=0;i<A.length();i++){

            if(A.charAt(i)=='A')
            {
                count_A++;
            }

            if(A.charAt(i)=='G')
            {
                //ans+=a;
                ans = ans + count_A;
                ans%=mod;
            }
        }
        return ans;
    }
}


//2nd approach

public class Solution {
    public int solve(String A) {
        int count = 0;
        int ans = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == 'A'){
                count++;
            } else if(A.charAt(i) == 'G'){
                ans += count;
            }
            ans %= 1000000007;
        }
        return ans % 1000000007 ;
    }
}


//3rd approach

public class Solution {
    public int solve(String A) {
        int A_count=0;
        int ag_count=0;
        int N=A.length();
        int modulo= (int)Math.pow(10,9)+7;
        for(int i=0;i<N;i++){
            if(A.charAt(i)=='A'){
                A_count++;
            }
            if(A.charAt(i)=='G'){
                ag_count=(ag_count+A_count)%modulo;
            }
        }

        return ag_count;
    }
}


//Here coming backwards, that’s why first g then A

public class Solution {
    public int solve(String A) {
        char[] ch = A.toCharArray();
        int ans=0;
        int count=0;
        int modulo = (int) Math.pow(10, 9) + 7; // this is done for the Note value
        for(int itr=ch.length-1;itr>=0;itr--){
            if(ch[itr]=='G'){
                count++;
            }else if(ch[itr]=='A'){
                ans=(ans+count)%modulo;
            }
        }
        return ans;
    }
}


//another approach

public class Solution {
    public int solve(String A) {
        long countOfA=0;
        long countOfAG=0;
        int modulo= (int)(Math.pow(10,9)+7);
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='A')
                countOfA++;
            else if(A.charAt(i)=='G')
                countOfAG+=countOfA;
        }
        return (int)(countOfAG%modulo);
    }
}


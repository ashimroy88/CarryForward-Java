//Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
//and at least one occurrence of the minimum value of the array.
//Output Format
//Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
//Example Inputv
//Input 1:
//A = [1, 3]
//Input 2:
//A = [2]
//
//Example Output
//Output 1:
// 2
//Output 2:
// 1

public class Closest_MinMax {
    public int solve(int[] A) {
        int min=A[0];    //defining first elem as min & max
        int max=A[0];
        for(int i=1;i<A.length;i++){      //iterating from 2nd elem till end;
            min=Integer.min(A[i],min);    //setting the lowest elem as min amoung all elem;
            max=Integer.max(A[i],max);    //setting the heighest elem as max amoung all elem;
        }

        int min_Index=-1;
        int max_Index=-1;
        int sml_Length=A.length;

        if(min==max) return 1;           //critical condition if all elem are same

        for(int i=0;i<A.length;i++){          //iterating over 1st to last elem
            if(max==A[i])                 // if max found
                max_Index=i;                        //reset max elem ka index
            else if(min==A[i])             // if min found
                min_Index=i;                 //reset min elem ka index

            if(min_Index!=-1 && max_Index!=-1){       //if max & min elem exists
                int diff=(Math.abs(max_Index-min_Index))+1;
                if(sml_Length>diff)
                    sml_Length=diff;
            }
        }
        return sml_Length;
    }
}


//Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
//An element is a leader if it is strictly greater than all the elements to its right side.
//NOTE:The rightmost element is always a leader.
//Input Format
//First and only argument is an integer array A.
//Output Format
//Return an integer array denoting all the leader elements of the array.
//Input 1:
// A = [16, 17, 4, 3, 5, 2]
//Input 2:
// A = [1, 2]
//Example Output
//Output 1:
// [17, 2, 5]
//Output 2:
// [2]

public class Leaders_in_an_Array {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = A.size();
        int max_val = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (A.get(i) > max_val) {
                max_val = A.get(i);
                //answer++;
                ans.add(A.get(i));
            }

        }
        return ans;
    }
}

//Using Arraylist:

public class Solution {
    public int[] solve(int[] A) {
        //int answer = 0;
        int count=1;   // by default right most elem is a leader
        int max=A[A.length-1];   //defining an variable which holds the last elem of A;
        for(int i=A.length-2;i>=0;i--){    //right to left
            if(max<A[i]){
                max=A[i];
                count++;}
        }
        int[] Solu=new int[count];   //a new array which we will return
        max=A[A.length-1];     // setting the last elem as MAX
        Solu[0]=max;          //putting the last elem at 0th index in returned array Solu
        int index=0;
        for(int i=A.length-2;i>=0;i--){   //right to left
            if(max<A[i]){                // checking for leader
                index++;                    //increasing if leader found
                Solu[index]=A[i];       //putting th enewly found leader at next index
                max=A[i];}               //setting new max for next iteration.
        }
        return Solu;
    }
}


//Arraylist 2nd approach

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int max = A.get(A.size()-1);  //last elem as max
        result.add(max);   //adding the last elem to returned ArrayList
        for(int i =A.size()-2;i>=0;i--)  //second last elem to left
        {
            if(A.get(i)>max)     //checking if greater
            {
                max = A.get(i);    // restoring max
                result.add(max);     //adding to arraylist
            }
        }
        return result;
    }
}


//Using Array:  in O(N)

public class Solution {
    public int[] solve(int[] A) {
        int leader=A[A.length-1];       //defining an variable which holds the last elem of A;
        int count=1,x;      // by default right most elem is a leader
        //first to know how many leader elements are present in the given array
        for(int i=A.length-2;i>=0;i--)    //right to left
        {
            if(A[i]>leader)
            {
                leader=A[i];
                count++;
            }
        }

        //take the count of leader elements, create an array and put all the elements in it
        int []leaders = new int[count];   //a new array which we will return
        x=count;              //no of leader element stored in x
        leader=A[A.length-1];    //  setting the last elem of main array as leader
        for (int i=A.length-1;i>=0;i--)     //right to left of main array
        {
            if(A[i]>=leader)            // checking for leader
            {
                leader=A[i];               //setting new leader for next iteration.
                leaders[count-x]=leader;   //3-3=0 th location for first elem
                x--;                      // x becomes 2, so 3-2=1, 3-1=2, 3-0=3
            }
        }
        return leaders;
    }
}

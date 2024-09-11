import java.util.Scanner;
public class Main{
    public static int findDuplicate(int[] arr) {
        // Initialize slow and fast pointers
        int slow = arr[0];
        int fast = arr[0];
        
        // Move slow pointer one step and fast pointer two steps
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        
        // Find the entrance to the cycle
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0;i<n+1;i++)
        {
            arr[i]=sc.nextInt();
        }
        int Dup_Num = findDuplicate(arr);
        
        System.out.println("Duplicate Number: " + Dup_Num);
    }
}

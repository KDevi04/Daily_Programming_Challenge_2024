import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
    public static ArrayList<Integer> findLeaders(int arr[],int n)
    {
        ArrayList<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[n-1];
        leaders.add(maxFromRight);
        
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>maxFromRight)
            {
                maxFromRight=arr[i];
                leaders.add(maxFromRight);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=leaders.size()-1;i>=0;i--)
        {
            result.add(leaders.get(i));
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> leaders = findLeaders(arr,n);
        System.out.println("Leaders :"+leaders);
    }
}

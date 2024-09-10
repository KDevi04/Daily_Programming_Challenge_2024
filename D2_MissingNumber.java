import java.util.Scanner;
class Miss
{
    static int missNumber(int a[],int n)
    {
        int total_sum=n*(n+1)/2;
        int actual_sum=0;
        for(int num:a)
        {
            actual_sum+=num;
            System.out.println(actual_sum);
        }
        return total_sum-actual_sum;
    }
}
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Miss obj=new Miss();
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] a = new int[n-1];
        System.out.println("Enter distinct elements in the given range : ");
        for(int i=0;i<n-1 ;i++)
        {
            a[i]=sc.nextInt();
        }
        int miss_number=obj.missNumber(a,n);
        System.out.println("Missing number is :"+miss_number);
        sc.close();
    }
}

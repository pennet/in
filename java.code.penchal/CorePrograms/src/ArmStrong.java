
import java.util.*;
public class ArmStrong {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any Value : ");
        int num = sc.nextInt();
        int temp = num;
        int rem = 0 , sum = 0;
        while(num > 0)
        {
            rem = num % 10;
            sum = sum + (rem * rem * rem);
            num = num / 10;
        }
        if(temp == sum)
        {
            System.out.println(temp + " is a ArmStrong ");
        }
        else
        {
            System.out.println(temp + " is not a ArmStrong ");
        }
    }
}

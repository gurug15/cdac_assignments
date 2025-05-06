import java.util.Arrays;

public class Que66 {

	public static int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        for(int i=digits.length-1;i>=1;i--) {
        	if(digits[i]>=10) {
        		digits[i-1] = digits[i-1] + 1;
        		digits[i]=digits[i]%10;
        		
        	}
        }
        if (digits[0]==10) { 
        
        int arr[] = new int[digits.length+1];
        arr[0] = 1;
        return arr;
        }
        
        return digits;
    }
	
	
	public static void main(String[] args) {
		int arr[] = {4,9,9};
		System.out.println(Arrays.toString(plusOne(arr)));
		System.out.println(Arrays.toString(arr));
	}

}

package medium.amazon;

import java.util.HashMap;

public class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman2(400));
	}
	
    public static String intToRoman(int num) {
        HashMap<Integer, Character> amap = new HashMap<>();
        amap.put(1, 'I');
        amap.put(5, 'V');
        amap.put(10, 'X');
        amap.put(50, 'L');
        amap.put(100, 'C');
        amap.put(500, 'D');
        amap.put(1000, 'M');
        
        String res = "";
        int[] thresholds = new int[] {1000, 100, 10, 1};
        for(int i=0; i<thresholds.length; ++i) {
        	int curr = num/thresholds[i];
        	if(curr > 0) {
        		if(curr==4 || curr==9) {
            		res = res + amap.get(thresholds[i])+amap.get((curr+1)*thresholds[i]);
            		curr = 0;
            	}
        		else if(curr>=5) {
        			res = res + amap.get(5*thresholds[i]);
        			curr -= 5;
        		}
        		if(curr > 0){
        			for(int j=0; j<curr; j++) {
        				res = res + amap.get(thresholds[i]);
        			}
        		}
        		num %= thresholds[i];
            }
        }
        return res;
    }
    
    public static String intToRoman2(int num) {
    	int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
    	StringBuilder res = new StringBuilder();
    	for(int i=0; i<numbers.length; ++i) {
    		while(numbers[i]<=num) {
    			num -= numbers[i];
    			res.append(romans[i]);
    		}
    	}
    	return res.toString();
    }
}

package hard.amazon;

public class IntegerToEnglish273 {
	public static void main(String[] args) {
		System.out.println(numberToWords(1234567891));
	}
	
	public static String numberToWords(int num) {
        int[] split = new int[4];
        int parts=1;
        while(parts<=4){
            int scaleFactor = (int)Math.pow(10, 3);
            split[parts-1] = num%scaleFactor;
            num = num/scaleFactor;
            if(num==0) break;
            parts++;
        }
        String[] connect = {"", " Thousand", " Million", " Billion"};
        StringBuilder res = new StringBuilder();
        for(int i=0; i<parts; ++i){
        	if(split[i] == 0) continue;
            res.insert(0, connect[i]);
            res.insert(0, threeDigitHelper(split[i]));
        }
        return res.toString().trim();
    }
    
    public static String threeDigitHelper(int num){
        StringBuilder res = new StringBuilder();
        String[] ones={"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        String[] tens={"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninty"};
        String[] teens = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        
        for(int i=1; i<=3; ++i){
            int scaleFactor = (int)Math.pow(10, 3-i);
            int curr = num/scaleFactor;
            num = num%scaleFactor;
            if(curr<=0) continue;
            if(i==1 || i==3){
                res.append(ones[curr]);
            }
            if(i==2){
                if(curr==1){
                    res.append(teens[num]);
                    break;
                }else
                    res.append(tens[curr]);
            }
            if(i==1)
                res.append(" Hundred");
        }
        return res.toString();
    }
}

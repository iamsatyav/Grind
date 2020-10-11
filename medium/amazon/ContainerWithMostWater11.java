package medium.amazon;

public class ContainerWithMostWater11 {
	public static void main(String[] args) {
		int[] height = {2,3,4,5,18,17,6};
		System.out.println(maxArea(height));
	}
	
    public static int maxAreaBrute(int[] height) {
    	int res = 0;
        for(int i=0; i<height.length-1; ++i) {
        	for(int j=i+1; j<height.length; ++j) {
        		int temp = Math.min(height[i], height[j]) * (j-i);
        		if(temp > res) res = temp;
        	}
        }
        return res;
    }
    
    public static int maxArea(int[] height) {
    	int i=0, j=height.length-1, res=0;
        while(i<j){
            res = Math.max(Math.min(height[i], height[j]) * (j-i), res);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return res;
    }
}

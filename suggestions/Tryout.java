package suggestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

public class Tryout {
	public static void main(String[] args) {
//		Check temp = Check.OPEN;
//		System.out.println(temp.getText() + "  "+temp.getNumber());
//		for(Check ea: Check.values()) {
//			if(ea.getNumber() == 2) {
//				System.out.println( ea.getText());
//				break;
//			}
//		}
		List<Integer> alist = Arrays.asList(1,3,7,2,4,1);
		Collections.sort(alist);
		for(int ea:alist) {
			System.out.print(ea+"  ");
		}
	}
}

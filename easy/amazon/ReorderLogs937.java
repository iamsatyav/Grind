package easy.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogs937 {
	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		leetSol(logs);
	}
	
	public static void mySolution(String[] logs) {
		int n = logs.length;
		String[] res = new String[n];
		int currD = n-1;
		for(int i=n-1; i>=0; --i) {
			if(Character.isDigit(logs[i].split(" ",2)[1].charAt(0))) {
				res[currD--] = logs[i];
				logs[i] = null;
			}
		}
		
		int currL = 0;
		for(int i=0; i<n;++i) {
			if(logs[i]!=null) {
				for(int j=i+1;j<n;++j) {
					if(logs[j]!=null) {
						String i1 = logs[i].split(" ", 2)[0];
						String i2 = logs[i].split(" ", 2)[1];
						String j1 = logs[j].split(" ", 2)[0];
						String j2 = logs[j].split(" ", 2)[1];
						if(i2.compareTo(j2) > 0 || (i2.compareTo(j2) == 0 && 
								i1.compareTo(j1) > 0)) {
							String temp = logs[i];
							logs[i] = logs[j];
							logs[j] = temp;
						}
					}
				}
				res[currL++] = logs[i];
			}
		}
		System.out.println(Arrays.deepToString(res));
	}
	
	public static void leetSol(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {

			@Override
			public int compare(String log1, String log2) {
				String[] la = log1.split(" ", 2);
				String[] lb = log2.split(" ", 2);
				boolean isDigit1 = Character.isDigit(la[1].charAt(0));
				boolean isDigit2 = Character.isDigit(lb[1].charAt(0));
				if(!isDigit1 && !isDigit2) {
					if(la[1].compareTo(lb[1]) > 0 || (la[1].compareTo(lb[1]) == 0 && 
							la[0].compareTo(lb[0]) > 0))
						return 1;
					else 
						return -1;
				}
				return isDigit1 ? (isDigit2 ? 0: 1) : -1;
			}
			
		});
		System.out.println(Arrays.deepToString(logs));
	}
	
	//same as above using lambda
	public static void leetSol2(String[] logs) {
		Arrays.sort(logs, (log1, log2) -> {
				String[] la = log1.split(" ", 2);
				String[] lb = log2.split(" ", 2);
				boolean isDigit1 = Character.isDigit(la[1].charAt(0));
				boolean isDigit2 = Character.isDigit(lb[1].charAt(0));
				if(!isDigit1 && !isDigit2) {
					if(la[1].compareTo(lb[1]) > 0 || (la[1].compareTo(lb[1]) == 0 && 
							la[0].compareTo(lb[0]) > 0))
						return 1;
					else 
						return -1;
				}
				return isDigit1 ? (isDigit2 ? 0: 1) : -1;			
		});
	}
	
	public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2)->{
            if(o1.charAt(0) != o2.charAt(0))
                return o2.charAt(0) - o1.charAt(0);
            else if(o1.charAt(0)=='d')
                return -1;
            else{
                int fi=0,si=0;
                String first=o1, second=o2;
                while(fi<first.length() && !(first.charAt(fi) == ' ')) fi++;
                while(si<first.length() && !(first.charAt(si)==' ')) si++;
                if(first.substring(fi+1).compareTo(second.substring(si+1))==0)
                    return first.substring(0,fi).compareTo(second.substring(0,si));
                else
                    return first.substring(fi+1).compareTo(second.substring(si+1));
            }
        });
        return logs;
    }
}

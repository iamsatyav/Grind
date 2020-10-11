package hard.amazon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;

public class MediumWindowSubstring76 {
	public static void main(String[] args) throws FileNotFoundException {
		 String filePath = selectFile();
		 File input = new File(filePath);
         Scanner sc = new Scanner(input);
         String s = sc.nextLine();
         String t = sc.nextLine();
         minWindow(s, t);
	}
	
	public static String minWindow(String s, String t) {
		if(s=="" || t=="") return "";
        
        int lo=0, hi=0;
        HashMap<Character, Integer> tmap = new HashMap<>();
        String res = "";
        for(int i=0; i<t.length(); ++i){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0)+1);
        }
        
        int required = tmap.size();
        HashMap<Character, Integer> loopmap = new HashMap<>();
        int satisfied = 0;
        while(hi<s.length()){
            if(tmap.containsKey(s.charAt(hi))){
                loopmap.put(s.charAt(hi), loopmap.getOrDefault(s.charAt(hi), 0)+1);
                if(loopmap.get(s.charAt(hi)).intValue() == tmap.get(s.charAt(hi)).intValue())
                    satisfied++;
                
                if(satisfied==required){
                    while(lo<=hi){
                        if(tmap.containsKey(s.charAt(lo))){
                            loopmap.put(s.charAt(lo), loopmap.get(s.charAt(lo))-1);
                            if(loopmap.get(s.charAt(lo)) < tmap.get(s.charAt(lo))){
                                if(res == "" || res.length()>s.substring(lo, hi+1).length())
                                    res = s.substring(lo, hi+1);
                                satisfied--; lo++;
                                break;
                            }
                        }
                        lo++;
                        if(res == "" || res.length()>s.substring(lo, hi+1).length())
                            res = s.substring(lo, hi+1);
                    }
                }
                
            }
            hi++;
        }
        return res;
    }
	
	public static String selectFile() {
        String filePath = null;
        try {
            JFileChooser chooser = new JFileChooser();
            int showOpenDialog = chooser.showOpenDialog(null);
            if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
                filePath = chooser.getSelectedFile().getAbsolutePath();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}

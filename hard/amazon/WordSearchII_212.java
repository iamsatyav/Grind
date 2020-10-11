package hard.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class WordTrie {
	char val;
	boolean isWord;
	WordTrie[] next;
	public WordTrie(char val, WordTrie[] next) {
		super();
		this.val = val;
		this.next = next;
		this.isWord = false;
	}
}

public class WordSearchII_212 {
	static char[][] _board;
	static WordTrie _root;
	static HashSet<String> _result;
	public static void main(String[] args) {
		char[][] board = {{'a', 'a'}};
		String[] words = {"aaa"};
		findWords(board, words);
	}
    
	public static List<String> findWords(char[][] board, String[] words) {
        _root = buildTrie(words);
        _result = new HashSet();
        _board = board;
        for(int i=0; i<board.length; ++i) {
        	for(int j=0; j<board[0].length; ++j) {
        		checkWordExists(_root, "", i, j);
        	}
        }
        return new ArrayList(_result);
    }
	
	private static boolean checkWordExists(WordTrie start, String pathWord, int r, int c) {
		WordTrie curr = start.next[_board[r][c] - 'a'];
		if(curr == null) return false;
		else {
			if(curr.isWord) {
				_result.add(pathWord+curr.val);
				return true;
			}
			else
				return (r-1>=0 && checkWordExists(curr, pathWord+curr.val, r-1, c) 
					|| r+1<_board.length && checkWordExists(curr, pathWord+curr.val, r+1, c)
					|| c+1<_board[0].length && checkWordExists(curr, pathWord+curr.val, r, c+1)
					|| c-1>=0 && checkWordExists(curr, pathWord+curr.val, r, c-1));
		}
	}
	
	private static WordTrie buildTrie(String[] words){
		WordTrie root = new WordTrie('/', new WordTrie[26]);
		for(String ea: words) {
			WordTrie curr = root;
			for(int i=0; i<ea.length(); ++i) {
				if(curr.next[ea.charAt(i)-'a'] == null)
					curr.next[ea.charAt(i)-'a'] = new WordTrie(ea.charAt(i), new WordTrie[26]);
				curr = curr.next[ea.charAt(i)-'a'];
			}
			curr.isWord = true;
		}
		return root;
	}
}

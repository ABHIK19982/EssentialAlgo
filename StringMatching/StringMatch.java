package StringMatching;

import org.jetbrains.annotations.NotNull;
import java.util.*;

public class StringMatch {
    private String pattern;
    private ArrayList<Integer[]> code;
    private Character[] alpha;
    private long no_of_matches;

    public StringMatch() {pattern = null;no_of_matches = 0;}
    public StringMatch(@NotNull String p) {
        this.pattern = p;
        code= new ArrayList<Integer[]>(p.length());
        no_of_matches = 0;
        InitializeAlpha();
    }

    public void setPattern(@NotNull String pattern) {
        this.pattern = pattern;
        InitializeAlpha();
        code = new ArrayList<Integer[]>(pattern.length());
    }

    public String getPattern() {
        return pattern;
    }
    public Character[] getAlpha() {
        return alpha;
    }
    public Integer[][] getCode() {
        Integer t[][] = new Integer[pattern.length()][alpha.length];
        code.toArray(t);
        return t;
    }
    public long getNo_of_matches() {return no_of_matches;}

    private void InitializeCode() {
        for(int i=0;i<pattern.length();i++)
        {
            code.add(new Integer[alpha.length]);
        }
    }
    private void InitializeAlpha(){
        HashSet<Character> temp = new HashSet<Character>();
        for(int i=0;i<pattern.length();i++)
            temp.add(pattern.charAt(i));
        alpha = new Character[temp.size()];
        temp.toArray(alpha);
        Arrays.sort(alpha);
    }

    public void encode() {
       InitializeCode();
       int q = 0;
       code.get(0)[0]  = 1;

       for(int i=0;i<pattern.length();i++)
       {
           for(int j = 0;j<alpha.length;j++)
           {
               int k = pattern.length() > i+1 ? i+1 : pattern.length();

               while(!compare(k,i,alpha[j]))
               {
                   k = k-1;
                   if(k == 0) break;
               }
               code.get(i)[j] = k;
           }
       }

    }
    private boolean compare(int k,int i,char c) {
        String s = pattern.substring(0,k);
        StringBuilder s1 = new StringBuilder(pattern.substring(i-k+1,i));
        s1.append(c);
        //s1.reverse();
        //System.out.println(s1+" -> "+s+" = "+s1.toString().equals(s));
        if(s.equals(s1.toString())) return true;
        else return false;
    }

    public boolean matches(@NotNull String s) {
        int q= 0;boolean found = false;
        for(int i=0;i<s.length();i++)
        {
            int p = getIndicesOf(s.charAt(i));
            if(p*-1 > 0) continue;
            q = code.get(q)[p];
            if(q == pattern.length()) {found = true;no_of_matches++;q = 0;}
        }
        return found;
    }
    private int getIndicesOf(char c) {
        return Arrays.binarySearch(alpha,c);
    }

}

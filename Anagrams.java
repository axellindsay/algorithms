public class Anagrams
{
    public boolean areAnagrams(String s, String t)
    {
        if (s.length() != t.length() || s == null || t == null) return false;
        
        int[] letters = new int[256];
        int numUniqueChars = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            int charValue = s.charAt(i);
            if (letters[charValue] == 0)
            {
                numUniqueChars++;
            }
            letters[charValue]++;
        }
        
        for (int i = 0; i < t.length(); i++)
        {
            int charValue = t.charAt(i);
            if (letters[charValue] == 0) return false;
            letters[charValue]--;
            if (letters[charValue] == 0) numUniqueChars--;
           
        }
        
        return numUniqueChars == 0 ? true : false;
    }
}
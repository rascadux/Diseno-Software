package e1;

import java.util.StringTokenizer;

public class StringCount {
    private static int cWords = 0;
    private static int cChar = 0;


    public static int countWords ( String text ) {
        cWords = 0;
        if(text == null || text.isEmpty()) {
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(text);
        return cWords = tokens.countTokens();

    }

    public static int countChar ( String text , char c) {
        cChar = 0;
        if(text == null) return cChar = 0;
        for(int i=0; i < text.length(); i++)
        {    if(text.charAt(i) == c)
            cChar++;
        }
        return cChar;
    }

    public static int countCharIgnoringCase ( String text , char c ) {
        if(text == null){
            return cChar = 0;
        }
        text = text.toLowerCase();
        c = Character.toLowerCase(c);
        return cChar = countChar(text, c);
    }

    public static boolean isPasswordSafe ( String password ) {
        char ch;
        boolean numberFlag = false;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;

        if (! (password.length() >= 8)){
            return  false;
        }
        if(!(password.contains("?") || password.contains("@") || password.contains("#") || password.contains("$") || password.contains(",") || password.contains("."))) {
            return false;
        }
        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;

    }

}

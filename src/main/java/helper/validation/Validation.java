package helper.validation;

public abstract class Validation {
    public static boolean isValidString(String s) {
        Boolean isValid = true;
        if (s.isEmpty() || s.isBlank()) isValid = false;
        return isValid;
    }
    
    public static boolean isValidInteger(String s, int radix) {
        Boolean isValid = true;
        if(s.isEmpty()) isValid = false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return isValid;
    }
    
    public static boolean isValidEmail(String email) {
        Boolean isValid = true;
        if (!email.contains("@") || !email.contains(".com")) isValid = false;
        return isValid;
    }
   
    
    
    public static int IsValidateUsername(String username){
      int i = 1;
      if(username.equals("")||username.length()<=3){
          i=0;
      }
      
      return i;
  }
    public static boolean IsValidPassword(String password) {

        if (password.length() < 8) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }

    
   
}

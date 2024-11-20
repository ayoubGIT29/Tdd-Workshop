package ma.xproce.tddtheodo.security;

public class passwordValidator {
    public boolean isValidPassword(String password) {
        boolean containsDigit=false;
        boolean containsUpperCase=false;
        boolean containsLowerCase=false;
        boolean containsSpecialCharacter=false;
        if(password.length()<8)
            return false;
        for(Character character:password.toCharArray()){
            if(containsDigit==false){
                containsDigit=Character.isDigit(character);
            }
            if(containsUpperCase==false){
                containsUpperCase=Character.isUpperCase(character);
            }
            if(containsLowerCase==false){
                containsLowerCase=Character.isLowerCase(character);
            }
            if(containsSpecialCharacter==false){
                containsSpecialCharacter=!Character.isLetterOrDigit(character);
            }
        }
        return containsDigit && containsUpperCase && containsSpecialCharacter && containsLowerCase;
    }
}

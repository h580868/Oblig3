package no.hvl.dat108;

public class Validator {

    public static final String ANY_LETTER = "[a-zA-ZåäöÅÄÖ]";
    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-Z+0-9]";
    public static final String ANY_DIGIT = "[0-9]";
    public static final String EIGHT_TIMES = "{8}";
    public static final String ZERO_OR_MORE_TIMES = "*";

    /**
     * 
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     *         Et gyldig brukernavn best�r av 4 eller flere tegn. Lovlige tegn
     *         er bokstaver (sm� og store) inkl. de norske bokstavene, og tall.
     *         Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isValidName(String name) {

        if (name == null || name.length()>20) {
            return false;
        }
        return name.matches("^" + ANY_LETTER + ZERO_OR_MORE_TIMES + "$");
    }
    
    public static boolean isRegistered() {
    	int length;
    	//if(mobil)
    	boolean reg = false;
    	//if (username.equals(username)) {
    		
    	//}
    	
    	return reg;
    }
    
    public static boolean allFieldsOk() {
    	boolean fieldOk = false;
    	
    	return fieldOk;
    }
    
    public static boolean isValidMobile(String mobil) {
    	if(mobil == null || mobil.length()!=8) {
    		return false;
    	}
    	return mobil.matches("^" + ANY_DIGIT + EIGHT_TIMES +"$");
    }
    
    public static boolean isValidPass(String pass) {
    	if(pass == null || pass.length()<=3) {
    		return false;
    	}
    	return pass.matches("^" + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES +"$");
    }
}

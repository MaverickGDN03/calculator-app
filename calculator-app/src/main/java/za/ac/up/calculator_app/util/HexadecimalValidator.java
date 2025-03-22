package za.ac.up.calculator_app.util;

public class HexadecimalValidator {

    private static final int MAX_OUTPUT = 0xFFFF;
    private static final String HEXADECIMAL_REGEX = "^[0-9A-Fa-f]+$";

    private HexadecimalValidator() {
    }

    public static boolean isValid(String input) {
        return input.matches(HEXADECIMAL_REGEX);
    }

    public static String formatOutput(int result){
        if(result > MAX_OUTPUT){
            return "FFFF";
        }
        return Integer.toHexString(result).toUpperCase();
    }


}

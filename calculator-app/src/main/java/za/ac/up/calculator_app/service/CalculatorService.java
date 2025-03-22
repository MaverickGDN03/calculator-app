package za.ac.up.calculator_app.service;

import org.springframework.stereotype.Service;
import za.ac.up.calculator_app.util.HexadecimalValidator;

@Service
public class CalculatorService {

    // Method to add two hexaddecimal numbers
    public String add(String hex1, String hex2) {
        if (HexadecimalValidator.isValid(hex1) && HexadecimalValidator.isValid(hex2)) {
            int result = Integer.parseInt(hex1, 16) + Integer.parseInt(hex2, 16);
            return HexadecimalValidator.formatOutput(result);
        } else {
            throw new IllegalArgumentException("Invalid hexadecimal input");
        }

    }

    // Method to subtract two hexaddecimal numbers
    public String subtract(String hex1, String hex2) {
        if (HexadecimalValidator.isValid(hex1) && HexadecimalValidator.isValid(hex2)) {
            int result = Integer.parseInt(hex1, 16) - Integer.parseInt(hex2, 16);
            if (result < 0) {
                result = 0;
            }
            return HexadecimalValidator.formatOutput(result);
        } else {
            throw new IllegalArgumentException("Invalid hexadecimal input");
        }
    }

    // Method to multiply two hexaddecimal numbers
    public String multiply(String hex1, String hex2) {
        if (!HexadecimalValidator.isValid(hex1) || !HexadecimalValidator.isValid(hex2)) {
            throw new IllegalArgumentException("Invalid hexadecimal input");
        }

        int result = Integer.parseInt(hex1, 16) * Integer.parseInt(hex2, 16);
        return HexadecimalValidator.formatOutput(result);
    }

    // Method to divide two hexaddecimal numbers
    public String divide(String hex1, String hex2) {
        if (!HexadecimalValidator.isValid(hex1) || !HexadecimalValidator.isValid(hex2)) {
            throw new IllegalArgumentException("Invalid hexadecimal input");
        }
        if (hex2.equals("0")) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        int result = Integer.parseInt(hex1, 16) / Integer.parseInt(hex2, 16);
        return HexadecimalValidator.formatOutput(result);
    }
}

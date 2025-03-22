package za.ac.up.calculator_app.service;

import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    static String  hex1;
    static String hex2;
    static String hex3;

    @BeforeAll
    static void setUp() {
        hex1 = "A";
        hex2 = "1";
        hex3 = "2";

    }


    @Test
    void add_two_letters() {
        String result = calculatorService.add(hex1, hex1);
        assertEquals("14", result);
    }

    @Test
    void add_letter_number(){
        String result = calculatorService.add(hex1, hex2);
        assertEquals("B", result);
    }

    @Test
    void subtract_two_letters() {
        String result = calculatorService.subtract(hex1, hex1);
        assertEquals("0", result);
    }

    @Test
    void subtract_letter_number(){
        String result = calculatorService.subtract(hex1, hex2);
        assertEquals("9", result);
    }

    @Test
    void multiply_two_letters() {
        String result = calculatorService.multiply(hex1, hex1);
        assertEquals("64", result);
    }

    @Test
    void multiply_letter_number(){
        String result = calculatorService.multiply(hex1, hex2);
        assertEquals(hex1, result);
    }

    @Test
    void divide_two_letters() {
        String result = calculatorService.divide(hex1, hex1);
        assertEquals(hex2, result);
    }

    @Test
    void divide_letter_number(){
        String result = calculatorService.divide(hex1, hex2);
        assertEquals(hex1, result);
    }

    @Test
    void divide_by_zero(){
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(hex1, "0");
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void subtract_result_negative(){
        String result = calculatorService.subtract(hex2, hex1);
        assertEquals("0", result);
    }

    @Test
    void invalid_input(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {calculatorService.add("G",hex1);});
        assertEquals("Invalid hexadecimal input", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {calculatorService.subtract("G",hex1);});
        assertEquals("Invalid hexadecimal input", exception.getMessage());
    }

    @Test
    void maximum_output_four_digits(){
        assertEquals("FFFF", calculatorService.add("FFFF",hex2));
        assertEquals("FFFF", calculatorService.multiply("FFFF","2"));
    }

    @Test
    void divide_no_decimals(){
        assertEquals("3", calculatorService.divide(hex1,"3"));
        assertEquals("1", calculatorService.divide("3",hex3));
    }
}
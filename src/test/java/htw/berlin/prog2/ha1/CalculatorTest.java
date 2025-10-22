package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen 
        // Aufgabe b.2 
    @Test 
    @DisplayName("should Display result %")
    void perCentage() {

       Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "1.0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    // Aufgabe b.3.1
    // Der Online Taschenrechner macht zwar das gleiche, aber ich orientiere mich nach unserem Taschenrechner Code und empfinde das Verhalten als Bug. Meine Taschenrechner zuhause haben Error angezeigt wenn ich das versucht habe.
    @Test
    @DisplayName("should still display the first operator if you enter after using only one operator for a binary calculation")
    void calcWithoutSecondOperator() {

        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("+");
        calc.pressEqualsKey();

        
        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }


        // Aufgabe b.3.2
    // Erwartet wäre, das er 4 + 3 rechnet. Allerdings ist nach der pressClearKey Eingabe das attribut "latestOperation" leer, wodurch er bei der methode pressEqualsKey in den default case geht und IllegalArgumentException ausgibt.
    @Test
    @DisplayName("should only delete last digit and set screen to 0")
    void oneTimeClearDeletion() {

        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressClearKey();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        
        String expected = "7";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}


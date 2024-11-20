package ma.xproce.tddtheodo.passwordValidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class passwordValidatorTest {
    private passwordValidator passwordValidator=new passwordValidator();

//    @BeforeEach
//    void setUp() {
//        passwordValidator=new passwordValidator();
//    }

    @ParameterizedTest
    @CsvSource({"Abcdefjh0@,true",
            "abcd,false",
            "abcdefjh@,false",
            "abcdefjh@0,false",
            "Abcdefjh0,false",
            "ABCDEFJ@0,false"
    })
    void isValidPassword_verifieTouteCondition_returnTrue(String input,boolean output){
        Assertions.assertEquals(output,passwordValidator.isValidPassword(input));
    }

    @Test
    void isValidPassword_lengthLessThan8_returnFalse(){
        String password="abcd";
        Assertions.assertFalse(passwordValidator.isValidPassword(password));
    }

    @Test
    void isValidPassword_doesntContainNumber_returnFalse(){
        String password="abcdefjh@";
        Assertions.assertFalse(passwordValidator.isValidPassword(password));
    }

    @Test
    void isValidPassword_doesntContainUpperCase_returnFalse(){
        String password="abcdefjh@0";
        Assertions.assertFalse(passwordValidator.isValidPassword(password));
    }

    @Test
    void isValidPassword_doesntContainSpecialCharacter_returnFalse(){
        String password="Abcdefjh0";
        Assertions.assertFalse(passwordValidator.isValidPassword(password));
    }

    @Test
    void isValidPassword_doesntContainLowerCase_returnFalse(){
        String password="ABCDEFJ@0";
        Assertions.assertFalse(passwordValidator.isValidPassword(password));
    }
}

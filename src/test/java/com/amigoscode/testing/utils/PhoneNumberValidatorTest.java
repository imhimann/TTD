package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setup(){
        underTest = new PhoneNumberValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "+447382940123,true",
            "4473829401232,false",
            "+44738294012232,false"
    })
    void itShouldValidatePhoneNumber(String phoneNumber, boolean expected) {

        //When
        boolean isValid = underTest.test(phoneNumber);

        //Then
        assertThat(isValid).isEqualTo(expected);

    }

}

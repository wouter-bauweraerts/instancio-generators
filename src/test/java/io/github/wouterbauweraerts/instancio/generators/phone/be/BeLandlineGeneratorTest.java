package io.github.wouterbauweraerts.instancio.generators.phone.be;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import io.github.wouterbauweraerts.instancio.generators.Generators;

class BeLandlineGeneratorTest {
    private static final Pattern BE_NATIONAL_LANDLINE_PATTERN = Pattern.compile("^(?<zone>0[0-9]{1,2})/(?<no1>[0-9]{2,3})\\.[0-9]{2}\\.[0-9]{2}$");
    private static final Pattern BE_INTERNATIONAL_LANDLINE_PATTERN = Pattern.compile("^\\+32(?<zone>[0-9]{1,2})/(?<no1>[0-9]{2,3})\\.[0-9]{2}\\.[0-9]{2}$");

    @Test
    void generateBeNationalLandlineReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().landline())
                .create()
                .getPhone();

        assertThat(phone).hasSize(12);
        Matcher phoneMatcher = BE_NATIONAL_LANDLINE_PATTERN.matcher(phone);
        assertThat(phoneMatcher)
                .matches();

        assertThat(phoneMatcher.group("no1")).hasSize(
                phoneMatcher.group("zone").length() == 2 ? 3 : 2
        );
    }

    @Test
    void generateBeInternationalLandlineReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().international().landline())
                .create()
                .getPhone();

        assertThat(phone).hasSize(14);
        Matcher phoneMatcher = BE_INTERNATIONAL_LANDLINE_PATTERN.matcher(phone);
        assertThat(phoneMatcher)
                .matches();

        assertThat(phoneMatcher.group("no1")).hasSize(
                phoneMatcher.group("zone").length() == 1 ? 3 : 2
        );
    }

    @Test
    void generateBeNationalLandlineWithSeedReturnsSameValue() {
        PhoneWrapper wrapper1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().landline())
                .withSeed(1234l)
                .create();
        PhoneWrapper wrapper2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().landline())
                .withSeed(1234l)
                .create();

        assertThat(wrapper1).usingRecursiveComparison().isEqualTo(wrapper2);
    }

    @Test
    void generateBeInternationalLandlineWithSeedReturnsSameValue() {
        PhoneWrapper wrapper1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().international().landline())
                .withSeed(1234l)
                .create();
        PhoneWrapper wrapper2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().international().landline())
                .withSeed(1234l)
                .create();

        assertThat(wrapper1).usingRecursiveComparison().isEqualTo(wrapper2);
    }
}

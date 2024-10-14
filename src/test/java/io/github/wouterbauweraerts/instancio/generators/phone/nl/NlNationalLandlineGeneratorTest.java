package io.github.wouterbauweraerts.instancio.generators.phone.nl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import io.github.wouterbauweraerts.instancio.generators.Generators;
import io.github.wouterbauweraerts.instancio.generators.phone.common.PhoneWrapper;

class NlNationalLandlineGeneratorTest {
    private static final Pattern NL_NATIONAL_LANDLINE_PATTERN = Pattern.compile("^\\(0(?<region>[0-9]{2,3})\\) (?<firstGroup>[0-9]{2,3}) [0-9]{4}$");

    @Test
    void generateReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().nl().national().landline())
                .create()
                .getPhone();

        Matcher matcher = NL_NATIONAL_LANDLINE_PATTERN.matcher(phone);

        assertThat(matcher).matches();
        assertThat(matcher.group("firstGroup")).hasSize(
                matcher.group("region").length() == 3 ? 2 : 3
        );
    }

    @Test
    void generateWithSeedReturnsIdenticalResults() {
        int seed = new Random().nextInt(100000);

        String phone1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().nl().national().landline())
                .withSeed(seed)
                .create()
                .getPhone();
        String phone2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().nl().national().landline())
                .withSeed(seed)
                .create()
                .getPhone();

        assertThat(phone1).isEqualTo(phone2);
    }
}

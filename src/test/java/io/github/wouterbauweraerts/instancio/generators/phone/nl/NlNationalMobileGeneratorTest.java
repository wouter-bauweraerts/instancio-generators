package io.github.wouterbauweraerts.instancio.generators.phone.nl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import java.util.Random;
import java.util.regex.Pattern;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import io.github.wouterbauweraerts.instancio.generators.Generators;
import io.github.wouterbauweraerts.instancio.generators.phone.common.PhoneWrapper;

class NlNationalMobileGeneratorTest {
    private static final Pattern NL_NATIONAL_MOBILE_PATTERN = Pattern.compile("^06 [0-9]{2} [0-9]{2} [0-9]{2}$");

    @Test
    void generateReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().nl().national().mobile())
                .create()
                .getPhone();

        assertThat(NL_NATIONAL_MOBILE_PATTERN.matcher(phone)).matches();
    }

    @Test
    void generateWithSeedReturnsIdenticalResults() {
        int seed = new Random().nextInt(100000);

        String phone1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().nl().national().mobile())
                .withSeed(seed)
                .create()
                .getPhone();
        String phone2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().nl().national().mobile())
                .withSeed(seed)
                .create()
                .getPhone();

        assertThat(phone1).isEqualTo(phone2);
    }
}

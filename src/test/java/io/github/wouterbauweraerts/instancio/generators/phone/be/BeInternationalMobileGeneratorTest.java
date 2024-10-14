package io.github.wouterbauweraerts.instancio.generators.phone.be;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import io.github.wouterbauweraerts.instancio.generators.Generators;
import io.github.wouterbauweraerts.instancio.generators.phone.common.PhoneWrapper;

class BeInternationalMobileGeneratorTest {
    private static final Pattern BE_INTERNATIONAL_MOBILE_PATTERN = Pattern.compile("^\\+324(?<zone>[0-9]{2})/(?<no1>[0-9]{2})\\.[0-9]{2}\\.[0-9]{2}$");

    @Test
    void generateReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().international().mobile())
                .create()
                .getPhone();

        assertThat(phone).hasSize(15);
        Matcher phoneMatcher = BE_INTERNATIONAL_MOBILE_PATTERN.matcher(phone);
        assertThat(phoneMatcher)
                .matches();

        assertThat(phoneMatcher.group("no1")).hasSize(
                phoneMatcher.group("zone").length() == 1 ? 3 : 2
        );
    }

    @Test
    void generateWithSeedReturnsIdenticalResults() {
        long seed = new Random().nextLong();
        PhoneWrapper wrapper1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().international().mobile())
                .withSeed(seed)
                .create();
        PhoneWrapper wrapper2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().international().mobile())
                .withSeed(seed)
                .create();

        assertThat(wrapper1).usingRecursiveComparison().isEqualTo(wrapper2);
    }
}

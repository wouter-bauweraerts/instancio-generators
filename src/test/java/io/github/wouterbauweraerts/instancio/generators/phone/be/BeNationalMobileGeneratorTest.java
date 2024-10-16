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

class BeNationalMobileGeneratorTest {
    private static final Pattern BE_NATIONAL_MOBILE_PATTERN = Pattern.compile("^(?<prefix>04[0-9]{2})/(?<no1>[0-9]{2})\\.[0-9]{2}\\.[0-9]{2}$");

    @Test
    void generateReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().mobile())
                .create()
                .getPhone();

        assertThat(phone).hasSize(13);
        Matcher phoneMatcher = BE_NATIONAL_MOBILE_PATTERN.matcher(phone);
        assertThat(phoneMatcher)
                .matches();
    }

    @Test
    void generateWithSeedReturnsIdenticalResults() {
        long seed = new Random().nextLong();
        PhoneWrapper wrapper1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().mobile())
                .withSeed(seed)
                .create();
        PhoneWrapper wrapper2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().mobile())
                .withSeed(seed)
                .create();

        assertThat(wrapper1).usingRecursiveComparison().isEqualTo(wrapper2);
    }
}

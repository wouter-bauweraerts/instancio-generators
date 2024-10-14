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

class BeNationalLandlineGeneratorTest {
    private static final Pattern BE_NATIONAL_LANDLINE_PATTERN = Pattern.compile("^(?<zone>0[0-9]{1,2})/(?<firstGroup>[0-9]{2,3})\\.[0-9]{2}\\.[0-9]{2}$");

    @Test
    void generateReturnsStringInExpectedFormat() {
        String phone = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().landline())
                .create()
                .getPhone();

        assertThat(phone).hasSize(12);
        Matcher phoneMatcher = BE_NATIONAL_LANDLINE_PATTERN.matcher(phone);
        assertThat(phoneMatcher)
                .matches();

        assertThat(phoneMatcher.group("firstGroup")).hasSize(
                phoneMatcher.group("zone").length() == 2 ? 3 : 2
        );
    }

    @Test
    void generateWithSeedReturnsIdenticalResults() {
        long seed = new Random().nextLong();
        PhoneWrapper wrapper1 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().landline())
                .withSeed(seed)
                .create();
        PhoneWrapper wrapper2 = Instancio.of(PhoneWrapper.class)
                .generate(field(PhoneWrapper::getPhone), Generators.phone().be().national().landline())
                .withSeed(seed)
                .create();

        assertThat(wrapper1).usingRecursiveComparison().isEqualTo(wrapper2);
    }
}

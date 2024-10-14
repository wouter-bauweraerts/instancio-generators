package io.github.wouterbauweraerts.instancio.generators.phone.nl.national;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class NlNationalMobileGenerator implements Generator<String> {
    private final GeneratorContext ctx;

    public NlNationalMobileGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        return String.format(
                "06 %s %s %s",
                random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

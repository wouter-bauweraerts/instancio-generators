package io.github.wouterbauweraerts.instancio.generators.phone.nl.international;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class NlInternationalMobileGenerator implements Generator<String> {
    private final GeneratorContext ctx;

    public NlInternationalMobileGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        return String.format(
                "+31 6 %s %s %s",
                random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

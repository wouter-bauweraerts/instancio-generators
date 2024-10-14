package io.github.wouterbauweraerts.instancio.generators.phone.be.international;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class BeInternationalMobileGenerator implements Generator<String> {
    private final GeneratorContext ctx;

    public BeInternationalMobileGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        return String.format(
                "+324%s/%s.%s.%s",
                random.digits(2),
                random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

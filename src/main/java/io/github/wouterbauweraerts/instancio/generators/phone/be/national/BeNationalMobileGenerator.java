package io.github.wouterbauweraerts.instancio.generators.phone.be.national;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class BeNationalMobileGenerator implements Generator<String> {
    private final GeneratorContext ctx;

    public BeNationalMobileGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        return String.format(
                "04%s/%s.%s.%s",
                random.digits(2),
                random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

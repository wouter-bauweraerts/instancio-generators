package io.github.wouterbauweraerts.instancio.generators.phone.nl.international;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class NlInternationalLandlineGenerator implements Generator<String> {
    private final GeneratorContext ctx;

    public NlInternationalLandlineGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        boolean sevenDigitNumber = random.trueOrFalse();
        return String.format(
                "+31 %s %s %s%s",
                sevenDigitNumber ? random.digits(2) : random.digits(3),
                sevenDigitNumber ? random.digits(3) : random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

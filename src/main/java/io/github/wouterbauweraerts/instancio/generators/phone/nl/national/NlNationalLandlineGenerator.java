package io.github.wouterbauweraerts.instancio.generators.phone.nl.national;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class NlNationalLandlineGenerator implements Generator<String> {
    private final GeneratorContext ctx;

    public NlNationalLandlineGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        boolean sevenDigitNumber = random.trueOrFalse();
        return String.format(
                "(0%s) %s %s %s",
                sevenDigitNumber ? random.digits(3) : random.digits(4),
                sevenDigitNumber ? random.digits(3) : random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

package io.github.wouterbauweraerts.instancio.generators.phone.be;

import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;

public class BeNationalLandlineGenerator implements Generator<String> {
    private GeneratorContext ctx;

    public BeNationalLandlineGenerator(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String generate(Random random) {
        boolean singleDigitZone = random.trueOrFalse();

        return String.format(
                "0%s/%s.%s.%s",
                singleDigitZone ? random.digits(1) : random.digits(2),
                singleDigitZone ? random.digits(3) : random.digits(2),
                random.digits(2),
                random.digits(2)
        );
    }
}

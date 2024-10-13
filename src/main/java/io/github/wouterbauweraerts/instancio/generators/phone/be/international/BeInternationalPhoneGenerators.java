package io.github.wouterbauweraerts.instancio.generators.phone.be.international;

import org.instancio.generator.GeneratorContext;

public class BeInternationalPhoneGenerators {
    private final GeneratorContext ctx;

    public BeInternationalPhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public BeInternationalLandlineGenerator landline() {
        return new BeInternationalLandlineGenerator(ctx);
    }
}

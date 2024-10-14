package io.github.wouterbauweraerts.instancio.generators.phone.nl.national;

import org.instancio.generator.GeneratorContext;

public class NlNationalPhoneGenerators {
    private final GeneratorContext ctx;

    public NlNationalPhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public NlNationalLandlineGenerator landline() {
        return new NlNationalLandlineGenerator(ctx);
    }

    public NlNationalMobileGenerator mobile() {
        return new NlNationalMobileGenerator(ctx);
    }
}

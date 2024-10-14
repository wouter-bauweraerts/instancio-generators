package io.github.wouterbauweraerts.instancio.generators.phone.nl.international;

import org.instancio.generator.GeneratorContext;

public class NlInternationalPhoneGenerators {
    private final GeneratorContext ctx;

    public NlInternationalPhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public NlInternationalLandlineGenerator landline() {
        return new NlInternationalLandlineGenerator(ctx);
    }

    public NlInternationalMobileGenerator mobile() {
        return new NlInternationalMobileGenerator(ctx);
    }
}

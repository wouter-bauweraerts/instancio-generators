package io.github.wouterbauweraerts.instancio.generators.phone.be.national;

import org.instancio.generator.GeneratorContext;

public class BeNationalPhoneGenerators {
    private GeneratorContext ctx;

    public BeNationalPhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public BeNationalLandlineGenerator landline() {
        return new BeNationalLandlineGenerator(ctx);
    }
}

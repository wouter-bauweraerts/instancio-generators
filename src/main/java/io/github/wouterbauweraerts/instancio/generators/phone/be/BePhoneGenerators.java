package io.github.wouterbauweraerts.instancio.generators.phone.be;

import org.instancio.generator.GeneratorContext;

public class BePhoneGenerators {
    private GeneratorContext ctx;

    public BePhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public BeNationalPhoneGenerators national() {
        return new BeNationalPhoneGenerators(ctx);
    }
}

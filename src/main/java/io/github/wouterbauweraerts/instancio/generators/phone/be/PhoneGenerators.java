package io.github.wouterbauweraerts.instancio.generators.phone.be;

import org.instancio.generator.GeneratorContext;

public class PhoneGenerators {
    private GeneratorContext ctx;

    public PhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public BePhoneGenerators be() {
        return new BePhoneGenerators(ctx);
    }
}

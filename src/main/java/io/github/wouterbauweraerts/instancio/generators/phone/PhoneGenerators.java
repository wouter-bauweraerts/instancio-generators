package io.github.wouterbauweraerts.instancio.generators.phone;

import org.instancio.generator.GeneratorContext;

import io.github.wouterbauweraerts.instancio.generators.phone.be.BePhoneGenerators;

public class PhoneGenerators {
    private GeneratorContext ctx;

    public PhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public BePhoneGenerators be() {
        return new BePhoneGenerators(ctx);
    }
}

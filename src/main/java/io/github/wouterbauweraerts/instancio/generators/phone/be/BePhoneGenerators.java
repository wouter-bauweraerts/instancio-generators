package io.github.wouterbauweraerts.instancio.generators.phone.be;

import org.instancio.generator.GeneratorContext;

import io.github.wouterbauweraerts.instancio.generators.phone.be.international.BeInternationalPhoneGenerators;
import io.github.wouterbauweraerts.instancio.generators.phone.be.national.BeNationalPhoneGenerators;

public class BePhoneGenerators {
    private GeneratorContext ctx;

    public BePhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public BeNationalPhoneGenerators national() {
        return new BeNationalPhoneGenerators(ctx);
    }

    public BeInternationalPhoneGenerators international() {
        return new BeInternationalPhoneGenerators(ctx);
    }
}

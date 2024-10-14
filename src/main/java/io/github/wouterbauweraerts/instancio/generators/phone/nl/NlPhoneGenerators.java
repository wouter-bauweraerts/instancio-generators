package io.github.wouterbauweraerts.instancio.generators.phone.nl;

import org.instancio.generator.GeneratorContext;

import io.github.wouterbauweraerts.instancio.generators.phone.nl.international.NlInternationalPhoneGenerators;
import io.github.wouterbauweraerts.instancio.generators.phone.nl.national.NlNationalPhoneGenerators;

public class NlPhoneGenerators {
    private final GeneratorContext ctx;

    public NlPhoneGenerators(GeneratorContext ctx) {
        this.ctx = ctx;
    }

    public NlInternationalPhoneGenerators international() {
        return new NlInternationalPhoneGenerators(ctx);
    }

    public NlNationalPhoneGenerators national() {
        return new NlNationalPhoneGenerators(ctx);
    }
}

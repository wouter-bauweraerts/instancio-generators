package io.github.wouterbauweraerts.instancio.generators;

import org.instancio.Random;
import org.instancio.generator.GeneratorContext;
import org.instancio.internal.RandomHelper;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.instancio.support.Global;
import org.instancio.support.ThreadLocalSettings;

import io.github.wouterbauweraerts.instancio.generators.phone.PhoneGenerators;

public class Generators {
    private static final Settings settings = Global.getPropertiesFileSettings()
            .merge(ThreadLocalSettings.getInstance().get());

    private Generators() {
    }

    public static PhoneGenerators phone() {
        final Random random = RandomHelper.resolveRandom(settings.get(Keys.SEED), null);

        return new PhoneGenerators(new GeneratorContext(settings, random));
    }
}

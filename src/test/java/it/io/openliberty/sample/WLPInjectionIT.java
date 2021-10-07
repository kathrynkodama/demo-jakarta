package it.io.openliberty.sample;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
// import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
// import org.junit.Assert;
// import org.junit.Test;
// import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;

import io.openliberty.sample.system.Greeter;

@ExtendWith(ArquillianExtension.class)
public class WLPInjectionIT {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(Greeter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return jar;
    }

    @Inject
    Greeter greeter;

    @Test
    public void should_create_greeting() {
        assertEquals("Hello, World!", greeter.createGreeting("World"));
    }
}
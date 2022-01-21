package io.openliberty.sample.jakarta.annotation;

import jakarta.ws.rs.ext.Provider;

@Provider()
public class NoPublicConstructorProviderClass {
	

    protected NoPublicConstructorProviderClass() {

    }

    protected NoPublicConstructorProviderClass(int arg1) {

    }

}

package io.ctdev.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public interface TestConfig extends Config {
    TestConfig cfg = ConfigFactory.create(TestConfig.class);
    @DefaultValue("firefox")
    String browser();

    @DefaultValue("http://18.217.145.6/")
    String webSite();

    @DefaultValue("https://abbvieonecrm--preprod1v3.lightning.force.com/")
    String salesForcePreProd1v3();
}

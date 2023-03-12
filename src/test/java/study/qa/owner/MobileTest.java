package study.qa.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import study.qa.owner.config.MobileConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {

    @Test
    public void testMobile() {
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.getPlatformName()).isEqualTo("IOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
        assertThat(config.getDeviceName()).isEqualTo("iPhone 13 Pro Max Super Man");
    }

    @Test
    public void testMobileWithSystemOverride() {
        System.setProperty("platform.version", "12");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.getPlatformVersion()).isEqualTo("12");
    }

    @Test
    public void testMobileWithAndroid() {
        System.setProperty("device", "google-pixel");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.getPlatformName()).isEqualTo("Android");
        assertThat(config.getPlatformVersion()).isEqualTo("24");
        assertThat(config.getDeviceName()).isEqualTo("Google Pixel");
    }

    @Test
    public void testMobileWithIOS() {
        System.setProperty("device", "iphone-13");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.getPlatformName()).isEqualTo("IOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
        assertThat(config.getDeviceName()).isEqualTo("iPhone 13 Pro Max Super Man");
    }
}

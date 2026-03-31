package padroesestruturais.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import padroesestruturais.bridge.Device.Device;
import padroesestruturais.bridge.Device.Radio;
import padroesestruturais.bridge.Device.Tv;
import padroesestruturais.bridge.Remote.AdvancedRemote;

class AdvancedRemoteTest {

    @Test
    void shouldMuteTv() {
        Device device = new Tv();
        AdvancedRemote remote = new AdvancedRemote(device);

        remote.mute();

        assertEquals(0, device.getVolume());
    }

    @Test
    void shouldMuteRadio() {
        Device device = new Radio();
        AdvancedRemote remote = new AdvancedRemote(device);

        remote.mute();

        assertEquals(0, device.getVolume());
    }

    @Test
    void shouldIncreaseVolumeAfterMuteOnTv() {
        Device device = new Tv();
        AdvancedRemote remote = new AdvancedRemote(device);

        remote.mute();
        remote.volumeUp();

        assertEquals(10, device.getVolume());
    }

    @Test
    void shouldIncreaseVolumeAfterMuteOnRadio() {
        Device device = new Radio();
        AdvancedRemote remote = new AdvancedRemote(device);

        remote.mute();
        remote.volumeUp();

        assertEquals(10, device.getVolume());
    }

    @Test
    void shouldTurnOnTv() {
        Device device = new Tv();
        AdvancedRemote remote = new AdvancedRemote(device);

        remote.power();

        assertTrue(device.isEnabled());
    }

    @Test
    void shouldTurnOnRadio() {
        Device device = new Radio();
        AdvancedRemote remote = new AdvancedRemote(device);

        remote.power();

        assertTrue(device.isEnabled());
    }
}
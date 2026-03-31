package padroesestruturais.bridge;


import org.junit.jupiter.api.Test;

import padroesestruturais.bridge.Device.Device;
import padroesestruturais.bridge.Device.Radio;
import padroesestruturais.bridge.Device.Tv;
import padroesestruturais.bridge.Remote.BasicRemote;

import static org.junit.jupiter.api.Assertions.*;

class BasicRemoteTest {

    @Test
    void shouldTurnOnTvWhenItIsOff() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        remote.power();

        assertTrue(device.isEnabled());
    }

    @Test
    void shouldTurnOffTvWhenItIsOn() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        device.enable();
        remote.power();

        assertFalse(device.isEnabled());
    }

    @Test
    void shouldTurnOnRadioWhenItIsOff() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        remote.power();

        assertTrue(device.isEnabled());
    }

    @Test
    void shouldTurnOffRadioWhenItIsOn() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        device.enable();
        remote.power();

        assertFalse(device.isEnabled());
    }

    @Test
    void shouldIncreaseTvVolume() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        remote.volumeUp();

        assertEquals(40, device.getVolume());
    }

    @Test
    void shouldDecreaseTvVolume() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        remote.volumeDown();

        assertEquals(20, device.getVolume());
    }

    @Test
    void shouldIncreaseRadioVolume() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        remote.volumeUp();

        assertEquals(40, device.getVolume());
    }

    @Test
    void shouldDecreaseRadioVolume() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        remote.volumeDown();

        assertEquals(20, device.getVolume());
    }

    @Test
    void shouldNotExceedMaxVolumeOnTv() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        device.setVolume(95);
        remote.volumeUp();

        assertEquals(100, device.getVolume());
    }

    @Test
    void shouldNotExceedMaxVolumeOnRadio() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        device.setVolume(95);
        remote.volumeUp();

        assertEquals(100, device.getVolume());
    }

    @Test
    void shouldNotGoBelowZeroVolumeOnTv() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        device.setVolume(5);
        remote.volumeDown();

        assertEquals(0, device.getVolume());
    }

    @Test
    void shouldNotGoBelowZeroVolumeOnRadio() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        device.setVolume(5);
        remote.volumeDown();

        assertEquals(0, device.getVolume());
    }

    @Test
    void shouldIncreaseTvChannel() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        remote.channelUp();

        assertEquals(2, device.getChannel());
    }

    @Test
    void shouldDecreaseTvChannel() {
        Device device = new Tv();
        BasicRemote remote = new BasicRemote(device);

        remote.channelDown();

        assertEquals(0, device.getChannel());
    }

    @Test
    void shouldIncreaseRadioChannel() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        remote.channelUp();

        assertEquals(2, device.getChannel());
    }

    @Test
    void shouldDecreaseRadioChannel() {
        Device device = new Radio();
        BasicRemote remote = new BasicRemote(device);

        remote.channelDown();

        assertEquals(0, device.getChannel());
    }
}

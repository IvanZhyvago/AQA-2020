package Lesson_7.task_4_Remote_Device;

public class Main {
    public static void main(String[] args){

        TV tv = new TV("Samsung");

        RemoteController remoteController = new RemoteController();
        System.out.println("Connection: " + remoteController.checkIfDeviceConnected());
        remoteController.connectDevice(tv);
        System.out.println("Connection tv " + tv.modelName + " is " + remoteController.checkIfDeviceConnected());
        remoteController.powerOn();
        System.out.println("Status tv is " + tv.isOn);
        remoteController.setChannel(44);
        remoteController.currentChannel();
        remoteController.switchTheChannel(3);
        remoteController.currentChannel();
        remoteController.upVolume();
        remoteController.upVolume();
        remoteController.upVolume();
        remoteController.upVolume();
        System.out.println("Current volume is " + tv.volumeLevel);
        remoteController.downVolume();
        System.out.println("Current volume is " + tv.volumeLevel);
        remoteController.mute();
        System.out.println("Current volume is " + tv.volumeLevel);
        remoteController.powerOff();
        System.out.println("Status tv is " + tv.isOn);
        remoteController.disconnectDevice();
        System.out.println("Connection tv " + tv.modelName + " is " + remoteController.checkIfDeviceConnected());
    }
}

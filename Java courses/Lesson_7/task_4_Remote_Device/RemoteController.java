package Lesson_7.task_4_Remote_Device;
//Write a project named "Remote Device".
// Create a class "RemoteController" which will be simulation the real one to control the TV.
// Create interfaces Device and Volume.
// The "Device" interface should have methods powerOn(), powerOff(), setChannel(int channel), and currentChannel();
// The "Volume" interface should have methods "upVolume(), downVolume() and mute();
//Write an abstract class TVDevice which will be implementing interfaces
//Volume and Device and has the fields String modelName and boolean isOn
// (Tip: You don't need to implement methods from the interface if you class is abstract).
//Write a class "TV" which extends the class TVDevice. Implements all the methods.
//Write a class RemoteController to control your TV.
//Example of the structure in the attachments.

public class RemoteController implements Device, Volume {
    private String tvDevice;
    private TVDevice deviceToConnect;


    public RemoteController (){
    }


    void connectDevice (TVDevice deviceToConnect){
        this.deviceToConnect = deviceToConnect;
        System.out.println("Success Connected !");
    }

    void disconnectDevice() {
        deviceToConnect = null;
        System.out.println("Device disconnected");

    }
    @Override
    public void upVolume() {
        deviceToConnect.upVolume();
    }
    @Override
    public void downVolume () {
        deviceToConnect.downVolume();
    }
    @Override
    public void mute () {
        deviceToConnect.mute();
    }

    void switchTheChannel (int numberOfChannel) {
        setChannel(numberOfChannel);
    }

    boolean checkIfDeviceConnected() {
        return deviceToConnect instanceof TV;
    }

    @Override
    public void powerOn () {
        deviceToConnect.isOn = true;

    }
    @Override
    public void powerOff () {
        deviceToConnect.isOn = false;

    }
    @Override
    public void setChannel (int number) {
        deviceToConnect.setChannel(number);

    }
    @Override
    public void currentChannel () {
        deviceToConnect.currentChannel();

    }

}

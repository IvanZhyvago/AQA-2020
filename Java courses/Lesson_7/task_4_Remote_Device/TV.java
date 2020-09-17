package Lesson_7.task_4_Remote_Device;

public class TV extends TVDevice {
    int volumeLevel;
    int channelNumber;

    TV(String model) {
        super(model);
    }


    public void currentChannel (){
        System.out.println("Current chanel - "+ channelNumber);
    }

    public void powerOn(){
        isOn = true;
    }

    public void powerOff() {
        isOn = false;
    }

    @Override
    public void setChannel(int number) {
        channelNumber = number;

    }

    public void upVolume () {
        volumeLevel = volumeLevel + 1;
    }

    public void downVolume () {
        volumeLevel = volumeLevel - 1;

    }

    public void mute () {
        volumeLevel = 0;

    }


}

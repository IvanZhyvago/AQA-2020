package Lesson_7.task_4_Remote_Device;

abstract public class TVDevice implements Device, Volume {
    String modelName;
    boolean isOn;

    TVDevice (String model) {
        modelName = model;
    }

}

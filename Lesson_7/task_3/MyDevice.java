package Lesson_7.task_3;
//Create two interfaces Volume and State:
//interface Volume {
//    void changeVolume(double value);
//}
//
//interface State {
//   void on();
//   void off();
//}
//
//Create a new class "MyDevice" which implements both interfaces. Provide your implementations of methods.

public class MyDevice implements Volume, State {
    private boolean status;
    private double volume;

    @Override
    public void on() {
        status = true;
        System.out.println("TV turn on!");
    }

    @Override
    public void off() {
        status = false;
        System.out.println("TV turn off!");

    }

    @Override
    public void changeVolume(double value) {
        if (value >= 0 && value < 100 ) {
            volume = value;
            System.out.println("Current volume = " + volume);
        }
        else {
            System.out.println("Valid value 0 - 100 !!!");
        }

    }
}

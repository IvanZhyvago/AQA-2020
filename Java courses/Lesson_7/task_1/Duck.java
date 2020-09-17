package Lesson_7.task_1;

public class Duck implements Flyable {
    @Override
    public void fly() {
        System.out.println("I'am a duck and I Can't Fly");
        System.out.println("But I can make a sound:" + sound("duck-duck-duck"));
    }

    public String sound (String sound) {
        return sound;
    }
}

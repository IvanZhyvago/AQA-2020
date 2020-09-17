package Lesson_6.task_4;

public class B extends A {

    private String name = "class B extends A";

    B(String name) {
        super(name);
    }

    @Override
    public void setNameToUpperCase(){
        super.setNameToUpperCase();
        System.out.println(name);
    }

    @Override
    public double randomNumber() {
        System.out.println("All Override");
        return 0;
    }

}

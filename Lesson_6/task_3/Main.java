package Lesson_6.task_3;
//3) Start with a base class of a Vehicle,
// then create a Car class that inherits from this base class.
// Finally, create another class, a specific type of Car that inherits from the Car class.
// You should be able to hand steering, changing gears, and moving(speed in other words).
// You will want to decide where to put the appropriate state and behaviours(fields and methods).
// As mentioned above, changing gears, increasing/decreasing speed should be included.
// For you specific type of vehicle you will want to add something specific for that type of car.

public class Main extends Car {
    public Main(String name, String size) {
        super(name, size);
    }
    static Main main = new Main("Ferrari", "Big");

    @Override
    public void stop(){
        super.stop();
        System.out.println("Police find you, sorry :-( ");
        System.out.println("Velocity -> " + main.getCurrentVelocity());
    }

    public static void main(String[] args) {

        System.out.println(main.getName());
        System.out.println(main.getSize());
        main.move(80,20);
        main.steer(10);
        System.out.println("Velocity -> " + main.getCurrentVelocity());
        System.out.println("Direction -> " + main.getCurrentDirection());
        main.stop();

    }

}



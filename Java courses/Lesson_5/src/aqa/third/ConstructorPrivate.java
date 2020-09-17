package aqa.third;

public class ConstructorPrivate {
    String name = "";

    private ConstructorPrivate (String name) {
        System.out.println(name);
    }

    public static ConstructorPrivate makeConstructor (String name){
        return new ConstructorPrivate (name);
    }

    public static void callConstructor (String name) {
        makeConstructor(name);
    }
}

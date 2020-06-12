package aqa.third;

public class DemonstrateStatic {

    public double getNonStataticInt() {
        return nonStataticInt;
    }

    public static double getStaticInt() {
        return staticInt;
    }

    double nonStataticInt =  Math.random() * 1000;
    static double staticInt=  Math.random() * 1000;

}

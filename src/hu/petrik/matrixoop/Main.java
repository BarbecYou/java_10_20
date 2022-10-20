package hu.petrik.matrixoop;

public class Main {

    public static void main(String[] args) {

        Matrix m1 = new Matrix(5,7);
        System.out.println(m1);
        System.out.println();
        Matrix m2 = new Matrix(3,3);
        System.out.println(m2);
        System.out.println();
        System.out.println(m2.getElemekOsszege());
        System.out.println(m2.getPozitivElemekSzama());
        System.out.println(m2.getLegnagyobbElem());
    }
}

package hu.petrik.matrixoop;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int sor;
    private int oszlop;
    private int[][] m;
    private static final Random rnd = new Random();

    public Matrix(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;

        this.m = new int[sor][oszlop];

        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j] = rnd.nextInt(1000);
            }
        }
    }

    public int getElemekOsszege() {
        int osszeg = 0;
        for (int[] sor : this.m){
            for (int elem : sor) {
                osszeg += elem;
            }
        }
        return osszeg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] sor : this.m) {
            for (int elem : sor){
                sb.append(String.format("%3d ", elem));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

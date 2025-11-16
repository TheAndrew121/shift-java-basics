package homework21;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

// задача №2
public class MeasureAnimals {
    static void main(String[] args) throws UnsupportedEncodingException {

        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

        int boaLengthCm = 380;


        double boaLengthM = boaLengthCm / 100.0;

        double parrotHeightM = boaLengthM / 38;  // 38 попугаев = длина удава
        double monkeyHeightM = boaLengthM / 5;   // 5 мартышек = длина удава
        double elephantHeightM = boaLengthM / 2; // 2 слонёнка = длина удава


        double totalHeight = boaLengthM + parrotHeightM + monkeyHeightM + elephantHeightM;


        System.out.printf("Длина удава: %.2f%n", boaLengthM);
        System.out.printf("%.2f%n" ,parrotHeightM);
        System.out.printf("%.2f%n" ,monkeyHeightM);
        System.out.printf("%.2f%n" ,elephantHeightM);
        System.out.printf("%.2f%n" ,totalHeight);
    }
}
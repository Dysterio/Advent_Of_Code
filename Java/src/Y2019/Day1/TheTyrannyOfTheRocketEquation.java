package Y2019.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheTyrannyOfTheRocketEquation {
    private List<Integer> data = new ArrayList<>();

    public TheTyrannyOfTheRocketEquation() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2019/Day1/input.txt"));
        while (sc.hasNext()) {
            this.data.add(sc.nextInt());
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        int fuelSum = 0;

        for (int mass : this.data) {
            fuelSum += (mass / 3) - 2;
        }

        System.out.println(fuelSum);
    }

    private void part2() {
        int fuelSum = 0;

        for (int mass : this.data) {
            int fuel = (mass / 3) - 2;
            while (fuel > 0) {
                fuelSum += fuel;
                fuel = (fuel / 3) - 2;
            }
        }

        System.out.println(fuelSum);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new TheTyrannyOfTheRocketEquation();
    }
}

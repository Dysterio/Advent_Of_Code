package Y2020.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

public class TobogganTrajectory {
    private List<String> map = new ArrayList<>();

    public TobogganTrajectory() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2020/Day3/input.txt"));
        while (sc.hasNext()) {
            this.map.add(sc.next());
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        int treesFound = 0;
        int width = this.map.get(0).length();
        int height = this.map.size();
        int row = 0;
        while (true) {
            int col = (row * 3) % width;
            if (row >= height) break;
            if (this.map.get(row).charAt(col) == '#') treesFound++;
            row++;
        }
        System.out.println(treesFound);
    }

    private void part2() {
        int width = this.map.get(0).length();
        int height = this.map.size();
        int[] rowInc = new int[]{1, 1, 1, 1, 2};
        int[] colInc = new int[]{1, 3, 5, 7, 1};
        long[] treesFound = new long[]{0, 0, 0, 0, 0};
        for (int i = 0; i < 5; i++) {
            int index = 0;
            while (true) {
                int row = rowInc[i] * index;
                int col = (colInc[i] * index) % width;
                if (row >= height) break;
                if (this.map.get(row).charAt(col) == '#') treesFound[i]++;
                index++;
            }
        }

        long product = LongStream.of(treesFound).reduce((a, b) -> a * b).orElse(1);
        System.out.println(product);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new TobogganTrajectory();
    }
}

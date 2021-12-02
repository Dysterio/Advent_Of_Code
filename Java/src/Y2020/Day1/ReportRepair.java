package Y2020.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportRepair {
    private List<Integer> data = new ArrayList<>();

    public ReportRepair() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2020/Day1/input.txt"));
        while (sc.hasNextInt())
            this.data.add(sc.nextInt());

        this.part1();
        this.part2();
    }

    private void part1() {
        outer: for (int i = 0; i < this.data.size(); i++) {
            for (int j = i; j < this.data.size(); j++) {
                int ii = this.data.get(i);
                int jj = this.data.get(j);
                if (ii + jj == 2020) {
                    System.out.println(ii * jj);
                    break outer;
                }
            }
        }
    }

    private void part2() {
        outer: for (int i = 0; i < this.data.size(); i++) {
            for (int j = i; j < this.data.size(); j++) {
                for (int k = j; k < this.data.size(); k++) {
                    int ii = this.data.get(i);
                    int jj = this.data.get(j);
                    int kk = this.data.get(k);
                    if (ii + jj + kk == 2020) {
                        System.out.println(ii * jj * kk);
                        break outer;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new ReportRepair();
    }
}

package Y2019.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneTwoZeroTwo_ProgramAlarm {
    private List<Integer> data = new ArrayList<>();

    public OneTwoZeroTwo_ProgramAlarm() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2019/Day2/input.txt"));
        sc.useDelimiter(",");
        while (sc.hasNextInt()) {
            this.data.add(sc.nextInt());
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        // Copy data
        List<Integer> data = new ArrayList<>(this.data);
        data.set(1, 12);
        data.set(2, 2);
        // Run program
        int i = 0;
        while (true) {
            int opCode = data.get(i);
            if (opCode == 99) break;

            int pos1 = data.get(i + 1);
            int pos2 = data.get(i + 2);
            int pos3 = data.get(i + 3);

            int res = switch (opCode) {
                case 1 -> data.get(pos1) + data.get(pos2);
                case 2 -> data.get(pos1) * data.get(pos2);
                default -> throw new IllegalStateException("Unexpected value: " + opCode);
            };
            data.set(pos3, res);

            i += 4;
        }
        // Print outpu
        System.out.println(data.get(0));
    }

    private void part2() {
        final int output = 19690720;
        List<Integer> data;
        outer: for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                // Reset memory
                data = new ArrayList<>(this.data);
                data.set(1, noun);
                data.set(2, verb);
                // Re-run program
                int i = 0;
                while (true) {
                    int opCode = data.get(i);
                    if (opCode == 99) break;

                    int param1 = data.get(i + 1);
                    int param2 = data.get(i + 2);
                    int param3 = data.get(i + 3);

                    int res = switch (opCode) {
                        case 1 -> data.get(param1) + data.get(param2);
                        case 2 -> data.get(param1) * data.get(param2);
                        default -> throw new IllegalStateException("Unexpected value: " + opCode);
                    };
                    data.set(param3, res);

                    i += 4;
                }
                // Check for expected output
                if (data.get(0) == output) {
                    System.out.println(100 * noun + verb);
                    break outer;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new OneTwoZeroTwo_ProgramAlarm();
    }
}

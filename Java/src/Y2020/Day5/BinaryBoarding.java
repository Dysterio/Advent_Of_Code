package Y2020.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinaryBoarding {
    private List<String> data = new ArrayList<>();
    private List<Integer> seatIDs = new ArrayList<>();

    public BinaryBoarding() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2020/Day5/input.txt"));
        while (sc.hasNextLine()) {
            this.data.add(sc.nextLine());
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        int maxID = Integer.MIN_VALUE;
        for (String boardingPass : this.data) {
            String rowPath = boardingPass.substring(0, boardingPass.length() - 3);
            String colPath = boardingPass.substring(boardingPass.length() - 3);
            int row = this.calculateSeatLoc(rowPath, 127, 'F', 'B');
            int col = this.calculateSeatLoc(colPath, 7, 'L', 'R');

            int id = row * 8 + col;
            this.seatIDs.add(id);
            maxID = Math.max(maxID, id);
        }

        System.out.println(maxID);
    }

    private void part2() {
        Collections.sort(this.seatIDs);
        for (int i = 0; i < this.seatIDs.size() - 1; i++) {
            int thisSeat = this.seatIDs.get(i);
            int nextSeat = this.seatIDs.get(i + 1);
            if (nextSeat == thisSeat + 2) {
                System.out.println(thisSeat + 1);
                break;
            }
        }
    }

    private int calculateSeatLoc(String desc, int max, char lowerHalf, char upperHalf) {
        int min = 0;
        for (char c : desc.toCharArray()) {
            if (c == lowerHalf) max -= (max - min)/2 + 1;
            else if (c == upperHalf) min += (max - min)/2 + 1;
            else throw new IllegalStateException("Expected " + lowerHalf + " or " + upperHalf + " but got: " + c);
        }
        return min;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new BinaryBoarding();
    }
}

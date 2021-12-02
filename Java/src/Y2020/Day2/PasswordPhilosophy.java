package Y2020.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordPhilosophy {
    private List<String> policy = new ArrayList<>();
    private List<Character> character = new ArrayList<>();
    private List<String> password = new ArrayList<>();

    public PasswordPhilosophy() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2020/Day2/input.txt"));
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(" ");
            this.policy.add(data[0]);
            this.character.add(data[1].charAt(0));
            this.password.add(data[2]);
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        int validPW = 0;

        for (int i = 0; i < this.password.size(); i++) {
            String[] policy = this.policy.get(i).split("-");
            char c = this.character.get(i);
            String pw = this.password.get(i);
            int minOcc = Integer.parseInt(policy[0]);
            int maxOcc = Integer.parseInt(policy[1]);

            long occ = pw.chars().filter(ch -> ch == c).count();
            if ((occ >= minOcc) && (occ <= maxOcc)) validPW++;
        }

        System.out.println(validPW);
    }

    private void part2() {
        int validPW = 0;

        for (int i = 0; i < this.password.size(); i++) {
            String[] policy = this.policy.get(i).split("-");
            char c = this.character.get(i);
            String pw = this.password.get(i);
            int firInd = Integer.parseInt(policy[0]) - 1;
            int secInd = Integer.parseInt(policy[1]) - 1;

            if ((pw.charAt(firInd) == c) ^ (pw.charAt(secInd) == c)) validPW++;
        }

        System.out.println(validPW);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new PasswordPhilosophy();
    }
}

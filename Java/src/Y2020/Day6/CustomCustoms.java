package Y2020.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomCustoms {
    private List<List<String>> data = new ArrayList<>();

    public CustomCustoms() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2020/Day6/input.txt"));
        this.data.add(new ArrayList<>());
        while (sc.hasNextLine()) {
            String answers = sc.nextLine();
            if (answers.isEmpty()) {
                this.data.add(new ArrayList<>());
                answers = sc.nextLine();
            }
            this.data.get(this.data.size() - 1).add(answers);
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        int count = 0;

        for (List<String> groupAns : this.data) {
            Set<Character> ans = new HashSet<>();
            groupAns.forEach(s -> s.chars().mapToObj(i -> (char)i).forEach(ans::add));
            count += ans.size();
        }

        System.out.println(count);
    }

    private void part2() {
        int count = 0;
        for (List<String> groupAns : this.data) {
            groupAns.sort(Comparator.comparingInt(String::length));
            List<Character> ans = new ArrayList<>();
            groupAns.get(0).chars().mapToObj(i -> (char)i).forEach(c -> {
                if (!ans.contains(c)) ans.add(c);
            });
            for (int i = 1; i < groupAns.size(); i++) {
                String s = groupAns.get(i);
                for (int j = ans.size() - 1; j >= 0; j--) {
                    char c = ans.get(j);
                    if (!s.contains(c + ""))
                        ans.remove((Character) c);
                }
            }
            count += ans.size();
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new CustomCustoms();
    }
}

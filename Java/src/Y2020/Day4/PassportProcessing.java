package Y2020.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PassportProcessing {
    private List<Map<String, String>> data = new ArrayList<>();
    private String[] reqFields = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    public PassportProcessing() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Y2020/Day4/input.txt"));
        sc.useDelimiter("\n\n");
        while (sc.hasNext()) {
            Scanner passportSc = new Scanner(sc.next());
            passportSc.useDelimiter("\s|:|\n");
            Map<String, String> passportDetails = new HashMap<>();
            while (passportSc.hasNext()) {
                String field = passportSc.next();
                String value = passportSc.next();
                passportDetails.put(field, value);
            }
            this.data.add(passportDetails);
        }

        this.part1();
        this.part2();
    }

    private void part1() {
        int validPassports = 0;
        outer: for (Map<String, String> passport : this.data) {
            for (String field : this.reqFields) {
                if (passport.get(field) == null) {
                    continue outer;
                }
            }
            validPassports++;
        }
        System.out.println(validPassports);
    }

    private void part2() {
        int validPassports = 0;
        for (Map<String, String> passport : this.data) {
            // Birth Year
            String byr = passport.get("byr");
            if (byr == null) continue;
            int byrVal = Integer.parseInt(byr);
            if ((byrVal < 1920) || (byrVal > 2002)) continue;
            // Issue Year
            String iyr = passport.get("iyr");
            if (iyr == null) continue;
            int iyrVal = Integer.parseInt(iyr);
            if ((iyrVal < 2010) || (iyrVal > 2020)) continue;
            // Expiration Year
            String eyr = passport.get("eyr");
            if (eyr == null) continue;
            int eyrVal = Integer.parseInt(eyr);
            if ((eyrVal < 2020) || (eyrVal > 2030)) continue;
            // Height
            String hgt = passport.get("hgt");
            if (hgt == null) continue;
            if (!hgt.matches("[0-9]+(in|cm)")) continue;
            int hgtVal = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            String hgtUnit = hgt.substring(hgt.length() - 2);
            switch (hgtUnit) {
                case "cm":
                    if ((hgtVal < 150) || (hgtVal > 193)) continue;
                    break;
                case "in":
                    if ((hgtVal < 59) || (hgtVal > 76)) continue;
                    break;
            }
            // Hair Color
            String hcl = passport.get("hcl");
            if (hcl == null) continue;
            if (hcl.charAt(0) != '#') continue;
            if (hcl.length() != 7) continue;
            // Eye Color
            String ecl = passport.get("ecl");
            if (ecl == null) continue;
            switch (ecl) {
                case "amb", "blu", "brn", "gry", "grn", "hzl", "oth":
                    break;
                default:
                    continue;
            }
            // Passport ID
            String pid = passport.get("pid");
            if (pid == null) continue;
            if (pid.length() != 9) continue;

            validPassports++;
        }

        System.out.println(validPassports);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new PassportProcessing();
    }
}

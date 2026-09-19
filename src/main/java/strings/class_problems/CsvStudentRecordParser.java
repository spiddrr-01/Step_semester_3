package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 2: CSV Student Record Parser
 *
 * Splits a "Name,RollNumber,Department" line into fields and prints a formatted
 * record, or "Invalid Record" when the field count is not exactly 3.
 */
public class CsvStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String rollNumber = fields[1];
        String department = fields[2];
        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE"); // Name: Ananya Verma | Roll No: RA2211003010123 | Dept: CSE
        parseStudentRecord("Ananya Verma,CSE");                 // Invalid Record
    }
}

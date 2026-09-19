package arrays_and_methods.class_problems;

/**
 * Week 5 - Category C - Problem 2: Duplicate Team Name Finder
 *
 * Scans the team names with plain nested loops (no Collections) and reports the
 * first duplicate, in order. Each name is only compared against the names that
 * come after it, so no pair is checked twice. Comparison is case-sensitive.
 */
public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "ByteForce"}));   // Duplicate Found: ByteForce
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "NullPointers"})); // No Duplicates Found
    }
}

package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 4: The Warehouse Inventory Balancer
 *
 * Sums two equal-length section arrays, reports whether their totals are
 * balanced, and finds the single highest quantity across the whole warehouse
 * along with the section and 1-based item position it was found at.
 */
public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        for (int quantity : sectionA) {
            totalA += quantity;
        }

        int totalB = 0;
        for (int quantity : sectionB) {
            totalB += quantity;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Track the single highest quantity across both sections. On a tie the
        // first one found wins: Section A is scanned before Section B, and a
        // lower index wins within a section (strict > keeps the earlier one).
        int bestQty = Integer.MIN_VALUE;
        String bestSection = "";
        int bestItem = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > bestQty) {
                bestQty = sectionA[i];
                bestSection = "Section A";
                bestItem = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > bestQty) {
                bestQty = sectionB[i];
                bestSection = "Section B";
                bestItem = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + bestQty
                + " (" + bestSection + ", Item " + bestItem + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
        // Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)
    }
}

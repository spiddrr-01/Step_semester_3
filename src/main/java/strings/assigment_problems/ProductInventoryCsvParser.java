package strings.assigment_problems;

/**
 * Week 2 - Problem 3: Product Inventory CSV Parser
 *
 * Splits a "ProductName,SKU,Quantity" line into fields and prints a formatted
 * record, or "Invalid Record" when the field count is wrong.
 */
public class ProductInventoryCsvParser {

    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0];
        String sku = fields[1];
        String quantity = fields[2];
        System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150"); // Product: Wireless Mouse | SKU: WM-2201 | Qty: 150
        parseInventoryRecord("Wireless Mouse,150");          // Invalid Record
    }
}

import java.util.Arrays;
import java.util.Comparator;

// Product class
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + ": " + productName + " (" + category + ")";
    }
}

// Main class
public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (requires sorted array)
    public static Product binarySearch(Product[] products, String targetName) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String midName = products[mid].productName.toLowerCase();

            if (midName.equals(targetName.toLowerCase())) {
                return products[mid];
            } else if (targetName.toLowerCase().compareTo(midName) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    // Main method
    public static void main(String[] args) {
        // Create products
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Smartphone", "Electronics"),
            new Product(105, "Watch", "Accessories")
        };

        // Perform Linear Search
        String searchItem = "Smartphone";
        Product result1 = linearSearch(products, searchItem);
        System.out.println("🔍 Linear Search Result: " + (result1 != null ? result1 : "Product not found"));

        // Perform Binary Search
        Product result2 = binarySearch(products, searchItem);
        System.out.println("🔍 Binary Search Result: " + (result2 != null ? result2 : "Product not found"));
    }
}

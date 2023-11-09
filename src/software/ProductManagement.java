package software;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String productName;
    private int productNumber;
    private int numPieces;

    public Product(String productName, int productNumber, int numPieces) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.numPieces = numPieces;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public int getNumPieces() {
        return numPieces;
    }

    public void setNumPieces(int numPieces) {
        this.numPieces = numPieces;
    }

    @Override
    public String toString() {
        return "Product Name: " + productName + ", Product Number: " + productNumber + ", Number of Pieces: " + numPieces;
    }
}

public class ProductManagement {
    public ArrayList<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	
        
    }

    public void addProduct() {
    	System.out.print("                     add product\n ");
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Product Number: ");
        int productNumber = scanner.nextInt();

        System.out.print("Enter Number of Pieces: ");
        int numPieces = scanner.nextInt();

        Product product = new Product(productName, productNumber, numPieces);
        productList.add(product);

        System.out.println("Product added successfully!");
    }

    public void editProduct() {
        System.out.print("Enter the Product Number you want to edit: ");
        int productNumber = scanner.nextInt();

        for (Product product : productList) {
            if (product.getProductNumber() == productNumber) {
                System.out.print("Enter new Number of Pieces: ");
                int numPieces = scanner.nextInt();

                product.setNumPieces(numPieces);
                System.out.println("Product updated successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void deleteProduct() {
    	System.out.print("                     delete product\n ");
        System.out.print("Enter the Product Number you want to delete: ");
        int productNumber = scanner.nextInt();

        for (Product product : productList) {
            if (product.getProductNumber() == productNumber) {
                productList.remove(product);
                System.out.println("Product deleted successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void viewProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        System.out.println("List of Products:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

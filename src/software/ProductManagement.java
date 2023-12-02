package software;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String productName;
    private int productNumber;
    public int numPieces;
    private int price;
    private String category;
    public Product(String productName, int productNumber, int numPieces,int price, String category ) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.numPieces = numPieces;
        this.price = price;
        this.category = category;
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
    public int getProductPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCategory(String price) {
        this.category = price;
    }
    @Override
    public String toString() {
        return "Product Name: " + productName + ", Product Number: " + productNumber + ", Number of Pieces: " + numPieces + ", Price: " + price + ", Category: " + category;
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
        System.out.print("Enter The Price Of The Product: ");
        int price = scanner.nextInt();
        System.out.print("Enter The Number Of The New Category:"
    			+ "1)Interior 2)Exterior 3)Electronics");
    	Scanner scanner1 = new Scanner(System.in);
        int cat = scanner1.nextInt();
        String cate="Invalid Choice";
        if(cat==1)
        	cate= "Interior";
        else if(cat==2)
        	cate= "Exterior";
        else if(cat==3)
        	cate= "Electronics";
        Product product = new Product(productName, productNumber, numPieces, price, cate);
        productList.add(product);

        System.out.println("Product added successfully!");
    }

    public void editProduct() {
    	if (productList.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        
        System.out.println("List of Products:");
        for (Product product : productList) {
            System.out.println(product);
        }
    	System.out.print("Enter the Product Number you want to edit: ");
        int productNumber = scanner.nextInt();
        
        System.out.print("Enter 1 If You Want To Edit The Number Of Pieces , 2 To Edit The Product Price And 3 To Edit Product Category: ");
        int c = scanner.nextInt();

        for (Product product : productList) {
            if (product.getProductNumber() == productNumber) {
                if(c==1) {
            	System.out.print("Enter new Number of Pieces: ");
                int numPieces = scanner.nextInt();

                product.setNumPieces(numPieces);
                }
                else if(c==2) 
                {
                	System.out.print("Enter The New Price: ");
                    int price = scanner.nextInt();

                    product.setPrice(price);
                }
                else if(c==3) 
                {
                	System.out.print("Enter The Number Of The New Category:"
                			+ "1)Interior 2)Exterior 3)Electronics");
                	Scanner scanner1 = new Scanner(System.in);
                    int cat = scanner1.nextInt();
                    String cate="Invalid Choice";
                    if(cat==1)
                    	cate= "Interior";
                    else if(cat==2)
                    	cate= "Exterior";
                    else if(cat==3)
                    	cate= "Electronics";
                    product.setCategory(cate);
                }
                else 
                {
                	System.out.println("Invalid Input!");
                	return;
                }
                System.out.println("Product updated successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void deleteProduct() {
    	if (productList.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        
        System.out.println("List of Products:");
        for (Product product : productList) {
            System.out.println(product);
        }
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
        System.out.println("1)Interior 2)Exterior 3)Electronics \n Enter The Number Of The Category You Want:");
        Scanner scanner1 = new Scanner(System.in);
        int cat = scanner1.nextInt();
        String cate= "Invalid Choice";
        if(cat==1)
        	cate= "Interior";
        else if(cat==2)
        	cate= "Exterior";
        else if(cat==3)
        	cate= "Electronics";
        System.out.println("List of Products:");
        for (Product product : productList) {
        	if(product.getCategory().equals(cate))
            System.out.println(product);
        }
    }
    public int BrowseProducts(int prod) {
        if (productList.isEmpty()) {
            System.out.println("No products found.");
            return 0;
        }

        System.out.println("Adding product to cart:");
        for (Product product : productList) {
             if(product.getProductNumber()== prod) {
            	 product.numPieces= product.numPieces - 1 ;
            	 return product.getProductPrice();
            	 }
        }
        System.out.println("product not found.");
        return 0;
    }
}

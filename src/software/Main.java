package software;

import java.util.*;
class User {
    private String username;
    private String password;
    private String role;
    private String Email;
    private String Phone;
    private String Birthday;
    
    
    public User(String username, String password, String role, String Email, String Phone, String Birthday) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.Email = Email;
        this.Phone = Phone;
        this.Birthday = Birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    public String getEmail() {
        return Email;
    }
    public String getPhone() {
        return Phone;
    }
    public String getBirthday() {
        return Birthday;
    }
}

public class Main {
    public static List<User> users = new ArrayList<>();
    public static User currentUser;
    public static ProductManagement pm = new ProductManagement();
    public static boolean signUp() {
    	
    	System.out.println("               Sign up \n");
   	 System.out.println("Enter your Username:");
   	 Scanner usn = new Scanner(System.in);
   	 String un  = usn.next();
   	 System.out.println("Enter your password:");
   	 Scanner pas = new Scanner(System.in);
   	 String pass  = pas.next();
   	System.out.println("Enter your Email:");
  	 Scanner em = new Scanner(System.in);
  	 String email  = em.next();
  	System.out.println("Enter your phone number:");
  	 Scanner ph = new Scanner(System.in);
  	 String phone  = ph.next();
  	System.out.println("Enter your birthday (in this formula year/month/day):");
 	 Scanner birth = new Scanner(System.in);
 	 String day  = birth.next();
   	System.out.println("Enter your role number: \n 1)admin \n 2)customer \n 3)installer");
   	Scanner num = new Scanner(System.in);
   	 int numb  = num.nextInt();
   	String rol = null;
   	 if(numb==1)
   	 
   	  rol  = "admin";
   	
   	 else if(numb==2)
   	 
   		  rol  = "customer";
   	
   	 
   	 else if(numb==3)
   	 
   		  rol  = "installer";
   		
   	 
   	 else System.out.println("wrong number please enter one of the three numbers");
   	for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(un)) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }
    }
   	User newUser = new User(un, pass, rol ,email, phone, day);
        users.add(newUser);
        System.out.println("User registered successfully.");
        return true;
    }

    public static boolean signIn() {
    	System.out.println("               Sign in \n");
    	System.out.println("Enter your Username:");
      	 Scanner usn1 = new Scanner(System.in);
      	 String una1  = usn1.next();
      	 System.out.println("Enter your Password:");
      	 Scanner pas1 = new Scanner(System.in);
      	 String pass1  = pas1.next();
    	for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(una1) && user.getPassword().equals(pass1)) {
                currentUser = user;
                System.out.println("Welcome, " + user.getUsername());
                return true;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return false;
    }

    public static void signOut() {
        if (currentUser != null) {
            System.out.println("Goodbye, " + currentUser.getUsername());
            currentUser = null;
        } else {
            System.out.println("No user is currently signed in.");
        }
    }

    public static void getCurrentUserDetails() {
        if (currentUser != null) {
            System.out.println("Current User: " + currentUser.getUsername() +"\n Email:" +currentUser.getEmail()+ "\n Phone:" + currentUser.getPhone()+ "\n Birthday:" + currentUser.getBirthday() +" \n Role: " + currentUser.getRole());
        } else {
            System.out.println("No user is currently signed in.");
        }
    }
    public static int showMenu(String role) {
        if (role.equals("admin")) {
            Scanner scanner1 = new Scanner(System.in);
            int choice;
  
            while (true) {
            	System.out.println("              Admin Dashboard  \n ");
                System.out.println("Menu:");
                System.out.println("1) View Users");
                System.out.println("2) Products Page");
                System.out.println("3) Sign out");
                System.out.print("Enter your choice: ");

                choice = scanner1.nextInt();
                scanner1.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Displaying Users Page...");
                        return 1;
                        
                    case 2:
                        System.out.println("Displaying Products Page...");
                        return 2;
                        
                    case 3:
                        System.out.println("Exiting...");
                        return 3;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        return 4;
                }
            }
        } else {
            ;
        }
		return 0;
    }
    public static void viewUsers() {
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Birthday: " + user.getBirthday());
            System.out.println("Role: " + user.getRole());
            System.out.println("-------------------");
        }
    }

    public static void addUsers() {
    	String un="osama";
    	String pass="osama123";
    	String rol="admin";
    	String email="osama@gamil.com";
    	String phone="0599999999";
    	String day="2002/7/27";
    	User User1 = new User(un, pass, rol ,email, phone, day);
        users.add(User1);
        un="ahmad";
   	 pass="ahmad123";
   	 rol="customer";
   	 email="ahmad@gamil.com";
   	 phone="0599999998";
   	 day="2003/6/17";
       User User2 = new User(un, pass, rol ,email, phone, day);
       users.add(User2);
       un="mohammed";
  	    pass="mohammed123";
  	    rol="customer";
  	    email="mohammed@gamil.com";
  	    phone="0599998888";
  	    day="2001/9/25";
       User User3 = new User(un, pass, rol ,email, phone, day);
       users.add(User3);
       un="khaled";
  	    pass="khaled123";
  	    rol="installer";
  	    email="khaled@gamil.com";
  	    phone="0577777777";
  	    day="2000/12/12";
       User User4 = new User(un, pass, rol ,email, phone, day);
       users.add(User4);
       un="ayman";
  	    pass="ayman123";
  	    rol="installer";
  	    email="ayman@gamil.com";
  	    phone="0566666666";
  	    day="2000/2/10";
       User User5 = new User(un, pass, rol ,email, phone, day);
       users.add(User5);
    }
    
    
    public static void addProducts() {
    	String productName="Table";
    	int productNumber= 101;
    	int numPieces= 23;
    	Product product = new Product(productName, productNumber, numPieces);
        pm.productList.add(product);
         productName="Chair";
    	 productNumber= 102;
    	 numPieces= 50;
    	Product product1 = new Product(productName, productNumber, numPieces);
        pm.productList.add(product1);
         productName="Hat";
    	 productNumber= 103;
    	 numPieces= 60;
    	Product product2 = new Product(productName, productNumber, numPieces);
        pm.productList.add(product2);
         productName="Cup";
    	 productNumber= 104;
    	 numPieces= 100;
    	Product product3 = new Product(productName, productNumber, numPieces);
        pm.productList.add(product3);
    }
    
    public static void main(String[] args) {
    	System.out.println("Available Features 1)Sign in/out/up 2)Admin Dashboard\n");
    	addProducts();
        addUsers();
    	System.out.println("Enter 1 to sign up and 2 to sign in:");
    	Scanner scanne = new Scanner(System.in);
        int choic = scanne.nextInt();
        if (choic == 1) {
    	signUp();
        signIn();
        getCurrentUserDetails();
        }
        else if(choic==2)
        {
        signIn();
        getCurrentUserDetails();
        }
        
        Scanner scanner = new Scanner(System.in);
        
            
            
            int x;
            while(true)
            {
             x= showMenu(currentUser.getRole());
             if(x==3) {
            	 signOut();
            	 break;
             }
             else if(x==1)
             {
             	viewUsers();
             }
             else if(x==2)
             {
             while (true) {
                 System.out.println("\nMenu:");
                 System.out.println("1. Add Product");
                 System.out.println("2. Edit Product");
                 System.out.println("3. Delete Product");
                 System.out.println("4. View Products");
                 System.out.println("5. Exit");
                 System.out.print("Enter your choice: ");
                  
                 int choice1 = scanner.nextInt();
                 scanner.nextLine();  // Consume the newline character
                  if(choice1==5)
                	  break;
                 switch (choice1) {
                     case 1:
                         pm.addProduct();
                         break;
                     case 2:
                         pm.editProduct();
                         break;
                     case 3:
                         pm.deleteProduct();
                         break;
                     case 4:
                         pm.viewProducts();
                         break;
                     case 5:
                    	 break;
                     default:
                         System.out.println("Invalid choice. Please try again.");
                 }
             }
     }
            }
            
            
    } 
}


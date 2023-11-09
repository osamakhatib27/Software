package software;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
public class UserManagementTest {

	
	
    @Test
    public void testSignUp() {
        assertTrue(Main.signUp());
    }

    @Test
    public void testSignIn() {
        assertTrue(Main.signIn());
    }

    @Test
    public void testSignOut() {
        Main.currentUser = new User("testuser", "testpass", "customer", "test@example.com", "123456789", "2000/01/01");
        assertNotNull(Main.currentUser);
        Main.signOut();
        assertNull(Main.currentUser);
    }

    @Test
    public void testShowMenu() {
        assertEquals(1, Main.showMenu("admin"));
        assertEquals(2, Main.showMenu("admin"));
        assertEquals(3, Main.showMenu("admin"));
    }

    @Test
    public void testViewUsers() {
    	 Main.addUsers();
        assertNotNull(Main.users);
        assertEquals(5, Main.users.size());
        
    }
    @Test
    public void testViewProducts() {
    	 Main.addProducts();
        assertNotNull(Main.pm.productList);
        assertEquals(4, Main.pm.productList.size());
        
    }
    @Test
    public void testAddProduct() {
        int Size = Main.pm.productList.size();
        Main.pm.addProduct();
        assertEquals(Size + 1, Main.pm.productList.size());
    }
    @Test
    public void testDeleteProduct() {
        int DSize = Main.pm.productList.size();
        Main.pm.deleteProduct();
        assertEquals(DSize - 1, Main.pm.productList.size());
    }
}
import java.util.*;




public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        // Task 1: Create a user, add user to roles, and print user details
        Set<Integer> roleIdsUser1 = new HashSet<>(Arrays.asList(1, 2));
        service.createUser(1, "John", "Doe", "john@example.com", "password123", roleIdsUser1);
        
        Set<Integer> roleIdsUser2 = new HashSet<>(Arrays.asList(1, 3));
        service.createUser(2, "Jack", "Smith", "jack@example.com", "password321", roleIdsUser2);
        
        // Task 2: Add user to a role
        service.addUserToRole(1, 4);
        
        Employee t1 = service.getEmployeeById(1);
        System.out.println("User ID: " + t1.getId());
        System.out.println("First Name: " + t1.getFirstName());
        System.out.println("Last Name: " + t1.getLastName());
        System.out.println("Email: " + t1.getEmail());
        System.out.println("Roles: " + t1.getRoleIds());
        System.out.println("-----------------------------------");
        
        
        // Task 3: Remove user from a role
        service.removeUserFromRole(1, 2);
        Employee t2 = service.getEmployeeById(1);
        System.out.println("User ID: " + t2.getId());
        System.out.println("First Name: " + t2.getFirstName());
        System.out.println("Last Name: " + t2.getLastName());
        System.out.println("Email: " + t2.getEmail());
        System.out.println("Roles: " + t2.getRoleIds());
        System.out.println("-----------------------------------");
        
        // Task 4: Print list of users having both reader and creator roles
        service.addUserToRole(2, 4);
        service.getUsersWithRoles(1, 4);
        
        Employee t3 = service.getEmployeeById(1);
        
        
     
    }
}

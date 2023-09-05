import java.util.*;




public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        // Task 1: Create a user, add user to roles, and print user details
        Set<Integer> roleIds = new HashSet<>(Arrays.asList(1, 2));
        service.createUser(1, "John", "Doe", "john@example.com", "password123", roleIds);
        
        Employee user = service.getEmployeeById(1);
//        if (user != null) {
//            System.out.println("User ID: " + user.getId());
//            System.out.println("First Name: " + user.getFirstName());
//            System.out.println("Last Name: " + user.getLastName());
//            System.out.println("Email: " + user.getEmail());
//            System.out.println("Roles: " + user.getRoleIds());
//        } else {
//            System.out.println("User not found.");
//        }
        System.out.println("-----------------------------------");
        // Task 2: Add user to a role
        service.addUserToRole(1, 3);
        Employee e1 = service.getEmployeeById(1);
//        System.out.println("User ID: " + user.getId());
//        System.out.println("First Name: " + user.getFirstName());
//        System.out.println("Last Name: " + user.getLastName());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Roles: " + user.getRoleIds());
        
        // Task 3: Remove user from a role
        //service.removeUserFromRole(1, 2);

        // Task 4: Print list of users having both reader and creator roles
        //service.getUsersWithRoles(1, 2);
        
        
     
    }
}

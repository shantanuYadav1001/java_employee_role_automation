import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Service {
	
	
    private List<Role> roles;			//create role list to save the Role hash set
    private List<Employee> users;		//create user list to save the pointer to each employee object
    
    public Service() {
    	
    	//initialize both lists
        roles = new ArrayList<>();
        users = new ArrayList<>();
        
        // Initialize roles in the constructor
        roles.add(new Role(1, "Reader", "Read-only access", new HashSet<>()));
        roles.add(new Role(2, "Creator", "Create content", new HashSet<>()));
        roles.add(new Role(3, "Editor", "Edit content", new HashSet<>()));
        roles.add(new Role(4, "Owner", "Full access", new HashSet<>()));
    }
    
    //this method returns the object reference in role list 
    private Role getRoleById(int roleId) {
        for (Role role : roles) {
            if (role.getId() == roleId) {
                return role;
            }
        }
        return null;
    }
    
    //this method return the object reference in users list
    public Employee getEmployeeById(int userId) {
        for(Employee employee : users) {
        	if (employee.getId() == userId) {
                return employee;
        	}
        }
        return null;
    }
    

    //------------------------------------------------------------------------------------------------------
    //method to create user
    public void createUser(int id, String firstName, String lastName, String email, 
    						String password, Set<Integer> roleIds) 
    {	
    	//create employee object and pass the values
        Employee employee = new Employee(id, firstName, lastName, email, password, roleIds);
        
        
        for (int roleId : roleIds) {
            Role role = getRoleById(roleId);
            if (role != null) {
                role.getEmployeeIds().add(id);
            }
        }
        //add the reference to the object in users list
        users.add(employee);
        
        // Print user details
        System.out.println("User created: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("User ID: " + employee.getId());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Roles: " + employee.getRoleIds());
        System.out.println("-----------------------------------");
    }

    //---------------------------------------------------------------------------------------------------
    //add user to role
    public void addUserToRole(int userId, int roleId) {
    	
    	Role role = getRoleById(roleId);
    	Employee user = getEmployeeById(userId);
    	
    	if (role != null && user != null) {
    		user.getRoleIds().add(roleId);
    		role.getEmployeeIds().add(userId);
    		System.out.println("Role with ID " + roleId + " was added to employee with ID" + userId);
    	}
    	else if (role == null ) {
            System.out.println("Role with ID " + roleId + " not Found!!!");
        }
    	else if (user == null) {
    		System.out.println("Employee with ID " + userId + " not Found!!!");
    	}
       
    }

    //remove user from role
    public void removeUserFromRole(int userId, int roleId) {
        
    	Role role = getRoleById(roleId);
        Employee user = getEmployeeById(userId);
        
        if (role != null && user != null) {
        	
            boolean removeUserFromRole = role.getEmployeeIds().remove(userId);
            boolean removeRoleFromUser = user.getRoleIds().remove(roleId);
            
            if (removeUserFromRole && removeRoleFromUser) {
                System.out.println("User with ID " + userId + " removed from role " + role.getName());
            } else {
                System.out.println("User with ID " + userId + " was not found in role " + role.getName());
            }
        } 
        else if (role == null ) {
            System.out.println("Role with ID " + roleId + "not Found!!!");
        }
    	else if (user == null) {
    		System.out.println("Employee with ID " + userId + "not Found!!!");
    	}
    }

    //get the all User Ids with these roles
    public void getUsersWithRoles(int roleId1, int roleId2) {
        Role role1 = getRoleById(roleId1);
        Role role2 = getRoleById(roleId2);

        if (role1 != null && role2 != null) {
            Set<Integer> usersInBothRoles = new HashSet<>(role1.getEmployeeIds());
            usersInBothRoles.retainAll(role2.getEmployeeIds());

            System.out.println("Users with both roles " + role1.getName() + " and " + role2.getName() + ": " + usersInBothRoles);
        } else {
            System.out.println("One or both roles not found.");
        }
    }

   
    
    
}
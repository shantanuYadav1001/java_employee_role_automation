import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Service {
    private List<Role> roles;
    private List<Employee> emp = new ArrayList<>();
    public Service() {
        roles = new ArrayList<>();
        // Initialize roles in the constructor
        roles.add(new Role(1, "Reader", "Read-only access", new HashSet<>()));
        roles.add(new Role(2, "Creator", "Create content", new HashSet<>()));
        roles.add(new Role(3, "Editor", "Edit content", new HashSet<>()));
        roles.add(new Role(4, "Owner", "Full access", new HashSet<>()));
    }

    public void createUser(int id, String firstName, String lastName, String email, String password, Set<Integer> roleIds) {
        Employee employee = new Employee(id, firstName, lastName, email, password, roleIds);
        
        for (int roleId : roleIds) {
            Role role = getRoleById(roleId);
            if (role != null) {
                role.getEmployeeIds().add(id);
            }
        }
        emp.add(employee);
        
        // Print user details
        System.out.println("User created: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("User ID: " + employee.getId());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Roles: " + employee.getRoleIds());
        System.out.println("-----------------------------------");
    }

    public void addUserToRole(int userId, int roleId) {
    	if (roleId < 5 && roleId > 0) {
	    	for(Employee e : emp) {
	        	if (e.getId() == userId) {
	        		e.getRoleIds().add(roleId);
	                
	        	}
	        }
    	}
    	else {
            System.out.println("Role with ID " + roleId + "not Found!!!");
        }
       
    }

    public void removeUserFromRole(int userId, int roleId) {
        Role role = getRoleById(roleId);
        if (role != null) {
            boolean removed = role.getEmployeeIds().remove(userId);
            if (removed) {
                System.out.println("User with ID " + userId + " removed from role " + role.getName());
            } else {
                System.out.println("User with ID " + userId + " was not found in role " + role.getName());
            }
        } else {
            System.out.println("Role with ID " + roleId + " not found.");
        }
    }

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

    private Role getRoleById(int roleId) {
        for (Role role : roles) {
            if (role.getId() == roleId) {
                return role;
            }
        }
        return null;
    }
    
    public Employee getEmployeeById(int userId) {
        for(Employee e : emp) {
        	if (e.getId() == userId) {
        		System.out.println("User name: " + e.getFirstName() + " " + e.getLastName());
                System.out.println("User ID: " + e.getId());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Roles: " + e.getRoleIds());
                System.out.println("-----------------------------------");
                
        	}
        }
        // Employee with the specified userId not found
        return null;
    }
}
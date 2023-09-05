import java.util.Set;

class Role {
    private int id;
    private String name;
    private String description;
    private Set<Integer> employeeIds;

    public Role(int id, String name, String description, Set<Integer> employeeIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.employeeIds = employeeIds;
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Integer> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(Set<Integer> employeeIds) {
        this.employeeIds = employeeIds;
    }
}

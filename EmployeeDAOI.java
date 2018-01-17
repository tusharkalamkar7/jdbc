public interface EmployeeDaoI {
    Employee getEmployee(int id);
    Set<Employee> getAllEmployees();
    boolean insertEmployee(Employee emp);
    boolean updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
}
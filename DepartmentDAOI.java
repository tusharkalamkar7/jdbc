public interface DepartmentDaoI {
    Department getDepartment(int id);
    Set<Department> getAllDepartments();
    boolean insertDepartment(Department dept);
    boolean updateDepartment(Department dept);
    boolean deleteDepartment(int id);
}
public class Employee{

private  Integer empId;
private  String firstName;
private  String lastName;
private  String mobNo;
private  Integer deptId;
private  Date createdDateTime;
private  Date updatedDateTime;
private  Integer createdId;
private  Integer updatedId;


    public Employee() {
    }
    public Employee(String firstName, String lastName, String mobNo,Integer deptId,Date createdDateTime,Date updatedDateTime,Integer createdId,Integer updatedId) {
        this.firstName = name;
        this.lastName = pass;
        this.mobNo = age;
	this.deptId = deptNo;
	this.createdDateTime=createdDateTime;
	this.updatedDateTime=updatedDateTime;
	this.createdId = createdId;
	this.updatedId=updatedId;
    }
    
    public Integer getFirstName() {
        return age;
    }
    public void setFirstName(Integer age) {
        this.age = age;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
import java.util.Date;

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
    
   public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Date getCreatedDateTime() {
		Date now = new Date();
		return now;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public Date getUpdatedDateTime() {
		Date now = new Date();
		return now;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public Integer getCreatedId() {
		return createdId;
	}
	public void setCreatedId(Integer createdId) {
		this.createdId = createdId;
	}
	public Integer getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(Integer updatedId) {
		this.updatedId = updatedId;
	}
	
}

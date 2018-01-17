import java.util.Date;

public class Department {

    private Integer deptId;
    private String deptName;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Integer createdId;
    private Integer updatedId;

    public Department() {
    }
    public Department(String deptName, Date createdDateTime,Date updatedDateTime,Integer createdId,Integer updatedId) {
        this.deptName = deptName;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
	this.createdId = createdId;
	this.updatedId = updatedId;
    }
		public Integer getDeptId() {
			return deptId;
		}
		public void setDeptId(Integer deptId) {
			this.deptId = deptId;
		}
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		public Date getCreatedDateTime() {
			Date now = new Date();
			return now;
		}
		public void setCreatedDateTime(Date createdDateTime) {
			this.createdDateTime = createdDateTime;
		}
		public Date getUpdatedDateTime() {
			return updatedDateTime;
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

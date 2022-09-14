package jdbc0914;

public class EmpDto {
	private int employeeid;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String hiredate;
	private String jobid;
	public EmpDto() {		
	}
	@Override
	public String toString() {
		return "EmpDto [employeeid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phonenumber=" + phonenumber + ", hiredate=" + hiredate + ", jobid=" + jobid + "]";
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public EmpDto(int employeeid, String firstname, String lastname, String email, String phonenumber, String hiredate,
			String jobid) {
		super();
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.hiredate = hiredate;
		this.jobid = jobid;
	}	
}

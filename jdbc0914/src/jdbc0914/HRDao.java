package jdbc0914;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HRDao extends DataBase{
	
	public List<EmpDto> getEmpList(){
		List<EmpDto> emps = new ArrayList<>();
		String sql =  "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, "
					+ "PHONE_NUMBER, HIRE_DATE, JOB_ID "
					+ "FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass() + " 2/6 S");
			psmt = conn.prepareStatement(sql);
			System.out.println(this.getClass() + " 3/6 S");
			rs=psmt.executeQuery();
			System.out.println(this.getClass() + " 4/6 S");
			while(rs.next()) {
				int i = 1;
				EmpDto dto = new EmpDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
				emps.add(dto);
			}
			System.out.println(this.getClass() + " 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " 2/6 F " + e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass() + " 6/6 S");
		}
		
		return emps;		
	}
	
	
	public EmpDto getEmp(int employee_id){
		EmpDto emp = null;
		String sql =  "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, "
					+ "PHONE_NUMBER, HIRE_DATE, JOB_ID "
					+ "FROM EMPLOYEES WHERE EMPLOYEE_ID=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass() + " getemp 2/6 S");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  employee_id);
			System.out.println(this.getClass() + " getemp 3/6 S");
			rs=psmt.executeQuery();
			System.out.println(this.getClass() + " getemp 4/6 S");
			while(rs.next()) {
				int i = 1;
				emp = new EmpDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));				
			}
			System.out.println(this.getClass() + " 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " 2/6 F " + e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass() + " 6/6 S");
		}		
		return emp;		
	}
	
	
	public List<EmpDto> getEmpListV2(int employeeId){
		List<EmpDto> emps = new ArrayList<>();
		String sql =  "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, "
					+ "PHONE_NUMBER, HIRE_DATE, JOB_ID "
					+ "FROM EMPLOYEES WHERE MANAGER_ID=(SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE EMPLOYEE_ID=?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass() + " 2/6 S");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  employeeId);
			System.out.println(this.getClass() + " 3/6 S");
			rs=psmt.executeQuery();
			System.out.println(this.getClass() + " 4/6 S");
			while(rs.next()) {
				int i = 1;
				EmpDto dto = new EmpDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
				emps.add(dto);
			}
			System.out.println(this.getClass() + " 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " 2/6 F " + e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass() + " 6/6 S");
		}
		
		return emps;		
	}
	
	// 상사의 이름이 first_name인 부하직원들의 정보를 구하시오.	
	public List<EmpDto> getEmpListV3(String firstName){
		List<EmpDto> emps = new ArrayList<>();
		String sql =  "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, "
					+ "PHONE_NUMBER, HIRE_DATE, JOB_ID "
					+ "FROM EMPLOYEES WHERE MANAGER_ID IN (SELECT distinct EMPLOYEE_ID FROM EMPLOYEES WHERE FIRST_NAME=?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass() + " 2/6 S");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  firstName);
			System.out.println(this.getClass() + " 3/6 S");
			rs=psmt.executeQuery();
			System.out.println(this.getClass() + " 4/6 S");
			while(rs.next()) {
				int i = 1;
				EmpDto dto = new EmpDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
				emps.add(dto);
			}
			System.out.println(this.getClass() + " 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " 2/6 F " + e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass() + " 6/6 S");
		}
		
		return emps;		
	}
	
	public List<EmpDto> getEmpListV4(String firstName){
		List<EmpDto> emps = new ArrayList<>();
		String sql =  "SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME, e.EMAIL, "
					+ "e.PHONE_NUMBER, e. HIRE_DATE, e.JOB_ID "
					+ "FROM EMPLOYEES e, EMPLOYEES m WHERE e.MANAGER_ID=m.EMPLOYEE_ID AND m.FIRST_NAME=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass() + " 2/6 S");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  firstName);
			System.out.println(this.getClass() + " 3/6 S");
			rs=psmt.executeQuery();
			System.out.println(this.getClass() + " 4/6 S");
			while(rs.next()) {
				int i = 1;
				EmpDto dto = new EmpDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
				emps.add(dto);
			}
			System.out.println(this.getClass() + " 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " 2/6 F " + e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass() + " 6/6 S");
		}
		
		return emps;		
	}
	
	public List<EmpDto> getEmpListV6(String firstName){
		List<EmpDto> emps = new ArrayList<>();
		String sql =  "SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME, e.EMAIL, "
					+ "e.PHONE_NUMBER, e. HIRE_DATE, e.JOB_ID "
					+ "FROM EMPLOYEES e, EMPLOYEES m WHERE e.MANAGER_ID=m.EMPLOYEE_ID AND m.FIRST_NAME=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			System.out.println(this.getClass() + " 2/6 S");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  firstName);
			System.out.println(this.getClass() + " 3/6 S");
			rs=psmt.executeQuery();
			System.out.println(this.getClass() + " 4/6 S");
			while(rs.next()) {
				int i = 1;
				EmpDto dto = new EmpDto(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
				emps.add(dto);
			}
			System.out.println(this.getClass() + " 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass() + " 2/6 F " + e);
		} finally {
			this.close(conn, psmt, rs);
			System.out.println(this.getClass() + " 6/6 S");
		}
		
		return emps;		
	}
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Employee;

public class EmployeeImpl implements employeesDAO{
	public void save(Connection conn, Employee employee) throws SQLException {
		PreparedStatement st=(PreparedStatement) conn.prepareCall("insert into employees values(?,?,?,?,?,?)");
		st.setLong(1,employee.getId());
		st.setString(2,employee.getName());
		st.setString(3,employee.getJob_id());
		st.setInt(4,employee.getAge());
		st.setInt(5,employee.getDepartment_id());
		st.setInt(6,employee.getManager_id());
	    st.execute();
	}

	public void update(Connection conn, long id, Employee employee) throws SQLException{
		PreparedStatement st=(PreparedStatement) conn.prepareCall("update employees set name=?,job_id=?,age=?," +
				"department_id=?,manager_id=? where id=?");
		st.setLong(6,employee.getId());
		st.setString(1,employee.getName());
		st.setString(2,employee.getJob_id());
		st.setInt(3,employee.getAge());
		st.setInt(4,employee.getDepartment_id());
		st.setInt(5,employee.getManager_id());
	    st.execute();
	}

	public void delete(Connection conn, Employee employee) throws SQLException{
		PreparedStatement st=(PreparedStatement) conn.prepareCall("delete from employees where id=?");
		st.setLong(1,employee.getId());
	    st.execute();
	}

	
	public ResultSet get(Connection conn,Employee e) throws SQLException
	{
		ResultSet rs=null;
		PreparedStatement st=(PreparedStatement) conn.prepareCall("select * from employees where name=? and password=?");
		st.setString(1, e.getName());
		st.setInt(2, e.getPassword());
		rs=st.executeQuery();
		return rs;
	}
}

package com.river.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.river.dao.EmployeeDao;
import com.river.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertEmployee(Employee emp) {
		String sql = "INSERT INTO employee(empId, empName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEmpId(), emp.getEmpName()
		});
	}
	
	public void insertEmployees(final List<Employee> employees) {
		String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setString(1, employee.getEmpId());
				ps.setString(2, employee.getEmpName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});

	}
	
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM employee";
		
		  List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		  
		  List<Employee> result = new ArrayList<Employee>(); 
		  for(Map<String, Object>row:rows){ 
			  Employee emp = new Employee();
			  emp.setEmpId((String)row.get("empId"));
			  emp.setEmpName((String)row.get("empName")); 
			  result.add(emp); }
		  
		  return result;
		 
//		return getJdbcTemplate().query(sql, new EmployeeMapper());
	}

	public Employee getEmployeeById(String empId) {
		String sql = "SELECT * FROM employee WHERE empId = ?";
//		return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
//			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
//				Employee emp = new Employee();
//				emp.setEmpId(rs.getString("empId"));
//				emp.setEmpName(rs.getString("empName"));
//				return emp;
//			}
//		});
		return getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new EmployeeMapper());
	}
}


//implement Spring RowMapper.
class EmployeeMapper implements RowMapper {
	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    String empId = rs.getString(1);
	    String empName = rs.getString(2);
	    Employee emp = new Employee(empId, empName);
	    return emp;
	}
}
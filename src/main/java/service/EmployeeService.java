package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.EmployeeImpl;
import entity.Employee;
import util.ConnectionFactory;

public class EmployeeService {
         protected EmployeeImpl empDAO=new EmployeeImpl();
         
         public boolean check(Employee e)
         {	Connection conn=null;
        	 try {
			conn=ConnectionFactory.getFactory().getConn();
				conn.setAutoCommit(false);
				 ResultSet rs=empDAO.get(conn,e);
				 if (rs.next()){
					 return true;
				 }
			} catch (SQLException e1) {
				e1.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
        	 finally{
        		 try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        	 }
        	 return false;
         }
}

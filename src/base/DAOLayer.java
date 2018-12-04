package base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAOLayer {
	
	@Autowired
	private JdbcTemplate jt;
	
	private static Account acc;

	public Account getLoginInfo(int accno, int pwd) {
		
		System.out.println(jt != null ? "jdbc template got" :"not got");
		
		String sql="select * from account where accno = ? and pwd = ?";
		Object params[]= {accno, pwd};
		try 
		{
			acc = jt.queryForObject(sql, params, new BeanPropertyRowMapper<Account>(Account.class));
		} 
		catch (DataAccessException e1)
		{			
			System.out.println(e1);	
		}
		
		return acc;
	}

	public int getBal() {
		return acc.getBal();
	}

	public void setBal(int bal) {
		
		String sql="update account set bal = ? where accno = ?";
		String sql1="select * from account where accno = ? and pwd = ?";
		
		Object params[]= {bal, acc.getAccno()};
		Object params1[]= {acc.getAccno(), acc.getPwd()};
		
		try 
		{
			jt.update(sql, params);
			acc = jt.queryForObject(sql1, params1, new BeanPropertyRowMapper<Account>(Account.class));
		} 
		catch (DataAccessException e1)
		{			
			System.out.println(e1);	
		}
	}

}

package base;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan("base")
public class EntryPointForSpring 
{
	@Bean
	public JdbcTemplate get()
	{
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost/atmcasestudy");
		bds.setUsername("root");
		bds.setPassword("mypwd");
		JdbcTemplate jt =new JdbcTemplate(bds);
		return jt;
	}
}

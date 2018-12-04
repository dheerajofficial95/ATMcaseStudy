package base;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private DAOLayer  daoLayer;
	
	public Account getLoginInfo(int accno, int pwd) 
	{	
		return daoLayer.getLoginInfo(accno, pwd);
	}

	public int getBal() 
	{
		return daoLayer.getBal();
	}

	public void setBal(int bal) 
	{
		daoLayer.setBal(bal);
		
	}

	

}

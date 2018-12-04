package base;

public class Account 
{
	public Account() {
		
	}

	private int accno;
	private int pwd;
	private int bal;
	
	public Account(int accno, int pwd, int bal) {
		this.accno = accno;
		this.pwd = pwd;
		this.bal = bal;
	}
	
	public int getAccno() {
		return accno;
	}
	
	public void setAccno(int accno) {
		this.accno = accno;
	}
	
	public int getPwd() {
		return pwd;
	}
	
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	
	public int getBal() {
		return bal;
	}
	
	public void setBal(int bal) {
		this.bal = bal;
	}
}

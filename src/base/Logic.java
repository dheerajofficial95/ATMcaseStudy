package base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Logic {
	
	private AnnotationConfigApplicationContext context;
	private Service service;
	
	public Logic() {
		context = new AnnotationConfigApplicationContext(EntryPointForSpring.class);
		service = context.getBean(Service.class);
	}

	public String getDoLogin(HttpServletRequest request) {
		
		String pageName = "/login.jsp";
		
		int accno = Integer.parseInt(request.getParameter("accno"));
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		
		HttpSession session = request.getSession();
	
		Account acc = service.getLoginInfo(accno, pwd);
		
		if(acc != null)
		{
				session.setAttribute("user", acc.getAccno());
				pageName = "/WEB-INF/menu.jsp";
		}
		else
		{
			request.setAttribute("message", "Invalid account or password !!");	
		}
		
		System.out.println("employee details should be got");
		
		return pageName ;
		
	}

	public String getBalance(HttpServletRequest request) {
		int bal = service.getBal();
		request.setAttribute("bal", bal);
		return "/WEB-INF/menu.jsp";
	}

	public String getWithdraw(HttpServletRequest request) {
		
		int amount = Integer.parseInt(request.getParameter("amount"));
		if (amount > service.getBal())
		{
			request.setAttribute("result", "Low Balance !!");
		}
		else
		{
			int bal = service.getBal() - amount;
			service.setBal(bal);
			request.setAttribute("result", "Withdraw Successful !!");
			
		}
		return "/WEB-INF/menu.jsp";
	}

	public String getdeposit(HttpServletRequest request) {
		int amount = Integer.parseInt(request.getParameter("amount"));
		int bal = service.getBal() + amount;
		service.setBal(bal);
		request.setAttribute("deposit", "Deposit Successful !!");
		return "/WEB-INF/menu.jsp";
	}

}

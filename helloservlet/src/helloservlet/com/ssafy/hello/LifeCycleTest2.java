package helloservlet.com.ssafy.hello;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleTest
 */
@WebServlet("/LifeCycleTest")
public class LifeCycleTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleTest2() {
        super();
        System.out.println("��ü �����մϴ�");
    }

    
  
    
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("��ü�� �����մϴ�.");
	}




	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("��ü �ʱ�ȭ �մϴ�.");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}

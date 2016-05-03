package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import service.CoreService;
import service.CoreService;
import util.SignUtil;
public class CoreServlet extends HttpServlet {
	//private static final long serialVersionUID = 4440739483644821986L;  
	/**
	 * Constructor of the object.
	 */
	
	public CoreServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String signature = request.getParameter("signature");  
        // ʱ���  
        String timestamp = request.getParameter("timestamp");  
        // �����  
        String nonce = request.getParameter("nonce");  
        // ����ַ���  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;  
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    request.setCharacterEncoding("UTF-8");  
	        response.setCharacterEncoding("UTF-8");  
	        String respMessage = CoreService.processRequest(request);  
	        PrintWriter out = response.getWriter();  
	        out.print(respMessage);  
	        out.close();  
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

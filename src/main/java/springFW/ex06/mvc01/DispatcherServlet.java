package springFw.ex06.mvc01;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	public void init() throws ServletException {
		
		String configFile = getInitParameter("configFile");
		String configFilePath = getServletContext().getRealPath(configFile);
		System.out.println(configFile);
		System.out.println(configFilePath);
		
		Properties prop = new Properties();
		
		try (FileReader inStream = new FileReader(configFilePath)) {
			prop.load(inStream);
		} catch (IOException e) {
			throw new ServletException(e);
		}

		Iterator<?> keys = prop.keySet().iterator();
		while (keys.hasNext()) {

			String command = (String) keys.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				
				commandHandlerMap.put(command, handlerInstance);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processServlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processServlet(request, response);
	}

	protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getRequestURI();

		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		
		CommandHandler handler = commandHandlerMap.get(command);
		if (handler == null) {
			handler = new NullHandler();
		}

		String viewPage = null;
		try {
			viewPage = handler.process(request, response);
			
			if ((viewPage!=null)&&(viewPage.indexOf("redirect:")==0)) {
				viewPage=viewPage.substring(9);
				response.sendRedirect(request.getContextPath()+viewPage);
			}
		} catch (Throwable e) {
			throw new ServletException(e);
		}


		if (viewPage != null) {
			viewPage = "/WEB-INF/vies/mvc01/"+viewPage;
		} else {
			viewPage = "index.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(viewPage);
		disp.forward(request, response);
	}
}

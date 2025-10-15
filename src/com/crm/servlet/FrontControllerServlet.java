package com.crm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.action.ActionFactory;

@WebServlet("/controller")//1
public class FrontControllerServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		if (cmd == null || cmd.trim().length() == 0)
			cmd = "mainUI";

		Action action = ActionFactory.getAction(cmd);
		
		request.setAttribute("response", response);

		String url = action.execute(request);
		if (url != null) {
            request.getRequestDispatcher("/" + url).forward(request, response);
        }
	}

}

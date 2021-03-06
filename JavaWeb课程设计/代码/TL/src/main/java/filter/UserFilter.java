package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "*.jsp")
public class UserFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if(session.getAttribute("User") != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(servletRequest,servletResponse);
        }
    }

    public void destroy() {

    }
}

package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet {
  private final AccountService accountService;

  public SignInServlet(AccountService accountService){
    this.accountService = accountService;
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response){
    String login = request.getParameter("login");
    String pass = request.getParameter("password");

    if (login == null || pass == null){
      response.setContentType("text/html;charset=utf-8");
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    UserProfile profile = accountService.getUserByName(login);
    if (profile == null || !profile.getPass().equals(pass)){
      response.setContentType("text/html;charset=utf-8");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    accountService.addSession(request.getSession().getId(), profile);
    response.setContentType("text/html;charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
  }
}

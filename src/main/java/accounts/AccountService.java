package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
  private final Map<String, UserProfile> loginToProfile;
  private final Map<String, UserProfile> sessionToProfile;

  public AccountService(){
    loginToProfile = new HashMap<>();
    sessionToProfile = new HashMap<>();
  }

  public void addUser(UserProfile userProfile){
    loginToProfile.put(userProfile.getLogin(), userProfile);
  }

  public void addSession(String sessionId, UserProfile userProfile){
    sessionToProfile.put(sessionId, userProfile);
  }

  public UserProfile getUserByName(String login){
    return loginToProfile.get(login);
  }

  public UserProfile getUserBySession(String sessionId){
    return sessionToProfile.get(sessionId);
  }

  public void deleteSession(String sessionId){
    sessionToProfile.remove(sessionId);
  }

}

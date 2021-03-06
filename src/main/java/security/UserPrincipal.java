package security;

import entity.User;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserPrincipal implements Principal {

  private String username;
  private List<String> roles = new ArrayList<>();

  /* Create a UserPrincipal, given the Entity class User*/

    /**
     *
     * @param user
     */

  public UserPrincipal(User user) {
    this.username = user.getUserName();
    this.roles = user.getRolesAsStrings();
  }

    /**
     *
     * @param username
     * @param roles
     */
    public UserPrincipal(String username, String... roles) {
    super();
    this.username = username;
    this.roles = Arrays.asList(roles);
  }

  @Override
  public String getName() {
    return username;
  }

    /**
     *
     * @param role
     * @return
     */
    public boolean isUserInRole(String role) {
    return this.roles.contains(role);
  }
}

package libraryapp.entity;

import java.util.prefs.Preferences;

public enum Role {


 USER ("user"),
 ADMIN ("admin");

 private String role;
 Role(String role) {
  this.role = role;
 }

 public String getName() {
  return role;
 }

}

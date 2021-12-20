public class newMember {
String firstName;
String lastName;
String email;
String loginId;
String password;

newMember(String fName, String lName, String email, String loginId, String pass){
  this.firstName = fName;
  this.lastName = lName;
  this.email = email;
  this.loginId = loginId;
  this.password = pass;

}

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getLoginId() {
      return loginId;
   }

   public String getPassword() {
      return password;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setLoginId(String loginId) {
      this.loginId = loginId;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}

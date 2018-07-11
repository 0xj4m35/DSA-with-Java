public class Password {
    
    private String value;
    private String role;

    public Password() {
    }

    public Password(String value, String role) {
        this.value = value;
        this.role = role;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
           
    public boolean isValid() {
        char [] c = value.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                return true;
            }
        }
        return false;
    }
}

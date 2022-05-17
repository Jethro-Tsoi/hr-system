interface Verification {
    boolean verify(int id, String password);
    boolean changePassword(int id, String oldPassword, String newPassword);
    boolean newEntry(int id, String password);
    boolean removeEntry(int id);
    
    public static boolean requirement(String password) {
        if (password.length() > 8) {
            return true;
        }
        return false;
    }
}
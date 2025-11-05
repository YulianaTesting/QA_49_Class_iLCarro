package utils.enums;

public enum HeaderMenuItem {
   /* SEARCH("//a[@href='/search']"),
    LET_THE_CAR_WORK("//a[@href='/let-car-work']"),
    TERMS_OF_USE("//a[@href='/terms-of-use']"),
    SIGN_UP("//a[@href='/registration?url=%2Fsearch']"),
    LOGIN_IN("//a[@href='/login?url=%2Fsearch']"); */

    SEARCH("//a[@id ='0']"),
    LET_THE_CAR_WORK("//a[@id ='1']"),
    TERMS_OF_USE("//a[@id ='2']"),
    SIGNUP(" //a[text() = ' Sign up ']"),
    LOGIN(" //a[text() = ' Log in ']"),
    LOGOUT("//a[text() =' Logout ']"),
    DELETE_ACCOUNT("//a[text() ='Delete account']");

     private final String locator;
    HeaderMenuItem(String locator){
        this.locator = locator;
    }

    public String getLocator(){
        return locator;
    }

}

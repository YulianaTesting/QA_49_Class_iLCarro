package utils;

public enum HeaderMenuItem {
    SEARCH("//a[@href='/search']"),
    LET_THE_CAR_WORK("//a[@href='/let-car-work']"),
    TERMS_OF_USE("//a[@href='/terms-of-use']"),
    SIGN_UP("//a[@href='/registration?url=%2Fsearch']"),
    LOGIN_IN("//a[@href='/login?url=%2Fsearch']");

     private final String locator;
    HeaderMenuItem(String locator){
        this.locator = locator;
    }

    public String getLocator(){
        return locator;
    }

}

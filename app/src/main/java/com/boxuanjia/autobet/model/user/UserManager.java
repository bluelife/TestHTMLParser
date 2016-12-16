package com.boxuanjia.autobet.model.user;

/**
 * Created by slomka.jin on 2016/11/24.
 */

public class UserManager {
    private static UserManager userManager;
    private AccountInfo accountInfo;
    private String id;
    private UserManager(){

    }
    public static UserManager instance(){
        if(null==userManager)
            userManager=new UserManager();
        return userManager;
    }
    public void setAccountInfo(AccountInfo info){
        accountInfo=info;
    }
    public AccountInfo getAccountInfo(){
        return accountInfo;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
}

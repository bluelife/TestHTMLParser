
package com.boxuanjia.autobet.model.userinfo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("Balance")
    @Expose
    private Float balance;
    @SerializedName("Bonuses")
    @Expose
    private List<String> bonuses = new ArrayList<String>();
    @SerializedName("CasinoBalance")
    @Expose
    private Float casinoBalance;
    @SerializedName("CasinoBonusBalance")
    @Expose
    private Float casinoBonusBalance;
    @SerializedName("CasinoRealBalance")
    @Expose
    private Float casinoRealBalance;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("CurrencyId")
    @Expose
    private Integer currencyId;
    @SerializedName("CurrencyName")
    @Expose
    private String currencyName;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("LastName")
    @Expose
    private String lastName;

    /**
     * 
     * @return
     *     The balance
     */
    public Float getBalance() {
        return balance;
    }

    /**
     * 
     * @param balance
     *     The Balance
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /**
     * 
     * @return
     *     The bonuses
     */
    public List<String> getBonuses() {
        return bonuses;
    }

    /**
     * 
     * @param bonuses
     *     The Bonuses
     */
    public void setBonuses(List<String> bonuses) {
        this.bonuses = bonuses;
    }

    /**
     * 
     * @return
     *     The casinoBalance
     */
    public Float getCasinoBalance() {
        return casinoBalance;
    }

    /**
     * 
     * @param casinoBalance
     *     The CasinoBalance
     */
    public void setCasinoBalance(Float casinoBalance) {
        this.casinoBalance = casinoBalance;
    }

    /**
     * 
     * @return
     *     The casinoBonusBalance
     */
    public Float getCasinoBonusBalance() {
        return casinoBonusBalance;
    }

    /**
     * 
     * @param casinoBonusBalance
     *     The CasinoBonusBalance
     */
    public void setCasinoBonusBalance(Float casinoBonusBalance) {
        this.casinoBonusBalance = casinoBonusBalance;
    }

    /**
     * 
     * @return
     *     The casinoRealBalance
     */
    public Float getCasinoRealBalance() {
        return casinoRealBalance;
    }

    /**
     * 
     * @param casinoRealBalance
     *     The CasinoRealBalance
     */
    public void setCasinoRealBalance(Float casinoRealBalance) {
        this.casinoRealBalance = casinoRealBalance;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The Currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The currencyId
     */
    public Integer getCurrencyId() {
        return currencyId;
    }

    /**
     * 
     * @param currencyId
     *     The CurrencyId
     */
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * 
     * @return
     *     The currencyName
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * 
     * @param currencyName
     *     The CurrencyName
     */
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The FirstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The iD
     */
    public Integer getID() {
        return iD;
    }

    /**
     * 
     * @param iD
     *     The ID
     */
    public void setID(Integer iD) {
        this.iD = iD;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The LastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

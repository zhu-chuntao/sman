package com.hban.sman.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhuchuntao on 16-11-29.
 */

@Entity
public class Drug {

    private String drugName;
    private String drugCode;
    public String getDrugCode() {
        return this.drugCode;
    }
    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }
    public String getDrugName() {
        return this.drugName;
    }
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
    @Generated(hash = 1014606714)
    public Drug(String drugName, String drugCode) {
        this.drugName = drugName;
        this.drugCode = drugCode;
    }
    @Generated(hash = 90337038)
    public Drug() {
    }
}

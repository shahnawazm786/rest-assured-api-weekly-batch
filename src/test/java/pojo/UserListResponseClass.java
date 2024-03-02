package pojo;

import apispom.Supports;
import apispom.UserDetails;

public class UserListResponseClass {
    private  UserDetails data;
    private  Supports support;
    public UserDetails getData() {
        return data;
    }

    public void setData(UserDetails data) {
        this.data = data;
    }

    public Supports getSupport() {
        return support;
    }

    public void setSupport(Supports support) {
        this.support = support;
    }
}


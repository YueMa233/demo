package com.ma.mybatis.pojo;

import java.util.List;

public class UserCustom extends User {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "UserCustom{" +
                "ids=" + ids +
                '}';
    }
}

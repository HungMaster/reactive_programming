package com.it.hungvt.reactiveprogramming.model;

/**
 * Created by Administrator on 11/6/2017.
 */

public class AndroidOS {
    private String version;
    private String name;
    private String api;

    public AndroidOS() {
    }

    public AndroidOS(String version, String name, String api) {
        this.version = version;
        this.name = name;
        this.api = api;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getApi() {
        return api;
    }
}

package com.eandbsolutions.models;

import com.google.gson.JsonObject;

public class TestJson {
    private String requestId;
    private JsonObject stuff;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public JsonObject getStuff() {
        return stuff;
    }

    public void setStuff(JsonObject stuff) {
        this.stuff = stuff;
    }
}

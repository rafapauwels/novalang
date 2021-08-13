package com.pauwels.controller;

public class CompileResponse {
    private String data;

    public CompileResponse(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toJson() {
        return "{\"data\": \"" + data.trim()
                .replace("\"", "'")
                .replace("\n", "\\n")
                .replace("\\", "\\\\")+ "\"}";
    }
}

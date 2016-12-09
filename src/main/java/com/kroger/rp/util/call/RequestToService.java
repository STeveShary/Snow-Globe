package com.kroger.rp.util.call;

import java.util.HashMap;
import java.util.Map;

public class RequestToService {

    private String baseUrl;
    private String hostname;
    private String urlToApplication;
    private Map<String, String> params = new HashMap<>();
    private String path;
    private Map<String, String> query = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private String protocol;
    private boolean secure;
    private boolean xhr;
    private String body;
    private String urlToRp;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUrlToApplication() {
        return urlToApplication;
    }

    public void setUrlToApplication(String urlToApplication) {
        this.urlToApplication = urlToApplication;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isXhr() {
        return xhr;
    }

    public void setXhr(boolean xhr) {
        this.xhr = xhr;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrlToRp() {
        return urlToRp;
    }

    public void setUrlToRp(String urlToRp) {
        this.urlToRp = urlToRp;
    }
}

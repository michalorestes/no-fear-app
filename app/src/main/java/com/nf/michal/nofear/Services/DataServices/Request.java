package com.nf.michal.nofear.Services.DataServices;

import java.net.URL;
import java.util.Map;

public class Request {
    private Source source;
    private URL requestUrl;
    private String baseUrl;
    private Map<String, String> parameters;

    public static enum Source {
        challenges, profile,
    }

    public Request(){
        this.baseUrl = "http://52.91.168.7:3000/";
    }

    public Request(Source source, Map<String, String> parameters) throws Exception {
        this.source = source;
        this.parameters = parameters;
        this.baseUrl = "http://52.91.168.7:3000/";
        this.requestUrl = buildRequestUrl();
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public URL getRequestUrl() {
        return this.requestUrl;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public void setParameters(Map<String, String> filters) {
        this.parameters = filters;
    }

    public void createRequest(Map<String, String> parameters) throws Exception {
        this.parameters = parameters;
        if (this.source != null) {
            this.requestUrl = buildRequestUrl();
        } else {
            throw new Exception("Request source is missing");
        }
    }

    private URL buildRequestUrl() throws Exception {
        String url = this.baseUrl + this.source;
        switch (this.source) {
            case profile:
                break;
            case challenges:
                //TODO: Implement building parameters in to URLS
                break;
        }

        return new URL(url);
    }
}

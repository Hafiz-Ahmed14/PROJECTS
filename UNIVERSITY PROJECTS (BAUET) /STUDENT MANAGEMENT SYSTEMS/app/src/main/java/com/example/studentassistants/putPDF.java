package com.example.studentassistants;

public class putPDF {
    public String filename;
    public String url;

    public putPDF() {

    }

    public putPDF(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

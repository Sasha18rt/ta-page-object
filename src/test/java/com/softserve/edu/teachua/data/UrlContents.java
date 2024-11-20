package com.softserve.edu.teachua.data;

public enum UrlContents {

    DEFOULT("JMAF_pSOBws","https://www.youtube.com/watch?v=JMAF_pSOBws"),
    WEBINAR_IFRAME("JMAF_pSOBws","https://www.youtube.com/watch?v=JMAF_pSOBws"),
    WEBINAR2_IFRAME("9C3CVLp-g9s","https://www.youtube.com/watch?v=9C3CVLp-g9s");

    private String searchVideo;
    private String fullURL;

    private UrlContents(String searchVideo, String fullURL) {
        this.searchVideo = searchVideo;
        this.fullURL = fullURL;
    }

    public String getSearchVideo() {return searchVideo;}

    public String getFullURL() {return fullURL;}

    @Override
    public String toString() {
        return "SearchVideo: " + searchVideo + ", FullURL: " + fullURL;
    }

}

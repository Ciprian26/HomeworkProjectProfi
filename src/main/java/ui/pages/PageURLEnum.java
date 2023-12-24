package ui.pages;

public enum PageURLEnum {
    PROFIT_PAGE("https://profit.com/"),
    TEMPORARY_EMAIL_PAGE("https://internxt.com/temporary-email");

    private final String url;

    PageURLEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

package cn.jju.library.entity;

public class PublishingForm{
    private String isbn;
    private String pubname;
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPubname(String pubname) {
        this.pubname = pubname;
    }

    public String getPubname() {
        return pubname;
    }
}

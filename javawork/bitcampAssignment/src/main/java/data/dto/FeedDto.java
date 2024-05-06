package data.dto;

import java.sql.Timestamp;

public class FeedDto {
    private int num;
    private String title;
    private Timestamp writetime;
    private String feedphoto;
    private String tag;
    private String text;

    // 생성자
    public FeedDto() {}

    // Getter 및 Setter 메서드
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getWritetime() {
        return writetime;
    }

    public void setWritetime(Timestamp writetime) {
        this.writetime = writetime;
    }

    public String getFeedphoto() {
        return feedphoto;
    }

    public void setFeedphoto(String feedphoto) {
        this.feedphoto = feedphoto;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
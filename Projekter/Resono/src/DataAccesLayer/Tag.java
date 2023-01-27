package src.DataAccesLayer;

public class Tag {
    private Integer tagID;
    private String tagText, tagColor, tagStrokeColor;
    
    public Tag(Integer tagID, String tagText, String tagColor, String tagStrokeColor) {
        this.tagID = tagID;
        this.tagText = tagText;
        this.tagColor = tagColor;
        this.tagStrokeColor = tagStrokeColor;
    }

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    public String getTagStrokeColor() {
        return tagStrokeColor;
    }

    public void setTagStrokeColor(String tagStrokeColor) {
        this.tagStrokeColor = tagStrokeColor;
    }
}

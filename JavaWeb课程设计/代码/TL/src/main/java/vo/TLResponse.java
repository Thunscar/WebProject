package vo;

public class TLResponse {
    private String code;
    private String text;

    public TLResponse(String answer) {
        int textBeginIndex = answer.indexOf("\"text\":\"");
        int textLastIndex = answer.indexOf("\"}");
        this.text = answer.substring(textBeginIndex+8,textLastIndex);
        int codeBeginIndex = answer.indexOf("\"code\":");
        this.code = answer.substring(codeBeginIndex+7,textBeginIndex-1);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

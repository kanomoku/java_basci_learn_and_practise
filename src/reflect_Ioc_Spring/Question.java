package reflect_Ioc_Spring;

public class Question {
    private String title;
    private String answer;

    public Question() {
    }

    public Question(String title, String answer) {
        this.answer = answer;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String toString() {
        return "{" + title + "," + answer + "}";
    }

}

package main.Hibernate.Mappings;

public class List_Of_Hw_Questions {
    private int hw_number;
    private String question;

    public List_Of_Hw_Questions(int hw_number, String question) {
        this.hw_number = hw_number;
        this.question = question;
    }

    public int getHw_number() {
        return hw_number;
    }

    public void setHw_number(int hw_number) {
        this.hw_number = hw_number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

package main.Hibernate.Mappings;

public class Survey_Question {
    private String survey_id;
    private int score;
    private String question;

    public Survey_Question(String survey_id, int score, String question) {
        this.survey_id = survey_id;
        this.score = score;
        this.question = question;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

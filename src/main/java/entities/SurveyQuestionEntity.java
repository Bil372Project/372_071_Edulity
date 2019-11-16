package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SURVEY_QUESTION", schema = "TESTER", catalog = "")
public class SurveyQuestionEntity {
    private Long score;
    private String question;
    private String surveyId;

    @Basic
    @Column(name = "SCORE", nullable = true, precision = 0)
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Basic
    @Column(name = "QUESTION", nullable = true, length = 20)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyQuestionEntity that = (SurveyQuestionEntity) o;
        return Objects.equals(score, that.score) &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, question);
    }

    @Id
    @Column(name = "SURVEY_ID", nullable = false, length = 20)
    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }
}

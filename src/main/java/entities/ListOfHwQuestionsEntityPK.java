package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ListOfHwQuestionsEntityPK implements Serializable {
    private String question;
    private long hwNumber;

    @Column(name = "QUESTION", nullable = false, length = 50)
    @Id
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(name = "HW_NUMBER", nullable = false, precision = 0)
    @Id
    public long getHwNumber() {
        return hwNumber;
    }

    public void setHwNumber(long hwNumber) {
        this.hwNumber = hwNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfHwQuestionsEntityPK that = (ListOfHwQuestionsEntityPK) o;
        return hwNumber == that.hwNumber &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, hwNumber);
    }
}

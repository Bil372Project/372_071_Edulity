package Hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LIST_OF_HW_QUESTIONS", schema = "TESTER", catalog = "")
@IdClass(ListOfHwQuestionsEntityPK.class)
public class ListOfHwQuestionsEntity {
    private String question;
    private long hwNumber;

    @Id
    @Column(name = "QUESTION", nullable = false, length = 50)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Id
    @Column(name = "HW_NUMBER", nullable = false, precision = 0)
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
        ListOfHwQuestionsEntity that = (ListOfHwQuestionsEntity) o;
        return hwNumber == that.hwNumber &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, hwNumber);
    }
}

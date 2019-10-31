package Bil372.edulity.common;

public class Syllabus {

    private String semester;
    private String course_name;
    private String gradingInfo;
    private int hodEmployeeId;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getGradingInfo() {
        return gradingInfo;
    }

    public void setGradingInfo(String gradingInfo) {
        this.gradingInfo = gradingInfo;
    }

    public int getHodEmployeeId() {
        return hodEmployeeId;
    }

    public void setHodEmployeeId(int hodEmployeeId) {
        this.hodEmployeeId = hodEmployeeId;
    }
}

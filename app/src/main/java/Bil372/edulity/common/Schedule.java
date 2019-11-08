package Bil372.edulity.common;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Bil372.edulity.enums.CourseType;
import Bil372.edulity.enums.Day;

public class Schedule {

    private int id;
    private String section;

    public class CourseInfo implements View.OnClickListener{

        private Course course;
        private Day day;
        private String startTime;
        private String endTime;

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        @Override
        public void onClick(View view) {

        }
    }

    List<CourseInfo> courseInfos;

    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public void setCourseInfos(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }

    public Schedule(String section) {
        this.section = section;
        id = Utility.randomIdGenerator();
        //TODO: Get this info from database
        //This is for test
        courseInfos = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            for(int j = 0; j < 8; j++) { // 8 course per day
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setCourse(new Course("Course" + i, CourseType.MANDATORY, Utility.randomIdGenerator()));
                courseInfo.setDay(Day.valueOf(i-1));
                courseInfo.setStartTime(String.valueOf(j + 8) + ".30");
                courseInfo.setEndTime(String.valueOf((j + 9)) + ".20");
                courseInfos.add(courseInfo);
            }
        }

    }
}

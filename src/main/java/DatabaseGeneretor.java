import Queries.HibarnateSupporter;
import entities.*;

import java.sql.Time;

public class DatabaseGeneretor {

        public  DatabaseGeneretor(){

        }
        public void generator(){
                HibarnateSupporter supporter = new HibarnateSupporter();
                SchoolEntity schoolEntity = new SchoolEntity();
                schoolEntity.setName("TOBB");
                schoolEntity.setSchoolAddress("CANKAYA");
                schoolEntity.setSchoolType("Private");
                supporter.createObject(schoolEntity);

                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setEmployeeId("s145345346");
                employeeEntity.setName("Mert");
                employeeEntity.setSsn("ssn87343");
                employeeEntity.setSchoolName("TOBB");
                supporter.createObject(employeeEntity);

                TeachingStaffEntity teachingStaffEntity = new TeachingStaffEntity();
                teachingStaffEntity.setEmployeeId("s145345346");
                teachingStaffEntity.setOfficeNo("No5");
                teachingStaffEntity.setSchoolName("TOBB");
                teachingStaffEntity.setSpecialization("J5352");
                supporter.createObject(teachingStaffEntity);

                HeadOfDepartmentEntity headOfDepartmentEntity = new HeadOfDepartmentEntity();
                headOfDepartmentEntity.setSchoolName("TOBB");
                headOfDepartmentEntity.setEmployeeId("s145345346");
                supporter.createObject(headOfDepartmentEntity);

                ParentEntity parent = new ParentEntity();
                parent.setAddress("Etlik/Ankara");
                parent.setEmail("Mahmut@gmail.com");
                parent.setName("Mahmut");
                parent.setSsn("p25256");
                supporter.createObject(parent);

                SurveyEntity survey = new SurveyEntity();
                survey.setSchoolName("TOBB");
                survey.setHodEmployeeId("s145345346");
                survey.setParentSsn("p25256");
                survey.setSurveyId("sv1");
                supporter.createObject(survey);

                SurveyQuestionEntity survey_question = new SurveyQuestionEntity();
                survey_question.setQuestion("Donem nasıl?");
                survey_question.setScore(5L);
                survey_question.setSurveyId("sv1");
                supporter.createObject(survey_question);

                TeacherEntity teacherEntity = new TeacherEntity();
                teacherEntity.setEmployeeId("s145345346");
                teacherEntity.setHodEmployeeId("s145345346");
                teacherEntity.setSchoolName("TOBB");
                teacherEntity.setSurveyId("sv1");
                supporter.createObject(teacherEntity);

                ClazzEntity clazzEntity = new ClazzEntity();
                clazzEntity.setClassSize(25L);
                clazzEntity.setSchedule("scheduling.....");
                clazzEntity.setSchoolName("TOBB");
                clazzEntity.setSection(8L);
                supporter.createObject(clazzEntity);

                CourseEntity course = new CourseEntity();
                course.setCourseName("MAT");
                course.setGrade(8L);
                course.setTeacherEmployeeId("s145345346");
                course.setType("true");
                course.setSchoolName("TOBB");
                supporter.createObject(course);

                SyllabusEntity syllabusEntity = new SyllabusEntity();
                syllabusEntity.setCourseName("MAT");
                syllabusEntity.setGradingInfo(8L);
                syllabusEntity.setHodEmployeeId("s145345346");
                syllabusEntity.setSchoolName("TOBB");
                syllabusEntity.setSemester("FALL");
                supporter.createObject(syllabusEntity);

                SyllabusSubjectListEntity syllabusSubjectListEntity = new SyllabusSubjectListEntity();
                syllabusSubjectListEntity.setCourseName("MAT");
                syllabusSubjectListEntity.setSemester("FALL");
                syllabusSubjectListEntity.setSubject("Sınav duyurusu");
                supporter.createObject(syllabusSubjectListEntity);

                SyllabusExamDateEntity syllabusExamDateEntity = new SyllabusExamDateEntity();
                syllabusExamDateEntity.setCourseName("MAT");
                syllabusExamDateEntity.setSemester("FALL");
                syllabusExamDateEntity.setSubject(new Time(310819829));
                supporter.createObject(syllabusExamDateEntity);

                ScheduleEntity scheduleEntity = new ScheduleEntity();
                scheduleEntity.setScheduleId("S57362842");
                supporter.createObject(scheduleEntity);

                ScheduleConsistsOfEntity scheduleConsistsOfEntity = new ScheduleConsistsOfEntity();
                scheduleConsistsOfEntity.setCourseName("MAT");
                scheduleConsistsOfEntity.setEndDate(new Time(23542));
                scheduleConsistsOfEntity.setStartDate(new Time(265436));
                scheduleConsistsOfEntity.setGrade(8L);
                scheduleConsistsOfEntity.setScheduleId("S57362842");
                supporter.createObject(scheduleConsistsOfEntity);

                HomeworkEntity homeworkEntity = new HomeworkEntity();
                homeworkEntity.setDueDate(new Time(63456));
                homeworkEntity.setClassSection(8L);
                homeworkEntity.setHwNumber(4);
                homeworkEntity.setSchoolName("TOBB");
                supporter.createObject(homeworkEntity);

                ListOfHwQuestionsEntity listOfHwQuestionsEntity = new ListOfHwQuestionsEntity();
                listOfHwQuestionsEntity.setHwNumber(4);
                listOfHwQuestionsEntity.setQuestion("How many nodes have been seen on graph");
                supporter.createObject(listOfHwQuestionsEntity);

                AnnouncementEntity announcementEntity = new AnnouncementEntity();
                announcementEntity.setClassSection(8L);
                announcementEntity.setDueDate(new Time(35235));
                announcementEntity.setInfo("Please not being copied");
                announcementEntity.setSchoolName("TOBB");
                announcementEntity.setSubmitDate(new Time(23626));
                announcementEntity.setTeacherEmployeeId("s145345346");
                supporter.createObject(announcementEntity);

                DriverEntity driverEntity = new DriverEntity();
                driverEntity.setId("dr32");
                driverEntity.setPhoneNumber("05346346");
                driverEntity.setSsn("ssn5436");
                supporter.createObject(driverEntity);

                SchoolBusEntity schoolBusEntity= new SchoolBusEntity();
                schoolBusEntity.setCapacity(30L);
                schoolBusEntity.setDestination("ETLIK");
                schoolBusEntity.setDriverId("dr32");
                schoolBusEntity.setId(1);
                schoolBusEntity.setSchoolName("TOBB");
                schoolBusEntity.setLicensePlate("06sf235");
                supporter.createObject(schoolBusEntity);

                StudentEntity student = new StudentEntity();
                student.setClassSection(8L);
                student.setName("Murat");
                student.setNumberOfAbsent(6L);
                student.setParentSsn("p25256");
                student.setYear(2019L);
                student.setStudentId("st01");
                student.setSchoolBusId(1L);
                student.setSchoolName("TOBB");
                supporter.createObject(student);
                //Did not work at first trial,it must be removed or fixed in the future
                //ListOfAbsentDatesEntity listOfAbsentDatesEntity = new ListOfAbsentDatesEntity();
               // listOfAbsentDatesEntity.setAbsentDate(new Time(236262));
                //listOfAbsentDatesEntity.setSchoolName("TOBB");
                //listOfAbsentDatesEntity.setStudentId("st01");

                LunchEntity lunchEntity = new LunchEntity();
                lunchEntity.setDay(new Time(23425));
                lunchEntity.setSchoolName("TOBB");
                lunchEntity.setStudentId("st01");
                supporter.createObject(lunchEntity);
        }
}

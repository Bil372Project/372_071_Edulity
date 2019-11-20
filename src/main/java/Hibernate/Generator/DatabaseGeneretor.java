package Hibernate.Generator;

import Hibernate.Queries.ClazzQuery;
import Hibernate.Queries.HaveScheduleQuery;
import Hibernate.Queries.HomeworkQuery;
import Hibernate.Queries.ScheduleQuery;
import Hibernate.Queries.SchoolBusQuery;
import Hibernate.Queries.SchoolQuery;
import Hibernate.Queries.SurveyQuery;
import Hibernate.Queries.TeachingStaffQuery;
import Hibernate.Entities.*;
import Hibernate.Queries.*;

import java.sql.Time;
import java.util.ArrayList;

public class DatabaseGeneretor {

        public String[] school_list = {"TOBB", "Hacettepe", "ITU", "METU", "Atılım", "Stanford"};
        public String[] school_adrress = {"Ankara", "Ankara", "istanbul", "Ankara", "Ankara", "California"};
        public String[] school_type = {"Public", "Public", "Public", "Public", "Public", "Public", "Private"};
        public String[] employee_name = {"Mert", "Mustafa", "Onur", "Muhammed", "Tansel", "Buğra", "Oğuz"};
        public ArrayList<String> sid_list;
        public String[] specialization = {"Mat","Fen","İng","Türkce","Beden","Sosyal"};
        public String[] questions = {"Dönem puanı","Dersler nasıl olmalı","Öğrenciler nasıl?"};
        public String[] sections = {"A","B","C","D","E"};
        private int max_int;
        private int student_number;
        private int section_numbers;
        private int grade;
        private int numberOfSurvey;
        private int homework_number;
        private int numberOfDriver;
        public HibarnateSupporter supporter;
        public SchoolQuery schoolQuery; //NOT ADDED
        public EmployeeQuery employeeQuery;
        public TeacherQuery teacherQuery;
        public TeachingStaffQuery teachingStaffEntityQuery;
        public ParentQuery parentQuery;
        public SyllabusQuery syllabusQuery;
        public HeadOfDepartmentQuery headOfEmployeeQuery;
        public SurveyQuery surveyQuery;
        public CourseQuery courseQuery;
        public ScheduleQuery scheduleQuery;
        public ClazzQuery clazzQuery;
        public HaveScheduleQuery haveScheduleQuery;
        public HomeworkQuery homeworkQuery;
        public SchoolBusQuery schoolBusQuery;
        public StudentQuery studentQuery;   //isnot used for now

        public DatabaseGeneretor() {
                this("");
        }
        public DatabaseGeneretor(String name)
        {
                sid_list = new ArrayList<>();
                max_int = 1000000;
                student_number = 1000;
                section_numbers = 16;
                grade = 8;
                numberOfSurvey = 100;
                homework_number = 20;
                numberOfDriver = 20;
                supporter = new HibarnateSupporter();
                schoolQuery = new SchoolQuery();
                employeeQuery = new EmployeeQuery();
                teacherQuery = new TeacherQuery();
                teachingStaffEntityQuery = new TeachingStaffQuery();
                parentQuery = new ParentQuery();
                syllabusQuery = new SyllabusQuery();
                headOfEmployeeQuery = new HeadOfDepartmentQuery();
                surveyQuery = new SurveyQuery();
                courseQuery = new CourseQuery();
                scheduleQuery = new ScheduleQuery();
                clazzQuery = new ClazzQuery();
                haveScheduleQuery = new HaveScheduleQuery();
                homeworkQuery = new HomeworkQuery();
                schoolBusQuery = new SchoolBusQuery();
                studentQuery = new StudentQuery();
        }
        public void generator() {
                for (int i = 0; i < school_list.length; i++)  {

                        SchoolEntity schoolEntity = new SchoolEntity();
                        schoolEntity.setName(school_list[i]);
                        schoolEntity.setSchoolAddress(school_adrress[i]);
                        schoolEntity.setSchoolType(school_type[i]);
                        supporter.createObject(schoolEntity);
                }
                int N = 30;
                for (int i = 0; i < N; i++)  {
                        EmployeeEntity employeeEntity = new EmployeeEntity();
                        int sid = (int) (Math.random() * max_int);
                        employeeEntity.setEmployeeId("s" + sid);
                        employeeEntity.setName(employee_name[(int) (Math.random() * max_int) % employee_name.length]);
                        employeeEntity.setSsn("ssn" + (int) (Math.random() * max_int));
                        sid_list.add("s" + sid);
                        employeeEntity.setSchoolName(school_list[(int) (Math.random() * max_int) % school_list.length]);
                        supporter.createObject(employeeEntity);
                }

                for (int i = 0; i < sid_list.size(); i++)  {
                        TeachingStaffEntity teachingStaffEntity = new TeachingStaffEntity();
                        int rand = (int) (Math.random() * 100);
                        if (rand > 30) {
                                System.out.println(sid_list.get(i));
                                ArrayList<EmployeeEntity> teachingStaffEntityArrayList = (ArrayList) employeeQuery.makeQuery(sid_list.get(i), null, null, null);
                                teachingStaffEntity.setEmployeeId(sid_list.get(i));
                                teachingStaffEntity.setOfficeNo("No" + (int) (Math.random() * 100));
                                teachingStaffEntity.setSchoolName(teachingStaffEntityArrayList.get(0).getSchoolName());
                                teachingStaffEntity.setSpecialization(specialization[(int) (Math.random() * max_int) % specialization.length]);
                                supporter.createObject(teachingStaffEntity);
                        }
                }
                //TODO do it in the next
                for (int i = 0; i < school_list.length; i++)  {

                        for(int j = 0; j < specialization.length; j++)  {
                                HeadOfDepartmentEntity headOfDepartmentEntity = new HeadOfDepartmentEntity();
                                headOfDepartmentEntity.setSchoolName(school_list[i]);
                                ArrayList<TeachingStaffEntity> headOfDepartment = (ArrayList) teachingStaffEntityQuery.makeQuery(school_list[i], null, specialization[j], null);
                                if(headOfDepartment.size() != 0 ) {
                                        headOfDepartmentEntity.setEmployeeId(headOfDepartment.get(0).getEmployeeId());
                                        supporter.createObject(headOfDepartmentEntity);
                                }

                        }
                }
                for(int i = 0; i < student_number; i++)  {
                        ParentEntity parent = new ParentEntity();
                        parent.setAddress("Etlik/Ankara");//TODO fix it
                        parent.setEmail("Mahmut@gmail.com");//TODO fix it
                        parent.setName(employee_name[(int) (Math.random() * max_int) % employee_name.length]);
                        parent.setSsn("p"+ (int)(Math.random()*max_int));
                        supporter.createObject(parent);
                }

                for(int i = 0; i < numberOfSurvey; i++)  {
                        ArrayList<HeadOfDepartmentEntity> headOfDepartment =(ArrayList) headOfEmployeeQuery.makeQuery(school_list[((int)(Math.random()*max_int))%school_list.length],null);
                        ArrayList<ParentEntity> parentEntities = (ArrayList) parentQuery.makeQuery(null,null,null,null,null);
                        SurveyEntity survey = new SurveyEntity();
                        int rand = (int)(Math.random()*max_int);
                        survey.setSchoolName(headOfDepartment.get(rand % headOfDepartment.size()).getSchoolName());
                        survey.setHodEmployeeId(headOfDepartment.get(rand % headOfDepartment.size()).getEmployeeId());
                        survey.setParentSsn(parentEntities.get(rand%parentEntities.size()).getSsn());
                        survey.setSurveyId("sv"+(int) (Math.random() * max_int));
                        supporter.createObject(survey);
                }
                ArrayList<SurveyEntity> surveyList = (ArrayList) surveyQuery.makeQuery(null,null,null,null);

                for(int i = 0; i < surveyList.size(); i++)  {
                        SurveyQuestionEntity survey_question = new SurveyQuestionEntity();

                        survey_question.setQuestion(questions[(int)(Math.random()*max_int)%questions.length]);
                        survey_question.setScore((long)(Math.random()*6));
                        survey_question.setSurveyId(surveyList.get(i).getSurveyId());
                        supporter.createObject(survey_question);
                }
                ArrayList<TeachingStaffEntity> teachers = (ArrayList) teachingStaffEntityQuery.makeQuery(null,null,null,null);

                for(int i = 0; i < teachers.size(); i++)  {
                        TeacherEntity teacherEntity = new TeacherEntity();
                        teacherEntity.setEmployeeId(teachers.get(i).getEmployeeId());
                        ArrayList<HeadOfDepartmentEntity> headOfDepartmentEntities = (ArrayList) headOfEmployeeQuery.makeQuery(teachers.get(i).getSchoolName(),null);

                        for(int j = 0; j < headOfDepartmentEntities.size(); j++) {
                                ArrayList<TeachingStaffEntity> headOfDepartment =(ArrayList)teachingStaffEntityQuery.makeQuery(null,headOfDepartmentEntities.get(j).getEmployeeId(),null,null);
                                if(headOfDepartment.size() !=0 && headOfDepartment.get(0).getSpecialization().equals(teachers.get(i).getSpecialization())){
                                    ArrayList<SurveyEntity> surveyEntities= (ArrayList)surveyQuery.makeQuery(null,null,headOfDepartment.get(0).getEmployeeId(),null);
                                    if(surveyEntities.size() != 0) {
                                        teacherEntity.setHodEmployeeId(headOfDepartment.get(0).getEmployeeId());
                                        teacherEntity.setSchoolName(teachers.get(i).getSchoolName());
                                        teacherEntity.setSurveyId(surveyEntities.get(0).getSurveyId()); //TODO do it
                                        supporter.createObject(teacherEntity);
                                    }
                                }
                        }
                }

                for(int i = 0; i < school_list.length; i++)  {
                        for(int j = 0; j < section_numbers; j++)  {
                                ClazzEntity clazzEntity = new ClazzEntity();
                                clazzEntity.setClassSize((long) (Math.random() * 20) + 20);
                                clazzEntity.setSchedule("scheduling.....");
                                clazzEntity.setSchoolName(school_list[i]);
                                clazzEntity.setSection(j);
                                supporter.createObject(clazzEntity);
                        }
                }
                for(int i = 0; i < school_list.length; i++)  {
                        for(int j = 0; j < specialization.length; j++)  {
                                for(int k = 1; k <= 8; k++)  {
                                        ArrayList<TeacherEntity> teacher = (ArrayList) teacherQuery.makeQuery(school_list[i], null, null, null);
                                        int size = teacher.size();
                                        CourseEntity course = new CourseEntity();
                                        course.setCourseName(specialization[j]+ (int)(Math.random()*max_int));
                                        course.setGrade(k);//TODO:fix it
                                        course.setTeacherEmployeeId(teacher.get((int) (Math.random() * max_int) % size).getEmployeeId());
                                        course.setType("true");
                                        course.setSchoolName(school_list[i]);
                                        supporter.createObject(course);
                                }
                        }
                }
                for(int i = 0; i < school_list.length; i++)  {
                        ArrayList<CourseEntity> courseEntities = (ArrayList)courseQuery.makeQuery(null,null,null,null,school_list[i]);
                        for(int j = 0; j < courseEntities.size(); j++)  {
                                ArrayList<TeacherEntity> teacherEntity = (ArrayList)teacherQuery.makeQuery(null,courseEntities.get(i).getTeacherEmployeeId(),null,null);

                                SyllabusEntity syllabusEntity = new SyllabusEntity();
                                syllabusEntity.setCourseName(courseEntities.get(i).getCourseName());
                                syllabusEntity.setGradingInfo(courseEntities.get(i).getGrade());//TODO:fix it

                                syllabusEntity.setHodEmployeeId(teacherEntity.get(0).getHodEmployeeId());
                                syllabusEntity.setSchoolName(school_list[i]);

                                syllabusEntity.setSemester("FALL"+ (int)(Math.random()*10000));//TODO:fix it importantly
                                supporter.createObject(syllabusEntity);
                        }
                }
                ArrayList<SyllabusEntity> syllabusEntity= (ArrayList)syllabusQuery.makeQuery(null,null,null,null,null);

                for(int i = 0; i < syllabusEntity.size(); i++) {
                        SyllabusExamDateEntity syllabusExamDateEntity = new SyllabusExamDateEntity();

                        syllabusExamDateEntity.setCourseName(syllabusEntity.get(i).getCourseName());
                        syllabusExamDateEntity.setSemester(syllabusEntity.get(i).getSemester());
                        syllabusExamDateEntity.setSubject(new Time((long)(Math.random()*100000)));//TODO:fix it
                        supporter.createObject(syllabusExamDateEntity);
                }
                ArrayList<CourseEntity> courseEntities = (ArrayList)courseQuery.makeQuery(null,null,null,null,null);
                ArrayList<ClazzEntity> clazzEntities = (ArrayList) clazzQuery.makeQuery(null,null,null,null);
                int l = clazzEntities.size();
                for(int i = 0; i < l; i++)  {
                        ScheduleEntity scheduleEntity = new ScheduleEntity();
                        scheduleEntity.setScheduleId("sc"+(int)(Math.random()*max_int));
                        supporter.createObject(scheduleEntity);
                }
                ArrayList<ScheduleEntity> scheduleEntities = (ArrayList)scheduleQuery.makeQuery(null);

                for(int j = 0; j < l; j++)  {
                        HaveScheduleEntity haveScheduleEntity = new HaveScheduleEntity();
                        if (j < clazzEntities.size()){
                                haveScheduleEntity.setClassSection(clazzEntities.get(j).getSection());
                                haveScheduleEntity.setScheduleId(scheduleEntities.get(j).getScheduleId());
                                haveScheduleEntity.setSchoolName(clazzEntities.get(j).getSchoolName());
                                supporter.createObject(haveScheduleEntity);
                        }
                }
                //TODO:this block should be improved so that generates schedule that does not overlapping with each other courses hours
                ArrayList<HaveScheduleEntity> haveScheduleEntities = (ArrayList)haveScheduleQuery.makeQuery(null,null,null);
                for(int i = 0; i < haveScheduleEntities.size(); i++)  {
                        ArrayList<HaveScheduleEntity> schedules = (ArrayList)haveScheduleQuery.makeQuery(null,haveScheduleEntities.get(i).getSchoolName(),null);
                        int rand = (int)(Math.random()*schedules.size());
                        ScheduleConsistsOfEntity scheduleConsistsOfEntity = new ScheduleConsistsOfEntity();
                        scheduleConsistsOfEntity.setCourseName(courseEntities.get(i).getCourseName());
                        scheduleConsistsOfEntity.setEndDate(new Time(23542));//TODO:fix it
                        scheduleConsistsOfEntity.setStartDate(new Time(265436));//TODO:fix it
                        scheduleConsistsOfEntity.setGrade(courseEntities.get(i).getGrade());
                        scheduleConsistsOfEntity.setScheduleId(haveScheduleEntities.get(rand).getScheduleId());
                        supporter.createObject(scheduleConsistsOfEntity);
                }

                for(int i = 0; i < homework_number; i++)  {
                        int rand = (int)(Math.random()*max_int);
                        HomeworkEntity homeworkEntity = new HomeworkEntity();
                        homeworkEntity.setDueDate(new Time(63456));
                        homeworkEntity.setClassSection(clazzEntities.get(rand % clazzEntities.size()).getSection());
                        homeworkEntity.setHwNumber((int)(Math.random()*max_int));
                        homeworkEntity.setSchoolName(clazzEntities.get(rand % clazzEntities.size()).getSchoolName());
                        supporter.createObject(homeworkEntity);
                }
                ArrayList<HomeworkEntity> homeworkEntities = (ArrayList)homeworkQuery.makeQuery(null,null,null,null,null);
                for(int i = 0; i < homework_number; i++)  {
                        ListOfHwQuestionsEntity listOfHwQuestionsEntity = new ListOfHwQuestionsEntity();
                        listOfHwQuestionsEntity.setHwNumber(homeworkEntities.get(i).getHwNumber());
                        listOfHwQuestionsEntity.setQuestion("How many nodes have been seen on graph");//TODO:fix it
                        supporter.createObject(listOfHwQuestionsEntity);
                }

                ArrayList<ClazzEntity> clazz = (ArrayList)clazzQuery.makeQuery(null,null,null,null);
                ArrayList<TeacherEntity> teacherEntities = (ArrayList)teacherQuery.makeQuery(clazz.get(0).getSchoolName(),null,null,null);

                AnnouncementEntity announcementEntity = new AnnouncementEntity();
                announcementEntity.setClassSection(clazz.get(0).getSection());
                announcementEntity.setDueDate(new Time(35235));
                announcementEntity.setInfo("Please not being copied");
                announcementEntity.setSchoolName(teacherEntities.get(0).getSchoolName());
                announcementEntity.setSubmitDate(new Time(45647));
                announcementEntity.setTeacherEmployeeId(teacherEntities.get(0).getEmployeeId());
                supporter.createObject(announcementEntity);
                for(int i = 0; i < numberOfDriver; i++) {
                        DriverEntity driverEntity = new DriverEntity();
                        driverEntity.setId("dr" + i);
                        driverEntity.setPhoneNumber("" + Math.random()*max_int);
                        driverEntity.setSsn("ssn" + i);
                        supporter.createObject(driverEntity);
                }
                for(int i = 0; i < numberOfDriver; i++)  {
                        SchoolBusEntity schoolBusEntity = new SchoolBusEntity();
                        schoolBusEntity.setCapacity((long)(Math.random()*30));
                        schoolBusEntity.setDestination("Ankara");
                        schoolBusEntity.setDriverId("dr"+i);
                        schoolBusEntity.setId(i);
                        schoolBusEntity.setSchoolName(school_list[(int)(Math.random()*school_list.length)]);
                        schoolBusEntity.setLicensePlate("06sf235");
                        supporter.createObject(schoolBusEntity);
                }
                ArrayList<ParentEntity> parentEntities = (ArrayList)parentQuery.makeQuery(null,null,null,null,null);
                for(int i = 0; i < student_number; i++)  {
                        int rand = (int)(Math.random()*parentEntities.size());
                        int class_sc =(int)(Math.random()*clazz.size());
                        StudentEntity student = new StudentEntity();
                        ArrayList<SchoolBusEntity> schoolBusEntities = (ArrayList)schoolBusQuery.makeQuery(null,null,null,null,null,clazz.get(class_sc).getSchoolName());
                        student.setClassSection(clazz.get(class_sc).getSection());
                        student.setName(employee_name[(int)(Math.random()*employee_name.length)]);
                        student.setNumberOfAbsent((long)(Math.random()*20));
                        student.setParentSsn(parentEntities.get(rand).getSsn());
                        student.setYear(2019L);
                        student.setStudentId("st"+i);
                        student.setSchoolBusId(schoolBusEntities.get((int)(Math.random()*schoolBusEntities.size())).getId());
                        student.setSchoolName(clazz.get(class_sc).getSchoolName());
                        supporter.createObject(student);
                }
                        //Did not work at first trial,it must be removed or fixed in the future
                /*

                       for(int i=0;i<studentEntities.size();i++) {
                           System.out.println("Schoolname"+studentEntities.get(i).getSchoolName());
                           System.out.println("Id:"+studentEntities.get(i).getStudentId());
                           ListOfAbsentDatesEntity listOfAbsentDatesEntity = new ListOfAbsentDatesEntity();
                           listOfAbsentDatesEntity.setAbsentDate(new Time((long)(Math.random()*max_int)));
                           listOfAbsentDatesEntity.setSchoolName(studentEntities.get(i).getSchoolName());
                           listOfAbsentDatesEntity.setStudentId(studentEntities.get(i).getStudentId());
                           supporter.createObject(listOfAbsentDatesEntity);
                       }
                       /
                 */
                /*
                       LunchEntity lunchEntity = new LunchEntity();
                       lunchEntity.setDay(new Time(23425));
                       lunchEntity.setSchoolName("TOBB");
                       lunchEntity.setStudentId("st01");
                       supporter.createObject(lunchEntity);
                */
                }
                public void resizeSizes()
                {
                        ArrayList<ClazzEntity> clazzEntities = (ArrayList) clazzQuery.makeQuery(null,null,null,null);
                        int l = clazzEntities.size();
                        for (long i = 0; i < l ; i++){
                                ArrayList<StudentEntity> studentEntities = (ArrayList) studentQuery.makeQuery(null,null,null,null,null,null,null,i,null,null);
                                if( clazzEntities.get((int)i).getClassSize() != studentEntities.size())
                                        clazzEntities.get((int)i).setClassSize((long)studentEntities.size());
                        }
                }
        }

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

import java.sql.Date;
import java.util.ArrayList;

public class DatabaseGeneretor {

        public String[] school_list = {"TOBB", "Hacettepe", "ITU", "METU", "Atılım", "Stanford"};
        public String[] school_adrress = {"Ankara", "Ankara", "istanbul", "Ankara", "Ankara", "California"};
        public String[] school_type = {"Public", "Public", "Public", "Public", "Public", "Public", "Private"};
        public String[] employee_name = {"Mert", "Mustafa", "Onur", "Muhammed", "Tansel", "Buğra", "Oğuz"};
        public ArrayList<String> sid_list = new ArrayList<>();
        public String[] specialization = {"Mat","Fen","İng","Türkce","Beden","Sosyal"};
        public String[] questions = {"Dönem puanı","Dersler nasıl olmalı","Öğrenciler nasıl?"};
        public String[] start_date = {"Monday=08.30","Monday=10:30","Monday=12:30","Monday=14:30","Monday=16:30",
                                      "Tuesday=08.30","Tuesday=10:30","Tuesday=12:30","Tuesday=14:30","Tuesday=16:30",
                                      "Wednesday=08.30","Wednesday=10:30","Wednesday=12:30","Wednesday=14:30","Wednesday=16:30",
                                      "Thursday=08.30","Thursday=10:30","Thursday=12:30","Thursday=14:30","Thursday=16:30",
                                      "Friday=08.30","Friday=10:30","Friday=12:30","Friday=14:30","Friday=16:30",
        };
        public String[] finish_date = {"Monday=10.30","Monday=12:30","Monday=14:30","Monday=16:30","Monday=18:30",
                "Tuesday=10.30","Tuesday=12:30","Tuesday=14:30","Tuesday=16:30","Tuesday=18:30",
                "Wednesday=10.30","Wednesday=12:30","Wednesday=14:30","Wednesday=16:30","Wednesday=18:30",
                "Thursday=10.30","Thursday=12:30","Thursday=14:30","Thursday=16:30","Thursday=18:30",
                "Friday=10.30","Friday=12:30","Friday=14:30","Friday=16:30","Friday=18:30",
        };
        public String[] sections = {"A","B","C","D","E"};
        int max_int = 1000000;
        int student_number = 1000;
        int section_numbers = 16;
        int grade = 8;
        int numberOfSurvey = 500;
        int homework_number = 20;
        int numberOfDriver = 20;
        int employee_size = 300;
        public HibernateSupporter supporter = new HibernateSupporter();
        public SchoolQuery schoolQuery = new SchoolQuery();
        public EmployeeQuery employeeQuery = new EmployeeQuery();
        public TeacherQuery teacherQuery = new TeacherQuery();
        public TeachingStaffQuery teachingStaffEntityQuery = new TeachingStaffQuery();
        public ParentQuery parentQuery = new ParentQuery();
        public ScheduleConsistsOfQuery scheduleConsistsOfQuery = new ScheduleConsistsOfQuery();
        public SyllabusQuery syllabusQuery = new SyllabusQuery();
        public HeadOfDepartmentQuery headOfEmployeeQuery = new HeadOfDepartmentQuery();
        public SurveyQuery surveyQuery = new SurveyQuery();
        public CourseQuery courseQuery = new CourseQuery();
        public ScheduleQuery scheduleQuery = new ScheduleQuery();
        public ClazzQuery clazzQuery = new ClazzQuery();
        public HaveScheduleQuery haveScheduleQuery = new HaveScheduleQuery();
        public HomeworkQuery homeworkQuery = new HomeworkQuery();
        public SchoolBusQuery schoolBusQuery = new SchoolBusQuery();
        public StudentQuery studentQuery = new StudentQuery();

        public DatabaseGeneretor() {

        }
        public void generator() {

                for (int i = 0; i < school_list.length; i++) {

                        SchoolEntity schoolEntity = new SchoolEntity();
                        schoolEntity.setName(school_list[i]);
                        schoolEntity.setSchoolAddress(school_adrress[i]);
                        schoolEntity.setSchoolType(school_type[i]);
                        supporter.createObject(schoolEntity);
                }

                for (int i = 0; i < school_list.length; i++) {
                        for(int j=0;j < employee_size;j++) {
                                EmployeeEntity employeeEntity = new EmployeeEntity();
                                int sid = i*employee_size+j;
                                employeeEntity.setEmployeeId("s" + sid);
                                employeeEntity.setName(employee_name[(int) (Math.random() * max_int) % employee_name.length]);
                                employeeEntity.setSsn("ssn" + i*employee_size+j);
                                sid_list.add("s" + sid);
                                employeeEntity.setSchoolName(school_list[i]);
                                supporter.createObject(employeeEntity);
                        }
                }
                int counter = 0;
                for (int i = 0; i < school_list.length; i++) {
                        for(int j=0;j < specialization.length;j++) {
                                for(int k =1;k <= 8;k++ ) {
                                        TeachingStaffEntity teachingStaffEntity = new TeachingStaffEntity();
                                        int rand = (int) (Math.random() * 100);

                                        ArrayList<EmployeeEntity> teachingStaffEntityArrayList = (ArrayList) employeeQuery.makeQuery(null, school_list[i], null, null);

                                        teachingStaffEntity.setEmployeeId(teachingStaffEntityArrayList.get(j*8+k).getEmployeeId());
                                        teachingStaffEntity.setOfficeNo("No" + (int) (Math.random() * 100));
                                        teachingStaffEntity.setSchoolName(school_list[i]);
                                        teachingStaffEntity.setSpecialization(specialization[j]);
                                        supporter.createObject(teachingStaffEntity);
                                        counter++;
                                }
                        }
                }
                //TODO do it in the next
                for (int i = 0; i < school_list.length; i++) {

                        for(int j=0;j < specialization.length;j++) {
                                HeadOfDepartmentEntity headOfDepartmentEntity = new HeadOfDepartmentEntity();
                                headOfDepartmentEntity.setSchoolName(school_list[i]);
                                ArrayList<TeachingStaffEntity> headOfDepartment = (ArrayList) teachingStaffEntityQuery.makeQuery(school_list[i], null, specialization[j], null);
                                if(headOfDepartment.size() != 0 ) {
                                        headOfDepartmentEntity.setEmployeeId(headOfDepartment.get(0).getEmployeeId());
                                        supporter.createObject(headOfDepartmentEntity);
                                }

                        }
                }
                for(int i = 0;i < student_number;i++) {
                        ParentEntity parent = new ParentEntity();
                        parent.setAddress("Etlik/Ankara");//TODO fix it
                        parent.setEmail("Mahmut@gmail.com");//TODO fix it
                        parent.setName(employee_name[(int) (Math.random() * max_int) % employee_name.length]);
                        parent.setSsn("p"+ i);
                        supporter.createObject(parent);
                }

                for(int i=0;i<numberOfSurvey;i++) {
                        ArrayList<HeadOfDepartmentEntity> headOfDepartment =(ArrayList) headOfEmployeeQuery.makeQuery(school_list[((int)(Math.random()*max_int))%school_list.length],null);
                        ArrayList<ParentEntity> parentEntities = (ArrayList) parentQuery.makeQuery(null,null,null,null,null);
                        SurveyEntity survey = new SurveyEntity();
                        int rand = (int)(Math.random()*max_int);
                        survey.setSchoolName(headOfDepartment.get(rand % headOfDepartment.size()).getSchoolName());
                        survey.setHodEmployeeId(headOfDepartment.get(rand % headOfDepartment.size()).getEmployeeId());
                        survey.setParentSsn(parentEntities.get(rand%parentEntities.size()).getSsn());
                        survey.setSurveyId("sv"+i);
                        supporter.createObject(survey);
                }
                ArrayList<SurveyEntity> surveyList = (ArrayList) surveyQuery.makeQuery(null,null,null,null);

                for(int i=0;i<surveyList.size();i++) {
                        SurveyQuestionEntity survey_question = new SurveyQuestionEntity();

                        survey_question.setQuestion(questions[(int)(Math.random()*max_int)%questions.length]);
                        survey_question.setScore((long)(Math.random()*6));
                        survey_question.setSurveyId(surveyList.get(i).getSurveyId());
                        supporter.createObject(survey_question);
                }
                ArrayList<TeachingStaffEntity> teachers = (ArrayList) teachingStaffEntityQuery.makeQuery(null,null,null,null);
                int counts = 0;
                for(int i=0;i<teachers.size();i++) {
                        TeacherEntity teacherEntity = new TeacherEntity();
                        teacherEntity.setEmployeeId(teachers.get(i).getEmployeeId());
                        ArrayList<HeadOfDepartmentEntity> headOfDepartmentEntities = (ArrayList) headOfEmployeeQuery.makeQuery(teachers.get(i).getSchoolName(),null);

                        for(int j=0;j<headOfDepartmentEntities.size();j++){
                                ArrayList<TeachingStaffEntity> headOfDepartment =(ArrayList)teachingStaffEntityQuery.makeQuery(null,headOfDepartmentEntities.get(j).getEmployeeId(),null,null);

                                if(headOfDepartment.get(0).getSpecialization().equals(teachers.get(i).getSpecialization())){

                                        ArrayList<SurveyEntity> surveyEntities= (ArrayList)surveyQuery.makeQuery(null,null,headOfDepartment.get(0).getEmployeeId(),null);
                                        if(surveyEntities.size() != 0) {
                                                teacherEntity.setHodEmployeeId(headOfDepartment.get(0).getEmployeeId());
                                                teacherEntity.setSchoolName(teachers.get(i).getSchoolName());
                                                teacherEntity.setSurveyId(surveyEntities.get(0).getSurveyId()); //TODO do it
                                                supporter.createObject(teacherEntity);
                                                counts++;
                                        }
                                }
                        }

                }
                System.out.println("Count"+counts);
                for(int i=0;i<school_list.length;i++) {
                        for(int j =0;j<section_numbers;j++) {
                                String scheduleId = "sc"+(int)(Math.random()*max_int);
                                ScheduleEntity scheduleEntity = new ScheduleEntity();
                                scheduleEntity.setScheduleId(scheduleId);
                                supporter.createObject(scheduleEntity);
                                ClazzEntity clazzEntity = new ClazzEntity();
                                clazzEntity.setClassSize((long) (Math.random() * 20) + 20);
                                clazzEntity.setSchedule(scheduleId);
                                clazzEntity.setSchoolName(school_list[i]);
                                clazzEntity.setSection(j);
                                supporter.createObject(clazzEntity);
                        }
                }
                int count = 0;
                for(int i=0;i<school_list.length;i++) {
                        for(int j=0;j<specialization.length;j++) {
                                for(int k=1;k<=8;k++) {
                                        ArrayList<TeachingStaffEntity> teacher = (ArrayList) teachingStaffEntityQuery.makeQuery(school_list[i], null, specialization[j], null);
                                        int size = teacher.size();
                                        CourseEntity course = new CourseEntity();
                                        course.setCourseName(specialization[j]+ count);
                                        course.setGrade(k);//TODO:fix it
                                        course.setTeacherEmployeeId(teacher.get(k-1).getEmployeeId());
                                        course.setType("true");
                                        course.setSchoolName(school_list[i]);
                                        System.out.println(specialization[j]+ count);
                                        System.out.println("EmployeeId:"+teacher.get(k-1).getEmployeeId());
                                        supporter.createObject(course);
                                        count++;
                                }
                        }
                }
                for(int i=0;i<school_list.length;i++) {
                        ArrayList<CourseEntity> courseEntities = (ArrayList)courseQuery.makeQuery(null,null,null,null,school_list[i]);
                        for(int j=0;j<courseEntities.size();j++) {
                                ArrayList<TeacherEntity> teacherEntity = (ArrayList)teacherQuery.makeQuery(null,courseEntities.get(i).getTeacherEmployeeId(),null,null);

                                SyllabusEntity syllabusEntity = new SyllabusEntity();
                                syllabusEntity.setCourseName(courseEntities.get(j).getCourseName());
                                syllabusEntity.setGradingInfo(courseEntities.get(j).getGrade());//TODO:fix it

                                syllabusEntity.setHodEmployeeId(teacherEntity.get(0).getHodEmployeeId());
                                syllabusEntity.setSchoolName(school_list[i]);

                                syllabusEntity.setSemester("FALL");//TODO:fix it important
                                supporter.createObject(syllabusEntity);
                        }
                }
                ArrayList<SyllabusEntity> syllabusEntity= (ArrayList)syllabusQuery.makeQuery(null,null,null,null,null);
        /*
                for(int i=0;i<syllabusEntity.size();i++){
                        System.out.println("syllabusExamDateEntity:"+syllabusEntity.get(i).getCourseName());
                        System.out.println("syllabusExamDateEntity:"+syllabusEntity.get(i).getSemester());
                        SyllabusExamDateEntity syllabusExamDateEntity = new SyllabusExamDateEntity();
                        syllabusExamDateEntity.setCourseName(syllabusEntity.get(i).getCourseName());
                        syllabusExamDateEntity.setSemester(syllabusEntity.get(i).getSemester());
                        syllabusExamDateEntity.setSubject(new Time(i));//TODO:fix it

                        supporter.createObject(syllabusExamDateEntity);
                }
          */
                ArrayList<ClazzEntity> clazzEntities = (ArrayList) clazzQuery.makeQuery(null,null,null,null);
                int l = clazzEntities.size();
                ArrayList<ScheduleEntity> scheduleEntities = (ArrayList)scheduleQuery.makeQuery(null);

                for(int j=0;j<l;j++) {
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
                for(int i=0;i<haveScheduleEntities.size();i++) {
                        ArrayList<ClazzEntity> clazzEntity = (ArrayList)clazzQuery.makeQuery(haveScheduleEntities.get(i).getSchoolName(),haveScheduleEntities.get(i).getClassSection(),null,null);

                        ArrayList<CourseEntity> courseEntities1 = (ArrayList)courseQuery.makeQuery(null,((long)(haveScheduleEntities.get(i).getClassSection()/2)+1),null,null,haveScheduleEntities.get(i).getSchoolName());
                        for(int j=0;j<courseEntities1.size();j++) {
                                for(int k =0;k<3;k++) {
                                        int m = (int)(j+(haveScheduleEntities.get(i).getClassSection()%2)+k*specialization.length);
                                        ScheduleConsistsOfEntity scheduleConsistsOfEntity = new ScheduleConsistsOfEntity();
                                        scheduleConsistsOfEntity.setCourseName(courseEntities1.get(j).getCourseName());
                                        scheduleConsistsOfEntity.setEndDate(finish_date[m]);
                                        scheduleConsistsOfEntity.setStartDate(start_date[m]);
                                        scheduleConsistsOfEntity.setGrade(courseEntities1.get(j).getGrade());
                                        scheduleConsistsOfEntity.setScheduleId(haveScheduleEntities.get(i).getScheduleId());
                                        supporter.createObject(scheduleConsistsOfEntity);
                                }
                        }

                }
                for(int i=0;i<homework_number;i++) {
                        int rand = (int)(Math.random()*max_int);
                        HomeworkEntity homeworkEntity = new HomeworkEntity();
                        homeworkEntity.setDueDate(Date.valueOf("2019-03-01"));
                        homeworkEntity.setClassSection(clazzEntities.get(rand % clazzEntities.size()).getSection());
                        homeworkEntity.setHwNumber((int)(Math.random()*max_int));
                        homeworkEntity.setSchoolName(clazzEntities.get(rand % clazzEntities.size()).getSchoolName());
                        supporter.createObject(homeworkEntity);
                }
                ArrayList<HomeworkEntity> homeworkEntities= (ArrayList)homeworkQuery.makeQuery(null,null,null,null,null);
                for(int i=0;i<homework_number;i++) {
                        ListOfHwQuestionsEntity listOfHwQuestionsEntity = new ListOfHwQuestionsEntity();
                        listOfHwQuestionsEntity.setHwNumber(homeworkEntities.get(i).getHwNumber());
                        listOfHwQuestionsEntity.setQuestion("How many nodes have been seen on graph");//TODO:fix it
                        supporter.createObject(listOfHwQuestionsEntity);
                }

                ArrayList<ClazzEntity> clazz = (ArrayList)clazzQuery.makeQuery(null,null,null,null);
                ArrayList<TeacherEntity> teacherEntities = (ArrayList)teacherQuery.makeQuery(clazz.get(0).getSchoolName(),null,null,null);

                AnnouncementEntity announcementEntity = new AnnouncementEntity();
                announcementEntity.setClassSection(clazz.get(0).getSection());
                announcementEntity.setDueDate(new Date(System.currentTimeMillis()));
                announcementEntity.setInfo("Please not being copied");
                announcementEntity.setSchoolName(teacherEntities.get(0).getSchoolName());
                announcementEntity.setSubmitDate(new Date(System.currentTimeMillis()));
                announcementEntity.setTeacherEmployeeId(teacherEntities.get(0).getEmployeeId());
                supporter.createObject(announcementEntity);

                for(int i=0;i<numberOfDriver;i++){
                        DriverEntity driverEntity = new DriverEntity();
                        driverEntity.setId("dr" + i);
                        driverEntity.setPhoneNumber("" + Math.random()*max_int);
                        driverEntity.setSsn("ssn" + i);
                        supporter.createObject(driverEntity);
                }
                for(int i=0;i<numberOfDriver;i++) {
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

                for(int i =0;i<student_number;i++) {
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
        public void createSchedule(){
                ArrayList<ClazzEntity> clazzEntities = (ArrayList)clazzQuery.makeQuery(null,null,null,null);
                ArrayList<CourseEntity> courseEntities = (ArrayList)courseQuery.makeQuery(null,null,null,null,null);
                ArrayList<HaveScheduleEntity> haveScheduleEntities= (ArrayList)haveScheduleQuery.makeQuery(null,null,null);
                ArrayList<ScheduleConsistsOfEntity> scheduleConsistsOfEntities = (ArrayList)scheduleConsistsOfQuery.makeQuery(null,null,null,null,null);
                for (int i = 0; i < school_list.length; i++) {

                        SchoolEntity schoolEntity = new SchoolEntity();
                        schoolEntity.setName(school_list[i]);
                        schoolEntity.setSchoolAddress(school_adrress[i]);
                        schoolEntity.setSchoolType(school_type[i]);
                        supporter.createObject(schoolEntity);
                }
        }
}

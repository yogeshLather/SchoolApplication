package com.example.myProjects.libraryClasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.myProjects.models.AcademicRecord;
import com.example.myProjects.models.Student;


@Service
public class DatabaseHelper {
	
	private String student_info_table = "student_info";
	private String academic_info_table = "academic_info";
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DatabaseHelper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String addStudent(Student student) {
		try {
			if(getStudent(student.getGrade(), student.getRollNumber()) != null) {
				return "Student already exists";
			}
			String query = "insert into " +  student_info_table +
					" values(" + student.getGrade() + ", " +student.getRollNumber()+ ", '" + student.getName() + "')";
			
			jdbcTemplate.execute(query);
			return "Successfully Inserted";     
		} catch(DataAccessException e) {
			return "Insert Failed" ;
		} 
	}
	
	public String addRecord(int grade, int rollNumber, AcademicRecord ar) {
		Student student = getStudent(grade, rollNumber);
		if(student == null) {
			return "Student does not exist";
		}
		try {
			if(getAcademicRecord(student.getGrade(), student.getRollNumber()) != null) {
				String query;
				if(ar.getEnglishScore() != null) {
					query = "update  "+ academic_info_table + " set math_score=" + ar.getMathScore() + ", english_score=" + ar.getEnglishScore() + " where class=" + student.getGrade() + " and roll_number=" + student.getRollNumber();
				} else {
					query = "update  "+ academic_info_table + " set math_score=" + ar.getMathScore() + " where class=" + student.getGrade() + " and roll_number=" + student.getRollNumber();
				}
				jdbcTemplate.execute(query);
				return "Successfully Inserted";  
			} else {
				String query;
				if(ar.getEnglishScore() != null) {
					query = "insert into "+ academic_info_table + " values(" + student.getGrade() + "," +student.getRollNumber() + "," + ar.getMathScore() + "," +ar.getEnglishScore() + ")";
				} else {
					query = "insert into "+ academic_info_table +" (class, roll_number, math_score)" + " values(" + student.getGrade() + "," +student.getRollNumber() + "," + ar.getMathScore() + ")";
				}
				jdbcTemplate.execute(query);
				return "Successfully Inserted";  
			}
		} catch(DataAccessException e) {
			return "Insert Failed" ;
		} 
	}
	
	public AcademicRecord getAcademicRecord(int grade, int roll_number) {
		@SuppressWarnings("deprecation")
		List<AcademicRecord> academicInfo = jdbcTemplate.query("SELECT * FROM academic_info WHERE class=? and roll_number=?" , 
				new Object[] {grade, roll_number}, 
				(rs, rowNum)->{
					AcademicRecord ar = new AcademicRecord(rs.getInt("math_score"));
					if(rs.getInt("english_score") != 0) {
						ar.setEnglishScore(rs.getInt("english_score"));
					}
					return ar;
				});
		
		if(academicInfo.size()>0) {
			return academicInfo.get(0);
		} else {
			return null;
		}
	}
	
	public Student getStudent(int grade, int roll_number) {
		@SuppressWarnings("deprecation")
		List<Student> students = jdbcTemplate.query("SELECT * FROM student_info WHERE class=? and roll_number=?" , 
				new Object[] {grade, roll_number}, 
				(rs, rowNum)->{
					return new Student(rs.getInt("roll_number"), rs.getInt("class"), rs.getString("name"));
				});
		
		if(students.size()>0) {
			return students.get(0);
		} else {
			return null;
		}
	}
}

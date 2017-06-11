package service;

import java.util.List;

import entity.Students;

//学生业务逻辑接口
public interface IStudentsDAO {
	
	//查询所有学生信息
	public List<Students> queryAllStudents();
	
	//根据学号查询学生信息
	public Students queryStudentsBySid(String sid);
	
	//添加学生信息
	public boolean addStudents(Students s);
	
	//修改学生信息
	public boolean updateStudents(Students s);
	
	//删除学生信息
	public boolean deleteStudents(String sid);
}

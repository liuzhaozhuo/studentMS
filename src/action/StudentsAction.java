package action;

import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import entity.Students;
import entity.Users;
import service.IStudentsDAO;
import sevice.impl.StudentsDAOImpl;

//学生Action类
public class StudentsAction extends SuperAction implements ModelDriven<Students>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Students student = new Students();
	
	//查询所有学生的动作
	
	public String query(){
		IStudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		//放进session中
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);			
		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete(){
		IStudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	//添加学生动作
	public String add(){

		IStudentsDAO studentsDAO = new StudentsDAOImpl();

		studentsDAO.addStudents(student);//使用模型驱动获取从表单提交过来的信息

		return "add_success";

	}
	
	//修改学生资料动作
	public String modify(){
		String sid = request.getParameter("sid");
		IStudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//保存修改后的学生资料动作
	public String save() throws Exception{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		IStudentsDAO sdao = new StudentsDAOImpl();
		sdao.updateStudents(s);		
		return "save_success";
	}

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.student;
	}
	
	
	
}

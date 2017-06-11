package action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import entity.Students;
import entity.Users;
import service.IStudentsDAO;
import sevice.impl.StudentsDAOImpl;

//ѧ��Action��
public class StudentsAction extends SuperAction implements ModelDriven<Students>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Students student = new Students();
	
	//��ѯ����ѧ���Ķ���
	
	public String query(){
		IStudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		//�Ž�session��
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);			
		}
		return "query_success";
	}
	
	//ɾ��ѧ������
	public String delete(){
		IStudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	//���ѧ������
	public String add(){

		IStudentsDAO studentsDAO = new StudentsDAOImpl();

		studentsDAO.addStudents(student);//ʹ��ģ��������ȡ�ӱ��ύ��������Ϣ

		return "add_success";

	}

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.student;
	}
	
	
	
}

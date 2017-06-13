package service;

import java.util.List;

import entity.Students;

//ѧ��ҵ���߼��ӿ�
public interface IStudentsDAO {
	
	//��ѯ����ѧ����Ϣ
	public List<Students> queryAllStudents();
	
	//����������ѯѧ����Ϣ
	public List<Students> queryStudentsByName(String sname);
	
	//����ѧ�Ų�ѯѧ����Ϣ
	public Students queryStudentsBySid(String sid);
	
	//���ѧ����Ϣ
	public boolean addStudents(Students s);
	
	//�޸�ѧ����Ϣ
	public boolean updateStudents(Students s);
	
	//ɾ��ѧ����Ϣ
	public boolean deleteStudents(String sid);

}

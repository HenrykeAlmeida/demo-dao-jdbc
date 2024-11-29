package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("====== Test 1: FindById =======");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("====== Test 2: FindAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("====== Test 3: Insert =======");
		Department newDepartment = new Department(null, "Businness");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("====== Test 4: Update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("UPDATE COMPLETED");
		
		System.out.println("====== Test 5: Delete =======");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("DELETE COMPLETED! ");
		
	    sc.close();	
	}
}

package com.jdbc.bootjdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BootjdbcexampleApplication implements CommandLineRunner {
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(BootjdbcexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createTable());

//		creating user
		this.insertUser();

//		Updating user
		this.updateUser();

//		DeleteUser user
		this.deleteUser();

//		search user
		this.searchUser();
	}
	public void insertUser() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user ID: ");
		Integer userId =  Integer.parseInt(br.readLine());

		System.out.println("Enter user Name: ");
		String name =  br.readLine();

		System.out.println("Enter user age: ");
		Integer age =  Integer.parseInt(br.readLine());

		System.out.println("Enter user city: ");
		String city =  br.readLine();

		int i = this.userDao.insertUser(userId, name, age, city);

		System.out.println(i + " user added");
	}


	public void updateUser() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter user ID to update: ");
		Integer userId = Integer.parseInt(br.readLine());

		System.out.println("Enter updated user Name: ");
		String name = br.readLine();

		System.out.println("Enter updated user age: ");
		Integer age = Integer.parseInt(br.readLine());

		System.out.println("Enter updated user city: ");
		String city = br.readLine();

		int i = this.userDao.updateUser(userId, name, age, city);
		System.out.println(i + " user updated");
	}

	public void deleteUser() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user ID to delete: ");
		Integer userId = Integer.parseInt(br.readLine());

		int i = this.userDao.deleteUser(userId);
		System.out.println(i + " user deleted");
	}
	public void searchUser() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Search row: ");
		int userId = Integer.parseInt(br.readLine());

		List<Map<String, Object>> search = this.userDao.search(userId);
		System.out.println(search + " row search.");
	}
}
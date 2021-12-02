package com.example.hospitalapp;

import com.example.hospitalapp.controller.Controller;
import com.example.hospitalapp.view.CLIView;
import com.example.hospitalapp.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalAppApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		View view = new CLIView();
		Controller controller = new Controller(view);
		controller.simulateOperation();
	}
}

package com.raghu.mbs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raghu.mbs.repository.SeatRepository;
import com.raghu.mbs.service.SeatReleaseHook;
import com.raghu.mbs.util.StaticData;

@SpringBootApplication
public class MovieBookingSystemApplication {

	@Autowired
	StaticData staticData;
	
	@Autowired
	SeatReleaseHook seatReleaseHook;
	

	@PostConstruct
	private void init() {
		System.out.println("MovieBookingSystemApplication initialization logic starts...");
		staticData.PersistStaticData();
		System.out.println("InitDemoApplication initialization logic ends...");
		Thread t1 = new Thread(seatReleaseHook);
		t1.start();
		System.out.println("Seat release thread started");
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingSystemApplication.class, args);
	}

}

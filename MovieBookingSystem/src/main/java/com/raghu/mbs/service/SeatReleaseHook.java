package com.raghu.mbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raghu.mbs.repository.SeatRepository;

@Component
public class SeatReleaseHook implements Runnable {

	@Autowired
	SeatRepository seatRepository;

	@Override
	public void run() {

		try {

			while (true) {

				List<Integer> listOfSeats = seatRepository.getUnConfirmedSeat();
				System.out.println("Going to Release seats : "+listOfSeats);
				for (Integer seatId : listOfSeats) {
					seatRepository.deleteById(seatId);
					System.out.println("Deleted seat id: "+seatId);
				}
				Thread.sleep(60000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

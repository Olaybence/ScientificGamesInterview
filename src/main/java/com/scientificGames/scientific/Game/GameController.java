package com.scientificGames.scientific.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class GameController {
	
	private Integer defaultCount = 6;
	private Integer poleSize = 49; // maximum value

	@GetMapping( path = "/randoms/{count}")
	public ArrayList<Integer> getGeneratedRandoms(@PathVariable Integer count) {
		
		// If negative, return empty list
		if(count < 0) return new ArrayList<Integer>();
		
		// If more needed than there is (return them all - otherwise it is a question what to do)
		if(count > poleSize) {
			ArrayList<Integer> full = new ArrayList<Integer>();
			for(int i = 0; i < poleSize; i++) full.add(i);
			return full;
		}
		
		ArrayList<Integer> randoms = new ArrayList<Integer>();
		int i = 0;
		Random r = new Random();
		while(i < count) {
			int tmp = r.nextInt(poleSize);
			if ( !randoms.contains(tmp)) {
				randoms.add(tmp);
				i++;
			}
		}
		return randoms;
	}
	
	@GetMapping( path = "/randoms/")
	public ArrayList<Integer> getGeneratedRandoms() {
		return this.getGeneratedRandoms(defaultCount);
	}
}

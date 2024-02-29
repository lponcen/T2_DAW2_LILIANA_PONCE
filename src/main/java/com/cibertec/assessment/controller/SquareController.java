package com.cibertec.assessment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.model.Square;
import com.cibertec.assessment.service.SquareService;


@RestController
@RequestMapping("/Square")
public class SquareController {
	
	@Autowired
	SquareService SquareService;
	
	@GetMapping
	public ResponseEntity<List<Square>> list(){
		return new ResponseEntity<>(SquareService.list(),HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<Square> createSquare(@RequestBody Square square) {
        Square createdSquare = SquareService.create(square);
        return new ResponseEntity<>(createdSquare, HttpStatus.CREATED);
    }
}


	




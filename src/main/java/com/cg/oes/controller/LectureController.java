package com.cg.oes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oes.entity.Lecture;
import com.cg.oes.exception.LectureNotFoundException;
import com.cg.oes.service.ILectureService;

@RestController
@RequestMapping(value = "/OES")
@CrossOrigin(origins="http://localhost:4200")
public class LectureController {
	@Autowired 
	private ILectureService ILectureService;
		
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	/**
	 * method name: addLecture
	 * method desc: to add a object of lecture class by passing object by calling the method of service class.
	 * parameters:  Lecture class type-lecture
	 * returns:     lecture
	 * method type: post
	 * author name: Manoj
	 */ 
	@RequestMapping(value="/lectures",method=RequestMethod.POST) 
	public ResponseEntity<Object> addLectures(@RequestBody Lecture lecture)  {
		lecture= ILectureService.addLecture(lecture);
		logger.info("Lecture Added");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	 /**
	 * method name: getLecture
	 * method desc: to fetch the details of lecture by passing  student id through uri by calling method of service class.
	 * parameters:  int type-id
	 * returns:    Lecture
	 * method type: get
	 * author name: Manoj
	 */ 
	@GetMapping(value="/lectures/{lectureId}")
	public Lecture getLectures(@PathVariable("lectureId") int lectureId){
		Lecture lecture=ILectureService.searchLecture(lectureId);
           return lecture;
	}
	/**
	 * method name: deleteLecture
	 * method desc: to delete  lecture by passing lecture id through uri by calling the method of service class.
	 * parameters:  int type-lectureId
	 * returns:     boolean 
	 * method type: delete
	 * author name: Manoj
	 */ 
	@DeleteMapping(value="/lectures/{lectureId}")
    public boolean deleteLectures(@PathVariable("lectureId") int lectureId) {
		ILectureService.deleteLecture(lectureId);
	  return true;
    }
	 /**
	 * method name: updateLecture
	 * method desc: update the object of  lecture by passing object by calling the method of service class.
	 * parameters:  Lecture class type-student
	 * returns:    Lecture
	 * method type: put
	 * author name: Manoj
	 */ 
	@PutMapping(value="/lectures")
	public Lecture updateLectures(@RequestBody Lecture lecture) {
		return ILectureService.updateLecture(lecture);		
	}
	/**
	 * method name: listLecture
	 * method desc: to fetch details of all lecture through uri by calling method of service class. 
	 * parameters:  no parameters
	 * returns:     list of student type
	 * method type: get
	 * author name: Manoj
	 */ 
	@GetMapping(value="/lectures")
	public List<Lecture> listLectures(){
		return ILectureService.displayLecture();
	}
	

}
package com.cg.oes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oes.entity.Lecture;
import com.cg.oes.exception.LectureNotFoundException;
import com.cg.oes.repository.ILectureRepository;

@Service
@Transactional 
public class LectureServiceImpl implements ILectureService {
	
	@Autowired
	private ILectureRepository ILectureRepository;
	/**
	 * method name: saveLecture
	 * method desc: get a Lecture class object and insert into database through save method.
	 * parameters:  Lecture type-lecture
	 * returns:    Lecture
	 * method type: insertion
	 * author name: Manoj
	 */
	@Override
	public Lecture addLecture(Lecture lecture) {
		try
		{
			return ILectureRepository.save(lecture);
		}catch(Exception e)
		{	
			throw new LectureNotFoundException("Lecture with id : "+lecture.getLectureId()+" already exist.");
		}	
	
	}
	 /**
		 * method name: searchLecture
		 * method desc: to fetch the details of Lecture from database through klectureId by findById method.
		 * parameters:  int type-teacherId
		 * returns:    Lecture
		 * method type: retrieval
		 * author name: Manoj
		 */
	@Override
	public Lecture searchLecture(int lectureId) {
		return ILectureRepository.findById(lectureId).get();
		
	}
	 /**
		 * method name: deleteLecture
		 * method desc: to delete the details of  lecture from database through  lectureId by deleteById method.
		 * parameters:  int0 type- lectureId
		 * returns:    Void
		 * method type: retrieval
		 * author name: Manoj
		 */
	@Override
	public void deleteLecture(int lectureId) {
		ILectureRepository.deleteById(lectureId);
				
	}
	 /**
		 * method name: updateLecture
		 * method desc: get a Lecture class object and update it from database through save method.
		 * parameters: Lecture type-lecture
		 * returns:     Lecture
		 * method type: updation
		 * author name: Manoj
		 */	 
	@Override
	public Lecture updateLecture(Lecture lecture) {
		Lecture updateLectures =ILectureRepository.save(lecture);
	    if(updateLectures!=null)
		{
		return ILectureRepository.save(lecture);		
		}
		else
		{
		throw new LectureNotFoundException("TeacherId  does not exist.");
		}
	
	}
	/**
	 * method name: displayLecture()
	 * method desc: to fetch the details of lecture by findAll method.
	 * parameters:  no parametrs
	 * returns:     list of Lecture type
	 * method type: retrieval
	 * author name: Manoj
	 */ 
	@Override
	public List<Lecture> displayLecture() {
		return (List<Lecture>) ILectureRepository.findAll();
	}

}

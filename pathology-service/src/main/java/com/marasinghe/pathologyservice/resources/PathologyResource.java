package com.marasinghe.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marasinghe.pathologyservice.models.Disease;
import com.marasinghe.pathologyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	List<Disease> diseases = Arrays.asList(
			new Disease("D1", "Asthma", "Warm water bath"),
			new Disease("D2", "Thyphoid", "Ampicilin capsule!")
			);
	
	 
    @RequestMapping("/diseases")
	public DiseasesList getDiseases(){
    	
    	DiseasesList diseasesList = new DiseasesList();
    	diseasesList.setDiseases(diseases);
    	
		return diseasesList;
	}
   
    
    
    @RequestMapping("/diseases/{Id}")
    public Disease getDiseaseById(@PathVariable("Id") String Id) {
    	Disease d = diseases.stream()
    			.filter(disease -> Id.equals(disease.getId()))
    			.findAny()
    			.orElse(null);
    	return d;
    }
}

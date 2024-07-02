package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Patient {
	
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientNameString=" + patientNameString + ", age=" + age
				+ ", doctor=" + doctor + "]";
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientNameString() {
		return patientNameString;
	}
	public void setPatientNameString(String patientNameString) {
		this.patientNameString = patientNameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	@Id
	private int patientId;
	private String patientNameString;
	private int age;
	@ManyToMany
	private List <Doctor> doctor;
	

}

package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Doctor {
	
@Override
	public String toString() {
		return "Doctor [doctoerId=" + doctoerId + ", nameString=" + nameString + ", fees=" + fees + ", Patient="
				+ Patient + "]";
	}
public int getDoctoerId() {
		return doctoerId;
	}
	public void setDoctoerId(int doctoerId) {
		this.doctoerId = doctoerId;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public List<Patient> getPatient() {
		return Patient;
	}
	public void setPatient(List<Patient> patient) {
		Patient = patient;
	}
@Id
private int doctoerId;
private String nameString;
private int fees;
@ManyToMany
private List <Patient> Patient;




}

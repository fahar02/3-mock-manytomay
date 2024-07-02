package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Doctor;
import dto.Patient;

public class Doctordao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("mockmanytomany").createEntityManager();
		
	}
	public void saveDoctor(Doctor doctor)
	{ 
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(doctor);
		entityTransaction.commit();
	}
	public void updateDoctor(int doctorId,Doctor doctor)
	{
		EntityManager entityManager=getEntityManager();
		Doctor doctordb=entityManager.find(Doctor.class,doctorId);
		if(doctordb!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			doctor.setDoctoerId(doctorId);
			doctor.setPatient(doctordb.getPatient());
			entityManager.merge(doctor);
			entityTransaction.commit();
			
		}
		else {
			System.out.println("invalid student id");
		}
	}
	public void deleteDoctor(int doctorId)
	{
		EntityManager entityManager=getEntityManager();
		Doctor doctordb=entityManager.find(Doctor.class,doctorId);
		if(doctordb!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			List <Patient> patients=doctordb.getPatient();
			for(Patient patient:patients)
			{
				List <Doctor> doctors=patient.getDoctor();
				doctors.remove(doctordb);
				patient.setDoctor(doctors);
				
				
			}
			entityManager.remove(doctordb);
			entityTransaction.commit();
		
		}
		else {
			System.out.println("invalid student id");
		}
	}
	public void findDoctor(int doctorId)
	{
		EntityManager entityManager=getEntityManager();
		Doctor doctordb=entityManager.find(Doctor.class,doctorId);
		if(doctordb!=null)
		{
			System.out.println(doctordb);
		}
		else {
			System.out.println("invalid docctor Id");
		}
	}
}

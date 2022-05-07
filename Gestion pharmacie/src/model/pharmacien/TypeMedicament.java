package model.pharmacien;

import java.util.ArrayList;

public class TypeMedicament {
	
	public static int id = 1;
	private int idType;
	private String label;
	private String description;
	private static ArrayList<TypeMedicament> listType  = new ArrayList<TypeMedicament>();
	
	public TypeMedicament() {
		idType = id;
		label = new String("INCONNU");
		description = new String("");
		id++;
	}
	
	public TypeMedicament(String label, String desc) {
		
		idType = id;
		this.label = label;
		this.description = desc;
		id++;
		
	}
	
	public int getId() {
		return idType;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static ArrayList<TypeMedicament> getListType() {
		return listType;
	}

	public static void setListType(ArrayList<TypeMedicament> listType) {
		TypeMedicament.listType = listType;
	}
	
}

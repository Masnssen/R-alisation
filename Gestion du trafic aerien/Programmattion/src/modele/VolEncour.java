package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VolEncour extends Vol {
	private String typeVolEncour;
	

	public VolEncour(String typeVolEncour,String id,String dateDep, String dateArriver, String idaeroportDep, String idaeroportArriver, int nbEcale,
			int nbPassager, double fretVol, String idcompagnie, TypeVol typeVol, String idAeronef, int idequippage,
			String heureDepart, String heureArriver,double distance) {
		super(id ,dateDep, dateArriver, idaeroportDep, idaeroportArriver, nbEcale, nbPassager, fretVol, idcompagnie, typeVol,
				idAeronef, idequippage, heureDepart, heureArriver,distance);

		this.typeVolEncour = typeVolEncour;
	}


	public String getTypeVolEncour() {
		return typeVolEncour;
	}


	public void setTypeVolEncour(String typeVolEncour) {
		this.typeVolEncour = typeVolEncour;
	}
	
	
	

	
	
	

}

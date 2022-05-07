package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
     Attribution attribution = new Attribution(5, 8, Fonction.STEWARDS,"2020-09-26");
     attribution.Modifier();
	}
    

}

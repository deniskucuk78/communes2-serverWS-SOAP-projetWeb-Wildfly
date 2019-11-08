package fr.gtm.communes.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.gtm.communes.CommunesDAO;
import fr.gtm.communes.entities.Commune;
import fr.gtm.communes.entities.Region;

@Stateless
@WebService

public class CommuneService implements CommuneServiceRemote, CommuneServiceLocal, CommuneServiceInterface, ConvertionService1 {
	@EJB private CommunesDAO dao;
	
	@Override
	public List<Commune> getCommunesByCodePostalLike(String cp) {
		return dao.getCommunesByCp(cp);
	}

	@Override
	public List<Region> getRegions() {
		return dao.getRegions();
	}
	
	@Override
	public String convertToSexagesimal(double gpsLatitude) {
		int d = (int) gpsLatitude;
		double mTemp = (gpsLatitude - d)*60;
		int m = (int) mTemp;
		int s = (int) ((gpsLatitude - d - m/60)*3600);
		String res = d+"°"+m+"''"+s+"'";
		return res;
	}
	
}

package fr.gtm.communes.service;

import java.util.List;

import fr.gtm.communes.entities.Commune;
import fr.gtm.communes.entities.Region;

public interface CommuneServiceInterface {
	
	List<Commune> getCommunesByCodePostalLike(String cp);
	List<Region> getRegions();

}
/**
 * 
 */
package it.unibo.oop.lab.enum2;

/**
 * Represents an enumeration for declaring sports.
 * 
 * 1) You must add a field keeping track of the number of members each team is
 * composed of (1 for individual sports)
 * 
 * 2) A second field will keep track of the name of the sport.
 * 
 * 3) A third field, of type Place, will allow to define if the sport is
 * practiced indoor or outdoor
 * 
 */
public enum Sport {
	
	BASKET (Place.INDOOR, 5, "Basket"),
	VOLLEY (Place.INDOOR, 6, "Volley"),
	TENNIS (Place.OUTDOOR, 1, "Tennis"),
	BIKE (Place.OUTDOOR, 1, "Bike"),
	F1 (Place.OUTDOOR, 1, "F1"),
	MOTOGP (Place.OUTDOOR, 1, "MotoGP"),
	SOCCER (Place.OUTDOOR, 11, "Soccer");
	
	private final String name;
	private final int teamMemebers;
	private final Place place;

	/**
	 * Builds new sport by place, no team members and name
	 * 
	 * @param place
	 * 				place to be set
	 * @param noTeamMembers
	 * 						no of team members to be set
	 * @param actualName
	 * 					name of sport to be set
	 * */
	Sport(final Place place, final int noTeamMembers, final String actualName) {
		this.name = actualName;
		this.place = place;
		this.teamMemebers = noTeamMembers;
	}
	
	/**
	 * Checks if the receiver is an individual sport
	 * 
	 * @return true
	 * 				if receiver's number of team members is equals to 1 
	 * */
	public boolean isIndividualSport() {
		return this.teamMemebers == 1;
	}
	
	/**
	 * Checks if receiver is an indoor sport
	 * 
	 * @return true
	 * 				if the receiver's place is equals to indoor
	 * */
	public boolean isIndoorSport() {
		return this.place == Place.INDOOR;
	}
	
	/**
	 * @return receiver's {@link Place}
	 * */
	public Place getPlace() {
		return this.place;
	}
	
	/**
	 * @return receiver's string representation
	 * */
	public String toString() {
		return this.name + " , Team Members: " + this.teamMemebers + " , Place: " + this.place;
	}
	
}

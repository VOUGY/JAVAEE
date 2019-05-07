package ch.hevs.warservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Weapon;
import ch.hevs.businessobject.Account;

@Local
public interface WarService {

	Account getAccount(String accountDescription, String lastnameOwner);
	
	public List<Account> getAccountListFromClientLastname(String lastname);

	void transfer(Account compteSrc, Account compteDest, int montant) throws Exception;

	List<Client> getClients();

	Client getClient(long clientid);
	
	// To do => Nicolas Solioz
	/*
	void AddWar();
	void DeleteWar(long id);
	void EditWar();
	void FinishWar();
	*/
	
	// To do => Guillaume Vouilloz
	void AddWeapon(Weapon weapon);
	void DeleteWeapon(long id);
	void EditWeapon(Weapon weapon);
	List<Weapon> GetWeapons();
	Weapon GetWeapon(long id);
	// To do => GV and NS	
	
	/*
	 * void EditCountry();
	 * void AddCountry();
	 */
	
}

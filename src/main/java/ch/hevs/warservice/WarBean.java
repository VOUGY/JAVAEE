package ch.hevs.warservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Weapon;

@Stateless
public class WarBean implements WarService {
	
	@PersistenceContext(name = "BankPU")
	private EntityManager em;

	public Account getAccount(String accountDescription, String lastnameOwner) {
		Query query = em.createQuery("FROM Account a WHERE a.description=:description AND a.owner.lastname=:lastname");
		query.setParameter("description", accountDescription);
		query.setParameter("lastname", lastnameOwner);
		
		return (Account) query.getSingleResult();
	}
	
	public List<Account> getAccountListFromClientLastname(String lastname) {
		return (List<Account>) em.createQuery("SELECT c.accounts FROM Client c where c.lastname=:lastname").setParameter("lastname", lastname).getResultList();
	}

	public void transfer(Account srcAccount, Account destAccount, int amount) {
		//CHANGEMENT DE persist en merge
		em.merge(srcAccount);
		em.merge(destAccount);
		srcAccount.debit(amount);
		destAccount.credit(amount);
	}

	public List<Client> getClients() {
		return em.createQuery("FROM Client").getResultList();
	}
	
	public Client getClient(long clientid) {
		return (Client) em.createQuery("FROM Client c where c.id=:id").setParameter("id", clientid).getSingleResult();
	}

	@Override
	public void AddWeapon(Weapon weapon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteWeapon(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EditWeapon(Weapon weapon) {
		//em.createQuery(qlString)		
	}

	@Override
	public List<Weapon> GetWeapons() {
		return em.createQuery("FROM Weapon").getResultList();
	}

	@Override
	public Weapon GetWeapon(long weaponId) {
		return (Weapon) em.createQuery("FROM Weapon w where w.id =:id").setParameter("id", weaponId).getSingleResult();
	}
}

package br.com.fiap.trabalho.test.jdbc;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.dao.jdbc.JDBCDAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;
import br.com.fiap.trabalho.entity.Studio;

@SuppressWarnings("deprecation")
public class TestJDBCActorDao {
	private ActorDAO actorDAO;
	private MovieDAO movieDAO;
	private StudioDAO studioDAO;
	private HashSet<Actor> actors = new HashSet<Actor>();
	private Studio studio1;

	@Before
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JDBCDAOFactory();
		actorDAO = abstractDAOFactory.createActorDAO();
		movieDAO = abstractDAOFactory.createMovieDAO();
		studioDAO = abstractDAOFactory.createStudioDAO();
		Actor actor1 = new Actor();
		actor1.setBirthDate(new Date("10/10/2010"));
		actor1.setFullName("actor1");
		actorDAO.createActor(actor1);

		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2");
		actorDAO.createActor(actor2);
		actors.add(actor1);
		actors.add(actor2);

		/*
		 * studio1 = new Studio(); studio1.setName("Studio 1");
		 * studioDAO.createStudio(studio1);
		 */
	}

	@Test
	public void validarcreateDao() {
		Assert.assertNotNull(this.actorDAO);
	}

	@Test
	public void insertActor() {
		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2000"));
		actor.setFullName("actor insert");
		actorDAO.createActor(actor);
		assertNotNull(actor);
	}

	@Test
	public void selectActorByName() {
		List<Actor> actorList = actorDAO.selectActorByName("actor2");
		assertNotNull(actorList);
	}

	@Test
	public void selectActorByAge() {
		Actor actor1 = new Actor();
		actor1.setBirthDate(new Date("10/10/2010"));
		actor1.setFullName("actor select by age");
		actorDAO.createActor(actor1);

		List<Actor> actorList = actorDAO.selectActorByAge(3);
		for (Actor actor : actorList) {
			if (actor.getBirthDate().getYear() + 1900 != getYear(3)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}

	@Test
	public void deleteActor() {
		List<Actor> actorList = actorDAO.selectActorByName("actor2");
		int idActor = actorList.get(0).getId();
		long milisec = new Date().getTime();
		actorDAO.deleteActor(actorList.get(0));
		milisec = new Date().getTime() - milisec;
		System.out.println(milisec + " ms");
		List<Actor> actorList2 = actorDAO.selectActorByName("actor2");
		if (!actorList2.isEmpty()) {
			assertTrue(idActor != actorList2.get(0).getId());
		} else {
			assertTrue(true);
		}
	}

	@Test
	public void selectActorByMovie() {
		Movie movie = new Movie();
		movie.setActors(actors);
		movie.setTitle("Ca�ada ao Mundo do Java");
		movie.setStudio(studio1);
		movie.setYear(2013);
		movieDAO.createMovie(movie);
		Set<Actor> list = actorDAO.selectActorByMovie(movie);
		assertTrue(list.size() > 0);
	}

	private int getYear(int age) {
		Calendar c = new GregorianCalendar();
		int ano = c.get(Calendar.YEAR);
		return ano - age;
	}
}
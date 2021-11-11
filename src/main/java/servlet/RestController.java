package servlet;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AutoreDao;
import dao.LibroDao;
import model.Autore;
import model.Libro;


@Stateless

@Path("rest")
public class RestController {

	@Inject
	private AutoreDao autoreDao;

	@Inject
	private LibroDao libroDao;
	
	
	
	
	// --- http://localhost:8080/progettoAutoreLibro/api/rest/all ---
	// http protocollo
	// 127.0.0.1 : dove risiede il mio server
	// 8080 porta default di esposizione protocollo application server
	// progettoAutoreLibro = nome progetto definito in maven
	// api = servlet
	// rest = ejb contenitore di servizi esposti
	// all = il nome del metodo
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("{id}") //variabile {}
	public Autore getById(@PathParam("id") int id) {
		return autoreDao.get(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("all") //variabile {}
	public List<Autore> getEvryone() {
		return autoreDao.getAll();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("allbook") //variabile {}
	public List<Libro> getAllbook() {
		return libroDao.getAll();
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("insertAutore")
	public void insertAutore(Autore nuovoAutore) {
		autoreDao.save(nuovoAutore);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("insertLibro")
	public void insertLibro(Libro nuovoLibro) {
		libroDao.save(nuovoLibro);
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("generaTreAutori")
//	public List<Autore> generaAutore(){
//		AtomicInteger count = new AtomicInteger(1);
//		Autore autore1 = new Autore();
//		List<Autore> padroniList = Arrays
//				.asList(new Autore(),
//						new Autore(),
//						new Autore());
//		padroniList.stream()
//		.forEach(persona -> {
//			persona.setNome("nome"+count.get());
//			persona.setCognome("cognome"+count.getAndIncrement());
//
//		});
//		autore1.setCognome("asd");
//		autore1.setNome("das");
//		autore1.setId(3);
//		padroniList.stream()
//		.forEach(persona ->{
//			autoreDao.save(persona);
//		});
//		//
//
//
//		//terzo inserimento illegale test
//		return padroniList;
//	}
	
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Path("insertCMT")
//	public void containedPadrone(Padrone padrone, Cane cane) 
//			throws 
//			IllegalStateException, SecurityException, 
//			SystemException, RollbackException, 
//			HeuristicMixedException, HeuristicRollbackException 
//	{
//		padroneDaoMod.save(padrone, cane);
//
//	}


}

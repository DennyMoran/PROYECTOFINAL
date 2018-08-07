import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.LoggerFactory;

import Modelos.Usuario;
import Modelos.Discos;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Server {
	
	/**
	 * Nuestra "Base de Datos" de Usuarios
	 * La utilizaremos para iniciar sesion
	 */
	static Usuario[] usuarios = {
	    new Usuario("Albert", "Santiago", "albertsc", "albert"),
	};
	
	static ArrayList<Discos> disco = new ArrayList<>();
	// Contador con el que asignaremos un ID Unico a cada
		// uno de nuestros juegos.
	static int idCounter = 0;
	
	public static void main(String[] args) {
		port(1234);
//		staticFiles.location("/");
		
		
		
		before((req, res) -> {
			/**
			 * Revisamos 2 cosas:
			 * 1 - El usuario NO esta iniciado en la sesion
			 * 2 - La cookie existe.
			 */
			if(req.session(true).attribute("usuarioEnSesion") == null
				&& req.cookie("usuarioLoggeado") != null) {
				/**
				 * Dado que ambas condiciones se dan,
				 * podemos tomar el nombre de usuario de la cookie "usuarioLoggeado"
				 */
				String nombreDeUsuario = req.cookie("usuarioLoggeado");
				/**
				 * For Each.
				 * Se lee: Para cada `usuario` de la lista de `usuarios`
				 * se realiza el bloque de codigo a continuacion
				 */
				for(Usuario user : usuarios) {
					/**
					 * Si hay un usuario en la lista que tenga
					 * el mismo nombre de usuario de la variable
					 * `nombreDeUsuario`, entonces lo guardamos en la sesion
					 */
					if(user.getUsuario().equals(nombreDeUsuario)) {
						req.session(true).attribute("usuarioEnSesion", user);
					}
				}
			}
		});
		
		/**
		 * Protegemos todas las rutas que empiezen con /privado/
		 */
		before("/privado/*", (req, res) -> {
			if(req.session(true).attribute("usuarioEnSesion") == null) {
				halt(401, "Usted no esta loggeado");
			}
		});
		
		get("/", (req, res) -> {
        	HashMap<String, Object> model = new HashMap<>();
        	if(req.session(true).attribute("usuarioEnSesion") == null) {}
        	return new ModelAndView(model,"form.ftl");
        }, new FreeMarkerEngine());
		
		
		
//		get("/", (req, res) -> {
//			if(req.session(true).attribute("usuarioEnSesion") == null) {
//				res.redirect("/form.ftl");
//				return null;
//			}
//			
//			Usuario usuarioEnSesion = req.session(true).attribute("usuarioEnSesion");
//			
//			return "Bienvenido " + usuarioEnSesion.getNombre() + " " + usuarioEnSesion.getApellido();
//		});
		
		/**
		 * Metodo que permite iniciar sesion basado
		 * en un usuario y contrasena.
		 */
		post("/login", (req, res) -> {
			String nombreUsuario = req.queryParams("usuario");
			String contrasena = req.queryParams("pass");
			boolean rememberMe = req.queryParamOrDefault("rem", "off").equals("on");
			
			for(Usuario user : usuarios) {
				if(user.getUsuario().equals(nombreUsuario)
					&& user.getContrasena().equals(contrasena)) {
					req.session(true).attribute("usuarioEnSesion", user);
					if(rememberMe) {
						res.cookie("usuarioLoggeado", user.getUsuario());
					}
				}
			}

			res.redirect("/lista.ftl");
			return null;
		});
		
		get("/privado/este", (req, res) -> {
			return "Solo por usuarios loggeados ESTE";
		});
		
		get("/privado/tambien", (req, res) -> {
			return "Solo por usuarios loggeados TAMBIEN";
		});
		
org.slf4j.Logger log = LoggerFactory.getLogger(Server.class);
        
		before((req, res) -> {
			// si la lista esta vacia,
			// Agregamos algunos juegos para
			// que el usuario nunca vea una pantalla
			// vacia.
			
			if(disco.size() == 0) {
				disco.add(new Discos(
						-2,
					"https://www.google.com.do/url?sa=i&source=imgres&cd=&cad=rja&uact=8&ved=2ahUKEwikibHm6s_cAhXM11MKHZ8uDDcQjRx6BAgBEAU&url=https%3A%2F%2Fwww36.pluspremieres.us%2F2018%2F04%2Fdrake-scorpion.html&psig=AOvVaw2pJSVMUxCuu7vKOrCSIo6o&ust=1533349668624654", 
					"Scorpion", 
					"Drake", 
					"29 de junio 2018", 
					"Canada"
				));
				disco.add(new Discos(
						-1,
					"http://a3.mzstatic.com/us/r30/Music71/v4/b9/73/d0/b973d0c9-5b64-1670-8997-879e49e22eea/cover600x600.jpeg", 
					"Seven", 
					"Martin Garrix", 
					"28 de octubre de 2016", 
					"Amsterdam"
				));
			}
		});

		// Ruta para listar todos los
		// juegos que se encuentren en la lista.
		get("/listar", (req, res) -> {
        	HashMap<String, Object> model = new HashMap<>();
        	// Ponemos la lista de juegos en el modelo.
        	model.put("discos", disco);
        	return modelAndView(model, "discos/lista.ftl");
		}, new FreeMarkerEngine());
		
		
		
		
		
		
	}

}

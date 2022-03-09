package com.biblioteca;

import com.biblioteca.entidades.Autor;
import com.biblioteca.entidades.Categoria;
import com.biblioteca.entidades.Editorial;
import com.biblioteca.entidades.Libro;
import com.biblioteca.servicios.AutorService;
import com.biblioteca.servicios.CategoriaService;
import com.biblioteca.servicios.EditorialService;
import com.biblioteca.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	
	//INYECTO SERVICIOS
	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EditorialService editorialService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		
		//CREO CATEGORIAS
		Categoria categoria1 = new Categoria("Científicos");
		Categoria categoria2 = new Categoria("Ficción");
		Categoria categoria3 = new Categoria("Poéticos");
		
		//GUARDO CATEGORIAS
		categoriaService.guardarCategoria(categoria1);
		categoriaService.guardarCategoria(categoria2);
		categoriaService.guardarCategoria(categoria3);
		
		//CREO AUTORES
		Autor autor1 = new Autor("J.K. Rowling",date, "Inglaterra");
		Autor autor2 = new Autor("Stephen King",date, "Estados Unidos");
		Autor autor3 = new Autor("Edgar Allan Poe",date, "Estados Unidos");
		Autor autor4 = new Autor("Charles Dickens",date, "Inglaterra");
		
		//GUARDO AUTORES
		autorService.guardarAutor(autor1);
		autorService.guardarAutor(autor2);
		autorService.guardarAutor(autor3);
		autorService.guardarAutor(autor4);
		
		//CREO EDITORIALES
		Editorial editorial1 = new Editorial("Bloomsbury Publishing");
		Editorial editorial2 = new Editorial("Viking Press");
		Editorial editorial3 = new Editorial("The Saturday Evening Post");
		Editorial editorial4 = new Editorial("Richard Bentley");
		
		//GUARDO EDITORIALES
		editorialService.guardarEditorial(editorial1);
		editorialService.guardarEditorial(editorial2);
		editorialService.guardarEditorial(editorial3);
		editorialService.guardarEditorial(editorial4);
		
		//CREO LOS LIBROS
		Libro libro1 = new Libro("Harry Potter", date, autor1, editorial1, categoria1);
		Libro libro2 = new Libro("Misery", date, autor2, editorial2, categoria2);
		Libro libro3 = new Libro("El gato negro", date, autor3, editorial3, categoria3);
		Libro libro4 = new Libro("Oliver Twist", date, autor4, editorial4, categoria1);
		
		//GUARDO LOS LIBROS
		libroService.guardarLibro(libro1);
		libroService.guardarLibro(libro2);
		libroService.guardarLibro(libro3);
		libroService.guardarLibro(libro4);
		
		//MUESTRO LOS DATOS
		autorService.getAutores().forEach(autor -> System.out.println(autor));
		editorialService.getEditoriales().forEach(editorial -> System.out.println(editorial));
		categoriaService.getCategorias().forEach(categoria -> System.out.println(categoria));
		libroService.getLibros().forEach(libro-> System.out.println(libro));

	}
}

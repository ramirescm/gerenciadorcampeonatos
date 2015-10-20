package br.com.gerenciadorcampeonatos.config;

import java.util.HashSet;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * 
 * @author Ramires
 * 
 * O objetivo dessa classe é informar ao servidor de aplicação quais os serviços nós queremos registrar 
 *
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method. It is automatically
	 * populated with all resources defined in the project. If required, comment
	 * out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(br.com.gerenciadorcampeonatos.resource.TimeResource.class);

		resources.add(br.com.gerenciadorcampeonatos.exception.EntityNotFoundExceptionMapper.class);
		resources.add(br.com.gerenciadorcampeonatos.exception.EJBExceptionMapper.class);
		resources.add(br.com.gerenciadorcampeonatos.exception.NotFoundExceptionMapper.class);
	}

}

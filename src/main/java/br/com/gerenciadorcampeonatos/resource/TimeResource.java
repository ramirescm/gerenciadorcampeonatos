package br.com.gerenciadorcampeonatos.resource;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gerenciadorcampeonatos.dto.TimeDTO;
import br.com.gerenciadorcampeonatos.exception.NotFoundException;
import br.com.gerenciadorcampeonatos.mapper.TimeMapper;
import br.com.gerenciadorcampeonatos.modelo.Time;
import br.com.gerenciadorcampeonatos.service.TimeService;

@Path("/times")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class TimeResource {

	// Log
	private final static Logger LOGGER = LoggerFactory.getLogger(TimeResource.class);

	// Permite injetar informação de URI na variável uriInfo
	@Context
	UriInfo uriInfo;

	@Inject
	private TimeService timeService;

	@GET
	public Response buscarTodos() {
		List<Time> times = timeService.buscarTodos();
		if (times == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return Response.ok(TimeMapper.toDTO(times)).build();
		}
	}

	@POST
	public Response adiciona(TimeDTO timeDTO) {
		try {
			Time time = timeService.salvar(TimeMapper.fromDTO(timeDTO));
			// return Response.ok().entity(TimeMapper.toDTO(time)).build();

			URI createdUri = uriInfo.getAbsolutePathBuilder().path(time.getId().toString()).build();

			// return Response.created(URI.create("/times/" +
			// time.getId())).build();
			return Response.created(createdUri).build();
		} catch (Exception ex) {
			LOGGER.error(ex.getLocalizedMessage(), ex);
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar time!").build();
	}

	@PUT
	@Path("{id}")
	public Response atualiza(@PathParam("id") Long id, TimeDTO timeDTO) {
		Time time = timeService.buscarPorId(id);
		if (time == null) {
			throw new NotFoundException("Este time não existe " + id);
		}
		timeService.atualizar(TimeMapper.toEntity(time, timeDTO));
		return Response.ok().entity("Time atualizado com sucesso!").build();
	}

	@GET
	@Path("{id}") 
	public Response buscarPorId(@PathParam("id") Long id) {
		System.out.println("buscarPorId");
		Time time = timeService.buscarPorId(id);
		if (time == null) {
			throw new NotFoundException("Time não encontrado " + id);
		}
		return Response.ok(TimeMapper.toDTO(time)).build();

	}

	@DELETE
	@Path("{id}")
	public Response excluir(@PathParam("id") Long id) {
		try {
			Time time = timeService.buscarPorId(id);
			if (time == null) {
				throw new NotFoundException("Não foi possível excluir o time! Time não encontrado " + id);
			}
			timeService.excluir(time);
			return Response.ok().entity("Registro excluído com sucesso!").build();
		} catch (Exception ex) {
			LOGGER.error(ex.getLocalizedMessage(), ex);
			return Response.status(Response.Status.NOT_FOUND).entity("Registro não encontrado!").build();
		}
	}

}

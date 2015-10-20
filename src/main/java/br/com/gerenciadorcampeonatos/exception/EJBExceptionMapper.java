package br.com.gerenciadorcampeonatos.exception;

import javax.ejb.EJBException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException> {

	@Context
	private Providers providers;

	@Override
	public Response toResponse(EJBException exception) {

		if (exception.getCausedByException() == null) {
			return Response.serverError().build();
		}

		Class cause = exception.getCausedByException().getClass();
		ExceptionMapper mapper = providers.getExceptionMapper(cause);

		if (mapper == null) {
			return Response.serverError().build();
		} else {
			return mapper.toResponse(exception.getCausedByException());
		}

	}

}

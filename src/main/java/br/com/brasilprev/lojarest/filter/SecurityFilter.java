package br.com.brasilprev.lojarest.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

public class SecurityFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> listHeaders = requestContext.getHeaders().get(AUTHORIZATION_HEADER);

		if (listHeaders != null && !listHeaders.isEmpty()) {
			String authToken = listHeaders.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decoded = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decoded, ":");
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();

			if ("user".equals(userName) && "password".equals(password)) {
				return;
			}
		}

		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
				.entity("Access Denied. User not logged in.").build();
		requestContext.abortWith(unauthorizedStatus);
	}

}

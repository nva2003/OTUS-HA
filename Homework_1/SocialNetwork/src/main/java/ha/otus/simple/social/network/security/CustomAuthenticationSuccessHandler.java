package ha.otus.simple.social.network.security;

import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.SysUser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

	@Autowired
	private final UserMapper userMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		SysUser userDTO = userMapper.findByUserName(authentication.getName());
		request.getSession().setAttribute("user", userDTO);

		LOGGER.info("Authentication Success for user " + authentication.getName());

		response.sendRedirect(request.getContextPath() + "/user/profile");
	}

}

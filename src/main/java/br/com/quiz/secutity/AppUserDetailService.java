package br.com.quiz.secutity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.LoginDao;
import br.com.quiz.model.dao.LoginDaoImpl;
import br.com.quiz.model.entidade.Login;

public class AppUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		LoginDao loginDao = new LoginDaoImpl();
		Session sessao = HibernateUtil.abrirSessao();
		UsuarioLogado usuarioLogado = null;
		
		Login loginDB = loginDao.buscaPorLogin(login, sessao);
		
		if (null != loginDB) {
			usuarioLogado = new UsuarioLogado(loginDB, buscaAutorizacao(loginDB));
		} 
		 
		return usuarioLogado;
	}

	private Collection<? extends GrantedAuthority> buscaAutorizacao(Login loginDB) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ADM"));
		
		return authorities;
	}

}

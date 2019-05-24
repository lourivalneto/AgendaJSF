package br.com.agenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Usuario;

@Named("usuarioCtrl")
@RequestScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;

	@Inject
	private UsuarioDAO usuarioDao;

	@Produces
	private List<Usuario> usuarioLista;

	public void Novo() {
		if (usuario != null) {
			usuarioDao.novo(this.usuario);
			this.usuario = new Usuario();
			// PrimeFaces.current().executeScript("PF('dlg1').show();");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso", "Adicionado"));
		}
	}

	@PostConstruct
	private void init(){
 
		this.usuarioLista = usuarioDao.lista();
	}
	public List<Usuario> Listar() {
		
		return this.usuarioLista = new UsuarioDAO().lista();

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public List<Usuario> getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(List<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}

}

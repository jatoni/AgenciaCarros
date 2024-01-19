package com.mx.web.app.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mx.web.app.entity.Correo;
import com.mx.web.app.entity.Telefono;
import com.mx.web.app.entity.Usuario;

@Named
@SessionScoped
public class UsuarioVistaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7648449335821722744L;

	private Map<Long, Usuario> usuarios;

	private Usuario usuarioSeleccionado;

	private List<Usuario> usuariosSeleccionados;

	@PostConstruct
	public void unit() {
		this.usuarioSeleccionado = new Usuario();
		List<Correo> correosUsuario1 = new ArrayList<>();
		List<Telefono> telefonosUsuario1 = new ArrayList<>();
		List<Correo> correosUsuario2 = new ArrayList<>();
		List<Telefono> telefonosUsuario2 = new ArrayList<>();

		correosUsuario1.add(new Correo(1L, "juan@gmail.com"));
		correosUsuario1.add(new Correo(2L, "carlos@gmail.com"));
		correosUsuario1.add(new Correo(3L, "jazziel@gmail.com"));
		correosUsuario1.add(new Correo(4L, "jair@gmail.com"));
		telefonosUsuario1.add(new Telefono(1L, "5598422985"));
		telefonosUsuario1.add(new Telefono(2L, "5587239812"));
		telefonosUsuario1.add(new Telefono(3L, "5687230921"));

		correosUsuario2.add(new Correo(1L, "juan@gmail.com"));
		correosUsuario2.add(new Correo(2L, "carlos@gmail.com"));
		correosUsuario2.add(new Correo(3L, "jazziel@gmail.com"));
		correosUsuario2.add(new Correo(4L, "jair@gmail.com"));
		telefonosUsuario2.add(new Telefono(1L, "5598422985"));
		telefonosUsuario2.add(new Telefono(2L, "5587239812"));
		telefonosUsuario2.add(new Telefono(3L, "5687230921"));

		this.usuarios = new HashMap<>();
		this.usuarios.put(1L, new Usuario(1L, "Juan123", "Sargento", "Juan", "Antonio", "Torres", correosUsuario1,
				telefonosUsuario1));
		this.usuarios.put(2L, new Usuario(2L, "Carlos123", "Sargento", "Carlos", "Antonio", "Torres", correosUsuario2,
				telefonosUsuario2));
	}

	public void handleUsuarioSeleccionado(Usuario usuario) {
		// setUsuarioSeleccionado(usuario);
		getUsuarioSeleccionado().setNombre(usuario.getNombre());
		System.out.println(getUsuarioSeleccionado().getNombre());

	}

	public List<Usuario> obtenerListUsuarios() {
		return new ArrayList<>(this.usuarios.values());
	}

	/**
	 * @return the usuarios
	 */
	public Map<Long, Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Map<Long, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the usuarioSeleccionado
	 */
	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	/**
	 * @param usuarioSeleccionado the usuarioSeleccionado to set
	 */
	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	/**
	 * @return the usuariosSeleccionados
	 */
	public List<Usuario> getUsuariosSeleccionados() {
		return usuariosSeleccionados;
	}

	/**
	 * @param usuariosSeleccionados the usuariosSeleccionados to set
	 */
	public void setUsuariosSeleccionados(List<Usuario> usuariosSeleccionados) {
		this.usuariosSeleccionados = usuariosSeleccionados;
	}

}

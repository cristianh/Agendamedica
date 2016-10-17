package eam.desarrollo.agenda.interfaces;

import eam.desarollo.agenda.modelo.Profesional;

public interface IntProfesional {

	public abstract void crear(Profesional pro) throws Exception;
	public abstract Profesional buscar(int identificacion) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Profesional pro) throws Exception;
	public abstract void listarProfesional(Profesional pro) throws Exception;
}

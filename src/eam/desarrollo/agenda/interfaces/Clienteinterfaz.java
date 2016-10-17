/**
 * 
 */
package eam.desarrollo.agenda.interfaces;

import eam.desarollo.agenda.modelo.Cliente;

/**
 * @author Cristianh
 *
 */
public interface Clienteinterfaz {

	public Cliente crear_nuevoCliente();
	public boolean buscar_Cliente();
	public boolean actualizar_Cliente();
	public void eliminar_Cliente();
}

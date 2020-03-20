/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author phant
 */
public interface IDAO {
    public boolean agregar(Object obj);
    public boolean eliminar(Object obj);
    public boolean actualizar(Object obj);
    public boolean buscar(Object obj);
    public Object get(Object obj);
    public List getAll();
}

package ar.edu.unju.edm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Ventas;
@Repository
public interface IVentasDAO extends CrudRepository<Ventas, Integer>{

}
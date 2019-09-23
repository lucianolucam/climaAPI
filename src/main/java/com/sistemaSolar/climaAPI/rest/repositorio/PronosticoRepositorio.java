package com.sistemaSolar.climaAPI.rest.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistemaSolar.climaAPI.domain.entidad.InfoClima;

@Repository
public interface PronosticoRepositorio extends JpaRepository<InfoClima, Integer> {
	
	@Query("select count(*) from InfoClima if where if.tipoClima = 'SEQUIA'")
    public long periodosDeSequia();

    @Query("select count(*) from InfoClima if where if.tipoClima = 'LLUVIA'")
    public long periodosDeLluvia();

    @Query("select count(*) from InfoClima if where if.tipoClima = 'CONDICIONES_OPTIMAS' ")
    public long periodosDeCondicionesOptimas();

    @Query("select dia from InfoClima where precipitacion = (select coalesce(max(fi.precipitacion), 0) from InfoClima fi where fi.tipoClima = 'LLUVIA')")
    public List<Integer> periodosMasLluviosos();

}

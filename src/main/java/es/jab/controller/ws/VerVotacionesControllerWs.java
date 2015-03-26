package es.jab.controller.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import es.jab.controller.VerVotacionesController;
import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;
import es.jab.persistence.model.entities.dto.TemaDTO;
import es.jab.persistence.model.utils.NivelEstudios;

public class VerVotacionesControllerWs implements VerVotacionesController {

	@Override
	public List<TemaDTO> recuperarVotaciones() {
		GenericType <List<Tema>> genericTypeTema = new GenericType<List<Tema>>() {};
		GenericType <List<Valoracion>> genericTypeValoracion = new GenericType<List<Valoracion>>() {};
		List<Tema> temas = ControllerWs.buildWebServiceManager("/temas").entities(genericTypeTema);

		Map<Tema,List<Valoracion>> listaValoracionesPorTema = new HashMap<Tema, List<Valoracion>>();

		for(Tema tema : temas){
			List<Valoracion> valoraciones = ControllerWs.buildWebServiceManager("/valoraciones" + "/byTema", String.valueOf(tema.getId())).entities(genericTypeValoracion);
			listaValoracionesPorTema.put(tema, valoraciones);

		}

		Map<NivelEstudios, Double> nivelesEstudios = new HashMap<NivelEstudios, Double>();
		for(NivelEstudios nivel : new ArrayList<NivelEstudios>(Arrays.asList(NivelEstudios.values()))){
			nivelesEstudios.put(nivel, new Double(0));
		}

		Map<NivelEstudios, Double> nivelesEstudiosBack = new HashMap<NivelEstudios, Double>(nivelesEstudios);

		List<TemaDTO> valoracionesDTO = new ArrayList<TemaDTO>();
		for(Tema tema : listaValoracionesPorTema.keySet()){
			List<Valoracion> valoraciones = listaValoracionesPorTema.get(tema);
			TemaDTO valoracionDTO;
			int totalValoraciones = 0;
			for(Valoracion valoracion : valoraciones){
				double sumaValoracionesPorNivel = nivelesEstudios.get(valoracion.getNivelEstudios()).doubleValue();
				sumaValoracionesPorNivel += valoracion.getRespuesta();
				nivelesEstudios.put(valoracion.getNivelEstudios(), new Double(sumaValoracionesPorNivel));
				totalValoraciones ++;
			}
			List<Double> listaMedias = new ArrayList<Double>(nivelesEstudios.values());
			valoracionDTO = new TemaDTO(tema.getNombre(), tema.getPregunta(), totalValoraciones, listaMedias);
			nivelesEstudios = nivelesEstudiosBack;
			valoracionesDTO.add(valoracionDTO);
		}
		return valoracionesDTO;
	}

}

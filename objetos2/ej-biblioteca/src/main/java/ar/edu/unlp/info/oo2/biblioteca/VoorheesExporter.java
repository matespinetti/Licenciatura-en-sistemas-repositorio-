package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;
import org.json.simple.*;

public class VoorheesExporter {

	private JSONObject exportar(Socio socio) {
		JSONObject socioObject = new JSONObject();
		socioObject.put("nombre", socio.getNombre());
		socioObject.put("email", socio.getEmail());
		socioObject.put("legajo", socio.getLegajo());
		return socioObject;
	}

	public String exportar(List<Socio> socios) {
		if (socios.isEmpty()) {
			return "[]";
		}
		JSONArray res = new JSONArray();
		for (Socio socio: socios){
			JSONObject socioObj = exportar(socio);
			res.add(socioObj);
		}
		return res.toJSONString();
	}
}

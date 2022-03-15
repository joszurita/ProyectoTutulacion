/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.ejemploImprimir.Controller;

import com.yavirac.ejemploImprimir.Commons.Enum.TipoReporteEnum;
import com.yavirac.ejemploImprimir.Model.Acta;
import com.yavirac.ejemploImprimir.Model.ActaDAO;
import com.yavirac.ejemploImprimir.Repository.Service.ActaReporte;
import com.yavirac.ejemploImprimir.Repository.Service.ActaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import net.sf.jasperreports.engine.JRException;


/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/acta")
public class ActaController {
    @Autowired
    ActaService actaService;
    @Autowired
    ActaReporte actaReporte;
    
    @GetMapping({"/lista","","/"})
    public List<Acta> findAll()
    {
        return actaService.findAll();
    }
    /**Read */
    @GetMapping("/{id}")
    public Acta findById(@PathVariable long id)
    {
        return actaService.findById(id);
    }
    /**Create */
    @PostMapping("/save")
    public Acta save(@RequestBody Acta acta)
    {
        return actaService.save(acta);
    }
    /**Update */
    @PutMapping("/update")
    public Acta update(@RequestBody Acta acta)
    {
        return actaService.save(acta);
    }
    
    /**Delete */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        actaService.deleteById(id);
    }
    
    @GetMapping(path = "/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ActaDAO dto = actaReporte.obtenerActa(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
}

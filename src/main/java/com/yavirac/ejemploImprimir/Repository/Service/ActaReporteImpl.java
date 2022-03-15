/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.ejemploImprimir.Repository.Service;

import com.yavirac.ejemploImprimir.Commons.Enum.TipoReporteEnum;
import com.yavirac.ejemploImprimir.Commons.JasperReportManager;
import com.yavirac.ejemploImprimir.Model.ActaDAO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class ActaReporteImpl implements ActaReporte{
    @Autowired
    private JasperReportManager reportManager;
    @Autowired
    private DataSource dataSource;

   @Override
	public ActaDAO obtenerActa(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "actaReporte";
		ActaDAO dto = new ActaDAO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}
    
}

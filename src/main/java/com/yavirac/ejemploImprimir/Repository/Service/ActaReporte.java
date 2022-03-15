/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.ejemploImprimir.Repository.Service;

import com.yavirac.ejemploImprimir.Model.ActaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author josue
 */
public interface ActaReporte {
    ActaDAO obtenerActa(Map<String, Object> params)throws JRException, IOException, SQLException;
}

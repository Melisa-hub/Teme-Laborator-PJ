package org.example;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class MasinaMapper implements RowMapper<Masina> {
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Masina masina = new Masina();
        masina.setNumar_inmatriculare(rs.getInt("numar_inmatriculare"));
        masina.setMarca(rs.getString("marca"));
        masina.setAnul_fabricatiei(rs.getInt("anul_fabricatiei"));
        masina.setCuloare(rs.getString("culoare"));
        masina.setNr_kilometri(rs.getInt("nr_kilometri"));
        return masina;
    }


}
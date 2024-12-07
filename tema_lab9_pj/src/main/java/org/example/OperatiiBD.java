package org.example;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
class OperatiiBD {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void insert(int numar_inmatriculare, String marca,  int anul_fabricatiei, String culoare,int nr_kilometri) {
        String SQL = "insert into masini (numar_inmatriculare, marca, anul_fabricatiei, culoare,nr_kilometri ) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, numar_inmatriculare, marca, anul_fabricatiei, culoare, nr_kilometri);
    }

    public void delete(int numar_inmatriculare){
        String SQL = "delete from masini where numar_inmatriculare = ?";
        jdbcTemplateObject.update(SQL, numar_inmatriculare);
    }


    public Masina getMasina(int numar_inmatriculare) {
        String SQL = "select * from masini where numar_inmatriculare = ?";
        Masina masina = jdbcTemplateObject.queryForObject(SQL,new Object[]{numar_inmatriculare},
                new MasinaMapper());
        return masina;
    }


    public List<Masina> getListaMasini() {
        String SQL = "select * from masini";
        List <Masina> masini = jdbcTemplateObject.query(SQL,new MasinaMapper());
        return masini;
    }

}
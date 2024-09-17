package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.MilharExtra;
import org.logcod.lojajogos.service.CompraService;

public class MilharExtraRepository {

    private static Connection connection;
    private ContextConfigDataSource dataSource;

    public MilharExtraRepository() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }
    
    public boolean enviarMilharExtra(MilharExtra me){
        try {
            PreparedStatement ps = connection
                    .prepareStatement("insert into milhar_extra values (?,?)");
            ps.setObject(1, me.getCompra().getIdCompra());
            ps.setObject(2, me.getNumero());
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    public Set<MilharExtra> buscarMilharExtraPorNumero(String numero){
        try {
            PreparedStatement ps = connection
                    .prepareStatement("select * from milhar_extra me where me.numero_extra like ?");
            ps.setObject(1, "%"+numero+"%");
            Set<MilharExtra> buscarMilharExtra = new LinkedHashSet<>();
            ResultSet rs = ps.executeQuery();
            CompraService cs = new CompraService();
            while(rs.next()){
                MilharExtra me = new MilharExtra(cs.obterCompra(rs.getInt("idcompra")), rs.getString("numero_extra"));
                buscarMilharExtra.add(me);
            }
            return buscarMilharExtra;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    public Set<MilharExtra> buscarMilharExtraPorId(int numero){
        try {
            PreparedStatement ps = connection
                    .prepareStatement("select * from milhar_extra me where me.idcompra = ?");
            ps.setObject(1, numero);
            Set<MilharExtra> buscarMilharExtra = new LinkedHashSet<>();
            ResultSet rs = ps.executeQuery();
            CompraService cs = new CompraService();
            while(rs.next()){
                MilharExtra me = new MilharExtra(cs.obterCompra(rs.getInt("idcompra")), rs.getString("numero_extra"));
                buscarMilharExtra.add(me);
            }
            return buscarMilharExtra;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }


}

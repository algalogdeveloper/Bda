/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.logcod.lojajogos.controller.subcontroller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Rota;
import org.logcod.lojajogos.relatorio.FabricaRelatorios;
import org.logcod.lojajogos.repository.RepositoryRota;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.RotaService;

public class BuscarPaginasPDF implements Action {

    RotaService rs = new RotaService(new RepositoryRota());
    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
             Rota r = rs.buscarRotasAS(Integer.parseInt(request.getParameter("rota")));
            Document d = new Document(PageSize.A4);
            d.setPageCount(r.getLocais().size());
            d.setMargins(15, 15, 15, 15);
            PdfWriter.getInstance(d, response.getOutputStream());
            d.addAuthor("Lrt, Serviços de Informatica");
            d.addTitle("Todos clientes por rota de endereços");
            
            d.open();
            if (!r.getLocais().isEmpty()) {
                for (Local e : r.getLocais()) {
                    d.newPage();
                    Paragraph p = new Paragraph("LOCAL DE COBRANÇA: " + e.getDescricao().toUpperCase() + "");
                    float[] pointColumnWidths = {150F, 150F, 150F};
                    PdfPTable table = new PdfPTable(pointColumnWidths);
                    table.setWidthPercentage(100);
                    PdfPCell col = new PdfPCell();
                    col.setColspan(3);
                    col.setPadding(2);
                    col.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    col.addElement(new Phrase(p));
                    table.addCell(col);
                    table.addCell(new PdfPCell(new Phrase("Cliente")));
                    table.addCell(new PdfPCell(new Phrase("Valor")));
                    table.addCell(new PdfPCell(new Phrase("Anotações")));
                    Collection<Compra> lista = cs.selecionarComprasPeloSeuEnderecoDeCadastro(String.valueOf(e.getIdLocal()));
                    for (Compra c : lista) {
                        table.addCell(new PdfPCell(new Phrase(c.getPessoa().getNome())));
                        table.addCell(new PdfPCell(new Phrase(FabricaRelatorios.formatarValor(c.getValor()))));
                        table.addCell(new PdfPCell(new Phrase("")));

                    }
                    d.add(table);
                }
            }
            d.close();
        } catch (Exception e) {
        }

        return "controller?operacao=UIRotasPorPagina";
    }

}

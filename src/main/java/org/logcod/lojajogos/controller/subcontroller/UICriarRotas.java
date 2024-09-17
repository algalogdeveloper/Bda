package org.logcod.lojajogos.controller.subcontroller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
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

public class UICriarRotas implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            RotaService rs = new RotaService(new RepositoryRota());
            String rota = request.getParameter("rota");
            Rota r = rs.buscarRotasAS(Integer.parseInt(rota));
            if (!r.getLocais().isEmpty()) {
                gerarPdf(response, r.getLocais());
            }
        } catch (Exception e) {

        }
        return "controller?operacao=UIRotas";
    }

    public void gerarPdf(HttpServletResponse r, Collection<Local> enderecosCompessoas) {
        try {
            CompraService cs = new CompraService();
            Document document = new Document(PageSize.A4);
            document.setMargins(15, 15, 15, 15);
            document.setMarginMirroring(true);
            PdfWriter.getInstance(document, r.getOutputStream());
            document.addAuthor("Lrt-Serviços");
            document.addTitle("Todos clientes por endereço");
            document.open();
            Font fonte = new Font(Font.getFamily("Ubuntu"), 10, 0);
            Font f = new Font(Font.FontFamily.TIMES_ROMAN, 12, 1);

            for (Local e : enderecosCompessoas) {
                Collection<Compra> compras = cs.selecionarComprasPeloSeuEnderecoDeCadastro(String.valueOf(e.getIdLocal()));

                if (compras.size() >= 100) {
                    document.newPage();
                }
                float[] pointColumnWidths = {150F, 150F, 150F};
                PdfPTable table = new PdfPTable(pointColumnWidths);
                table.setWidthPercentage(100);
                Paragraph p = new Paragraph(new Phrase("LOCAL: " + e.getDescricao().toUpperCase(), f));
                PdfPCell col = new PdfPCell();
                col.setColspan(3);
                col.setPadding(2);
                col.setBackgroundColor(BaseColor.LIGHT_GRAY);
                col.addElement(new Phrase(p));
                table.addCell(col);
                table.addCell(new PdfPCell(new Phrase("Cliente", f)));
                table.addCell(new PdfPCell(new Phrase("Valor", f)));
                table.addCell(new PdfPCell(new Phrase("Anotações", f)));
                for (Compra c : compras) {
                    table.addCell(new PdfPCell(new Phrase(c.getPessoa().getNome(), fonte)));
                    table.addCell(new PdfPCell(new Phrase(FabricaRelatorios.formatarValor(c.getValor()), fonte)));
                    table.addCell(new PdfPCell(new Phrase("", fonte)));
                }
                document.add(table);
            }
            document.close();
        } catch (Exception e) {
            System.out.println("Relatorio nao gerado: " + e);
        }

    }

}

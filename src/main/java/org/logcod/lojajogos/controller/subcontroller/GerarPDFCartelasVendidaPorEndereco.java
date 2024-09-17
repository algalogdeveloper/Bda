package org.logcod.lojajogos.controller.subcontroller;

import java.text.NumberFormat;
import java.util.Collection;
//import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.bean.BeanRelatorioPDFVenda;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.LocalService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarPDFCartelasVendidaPorEndereco implements Action {

    CompraService cs = new CompraService();
    LocalService localService = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            Document document = new Document(PageSize.A4);
            document.setMargins(15, 15, 15, 15);
            document.setMarginMirroring(true);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            Paragraph pth = new Paragraph(new Phrase("Sistema de Cobrança de Rifas - BDA".toUpperCase()));
            pth.setAlignment(1);
            Paragraph pth3 = new Paragraph(new Phrase("Plataforma Bolão de Acupe"));
            pth3.setAlignment(1);
            Paragraph pth2 = new Paragraph(new Phrase("__________________________________________________________________________________"));
            pth.setAlignment(1);

            Paragraph texto1 = new Paragraph(new Phrase("Lista de Cobrança -  Em aberto".toUpperCase()));
            texto1.setAlignment(1);
            texto1.setSpacingAfter(20);

            @SuppressWarnings("deprecation")
            String path = request.getRealPath("/img/pdf.png");
            Image image = Image.getInstance(path);
            image.scaleToFit(50, 50);
            image.setAlignment(1);
            document.add(image);
            document.add(pth);
            document.add(pth3);
            document.add(pth2);
            document.add(texto1);
            Font font = FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, new BaseColor(BaseColor.BLACK.getRGB()));
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("id", font));
            cell.setFixedHeight(10);
            cell.setBorderWidth(5);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);
            PdfPCell cell2 = new PdfPCell(new Phrase("Cliente", font));
            cell2.setFixedHeight(30);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setColspan(2);
            table.addCell(cell2);

            PdfPCell cell5 = new PdfPCell(new Phrase("Valor", font));
            cell5.setFixedHeight(30);
            cell5.setBorder(Rectangle.NO_BORDER);
            cell5.setColspan(2);
            table.addCell(cell5);
            PdfPCell cell3 = new PdfPCell(new Phrase("Endereço", font));
            cell3.setFixedHeight(30);
            cell3.setBorder(Rectangle.NO_BORDER);
            cell3.setColspan(2);
            table.addCell(cell3);
            PdfPCell cell4 = new PdfPCell(new Phrase("Números", font));
            cell4.setFixedHeight(30);
            cell4.setBorder(Rectangle.NO_BORDER);
            cell4.setColspan(2);
            table.addCell(cell4);
            List<Compra> compras = cs.joinEnderecoPessoaCompraApostaGerandoPdfEmaberto();
            int count = 0;
            for (Compra c : compras) {
                PdfPCell row = new PdfPCell(new Phrase("" + c.getIdCompra(), font));
                row.setFixedHeight(10);
                row.setBorderWidth(10);
                row.setBorder(Rectangle.NO_BORDER);
                row.setColspan(2);
                table.addCell(row);
                PdfPCell row2 = new PdfPCell(new Phrase("" + c.getPessoa().getNome(), font));
                row2.setFixedHeight(30);
                row2.setBorder(Rectangle.NO_BORDER);
                row2.setColspan(2);
                table.addCell(row2);
                PdfPCell row5 = new PdfPCell(new Phrase("" + c.getValor(), font));
                row5.setFixedHeight(30);
                row5.setBorder(Rectangle.NO_BORDER);
                row5.setColspan(2);
                table.addCell(row5);

                PdfPCell row3 = new PdfPCell(new Phrase("" + c.getPessoa().getLocal().getDescricao(), font));
                row3.setFixedHeight(30);
                row3.setBorder(Rectangle.NO_BORDER);
                row3.setColspan(2);
                table.addCell(row3);
                List<Aposta> array = (List<Aposta>) c.getApostas();
                System.out.println(array);
                PdfPCell row4 = new PdfPCell(criarTableModificada(array));
                row4.setFixedHeight(30);
                row4.setBorder(Rectangle.NO_BORDER);
                row4.setColspan(2);
                table.addCell(row4);
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return "controller?operacao=PainelAdministrativo";
    }

    public PdfPTable criarTableModificada(List<?> list)
            throws DocumentException {
        PdfPTable table = new PdfPTable(list.size());
        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, Font.BOLD, new BaseColor(BaseColor.BLACK.getRGB()));
        for (int i = 0; i < list.size(); i++) {
            Aposta aposta = (Aposta) list.get(i);
            PdfPCell cell = new PdfPCell(new Phrase(aposta.getMilhar().getValue(), font));
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);

        }
        return table;

    }

}

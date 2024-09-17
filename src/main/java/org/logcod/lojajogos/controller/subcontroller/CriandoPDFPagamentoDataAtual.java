package org.logcod.lojajogos.controller.subcontroller;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CriandoPDFPagamentoDataAtual implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CompraService cs = new CompraService();
            Document document = new Document(PageSize.A4);
            document.setMargins(15, 15, 15, 15);
            document.setMarginMirroring(true);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Paragraph pth = new Paragraph(new Phrase("Plataforma L.r.t Serviços de Cobrança & Venda de rifas"));
            pth.setAlignment(1);
            //pth.setSpacingBefore(10);
            //pth.setSpacingAfter(10);
            Paragraph texto1 = new Paragraph(new Phrase("Lista de pagamentos"));
            texto1.setAlignment(1);
            texto1.setSpacingAfter(10);
            texto1.setIndentationLeft(20);
            Paragraph pth3 = new Paragraph(new Phrase(""));
            pth3.setAlignment(1);

            Paragraph texto2 = new Paragraph(new Phrase("Data de geração do relatório:" + DataSourceUtil.formatarDataViewCalendar(Calendar.getInstance())));
            texto2.setSpacingAfter(10);
            texto2.setAlignment(1);
            @SuppressWarnings("deprecation")
            String path = request.getRealPath("/img/pdf.png");
            Image image = Image.getInstance(path);
            image.setAlignment(1);
            image.setPaddingTop(3);
            image.setSpacingBefore(20);
            image.setSpacingAfter(20);
            image.setBorderWidth(2);
            image.scaleToFit(30, 30);
            document.add(pth);
            document.add(pth3);
            document.add(texto1);
            document.add(image);
            document.add(texto2);
            document.add(criarTableModificada2(cs.vizualizarPagamentosDoDia()));
            document.close();
        } catch (Exception e) {
            return "controller?operacao=ConsultarPagamentosDoDia";
        }
        return "controller?operacao=ConsultarPagamentosDoDia";
    }

    private void bordarTo(PdfPCell cell1, PdfPCell cell2, PdfPCell cell3, PdfPCell cell4, PdfPCell cell5) {
        cell1.setBorderWidthLeft(1);
        //cell1.setColspan(0);
        cell1.setBorderWidthRight(1);
        cell1.setBorderWidthTop(1);
        cell1.setBorderWidthBottom(1);

        //cell2.setColspan(0);
        cell2.setBorderWidthLeft(0);
        cell2.setBorderWidthRight(1);
        cell2.setBorderWidthTop(1);
        cell2.setBorderWidthBottom(1);

        //cell3.setColspan(0);
        cell3.setBorderWidthLeft(0);
        cell3.setBorderWidthRight(1);
        cell3.setBorderWidthTop(1);
        cell3.setBorderWidthBottom(1);

        //	cell4.setColspan(0);
        cell4.setBorderWidthLeft(0);
        cell4.setBorderWidthRight(1);
        cell4.setBorderWidthTop(1);
        cell4.setBorderWidthBottom(1);

        //	cell5.setColspan(0);
        cell5.setBorderWidthLeft(0);
        cell5.setBorderWidthRight(1);
        cell5.setBorderWidthTop(1);
        cell5.setBorderWidthBottom(1);

    }

    public PdfPTable criarTableModificada2(List<Compra> listaOrdenadas) throws DocumentException {
        PdfPTable table = new PdfPTable(5);
        table.setWidths(new int[]{3, 10, 4, 6, 4});
        Font f = FontFactory.getFont(FontFactory.HELVETICA, Font.DEFAULTSIZE, Font.BOLD, new BaseColor(BaseColor.BLACK.getRGB()));

        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        PdfPCell cellIdenf = new PdfPCell(new Phrase("Chave", f));
        //	cellIdenf.setColspan(0);
        cellIdenf.setBorderWidthLeft(0);
        cellIdenf.setBorderWidthRight(1);
        cellIdenf.setBorderWidthTop(1);
        cellIdenf.setBorderWidthBottom(1);

        PdfPCell cellNome = new PdfPCell(new Phrase("Pessoa", f));
        //cellNome.setColspan(0);
        cellNome.setBorderWidthLeft(0);
        cellNome.setBorderWidthRight(1);
        cellNome.setBorderWidthTop(1);
        cellNome.setBorderWidthBottom(1);

        PdfPCell cellValor = new PdfPCell(new Phrase("R$ Valor", f));
        //	cellValor.setColspan(0);
        cellValor.setBorderWidthLeft(0);
        cellValor.setBorderWidthRight(1);
        cellValor.setBorderWidthTop(1);
        cellValor.setBorderWidthBottom(1);

        PdfPCell cellFunc = new PdfPCell(new Phrase("Funcionario", f));
        //cellFunc.setColspan(0);
        cellFunc.setBorderWidthLeft(0);
        cellFunc.setBorderWidthRight(1);
        cellFunc.setBorderWidthTop(1);
        cellFunc.setBorderWidthBottom(1);

        PdfPCell cellPagou = new PdfPCell(new Phrase("Situação", f));
        //	cellPagou.setColspan(0);
        cellPagou.setBorderWidthLeft(0);
        cellPagou.setBorderWidthRight(1);
        cellPagou.setBorderWidthTop(1);
        cellPagou.setBorderWidthBottom(1);

        bordarTo(cellIdenf, cellNome, cellValor, cellFunc, cellPagou);
        table.addCell(cellIdenf);
        table.addCell(cellNome);
        table.addCell(cellValor);
        table.addCell(cellFunc);
        table.addCell(cellPagou);

        for (Compra venda : listaOrdenadas) {
            PdfPCell item0 = new PdfPCell(new Phrase(venda.getNumero_cartela()));
            //item0.setBorderColor(BaseColor.LIGHT_GRAY);
            PdfPCell item1 = new PdfPCell(new Phrase(venda.getPessoa().getNome()));
            //item1.setBorderColor(BaseColor.LIGHT_GRAY);
            PdfPCell item2 = new PdfPCell(new Phrase("" + NumberFormat.getCurrencyInstance().format(+venda.getValor())));
            //item2.setBorderColor(BaseColor.LIGHT_GRAY);
            PdfPCell item3 = new PdfPCell(new Phrase(venda.getFuncionario().getNome()));
            //	item3.setBorderColor(BaseColor.LIGHT_GRAY);
            PdfPCell item4 = new PdfPCell(new Phrase((venda.isPagou()) ? "Concluído" : "Em aberto"));
            //		item4.setBorderColor(BaseColor.LIGHT_GRAY);
            table.addCell(item0);
            table.addCell(item1);
            table.addCell(item2);
            table.addCell(item3);
            table.addCell(item4);

        }

        return table;

    }

}

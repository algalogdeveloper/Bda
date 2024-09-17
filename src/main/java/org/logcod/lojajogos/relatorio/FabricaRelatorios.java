package org.logcod.lojajogos.relatorio;

import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.LocalService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FabricaRelatorios {

    public static void carregarRelatorioDisplayView(HttpServletResponse response, HttpServletRequest request,
            String endereco) {
        try {
            LocalService localService = new LocalService();
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            String logo = request.getRealPath("/img/lrt-logo.jpeg");
            System.out.println(logo);
            URL url = new URL("https://cdn-icons-png.flaticon.com/128/3143/3143460.png");
            Image image = Image.getInstance(logo);
            image.scaleToFit(40, 40);
            image.setAlignment(1);
            document.add(image);

            Font foTitle = new Font(FontFamily.UNDEFINED, 11, Font.BOLD, BaseColor.BLACK);
            Paragraph title = new Paragraph(
                    new Phrase("Plataforma L.r.t Serviços de Cobrança & Venda de rifas".toUpperCase(), foTitle));
            title.setAlignment(1);
            document.add(title);
            document.addAuthor("leandro de Souza");
            document.addTitle("Plataforma de Gestão de Rifas");
            document.addSubject("L.r.t Serviços");
            Font fonteEnd = new Font(FontFamily.UNDEFINED, 15, Font.BOLD, BaseColor.RED);

            Paragraph subTitle = new Paragraph("Lista de cobrança em aberto do(a):".toUpperCase()
                    + new Phrase(localService.get(Integer.valueOf(endereco)).getDescricao().toUpperCase(), fonteEnd));
            subTitle.setAlignment(1);
            subTitle.setSpacingBefore(2);
            subTitle.setSpacingAfter(2);
            document.add(subTitle);

            document.add(createTable(endereco));
            Paragraph dataHoje = new Paragraph(new Paragraph("Data documento :".toUpperCase()
                    + new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime())));
            dataHoje.setSpacingAfter(5);
            dataHoje.setAlignment(1);
            document.add(dataHoje);
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void carregarRelatorioDisplayViewSemMilhar(HttpServletResponse response, HttpServletRequest request,
            String endereco) {
        try {
            LocalService localService = new LocalService();
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            String logo = request.getRealPath("/img/lrt-logo.jpeg");
            Image image = Image.getInstance(logo);
            image.scaleToFit(30, 30);
            image.setAlignment(1);
            if (Objects.nonNull(image)) {
                document.add(image);
            }
            Font foTitle = new Font(FontFamily.UNDEFINED, 11, Font.BOLD, BaseColor.BLACK);
            Paragraph title = new Paragraph(
                    new Phrase("Plataforma L.r.t Serviços de Cobrança & Venda de rifas".toUpperCase(), foTitle));
            title.setAlignment(1);
            document.add(title);
            document.addAuthor("leandro de Souza");
            document.addTitle("Plataforma de Gestão de Rifas");
            document.addSubject("L.r.t Serviços");
            Font fonteEnd = new Font(FontFamily.UNDEFINED, 13, Font.BOLD, BaseColor.BLACK);

            Paragraph subTitle = new Paragraph(
                    "Rua:".toUpperCase() + new Phrase(localService.get(Integer.valueOf(endereco)).getDescricao()),
                    fonteEnd);
            subTitle.setAlignment(0);
            subTitle.setSpacingBefore(5);
            subTitle.setSpacingAfter(5);
            document.add(subTitle);

            document.add(createTableSemMilhar(endereco));

            Paragraph dataHoje = new Paragraph(new Paragraph("Data de geração do documento :"
                    + new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()), foTitle));
            dataHoje.setSpacingAfter(5);
            dataHoje.setAlignment(0);
            document.add(dataHoje);

            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String formatarValor(double valor) {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat format = NumberFormat.getCurrencyInstance(localeBR);
        return format.format(valor);
    }

    public static PdfPTable createTable(String endereco) throws DocumentException {
        float[] pointColumnWidths = {120F, 150F, 150F};
        PdfPTable pdfPTable = new PdfPTable(pointColumnWidths);
        pdfPTable.setWidths(new int[]{4, 3, 8});
        pdfPTable.setWidthPercentage(100);
        Font fo = new Font(FontFamily.UNDEFINED, 10, Font.BOLD, BaseColor.BLACK);
        Font foTop = new Font(FontFamily.UNDEFINED, 11, Font.BOLD, BaseColor.WHITE);
        PdfPCell column = new PdfPCell(new Paragraph("Números".toUpperCase(), foTop));
        column.setBackgroundColor(BaseColor.GRAY);
        column.setBorderWidthBottom(1);
        column.setBorderWidthTop(1);
        column.setBorderWidthLeft(1);
        column.setBorderWidthRight(1);
        column.setBorderColor(BaseColor.GRAY);
        column.setHorizontalAlignment(1);
        column.setPadding(3);
        PdfPCell column2 = new PdfPCell(new Paragraph("R$ Valor".toUpperCase(), foTop));
        column2.setBackgroundColor(BaseColor.GRAY);
        column2.setBorderWidthBottom(1);
        column2.setBorderWidthTop(1);
        column2.setBorderWidthLeft(0);
        column2.setBorderWidthRight(0);
        column2.setBorderColor(BaseColor.GRAY);
        column2.setPadding(3);

        PdfPCell column3 = new PdfPCell(new Paragraph("Cliente".toUpperCase(), foTop));
        column3.setBackgroundColor(BaseColor.GRAY);
        column3.setBorderWidthBottom(1);
        column3.setBorderWidthTop(1);
        column3.setBorderWidthLeft(1);
        column3.setBorderWidthRight(1);
        column3.setBorderColor(BaseColor.GRAY);
        column3.setPadding(3);
        // add colunm

        pdfPTable.addCell(column3);
        pdfPTable.addCell(column2);
        pdfPTable.addCell(column);

        CompraService compraService = new CompraService();
        Collection<Compra> compras = compraService.selecionarComprasPeloSeuEnderecoDeCadastro(endereco);
        int i = 0;
        for (Compra c : compras) {
            i++;
            PdfPCell columnadd = new PdfPCell(
                    new Paragraph(c.getApostas().toString().replace("[", "").replace("]", ""), fo));
            columnadd.setBorderWidthBottom(1);
            columnadd.setBorderWidthTop(0);
            columnadd.setBorderWidthLeft(1);
            columnadd.setBorderWidthRight(1);
            columnadd.setBorderColor(BaseColor.GRAY);
            columnadd.setPadding(3);

            PdfPCell columnadd2 = new PdfPCell(new Paragraph(formatarValor(c.getValor()), fo));
            columnadd2.setBorderWidthBottom(1);
            columnadd2.setBorderWidthTop(0);
            columnadd2.setBorderWidthLeft(0);
            columnadd2.setBorderWidthRight(0);
            columnadd2.setBorderColor(BaseColor.GRAY);
            columnadd2.setPadding(3);

            PdfPCell columnadd3 = new PdfPCell(new Paragraph(c.getPessoa().getNome().toUpperCase(), fo));
            columnadd3.setBorderWidthBottom(1);
            columnadd3.setBorderWidthTop(0);
            columnadd3.setBorderWidthLeft(1);
            columnadd3.setBorderWidthRight(1);
            columnadd3.setBorderColor(BaseColor.GRAY);
            columnadd3.setPadding(3);
            if (i % 2 == 0) {
                BaseColor color = new BaseColor(245, 255, 250);
                columnadd.setBackgroundColor(color);
                columnadd3.setBackgroundColor(color);
                columnadd2.setBackgroundColor(color);
            }

            // add colunm
            pdfPTable.addCell(columnadd3);
            pdfPTable.addCell(columnadd2);
            pdfPTable.addCell(columnadd);
        }
        return pdfPTable;
    }

    public static PdfPTable createTableSemMilhar(String endereco) throws DocumentException {
        float[] pointColumnWidths = {7, 2};
        PdfPTable pdfPTable = new PdfPTable(pointColumnWidths);
        pdfPTable.setWidths(pointColumnWidths);
        pdfPTable.setWidthPercentage(50);
        pdfPTable.setHorizontalAlignment(0);
        Font fo = new Font(FontFamily.UNDEFINED, 10, Font.BOLD, BaseColor.BLACK);
        Font foTop = new Font(FontFamily.UNDEFINED, 10, Font.BOLD, BaseColor.BLACK);
        //PdfPCell column = new PdfPCell(new Paragraph("Anotações".toUpperCase(), foTop));
//        column.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        column.setBorderWidthBottom(1);
//        column.setBorderWidthTop(1);
//        column.setBorderWidthLeft(1);
//        column.setBorderWidthRight(1);
//        column.setBorderColor(BaseColor.LIGHT_GRAY);
//        column.setHorizontalAlignment(1);
     //   column.setPadding(3);
        PdfPCell column2 = new PdfPCell(new Paragraph("Valor".toUpperCase(), foTop));
        column2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        column2.setBorderWidthBottom(1);
        column2.setBorderWidthTop(1);
        column2.setBorderWidthLeft(0);
        column2.setBorderWidthRight(1);
        column2.setHorizontalAlignment(1);
        column2.setBorderColor(BaseColor.LIGHT_GRAY);
        column2.setPadding(3);

        PdfPCell column3 = new PdfPCell(new Paragraph("Cliente".toUpperCase(), foTop));
        column3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        column3.setBorderWidthBottom(1);
        column3.setBorderWidthTop(1);
        column3.setBorderWidthLeft(1);
        column3.setBorderWidthRight(1);
        column3.setBorderColor(BaseColor.LIGHT_GRAY);
        column3.setPadding(3);
        // add colunm

        pdfPTable.addCell(column3);
        pdfPTable.addCell(column2);
       // pdfPTable.addCell(column);
        int i = 0;
        CompraService compraService = new CompraService();
        Collection<Compra> compras = compraService.selecionarComprasPeloSeuEnderecoDeCadastro(endereco);
        for (Compra c : compras) {
            i++;
           // PdfPCell columnadd = new PdfPCell(new Paragraph(" ", fo));
//            columnadd.setBorderWidthBottom(1);
//            columnadd.setBorderWidthTop(0);
//            columnadd.setBorderWidthLeft(0);
//            columnadd.setBorderWidthRight(1);
//            columnadd.setBorderColor(BaseColor.LIGHT_GRAY);
//            columnadd.setPadding(3);
            PdfPCell columnadd2 = new PdfPCell(new Paragraph(formatarValor(c.getValor()), fo));
            columnadd2.setBorderWidthBottom(1);
            columnadd2.setBorderWidthTop(0);
            columnadd2.setBorderWidthLeft(1);
            columnadd2.setBorderWidthRight(1);
            columnadd2.setBorderColor(BaseColor.LIGHT_GRAY);
            columnadd2.setPadding(3);
            PdfPCell columnadd3 = new PdfPCell(new Paragraph(c.getPessoa().getNome().toUpperCase(), fo));
            columnadd3.setBorderWidthBottom(1);
            columnadd3.setBorderWidthTop(0);
            columnadd3.setBorderWidthLeft(1);
            columnadd3.setBorderWidthRight(0);
            columnadd3.setBorderColor(BaseColor.LIGHT_GRAY);
            columnadd3.setPadding(3);
            if (i % 2 == 0) {
                BaseColor color = new BaseColor(245, 255, 250);
             //   columnadd.setBackgroundColor(color);
                columnadd2.setBackgroundColor(color);
                columnadd3.setBackgroundColor(color);
            }
            // add colunm
            pdfPTable.addCell(columnadd3);
            pdfPTable.addCell(columnadd2);
         //   pdfPTable.addCell(columnadd);
        }
        return pdfPTable;
    }

}

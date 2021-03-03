package Classes;

import Crud.CompraCRUD;
import Crud.ItemCompraCRUD;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relatorio {
    /*
    Gerar Relatorio Completo, especifico, etc...
    Permitir que o usuario mude o direitorio./talvez // NÃO
    Lucro / em andamaneot
    */
    private Date dt = new Date();
    private final SimpleDateFormat DTF = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat DTFT = new SimpleDateFormat("dd/MM/yyyy");
    private final String relName = "Relatorio_" + DTF.format(dt) + ".pdf"; 
    private String src = "rel/" + relName;
    private final DecimalFormat DF = new DecimalFormat("###,###,##0.00");
    private final DecimalFormat PF = new DecimalFormat("#0.##");
    private final DecimalFormat PEF = new DecimalFormat("###0.##");
    private final String srcLogo  = "src/Imagens/logo_175x78.png";
    
    public void gerarRelatorio() throws FileNotFoundException, IOException, BadElementException, DocumentException {
        //Essenciais
        CompraCRUD comc = new CompraCRUD();
        ItemCompraCRUD itemc = new ItemCompraCRUD();
        Document docc = new Document(PageSize.A4);
        Double total = 0.00;
        //Fontes
        Font f1 = new Font(FontFamily.HELVETICA, 20, Font.BOLD);
        Font fc = new Font(FontFamily.HELVETICA, 10, Font.UNDERLINE, BaseColor.WHITE);
        Font fct = new Font(FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
        Font fctN = new Font(FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED);
        //Definindo paragrafos e células da Tabela
        Paragraph cab = new Paragraph("Relatorio de Vendas:", f1);
        cab.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cellCod = new PdfPCell(new Paragraph("Código", fc));
        cellCod.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellData = new PdfPCell(new Paragraph("Data", fc));
        cellData.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellTotal = new PdfPCell(new Paragraph("Valor", fc));
        cellTotal.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellPag = new PdfPCell(new Paragraph("Forma de Pagamento", fc));
        cellPag.setBackgroundColor(BaseColor.DARK_GRAY);

        //Adicionando conteudo no arquivo PDF
        Image logo = Image.getInstance(srcLogo);
        logo.setAlignment(Element.ALIGN_CENTER);
        PdfWriter.getInstance(docc, new FileOutputStream(src));
        docc.open();
        docc.add(logo);
        docc.add(new Paragraph(cab));
        docc.add(new Paragraph("\n"));
        PdfPTable tb = new PdfPTable(4);
        tb.addCell(cellCod);
        tb.addCell(cellData);
        tb.addCell(cellTotal);
        tb.addCell(cellPag);

        int i = 0; //Impar/par, pra mudar a cor das celulas
        for (Compra com : comc.read()) {
            i++;
            String cod = String.valueOf(com.getCod());
            String vt = "R$" + DF.format(com.getVlrTot());
            String data = /*DTFT.format(com.getData())*/ DTFT.format(new java.util.Date(com.getData().replaceAll("-", "/")));
            //-------------------------------------------------------
            cellCod = new PdfPCell(new Paragraph(cod, fct));
            if (i % 2 == 0) {
                cellCod.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tb.addCell(cellCod);
            cellData = new PdfPCell(new Paragraph(data, fct));
            if (i % 2 == 0) {
                cellData.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tb.addCell(cellData);
            cellTotal = new PdfPCell(new Paragraph(vt, fct));
            if (i % 2 == 0) {
                cellTotal.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tb.addCell(cellTotal);
            cellPag = new PdfPCell(new Paragraph(com.getPagForm(), fct));
            if (i % 2 == 0) {
                cellPag.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tb.addCell(cellPag);
            total += com.getVlrTot(); //Calculando o valor de todas as vendas
        }

        //Mostrando o valor total das vendas
        docc.add(tb);
        docc.add(new Paragraph("\n \n \n "));
        docc.add(new Paragraph("Total em Vendas: R$" + DF.format(total)));

        //Exibir estatisticas dos produtos vendidos
        PdfPTable tbItens = new PdfPTable(8);
        float[] collumWidths = new float[]{7f, 15f, 10f, 7f, 15f, 15f, 15f, 12f};
        tbItens.setWidths(collumWidths);
        PdfPCell cellCodI = new PdfPCell(new Paragraph("Cod", fc));
        cellCodI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellNomeI = new PdfPCell(new Paragraph("Nome", fc));
        cellNomeI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellQuantI = new PdfPCell(new Paragraph("Quant Vendida", fc));
        cellQuantI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellUnI = new PdfPCell(new Paragraph("Unid", fc));
        cellUnI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellPrecI = new PdfPCell(new Paragraph("Preço", fc));
        cellPrecI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellTotalI = new PdfPCell(new Paragraph("Valor Total", fc));
        cellTotalI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellLucroI = new PdfPCell(new Paragraph("Lucro", fc));
        cellLucroI.setBackgroundColor(BaseColor.DARK_GRAY);
        PdfPCell cellLucroPI = new PdfPCell(new Paragraph("Lucro %", fc));
        cellLucroPI.setBackgroundColor(BaseColor.DARK_GRAY);
        tbItens.addCell(cellCodI);
        tbItens.addCell(cellNomeI);
        tbItens.addCell(cellQuantI);
        tbItens.addCell(cellUnI);
        tbItens.addCell(cellPrecI);
        tbItens.addCell(cellTotalI);
        tbItens.addCell(cellLucroI);
        tbItens.addCell(cellLucroPI);

        i = 0;
        //Double itemMV = 0.0;
        //int itemMVc = 0;
        for (EstatsItem stats : itemc.readEstats()) {
            i++;
            Double precP = stats.getPrecItem();
            Double quantP = stats.getQuantItem();
            String codS = String.valueOf(stats.getCodItem());
            String quantS = PEF.format(stats.getQuantItem());
            String precS = "R$" + DF.format(stats.getPrecItem());
            String vlrTotS = "R$" + DF.format(stats.getVlrTot());
            //-------Calculos---------------------------
            Double lucro = stats.getVlrTot() - (precP * quantP);
            Double lucroPc = (lucro / stats.getVlrTot()) * 100;
            /*
                ******RESOLVER: COMO EXIBIR O PRODUTO MAIS VENDIDO/DEMANDADO*******
                
                itemMV = (stats.getQuantItem() > itemMV) ? stats.getQuantItem() : itemMV;
                itemMVc = (stats.getQuantItem() > itemMV) ? stats.getCodItem() : itemMVc;
             */
            //------------------------------------------
            String lucroS = "R$" + DF.format(lucro);
            String lucroPcS = "%" + PF.format(lucroPc);

            cellCodI = new PdfPCell(new Paragraph(codS, fct));
            if (i % 2 == 0) {
                cellCodI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellCodI);
            cellNomeI = new PdfPCell(new Paragraph(stats.getNomeProd(), fct));
            if (i % 2 == 0) {
                cellNomeI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellNomeI);
            cellQuantI = new PdfPCell(new Paragraph(quantS, fct));
            if (i % 2 == 0) {
                cellQuantI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellQuantI);
            cellUnI = new PdfPCell(new Paragraph(stats.getUnidItem(), fct));
            if (i % 2 == 0) {
                cellUnI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellUnI);
            cellPrecI = new PdfPCell(new Paragraph(precS, fct));
            if (i % 2 == 0) {
                cellPrecI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellPrecI);
            cellTotalI = new PdfPCell(new Paragraph(vlrTotS, fct));
            if (i % 2 == 0) {
                cellTotalI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellTotalI);
            if (lucro > 0) {
                cellLucroI = new PdfPCell(new Paragraph(lucroS, fct)); //Se lucro for > 0
            } else {
                cellLucroI = new PdfPCell(new Paragraph(lucroS, fctN));         //Se lucro for < 0
            }
            if (i % 2 == 0) {
                cellLucroI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellLucroI);
            if (lucroPc > 0) {
                cellLucroPI = new PdfPCell(new Paragraph(lucroPcS, fct)); //Se % for > 0
            } else {
                cellLucroPI = new PdfPCell(new Paragraph(lucroPcS, fctN));          //Se % for < 0
            }
            if (i % 2 == 0) {
                cellLucroPI.setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            tbItens.addCell(cellLucroPI);

        }

        docc.add(new Paragraph("\n \n \n \n"));
        Paragraph citem = new Paragraph("Estatísticas de Itens Vendidos:", f1);
        citem.setAlignment(Element.ALIGN_CENTER);
        docc.add(citem);
        docc.add(new Paragraph("\n"));
        docc.add(tbItens);

        docc.close();
    }

    public String getSrc() {
        return src;
    }   
    
}
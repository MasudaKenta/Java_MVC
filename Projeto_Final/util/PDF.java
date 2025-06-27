package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.File;
import java.io.FileOutputStream;

import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDF {
    private Document document = new Document(PageSize.A4);
    private String arquivoPDF;
    private Font fonteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD, BaseColor.DARK_GRAY);
    private Font fonte = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
    DottedLineSeparator linha = new DottedLineSeparator();
    
    public PDF(String titulo) {
        arquivoPDF = titulo + new SimpleDateFormat("-d-M-y").format(new Date())+".pdf";
        
        linha.setOffset(-5);
        
        Chunk cTitulo = new Chunk(titulo, fonteTitulo);
       
        try {
            PdfWriter.getInstance(document, new FileOutputStream(arquivoPDF));
            document.open();
            document.add(cTitulo);
            addLinha();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void add(String s){
        try {
            document.add(new Paragraph(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addLinha(){
        try {
            document.add(linha);
            document.add(new Paragraph(" "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void exibir(){
        try {
            document.close();
            File pdf = new File(arquivoPDF);
            Desktop.getDesktop().open(pdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addColunasTabela(String[] colunas){
        
        try {
            float[] colunasLargura = {0.2f,1f,0.8f,0.6f,0.6f,0.6f,0.6f,0.5f};
            PdfPTable t = new PdfPTable(colunasLargura);
            
            for(String s: colunas){
                
                Chunk cTitulo = new Chunk(s,fonte);
                t.addCell(new Paragraph(cTitulo));
           
            }
            
            document.add(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void addLinhaTabela(String[] linha){
        
        try {
            float[] colunasLargura = {0.2f,1f,0.8f,0.6f,0.6f,0.6f,0.6f,0.5f};
            PdfPTable t = new PdfPTable(colunasLargura);
            
            
            for(String s:linha){
                Chunk clinha = new Chunk(s, fonte);
                t.addCell(new Paragraph(clinha));
            }
                
            
            document.add(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

package io.sim.Projeto;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class Relatorio extends Thread {
    
    Workbook workbook;

    public Relatorio() {
        workbook = new XSSFWorkbook();    
    }


    @Override
    public void run() {
        try {
            
            // Crie uma nova planilha no arquivo
            Sheet sheet = workbook.createSheet("relatorio");

            // Crie uma linha
            Row row = sheet.createRow(0);

            // Crie uma célula na linha
            Cell cell = row.createCell(0);

            // Defina o valor da célula
            cell.setCellValue("Olá, Mundo!");

            // Salve o arquivo Excel em disco
            try (FileOutputStream fileOut = new FileOutputStream("meuarquivo.xlsx")) {
                workbook.write(fileOut);
            }

            System.out.println("Arquivo Excel criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


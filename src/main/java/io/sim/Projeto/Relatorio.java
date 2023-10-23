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
            int nLinha = 1;
            // Criar a primeira linha com cabeçalhos
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Timestamp");
            headerRow.createCell(1).setCellValue("Id Car");
            headerRow.createCell(2).setCellValue("Id Route");
            headerRow.createCell(3).setCellValue("Speed");
            headerRow.createCell(4).setCellValue("Distance");
            headerRow.createCell(5).setCellValue("FuelConsumption");
            headerRow.createCell(6).setCellValue("FuelType");
            headerRow.createCell(7).setCellValue("CO2Emission");
            headerRow.createCell(8).setCellValue("Longitude (lon)");
            headerRow.createCell(9).setCellValue("latitude (lat)");
            
            
            // Adicionar dados à planilha
            
            // Adicionar uma nova coluna (por exemplo, "E-mail")
            
            // Salve o arquivo Excel em disco
            
            
            while(nLinha < 10){
            Row dataRow = sheet.createRow(nLinha);
            dataRow.createCell(0).setCellValue("Timestamp" + nLinha+ "novo dado");
            dataRow.createCell(1).setCellValue("Id Car" + nLinha+ "novo dado");
            dataRow.createCell(2).setCellValue("Id Route" + nLinha+ "novo dado");
            dataRow.createCell(3).setCellValue("Speed" + nLinha+ "novo dado");
            dataRow.createCell(4).setCellValue("Distance" + nLinha+ "novo dado");
            dataRow.createCell(5).setCellValue("FuelConsumption" + nLinha+ "novo dado");
            dataRow.createCell(6).setCellValue("FuelType" + nLinha+ "novo dado");
            dataRow.createCell(7).setCellValue("CO2Emission" + nLinha+ "novo dado");
            dataRow.createCell(8).setCellValue("Longitude (lon)" + nLinha+ "novo dado");
            dataRow.createCell(9).setCellValue("latitude (lat)" + nLinha + "novo dado");
            nLinha++;
            
            try (FileOutputStream fileOut = new FileOutputStream("relatorio.xlsx")) {
                workbook.write(fileOut);
            }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


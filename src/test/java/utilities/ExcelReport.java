package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.TestOtomasyonuLoginPage;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReport extends TestListenerAdapter {


    private Workbook workbook;
    private Sheet sheet;
    private int rowCount;

    public ExcelReport() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Test Report");
        rowCount = 0;
        createHeaderRow();

    }
        private void createHeaderRow() {
            Row headerRow = sheet.createRow(rowCount++);
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);

            String[] headers = {"Test Name", "Status", "Error Message"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(style);
            }
        }


    @Override
    public void onTestSuccess(ITestResult tr) {
        addTestResultToSheet(tr, "PASS", null);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        addTestResultToSheet(tr, "FAIL", tr.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        addTestResultToSheet(tr, "SKIP", null);
    }

    private void addTestResultToSheet(ITestResult tr, String status, String errorMessage) {
        Row row = sheet.createRow(rowCount++);
        row.createCell(0).setCellValue(tr.getName());
        row.createCell(1).setCellValue(status);
        row.createCell(2).setCellValue(errorMessage != null ? errorMessage : "");
    }

    public void saveReport(String filePath) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
    }


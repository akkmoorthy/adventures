package com.adventures.ooprinciples.solid.srp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * A utility class which converts a word document to PDF
 * http://programmergate.com/software-design-principles/
 *
 */
public class PDFConverterViolation {

	public String documentType = "WORD";
	
	/**
	 * This method accepts as input the document to be converted and returns the
	 * converted one.
	 * 
	 * @param fileBytes
	 * @throws Exception
	 */
	public byte[] convertToPDF(byte[] fileBytes) throws Exception
	{
		if(documentType.equalsIgnoreCase("WORD"))
		{
			InputStream input = new ByteArrayInputStream(fileBytes);
//			com.aspose.words.Document wordDocument = new com.aspose.words.Document(input);
			ByteArrayOutputStream pdfDocument = new ByteArrayOutputStream();
//			wordDocument.save(pdfDocument, SaveFormat.PDF);
			return pdfDocument.toByteArray();
		}
		else
		{
			InputStream input = new ByteArrayInputStream(fileBytes);
//			Workbook workbook = new Workbook(input);
//            PdfSaveOptions saveOptions = new PdfSaveOptions();
//            saveOptions.setCompliance(PdfCompliance.PDF_A_1_B);
			ByteArrayOutputStream pdfDocument = new ByteArrayOutputStream();
//			workbook.save(pdfDocument, saveOptions);
			return pdfDocument.toByteArray();
		}
	}
}
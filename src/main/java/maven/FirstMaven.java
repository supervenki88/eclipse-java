package maven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
public class FirstMaven {

	public static void main(String[] args) throws Docx4JException, IOException
	{
		// TODO Auto-generated method stub
		
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
		
		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title", "Hello Maven Central");

		wordMLPackage.getMainDocumentPart().addParagraphOfText("from docx4j!");
		System.out.println(System.getProperties());
        
		// Now save it
		File docxFile = new File("src/main/resources/helloMavenCentral.docx"); 
		wordMLPackage.save(docxFile);
		
		FileInputStream fileInputStream = new FileInputStream(docxFile.getAbsolutePath());	
		
		//===[XWPFDocument is an API for read or write an OOML documents]===
		XWPFDocument document = new XWPFDocument(fileInputStream);
			
		XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
		
		String fileData = wordExtractor.getText();
		System.out.println(fileData);
		
		
		
		
	}

}

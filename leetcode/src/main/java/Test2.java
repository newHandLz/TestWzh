package agli;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test2 {
    public static void main(String[] args) throws IOException {
        String inputFile = "D:\\爱之星/model_draf 2.pdf";   // 输入PDF文件路径
        String outputFile = "D:\\爱之星/output.pdf"; // 输出PDF文件路径
        if (new File(outputFile).exists()) {
            Files.delete(Paths.get(outputFile));

        }
        String fieldName = "[custName_0]";  // 要替换的表单域名
        //    String replacementText = "你好xxxxxxxxx"; // 替换的文本
        String replacementText = "1\uD869\uDF002\uD869\uDF103\uD869\uDF634\uD869\uDF735\uD869\uDF996\uD869\uDFA97\uD869\uDFAE8\uD869\uDFBE9\uD86E\uDF6210\uD870\uDC2911䶮12䢺";
        String fontPath = "C:\\Windows\\fonts\\SIMSUNB.ttf"; // 字体文件路径
        try {
            // 加载自定义字体
            // 创建输入和输出PDF文档对象
            PdfReader reader = new PdfReader(inputFile);
            PdfWriter writer = new PdfWriter(outputFile);
            PdfDocument pdfDoc = new PdfDocument(reader, writer);

            //PdfFontFactory.registerDirectory("/Users/zhangjialin/Downloads/ttf/");

            // 获取表单对象
            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
//            // 获取要替换的表单域
            PdfFormField field = form.getField(fieldName);
//            // 设置字体\
            PdfFont font = PdfFontFactory.createFont(fontPath, true);

//            PdfFont font = PdfFontFactory.createRegisteredFont("SimSun-ExtB", "UTF-8", true);

//            field.setFont(font);

            //            // 替换表单域的值
            field.setFont(font);
            field.setValue("你号手机打开伞");
//           // 更新表单
            form.flattenFields();

            // 关闭文档
            pdfDoc.close();

            System.out.println("替换完成，输出文件：" + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

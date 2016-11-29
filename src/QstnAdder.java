import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Created by sunning on 2016/11/29.
 */
public class QstnAdder {
    private int id;
    private String content;
    private String[] option;
    private String answer;

    private String separator = File.separator;

    XMLWriter writer = null; //  声明写XML的对象
    SAXReader reader = new SAXReader();

    String filePath = separator + "Users" + separator +
            "sunning" + separator + "Desktop" + separator + "QA" + separator;

    //TODO:select
    public QstnAdder(int id, String content, String[] option, String answer) throws IOException, DocumentException {
        addRoot();
        this.id = id;
        this.content = content;
        this.option = option;
        this.answer = answer;
        this.addQstn(id, content, option, answer);
    }

    //TODO:fillblank and descrip
    public QstnAdder(int id, String content) throws IOException, DocumentException {
        addRoot();
        this.id = id;
        this.content = content;
        String tmp = "()";
        if (content.indexOf(tmp) >= 0) {
            String[] fillcontent = content.split(tmp);
            for (int i = 0; i < fillcontent.length; i++) {
                System.out.println(fillcontent[i]);
            }
            this.addQstn(id, fillcontent);
        }
        this.addQstn(id, content);
    }

    //TODO:judge
    public QstnAdder(int id, String content, String answer) {
        this.id = id;
        this.content = content;
        this.answer = answer;
    }

    //TODO:descrip
    public void addQstn(int id, String content) throws IOException, DocumentException {
        File file = new File(filePath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        root.addElement("question");
        Element question = root.element("question");

        addNode(question, "id", String.valueOf(id));
        addNode(question, "content", content);
        writer = new XMLWriter(new FileWriter(file), this.setformat());
        writer.write(doc);
        writer.close();
    }

    //TODO:judge
    public void addQstn(int id, String content, String answer) {

    }

    public void addQstn(int id, String[] content) throws DocumentException {
        File file = new File(filePath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        root.addElement("question");
        Element question = root.element("question");

        addNode(question, "content", content[0]);

        for (int i = 1; i < content.length; i++) {
            addNode(question, "blank", "");
            addNode(question, "content", content[i]);
        }
    }

    //TODO:select
    public void addQstn(int id, String content, String[] option, String answer) throws DocumentException, IOException {
        File file = new File(filePath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        root.addElement("question");
        Element question = root.element("question");

        addNode(question, "id", String.valueOf(id));
        addNode(question, "content", content);
        addNode(question, "option", option[0], "num", "A");
        addNode(question, "option", option[1], "num", "B");
        addNode(question, "option", option[2], "num", "C");
        addNode(question, "option", option[3], "num", "D");
        addNode(question, "answer", answer);

        writer = new XMLWriter(new FileWriter(file), this.setformat());
        writer.write(doc);
        writer.close();

    }

    //TODO:添加根节点qamaintain

    public void addRoot() throws IOException {
        filePath += "test.xml";
        File file = new File(filePath);
        Document document = DocumentHelper.createDocument();
        document.addElement("qamaitain");
        writer = new XMLWriter(new FileWriter(file), this.setformat());
        writer.write(document);
        writer.close();
    }

    //TODO:添加节点和格式化操作

    public void addNode(Element node, String nodeName, String text) {
        Element newNode = node.addElement(nodeName);
        newNode.setText(text);
    }

    public void addNode(Element node, String nodeName, String text, String attribute, String value) {
        Element newNode = node.addElement(nodeName);
        newNode.setText(text);
        newNode.addAttribute(attribute, value);
    }

    public OutputFormat setformat() {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("gb2312");
        return format;
    }
}

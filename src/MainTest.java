import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * Created by sunning on 2016/11/29.
 */
public class MainTest {
    public static void main(String[] args) throws IOException, DocumentException {
        String option="this is () test, to check whether the () is right.";
        QstnAdder qstnAdder=new QstnAdder(1,option);

    }
}

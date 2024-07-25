package agli;

import org.springframework.web.util.HtmlUtils;

public class XssTest {
    public static void main(String[] args) {
        String json="opInfo eval(1)";
        System.out.println(SecurityUtil.isXssAttack(json));
        System.out.println(HtmlUtils.htmlEscape(json));
    }
}

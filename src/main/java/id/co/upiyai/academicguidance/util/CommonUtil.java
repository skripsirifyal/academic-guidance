package id.co.upiyai.academicguidance.util;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class CommonUtil {
    private static final String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z"};

    private static final Random random = new Random(System.currentTimeMillis());

    public static String generateId() {
        return (UUID.randomUUID().toString().replace("-", "")).toUpperCase();
    }

    public static String generatePrimaryCode(String action, String className, String total) {
        LocalDate currentDate = LocalDate.now();
        String prefix = action.concat(className).concat(currentDate.toString().replace("-",""));
        String suffix = String.format("%0"+ (32 - (prefix.length()+total.length()))+"d%s", 0 ,"");
        return (prefix.concat(suffix)).toUpperCase();
    }

    public static String generateReferenceNumber(String text) {
        String bin = encodeA1Z26(text).replace("-", "");
        int length = bin.length() + 12;
        int randomNumberLength = length - (bin.length() + 1);

        StringBuilder builder = new StringBuilder(bin);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        int checkDigit = getCheckDigit(builder.toString());
        builder.append(checkDigit);

        String result = builder.toString().replace(bin, text);
        String[] splitter = result.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        return String.join("-", splitter);
    }

    private static int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }

    public String decodeA1Z26(String s){
        StringBuilder n = new StringBuilder();
        String[] c = s.split("\\s");
        for (int i=0;i<c.length;i++){
            String temp =c[i];
            if (!temp.equals("")){
                String[] c2 = temp.split("-");
                for (String temp2 : c2) {
                    int t = Integer.parseInt(temp2);
                    t = t - 1;
                    n.append(alphabet[t]);
                }
            }

            if (i != c.length-1) n.append(" ");
        }
        return n.toString();
    }

    public static String encodeA1Z26(String s){
        StringBuilder n = new StringBuilder();
        String[] c = s.split("\\s");
        for (int i=0;i<c.length;i++){
            String temp =c[i];
            if (!temp.equals("")){
                String[] c2 = temp.split("(?!^)");
                for (int j=0;j<c2.length;j++){
                    if (j == c2.length-1) n.append(ltn(c2[j]));
                    else n.append(ltn(c2[j])).append("-");
                }
            }

            if (i != c.length-1) n.append(" ");
        }
        return n.toString();
    }

    public static int ltn(String s){
        int n;
        char t = s.charAt(0);
        n = Character.getNumericValue(t)-9;
        return n;
    }

    public static ActionEnum action(String action) {
        if ("add".equals(action)) {
            return ActionEnum.ADD;
        } else if ("edit".equals(action)) {
            return ActionEnum.MODIFY;
        } else if ("delete".equals(action)) {
            return ActionEnum.DELETE;
        } else {
            return ActionEnum.RESUBMIT;
        }
    }

    public static StatusEnum status(String status) {
        if ("consulted".equals(status)) {
            return StatusEnum.CONSULTED;
        } else if ("rejected".equals(status)) {
            return StatusEnum.REJECTED;
        } else if ("deleted".equals(status)) {
            return StatusEnum.DELETED;
        } else if ("requested".equals(status)) {
            return StatusEnum.REQUESTED;
        } else if ("escalated".equals(status)) {
            return StatusEnum.ESCALATED;
        } else {
            return StatusEnum.DRAFTED;
        }
    }

    public static KindEnum kind(String kind) {
        if ("online".equals(kind)) {
            return KindEnum.ONLINE;
        } else {
            return KindEnum.OFFLINE;
        }
    }

    public static TypeEnum type(String type) {
        if ("new".equals(type)) {
            return TypeEnum.NEW;
        } else {
            return TypeEnum.CONTINUE;
        }
    }
}

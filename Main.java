import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main
{
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);

        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("비밀번호를 입력하세요: ");
            String inputPassword = sc.nextLine();

            System.out.println("\n입력한 비밀번호: " + inputPassword);
            System.out.println("해싱된 결과 (SHA-512): " + toHexString(getSHA(inputPassword)));
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("올바르지 않은 알고리즘이 지정되었습니다: " + e);
        }
    }
}

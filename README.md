```markdown
# 🔒 SHA-512 비밀번호 해싱 프로그램

이 프로젝트는 Java를 사용하여 입력한 비밀번호를 SHA-512 알고리즘으로 해싱하는 프로그램입니다.
이 프로그램은 입력된 문자열을 SHA-512로 변환한 후, 그 결과를 16진수로 출력합니다.

## 🛠️ 주요 기능

- 사용자가 입력한 비밀번호를 SHA-512 알고리즘을 사용해 해싱
- 해싱된 결과를 16진수 문자열로 변환하여 출력

```
## 📋 코드 설명

```java
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main
{
    // 입력 문자열을 SHA-512 해싱하여 byte 배열로 반환하는 함수
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    // byte 배열을 16진수 문자열로 변환하는 함수
    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // 해시값이 32자리가 될 때까지 앞에 '0' 추가
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    // 메인 함수: 사용자로부터 비밀번호 입력받고 해싱된 결과 출력
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
```

## 📝 사용 방법

1. **프로젝트를 클론**하거나 파일을 다운로드합니다:

```bash
git clone https://github.com/your-github-username/your-repo-name.git
```

2. **Java 개발 환경**(JDK 11 이상)을 설치하고 프로젝트를 컴파일 및 실행합니다:

```bash
javac Main.java
java Main
```

3. 실행 후 비밀번호를 입력하면, 해당 비밀번호의 SHA-512 해싱 결과가 출력됩니다.

## 🛡️ SHA-512란?

SHA-512는 **해시 함수**로, 입력된 데이터를 고정된 길이의 **128자리 해시값**으로 변환합니다. 이 해시값은 입력된 데이터와 유일하게 연결되며, 보안성 높은 비밀번호 저장 등에 사용됩니다.

## 🛠️ 필수 사항

- **JDK 11** 이상이 설치되어 있어야 합니다.

## 🌱 향후 계획

- 추가적인 해시 알고리즘 지원 (예: SHA-256, MD5)
- 비밀번호 비교 및 검증 기능 추가

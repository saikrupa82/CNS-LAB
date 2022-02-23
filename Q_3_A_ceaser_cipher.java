import java.util.*;
class Caesar{
	public static void Encrypt(String text, int shift){
		String ciphertext="";
		char a;
		for (int i=0;i<text.length();i++){
			a=text.charAt(i);
			if (a>='a' && a<='z'){
				a=(char)(a+shift);
				if (a>'z'){
					a=(char)(a+'a'-'z'-1);
				}
				ciphertext=ciphertext+a;
			}
			else if (a>='A' && a<='Z'){
				a=(char)(a+shift);
				if (a>'Z'){
					a=(char)(a+'A'-'Z'-1);
				}
				ciphertext=ciphertext+a;
			}
			else{
				ciphertext=ciphertext+a;
			}
		}
		System.out.println("Encrypt : "+ciphertext);
	}
	
	public static void Decrypt(String text, int shift){
		String ciphertext="";
		char a;
		for (int i=0;i<text.length();i++){
			a=text.charAt(i);
			if (a>='a' && a<='z'){
				a=(char)(a-shift);
				if (a<'a'){
					a=(char)(a-'a'+'z'+1);
				}
				ciphertext=ciphertext+a;
			}
			else if (a>='A' && a<='Z'){
				a=(char)(a-shift);
				if (a<'A'){
					a=(char)(a-'A'+'Z'+1);
				}
				ciphertext=ciphertext+a;
			}
			else{
				ciphertext=ciphertext+a;
			}
		}
		System.out.println("Decrypt : "+ciphertext);
	}
	public static void main(String ar[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the text to Encrypt");
		String text = sc.nextLine();
		System.out.println("Enter the value by which text should be shifted");
		int shift = sc.nextInt();
		System.out.println("Enter your choice");
		System.out.println("1.Encrypt\n2.Decrypt");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				Encrypt(text,shift);
				break;
			case 2:
				Decrypt(text,shift);
				break;
		}	
	}	
}


// Enter any String: Hello World
// Enter the Key: 5
// Encrypted String is: MjqqtBtwqi
// Decrypted String is: Hello World
object Q1 {

  println("Enter a Word");
  val text=scala.io.StdIn.readLine();
  println("Enter the Shift ");
  val shift=scala.io.StdIn.readInt();


  def main(args:Array[String]):Unit={

    val encryptedtext=cipher(text,shift,encrypt);
    printf("Encrypted Text:%s\n",encryptedtext);

    val decryptedtext=cipher(encryptedtext,shift,decrypt);
    printf("Decrypted Text:%s ",decryptedtext);
  }

  def encrypt(s:Char,shift:Int): Char= {
    if (s.isLetter) {
      val base = if (s.isUpper) 'A' else 'a'
      ((s - base + shift) % 26 + base).toChar
    } else {
      s
    }
  }
  def decrypt(s:Char,shift:Int):Char={
    if (s.isLetter) {
      val base = if (s.isUpper) 'A' else 'a'
      ((s -base - shift+26) % 26 + base).toChar
    } else {
      s
    }

  }

  def cipher(text: String, shift: Int, func: (Char, Int) => Char): String = {
    text.map(c => func(c, shift))
  }


}

package me.zeroest.kotlin.basic.extensionfunction

fun String.firstChar(): Char {
    return this[0]
}

fun String.addFirstChar(char: Char): String {
    return char + this.substring(0)
}

fun main() {
    println("ABCD".firstChar())
    println("ABCD".addFirstChar('Z'))
}

/*
   Kotlin -> Java

   public static final char firstChar(@NotNull String $this$firstChar) {
      Intrinsics.checkNotNullParameter($this$firstChar, "$this$firstChar");
      return $this$firstChar.charAt(0);
   }

   @NotNull
   public static final String addFirstChar(@NotNull String $this$addFirstChar, char var1) {
      Intrinsics.checkNotNullParameter($this$addFirstChar, "$this$addFirstChar");
      byte var4 = 0;
      String var10000 = $this$addFirstChar.substring(var4);
      Intrinsics.checkNotNullExpressionValue(var10000, "this as java.lang.String).substring(startIndex)");
      String var3 = var10000;
      return var1 + var3;
   }

   public static final void main() {
      char var0 = firstChar("ABCD");
      System.out.println(var0);
      String var1 = addFirstChar("ABCD", 'Z');
      System.out.println(var1);
   }
*/
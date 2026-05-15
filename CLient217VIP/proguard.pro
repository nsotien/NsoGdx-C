-injars      dist/NSO217VIP.jar
-outjars     dist/NSO217VIP_Obf.jar

-libraryjars lib/cdc_1.1.jar
-libraryjars lib/jsr205_2.0.jar
-libraryjars lib/midp_2.1.jar

-dontwarn java.nio.file.**
-ignorewarnings
-dontpreverify
-target 1.6

# Không gộp package để giữ đúng cấu trúc
#-repackageclasses ''

-dontshrink
-dontoptimize

-overloadaggressively
-useuniqueclassmembernames

# Giữ nguyên tất cả class mở rộng MIDlet
-keep class * extends javax.microedition.midlet.MIDlet {
    public <init>();
    public void startApp();
    public void pauseApp();
    public void destroyApp(boolean);
}

-assumenosideeffects class java.io.PrintStream {
    public void println(...);
    public void print(...);
}

-obfuscationdictionary      proguard-7.6.0/OBF.txt
-classobfuscationdictionary proguard-7.6.0/OBF.txt
-packageobfuscationdictionary proguard-7.6.0/OBF.txt

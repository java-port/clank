//<editor-fold defaultstate="collapsed" desc="clang::Builtin::Info">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", line = 53,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Builtins.h", old_line = 52)
//</editor-fold>  
public Info(Object/*char$ptr || String*/ Name, Object/*char$ptr || String*/ Type, Object/*char$ptr || String*/ Attributes, Object/*char$ptr || String*/ HeaderName, 
        /*LanguageID*//*uint*/int Langs, Object/*char$ptr || String*/  Features) {
  assert Name != null;
  this.Name = param2constPtr(Name);
  this.Type = param2constPtr(Type);
  this.Attributes = param2constPtr(Attributes);
  this.HeaderName = param2constPtr(HeaderName);
  this.Langs = Langs;
  this.Features = param2constPtr(Features);
}
private static char$ptr param2constPtr(Object/*char$ptr || String*/ param) {
  if (param == null) {
    return null;
  }
  if (param instanceof String) {
    return $toConst(create_char$ptr_utf8((String)param));
  }
  assert param instanceof char$ptr : "must be char$ptr " + param.getClass();
  return $toConst((char$ptr)param);
}

public String toString() {
  return "" + "Name=" + Casts.toJavaString(Name) // NOI18N
            + ", Type=" + Casts.toJavaString(Type) // NOI18N
            + ", Attributes=" + Casts.toJavaString(Attributes) // NOI18N
            + ", HeaderName=" + Casts.toJavaString(HeaderName) // NOI18N
            + ", (LanguageID)Langs=" + Integer.toBinaryString(Langs) // NOI18N
            + ", Features=" + Casts.toJavaString(Features); // NOI18N
}

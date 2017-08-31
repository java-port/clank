@Override public OpaquePtr clone() { 
  return new OpaquePtr(this.Ptr); 
}

//<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
 FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtrINS_8QualTypeEE3getEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrINS_8QualTypeEE3getEv")
//</editor-fold>
public QualType getQualType() /*const*/ {
//    return PointerLikeTypeTraitsQualType.getFromVoidPointer(Ptr);
  assert Ptr instanceof QualType || Ptr == null : "unexpected " + NativeTrace.getIdentityStr(Ptr);
  return Ptr == null ? new QualType() : (QualType)Ptr;
}
//<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
 FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtrINS_12TemplateNameEE3getEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrINS_12TemplateNameEE3getEv")
//</editor-fold>
public TemplateName getTemplateName() /*const*/ {
//    return PointerLikeTypeTraitsTemplateName.getFromVoidPointer(Ptr);
  assert Ptr instanceof TemplateName || Ptr == null : "unexpected " + NativeTrace.getIdentityStr(Ptr);
  return Ptr == null ? new TemplateName() : (TemplateName)Ptr;
}
//<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
 FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtrINS_12DeclGroupRefEE3getEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrINS_12DeclGroupRefEE3getEv")
//</editor-fold>
public DeclGroupRef getDeclGroupRef() /*const*/ {
//    return PointerLikeTypeTraitsDeclGroupRef.getFromVoidPointer(Ptr);
  assert Ptr instanceof DeclGroupRef || Ptr == null : "unexpected " + NativeTrace.getIdentityStr(Ptr);
  return Ptr == null ? new DeclGroupRef() : (DeclGroupRef)Ptr;
}
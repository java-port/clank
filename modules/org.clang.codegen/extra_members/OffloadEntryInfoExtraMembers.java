//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 249,
 FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1ERKS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1ERKS3_")
//</editor-fold>
public /*inline*/ OffloadEntryInfo(final /*const*/ OffloadEntryInfo /*&*/ $Prm0) {
  // : Order(.Order), Kind(.Kind) 
  //START JInit
  this.Order = $Prm0.Order;
  this.Kind = $Prm0.Kind;
  //END JInit
}
      
@Override
public OffloadEntryInfo clone() {
  assert this.getClass() == OffloadEntryInfo.class : "Why not overridden in " + this.getClass();
  return new OffloadEntryInfo(this);
}

@Override
public OffloadEntryInfo move() {
  assert this.getClass() == OffloadEntryInfo.class : "Why not overridden in " + this.getClass();
  return new OffloadEntryInfo(JD$Move.INSTANCE, this);
}

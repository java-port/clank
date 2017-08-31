//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 287,
 FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1ERKS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1ERKS3_")
//</editor-fold>
public /*inline*/ OffloadEntryInfoTargetRegion(final /*const*/ OffloadEntryInfoTargetRegion /*&*/ $Prm0) {
  // : OffloadEntryInfo(), Addr(.Addr), ID(.ID) 
  //START JInit
  super($Prm0);
  this.Addr = $Prm0.Addr;
  this.ID = $Prm0.ID;
  //END JInit
}

@Override
public OffloadEntryInfoTargetRegion clone() {
  assert this.getClass() == OffloadEntryInfoTargetRegion.class : "Why not overridden in " + this.getClass();
  return new OffloadEntryInfoTargetRegion(this);
}

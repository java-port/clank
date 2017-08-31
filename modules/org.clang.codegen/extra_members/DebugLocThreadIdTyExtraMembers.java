//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy::DebugLocThreadIdTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 151,
 FQN="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy::DebugLocThreadIdTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyC1ERKS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyC1ERKS2_")
//</editor-fold>
public /*inline*/ DebugLocThreadIdTy(final /*const*/ DebugLocThreadIdTy /*&*/ $Prm0) {
  // : DebugLoc(.DebugLoc), ThreadID(.ThreadID) 
  //START JInit
  this.DebugLoc = $Prm0.DebugLoc;
  this.ThreadID = $Prm0.ThreadID;
  //END JInit
}

public DebugLocThreadIdTy() { 
}

@Override public DebugLocThreadIdTy clone() {
  return new DebugLocThreadIdTy(this);
}

@Override public DebugLocThreadIdTy move() {
  return new DebugLocThreadIdTy(JD$Move.INSTANCE, this);
}

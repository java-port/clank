//<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase<BasicBlock>::InfoRec::InfoRec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 224,
 FQN="llvm::DominatorTreeBase<BasicBlock>::InfoRec::InfoRec", NM="_ZN4llvm17DominatorTreeBaseINS_10BasicBlockEE7InfoRecC1ERKS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm17DominatorTreeBaseINS_10BasicBlockEE7InfoRecC1ERKS3_")
//</editor-fold>
public /*inline*/ InfoRec(final /*const*/ InfoRec /*&*/ $Prm0) {
  // : DFSNum(.DFSNum), Parent(.Parent), Semi(.Semi), Label(.Label)
  //START JInit
  this.DFSNum = $Prm0.DFSNum;
  this.Parent = $Prm0.Parent;
  this.Semi = $Prm0.Semi;
  this.Label = $Prm0.Label;
  //END JInit
}

@Override public InfoRec clone() {
  return new InfoRec(this);
}

@Override public InfoRec move() {
  return new InfoRec(JD$Move.INSTANCE, this);
}

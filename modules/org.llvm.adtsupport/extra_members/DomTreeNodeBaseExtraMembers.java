//<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase<NodeT>::~DomTreeNodeBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 32,
 FQN="llvm::DomTreeNodeBase<NodeT>::~DomTreeNodeBase", NM="_ZN4llvm15DomTreeNodeBaseINS_10BasicBlockEED0Ev",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm15DomTreeNodeBaseINS_10BasicBlockEED0Ev")
//</editor-fold>
public /*inline*/ void $destroy() {
  //START JDestroy
  Children.$destroy();
  //END JDestroy
}

@Override
public Iterator<DomTreeNodeBase<NodeT>> iterator() {
  return new JavaIterator<DomTreeNodeBase<NodeT>>(begin(), end());
}

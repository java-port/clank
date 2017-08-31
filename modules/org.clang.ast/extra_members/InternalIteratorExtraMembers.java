//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::InternalIterator">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 901,
 FQN="(anonymous namespace)::TemplateDiff::TSTiterator::InternalIterator::InternalIterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorC1ERKS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiterator16InternalIteratorC1ERKS2_")
//</editor-fold>
public /*inline*/ InternalIterator(final /*const*/ InternalIterator /*&*/ $Prm0) {
  this.TST = $Prm0.TST;
  this.Index = $Prm0.Index;
  this.CurrentTA = $tryClone($Prm0.CurrentTA);
  this.EndTA = $tryClone($Prm0.EndTA);
}

@Override
public InternalIterator clone() {
  return new InternalIterator(this);
}

@Override
public boolean $eq(Object obj) {
  if (this == obj) {
    return true;
  }
  if (obj == null) {
    return false;
  }
  final InternalIterator other = (InternalIterator) obj;
  if (this.Index != other.Index) {
    return false;
  }
  if (this.TST != other.TST) {
    return false;
  }
  if (!Native.$eq_ptr(this.CurrentTA, other.CurrentTA)) {
    return false;
  }
  if (!Native.$eq_ptr(this.EndTA, other.EndTA)) {
    return false;
  }
  return true;
}

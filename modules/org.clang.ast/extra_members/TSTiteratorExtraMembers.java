//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::TSTiterator::TSTiterator">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 894,
 FQN="(anonymous namespace)::TemplateDiff::TSTiterator::TSTiterator", NM="_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorC1ERKS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff11TSTiteratorC1ERKS1_")
//</editor-fold>
public /*inline*/ TSTiterator(final /*const*/ TSTiterator /*&*/ $Prm0) {
  this.UseDesugaredIterator = $Prm0.UseDesugaredIterator;
  this.SugaredIterator = $tryClone($Prm0.SugaredIterator);
  this.DesugaredIterator = $tryClone($Prm0.DesugaredIterator);
}

@Override
public TSTiterator clone() {
  return new TSTiterator(this);
}

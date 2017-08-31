public @Override int $hashcode() { 
  return this.Stored.$hashcode();  
}

public CanQual<T> $assign(CanQual<?> $Prm0) {
  this.Stored.$assign($Prm0.Stored);
  return this;
}

public CanQual<T> $assignMove(CanQual<?> $Prm0) {
  assert this != $Prm0;
  this.Stored = $Prm0.Stored;
  $Prm0.Stored = null;
  return this;
}

public CanQual(final /*const*/ CanQual<T> /*&*/ Other) {
  this.Stored = new QualType(Other.Stored);
}

public CanQual(JD$Move _dparam, final /*const*/ CanQual<T> /*&*/ Other) {
  assert this != Other;
  this.Stored = Other.Stored;
  Other.Stored = null;
}

@Override public CanQual<T> clone() {
  return new CanQual(this);
}

@Override
public boolean $eq(CanQual<?> other) {
  return $eq_CanQual(this, other);
}

public static boolean $eq_CanQual(CanQual<?> LHS, CanQual<?> RHS) {
  return QualType.$eq_QualType$C(LHS.Stored, RHS.Stored);
}

public static boolean $noteq_CanQual(CanQual<?> LHS, CanQual<?> RHS) {
  return QualType.$noteq_QualType$C(LHS.Stored, RHS.Stored);
}

//<editor-fold defaultstate="collapsed" desc="llvm::simplify_type<CanQual<type-parameter-0-0> >::getSimplifiedValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 355,
 FQN="llvm::simplify_type<CanQual<type-parameter-0-0> >::getSimplifiedValue", NM="_ZN4llvm13simplify_typeIN5clang7CanQualIT_EEE18getSimplifiedValueES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN4llvm13simplify_typeIN5clang7CanQualIT_EEE18getSimplifiedValueES4_")
//</editor-fold>  
@Override public Object getSimplifiedValue(Object $This) {
  // copied from llvm::simplify_type<CanQual>
  assert $This == this : "must be called on itself " + this + " vs. " + $This;
  return this.getTypePtr();
}
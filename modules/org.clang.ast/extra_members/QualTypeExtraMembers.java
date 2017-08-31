public @Override int $hashcode() { 
  return this.Value.$hashcode();  
}

@Override public QualType clone() { 
  return new QualType(this); 
}

private static final int DUMMY_QUAL_TYPE_VALUE = -1;

public static final Object/*P*/DUMMY_QUAL_TYPE_OPAQUE_VALUE = 
        new PointerIntPair(null, DUMMY_QUAL_TYPE_VALUE);

@Override public boolean $less(Object Other) { 
  PointerIntPair<PointerUnion<Type, ExtQuals>> RHS = (PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>)Other; 
  return this.Value.$less(RHS);
}
public boolean $less(QualType RHS) {
  return this.Value.$less(RHS.Value);
}

@Override public boolean $lesseq(Object Other) { 
  PointerIntPair<PointerUnion<Type, ExtQuals>> RHS = (PointerIntPair<PointerUnion</*const*/ Type /*P*/ , /*const*/ ExtQuals /*P*/ >/*, Qualifiers.FastWidth*/>)Other; 
  return this.Value.$lesseq(RHS);
}
public boolean $lesseq(QualType RHS) { 
  return this.Value.$lesseq(RHS.Value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::simplify_type<clang::QualType>::getSimplifiedValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1117,
 FQN="llvm::simplify_type<clang::QualType>::getSimplifiedValue", NM="_ZN4llvm13simplify_typeIN5clang8QualTypeEE18getSimplifiedValueES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN4llvm13simplify_typeIN5clang8QualTypeEE18getSimplifiedValueES2_")
//</editor-fold>  
@Override public Object getSimplifiedValue(Object $This) {
  // copied from llvm::simplify_type<clang::QualType>
  assert $This == this : "must be called on itself " + $This + " vs. " + this;
  return this.getTypePtr();
}

@Override
public boolean $noteq(QualType other) {
  if (other == null) {
    return !isNull();
  }
  return $noteq_QualType$C(this, other);
}

@Override
public boolean $eq(QualType other) {
  if (other == null) {
    return isNull();
  }
  return $eq_QualType$C(this, other);
}

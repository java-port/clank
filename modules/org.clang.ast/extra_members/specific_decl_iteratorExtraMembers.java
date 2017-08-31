private final Class<SpecificDecl> clazz;
       
public specific_decl_iterator(specific_decl_iterator  C) {
  // : Current(C) 
  this.Current = new DeclContext.decl_iterator(C.Current);
  this.clazz = C.clazz;
}

public specific_decl_iterator<SpecificDecl> $assignMove(specific_decl_iterator<SpecificDecl> $Prm0) {
  assert this.clazz == $Prm0.clazz;
  this.Current.$assign($Prm0.Current);
  return /*Deref*/this;
}
    
@Override public boolean $eq(Object other) { 
  return $eq_specific_decl_iterator$SpecificDecl$C(this, (specific_decl_iterator)other); 
}

@Override public boolean $noteq(Object other) { 
  return $noteq_specific_decl_iterator$SpecificDecl$C(this, (specific_decl_iterator)other); 
}

@Override
public DeclContext.specific_decl_iterator<SpecificDecl> clone() {
  return new specific_decl_iterator(this);
}

//<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator<clang::FieldDecl>::operator=">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1473,
 FQN="clang::DeclContext::specific_decl_iterator<clang::FieldDecl>::operator=", NM="_ZN5clang11DeclContext22specific_decl_iteratorINS_9FieldDeclEEaSERKS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorINS_9FieldDeclEEaSERKS3_")
//</editor-fold>
public /*inline*/ specific_decl_iterator<SpecificDecl> /*&*/ $assign(final /*const*/ specific_decl_iterator<SpecificDecl> /*&*/ $Prm0) {
  assert this.clazz == $Prm0.clazz;
  this.Current.$assign($Prm0.Current);
  return /*Deref*/this;
}

@Override
public int $sub(specific_decl_iterator __first) {
  int dist = 0;
  if (__first.$noteq(this)) {
    specific_decl_iterator<?> iter = __first.clone();
    do {
      ++dist;
      iter.$preInc();
    } while (iter.$noteq(this));
  }
  return dist;      
}
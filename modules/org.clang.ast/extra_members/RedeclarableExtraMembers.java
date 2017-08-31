public static class Redeclarable$Fields<decl_type extends Decl & Redeclarable> {
  public/*protected*/ DeclLink<decl_type> RedeclLink;
  public/*protected*/ decl_type /*P*/ First;

  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::Redeclarable<decl_type>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 139,
   FQN="clang::Redeclarable::Redeclarable<decl_type>", NM="_ZN5clang12RedeclarableC1ERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12RedeclarableC1ERKNS_10ASTContextE")
  //</editor-fold>
  public Redeclarable$Fields(final /*const*/ ASTContext /*&*/ Ctx, decl_type $this) {
    // : RedeclLink(LatestDeclLink(Ctx)), First(static_cast<decl_type * >(this)) 
    //START JInit
    this.RedeclLink = /*ParenListExpr*//*NO_COPY*/LatestDeclLink(Ctx);
    this.First = /*ParenListExpr*/((/*static_cast*/decl_type /*P*/ )($this));
    //END JInit
  }    
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
/*private*/ default Redeclarable$Fields<decl_type> $Redeclarable$Fields() {
  throw new UnsupportedOperationException("Why not implemented in derived? Keep what was returned from $Redeclarable in your final field and just return it here.");
}  

//<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::Redeclarable<decl_type>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 139,
 FQN="clang::Redeclarable::Redeclarable<decl_type>", NM="_ZN5clang12RedeclarableC1ERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12RedeclarableC1ERKNS_10ASTContextE")
//</editor-fold>
public/*protected*/ default/*interface*/ Redeclarable$Fields<decl_type> $Redeclarable(final /*const*/ ASTContext /*&*/ Ctx) {
  assert !(this instanceof Mergeable) : "can not be Mergeable and Redeclarable at the same time" + this.getClass();
  // : RedeclLink(LatestDeclLink(Ctx)), First(static_cast<decl_type * >(this)) 
  //START JInit
  return new Redeclarable$Fields(Ctx, (Decl)this);
  //END JInit
}  

public default void $destroy$Redeclarable() {
}
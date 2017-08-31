@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static final class DeclContext$Fields {  
/// DeclKind - This indicates which class this is.
public/*private*/ /*JBYTE unsigned int*/ byte DeclKind /*: 8*/;

/// \brief Whether this declaration context also has some external
/// storage that contains additional declarations that are lexically
/// part of this context.
public/*private*/ /*mutable *//*JBIT bool*/ boolean ExternalLexicalStorage /*: 1*/;

/// \brief Whether this declaration context also has some external
/// storage that contains additional declarations that are visible
/// in this context.
public/*private*/ /*mutable *//*JBIT bool*/ boolean ExternalVisibleStorage /*: 1*/;

/// \brief Whether this declaration context has had external visible
/// storage added since the last lookup. In this case, \c LookupPtr's
/// invariant may not hold and needs to be fixed before we perform
/// another lookup.
public/*private*/ /*mutable *//*JBIT bool*/ boolean NeedToReconcileExternalVisibleStorage /*: 1*/;

/// \brief If \c true, this context may have local lexical declarations
/// that are missing from the lookup table.
public/*private*/ /*mutable *//*JBIT bool*/ boolean HasLazyLocalLexicalLookups /*: 1*/;

/// \brief If \c true, the external source may have lexical declarations
/// that are missing from the lookup table.
public/*private*/ /*mutable *//*JBIT bool*/ boolean HasLazyExternalLexicalLookups /*: 1*/;

/// \brief If \c true, lookups should only return identifier from
/// DeclContext scope (for example TranslationUnit). Used in
/// LookupQualifiedName()
public/*private*/ /*mutable *//*JBIT bool*/ boolean UseQualifiedLookup /*: 1*/;

/// \brief Pointer to the data structure used to lookup declarations
/// within this context (or a DependentStoredDeclsMap if this is a
/// dependent context). We maintain the invariant that, if the map
/// contains an entry for a DeclarationName (and we haven't lazily
/// omitted anything), then it contains all relevant entries for that
/// name (modulo the hasExternalDecls() flag).
public/*private*/ /*mutable */StoredDeclsMap /*P*/ LookupPtr;
/*protected:*/
/// FirstDecl - The first declaration stored within this declaration
/// context.
public/*protected*/ /*mutable */Decl /*P*/ FirstDecl;

/// LastDecl - The last declaration stored within this declaration
/// context. FIXME: We could probably cache this value somewhere
/// outside of the DeclContext, to reduce the size of DeclContext by
/// another pointer.
public/*protected*/ /*mutable */Decl /*P*/ LastDecl;

//<editor-fold defaultstate="collapsed" desc="clang::DeclContext::DeclContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1197,
 FQN="clang::DeclContext::DeclContext", NM="_ZN5clang11DeclContextC1ENS_4Decl4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContextC1ENS_4Decl4KindE")
//</editor-fold>
protected/*protected*/ DeclContext$Fields(/*Decl,Kind*/byte K) {
  // : DeclKind(K), ExternalLexicalStorage(false), ExternalVisibleStorage(false), NeedToReconcileExternalVisibleStorage(false), HasLazyLocalLexicalLookups(false), HasLazyExternalLexicalLookups(false), UseQualifiedLookup(false), LookupPtr(null), FirstDecl(null), LastDecl(null) 
  //START JInit
  this.DeclKind = $uint2uint_8bits(K);
  this.ExternalLexicalStorage = false;
  this.ExternalVisibleStorage = false;
  this.NeedToReconcileExternalVisibleStorage = false;
  this.HasLazyLocalLexicalLookups = false;
  this.HasLazyExternalLexicalLookups = false;
  this.UseQualifiedLookup = false;
  this.LookupPtr = null;
  this.FirstDecl = null;
  this.LastDecl = null;
  //END JInit
}
public String toString() {
  return "" + "DeclKind=" + DeclKind // NOI18N
          + ", ExternalLexicalStorage=" + ExternalLexicalStorage // NOI18N
          + ", ExternalVisibleStorage=" + ExternalVisibleStorage // NOI18N
          + ", NeedToReconcileExternalVisibleStorage=" + NeedToReconcileExternalVisibleStorage // NOI18N
          + ", HasLazyLocalLexicalLookups=" + HasLazyLocalLexicalLookups // NOI18N
          + ", HasLazyExternalLexicalLookups=" + HasLazyExternalLexicalLookups // NOI18N
          + ", UseQualifiedLookup=" + UseQualifiedLookup // NOI18N
          + ", LookupPtr=" + LookupPtr // NOI18N
          + ", FirstDecl=" + FirstDecl // NOI18N
          + ", LastDecl=" + LastDecl; // NOI18N
}  
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
/*private*/ default DeclContext$Fields $DeclContext$Fields() {
  throw new UnsupportedOperationException("Why not implemented in derived? Keep what was returned from $DeclContext in your final field and just return it here.");
}  

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public default StoredDeclsMap $LookupPtr() {
  throw new UnsupportedOperationException("EmptyBody. call getLookupPtr()?");
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public default boolean $NeedToReconcileExternalVisibleStorage() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::DeclContext::DeclContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1197,
 FQN="clang::DeclContext::DeclContext", NM="_ZN5clang11DeclContextC1ENS_4Decl4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContextC1ENS_4Decl4KindE")
//</editor-fold>
public/*protected*/ default/*interface*/ DeclContext$Fields $DeclContext(Decl.Kind K) {
  // : DeclKind(K), ExternalLexicalStorage(false), ExternalVisibleStorage(false), NeedToReconcileExternalVisibleStorage(false), HasLazyLocalLexicalLookups(false), HasLazyExternalLexicalLookups(false), UseQualifiedLookup(false), LookupPtr(null), FirstDecl(null), LastDecl(null) 
  //START JInit
  return new DeclContext$Fields(K);
  //END JInit
}

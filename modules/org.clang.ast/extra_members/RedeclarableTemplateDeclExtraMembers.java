@Override 
public/*derived non-final*/ RedeclarableTemplateDecl getPreviousDecl() { 
  return (RedeclarableTemplateDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
} 

@Override 
public/*derived non-final*/ RedeclarableTemplateDecl getPreviousDecl$Const() { 
  return (RedeclarableTemplateDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
} 

@Override 
public/*derived non-final*/ RedeclarableTemplateDecl getMostRecentDecl() { 
  return (RedeclarableTemplateDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
} 

@Override 
public/*derived non-final*/ RedeclarableTemplateDecl getMostRecentDecl$Const() { 
  return (RedeclarableTemplateDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
} 

@Override 
public final boolean isFirstDecl() { 
  return Redeclarable.super.isFirstDecl$Redeclarable(); 
} 

/////////////////////////////////////////////////////////////////////////////////
/// instantiations of clang::RedeclarableTemplateDecl::findSpecializationImpl ///

/*template <class EntryType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="Tpl__ZN5clang24RedeclarableTemplateDecl22findSpecializationImplERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEENS1_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl22findSpecializationImplERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEENS1_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final </*class*/ EntryType extends FoldingSetImpl.Node> EntryType/*P*/ findSpecializationImpl(final FoldingSetVector<EntryType> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<?>>/*void P&*/ InsertPos) {
  throw new IllegalStateException("Specialized method from EXTRA MEMBERS must be used");
}

//</*class*/ EntryType/* = FunctionTemplateSpecializationInfo*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_34FunctionTemplateSpecializationInfoEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_34FunctionTemplateSpecializationInfoEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final FunctionDecl /*P*/ findSpecializationImpl$FunctionDecl(final FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>>/*void P&*/ InsertPos) {
  /*typedef SpecEntryTraits<FunctionTemplateSpecializationInfo> SETraits*/
//  final class SETraits extends SpecEntryTraitsFunctionTemplateSpecializationInfo{ };
  FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
  FunctionTemplateSpecializationInfo.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
  FunctionTemplateSpecializationInfo /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
  return (Entry != null) ? SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Entry).getMostRecentDecl() : null;
}
//</*class*/ EntryType/* = ClassTemplateSpecializationDecl*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_31ClassTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_31ClassTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final ClassTemplateSpecializationDecl /*P*/ findSpecializationImpl$ClassTemplateSpecializationDecl(final FoldingSetVector<ClassTemplateSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
  /*typedef SpecEntryTraits<ClassTemplateSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<ClassTemplateSpecializationDecl>{ };
  FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
  ClassTemplateSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
  ClassTemplateSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
  return (Entry != null) ? SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
}
//</*class*/ EntryType/* = ClassTemplatePartialSpecializationDecl*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_38ClassTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_38ClassTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final ClassTemplatePartialSpecializationDecl /*P*/ findSpecializationImpl$ClassTemplatePartialSpecializationDecl(final FoldingSetVector<ClassTemplatePartialSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<ClassTemplatePartialSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
  /*typedef SpecEntryTraits<ClassTemplatePartialSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<ClassTemplatePartialSpecializationDecl>{ };
  FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
  ClassTemplatePartialSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
  ClassTemplatePartialSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
  return (Entry != null) ? SpecEntryTraits.<ClassTemplatePartialSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
}
//</*class*/ EntryType/* = VarTemplateSpecializationDecl*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_29VarTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_29VarTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final VarTemplateSpecializationDecl /*P*/ findSpecializationImpl$VarTemplateSpecializationDecl(final FoldingSetVector<VarTemplateSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
  /*typedef SpecEntryTraits<VarTemplateSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<VarTemplateSpecializationDecl>{ };
  FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
  VarTemplateSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
  VarTemplateSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
  return (Entry != null) ? SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
}
//</*class*/ EntryType/* = VarTemplatePartialSpecializationDecl*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final VarTemplatePartialSpecializationDecl /*P*/ findSpecializationImpl$VarTemplatePartialSpecializationDecl(final FoldingSetVector<VarTemplatePartialSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<VarTemplatePartialSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
  /*typedef SpecEntryTraits<VarTemplatePartialSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<VarTemplatePartialSpecializationDecl>{ };
  FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
  VarTemplatePartialSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
  VarTemplatePartialSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
  return (Entry != null) ? SpecEntryTraits.<VarTemplatePartialSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
}

//</*class*/ EntryType/* = FunctionTemplateSpecializationInfo*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
 FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
//</editor-fold>
protected final FunctionDecl /*P*/ findSpecializationImpl$FunctionTemplateSpecializationInfo(final FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                      final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>>/*void P&*/ InsertPos) {
  /*typedef SpecEntryTraits<VarTemplatePartialSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<VarTemplatePartialSpecializationDecl>{ };
  FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
  FunctionTemplateSpecializationInfo.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
  FunctionTemplateSpecializationInfo /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
  return (Entry != null) ? SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Entry).getMostRecentDecl() : null;
}

/// end of instantiations clang::RedeclarableTemplateDecl::findSpecializationImpl
/////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////
/// instantiations clang::RedeclarableTemplateDecl::addSpecializationImpl

/*template <class Derived, class EntryType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
 FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="Tpl__ZN5clang24RedeclarableTemplateDecl21addSpecializationImplERN4llvm16FoldingSetVectorIT0_NS1_11SmallVectorIPS3_Lj8EEEEES5_Pv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl21addSpecializationImplERN4llvm16FoldingSetVectorIT0_NS1_11SmallVectorIPS3_Lj8EEEEES5_Pv")
//</editor-fold>
protected final </*class*/ Derived, /*class*/ EntryType> void addSpecializationImpl(final FoldingSetVector<?> /*&*/ Specializations, EntryType /*P*/ Entry, 
                     type$ptr<?>/*void P*/ InsertPos) {
  throw new IllegalStateException("Specialized method from EXTRA MEMBERS must be used");
}

//</*class*/ Derived/* = FunctionTemplateDecl*/, /*class*/ EntryType/* = FunctionTemplateSpecializationInfo*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
 FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_20FunctionTemplateDeclENS_34FunctionTemplateSpecializationInfoEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_20FunctionTemplateDeclENS_34FunctionTemplateSpecializationInfoEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv")
//</editor-fold>
protected final void addSpecializationImpl$FunctionTemplateSpecializationInfo(final FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ Specializations, FunctionTemplateSpecializationInfo /*P*/ Entry, 
                     type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos) {
  /*typedef SpecEntryTraits<FunctionTemplateSpecializationInfo> SETraits*/
//  final class SETraits extends SpecEntryTraitsFunctionTemplateSpecializationInfo{ };
  if ((InsertPos != null)) {
    final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > CorrectInsertPos = create_type$ref();
    assert (!(findSpecializationImpl$FunctionDecl(Specializations, SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getTemplateArgs(Entry), CorrectInsertPos) != null) && $eq_ptr(InsertPos, CorrectInsertPos.$deref())) : "given incorrect InsertPos for specialization";
    Specializations.InsertNode(Entry, InsertPos);
  } else {
    FunctionTemplateSpecializationInfo /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
    ///*J:(void)*/Existing;
    assert (SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
  }
  {

    ASTMutationListener /*P*/ L = getASTMutationListener();
    if ((L != null)) {
      L.AddedCXXTemplateSpecialization(cast_FunctionTemplateDecl(this), 
          SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Entry));
    }
  }
}

//  </*class*/ Derived/* = ClassTemplateDecl*/, /*class*/ EntryType/* = ClassTemplateSpecializationDecl*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
 FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_17ClassTemplateDeclENS_31ClassTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_17ClassTemplateDeclENS_31ClassTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv")
//</editor-fold>
protected final void addSpecializationImpl$ClassTemplateSpecializationDecl(final FoldingSetVector<ClassTemplateSpecializationDecl> /*&*/ Specializations, ClassTemplateSpecializationDecl /*P*/ Entry, 
                     type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos) {
  /*typedef SpecEntryTraits<ClassTemplateSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<ClassTemplateSpecializationDecl>{ };
  if ((InsertPos != null)) {
    final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ > CorrectInsertPos = create_type$ref();
    assert (!(findSpecializationImpl$ClassTemplateSpecializationDecl(Specializations, SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getTemplateArgs(Entry), CorrectInsertPos) != null) && $eq_ptr(InsertPos, CorrectInsertPos.$deref())) : "given incorrect InsertPos for specialization";
    Specializations.InsertNode(Entry, InsertPos);
  } else {
    ClassTemplateSpecializationDecl /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
    ///*J:(void)*/Existing;
    assert (SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
  }
  {

    ASTMutationListener /*P*/ L = getASTMutationListener();
    if ((L != null)) {
      L.AddedCXXTemplateSpecialization(cast_ClassTemplateDecl(this), 
          SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getDecl(Entry));
    }
  }
}

//</*class*/ Derived/* = VarTemplateDecl*/, /*class*/ EntryType/* = VarTemplateSpecializationDecl*/> 
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
 FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_15VarTemplateDeclENS_29VarTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_15VarTemplateDeclENS_29VarTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv")
//</editor-fold>
protected final void addSpecializationImpl$VarTemplateSpecializationDecl(final FoldingSetVector<VarTemplateSpecializationDecl> /*&*/ Specializations, VarTemplateSpecializationDecl /*P*/ Entry, 
                     type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos) {
  /*typedef SpecEntryTraits<VarTemplateSpecializationDecl> SETraits*/
//  final class SETraits extends SpecEntryTraits<VarTemplateSpecializationDecl>{ };
  if ((InsertPos != null)) {
    final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ > CorrectInsertPos = create_type$ref();
    assert (!(findSpecializationImpl$VarTemplateSpecializationDecl(Specializations, SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getTemplateArgs(Entry), CorrectInsertPos) != null) && $eq_ptr(InsertPos, CorrectInsertPos.$deref())) : "given incorrect InsertPos for specialization";
    Specializations.InsertNode(Entry, InsertPos);
  } else {
    VarTemplateSpecializationDecl /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
    ///*J:(void)*/Existing;
    assert (SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
  }
  {

    ASTMutationListener /*P*/ L = getASTMutationListener();
    if ((L != null)) {
      L.AddedCXXTemplateSpecialization(cast_VarTemplateDecl(this), 
          SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getDecl(Entry));
    }
  }
}

/// end of instantiations clang::RedeclarableTemplateDecl::addSpecializationImpl
/////////////////////////////////////////////////////////////////////////////////

public void LoadLazySpecializations() /*const*/ {
}

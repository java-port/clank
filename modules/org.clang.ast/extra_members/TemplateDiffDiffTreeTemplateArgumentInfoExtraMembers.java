//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 524,
 FQN="(anonymous namespace)::TemplateDiff::DiffTree::TemplateArgumentInfo::TemplateArgumentInfo", NM="_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1EOS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN12_GLOBAL__N_112TemplateDiff8DiffTree20TemplateArgumentInfoC1EOS2_")
//</editor-fold>      
public /*inline*/ TemplateArgumentInfo(final TemplateArgumentInfo /*&*/$Prm0) {
  // : ArgType(static_cast<TemplateArgumentInfo &&>().ArgType), Qual(static_cast<TemplateArgumentInfo &&>().Qual), Val(static_cast<TemplateArgumentInfo &&>().Val), IsValidInt(static_cast<TemplateArgumentInfo &&>().IsValidInt), ArgExpr(static_cast<TemplateArgumentInfo &&>().ArgExpr), TD(static_cast<TemplateArgumentInfo &&>().TD), VD(static_cast<TemplateArgumentInfo &&>().VD), NeedAddressOf(static_cast<TemplateArgumentInfo &&>().NeedAddressOf), IsNullPtr(static_cast<TemplateArgumentInfo &&>().IsNullPtr), IsDefault(static_cast<TemplateArgumentInfo &&>().IsDefault) 
  //START JInit
  this.ArgType = new QualType($Prm0.ArgType);
  this.Qual = new Qualifiers($Prm0.Qual);
  this.Val = new APSInt($Prm0.Val);
  this.IsValidInt = $Prm0.IsValidInt;
  this.ArgExpr = $Prm0.ArgExpr;
  this.TD = $Prm0.TD;
  this.VD = $Prm0.VD;
  this.NeedAddressOf = $Prm0.NeedAddressOf;
  this.IsNullPtr = $Prm0.IsNullPtr;
  this.IsDefault = $Prm0.IsDefault;
  //END JInit
}
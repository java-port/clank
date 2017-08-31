/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.DeclContext.decl_iterator.*;
import static org.clang.ast.QualType.StreamedQualTypeHelper.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.DeclPrinterStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 28,
 FQN="(anonymous namespace)::DeclPrinter", NM="_ZN12_GLOBAL__N_111DeclPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinterE")
//</editor-fold>
public class DeclPrinter implements /*public*/ DeclVisitorVoid<DeclPrinter> {
  private final raw_ostream /*&*/ Out;
  private PrintingPolicy Policy;
  private /*uint*/int Indentation;
  private boolean PrintInstantiation;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::Indent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 34,
   FQN="(anonymous namespace)::DeclPrinter::Indent", NM="_ZN12_GLOBAL__N_111DeclPrinter6IndentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter6IndentEv")
  //</editor-fold>
  private raw_ostream /*&*/ Indent() {
    return Indent(Indentation);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::Indent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 194,
   FQN="(anonymous namespace)::DeclPrinter::Indent", NM="_ZN12_GLOBAL__N_111DeclPrinter6IndentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter6IndentEj")
  //</editor-fold>
  private raw_ostream /*&*/ Indent(/*uint*/int Indentation) {
    for (/*uint*/int i = 0; i != Indentation; ++i)  {
      Out.$out(/*KEEP_STR*/"  ");
    }
    return Out;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::ProcessDeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 252,
   FQN="(anonymous namespace)::DeclPrinter::ProcessDeclGroup", NM="_ZN12_GLOBAL__N_111DeclPrinter16ProcessDeclGroupERN4llvm15SmallVectorImplIPN5clang4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter16ProcessDeclGroupERN4llvm15SmallVectorImplIPN5clang4DeclEEE")
  //</editor-fold>
  private void ProcessDeclGroup(final SmallVectorImpl<Decl /*P*/ > /*&*/ Decls) {
    this.Indent();
    Decl.printGroup(Decls.data(), Decls.size(), Out, Policy, Indentation);
    Out.$out(/*KEEP_STR*/";\n");
    Decls.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::Print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 260,
   FQN="(anonymous namespace)::DeclPrinter::Print", NM="_ZN12_GLOBAL__N_111DeclPrinter5PrintEN5clang15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter5PrintEN5clang15AccessSpecifierE")
  //</editor-fold>
  private void Print(AccessSpecifier AS) {
    switch (AS) {
     case AS_none:
      throw new llvm_unreachable("No access specifier!");
     case AS_public:
      Out.$out(/*KEEP_STR*/$public);
      break;
     case AS_protected:
      Out.$out(/*KEEP_STR*/$protected);
      break;
     case AS_private:
      Out.$out(/*KEEP_STR*/$private);
      break;
    }
  }

  
  /// Print an Objective-C method type in parentheses.
  ///
  /// \param Quals The Objective-C declaration qualifiers.
  /// \param T The type to print.
  
  //----------------------------------------------------------------------------
  // Objective-C declarations
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::PrintObjCMethodType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 998,
   FQN="(anonymous namespace)::DeclPrinter::PrintObjCMethodType", NM="_ZN12_GLOBAL__N_111DeclPrinter19PrintObjCMethodTypeERN5clang10ASTContextENS1_4Decl17ObjCDeclQualifierENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter19PrintObjCMethodTypeERN5clang10ASTContextENS1_4Decl17ObjCDeclQualifierENS1_8QualTypeE")
  //</editor-fold>
  private void PrintObjCMethodType(final ASTContext /*&*/ Ctx, 
                     /*Decl::ObjCDeclQualifier*//*uint*/int Quals, 
                     QualType T) {
    Out.$out_char($$LPAREN);
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_In) != 0)) {
      Out.$out(/*KEEP_STR*/"in ");
    }
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_Inout) != 0)) {
      Out.$out(/*KEEP_STR*/"inout ");
    }
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_Out) != 0)) {
      Out.$out(/*KEEP_STR*/"out ");
    }
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_Bycopy) != 0)) {
      Out.$out(/*KEEP_STR*/"bycopy ");
    }
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_Byref) != 0)) {
      Out.$out(/*KEEP_STR*/"byref ");
    }
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_Oneway) != 0)) {
      Out.$out(/*KEEP_STR*/"oneway ");
    }
    if (((Quals & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0)) {
      {
        Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(T);
        if (nullability.$bool()) {
          Out.$out(getNullabilitySpelling(nullability.$star(), true)).$out_char($$SPACE);
        }
      }
    }
    
    Out.$out(Ctx.getUnqualifiedObjCPointerType(new QualType(T)).getAsString(Policy));
    Out.$out_char($$RPAREN);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::PrintObjCTypeParams">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1023,
   FQN="(anonymous namespace)::DeclPrinter::PrintObjCTypeParams", NM="_ZN12_GLOBAL__N_111DeclPrinter19PrintObjCTypeParamsEPN5clang17ObjCTypeParamListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter19PrintObjCTypeParamsEPN5clang17ObjCTypeParamListE")
  //</editor-fold>
  private void PrintObjCTypeParams(ObjCTypeParamList /*P*/ Params) {
    Out.$out(/*KEEP_STR*/$LT);
    /*uint*/int First = /*true*/1;
    for (ObjCTypeParamDecl /*P*/ Param : $Deref(Params)) {
      if ((First != 0)) {
        First = /*false*/0;
      } else {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      switch (Param.getVariance()) {
       case Invariant:
        break;
       case Covariant:
        Out.$out(/*KEEP_STR*/"__covariant ");
        break;
       case Contravariant:
        Out.$out(/*KEEP_STR*/"__contravariant ");
        break;
      }
      
      Out.$out(Param.getDeclName().getAsString());
      if (Param.hasExplicitBound()) {
        Out.$out(/*KEEP_STR*/" : ").$out(Param.getUnderlyingType().getAsString(Policy));
      }
    }
    Out.$out(/*KEEP_STR*/$GT);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::DeclPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 50,
   FQN="(anonymous namespace)::DeclPrinter::DeclPrinter", NM="_ZN12_GLOBAL__N_111DeclPrinterC1ERN4llvm11raw_ostreamERKN5clang14PrintingPolicyEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinterC1ERN4llvm11raw_ostreamERKN5clang14PrintingPolicyEjb")
  //</editor-fold>
  public DeclPrinter(final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy) {
    this(Out, Policy, 
      0, false);
  }
  public DeclPrinter(final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy, 
      /*uint*/int Indentation/*= 0*/) {
    this(Out, Policy, 
      Indentation, false);
  }
  public DeclPrinter(final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy, 
      /*uint*/int Indentation/*= 0*/, boolean PrintInstantiation/*= false*/) {
    // : DeclVisitor<DeclPrinter>(), Out(Out), Policy(Policy), Indentation(Indentation), PrintInstantiation(PrintInstantiation) 
    //START JInit
    $DeclVisitor();
    this./*&*/Out=/*&*/Out;
    this.Policy = new PrintingPolicy(Policy);
    this.Indentation = Indentation;
    this.PrintInstantiation = PrintInstantiation;
    //END JInit
  }

  
  
  //----------------------------------------------------------------------------
  // Common C declarations
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 273,
   FQN="(anonymous namespace)::DeclPrinter::VisitDeclContext", NM="_ZN12_GLOBAL__N_111DeclPrinter16VisitDeclContextEPN5clang11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter16VisitDeclContextEPN5clang11DeclContextEb")
  //</editor-fold>
  public void VisitDeclContext(DeclContext /*P*/ DC) {
    VisitDeclContext(DC, true);
  }
  public void VisitDeclContext(DeclContext /*P*/ DC, boolean Indent/*= true*/) {
    if (Policy.TerseOutput) {
      return;
    }
    if (Indent) {
      Indentation += $8bits_uint2uint(Policy.Indentation);
    }
    
    SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(2, null);
    for (DeclContext.decl_iterator D = DC.decls_begin(), DEnd = DC.decls_end();
         $noteq_decl_iterator(/*NO_COPY*/D, /*NO_COPY*/DEnd); D.$preInc()) {
      
      // Don't print ObjCIvarDecls, as they are printed when visiting the
      // containing ObjCInterfaceDecl.
      if (isa_ObjCIvarDecl(D.$star())) {
        continue;
      }
      
      // Skip over implicit declarations in pretty-printing mode.
      if (D.$arrow().isImplicit()) {
        continue;
      }
      
      // The next bits of code handles stuff like "struct {int x;} a,b"; we're
      // forced to merge the declarations because there's no other way to
      // refer to the struct in question.  This limited merging is safe without
      // a bunch of other checks because it only merges declarations directly
      // referring to the tag, not typedefs.
      //
      // Check whether the current declaration should be grouped with a previous
      // unnamed struct.
      QualType CurDeclType = getDeclType(D.$star());
      if (!Decls.empty() && !CurDeclType.isNull()) {
        QualType BaseType = GetBaseType(new QualType(CurDeclType));
        if (!BaseType.isNull() && isa_ElaboratedType(BaseType)) {
          BaseType.$assignMove(cast_ElaboratedType(BaseType).getNamedType());
        }
        if (!BaseType.isNull() && isa_TagType(BaseType)
           && cast_TagType(BaseType).getDecl() == Decls.$at(0)) {
          Decls.push_back(D.$star());
          continue;
        }
      }
      
      // If we have a merged group waiting to be handled, handle it now.
      if (!Decls.empty()) {
        ProcessDeclGroup(Decls);
      }
      
      // If the current declaration is an unnamed tag type, save it
      // so we can merge it with the subsequent declaration(s) using it.
      if (isa_TagDecl(D.$star()) && !(cast_TagDecl(D.$star()).getIdentifier() != null)) {
        Decls.push_back(D.$star());
        continue;
      }
      if (isa_AccessSpecDecl(D.$star())) {
        Indentation -= $8bits_uint2uint(Policy.Indentation);
        this.Indent();
        Print(D.$arrow().getAccess());
        Out.$out(/*KEEP_STR*/$COLON_LF);
        Indentation += $8bits_uint2uint(Policy.Indentation);
        continue;
      }
      
      this.Indent();
      Visit(D.$star());
      
      // FIXME: Need to be able to tell the DeclPrinter when
      /*const*/char$ptr/*char P*/ Terminator = null;
      if (isa_OMPThreadPrivateDecl(D.$star()) || isa_OMPDeclareReductionDecl(D.$star())) {
        Terminator = null;
      } else if (isa_FunctionDecl(D.$star())
         && cast_FunctionDecl(D.$star()).isThisDeclarationADefinition()) {
        Terminator = null;
      } else if (isa_ObjCMethodDecl(D.$star()) && (cast_ObjCMethodDecl(D.$star()).getBody() != null)) {
        Terminator = null;
      } else if (isa_NamespaceDecl(D.$star()) || isa_LinkageSpecDecl(D.$star())
         || isa_ObjCImplementationDecl(D.$star())
         || isa_ObjCInterfaceDecl(D.$star())
         || isa_ObjCProtocolDecl(D.$star())
         || isa_ObjCCategoryImplDecl(D.$star())
         || isa_ObjCCategoryDecl(D.$star())) {
        Terminator = null;
      } else if (isa_EnumConstantDecl(D.$star())) {
        DeclContext.decl_iterator Next = new DeclContext.decl_iterator(D);
        Next.$preInc();
        if ($noteq_decl_iterator(/*NO_COPY*/Next, /*NO_COPY*/DEnd)) {
          Terminator = $tryClone($COMMA);
        }
      } else {
        Terminator = $tryClone($SEMI);
      }
      if (Native.$bool(Terminator)) {
        Out.$out(Terminator);
      }
      Out.$out(/*KEEP_STR*/$LF);
      
      // Declare target attribute is special one, natural spelling for the pragma
      // assumes "ending" construct so print it here.
      if (D.$arrow().hasAttr(OMPDeclareTargetDeclAttr.class)) {
        Out.$out(/*KEEP_STR*/"#pragma omp end declare target\n");
      }
    }
    if (!Decls.empty()) {
      ProcessDeclGroup(Decls);
    }
    if (Indent) {
      Indentation -= $8bits_uint2uint(Policy.Indentation);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 377,
   FQN="(anonymous namespace)::DeclPrinter::VisitTranslationUnitDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter24VisitTranslationUnitDeclEPN5clang19TranslationUnitDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter24VisitTranslationUnitDeclEPN5clang19TranslationUnitDeclE")
  //</editor-fold>
  public void VisitTranslationUnitDecl(TranslationUnitDecl /*P*/ D) {
    VisitDeclContext(D, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 381,
   FQN="(anonymous namespace)::DeclPrinter::VisitTypedefDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter16VisitTypedefDeclEPN5clang11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter16VisitTypedefDeclEPN5clang11TypedefDeclE")
  //</editor-fold>
  public void VisitTypedefDecl(TypedefDecl /*P*/ D) {
    if (!Policy.SuppressSpecifiers) {
      Out.$out(/*KEEP_STR*/"typedef ");
      if (D.isModulePrivate()) {
        Out.$out(/*KEEP_STR*/"__module_private__ ");
      }
    }
    QualType Ty = D.getTypeSourceInfo().getType();
    Ty.print(Out, Policy, new Twine(D.getName()), Indentation);
    prettyPrintAttributes(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 393,
   FQN="(anonymous namespace)::DeclPrinter::VisitTypeAliasDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter18VisitTypeAliasDeclEPN5clang13TypeAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter18VisitTypeAliasDeclEPN5clang13TypeAliasDeclE")
  //</editor-fold>
  public void VisitTypeAliasDecl(TypeAliasDecl /*P*/ D) {
    $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"using "), $Deref(D));
    prettyPrintAttributes(D);
    Out.$out(/*KEEP_STR*/" = ").$out(D.getTypeSourceInfo().getType().getAsString(Policy));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitEnumDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 399,
   FQN="(anonymous namespace)::DeclPrinter::VisitEnumDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter13VisitEnumDeclEPN5clang8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter13VisitEnumDeclEPN5clang8EnumDeclE")
  //</editor-fold>
  public void VisitEnumDecl(EnumDecl /*P*/ D) {
    if (!Policy.SuppressSpecifiers && D.isModulePrivate()) {
      Out.$out(/*KEEP_STR*/"__module_private__ ");
    }
    Out.$out(/*KEEP_STR*/"enum ");
    if (D.isScoped()) {
      if (D.isScopedUsingClassTag()) {
        Out.$out(/*KEEP_STR*/"class ");
      } else {
        Out.$out(/*KEEP_STR*/"struct ");
      }
    }
    $out_raw_ostream_NamedDecl$C(Out, $Deref(D));
    if (D.isFixed()) {
      $out_raw_ostream_StreamedQualTypeHelper$C(Out.$out(/*KEEP_STR*/" : "), D.getIntegerType().stream(Policy));
    }
    if (D.isCompleteDefinition()) {
      Out.$out(/*KEEP_STR*/" {\n");
      VisitDeclContext(D);
      Indent().$out(/*KEEP_STR*/$RCURLY);
    }
    prettyPrintAttributes(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 422,
   FQN="(anonymous namespace)::DeclPrinter::VisitRecordDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter15VisitRecordDeclEPN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter15VisitRecordDeclEPN5clang10RecordDeclE")
  //</editor-fold>
  public void VisitRecordDecl(RecordDecl /*P*/ D) {
    if (!Policy.SuppressSpecifiers && D.isModulePrivate()) {
      Out.$out(/*KEEP_STR*/"__module_private__ ");
    }
    Out.$out(D.getKindName());
    
    prettyPrintAttributes(D);
    if ((D.getIdentifier() != null)) {
      $out_raw_ostream_NamedDecl$C(Out.$out_char($$SPACE), $Deref(D));
    }
    if (D.isCompleteDefinition()) {
      Out.$out(/*KEEP_STR*/" {\n");
      VisitDeclContext(D);
      Indent().$out(/*KEEP_STR*/$RCURLY);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 439,
   FQN="(anonymous namespace)::DeclPrinter::VisitEnumConstantDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter21VisitEnumConstantDeclEPN5clang16EnumConstantDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21VisitEnumConstantDeclEPN5clang16EnumConstantDeclE")
  //</editor-fold>
  public void VisitEnumConstantDecl(EnumConstantDecl /*P*/ D) {
    $out_raw_ostream_NamedDecl$C(Out, $Deref(D));
    {
      Expr /*P*/ Init = D.getInitExpr();
      if ((Init != null)) {
        Out.$out(/*KEEP_STR*/" = ");
        Init.printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitEmptyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 830,
   FQN="(anonymous namespace)::DeclPrinter::VisitEmptyDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter14VisitEmptyDeclEPN5clang9EmptyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter14VisitEmptyDeclEPN5clang9EmptyDeclE")
  //</editor-fold>
  public void VisitEmptyDecl(EmptyDecl /*P*/ D) {
    prettyPrintAttributes(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 447,
   FQN="(anonymous namespace)::DeclPrinter::VisitFunctionDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter17VisitFunctionDeclEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter17VisitFunctionDeclEPN5clang12FunctionDeclE")
  //</editor-fold>
  public void VisitFunctionDecl(FunctionDecl /*P*/ D) {
    if (!(D.getDescribedFunctionTemplate() != null)
       && !D.isFunctionTemplateSpecialization()) {
      prettyPrintPragmas(D);
    }
    
    CXXConstructorDecl /*P*/ CDecl = dyn_cast_CXXConstructorDecl(D);
    CXXConversionDecl /*P*/ ConversionDecl = dyn_cast_CXXConversionDecl(D);
    if (!Policy.SuppressSpecifiers) {
      switch (D.getStorageClass()) {
       case SC_None:
        break;
       case SC_Extern:
        Out.$out(/*KEEP_STR*/"extern ");
        break;
       case SC_Static:
        Out.$out(/*KEEP_STR*/"static ");
        break;
       case SC_PrivateExtern:
        Out.$out(/*KEEP_STR*/"__private_extern__ ");
        break;
       case SC_Auto:
       case SC_Register:
        throw new llvm_unreachable("invalid for functions");
      }
      if (D.isInlineSpecified()) {
        Out.$out(/*KEEP_STR*/"inline ");
      }
      if (D.isVirtualAsWritten()) {
        Out.$out(/*KEEP_STR*/"virtual ");
      }
      if (D.isModulePrivate()) {
        Out.$out(/*KEEP_STR*/"__module_private__ ");
      }
      if (D.isConstexpr() && !D.isExplicitlyDefaulted()) {
        Out.$out(/*KEEP_STR*/"constexpr ");
      }
      if (((CDecl != null) && CDecl.isExplicitSpecified())
         || ((ConversionDecl != null) && ConversionDecl.isExplicit())) {
        Out.$out(/*KEEP_STR*/"explicit ");
      }
    }
    
    PrintingPolicy SubPolicy/*J*/= new PrintingPolicy(Policy);
    SubPolicy.SuppressSpecifiers = false;
    std.string Proto = D.getNameInfo().getAsString();
    
    QualType Ty = D.getType();
    {
      /*const*/ ParenType /*P*/ PT;
      while (((/*P*/ PT = dyn_cast_ParenType(Ty)) != null)) {
        Proto.$assignMove($add_string_T($add_T_string$C($$LPAREN, Proto), $$RPAREN));
        Ty.$assignMove(PT.getInnerType());
      }
    }
    {
      
      /*const*/ FunctionType /*P*/ AFT = Ty.$arrow().getAs(FunctionType.class);
      if ((AFT != null)) {
        /*const*/ FunctionProtoType /*P*/ FT = null;
        if (D.hasWrittenPrototype()) {
          FT = dyn_cast_FunctionProtoType(AFT);
        }
        
        Proto.$addassign_T$C$P(/*KEEP_STR*/"(");
        if ((FT != null)) {
          raw_string_ostream POut = null;
          try {
            POut/*J*/= new raw_string_ostream(Proto);
            DeclPrinter ParamPrinter/*J*/= new DeclPrinter(POut, SubPolicy, Indentation);
            for (/*uint*/int i = 0, e = D.getNumParams(); i != e; ++i) {
              if ((i != 0)) {
                POut.$out(/*KEEP_STR*/$COMMA_SPACE);
              }
              ParamPrinter.VisitParmVarDecl(D.getParamDecl(i));
            }
            if (FT.isVariadic()) {
              if ((D.getNumParams() != 0)) {
                POut.$out(/*KEEP_STR*/$COMMA_SPACE);
              }
              POut.$out(/*KEEP_STR*/$ELLIPSIS);
            }
          } finally {
            if (POut != null) { POut.$destroy(); }
          }
        } else if (D.doesThisDeclarationHaveABody() && !D.hasPrototype()) {
          for (/*uint*/int i = 0, e = D.getNumParams(); i != e; ++i) {
            if ((i != 0)) {
              Proto.$addassign_T$C$P(/*KEEP_STR*/", ");
            }
            Proto.$addassign(D.getParamDecl(i).getNameAsString());
          }
        }
        
        Proto.$addassign_T$C$P(/*KEEP_STR*/")");
        if ((FT != null)) {
          if (FT.isConst()) {
            Proto.$addassign_T$C$P(/*KEEP_STR*/" const");
          }
          if (FT.isVolatile()) {
            Proto.$addassign_T$C$P(/*KEEP_STR*/" volatile");
          }
          if (FT.isRestrict()) {
            Proto.$addassign_T$C$P(/*KEEP_STR*/" restrict");
          }
          switch (FT.getRefQualifier()) {
           case RQ_None:
            break;
           case RQ_LValue:
            Proto.$addassign_T$C$P(/*KEEP_STR*/" &");
            break;
           case RQ_RValue:
            Proto.$addassign_T$C$P(/*KEEP_STR*/" &&");
            break;
          }
        }
        if ((FT != null) && FT.hasDynamicExceptionSpec()) {
          Proto.$addassign_T$C$P(/*KEEP_STR*/" throw(");
          if (FT.getExceptionSpecType() == ExceptionSpecificationType.EST_MSAny) {
            Proto.$addassign_T$C$P(/*KEEP_STR*/"...");
          } else {
            for (/*uint*/int I = 0, N = FT.getNumExceptions(); I != N; ++I) {
              if ((I != 0)) {
                Proto.$addassign_T$C$P(/*KEEP_STR*/", ");
              }
              
              Proto.$addassign(FT.getExceptionType(I).getAsString(SubPolicy));
            }
          }
          Proto.$addassign_T$C$P(/*KEEP_STR*/")");
        } else if ((FT != null) && isNoexceptExceptionSpec(FT.getExceptionSpecType())) {
          Proto.$addassign_T$C$P(/*KEEP_STR*/" noexcept");
          if (FT.getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept) {
            raw_string_ostream EOut = null;
            try {
              Proto.$addassign_T$C$P(/*KEEP_STR*/"(");
              EOut/*J*/= new raw_string_ostream(Proto);
              FT.getNoexceptExpr().printPretty(EOut, (PrinterHelper /*P*/ )null, SubPolicy, 
                  Indentation);
              EOut.flush();
              Proto.$addassign(EOut.str());
              Proto.$addassign_T$C$P(/*KEEP_STR*/")");
            } finally {
              if (EOut != null) { EOut.$destroy(); }
            }
          }
        }
        if ((CDecl != null)) {
          boolean HasInitializerList = false;
          for (/*const*/ CXXCtorInitializer /*P*/ BMInitializer : CDecl.inits()) {
            if (BMInitializer.isInClassMemberInitializer()) {
              continue;
            }
            if (!HasInitializerList) {
              Proto.$addassign_T$C$P(/*KEEP_STR*/" : ");
              Out.$out(Proto);
              Proto.clear();
              HasInitializerList = true;
            } else {
              Out.$out(/*KEEP_STR*/$COMMA_SPACE);
            }
            if (BMInitializer.isAnyMemberInitializer()) {
              FieldDecl /*P*/ FD = BMInitializer.getAnyMember();
              $out_raw_ostream_NamedDecl$C(Out, $Deref(FD));
            } else {
              Out.$out(new QualType(BMInitializer.getBaseClass(), 0).getAsString(Policy));
            }
            
            Out.$out(/*KEEP_STR*/$LPAREN);
            if (!(BMInitializer.getInit() != null)) {
              // Nothing to print
            } else {
              Expr /*P*/ Init = BMInitializer.getInit();
              {
                ExprWithCleanups /*P*/ Tmp = dyn_cast_ExprWithCleanups(Init);
                if ((Tmp != null)) {
                  Init = Tmp.getSubExpr();
                }
              }
              
              Init = Init.IgnoreParens();
              
              Expr /*P*/ SimpleInit = null;
              type$ptr<Expr /*P*/ /*P*/> Args = null;
              /*uint*/int NumArgs = 0;
              {
                ParenListExpr /*P*/ ParenList = dyn_cast_ParenListExpr(Init);
                if ((ParenList != null)) {
                  Args = $tryClone(ParenList.getExprs());
                  NumArgs = ParenList.getNumExprs();
                } else {
                  CXXConstructExpr /*P*/ Construct = dyn_cast_CXXConstructExpr(Init);
                  if ((Construct != null)) {
                    Args = $tryClone(Construct.getArgs());
                    NumArgs = Construct.getNumArgs();
                  } else {
                    SimpleInit = Init;
                  }
                }
              }
              if ((SimpleInit != null)) {
                SimpleInit.printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
              } else {
                for (/*uint*/int I = 0; I != NumArgs; ++I) {
                  assert (Args.$at(I) != null) : "Expected non-null Expr";
                  if (isa_CXXDefaultArgExpr(Args.$at(I))) {
                    break;
                  }
                  if ((I != 0)) {
                    Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                  }
                  Args.$at(I).printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
                }
              }
            }
            Out.$out(/*KEEP_STR*/$RPAREN);
            if (BMInitializer.isPackExpansion()) {
              Out.$out(/*KEEP_STR*/$ELLIPSIS);
            }
          }
        } else if (!(ConversionDecl != null) && !isa_CXXDestructorDecl(D)) {
          if ((FT != null) && FT.hasTrailingReturn()) {
            Out.$out(/*KEEP_STR*/"auto ").$out(Proto).$out(/*KEEP_STR*/" -> ");
            Proto.clear();
          }
          AFT.getReturnType().print(Out, Policy, new Twine(Proto));
          Proto.clear();
        }
        Out.$out(Proto);
      } else {
        Ty.print(Out, Policy, new Twine(Proto));
      }
    }
    
    prettyPrintAttributes(D);
    if (D.isPure()) {
      Out.$out(/*KEEP_STR*/" = 0");
    } else if (D.isDeletedAsWritten()) {
      Out.$out(/*KEEP_STR*/" = delete");
    } else if (D.isExplicitlyDefaulted()) {
      Out.$out(/*KEEP_STR*/" = default");
    } else if (D.doesThisDeclarationHaveABody() && !Policy.TerseOutput) {
      if (!D.hasPrototype() && (D.getNumParams() != 0)) {
        // This is a K&R function definition, so we need to print the
        // parameters.
        Out.$out_char($$LF);
        DeclPrinter ParamPrinter/*J*/= new DeclPrinter(Out, SubPolicy, Indentation);
        Indentation += $8bits_uint2uint(Policy.Indentation);
        for (/*uint*/int i = 0, e = D.getNumParams(); i != e; ++i) {
          Indent();
          ParamPrinter.VisitParmVarDecl(D.getParamDecl(i));
          Out.$out(/*KEEP_STR*/";\n");
        }
        Indentation -= $8bits_uint2uint(Policy.Indentation);
      } else {
        Out.$out_char($$SPACE);
      }
      if ((D.getBody() != null)) {
        D.getBody().printPretty(Out, (PrinterHelper /*P*/ )null, SubPolicy, Indentation);
      }
      Out.$out_char($$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 661,
   FQN="(anonymous namespace)::DeclPrinter::VisitFriendDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter15VisitFriendDeclEPN5clang10FriendDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter15VisitFriendDeclEPN5clang10FriendDeclE")
  //</editor-fold>
  public void VisitFriendDecl(FriendDecl /*P*/ D) {
    {
      TypeSourceInfo /*P*/ TSI = D.getFriendType();
      if ((TSI != null)) {
        /*uint*/int NumTPLists = D.getFriendTypeNumTemplateParameterLists();
        for (/*uint*/int i = 0; $less_uint(i, NumTPLists); ++i)  {
          PrintTemplateParameters(D.getFriendTypeTemplateParameterList(i));
        }
        Out.$out(/*KEEP_STR*/"friend ");
        Out.$out(/*KEEP_STR*/$SPACE).$out(TSI.getType().getAsString(Policy));
      } else {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D.getFriendDecl());
        if ((FD != null)) {
          Out.$out(/*KEEP_STR*/"friend ");
          VisitFunctionDecl(FD);
        } else {
          FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(D.getFriendDecl());
          if ((FTD != null)) {
            Out.$out(/*KEEP_STR*/"friend ");
            VisitFunctionTemplateDecl(FTD);
          } else {
            ClassTemplateDecl /*P*/ CTD = dyn_cast_ClassTemplateDecl(D.getFriendDecl());
            if ((CTD != null)) {
              Out.$out(/*KEEP_STR*/"friend ");
              VisitRedeclarableTemplateDecl(CTD);
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 686,
   FQN="(anonymous namespace)::DeclPrinter::VisitFieldDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter14VisitFieldDeclEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter14VisitFieldDeclEPN5clang9FieldDeclE")
  //</editor-fold>
  public void VisitFieldDecl(FieldDecl /*P*/ D) {
    // FIXME: add printing of pragma attributes if required.
    if (!Policy.SuppressSpecifiers && D.isMutable()) {
      Out.$out(/*KEEP_STR*/"mutable ");
    }
    if (!Policy.SuppressSpecifiers && D.isModulePrivate()) {
      Out.$out(/*KEEP_STR*/"__module_private__ ");
    }
    
    $out_raw_ostream_StreamedQualTypeHelper$C(Out, D.getASTContext().getUnqualifiedObjCPointerType(D.getType()).
            stream(Policy, new Twine(D.getName()), Indentation));
    if (D.isBitField()) {
      Out.$out(/*KEEP_STR*/" : ");
      D.getBitWidth().printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
    }
    
    Expr /*P*/ Init = D.getInClassInitializer();
    if (!Policy.SuppressInitializers && (Init != null)) {
      if (D.getInClassInitStyle() == InClassInitStyle.ICIS_ListInit) {
        Out.$out(/*KEEP_STR*/$SPACE);
      } else {
        Out.$out(/*KEEP_STR*/" = ");
      }
      Init.printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
    }
    prettyPrintAttributes(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 716,
   FQN="(anonymous namespace)::DeclPrinter::VisitVarDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter12VisitVarDeclEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter12VisitVarDeclEPN5clang7VarDeclE")
  //</editor-fold>
  public void VisitVarDecl(VarDecl /*P*/ D) {
    prettyPrintPragmas(D);
    
    QualType T = (D.getTypeSourceInfo() != null) ? D.getTypeSourceInfo().getType() : D.getASTContext().getUnqualifiedObjCPointerType(D.getType());
    if (!Policy.SuppressSpecifiers) {
      StorageClass SC = D.getStorageClass();
      if (SC != StorageClass.SC_None) {
        Out.$out(VarDecl.getStorageClassSpecifierString(SC)).$out(/*KEEP_STR*/$SPACE);
      }
      switch (D.getTSCSpec()) {
       case TSCS_unspecified:
        break;
       case TSCS___thread:
        Out.$out(/*KEEP_STR*/"__thread ");
        break;
       case TSCS__Thread_local:
        Out.$out(/*KEEP_STR*/"_Thread_local ");
        break;
       case TSCS_thread_local:
        Out.$out(/*KEEP_STR*/"thread_local ");
        break;
      }
      if (D.isModulePrivate()) {
        Out.$out(/*KEEP_STR*/"__module_private__ ");
      }
      if (D.isConstexpr()) {
        Out.$out(/*KEEP_STR*/"constexpr ");
        T.removeLocalConst();
      }
    }
    
    printDeclType(new QualType(T), D.getName());
    Expr /*P*/ Init = D.getInit();
    if (!Policy.SuppressInitializers && (Init != null)) {
      boolean ImplicitInit = false;
      {
        CXXConstructExpr /*P*/ Construct = dyn_cast_CXXConstructExpr(Init.IgnoreImplicit());
        if ((Construct != null)) {
          if (D.getInitStyle() == VarDecl.InitializationStyle.CallInit
             && !Construct.isListInitialization()) {
            ImplicitInit = Construct.getNumArgs() == 0
               || Construct.getArg(0).isDefaultArgument();
          }
        }
      }
      if (!ImplicitInit) {
        if ((D.getInitStyle() == VarDecl.InitializationStyle.CallInit) && !isa_ParenListExpr(Init)) {
          Out.$out(/*KEEP_STR*/$LPAREN);
        } else if (D.getInitStyle() == VarDecl.InitializationStyle.CInit) {
          Out.$out(/*KEEP_STR*/" = ");
        }
        PrintingPolicy SubPolicy/*J*/= new PrintingPolicy(Policy);
        SubPolicy.SuppressSpecifiers = false;
        SubPolicy.IncludeTagDefinition = false;
        Init.printPretty(Out, (PrinterHelper /*P*/ )null, SubPolicy, Indentation);
        if ((D.getInitStyle() == VarDecl.InitializationStyle.CallInit) && !isa_ParenListExpr(Init)) {
          Out.$out(/*KEEP_STR*/$RPAREN);
        }
      }
    }
    prettyPrintAttributes(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitLabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 712,
   FQN="(anonymous namespace)::DeclPrinter::VisitLabelDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter14VisitLabelDeclEPN5clang9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter14VisitLabelDeclEPN5clang9LabelDeclE")
  //</editor-fold>
  public void VisitLabelDecl(LabelDecl /*P*/ D) {
    $out_raw_ostream_NamedDecl$C(Out, $Deref(D)).$out(/*KEEP_STR*/$COLON);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 780,
   FQN="(anonymous namespace)::DeclPrinter::VisitParmVarDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter16VisitParmVarDeclEPN5clang11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter16VisitParmVarDeclEPN5clang11ParmVarDeclE")
  //</editor-fold>
  public void VisitParmVarDecl(ParmVarDecl /*P*/ D) {
    VisitVarDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitFileScopeAsmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 784,
   FQN="(anonymous namespace)::DeclPrinter::VisitFileScopeAsmDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter21VisitFileScopeAsmDeclEPN5clang16FileScopeAsmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21VisitFileScopeAsmDeclEPN5clang16FileScopeAsmDeclE")
  //</editor-fold>
  public void VisitFileScopeAsmDecl(FileScopeAsmDecl /*P*/ D) {
    Out.$out(/*KEEP_STR*/"__asm (");
    D.getAsmString().printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
    Out.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 790,
   FQN="(anonymous namespace)::DeclPrinter::VisitImportDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter15VisitImportDeclEPN5clang10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter15VisitImportDeclEPN5clang10ImportDeclE")
  //</editor-fold>
  public void VisitImportDecl(ImportDecl /*P*/ D) {
    Out.$out(/*KEEP_STR*/"@import ").$out(D.getImportedModule().getFullModuleName()).$out(
        /*KEEP_STR*/";\n"
    );
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitStaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 795,
   FQN="(anonymous namespace)::DeclPrinter::VisitStaticAssertDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter21VisitStaticAssertDeclEPN5clang16StaticAssertDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21VisitStaticAssertDeclEPN5clang16StaticAssertDeclE")
  //</editor-fold>
  public void VisitStaticAssertDecl(StaticAssertDecl /*P*/ D) {
    Out.$out(/*KEEP_STR*/"static_assert(");
    D.getAssertExpr().printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
    {
      StringLiteral /*P*/ SL = D.getMessage();
      if ((SL != null)) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        SL.printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
      }
    }
    Out.$out(/*KEEP_STR*/$RPAREN);
  }

  
  //----------------------------------------------------------------------------
  // C++ declarations
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 808,
   FQN="(anonymous namespace)::DeclPrinter::VisitNamespaceDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter18VisitNamespaceDeclEPN5clang13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter18VisitNamespaceDeclEPN5clang13NamespaceDeclE")
  //</editor-fold>
  public void VisitNamespaceDecl(NamespaceDecl /*P*/ D) {
    if (D.isInline()) {
      Out.$out(/*KEEP_STR*/"inline ");
    }
    $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"namespace "), $Deref(D)).$out(/*KEEP_STR*/" {\n");
    VisitDeclContext(D);
    Indent().$out(/*KEEP_STR*/$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitUsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 816,
   FQN="(anonymous namespace)::DeclPrinter::VisitUsingDirectiveDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter23VisitUsingDirectiveDeclEPN5clang18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter23VisitUsingDirectiveDeclEPN5clang18UsingDirectiveDeclE")
  //</editor-fold>
  public void VisitUsingDirectiveDecl(UsingDirectiveDecl /*P*/ D) {
    Out.$out(/*KEEP_STR*/"using namespace ");
    if ((D.getQualifier() != null)) {
      D.getQualifier().print(Out, Policy);
    }
    $out_raw_ostream_NamedDecl$C(Out, $Deref(D.getNominatedNamespaceAsWritten()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitNamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 823,
   FQN="(anonymous namespace)::DeclPrinter::VisitNamespaceAliasDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter23VisitNamespaceAliasDeclEPN5clang18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter23VisitNamespaceAliasDeclEPN5clang18NamespaceAliasDeclE")
  //</editor-fold>
  public void VisitNamespaceAliasDecl(NamespaceAliasDecl /*P*/ D) {
    $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"namespace "), $Deref(D)).$out(/*KEEP_STR*/" = ");
    if ((D.getQualifier() != null)) {
      D.getQualifier().print(Out, Policy);
    }
    $out_raw_ostream_NamedDecl$C(Out, $Deref(D.getAliasedNamespace()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 834,
   FQN="(anonymous namespace)::DeclPrinter::VisitCXXRecordDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter18VisitCXXRecordDeclEPN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter18VisitCXXRecordDeclEPN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void VisitCXXRecordDecl(CXXRecordDecl /*P*/ D) {
    // FIXME: add printing of pragma attributes if required.
    if (!Policy.SuppressSpecifiers && D.isModulePrivate()) {
      Out.$out(/*KEEP_STR*/"__module_private__ ");
    }
    Out.$out(D.getKindName());
    
    prettyPrintAttributes(D);
    if ((D.getIdentifier() != null)) {
      $out_raw_ostream_NamedDecl$C(Out.$out_char($$SPACE), $Deref(D));
    }
    if (D.isCompleteDefinition()) {
      // Print the base classes
      if ((D.getNumBases() != 0)) {
        Out.$out(/*KEEP_STR*/" : ");
        for (type$ptr<CXXBaseSpecifier /*P*/ > Base = $tryClone(D.bases_begin()), 
            /*P*/ BaseEnd = $tryClone(D.bases_end()); $noteq_ptr(Base, BaseEnd); Base.$preInc()) {
          if ($noteq_ptr(Base, D.bases_begin())) {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          if (Base./*->*/$star().isVirtual()) {
            Out.$out(/*KEEP_STR*/"virtual ");
          }
          
          AccessSpecifier AS = Base./*->*/$star().getAccessSpecifierAsWritten();
          if (AS != AccessSpecifier.AS_none) {
            Print(AS);
            Out.$out(/*KEEP_STR*/$SPACE);
          }
          Out.$out(Base./*->*/$star().getType().getAsString(Policy));
          if (Base./*->*/$star().isPackExpansion()) {
            Out.$out(/*KEEP_STR*/$ELLIPSIS);
          }
        }
      }
      
      // Print the class definition
      // FIXME: Doesn't print access specifiers, e.g., "public:"
      Out.$out(/*KEEP_STR*/" {\n");
      VisitDeclContext(D);
      Indent().$out(/*KEEP_STR*/$RCURLY);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitLinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 877,
   FQN="(anonymous namespace)::DeclPrinter::VisitLinkageSpecDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter20VisitLinkageSpecDeclEPN5clang15LinkageSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter20VisitLinkageSpecDeclEPN5clang15LinkageSpecDeclE")
  //</editor-fold>
  public void VisitLinkageSpecDecl(LinkageSpecDecl /*P*/ D) {
    /*const*/char$ptr/*char P*/ l = create_char$ptr();
    if (D.getLanguage() == LinkageSpecDecl.LanguageIDs.lang_c) {
      l = $tryClone($C);
    } else {
      assert (D.getLanguage() == LinkageSpecDecl.LanguageIDs.lang_cxx) : "unknown language in linkage specification";
      l = $tryClone($("C++"));
    }
    
    Out.$out(/*KEEP_STR*/"extern \"").$out(l).$out(/*KEEP_STR*/"\" ");
    if (D.hasBraces()) {
      Out.$out(/*KEEP_STR*/"{\n");
      VisitDeclContext(D);
      Indent().$out(/*KEEP_STR*/$RCURLY);
    } else {
      Visit(D.decls_begin().$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 953,
   FQN="(anonymous namespace)::DeclPrinter::VisitTemplateDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter17VisitTemplateDeclEPKN5clang12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter17VisitTemplateDeclEPKN5clang12TemplateDeclE")
  //</editor-fold>
  public void VisitTemplateDecl(/*const*/ TemplateDecl /*P*/ D) {
    PrintTemplateParameters(D.getTemplateParameters());
    {
      
      /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(D);
      if ((TTP != null)) {
        Out.$out(/*KEEP_STR*/"class ");
        if (TTP.isParameterPack()) {
          Out.$out(/*KEEP_STR*/$ELLIPSIS);
        }
        Out.$out(D.getName());
      } else {
        Visit(D.getTemplatedDecl());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 967,
   FQN="(anonymous namespace)::DeclPrinter::VisitFunctionTemplateDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter25VisitFunctionTemplateDeclEPN5clang20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter25VisitFunctionTemplateDeclEPN5clang20FunctionTemplateDeclE")
  //</editor-fold>
  public void VisitFunctionTemplateDecl(FunctionTemplateDecl /*P*/ D) {
    if (PrintInstantiation) {
      TemplateParameterList /*P*/ Params = D.getTemplateParameters();
      for (FunctionDecl /*P*/ I : D.specializations()) {
        prettyPrintPragmas(I);
        PrintTemplateParameters(Params, I.getTemplateSpecializationArgs());
        Visit(I);
      }
    }
    
    prettyPrintPragmas(D.getTemplatedDecl());
    VisitRedeclarableTemplateDecl(D);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 981,
   FQN="(anonymous namespace)::DeclPrinter::VisitClassTemplateDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter22VisitClassTemplateDeclEPN5clang17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter22VisitClassTemplateDeclEPN5clang17ClassTemplateDeclE")
  //</editor-fold>
  public void VisitClassTemplateDecl(ClassTemplateDecl /*P*/ D) {
    if (PrintInstantiation) {
      TemplateParameterList /*P*/ Params = D.getTemplateParameters();
      for (ClassTemplateSpecializationDecl /*P*/ I : D.specializations()) {
        PrintTemplateParameters(Params, $AddrOf(I.getTemplateArgs()));
        Visit(I);
        Out.$out_char($$LF);
      }
    }
    
    VisitRedeclarableTemplateDecl(D);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1055,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCMethodDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter19VisitObjCMethodDeclEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter19VisitObjCMethodDeclEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void VisitObjCMethodDecl(ObjCMethodDecl /*P*/ OMD) {
    if (OMD.isInstanceMethod()) {
      Out.$out(/*KEEP_STR*/"- ");
    } else {
      Out.$out(/*KEEP_STR*/"+ ");
    }
    if (!OMD.getReturnType().isNull()) {
      PrintObjCMethodType(OMD.getASTContext(), OMD.getObjCDeclQualifier(), 
          OMD.getReturnType());
    }
    
    std.string name = OMD.getSelector().getAsString();
    /*size_t*/int pos;
    /*size_t*/int lastPos = 0;
    for (/*const*/ ParmVarDecl /*P*/ PI : OMD.parameters()) {
      // FIXME: selector is missing here!
      pos = name.find_first_of_T_$_CharT($$COLON, lastPos);
      Out.$out(/*KEEP_STR*/$SPACE).$out(name.substr(lastPos, pos - lastPos)).$out_char($$COLON);
      PrintObjCMethodType(OMD.getASTContext(), 
          PI.getObjCDeclQualifier(), 
          PI.getType());
      $out_raw_ostream_NamedDecl$C(Out, $Deref(PI));
      lastPos = pos + 1;
    }
    if ($eq_ptr(OMD.param_begin(), OMD.param_end())) {
      Out.$out(/*KEEP_STR*/$SPACE).$out(name);
    }
    if (OMD.isVariadic()) {
      Out.$out(/*KEEP_STR*/", ...");
    }
    
    prettyPrintAttributes(OMD);
    if ((OMD.getBody() != null) && !Policy.TerseOutput) {
      Out.$out_char($$SPACE);
      OMD.getBody().printPretty(Out, (PrinterHelper /*P*/ )null, Policy);
    } else if (Policy.PolishForDeclaration) {
      Out.$out_char($$SEMI);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1094,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCImplementationDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter27VisitObjCImplementationDeclEPN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter27VisitObjCImplementationDeclEPN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  public void VisitObjCImplementationDecl(ObjCImplementationDecl /*P*/ OID) {
    std.string I = OID.getNameAsString();
    ObjCInterfaceDecl /*P*/ SID = OID.getSuperClass();
    
    boolean eolnOut = false;
    if ((SID != null)) {
      $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@implementation ").$out(I).$out(/*KEEP_STR*/" : "), $Deref(SID));
    } else {
      Out.$out(/*KEEP_STR*/"@implementation ").$out(I);
    }
    if ($greater_uint(OID.ivar_size(), 0)) {
      Out.$out(/*KEEP_STR*/"{\n");
      eolnOut = true;
      Indentation += $8bits_uint2uint(Policy.Indentation);
      for (/*const*/ ObjCIvarDecl /*P*/ I$1 : OID.ivars()) {
        $out_raw_ostream_NamedDecl$C(Indent().$out(I$1.getASTContext().getUnqualifiedObjCPointerType(I$1.getType()).
                    getAsString(Policy)).$out_char($$SPACE), $Deref(I$1)).$out(/*KEEP_STR*/";\n");
      }
      Indentation -= $8bits_uint2uint(Policy.Indentation);
      Out.$out(/*KEEP_STR*/"}\n");
    } else if ((SID != null) || ($noteq_decl_iterator(OID.decls_begin(), OID.decls_end()))) {
      Out.$out(/*KEEP_STR*/$LF);
      eolnOut = true;
    }
    VisitDeclContext(OID, false);
    if (!eolnOut) {
      Out.$out(/*KEEP_STR*/$LF);
    }
    Out.$out(/*KEEP_STR*/"@end");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1125,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCInterfaceDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter22VisitObjCInterfaceDeclEPN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter22VisitObjCInterfaceDeclEPN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  public void VisitObjCInterfaceDecl(ObjCInterfaceDecl /*P*/ OID) {
    std.string I = OID.getNameAsString();
    ObjCInterfaceDecl /*P*/ SID = OID.getSuperClass();
    if (!OID.isThisDeclarationADefinition()) {
      Out.$out(/*KEEP_STR*/"@class ").$out(I);
      {
        
        ObjCTypeParamList /*P*/ TypeParams = OID.getTypeParamListAsWritten();
        if ((TypeParams != null)) {
          PrintObjCTypeParams(TypeParams);
        }
      }
      
      Out.$out(/*KEEP_STR*/$SEMI);
      return;
    }
    boolean eolnOut = false;
    Out.$out(/*KEEP_STR*/"@interface ").$out(I);
    {
      
      ObjCTypeParamList /*P*/ TypeParams = OID.getTypeParamListAsWritten();
      if ((TypeParams != null)) {
        PrintObjCTypeParams(TypeParams);
      }
    }
    if ((SID != null)) {
      Out.$out(/*KEEP_STR*/" : ").$out(new QualType(OID.getSuperClassType(), 0).getAsString(Policy));
    }
    
    // Protocols?
    final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = OID.getReferencedProtocols();
    if (!Protocols.empty()) {
      for (type$ptr<ObjCProtocolDecl> I$1 = $tryClone(Protocols.begin()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end()); $noteq_ptr(I$1, E); I$1.$preInc())  {
        $out_raw_ostream_NamedDecl$C(Out.$out_char(($eq_ptr(I$1, Protocols.begin()) ? $$LT : $$COMMA)), $Deref(I$1.$star()));
      }
      Out.$out(/*KEEP_STR*/"> ");
    }
    if ($greater_uint(OID.ivar_size(), 0)) {
      Out.$out(/*KEEP_STR*/"{\n");
      eolnOut = true;
      Indentation += $8bits_uint2uint(Policy.Indentation);
      for (/*const*/ ObjCIvarDecl /*P*/ I$1 : OID.ivars()) {
        $out_raw_ostream_NamedDecl$C(Indent().$out(I$1.getASTContext().
                    getUnqualifiedObjCPointerType(I$1.getType()).
                    getAsString(Policy)).$out_char($$SPACE), $Deref(I$1)).$out(/*KEEP_STR*/";\n");
      }
      Indentation -= $8bits_uint2uint(Policy.Indentation);
      Out.$out(/*KEEP_STR*/"}\n");
    } else if ((SID != null) || ($noteq_decl_iterator(OID.decls_begin(), OID.decls_end()))) {
      Out.$out(/*KEEP_STR*/$LF);
      eolnOut = true;
    }
    
    VisitDeclContext(OID, false);
    if (!eolnOut) {
      Out.$out(/*KEEP_STR*/$LF);
    }
    Out.$out(/*KEEP_STR*/"@end");
    // FIXME: implement the rest...
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1182,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCProtocolDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter21VisitObjCProtocolDeclEPN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21VisitObjCProtocolDeclEPN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  public void VisitObjCProtocolDecl(ObjCProtocolDecl /*P*/ PID) {
    if (!PID.isThisDeclarationADefinition()) {
      $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@protocol "), $Deref(PID)).$out(/*KEEP_STR*/";\n");
      return;
    }
    // Protocols?
    final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = PID.getReferencedProtocols();
    if (!Protocols.empty()) {
      $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@protocol "), $Deref(PID));
      for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end()); $noteq_ptr(I, E); I.$preInc())  {
        $out_raw_ostream_NamedDecl$C(Out.$out_char(($eq_ptr(I, Protocols.begin()) ? $$LT : $$COMMA)), $Deref(I.$star()));
      }
      Out.$out(/*KEEP_STR*/$GT_LF);
    } else {
      $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@protocol "), $Deref(PID)).$out_char($$LF);
    }
    VisitDeclContext(PID, false);
    Out.$out(/*KEEP_STR*/"@end");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1201,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCCategoryImplDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter25VisitObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter25VisitObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void VisitObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ PID) {
    $out_raw_ostream_ObjCCategoryImplDecl$C($out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@implementation "), $Deref(PID.getClassInterface())).$out_char($$LPAREN), $Deref(PID)).$out(/*KEEP_STR*/")\n");
    
    VisitDeclContext(PID, false);
    Out.$out(/*KEEP_STR*/"@end");
    // FIXME: implement the rest...
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1209,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCCategoryDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter21VisitObjCCategoryDeclEPN5clang16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21VisitObjCCategoryDeclEPN5clang16ObjCCategoryDeclE")
  //</editor-fold>
  public void VisitObjCCategoryDecl(ObjCCategoryDecl /*P*/ PID) {
    $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@interface "), $Deref(PID.getClassInterface()));
    {
      ObjCTypeParamList /*P*/ TypeParams = PID.getTypeParamList();
      if ((TypeParams != null)) {
        PrintObjCTypeParams(TypeParams);
      }
    }
    $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$LPAREN), $Deref(PID)).$out(/*KEEP_STR*/")\n");
    if ($greater_uint(PID.ivar_size(), 0)) {
      Out.$out(/*KEEP_STR*/"{\n");
      Indentation += $8bits_uint2uint(Policy.Indentation);
      for (/*const*/ ObjCIvarDecl /*P*/ I : PID.ivars())  {
        $out_raw_ostream_NamedDecl$C(Indent().$out(I.getASTContext().getUnqualifiedObjCPointerType(I.getType()).
                    getAsString(Policy)).$out_char($$SPACE), $Deref(I)).$out(/*KEEP_STR*/";\n");
      }
      Indentation -= $8bits_uint2uint(Policy.Indentation);
      Out.$out(/*KEEP_STR*/"}\n");
    }
    
    VisitDeclContext(PID, false);
    Out.$out(/*KEEP_STR*/"@end");
    // FIXME: implement the rest...
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1231,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCCompatibleAliasDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter28VisitObjCCompatibleAliasDeclEPN5clang23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter28VisitObjCCompatibleAliasDeclEPN5clang23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  public void VisitObjCCompatibleAliasDecl(ObjCCompatibleAliasDecl /*P*/ AID) {
    $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"@compatibility_alias "), $Deref(AID)).$out_char(
            $$SPACE
        ), $Deref(AID.getClassInterface())).$out(/*KEEP_STR*/";\n");
  }

  
  /// PrintObjCPropertyDecl - print a property declaration.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1238,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCPropertyDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter21VisitObjCPropertyDeclEPN5clang16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21VisitObjCPropertyDeclEPN5clang16ObjCPropertyDeclE")
  //</editor-fold>
  public void VisitObjCPropertyDecl(ObjCPropertyDecl /*P*/ PDecl) {
    if (PDecl.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Required) {
      Out.$out(/*KEEP_STR*/"@required\n");
    } else if (PDecl.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Optional) {
      Out.$out(/*KEEP_STR*/"@optional\n");
    }
    
    QualType T = PDecl.getType();
    
    Out.$out(/*KEEP_STR*/"@property");
    if (PDecl.getPropertyAttributes() != ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_noattr) {
      boolean first = true;
      Out.$out(/*KEEP_STR*/" (");
      if (((PDecl.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"readonly");
        first = false;
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_getter) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"getter = ");
        PDecl.getGetterName().print(Out);
        first = false;
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_setter) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"setter = ");
        PDecl.getSetterName().print(Out);
        first = false;
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"assign");
        first = false;
      }
      if (((PDecl.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"readwrite");
        first = false;
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"retain");
        first = false;
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"strong");
        first = false;
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"copy");
        first = false;
      }
      if (((PDecl.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"nonatomic");
        first = false;
      }
      if (((PDecl.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"atomic");
        first = false;
      }
      if (((PDecl.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nullability) != 0)) {
        {
          Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(T);
          if (nullability.$bool()) {
            if (nullability.$star() == NullabilityKind.Unspecified
               && ((PDecl.getPropertyAttributes()
               & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_null_resettable) != 0)) {
              Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/"null_resettable");
            } else {
              Out.$out_char((first ? $$SPACE : $$COMMA)).$out(
                  getNullabilitySpelling(nullability.$star(), true)
              );
            }
            first = false;
          }
        }
      }
      if (((PDecl.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_class) != 0)) {
        Out.$out_char((first ? $$SPACE : $$COMMA)).$out(/*KEEP_STR*/$class);
        first = false;
      }
      
      ///*J:(void)*/first; // Silence dead store warning due to idiomatic code.
      Out.$out(/*KEEP_STR*/" )");
    }
    $out_raw_ostream_NamedDecl$C(Out.$out_char($$SPACE).$out(PDecl.getASTContext().getUnqualifiedObjCPointerType(new QualType(T)).
                getAsString(Policy)).$out_char($$SPACE), $Deref(PDecl));
    if (Policy.PolishForDeclaration) {
      Out.$out_char($$SEMI);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1333,
   FQN="(anonymous namespace)::DeclPrinter::VisitObjCPropertyImplDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter25VisitObjCPropertyImplDeclEPN5clang20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter25VisitObjCPropertyImplDeclEPN5clang20ObjCPropertyImplDeclE")
  //</editor-fold>
  public void VisitObjCPropertyImplDecl(ObjCPropertyImplDecl /*P*/ PID) {
    if (PID.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Synthesize) {
      Out.$out(/*KEEP_STR*/"@synthesize ");
    } else {
      Out.$out(/*KEEP_STR*/"@dynamic ");
    }
    $out_raw_ostream_NamedDecl$C(Out, $Deref(PID.getPropertyDecl()));
    if ((PID.getPropertyIvarDecl() != null)) {
      $out_raw_ostream_NamedDecl$C(Out.$out_char($$EQ), $Deref(PID.getPropertyIvarDecl()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitUnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1352,
   FQN="(anonymous namespace)::DeclPrinter::VisitUnresolvedUsingTypenameDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter32VisitUnresolvedUsingTypenameDeclEPN5clang27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter32VisitUnresolvedUsingTypenameDeclEPN5clang27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypenameDecl(UnresolvedUsingTypenameDecl /*P*/ D) {
    Out.$out(/*KEEP_STR*/"using typename ");
    D.getQualifier().print(Out, Policy);
    $out_raw_ostream_DeclarationName(Out, D.getDeclName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitUnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1359,
   FQN="(anonymous namespace)::DeclPrinter::VisitUnresolvedUsingValueDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter29VisitUnresolvedUsingValueDeclEPN5clang24UnresolvedUsingValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter29VisitUnresolvedUsingValueDeclEPN5clang24UnresolvedUsingValueDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingValueDecl(UnresolvedUsingValueDecl /*P*/ D) {
    if (!D.isAccessDeclaration()) {
      Out.$out(/*KEEP_STR*/"using ");
    }
    D.getQualifier().print(Out, Policy);
    $out_raw_ostream_DeclarationName(Out, D.getDeclName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1343,
   FQN="(anonymous namespace)::DeclPrinter::VisitUsingDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter14VisitUsingDeclEPN5clang9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter14VisitUsingDeclEPN5clang9UsingDeclE")
  //</editor-fold>
  public void VisitUsingDecl(UsingDecl /*P*/ D) {
    if (!D.isAccessDeclaration()) {
      Out.$out(/*KEEP_STR*/"using ");
    }
    if (D.hasTypename()) {
      Out.$out(/*KEEP_STR*/"typename ");
    }
    D.getQualifier().print(Out, Policy);
    $out_raw_ostream_NamedDecl$C(Out, $Deref(D));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1366,
   FQN="(anonymous namespace)::DeclPrinter::VisitUsingShadowDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter20VisitUsingShadowDeclEPN5clang15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter20VisitUsingShadowDeclEPN5clang15UsingShadowDeclE")
  //</editor-fold>
  public void VisitUsingShadowDecl(UsingShadowDecl /*P*/ D) {
    // ignore
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitOMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1370,
   FQN="(anonymous namespace)::DeclPrinter::VisitOMPThreadPrivateDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter25VisitOMPThreadPrivateDeclEPN5clang20OMPThreadPrivateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter25VisitOMPThreadPrivateDeclEPN5clang20OMPThreadPrivateDeclE")
  //</editor-fold>
  public void VisitOMPThreadPrivateDecl(OMPThreadPrivateDecl /*P*/ D) {
    Out.$out(/*KEEP_STR*/"#pragma omp threadprivate");
    if (!D.varlist_empty()) {
      for (type$ptr<Expr/*P*/>/*iterator*/ I = $tryClone(D.varlist_begin()), 
          /*P*/ E = $tryClone(D.varlist_end());
           $noteq_ptr(I, E); I.$preInc()) {
        Out.$out_char(($eq_ptr(I, D.varlist_begin()) ? $$LPAREN : $$COMMA));
        NamedDecl /*P*/ ND = cast_NamedDecl(cast_DeclRefExpr(I.$star()).getDecl());
        ND.printQualifiedName(Out);
      }
      Out.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitOMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1384,
   FQN="(anonymous namespace)::DeclPrinter::VisitOMPDeclareReductionDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter28VisitOMPDeclareReductionDeclEPN5clang23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter28VisitOMPDeclareReductionDeclEPN5clang23OMPDeclareReductionDeclE")
  //</editor-fold>
  public void VisitOMPDeclareReductionDecl(OMPDeclareReductionDecl /*P*/ D) {
    if (!D.isInvalidDecl()) {
      Out.$out(/*KEEP_STR*/"#pragma omp declare reduction (");
      if (D.getDeclName().getNameKind() == DeclarationName.NameKind.CXXOperatorName) {
        final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[45]*/> OperatorNames = VisitOMPDeclareReductionDecl$$.OperatorNames;
        /*const*/char$ptr/*char P*/ OpName = $tryClone(OperatorNames.$at(D.getDeclName().getCXXOverloadedOperator().getValue()));
        assert (Native.$bool(OpName)) : "not an overloaded operator";
        Out.$out(OpName);
      } else {
        assert (D.getDeclName().isIdentifier());
        D.printName(Out);
      }
      Out.$out(/*KEEP_STR*/" : ");
      D.getType().print(Out, Policy);
      Out.$out(/*KEEP_STR*/" : ");
      D.getCombiner().printPretty(Out, (PrinterHelper /*P*/ )null, Policy, 0);
      Out.$out(/*KEEP_STR*/$RPAREN);
      {
        Expr /*P*/ Init = D.getInitializer();
        if ((Init != null)) {
          Out.$out(/*KEEP_STR*/" initializer(");
          Init.printPretty(Out, (PrinterHelper /*P*/ )null, Policy, 0);
          Out.$out(/*KEEP_STR*/$RPAREN);
        }
      }
    }
  }
  private static final class VisitOMPDeclareReductionDecl$$ {
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[45]*/> OperatorNames = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*45*/] {
      (/*const*/char$ptr/*char P*//*const*/)null, 
      $new, 
      $delete, 
      $new_LSQUARE_RSQUARE, 
      $delete_LSQUARE_RSQUARE, 
      $PLUS, 
      $MINUS, 
      $STAR, 
      $SLASH, 
      $PERCENT, 
      $CARET, 
      $AMP, 
      $PIPE, 
      $TILDE, 
      $EXCLAIM, 
      $EQ, 
      $LT, 
      $GT, 
      $PLUS_EQ, 
      $MINUS_EQ, 
      $STAR_EQ, 
      $SLASH_EQ, 
      $PERCENT_EQ, 
      $CARET_EQ, 
      $AMP_EQ, 
      $PIPE_EQ, 
      $LT_LT, 
      $GT_GT, 
      $LT_LT_EQ, 
      $GT_GT_EQ, 
      $EQ_EQ, 
      $EXCLAIM_EQ, 
      $LT_EQ, 
      $GT_EQ, 
      $AMP_AMP, 
      $PIPE_PIPE, 
      $PLUS_PLUS, 
      $MINUS_MINUS, 
      $COMMA, 
      $ARROW_STAR, 
      $ARROW, 
      $LPAREN_RPAREN, 
      $LSQUARE_RSQUARE, 
      // ?: can *not* be overloaded, but we need the overload
      // resolution machinery for it.
      $QMARK, 
      $co_await
    });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::VisitOMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 1415,
   FQN="(anonymous namespace)::DeclPrinter::VisitOMPCapturedExprDecl", NM="_ZN12_GLOBAL__N_111DeclPrinter24VisitOMPCapturedExprDeclEPN5clang19OMPCapturedExprDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter24VisitOMPCapturedExprDeclEPN5clang19OMPCapturedExprDeclE")
  //</editor-fold>
  public void VisitOMPCapturedExprDecl(OMPCapturedExprDecl /*P*/ D) {
    D.getInit().printPretty(Out, (PrinterHelper /*P*/ )null, Policy, Indentation);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::PrintTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 896,
   FQN="(anonymous namespace)::DeclPrinter::PrintTemplateParameters", NM="_ZN12_GLOBAL__N_111DeclPrinter23PrintTemplateParametersEPKN5clang21TemplateParameterListEPKNS1_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter23PrintTemplateParametersEPKN5clang21TemplateParameterListEPKNS1_20TemplateArgumentListE")
  //</editor-fold>
  public void PrintTemplateParameters(/*const*/ TemplateParameterList /*P*/ Params) {
    PrintTemplateParameters(Params, 
                         (/*const*/ TemplateArgumentList /*P*/ )null);
  }
  public void PrintTemplateParameters(/*const*/ TemplateParameterList /*P*/ Params, 
                         /*const*/ TemplateArgumentList /*P*/ Args/*= null*/) {
    assert Native.$bool(Params);
    assert (!(Args != null) || Params.size() == Args.size());
    
    Out.$out(/*KEEP_STR*/"template <");
    
    for (/*uint*/int i = 0, e = Params.size(); i != e; ++i) {
      if (i != 0) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      
      /*const*/ Decl /*P*/ Param = Params.getParam$Const(i);
      {
        /*const*/ TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Param);
        if ((TTP != null)) {
          if (TTP.wasDeclaredWithTypename()) {
            Out.$out(/*KEEP_STR*/"typename ");
          } else {
            Out.$out(/*KEEP_STR*/"class ");
          }
          if (TTP.isParameterPack()) {
            Out.$out(/*KEEP_STR*/$ELLIPSIS);
          }
          
          $out_raw_ostream_NamedDecl$C(Out, $Deref(TTP));
          if ((Args != null)) {
            Out.$out(/*KEEP_STR*/" = ");
            Args.get(i).print(Policy, Out);
          } else if (TTP.hasDefaultArgument()) {
            Out.$out(/*KEEP_STR*/" = ");
            Out.$out(TTP.getDefaultArgument().getAsString(Policy));
          }
          ;
        } else {
          /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
          if ((NTTP != null)) {
            StringRef Name/*J*/= new StringRef();
            {
              IdentifierInfo /*P*/ II = NTTP.getIdentifier();
              if ((II != null)) {
                Name.$assignMove(II.getName());
              }
            }
            printDeclType(NTTP.getType(), new StringRef(Name), NTTP.isParameterPack());
            if ((Args != null)) {
              Out.$out(/*KEEP_STR*/" = ");
              Args.get(i).print(Policy, Out);
            } else if (NTTP.hasDefaultArgument()) {
              Out.$out(/*KEEP_STR*/" = ");
              NTTP.getDefaultArgument().printPretty(Out, (PrinterHelper /*P*/ )null, Policy, 
                  Indentation);
            }
          } else {
            /*const*/ TemplateTemplateParmDecl /*P*/ TTPD = dyn_cast_TemplateTemplateParmDecl(Param);
            if ((TTPD != null)) {
              VisitTemplateDecl(TTPD);
              // FIXME: print the default argument, if present.
            }
          }
        }
      }
    }
    
    Out.$out(/*KEEP_STR*/"> ");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::prettyPrintAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 200,
   FQN="(anonymous namespace)::DeclPrinter::prettyPrintAttributes", NM="_ZN12_GLOBAL__N_111DeclPrinter21prettyPrintAttributesEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter21prettyPrintAttributesEPN5clang4DeclE")
  //</editor-fold>
  public void prettyPrintAttributes(Decl /*P*/ D) {
    if (Policy.PolishForDeclaration) {
      return;
    }
    if (D.hasAttrs()) {
      final SmallVector<Attr /*P*/>/*&*/ Attrs = D.getAttrs();
      for (Attr /*P*/ A : Attrs) {
        switch (A.getKind()) {
         case InitSeg:
         case LoopHint:
         case OMPDeclareSimdDecl:
         case OMPDeclareTargetDecl:
          break;
         default:
          A.printPretty(Out, Policy);
          break;
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::prettyPrintPragmas">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 220,
   FQN="(anonymous namespace)::DeclPrinter::prettyPrintPragmas", NM="_ZN12_GLOBAL__N_111DeclPrinter18prettyPrintPragmasEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter18prettyPrintPragmasEPN5clang4DeclE")
  //</editor-fold>
  public void prettyPrintPragmas(Decl /*P*/ D) {
    if (Policy.PolishForDeclaration) {
      return;
    }
    if (D.hasAttrs()) {
      final SmallVector<Attr /*P*/>/*&*/ Attrs = D.getAttrs();
      for (Attr /*P*/ A : Attrs) {
        switch (A.getKind()) {
         case InitSeg:
         case LoopHint:
         case OMPDeclareSimdDecl:
         case OMPDeclareTargetDecl:
          A.printPretty(Out, Policy);
          Indent();
          break;
         default:
          break;
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclPrinter::printDeclType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 241,
   FQN="(anonymous namespace)::DeclPrinter::printDeclType", NM="_ZN12_GLOBAL__N_111DeclPrinter13printDeclTypeEN5clang8QualTypeEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN12_GLOBAL__N_111DeclPrinter13printDeclTypeEN5clang8QualTypeEN4llvm9StringRefEb")
  //</editor-fold>
  public void printDeclType(QualType T, StringRef DeclName) {
    printDeclType(T, DeclName, false);
  }
  public void printDeclType(QualType T, StringRef DeclName, boolean Pack/*= false*/) {
    {
      // Normally, a PackExpansionType is written as T[3]... (for instance, as a
      // template argument), but if it is the type of a declaration, the ellipsis
      // is placed before the name being declared.
      /*const*/ PackExpansionType /*P*/ PET = T.$arrow().getAs(PackExpansionType.class);
      if ((PET != null)) {
        Pack = true;
        T.$assignMove(PET.getPattern());
      }
    }
    T.print(Out, Policy, $add_char$ptr$C_StringRef$C((Pack ? $ELLIPSIS : $EMPTY), DeclName), Indentation);
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", Policy=" + Policy // NOI18N
              + ", Indentation=" + Indentation // NOI18N
              + ", PrintInstantiation=" + PrintInstantiation // NOI18N
              + super.toString(); // NOI18N
  }
}

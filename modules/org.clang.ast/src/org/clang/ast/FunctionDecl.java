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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.QualType.*;
import org.clang.ast.comments.CommandTraits;
import org.clang.ast.impl.ASTDumper;
import static org.clang.ast.impl.DeclStatics.*;
import org.clang.ast.java.ExternC;


/// FunctionDecl - An instance of this class is created to represent a
/// function declaration or definition.
///
/// Since a given function can be declared several times in a program,
/// there may be several FunctionDecls that correspond to that
/// function. Only one of those FunctionDecls will be found when
/// traversing the list of declarations in the context of the
/// FunctionDecl (e.g., the translation unit); this FunctionDecl
/// contains all of the information known about the function. Other,
/// previous declarations of the function are available via the
/// getPreviousDecl() chain.
//<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1561,
 FQN="clang::FunctionDecl", NM="_ZN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDeclE")
//</editor-fold>
public class FunctionDecl extends /*public*/ DeclaratorDecl implements /*public*/ DeclContext, /*public*/ Redeclarable<FunctionDecl>, ExternC, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief The kind of templated function a FunctionDecl can be.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::TemplatedKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1565,
   FQN="clang::FunctionDecl::TemplatedKind", NM="_ZN5clang12FunctionDecl13TemplatedKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl13TemplatedKindE")
  //</editor-fold>
  public enum TemplatedKind implements Native.ComparableLower {
    TK_NonTemplate(0),
    TK_FunctionTemplate(TK_NonTemplate.getValue() + 1),
    TK_MemberSpecialization(TK_FunctionTemplate.getValue() + 1),
    TK_FunctionTemplateSpecialization(TK_MemberSpecialization.getValue() + 1),
    TK_DependentFunctionTemplateSpecialization(TK_FunctionTemplateSpecialization.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TemplatedKind valueOf(int val) {
      TemplatedKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TemplatedKind[] VALUES;
      private static final TemplatedKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TemplatedKind kind : TemplatedKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TemplatedKind[min < 0 ? (1-min) : 0];
        VALUES = new TemplatedKind[max >= 0 ? (1+max) : 0];
        for (TemplatedKind kind : TemplatedKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private TemplatedKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TemplatedKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TemplatedKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// ParamInfo - new[]'d array of pointers to VarDecls for the formal
  /// parameters of this function.  This is null if a prototype or if there are
  /// no formals.
  private type$ptr<ParmVarDecl /*P*/ /*P*/> ParamInfo;
  
  /// DeclsInPrototypeScope - Array of pointers to NamedDecls for
  /// decls defined in the function prototype that are not parameters. E.g.
  /// 'enum Y' in 'void f(enum Y {AA} x) {}'.
  private ArrayRef<NamedDecl /*P*/ > DeclsInPrototypeScope;
  
  private LazyDeclStmtPtr Body;
  
  // FIXME: This can be packed into the bitfields in DeclContext.
  // NOTE: VC++ packs bitfields poorly if the types differ.
  /*friend*/public /*JBYTE unsigned int*/ byte SClass /*: 3*/; // JAVA FIX: must be 3 to fit
  /*friend*/public /*JBIT unsigned int*/ boolean IsInline /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsInlineSpecified /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsVirtualAsWritten /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsPure /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean HasInheritedPrototype /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean HasWrittenPrototype /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsDeleted /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsTrivial /*: 1*/; // sunk from CXXMethodDecl
  /*friend*/public /*JBIT unsigned int*/ boolean IsDefaulted /*: 1*/; // sunk from CXXMethoDecl
  /*friend*/public /*JBIT unsigned int*/ boolean IsExplicitlyDefaulted /*: 1*/; //sunk from CXXMethodDecl
  /*friend*/public /*JBIT unsigned int*/ boolean HasImplicitReturnZero /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsLateTemplateParsed /*: 1*/;
  /*friend*/public /*JBIT unsigned int*/ boolean IsConstexpr /*: 1*/;
  
  /// \brief Indicates if the function uses __try.
  private /*JBIT unsigned int*/ boolean UsesSEHTry /*: 1*/;
  
  /// \brief Indicates if the function was a definition but its body was
  /// skipped.
  /*friend*/public /*JBIT unsigned int*/ boolean HasSkippedBody /*: 1*/;
  
  /// \brief End part of this FunctionDecl's source range.
  ///
  /// We could compute the full range in getSourceRange(). However, when we're
  /// dealing with a function definition deserialized from a PCH/AST file,
  /// we can only compute the full range once the function body has been
  /// de-serialized, so it's far better to have the (sometimes-redundant)
  /// EndRangeLoc.
  /*friend*/public SourceLocation EndRangeLoc;
  
  /// \brief The template or declaration that this declaration
  /// describes or was instantiated from, respectively.
  ///
  /// For non-templates, this value will be NULL. For function
  /// declarations that describe a function template, this will be a
  /// pointer to a FunctionTemplateDecl. For member functions
  /// of class template specializations, this will be a MemberSpecializationInfo
  /// pointer containing information about the specialization.
  /// For function template specializations, this will be a
  /// FunctionTemplateSpecializationInfo, which contains information about
  /// the template being specialized and the template arguments involved in
  /// that specialization.
  /*friend*/public PointerUnion4<FunctionTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ , FunctionTemplateSpecializationInfo /*P*/ , DependentFunctionTemplateSpecializationInfo /*P*/ > TemplateOrSpecialization;
  
  /// DNLoc - Provides source/type location info for the
  /// declaration name embedded in the DeclaratorDecl base class.
  /*friend*/public DeclarationNameLoc DNLoc;
  
  /// \brief Specify that this function declaration is actually a function
  /// template specialization.
  ///
  /// \param C the ASTContext.
  ///
  /// \param Template the function template that this function template
  /// specialization specializes.
  ///
  /// \param TemplateArgs the template arguments that produced this
  /// function template specialization from the template.
  ///
  /// \param InsertPos If non-NULL, the position in the function template
  /// specialization set where the function template specialization data will
  /// be inserted.
  ///
  /// \param TSK the kind of template specialization this is.
  ///
  /// \param TemplateArgsAsWritten location info of template arguments.
  ///
  /// \param PointOfInstantiation point at which the function template
  /// specialization was first instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setFunctionTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3208,
   FQN="clang::FunctionDecl::setFunctionTemplateSpecialization", NM="_ZN5clang12FunctionDecl33setFunctionTemplateSpecializationERNS_10ASTContextEPNS_20FunctionTemplateDeclEPKNS_20TemplateArgumentListEPvNS_26TemplateSpecializationKindEPKNS_24TemplateArgumentListInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl33setFunctionTemplateSpecializationERNS_10ASTContextEPNS_20FunctionTemplateDeclEPKNS_20TemplateArgumentListEPvNS_26TemplateSpecializationKindEPKNS_24TemplateArgumentListInfoENS_14SourceLocationE")
  //</editor-fold>
  private void setFunctionTemplateSpecialization(final ASTContext /*&*/ C, 
                                   FunctionTemplateDecl /*P*/ Template, 
                                   /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
                                   type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos, 
                                   TemplateSpecializationKind TSK, 
                                   /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgsAsWritten, 
                                   SourceLocation PointOfInstantiation) {
    assert (TSK != TemplateSpecializationKind.TSK_Undeclared) : "Must specify the type of function template specialization";
    FunctionTemplateSpecializationInfo /*P*/ Info = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
    if (!(Info != null)) {
      Info = FunctionTemplateSpecializationInfo.Create(C, this, Template, TSK, 
          TemplateArgs, 
          TemplateArgsAsWritten, 
          new SourceLocation(PointOfInstantiation));
    }
    TemplateOrSpecialization.$assign_T2$C$R(FunctionTemplateSpecializationInfo /*P*/ /*const*/ /*&*/.class, Info);
    Template.addSpecialization(Info, InsertPos);
  }

  
  /// \brief Specify that this record is an instantiation of the
  /// member function FD.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setInstantiationOfMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3057,
   FQN="clang::FunctionDecl::setInstantiationOfMemberFunction", NM="_ZN5clang12FunctionDecl32setInstantiationOfMemberFunctionERNS_10ASTContextEPS0_NS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl32setInstantiationOfMemberFunctionERNS_10ASTContextEPS0_NS_26TemplateSpecializationKindE")
  //</editor-fold>
  /*friend*/public void setInstantiationOfMemberFunction(final ASTContext /*&*/ C, 
                                  FunctionDecl /*P*/ FD, 
                                  TemplateSpecializationKind TSK) {
    assert (TemplateOrSpecialization.isNull()) : "Member function is already a specialization";
    MemberSpecializationInfo /*P*/ Info = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (C)*/ $new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new MemberSpecializationInfo(FD, TSK);
     });
    TemplateOrSpecialization.$assign_T1$C$R(MemberSpecializationInfo /*P*/ /*const*/ /*&*/.class, Info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2747,
   FQN="clang::FunctionDecl::setParams", NM="_ZN5clang12FunctionDecl9setParamsERNS_10ASTContextEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl9setParamsERNS_10ASTContextEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE")
  //</editor-fold>
  /*friend*/public void setParams(final ASTContext /*&*/ C, 
           ArrayRef<ParmVarDecl /*P*/ > NewParamInfo) {
    assert (!Native.$bool(ParamInfo)) : "Already has param info!";
    assert (NewParamInfo.size() == getNumParams()) : "Parameter count mismatch!";
    
    // Zero params -> null pointer.
    if (!NewParamInfo.empty()) {
      ParamInfo = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (C)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new ParmVarDecl /*P*/ [NewParamInfo.size()]);
      std.copy(NewParamInfo.begin(), NewParamInfo.end(), ParamInfo);
    }
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::FunctionDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init ParamInfo*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1678,
   FQN="clang::FunctionDecl::FunctionDecl", NM="_ZN5clang12FunctionDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbb")
  //</editor-fold>
  protected FunctionDecl(Kind DK, final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      QualType T, TypeSourceInfo /*P*/ TInfo, 
      StorageClass S, boolean isInlineSpecified, 
      boolean isConstexprSpecified) {
    // : DeclaratorDecl(DK, DC, NameInfo.getLoc(), NameInfo.getName(), T, TInfo, StartLoc), DeclContext(DK), redeclarable_base(C), ParamInfo(null), DeclsInPrototypeScope(), Body(), SClass(S), IsInline(isInlineSpecified), IsInlineSpecified(isInlineSpecified), IsVirtualAsWritten(false), IsPure(false), HasInheritedPrototype(false), HasWrittenPrototype(true), IsDeleted(false), IsTrivial(false), IsDefaulted(false), IsExplicitlyDefaulted(false), HasImplicitReturnZero(false), IsLateTemplateParsed(false), IsConstexpr(isConstexprSpecified), UsesSEHTry(false), HasSkippedBody(false), EndRangeLoc(NameInfo.getEndLoc()), TemplateOrSpecialization(), DNLoc(NameInfo.getInfo()) 
    //START JInit
    super(DK, DC, NameInfo.getLoc(), NameInfo.getName(), new QualType(T), TInfo, 
        new SourceLocation(StartLoc));
    this.DeclContext$Flds = $DeclContext(DK);
    this.Redeclarable$Flds = $Redeclarable(C);
    this.ParamInfo = EMPTY_PARAMS; // JAVA
    this.DeclsInPrototypeScope = new ArrayRef<NamedDecl /*P*/ >(true);
    this.Body = new LazyDeclStmtPtr();
    this.SClass = $uint2uint_3bits(S.getValue());
    this.IsInline = isInlineSpecified;
    this.IsInlineSpecified = isInlineSpecified;
    this.IsVirtualAsWritten = false;
    this.IsPure = false;
    this.HasInheritedPrototype = false;
    this.HasWrittenPrototype = true;
    this.IsDeleted = false;
    this.IsTrivial = false;
    this.IsDefaulted = false;
    this.IsExplicitlyDefaulted = false;
    this.HasImplicitReturnZero = false;
    this.IsLateTemplateParsed = false;
    this.IsConstexpr = isConstexprSpecified;
    this.UsesSEHTry = false;
    this.HasSkippedBody = false;
    this.EndRangeLoc = NameInfo.getEndLoc();
    this.TemplateOrSpecialization = new PointerUnion4<FunctionTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ , FunctionTemplateSpecializationInfo /*P*/ , DependentFunctionTemplateSpecializationInfo /*P*/ >(FunctionTemplateDecl /*P*/.class);
    this.DNLoc = new DeclarationNameLoc(NameInfo.getInfo$Const());
    //END JInit
  }

  
  /*typedef Redeclarable<FunctionDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<FunctionDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1700,
   FQN="clang::FunctionDecl::getNextRedeclarationImpl", NM="_ZN5clang12FunctionDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected FunctionDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1703,
   FQN="clang::FunctionDecl::getPreviousDeclImpl", NM="_ZN5clang12FunctionDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected FunctionDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1706,
   FQN="clang::FunctionDecl::getMostRecentDeclImpl", NM="_ZN5clang12FunctionDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected FunctionDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*public:*/
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<FunctionDecl /*P*/ >{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<FunctionDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<FunctionDecl>::redecls_begin;
  //JAVA: using Redeclarable<FunctionDecl>::redecls_end;
  //JAVA: using Redeclarable<FunctionDecl>::redecls;
  //JAVA: using Redeclarable<FunctionDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<FunctionDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<FunctionDecl>::isFirstDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1720,
   FQN="clang::FunctionDecl::Create", NM="_ZN5clang12FunctionDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbb")
  //</editor-fold>
  public static FunctionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation NLoc, 
        DeclarationName N, QualType T, 
        TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC) {
    return Create(C, DC, 
        StartLoc, NLoc, 
        N, T, 
        TInfo, 
        SC, 
        false, 
        true, 
        false);
  }
  public static FunctionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation NLoc, 
        DeclarationName N, QualType T, 
        TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC, 
        boolean isInlineSpecified/*= false*/) {
    return Create(C, DC, 
        StartLoc, NLoc, 
        N, T, 
        TInfo, 
        SC, 
        isInlineSpecified, 
        true, 
        false);
  }
  public static FunctionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation NLoc, 
        DeclarationName N, QualType T, 
        TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC, 
        boolean isInlineSpecified/*= false*/, 
        boolean hasWrittenPrototype/*= true*/) {
    return Create(C, DC, 
        StartLoc, NLoc, 
        N, T, 
        TInfo, 
        SC, 
        isInlineSpecified, 
        hasWrittenPrototype, 
        false);
  }
  public static FunctionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation NLoc, 
        DeclarationName N, QualType T, 
        TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC, 
        boolean isInlineSpecified/*= false*/, 
        boolean hasWrittenPrototype/*= true*/, 
        boolean isConstexprSpecified/*= false*/) {
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(N), new SourceLocation(NLoc));
    return FunctionDecl.Create(C, DC, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
        SC, 
        isInlineSpecified, hasWrittenPrototype, 
        isConstexprSpecified);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4029,
   FQN="clang::FunctionDecl::Create", NM="_ZN5clang12FunctionDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbb")
  //</editor-fold>
  public static FunctionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC, 
        boolean isInlineSpecified, 
        boolean hasWrittenPrototype) {
    return Create(C, DC, 
        StartLoc, 
        NameInfo, 
        T, TInfo, 
        SC, 
        isInlineSpecified, 
        hasWrittenPrototype, 
        false);
  }
  public static FunctionDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC, 
        boolean isInlineSpecified, 
        boolean hasWrittenPrototype, 
        boolean isConstexprSpecified/*= false*/) {
    FunctionDecl /*P*/ New = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new FunctionDecl(Kind.Function, C, DC, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
                SC, isInlineSpecified, isConstexprSpecified);
     });
    New.HasWrittenPrototype = hasWrittenPrototype;
    return New;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4044,
   FQN="clang::FunctionDecl::CreateDeserialized", NM="_ZN5clang12FunctionDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static FunctionDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new FunctionDecl(Kind.Function, C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationNameInfo(), new QualType(), (TypeSourceInfo /*P*/ )null, 
                StorageClass.SC_None, false, false);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1746,
   FQN="clang::FunctionDecl::getNameInfo", NM="_ZNK5clang12FunctionDecl11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl11getNameInfoEv")
  //</editor-fold>
  public DeclarationNameInfo getNameInfo() /*const*/ {
    return new DeclarationNameInfo(getDeclName(), getLocation(), new DeclarationNameLoc(DNLoc));
  }

  
  
  //===----------------------------------------------------------------------===//
  // FunctionDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getNameForDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2439,
   FQN="clang::FunctionDecl::getNameForDiagnostic", NM="_ZNK5clang12FunctionDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb")
  //</editor-fold>
  @Override public void getNameForDiagnostic(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, boolean Qualified) /*const*//* override*/ {
    super.getNameForDiagnostic(OS, Policy, Qualified);
    /*const*/ TemplateArgumentList /*P*/ TemplateArgs = getTemplateSpecializationArgs();
    if ((TemplateArgs != null)) {
      TemplateSpecializationType.PrintTemplateArgumentList1(OS, TemplateArgs.asArray(), Policy);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1753,
   FQN="clang::FunctionDecl::setRangeEnd", NM="_ZN5clang12FunctionDecl11setRangeEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl11setRangeEndENS_14SourceLocationE")
  //</editor-fold>
  public void setRangeEnd(SourceLocation E) {
    EndRangeLoc.$assign(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3346,
   FQN="clang::FunctionDecl::getSourceRange", NM="_ZNK5clang12FunctionDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(getOuterLocStart(), /*NO_COPY*/EndRangeLoc);
  }

  
  /// \brief Returns true if the function has a body (definition). The
  /// function body might be in any of the (re-)declarations of this
  /// function. The variant that accepts a FunctionDecl pointer will
  /// set that function declaration to the actual declaration
  /// containing the body (if there is one).
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2454,
   FQN="clang::FunctionDecl::hasBody", NM="_ZNK5clang12FunctionDecl7hasBodyERPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl7hasBodyERPKS0_")
  //</editor-fold>
  public boolean hasBody(final type$ref</*const*/ FunctionDecl /*P*/ /*&*/> Definition) /*const*/ {
    for (FunctionDecl /*P*/ I : redeclarable_redecls()) {
      if (I.Body.$bool() || I.IsLateTemplateParsed) {
        Definition.$set(I);
        return true;
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1764,
   FQN="clang::FunctionDecl::hasBody", NM="_ZNK5clang12FunctionDecl7hasBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl7hasBodyEv")
  //</editor-fold>
  @Override public boolean hasBody() /*const*//* override*/ {
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
    return hasBody(Definition);
  }

  
  /// hasTrivialBody - Returns whether the function has a trivial body that does
  /// not require any specific codegen.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasTrivialBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2465,
   FQN="clang::FunctionDecl::hasTrivialBody", NM="_ZNK5clang12FunctionDecl14hasTrivialBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl14hasTrivialBodyEv")
  //</editor-fold>
  public boolean hasTrivialBody() /*const*/ {
    Stmt /*P*/ S = getBody();
    if (!(S != null)) {
      // Since we don't have a body for this function, we don't know if it's
      // trivial or not.
      return false;
    }
    if (isa_CompoundStmt(S) && cast_CompoundStmt(S).body_empty()) {
      return true;
    }
    return false;
  }

  
  /// isDefined - Returns true if the function is defined at all, including
  /// a deleted definition. Except for the behavior when the function is
  /// deleted, behaves like hasBody.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2479,
   FQN="clang::FunctionDecl::isDefined", NM="_ZNK5clang12FunctionDecl9isDefinedERPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9isDefinedERPKS0_")
  //</editor-fold>
  public boolean isDefined(final type$ref</*const*/ FunctionDecl /*P*/ /*&*/> Definition) /*const*/ {
    for (FunctionDecl /*P*/ I : redeclarable_redecls()) {
      if (I.IsDeleted || I.IsDefaulted || I.Body.$bool() || I.IsLateTemplateParsed
         || I.hasDefiningAttr()) {
        Definition.$set(I.IsDeleted ? I.getCanonicalDecl() : I);
        return true;
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1778,
   FQN="clang::FunctionDecl::isDefined", NM="_ZNK5clang12FunctionDecl9isDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9isDefinedEv")
  //</editor-fold>
  public /*virtual*/ boolean isDefined() /*const*/ {
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
    return isDefined(Definition);
  }

  
  /// \brief Get the definition for this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1784,
   FQN="clang::FunctionDecl::getDefinition", NM="_ZN5clang12FunctionDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl13getDefinitionEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getDefinition() {
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
    if (isDefined(Definition)) {
      return ((/*const_cast*/FunctionDecl /*P*/ )(Definition.$deref()));
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1790,
   FQN="clang::FunctionDecl::getDefinition", NM="_ZNK5clang12FunctionDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl13getDefinitionEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getDefinition$Const() /*const*/ {
    return ((/*const_cast*/FunctionDecl /*P*/ )(this)).getDefinition();
  }

  
  /// getBody - Retrieve the body (definition) of the function. The
  /// function body might be in any of the (re-)declarations of this
  /// function. The variant that accepts a FunctionDecl pointer will
  /// set that function declaration to the actual declaration
  /// containing the body (if there is one).
  /// NOTE: For checking if there is a body, use hasBody() instead, to avoid
  /// unnecessary AST de-serialization of the body.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2491,
   FQN="clang::FunctionDecl::getBody", NM="_ZNK5clang12FunctionDecl7getBodyERPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl7getBodyERPKS0_")
  //</editor-fold>
  public Stmt /*P*/ getBody(final type$ref</*const*/ FunctionDecl /*P*/ /*&*/> Definition) /*const*/ {
    if (!hasBody(Definition)) {
      return null;
    }
    if (Definition.$deref().Body.$bool()) {
      return Definition.$deref().Body.get(getASTContext().getExternalSource());
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1803,
   FQN="clang::FunctionDecl::getBody", NM="_ZNK5clang12FunctionDecl7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl7getBodyEv")
  //</editor-fold>
  @Override public Stmt /*P*/ getBody() /*const*//* override*/ {
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
    return getBody(Definition);
  }

  
  /// isThisDeclarationADefinition - Returns whether this specific
  /// declaration of the function is also a definition. This does not
  /// determine whether the function has been defined (e.g., in a
  /// previous definition); for that information, use isDefined. Note
  /// that this returns false for a defaulted function unless that function
  /// has been implicitly defined (possibly as deleted).
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1814,
   FQN="clang::FunctionDecl::isThisDeclarationADefinition", NM="_ZNK5clang12FunctionDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return IsDeleted || Body.$bool() || IsLateTemplateParsed;
  }

  
  /// doesThisDeclarationHaveABody - Returns whether this specific
  /// declaration of the function has a body - that is, if it is a non-
  /// deleted definition.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::doesThisDeclarationHaveABody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1821,
   FQN="clang::FunctionDecl::doesThisDeclarationHaveABody", NM="_ZNK5clang12FunctionDecl28doesThisDeclarationHaveABodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl28doesThisDeclarationHaveABodyEv")
  //</editor-fold>
  public boolean doesThisDeclarationHaveABody() /*const*/ {
    return Body.$bool() || IsLateTemplateParsed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2501,
   FQN="clang::FunctionDecl::setBody", NM="_ZN5clang12FunctionDecl7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ B) {
    Body.$assign(B);
    if ((B != null)) {
      EndRangeLoc.$assignMove(B.getLocEnd());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setLazyBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1826,
   FQN="clang::FunctionDecl::setLazyBody", NM="_ZN5clang12FunctionDecl11setLazyBodyEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl11setLazyBodyEy")
  //</editor-fold>
  public void setLazyBody(long/*uint64_t*/ Offset) {
    Body.$assign(Offset);
  }

  
  /// Whether this function is variadic.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2448,
   FQN="clang::FunctionDecl::isVariadic", NM="_ZNK5clang12FunctionDecl10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    {
      /*const*/ FunctionProtoType /*P*/ FT = getType().$arrow().getAs(FunctionProtoType.class);
      if ((FT != null)) {
        return FT.isVariadic();
      }
    }
    return false;
  }

  
  /// Whether this function is marked as virtual explicitly.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isVirtualAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1832,
   FQN="clang::FunctionDecl::isVirtualAsWritten", NM="_ZNK5clang12FunctionDecl18isVirtualAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl18isVirtualAsWrittenEv")
  //</editor-fold>
  public boolean isVirtualAsWritten() /*const*/ {
    return IsVirtualAsWritten;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setVirtualAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1833,
   FQN="clang::FunctionDecl::setVirtualAsWritten", NM="_ZN5clang12FunctionDecl19setVirtualAsWrittenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl19setVirtualAsWrittenEb")
  //</editor-fold>
  public void setVirtualAsWritten(boolean V) {
    IsVirtualAsWritten = V;
  }

  
  /// Whether this virtual function is pure, i.e. makes the containing class
  /// abstract.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isPure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1837,
   FQN="clang::FunctionDecl::isPure", NM="_ZNK5clang12FunctionDecl6isPureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl6isPureEv")
  //</editor-fold>
  public boolean isPure() /*const*/ {
    return IsPure;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setPure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2507,
   FQN="clang::FunctionDecl::setPure", NM="_ZN5clang12FunctionDecl7setPureEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl7setPureEb")
  //</editor-fold>
  public void setPure() {
    setPure(true);
  }
  public void setPure(boolean P/*= true*/) {
    IsPure = P;
    if (P) {
      {
        CXXRecordDecl /*P*/ Parent = dyn_cast_CXXRecordDecl(getDeclContext());
        if ((Parent != null)) {
          Parent.markedVirtualFunctionPure();
        }
      }
    }
  }

  
  /// Whether this templated function will be late parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isLateTemplateParsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1841,
   FQN="clang::FunctionDecl::isLateTemplateParsed", NM="_ZNK5clang12FunctionDecl20isLateTemplateParsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl20isLateTemplateParsedEv")
  //</editor-fold>
  public boolean isLateTemplateParsed() /*const*/ {
    return IsLateTemplateParsed;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setLateTemplateParsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1842,
   FQN="clang::FunctionDecl::setLateTemplateParsed", NM="_ZN5clang12FunctionDecl21setLateTemplateParsedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl21setLateTemplateParsedEb")
  //</editor-fold>
  public void setLateTemplateParsed() {
    setLateTemplateParsed(true);
  }
  public void setLateTemplateParsed(boolean ILT/*= true*/) {
    IsLateTemplateParsed = ILT;
  }

  
  /// Whether this function is "trivial" in some specialized C++ senses.
  /// Can only be true for default constructors, copy constructors,
  /// copy assignment operators, and destructors.  Not meaningful until
  /// the class has been fully built by Sema.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isTrivial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1848,
   FQN="clang::FunctionDecl::isTrivial", NM="_ZNK5clang12FunctionDecl9isTrivialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9isTrivialEv")
  //</editor-fold>
  public boolean isTrivial() /*const*/ {
    return IsTrivial;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setTrivial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1849,
   FQN="clang::FunctionDecl::setTrivial", NM="_ZN5clang12FunctionDecl10setTrivialEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl10setTrivialEb")
  //</editor-fold>
  public void setTrivial(boolean IT) {
    IsTrivial = IT;
  }

  
  /// Whether this function is defaulted per C++0x. Only valid for
  /// special member functions.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isDefaulted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1853,
   FQN="clang::FunctionDecl::isDefaulted", NM="_ZNK5clang12FunctionDecl11isDefaultedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl11isDefaultedEv")
  //</editor-fold>
  public boolean isDefaulted() /*const*/ {
    return IsDefaulted;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setDefaulted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1854,
   FQN="clang::FunctionDecl::setDefaulted", NM="_ZN5clang12FunctionDecl12setDefaultedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl12setDefaultedEb")
  //</editor-fold>
  public void setDefaulted() {
    setDefaulted(true);
  }
  public void setDefaulted(boolean D/*= true*/) {
    IsDefaulted = D;
  }

  
  /// Whether this function is explicitly defaulted per C++0x. Only valid
  /// for special member functions.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isExplicitlyDefaulted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1858,
   FQN="clang::FunctionDecl::isExplicitlyDefaulted", NM="_ZNK5clang12FunctionDecl21isExplicitlyDefaultedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl21isExplicitlyDefaultedEv")
  //</editor-fold>
  public boolean isExplicitlyDefaulted() /*const*/ {
    return IsExplicitlyDefaulted;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setExplicitlyDefaulted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1859,
   FQN="clang::FunctionDecl::setExplicitlyDefaulted", NM="_ZN5clang12FunctionDecl22setExplicitlyDefaultedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl22setExplicitlyDefaultedEb")
  //</editor-fold>
  public void setExplicitlyDefaulted() {
    setExplicitlyDefaulted(true);
  }
  public void setExplicitlyDefaulted(boolean ED/*= true*/) {
    IsExplicitlyDefaulted = ED;
  }

  
  /// Whether falling off this function implicitly returns null/zero.
  /// If a more specific implicit return value is required, front-ends
  /// should synthesize the appropriate return statements.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasImplicitReturnZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1864,
   FQN="clang::FunctionDecl::hasImplicitReturnZero", NM="_ZNK5clang12FunctionDecl21hasImplicitReturnZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl21hasImplicitReturnZeroEv")
  //</editor-fold>
  public boolean hasImplicitReturnZero() /*const*/ {
    return HasImplicitReturnZero;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setHasImplicitReturnZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1865,
   FQN="clang::FunctionDecl::setHasImplicitReturnZero", NM="_ZN5clang12FunctionDecl24setHasImplicitReturnZeroEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl24setHasImplicitReturnZeroEb")
  //</editor-fold>
  public void setHasImplicitReturnZero(boolean IRZ) {
    HasImplicitReturnZero = IRZ;
  }

  
  /// \brief Whether this function has a prototype, either because one
  /// was explicitly written or because it was "inherited" by merging
  /// a declaration without a prototype with a declaration that has a
  /// prototype.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasPrototype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1871,
   FQN="clang::FunctionDecl::hasPrototype", NM="_ZNK5clang12FunctionDecl12hasPrototypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl12hasPrototypeEv")
  //</editor-fold>
  public boolean hasPrototype() /*const*/ {
    return HasWrittenPrototype || HasInheritedPrototype;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasWrittenPrototype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1875,
   FQN="clang::FunctionDecl::hasWrittenPrototype", NM="_ZNK5clang12FunctionDecl19hasWrittenPrototypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl19hasWrittenPrototypeEv")
  //</editor-fold>
  public boolean hasWrittenPrototype() /*const*/ {
    return HasWrittenPrototype;
  }

  
  /// \brief Whether this function inherited its prototype from a
  /// previous declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasInheritedPrototype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1879,
   FQN="clang::FunctionDecl::hasInheritedPrototype", NM="_ZNK5clang12FunctionDecl21hasInheritedPrototypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl21hasInheritedPrototypeEv")
  //</editor-fold>
  public boolean hasInheritedPrototype() /*const*/ {
    return HasInheritedPrototype;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setHasInheritedPrototype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1880,
   FQN="clang::FunctionDecl::setHasInheritedPrototype", NM="_ZN5clang12FunctionDecl24setHasInheritedPrototypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl24setHasInheritedPrototypeEb")
  //</editor-fold>
  public void setHasInheritedPrototype() {
    setHasInheritedPrototype(true);
  }
  public void setHasInheritedPrototype(boolean P/*= true*/) {
    HasInheritedPrototype = P;
  }

  
  /// Whether this is a (C++11) constexpr function or constexpr constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isConstexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1883,
   FQN="clang::FunctionDecl::isConstexpr", NM="_ZNK5clang12FunctionDecl11isConstexprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl11isConstexprEv")
  //</editor-fold>
  public boolean isConstexpr() /*const*/ {
    return IsConstexpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setConstexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1884,
   FQN="clang::FunctionDecl::setConstexpr", NM="_ZN5clang12FunctionDecl12setConstexprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl12setConstexprEb")
  //</editor-fold>
  public void setConstexpr(boolean IC) {
    IsConstexpr = IC;
  }

  
  /// \brief Indicates the function uses __try.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::usesSEHTry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1887,
   FQN="clang::FunctionDecl::usesSEHTry", NM="_ZNK5clang12FunctionDecl10usesSEHTryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl10usesSEHTryEv")
  //</editor-fold>
  public boolean usesSEHTry() /*const*/ {
    return UsesSEHTry;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setUsesSEHTry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1888,
   FQN="clang::FunctionDecl::setUsesSEHTry", NM="_ZN5clang12FunctionDecl13setUsesSEHTryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl13setUsesSEHTryEb")
  //</editor-fold>
  public void setUsesSEHTry(boolean UST) {
    UsesSEHTry = UST;
  }

  
  /// \brief Whether this function has been deleted.
  ///
  /// A function that is "deleted" (via the C++0x "= delete" syntax)
  /// acts like a normal function, except that it cannot actually be
  /// called or have its address taken. Deleted functions are
  /// typically used in C++ overload resolution to attract arguments
  /// whose type or lvalue/rvalue-ness would permit the use of a
  /// different overload that would behave incorrectly. For example,
  /// one might use deleted functions to ban implicit conversion from
  /// a floating-point number to an Integer type:
  ///
  /// @code
  /// struct Integer {
  ///   Integer(long); // construct from a long
  ///   Integer(double) = delete; // no construction from float or double
  ///   Integer(long double) = delete; // no construction from long double
  /// };
  /// @endcode
  // If a function is deleted, its first declaration must be.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isDeleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1909,
   FQN="clang::FunctionDecl::isDeleted", NM="_ZNK5clang12FunctionDecl9isDeletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9isDeletedEv")
  //</editor-fold>
  public boolean isDeleted() /*const*/ {
    return getCanonicalDecl$Const().IsDeleted;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isDeletedAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1910,
   FQN="clang::FunctionDecl::isDeletedAsWritten", NM="_ZNK5clang12FunctionDecl18isDeletedAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl18isDeletedAsWrittenEv")
  //</editor-fold>
  public boolean isDeletedAsWritten() /*const*/ {
    return IsDeleted && !IsDefaulted;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setDeletedAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1911,
   FQN="clang::FunctionDecl::setDeletedAsWritten", NM="_ZN5clang12FunctionDecl19setDeletedAsWrittenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl19setDeletedAsWrittenEb")
  //</editor-fold>
  public void setDeletedAsWritten() {
    setDeletedAsWritten(true);
  }
  public void setDeletedAsWritten(boolean D/*= true*/) {
    IsDeleted = D;
  }

  
  /// \brief Determines whether this function is "main", which is the
  /// entry point into an executable program.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isMain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2520,
   FQN="clang::FunctionDecl::isMain", NM="_ZNK5clang12FunctionDecl6isMainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl6isMainEv")
  //</editor-fold>
  public boolean isMain() /*const*/ {
    /*const*/ TranslationUnitDecl /*P*/ tunit = dyn_cast_TranslationUnitDecl(getDeclContext$Const().getRedeclContext$Const());
    return (tunit != null)
       && !tunit.getASTContext().getLangOpts().Freestanding
       && isNamed(this, /*KEEP_STR*/"main");
  }

  
  /// \brief Determines whether this function is a MSVCRT user defined entry
  /// point.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isMSVCRTEntryPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2528,
   FQN="clang::FunctionDecl::isMSVCRTEntryPoint", NM="_ZNK5clang12FunctionDecl18isMSVCRTEntryPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl18isMSVCRTEntryPointEv")
  //</editor-fold>
  public boolean isMSVCRTEntryPoint() /*const*/ {
    /*const*/ TranslationUnitDecl /*P*/ TUnit = dyn_cast_TranslationUnitDecl(getDeclContext$Const().getRedeclContext$Const());
    if (!(TUnit != null)) {
      return false;
    }
    
    // Even though we aren't really targeting MSVCRT if we are freestanding,
    // semantic analysis for these functions remains the same.
    
    // MSVCRT entry points only exist on MSVCRT targets.
    if (!TUnit.getASTContext().getTargetInfo().getTriple().isOSMSVCRT()) {
      return false;
    }
    
    // Nameless functions like constructors cannot be entry points.
    if (!(getIdentifier() != null)) {
      return false;
    }
    
    return new StringSwitchBool(getName()).
        Cases(/*KEEP_STR*/"main",  // an ANSI console app
        /*KEEP_STR*/"wmain",  // a Unicode console App
        /*KEEP_STR*/"WinMain",  // an ANSI GUI app
        /*KEEP_STR*/"wWinMain",  // a Unicode GUI app
        /*KEEP_STR*/"DllMain",  // a DLL
        true).
        Default(false);
  }

  
  /// \brief Determines whether this operator new or delete is one
  /// of the reserved global placement operators:
  ///    void *operator new(size_t, void *);
  ///    void *operator new[](size_t, void *);
  ///    void operator delete(void *, void *);
  ///    void operator delete[](void *, void *);
  /// These functions have special behavior under [new.delete.placement]:
  ///    These functions are reserved, a C++ program may not define
  ///    functions that displace the versions in the Standard C++ library.
  ///    The provisions of [basic.stc.dynamic] do not apply to these
  ///    reserved placement forms of operator new and operator delete.
  ///
  /// This function must be an allocation or deallocation function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isReservedGlobalPlacementOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2555,
   FQN="clang::FunctionDecl::isReservedGlobalPlacementOperator", NM="_ZNK5clang12FunctionDecl33isReservedGlobalPlacementOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl33isReservedGlobalPlacementOperatorEv")
  //</editor-fold>
  public boolean isReservedGlobalPlacementOperator() /*const*/ {
    assert (getDeclName().getNameKind() == DeclarationName.NameKind.CXXOperatorName);
    assert (getDeclName().getCXXOverloadedOperator() == OverloadedOperatorKind.OO_New || getDeclName().getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Delete || getDeclName().getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Array_New || getDeclName().getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Array_Delete);
    if (!getDeclContext$Const().getRedeclContext$Const().isTranslationUnit()) {
      return false;
    }
    
    /*const*/ FunctionProtoType /*P*/ proto = getType().$arrow().castAs(FunctionProtoType.class);
    if (proto.getNumParams() != 2 || proto.isVariadic()) {
      return false;
    }
    
    final ASTContext /*&*/ Context = cast_TranslationUnitDecl(getDeclContext$Const().getRedeclContext$Const()).
        getASTContext();
    
    // The result type and first argument type are constant across all
    // these operators.  The second argument must be exactly void*.
    return ($eq_QualType$C(proto.getParamType(1).getCanonicalType(), Context.VoidPtrTy.$QualType()));
  }

  
  /// \brief Determines whether this function is one of the replaceable
  /// global allocation functions:
  ///    void *operator new(size_t);
  ///    void *operator new(size_t, const std::nothrow_t &) noexcept;
  ///    void *operator new[](size_t);
  ///    void *operator new[](size_t, const std::nothrow_t &) noexcept;
  ///    void operator delete(void *) noexcept;
  ///    void operator delete(void *, std::size_t) noexcept;      [C++1y]
  ///    void operator delete(void *, const std::nothrow_t &) noexcept;
  ///    void operator delete[](void *) noexcept;
  ///    void operator delete[](void *, std::size_t) noexcept;    [C++1y]
  ///    void operator delete[](void *, const std::nothrow_t &) noexcept;
  /// These functions have special behavior under C++1y [expr.new]:
  ///    An implementation is allowed to omit a call to a replaceable global
  ///    allocation function. [...]
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isReplaceableGlobalAllocationFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2578,
   FQN="clang::FunctionDecl::isReplaceableGlobalAllocationFunction", NM="_ZNK5clang12FunctionDecl37isReplaceableGlobalAllocationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl37isReplaceableGlobalAllocationFunctionEv")
  //</editor-fold>
  public boolean isReplaceableGlobalAllocationFunction() /*const*/ {
    if (getDeclName().getNameKind() != DeclarationName.NameKind.CXXOperatorName) {
      return false;
    }
    if (getDeclName().getCXXOverloadedOperator() != OverloadedOperatorKind.OO_New
       && getDeclName().getCXXOverloadedOperator() != OverloadedOperatorKind.OO_Delete
       && getDeclName().getCXXOverloadedOperator() != OverloadedOperatorKind.OO_Array_New
       && getDeclName().getCXXOverloadedOperator() != OverloadedOperatorKind.OO_Array_Delete) {
      return false;
    }
    if (isa_CXXRecordDecl(getDeclContext$Const())) {
      return false;
    }
    
    // This can only fail for an invalid 'operator new' declaration.
    if (!getDeclContext$Const().getRedeclContext$Const().isTranslationUnit()) {
      return false;
    }
    
    /*const*/ FunctionProtoType /*P*/ FPT = getType().$arrow().castAs(FunctionProtoType.class);
    if (FPT.getNumParams() == 0 || $greater_uint(FPT.getNumParams(), 2) || FPT.isVariadic()) {
      return false;
    }
    
    // If this is a single-parameter function, it must be a replaceable global
    // allocation or deallocation function.
    if (FPT.getNumParams() == 1) {
      return true;
    }
    
    // Otherwise, we're looking for a second parameter whose type is
    // 'const std::nothrow_t &', or, in C++1y, 'std::size_t'.
    QualType Ty = FPT.getParamType(1);
    final ASTContext /*&*/ Ctx = getASTContext();
    if (Ctx.getLangOpts().SizedDeallocation
       && Ctx.hasSameType(new QualType(Ty), Ctx.getSizeType().$QualType())) {
      return true;
    }
    if (!Ty.$arrow().isReferenceType()) {
      return false;
    }
    Ty.$assignMove(Ty.$arrow().getPointeeType());
    if (Ty.getCVRQualifiers() != Qualifiers.TQ.Const) {
      return false;
    }
    /*const*/ CXXRecordDecl /*P*/ RD = Ty.$arrow().getAsCXXRecordDecl();
    return (RD != null) && isNamed(RD, /*KEEP_STR*/"nothrow_t") && RD.isInStdNamespace();
  }

  
  /// Compute the language linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getLanguageLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2619,
   FQN="clang::FunctionDecl::getLanguageLinkage", NM="_ZNK5clang12FunctionDecl18getLanguageLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl18getLanguageLinkageEv")
  //</editor-fold>
  public LanguageLinkage getLanguageLinkage() /*const*/ {
    return getDeclLanguageLinkage(/*Deref*/this);
  }

  
  /// \brief Determines whether this function is a function with
  /// external, C linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isExternC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2623,
   FQN="clang::FunctionDecl::isExternC", NM="_ZNK5clang12FunctionDecl9isExternCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9isExternCEv")
  //</editor-fold>
  public boolean isExternC() /*const*/ {
    return isDeclExternC(/*Deref*/this);
  }

  
  /// \brief Determines whether this function's context is, or is nested within,
  /// a C++ extern "C" linkage spec.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isInExternCContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2627,
   FQN="clang::FunctionDecl::isInExternCContext", NM="_ZNK5clang12FunctionDecl18isInExternCContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl18isInExternCContextEv")
  //</editor-fold>
  public boolean isInExternCContext() /*const*/ {
    return getLexicalDeclContext$Const().isExternCContext();
  }

  
  /// \brief Determines whether this function's context is, or is nested within,
  /// a C++ extern "C++" linkage spec.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isInExternCXXContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2631,
   FQN="clang::FunctionDecl::isInExternCXXContext", NM="_ZNK5clang12FunctionDecl20isInExternCXXContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl20isInExternCXXContextEv")
  //</editor-fold>
  public boolean isInExternCXXContext() /*const*/ {
    return getLexicalDeclContext$Const().isExternCXXContext();
  }

  
  /// \brief Determines whether this is a global function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2635,
   FQN="clang::FunctionDecl::isGlobal", NM="_ZNK5clang12FunctionDecl8isGlobalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl8isGlobalEv")
  //</editor-fold>
  public boolean isGlobal() /*const*/ {
    {
      /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(this);
      if ((Method != null)) {
        return Method.isStatic();
      }
    }
    if (getCanonicalDecl$Const().getStorageClass() == StorageClass.SC_Static) {
      return false;
    }
    
    for (/*const*/ DeclContext /*P*/ DC = getDeclContext$Const();
         DC.isNamespace();
         DC = DC.getParent$Const()) {
      {
        /*const*/ NamespaceDecl /*P*/ Namespace = cast_NamespaceDecl(DC);
        if ((Namespace != null)) {
          if (!Namespace.getDeclName().$bool()) {
            return false;
          }
          break;
        }
      }
    }
    
    return true;
  }

  
  /// \brief Determines whether this function is known to be 'noreturn', through
  /// an attribute on its declaration or its type.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2655,
   FQN="clang::FunctionDecl::isNoReturn", NM="_ZNK5clang12FunctionDecl10isNoReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl10isNoReturnEv")
  //</editor-fold>
  public boolean isNoReturn() /*const*/ {
    return hasAttr(NoReturnAttr.class) || hasAttr(CXX11NoReturnAttr.class)
       || hasAttr(C11NoReturnAttr.class)
       || getType().$arrow().getAs(FunctionType.class).getNoReturnAttr();
  }

  
  /// \brief True if the function was a definition but its body was skipped.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasSkippedBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1976,
   FQN="clang::FunctionDecl::hasSkippedBody", NM="_ZNK5clang12FunctionDecl14hasSkippedBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl14hasSkippedBodyEv")
  //</editor-fold>
  public boolean hasSkippedBody() /*const*/ {
    return HasSkippedBody;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setHasSkippedBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1977,
   FQN="clang::FunctionDecl::setHasSkippedBody", NM="_ZN5clang12FunctionDecl17setHasSkippedBodyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl17setHasSkippedBodyEb")
  //</editor-fold>
  public void setHasSkippedBody() {
    setHasSkippedBody(true);
  }
  public void setHasSkippedBody(boolean Skipped/*= true*/) {
    HasSkippedBody = Skipped;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setPreviousDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2661,
   FQN="clang::FunctionDecl::setPreviousDeclaration", NM="_ZN5clang12FunctionDecl22setPreviousDeclarationEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl22setPreviousDeclarationEPS0_")
  //</editor-fold>
  public void setPreviousDeclaration(FunctionDecl /*P*/ PrevDecl) {
    Redeclarable.super.setPreviousDecl(PrevDecl);
    {
      
      FunctionTemplateDecl /*P*/ FunTmpl = getDescribedFunctionTemplate();
      if ((FunTmpl != null)) {
        FunctionTemplateDecl /*P*/ PrevFunTmpl = (PrevDecl != null) ? PrevDecl.getDescribedFunctionTemplate() : null;
        assert ((!(PrevDecl != null) || (PrevFunTmpl != null))) : "Function/function template mismatch";
        FunTmpl.setPreviousDecl(PrevFunTmpl);
      }
    }
    if ((PrevDecl != null) && PrevDecl.IsInline) {
      IsInline = true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2676,
   FQN="clang::FunctionDecl::getCanonicalDecl", NM="_ZN5clang12FunctionDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public FunctionDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1982,
   FQN="clang::FunctionDecl::getCanonicalDecl", NM="_ZNK5clang12FunctionDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/FunctionDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  
  /// \brief Returns a value indicating whether this function
  /// corresponds to a builtin function.
  ///
  /// The function corresponds to a built-in function if it is
  /// declared at translation scope or within an extern "C" block and
  /// its name matches with the name of a builtin. The returned value
  /// will be 0 for functions that do not correspond to a builtin, a
  /// value of type \c Builtin::ID if in the target-independent range
  /// \c [1,Builtin::First), or a target-specific builtin value.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getBuiltinID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2687,
   FQN="clang::FunctionDecl::getBuiltinID", NM="_ZNK5clang12FunctionDecl12getBuiltinIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl12getBuiltinIDEv")
  //</editor-fold>
  public /*uint*/int getBuiltinID() /*const*/ {
    if (!(getIdentifier() != null)) {
      return 0;
    }
    
    /*uint*/int BuiltinID = getIdentifier().getBuiltinID();
    if (!(BuiltinID != 0)) {
      return 0;
    }
    
    final ASTContext /*&*/ Context = getASTContext();
    if (Context.getLangOpts().CPlusPlus) {
      /*const*/ LinkageSpecDecl /*P*/ LinkageDecl = dyn_cast_LinkageSpecDecl(getFirstDecl$Const().getDeclContext$Const());
      // In C++, the first declaration of a builtin is always inside an implicit
      // extern "C".
      // FIXME: A recognised library function may not be directly in an extern "C"
      // declaration, for instance "extern "C" { namespace std { decl } }".
      if (!(LinkageDecl != null)) {
        if (BuiltinID == Builtin.ID.BI__GetExceptionInfo.getValue()
           && Context.getTargetInfo().getCXXABI().isMicrosoft()) {
          return Builtin.ID.BI__GetExceptionInfo.getValue();
        }
        return 0;
      }
      if (LinkageDecl.getLanguage() != LinkageSpecDecl.LanguageIDs.lang_c) {
        return 0;
      }
    }
    
    // If the function is marked "overloadable", it has a different mangled name
    // and is not the C library function.
    if (hasAttr(OverloadableAttr.class)) {
      return 0;
    }
    if (!Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID)) {
      return BuiltinID;
    }
    
    // This function has the name of a known C library
    // function. Determine whether it actually refers to the C library
    // function or whether it just has the same name.
    
    // If this is a static function, it's not a builtin.
    if (getStorageClass() == StorageClass.SC_Static) {
      return 0;
    }
    
    // OpenCL v1.2 s6.9.f - The library functions defined in
    // the C99 standard headers are not available.
    if (Context.getLangOpts().OpenCL
       && Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID)) {
      return 0;
    }
    
    return BuiltinID;
  }

  
  // ArrayRef interface to parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1989,
   FQN="clang::FunctionDecl::parameters", NM="_ZNK5clang12FunctionDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl10parametersEv")
  //</editor-fold>
  public ArrayRef<ParmVarDecl /*P*/ > parameters$Const() /*const*/ {
    return /*{ */new ArrayRef<ParmVarDecl /*P*/ >(ParamInfo, getNumParams(), true)/* }*/;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1992,
   FQN="clang::FunctionDecl::parameters", NM="_ZN5clang12FunctionDecl10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl10parametersEv")
  //</editor-fold>
  public MutableArrayRef<ParmVarDecl /*P*/ > parameters() {
    return /*{ */new MutableArrayRef<ParmVarDecl /*P*/ >(ParamInfo, getNumParams(), true)/* }*/;
  }

  
  // Iterator access to formal parameters.
  /*typedef MutableArrayRef<ParmVarDecl *>::iterator param_iterator*/
//  public final class param_iterator extends type$ptr<ParmVarDecl /*P*/ /*P*/>{ };
  /*typedef ArrayRef<ParmVarDecl *>::const_iterator param_const_iterator*/
//  public final class param_const_iterator extends type$ptr<ParmVarDecl /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::param_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1999,
   FQN="clang::FunctionDecl::param_empty", NM="_ZNK5clang12FunctionDecl11param_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl11param_emptyEv")
  //</editor-fold>
  public boolean param_empty() /*const*/ {
    return parameters$Const().empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2000,
   FQN="clang::FunctionDecl::param_begin", NM="_ZN5clang12FunctionDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl11param_beginEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_begin() {
    return parameters().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2001,
   FQN="clang::FunctionDecl::param_end", NM="_ZN5clang12FunctionDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl9param_endEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_end() {
    return parameters().end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2002,
   FQN="clang::FunctionDecl::param_begin", NM="_ZNK5clang12FunctionDecl11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl11param_beginEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_begin$Const() /*const*/ {
    return parameters$Const().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::param_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2003,
   FQN="clang::FunctionDecl::param_end", NM="_ZNK5clang12FunctionDecl9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9param_endEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*P*/> param_end$Const() /*const*/ {
    return parameters$Const().end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::param_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2004,
   FQN="clang::FunctionDecl::param_size", NM="_ZNK5clang12FunctionDecl10param_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl10param_sizeEv")
  //</editor-fold>
  public /*size_t*/int param_size() /*const*/ {
    return parameters$Const().size();
  }

  
  /// getNumParams - Return the number of parameters this function must have
  /// based on its FunctionType.  This is the length of the ParamInfo array
  /// after it has been created.
  
  /// getNumParams - Return the number of parameters this function must have
  /// based on its FunctionType.  This is the length of the ParamInfo array
  /// after it has been created.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2742,
   FQN="clang::FunctionDecl::getNumParams", NM="_ZNK5clang12FunctionDecl12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    /*const*/ FunctionProtoType /*P*/ FPT = getType().$arrow().getAs(FunctionProtoType.class);
    return (FPT != null) ? FPT.getNumParams() : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2011,
   FQN="clang::FunctionDecl::getParamDecl", NM="_ZNK5clang12FunctionDecl12getParamDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl12getParamDeclEj")
  //</editor-fold>
  public /*const*/ ParmVarDecl /*P*/ getParamDecl$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumParams())) : "Illegal param #";
    return ParamInfo.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2015,
   FQN="clang::FunctionDecl::getParamDecl", NM="_ZN5clang12FunctionDecl12getParamDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl12getParamDeclEj")
  //</editor-fold>
  public ParmVarDecl /*P*/ getParamDecl(/*uint*/int i) {
    assert ($less_uint(i, getNumParams())) : "Illegal param #";
    return ParamInfo.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2019,
   FQN="clang::FunctionDecl::setParams", NM="_ZN5clang12FunctionDecl9setParamsEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl9setParamsEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE")
  //</editor-fold>
  public void setParams(ArrayRef<ParmVarDecl /*P*/ > NewParamInfo) {
    setParams(getASTContext(), new ArrayRef<ParmVarDecl /*P*/ >(NewParamInfo));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getDeclsInPrototypeScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2023,
   FQN="clang::FunctionDecl::getDeclsInPrototypeScope", NM="_ZNK5clang12FunctionDecl24getDeclsInPrototypeScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl24getDeclsInPrototypeScopeEv")
  //</editor-fold>
  public ArrayRef<NamedDecl /*P*/ > getDeclsInPrototypeScope() /*const*/ {
    return new ArrayRef<NamedDecl /*P*/ >(DeclsInPrototypeScope);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setDeclsInPrototypeScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2759,
   FQN="clang::FunctionDecl::setDeclsInPrototypeScope", NM="_ZN5clang12FunctionDecl24setDeclsInPrototypeScopeEN4llvm8ArrayRefIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl24setDeclsInPrototypeScopeEN4llvm8ArrayRefIPNS_9NamedDeclEEE")
  //</editor-fold>
  public void setDeclsInPrototypeScope(ArrayRef<NamedDecl /*P*/ > NewDecls) {
    assert (DeclsInPrototypeScope.empty()) : "Already has prototype decls!";
    if (!NewDecls.empty()) {
      type$ptr<NamedDecl /*P*/ /*P*/> A = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (getASTContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new NamedDecl /*P*/ [NewDecls.size()]);
      std.copy(NewDecls.begin(), NewDecls.end(), A);
      DeclsInPrototypeScope.$assignMove(llvm.makeArrayRef(A, NewDecls.size()));
      // Move declarations introduced in prototype to the function context.
      for (NamedDecl /*P*/ I : NewDecls) {
        DeclContext /*P*/ DC = I.getDeclContext();
        // Forward-declared reference to an enumeration is not added to
        // declaration scope, so skip declaration that is absent from its
        // declaration contexts.
        if (DC.containsDecl(I)) {
          DC.removeDecl(I);
          I.setDeclContext(this);
          addDecl(I);
        }
      }
    }
  }

  
  /// getMinRequiredArguments - Returns the minimum number of arguments
  /// needed to call this function. This may be fewer than the number of
  /// function parameters, if some of the parameters have default
  /// arguments (in C++).
  
  /// getMinRequiredArguments - Returns the minimum number of arguments
  /// needed to call this function. This may be fewer than the number of
  /// function parameters, if some of the parameters have default
  /// arguments (in C++) or are parameter packs (C++11).
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getMinRequiredArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2785,
   FQN="clang::FunctionDecl::getMinRequiredArguments", NM="_ZNK5clang12FunctionDecl23getMinRequiredArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl23getMinRequiredArgumentsEv")
  //</editor-fold>
  public /*uint*/int getMinRequiredArguments() /*const*/ {
    if (!getASTContext().getLangOpts().CPlusPlus) {
      return getNumParams();
    }
    
    /*uint*/int NumRequiredArgs = 0;
    for (ParmVarDecl /*P*/ Param : parameters$Const())  {
      if (!Param.isParameterPack() && !Param.hasDefaultArg()) {
        ++NumRequiredArgs;
      }
    }
    return NumRequiredArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2034,
   FQN="clang::FunctionDecl::getReturnType", NM="_ZNK5clang12FunctionDecl13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl13getReturnTypeEv")
  //</editor-fold>
  public QualType getReturnType() /*const*/ {
    assert ((getType().$arrow().getAs(FunctionType.class) != null)) : "Expected a FunctionType!";
    return getType().$arrow().getAs(FunctionType.class).getReturnType();
  }

  
  /// \brief Attempt to compute an informative source range covering the
  /// function return type. This may omit qualifiers and other information with
  /// limited representation in the AST.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getReturnTypeSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2911,
   FQN="clang::FunctionDecl::getReturnTypeSourceRange", NM="_ZNK5clang12FunctionDecl24getReturnTypeSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl24getReturnTypeSourceRangeEv")
  //</editor-fold>
  public SourceRange getReturnTypeSourceRange() /*const*/ {
    /*const*/ TypeSourceInfo /*P*/ TSI = getTypeSourceInfo();
    if (!(TSI != null)) {
      return new SourceRange();
    }
    FunctionTypeLoc FTL = TSI.getTypeLoc().IgnoreParens().getAs(FunctionTypeLoc.class);
    if (!FTL.$bool()) {
      return new SourceRange();
    }
    
    // Skip self-referential return types.
    final /*const*/ SourceManager /*&*/ SM = getASTContext().getSourceManager();
    SourceRange RTRange = FTL.getReturnLoc().getSourceRange();
    SourceLocation Boundary = getNameInfo().getLocStart();
    if (RTRange.isInvalid() || Boundary.isInvalid()
       || !SM.isBeforeInTranslationUnit(RTRange.getEnd(), /*NO_COPY*/Boundary)) {
      return new SourceRange();
    }
    
    return RTRange;
  }

  
  /// \brief Determine the type of an expression that calls this function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getCallResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2045,
   FQN="clang::FunctionDecl::getCallResultType", NM="_ZNK5clang12FunctionDecl17getCallResultTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl17getCallResultTypeEv")
  //</editor-fold>
  public QualType getCallResultType() /*const*/ {
    assert ((getType().$arrow().getAs(FunctionType.class) != null)) : "Expected a FunctionType!";
    return getType().$arrow().getAs(FunctionType.class).getCallResultType(getASTContext());
  }

  
  /// \brief Returns the WarnUnusedResultAttr that is either declared on this
  /// function, or its return type declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getUnusedResultAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2931,
   FQN="clang::FunctionDecl::getUnusedResultAttr", NM="_ZNK5clang12FunctionDecl19getUnusedResultAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl19getUnusedResultAttrEv")
  //</editor-fold>
  public /*const*/ Attr /*P*/ getUnusedResultAttr() /*const*/ {
    QualType RetType = getReturnType();
    if (RetType.$arrow().isRecordType()) {
      /*const*/ CXXRecordDecl /*P*/ Ret = RetType.$arrow().getAsCXXRecordDecl();
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(this);
      if ((Ret != null) && !((MD != null) && (MD.getCorrespondingMethodInClass$Const(Ret, true) != null))) {
        {
          /*const*/ WarnUnusedResultAttr /*P*/ R = Ret.getAttr(WarnUnusedResultAttr.class);
          if ((R != null)) {
            return R;
          }
        }
      }
    } else {
      /*const*/ EnumType /*P*/ ET = RetType.$arrow().getAs$EnumType();
      if ((ET != null)) {
        {
          /*const*/ EnumDecl /*P*/ ED = ET.getDecl();
          if ((ED != null)) {
            {
              /*const*/ WarnUnusedResultAttr /*P*/ R = ED.getAttr(WarnUnusedResultAttr.class);
              if ((R != null)) {
                return R;
              }
            }
          }
        }
      }
    }
    return getAttr(WarnUnusedResultAttr.class);
  }

  
  /// \brief Returns true if this function or its return type has the
  /// warn_unused_result attribute. If the return type has the attribute and
  /// this function is a method of the return type's class, then false will be
  /// returned to avoid spurious warnings on member methods such as assignment
  /// operators.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::hasUnusedResultAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2059,
   FQN="clang::FunctionDecl::hasUnusedResultAttr", NM="_ZNK5clang12FunctionDecl19hasUnusedResultAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl19hasUnusedResultAttrEv")
  //</editor-fold>
  public boolean hasUnusedResultAttr() /*const*/ {
    return getUnusedResultAttr() != null;
  }

  
  /// \brief Returns the storage class as written in the source. For the
  /// computed linkage of symbol, see getLinkage.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2063,
   FQN="clang::FunctionDecl::getStorageClass", NM="_ZNK5clang12FunctionDecl15getStorageClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl15getStorageClassEv")
  //</editor-fold>
  public StorageClass getStorageClass() /*const*/ {
    return StorageClass.valueOf(SClass);
  }

  
  /// \brief Determine whether the "inline" keyword was specified for this
  /// function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isInlineSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2067,
   FQN="clang::FunctionDecl::isInlineSpecified", NM="_ZNK5clang12FunctionDecl17isInlineSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl17isInlineSpecifiedEv")
  //</editor-fold>
  public boolean isInlineSpecified() /*const*/ {
    return IsInlineSpecified;
  }

  
  /// Set whether the "inline" keyword was specified for this function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setInlineSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2070,
   FQN="clang::FunctionDecl::setInlineSpecified", NM="_ZN5clang12FunctionDecl18setInlineSpecifiedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl18setInlineSpecifiedEb")
  //</editor-fold>
  public void setInlineSpecified(boolean I) {
    IsInlineSpecified = I;
    IsInline = I;
  }

  
  /// Flag that this function is implicitly inline.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setImplicitlyInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2076,
   FQN="clang::FunctionDecl::setImplicitlyInline", NM="_ZN5clang12FunctionDecl19setImplicitlyInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl19setImplicitlyInlineEv")
  //</editor-fold>
  public void setImplicitlyInline() {
    IsInline = true;
  }

  
  /// \brief Determine whether this function should be inlined, because it is
  /// either marked "inline" or "constexpr" or is a member function of a class
  /// that was defined in the class body.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isInlined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2083,
   FQN="clang::FunctionDecl::isInlined", NM="_ZNK5clang12FunctionDecl9isInlinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl9isInlinedEv")
  //</editor-fold>
  public boolean isInlined() /*const*/ {
    return IsInline;
  }

  
  
  /// \brief For an inline function definition in C, or for a gnu_inline function
  /// in C++, determine whether the definition will be externally visible.
  ///
  /// Inline function definitions are always available for inlining optimizations.
  /// However, depending on the language dialect, declaration specifiers, and
  /// attributes, the definition of an inline function may or may not be
  /// "externally" visible to other translation units in the program.
  ///
  /// In C99, inline definitions are not externally visible by default. However,
  /// if even one of the global-scope declarations is marked "extern inline", the
  /// inline definition becomes externally visible (C99 6.7.4p6).
  ///
  /// In GNU89 mode, or if the gnu_inline attribute is attached to the function
  /// definition, we use the GNU semantics for inline, which are nearly the 
  /// opposite of C99 semantics. In particular, "inline" by itself will create 
  /// an externally visible symbol, but "extern inline" will not create an 
  /// externally visible symbol.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isInlineDefinitionExternallyVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2966,
   FQN="clang::FunctionDecl::isInlineDefinitionExternallyVisible", NM="_ZNK5clang12FunctionDecl35isInlineDefinitionExternallyVisibleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl35isInlineDefinitionExternallyVisibleEv")
  //</editor-fold>
  public boolean isInlineDefinitionExternallyVisible() /*const*/ {
    assert (doesThisDeclarationHaveABody()) : "Must have the function definition";
    assert (isInlined()) : "Function must be inline";
    final ASTContext /*&*/ Context = getASTContext();
    if (Context.getLangOpts().GNUInline || hasAttr(GNUInlineAttr.class)) {
      // Note: If you change the logic here, please change
      // doesDeclarationForceExternallyVisibleDefinition as well.
      //
      // If it's not the case that both 'inline' and 'extern' are
      // specified on the definition, then this inline definition is
      // externally visible.
      if (!(isInlineSpecified() && getStorageClass() == StorageClass.SC_Extern)) {
        return true;
      }
      
      // If any declaration is 'inline' but not 'extern', then this definition
      // is externally visible.
      for (FunctionDecl /*P*/ Redecl : redeclarable_redecls()) {
        if (Redecl.isInlineSpecified()
           && Redecl.getStorageClass() != StorageClass.SC_Extern) {
          return true;
        }
      }
      
      return false;
    }
    
    // The rest of this function is C-only.
    assert (!Context.getLangOpts().CPlusPlus) : "should not use C inline rules in C++";
    
    // C99 6.7.4p6:
    //   [...] If all of the file scope declarations for a function in a 
    //   translation unit include the inline function specifier without extern, 
    //   then the definition in that translation unit is an inline definition.
    for (FunctionDecl /*P*/ Redecl : redeclarable_redecls()) {
      if (RedeclForcesDefC99(Redecl)) {
        return true;
      }
    }
    
    // C99 6.7.4p6:
    //   An inline definition does not provide an external definition for the 
    //   function, and does not forbid an external definition in another 
    //   translation unit.
    return false;
  }

  
  
  /// \brief The combination of the extern and inline keywords under MSVC forces
  /// the function to be required.
  ///
  /// Note: This function assumes that we will only get called when isInlined()
  /// would return true for this FunctionDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isMSExternInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2801,
   FQN="clang::FunctionDecl::isMSExternInline", NM="_ZNK5clang12FunctionDecl16isMSExternInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl16isMSExternInlineEv")
  //</editor-fold>
  public boolean isMSExternInline() /*const*/ {
    assert (isInlined()) : "expected to get called on an inlined function!";
    
    final /*const*/ ASTContext /*&*/ Context = getASTContext();
    if (!Context.getTargetInfo().getCXXABI().isMicrosoft()
       && !hasAttr(DLLExportAttr.class)) {
      return false;
    }
    
    for (/*const*/ FunctionDecl /*P*/ FD = getMostRecentDecl$Redeclarable$Const(); (FD != null);
         FD = FD.getPreviousDecl$Redeclarable$Const())  {
      if (!FD.isImplicit() && FD.getStorageClass() == StorageClass.SC_Extern) {
        return true;
      }
    }
    
    return false;
  }

  
  
  /// \brief For a function declaration in C or C++, determine whether this
  /// declaration causes the definition to be externally visible.
  ///
  /// For instance, this determines if adding the current declaration to the set
  /// of redeclarations of the given functions causes
  /// isInlineDefinitionExternallyVisible to change from false to true.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::doesDeclarationForceExternallyVisibleDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2851,
   FQN="clang::FunctionDecl::doesDeclarationForceExternallyVisibleDefinition", NM="_ZNK5clang12FunctionDecl47doesDeclarationForceExternallyVisibleDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl47doesDeclarationForceExternallyVisibleDefinitionEv")
  //</editor-fold>
  public boolean doesDeclarationForceExternallyVisibleDefinition() /*const*/ {
    assert (!doesThisDeclarationHaveABody()) : "Must have a declaration without a body.";
    
    final ASTContext /*&*/ Context = getASTContext();
    if (Context.getLangOpts().MSVCCompat) {
      type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
      if (hasBody(Definition) && Definition.$deref().isInlined()
         && redeclForcesDefMSVC(this)) {
        return true;
      }
    }
    if (Context.getLangOpts().GNUInline || hasAttr(GNUInlineAttr.class)) {
      // With GNU inlining, a declaration with 'inline' but not 'extern', forces
      // an externally visible definition.
      //
      // FIXME: What happens if gnu_inline gets added on after the first
      // declaration?
      if (!isInlineSpecified() || getStorageClass() == StorageClass.SC_Extern) {
        return false;
      }
      
      /*const*/ FunctionDecl /*P*/ Prev = this;
      boolean FoundBody = false;
      while (((Prev = Prev.getPreviousDecl$Redeclarable$Const()) != null)) {
        FoundBody |= Prev.Body.isValid();
        if (Prev.Body.$bool()) {
          // If it's not the case that both 'inline' and 'extern' are
          // specified on the definition, then it is always externally visible.
          if (!Prev.isInlineSpecified()
             || Prev.getStorageClass() != StorageClass.SC_Extern) {
            return false;
          }
        } else if (Prev.isInlineSpecified()
           && Prev.getStorageClass() != StorageClass.SC_Extern) {
          return false;
        }
      }
      return FoundBody;
    }
    if (Context.getLangOpts().CPlusPlus) {
      return false;
    }
    
    // C99 6.7.4p6:
    //   [...] If all of the file scope declarations for a function in a 
    //   translation unit include the inline function specifier without extern, 
    //   then the definition in that translation unit is an inline definition.
    if (isInlineSpecified() && getStorageClass() != StorageClass.SC_Extern) {
      return false;
    }
    /*const*/ FunctionDecl /*P*/ Prev = this;
    boolean FoundBody = false;
    while (((Prev = Prev.getPreviousDecl$Redeclarable$Const()) != null)) {
      FoundBody |= Prev.Body.isValid();
      if (RedeclForcesDefC99(Prev)) {
        return false;
      }
    }
    return FoundBody;
  }

  
  /// isOverloadedOperator - Whether this function declaration
  /// represents an C++ overloaded operator, e.g., "operator+".
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2093,
   FQN="clang::FunctionDecl::isOverloadedOperator", NM="_ZNK5clang12FunctionDecl20isOverloadedOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl20isOverloadedOperatorEv")
  //</editor-fold>
  public boolean isOverloadedOperator() /*const*/ {
    return getOverloadedOperator() != OverloadedOperatorKind.OO_None;
  }

  
  
  /// getOverloadedOperator - Which C++ overloaded operator this
  /// function represents, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3014,
   FQN="clang::FunctionDecl::getOverloadedOperator", NM="_ZNK5clang12FunctionDecl21getOverloadedOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl21getOverloadedOperatorEv")
  //</editor-fold>
  public OverloadedOperatorKind getOverloadedOperator() /*const*/ {
    if (getDeclName().getNameKind() == DeclarationName.NameKind.CXXOperatorName) {
      return getDeclName().getCXXOverloadedOperator();
    } else {
      return OverloadedOperatorKind.OO_None;
    }
  }

  
  
  /// getLiteralIdentifier - The literal suffix identifier this function
  /// represents, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getLiteralIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3023,
   FQN="clang::FunctionDecl::getLiteralIdentifier", NM="_ZNK5clang12FunctionDecl20getLiteralIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl20getLiteralIdentifierEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getLiteralIdentifier() /*const*/ {
    if (getDeclName().getNameKind() == DeclarationName.NameKind.CXXLiteralOperatorName) {
      return getDeclName().getCXXLiteralIdentifier();
    } else {
      return null;
    }
  }

  
  /// \brief If this function is an instantiation of a member function
  /// of a class template specialization, retrieves the function from
  /// which it was instantiated.
  ///
  /// This routine will return non-NULL for (non-templated) member
  /// functions of class templates and for instantiations of function
  /// templates. For example, given:
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   void f(T);
  /// };
  /// \endcode
  ///
  /// The declaration for X<int>::f is a (non-templated) FunctionDecl
  /// whose parent is the class template specialization X<int>. For
  /// this declaration, getInstantiatedFromFunction() will return
  /// the FunctionDecl X<T>::A. When a complete definition of
  /// X<int>::A is required, it will be instantiated from the
  /// declaration returned by getInstantiatedFromMemberFunction().
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getInstantiatedFromMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3046,
   FQN="clang::FunctionDecl::getInstantiatedFromMemberFunction", NM="_ZNK5clang12FunctionDecl33getInstantiatedFromMemberFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl33getInstantiatedFromMemberFunctionEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getInstantiatedFromMemberFunction() /*const*/ {
    {
      MemberSpecializationInfo /*P*/ Info = getMemberSpecializationInfo();
      if ((Info != null)) {
        return cast_FunctionDecl(Info.getInstantiatedFrom());
      }
    }
    
    return null;
  }

  
  /// \brief What kind of templated function this is.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getTemplatedKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3030,
   FQN="clang::FunctionDecl::getTemplatedKind", NM="_ZNK5clang12FunctionDecl16getTemplatedKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl16getTemplatedKindEv")
  //</editor-fold>
  public FunctionDecl.TemplatedKind getTemplatedKind() /*const*/ {
    if (TemplateOrSpecialization.isNull()) {
      return TemplatedKind.TK_NonTemplate;
    }
    if ((TemplateOrSpecialization.is(FunctionTemplateDecl /*P*/.class) != 0)) {
      return TemplatedKind.TK_FunctionTemplate;
    }
    if ((TemplateOrSpecialization.is(MemberSpecializationInfo /*P*/.class) != 0)) {
      return TemplatedKind.TK_MemberSpecialization;
    }
    if ((TemplateOrSpecialization.is(FunctionTemplateSpecializationInfo /*P*/.class) != 0)) {
      return TemplatedKind.TK_FunctionTemplateSpecialization;
    }
    if ((TemplateOrSpecialization.is(DependentFunctionTemplateSpecializationInfo /*P*/.class) != 0)) {
      return TemplatedKind.TK_DependentFunctionTemplateSpecialization;
    }
    throw new llvm_unreachable("Did we miss a TemplateOrSpecialization type?");
  }

  
  /// \brief If this function is an instantiation of a member function of a
  /// class template specialization, retrieves the member specialization
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getMemberSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3053,
   FQN="clang::FunctionDecl::getMemberSpecializationInfo", NM="_ZNK5clang12FunctionDecl27getMemberSpecializationInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl27getMemberSpecializationInfoEv")
  //</editor-fold>
  public MemberSpecializationInfo /*P*/ getMemberSpecializationInfo() /*const*/ {
    return TemplateOrSpecialization.dyn_cast(MemberSpecializationInfo /*P*/.class);
  }

  
  /// \brief Specify that this record is an instantiation of the
  /// member function FD.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setInstantiationOfMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2134,
   FQN="clang::FunctionDecl::setInstantiationOfMemberFunction", NM="_ZN5clang12FunctionDecl32setInstantiationOfMemberFunctionEPS0_NS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl32setInstantiationOfMemberFunctionEPS0_NS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setInstantiationOfMemberFunction(FunctionDecl /*P*/ FD, 
                                  TemplateSpecializationKind TSK) {
    setInstantiationOfMemberFunction(getASTContext(), FD, TSK);
  }

  
  /// \brief Retrieves the function template that is described by this
  /// function declaration.
  ///
  /// Every function template is represented as a FunctionTemplateDecl
  /// and a FunctionDecl (or something derived from FunctionDecl). The
  /// former contains template properties (such as the template
  /// parameter lists) while the latter contains the actual
  /// description of the template's
  /// contents. FunctionTemplateDecl::getTemplatedDecl() retrieves the
  /// FunctionDecl that describes the function template,
  /// getDescribedFunctionTemplate() retrieves the
  /// FunctionTemplateDecl from a FunctionDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getDescribedFunctionTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3068,
   FQN="clang::FunctionDecl::getDescribedFunctionTemplate", NM="_ZNK5clang12FunctionDecl28getDescribedFunctionTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl28getDescribedFunctionTemplateEv")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getDescribedFunctionTemplate() /*const*/ {
    return TemplateOrSpecialization.dyn_cast(FunctionTemplateDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setDescribedFunctionTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3072,
   FQN="clang::FunctionDecl::setDescribedFunctionTemplate", NM="_ZN5clang12FunctionDecl28setDescribedFunctionTemplateEPNS_20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl28setDescribedFunctionTemplateEPNS_20FunctionTemplateDeclE")
  //</editor-fold>
  public void setDescribedFunctionTemplate(FunctionTemplateDecl /*P*/ Template) {
    TemplateOrSpecialization.$assign_T$C$R(FunctionTemplateDecl /*P*/ /*const*/ /*&*/.class, Template);
  }

  
  /// \brief Determine whether this function is a function template
  /// specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isFunctionTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2157,
   FQN="clang::FunctionDecl::isFunctionTemplateSpecialization", NM="_ZNK5clang12FunctionDecl32isFunctionTemplateSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl32isFunctionTemplateSpecializationEv")
  //</editor-fold>
  public boolean isFunctionTemplateSpecialization() /*const*/ {
    return getPrimaryTemplate() != null;
  }

  
  /// \brief Retrieve the class scope template pattern that this function
  ///  template specialization is instantiated from.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getClassScopeSpecializationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3178,
   FQN="clang::FunctionDecl::getClassScopeSpecializationPattern", NM="_ZNK5clang12FunctionDecl34getClassScopeSpecializationPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl34getClassScopeSpecializationPatternEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getClassScopeSpecializationPattern() /*const*/ {
    return getASTContext().getClassScopeSpecializationPattern(this);
  }

  
  /// \brief If this function is actually a function template specialization,
  /// retrieve information about this function template specialization.
  /// Otherwise, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getTemplateSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3182,
   FQN="clang::FunctionDecl::getTemplateSpecializationInfo", NM="_ZNK5clang12FunctionDecl29getTemplateSpecializationInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl29getTemplateSpecializationInfoEv")
  //</editor-fold>
  public FunctionTemplateSpecializationInfo /*P*/ getTemplateSpecializationInfo() /*const*/ {
    return TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
  }

  
  /// \brief Determines whether this function is a function template
  /// specialization or a member of a class template specialization that can
  /// be implicitly instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isImplicitlyInstantiable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3076,
   FQN="clang::FunctionDecl::isImplicitlyInstantiable", NM="_ZNK5clang12FunctionDecl24isImplicitlyInstantiableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl24isImplicitlyInstantiableEv")
  //</editor-fold>
  public boolean isImplicitlyInstantiable() /*const*/ {
    // If the function is invalid, it can't be implicitly instantiated.
    if (isInvalidDecl()) {
      return false;
    }
    switch (getTemplateSpecializationKind()) {
     case TSK_Undeclared:
     case TSK_ExplicitInstantiationDefinition:
      return false;
     case TSK_ImplicitInstantiation:
      return true;
     case TSK_ExplicitSpecialization:
      
      // It is possible to instantiate TSK_ExplicitSpecialization kind
      // if the FunctionDecl has a class scope specialization pattern.
      return getClassScopeSpecializationPattern() != null;
     case TSK_ExplicitInstantiationDeclaration:
      // Handled below.
      break;
    }
    
    // Find the actual template from which we will instantiate.
    type$ref</*const*/ FunctionDecl /*P*/ > PatternDecl = create_type$ref(getTemplateInstantiationPattern());
    boolean HasPattern = false;
    if ((PatternDecl.$deref() != null)) {
      HasPattern = PatternDecl.$deref().hasBody(PatternDecl);
    }
    
    // C++0x [temp.explicit]p9:
    //   Except for inline functions, other explicit instantiation declarations
    //   have the effect of suppressing the implicit instantiation of the entity
    //   to which they refer. 
    if (!HasPattern || !(PatternDecl.$deref() != null)) {
      return true;
    }
    
    return PatternDecl.$deref().isInlined();
  }

  
  /// \brief Determines if the given function was instantiated from a
  /// function template.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isTemplateInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3115,
   FQN="clang::FunctionDecl::isTemplateInstantiation", NM="_ZNK5clang12FunctionDecl23isTemplateInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl23isTemplateInstantiationEv")
  //</editor-fold>
  public boolean isTemplateInstantiation() /*const*/ {
    switch (getTemplateSpecializationKind()) {
     case TSK_Undeclared:
     case TSK_ExplicitSpecialization:
      return false;
     case TSK_ImplicitInstantiation:
     case TSK_ExplicitInstantiationDeclaration:
     case TSK_ExplicitInstantiationDefinition:
      return true;
    }
    throw new llvm_unreachable("All TSK values handled.");
  }

  
  /// \brief Retrieve the function declaration from which this function could
  /// be instantiated, if it is an instantiation (rather than a non-template
  /// or a specialization, for example).
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getTemplateInstantiationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3128,
   FQN="clang::FunctionDecl::getTemplateInstantiationPattern", NM="_ZNK5clang12FunctionDecl31getTemplateInstantiationPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl31getTemplateInstantiationPatternEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getTemplateInstantiationPattern() /*const*/ {
    // Handle class scope explicit specialization special case.
    if (getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
      return getClassScopeSpecializationPattern();
    }
    
    // If this is a generic lambda call operator specialization, its 
    // instantiation pattern is always its primary template's pattern
    // even if its primary template was instantiated from another 
    // member template (which happens with nested generic lambdas).
    // Since a lambda's call operator's body is transformed eagerly, 
    // we don't have to go hunting for a prototype definition template 
    // (i.e. instantiated-from-member-template) to use as an instantiation 
    // pattern.
    if (isGenericLambdaCallOperatorSpecialization(dyn_cast_CXXMethodDecl(this))) {
      assert ((getPrimaryTemplate() != null)) : "A generic lambda specialization must be generated from a primary call operator template";
      assert ((getPrimaryTemplate().getTemplatedDecl().getBody() != null)) : "A generic lambda call operator template must always have a body - even if instantiated from a prototype (i.e. as written) member template";
      return getPrimaryTemplate().getTemplatedDecl();
    }
    {
      
      FunctionTemplateDecl /*P*/ Primary = getPrimaryTemplate();
      if ((Primary != null)) {
        while ((Primary.getInstantiatedFromMemberTemplate() != null)) {
          // If we have hit a point where the user provided a specialization of
          // this template, we're done looking.
          if (Primary.isMemberSpecialization()) {
            break;
          }
          Primary = Primary.getInstantiatedFromMemberTemplate();
        }
        
        return Primary.getTemplatedDecl();
      }
    }
    
    return getInstantiatedFromMemberFunction();
  }

  
  /// \brief Retrieve the primary template that this function template
  /// specialization either specializes or was instantiated from.
  ///
  /// If this function declaration is not a function template specialization,
  /// returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getPrimaryTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3169,
   FQN="clang::FunctionDecl::getPrimaryTemplate", NM="_ZNK5clang12FunctionDecl18getPrimaryTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl18getPrimaryTemplateEv")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getPrimaryTemplate() /*const*/ {
    {
      FunctionTemplateSpecializationInfo /*P*/ Info = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
      if ((Info != null)) {
        return Info.Template.getPointer();
      }
    }
    return null;
  }

  
  /// \brief Retrieve the template arguments used to produce this function
  /// template specialization from the primary template.
  ///
  /// If this function declaration is not a function template specialization,
  /// returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getTemplateSpecializationArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3188,
   FQN="clang::FunctionDecl::getTemplateSpecializationArgs", NM="_ZNK5clang12FunctionDecl29getTemplateSpecializationArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl29getTemplateSpecializationArgsEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentList /*P*/ getTemplateSpecializationArgs() /*const*/ {
    {
      FunctionTemplateSpecializationInfo /*P*/ Info = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
      if ((Info != null)) {
        return Info.TemplateArguments;
      }
    }
    return null;
  }

  
  /// \brief Retrieve the template argument list as written in the sources,
  /// if any.
  ///
  /// If this function declaration is not a function template specialization
  /// or if it had no explicit template argument list, returns NULL.
  /// Note that it an explicit template argument list may be written empty,
  /// e.g., template<> void foo<>(char* s);
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getTemplateSpecializationArgsAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3198,
   FQN="clang::FunctionDecl::getTemplateSpecializationArgsAsWritten", NM="_ZNK5clang12FunctionDecl38getTemplateSpecializationArgsAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl38getTemplateSpecializationArgsAsWrittenEv")
  //</editor-fold>
  public /*const*/ ASTTemplateArgumentListInfo /*P*/ getTemplateSpecializationArgsAsWritten() /*const*/ {
    {
      FunctionTemplateSpecializationInfo /*P*/ Info = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
      if ((Info != null)) {
        return Info.TemplateArgumentsAsWritten;
      }
    }
    return null;
  }

  
  /// \brief Specify that this function declaration is actually a function
  /// template specialization.
  ///
  /// \param Template the function template that this function template
  /// specialization specializes.
  ///
  /// \param TemplateArgs the template arguments that produced this
  /// function template specialization from the template.
  ///
  /// \param InsertPos If non-NULL, the position in the function template
  /// specialization set where the function template specialization data will
  /// be inserted.
  ///
  /// \param TSK the kind of template specialization this is.
  ///
  /// \param TemplateArgsAsWritten location info of template arguments.
  ///
  /// \param PointOfInstantiation point at which the function template
  /// specialization was first instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setFunctionTemplateSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2227,
   FQN="clang::FunctionDecl::setFunctionTemplateSpecialization", NM="_ZN5clang12FunctionDecl33setFunctionTemplateSpecializationEPNS_20FunctionTemplateDeclEPKNS_20TemplateArgumentListEPvNS_26TemplateSpecializationKindEPKNS_24TemplateArgumentListInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl33setFunctionTemplateSpecializationEPNS_20FunctionTemplateDeclEPKNS_20TemplateArgumentListEPvNS_26TemplateSpecializationKindEPKNS_24TemplateArgumentListInfoENS_14SourceLocationE")
  //</editor-fold>
  public void setFunctionTemplateSpecialization(FunctionTemplateDecl /*P*/ Template, 
                                   /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
                                   type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos) {
    setFunctionTemplateSpecialization(Template, 
                                   TemplateArgs, 
                                   InsertPos, 
                                   TemplateSpecializationKind.TSK_ImplicitInstantiation, 
                                   (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
                                   new SourceLocation());
  }
  public void setFunctionTemplateSpecialization(FunctionTemplateDecl /*P*/ Template, 
                                   /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
                                   type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos, 
                                   TemplateSpecializationKind TSK/*= TSK_ImplicitInstantiation*/) {
    setFunctionTemplateSpecialization(Template, 
                                   TemplateArgs, 
                                   InsertPos, 
                                   TSK, 
                                   (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
                                   new SourceLocation());
  }
  public void setFunctionTemplateSpecialization(FunctionTemplateDecl /*P*/ Template, 
                                   /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
                                   type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos, 
                                   TemplateSpecializationKind TSK/*= TSK_ImplicitInstantiation*/, 
                                   /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgsAsWritten/*= null*/) {
    setFunctionTemplateSpecialization(Template, 
                                   TemplateArgs, 
                                   InsertPos, 
                                   TSK, 
                                   TemplateArgsAsWritten, 
                                   new SourceLocation());
  }
  public void setFunctionTemplateSpecialization(FunctionTemplateDecl /*P*/ Template, 
                                   /*const*/ TemplateArgumentList /*P*/ TemplateArgs, 
                                   type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos, 
                                   TemplateSpecializationKind TSK/*= TSK_ImplicitInstantiation*/, 
                                   /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgsAsWritten/*= null*/, 
                                   SourceLocation PointOfInstantiation/*= SourceLocation()*/) {
    setFunctionTemplateSpecialization(getASTContext(), Template, TemplateArgs, 
        InsertPos, TSK, TemplateArgsAsWritten, 
        new SourceLocation(PointOfInstantiation));
  }

  
  /// \brief Specifies that this function declaration is actually a
  /// dependent function template specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setDependentTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3229,
   FQN="clang::FunctionDecl::setDependentTemplateSpecialization", NM="_ZN5clang12FunctionDecl34setDependentTemplateSpecializationERNS_10ASTContextERKNS_17UnresolvedSetImplERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl34setDependentTemplateSpecializationERNS_10ASTContextERKNS_17UnresolvedSetImplERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void setDependentTemplateSpecialization(final ASTContext /*&*/ Context, 
                                    final /*const*/ UnresolvedSetImpl /*&*/ Templates, 
                                    final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgs) {
    assert (TemplateOrSpecialization.isNull());
    DependentFunctionTemplateSpecializationInfo /*P*/ Info = DependentFunctionTemplateSpecializationInfo.Create(Context, Templates, 
        TemplateArgs);
    TemplateOrSpecialization.$assign_T3$C$R(DependentFunctionTemplateSpecializationInfo /*P*/ /*const*/ /*&*/.class, Info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getDependentSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3240,
   FQN="clang::FunctionDecl::getDependentSpecializationInfo", NM="_ZNK5clang12FunctionDecl30getDependentSpecializationInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl30getDependentSpecializationInfoEv")
  //</editor-fold>
  public DependentFunctionTemplateSpecializationInfo /*P*/ getDependentSpecializationInfo() /*const*/ {
    return TemplateOrSpecialization.dyn_cast(DependentFunctionTemplateSpecializationInfo /*P*/.class);
  }

  
  /// \brief Determine what kind of template instantiation this function
  /// represents.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3273,
   FQN="clang::FunctionDecl::getTemplateSpecializationKind", NM="_ZNK5clang12FunctionDecl29getTemplateSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl29getTemplateSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getTemplateSpecializationKind() /*const*/ {
    // For a function template specialization, query the specialization
    // information object.
    FunctionTemplateSpecializationInfo /*P*/ FTSInfo = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
    if ((FTSInfo != null)) {
      return FTSInfo.getTemplateSpecializationKind();
    }
    
    MemberSpecializationInfo /*P*/ MSInfo = TemplateOrSpecialization.dyn_cast(MemberSpecializationInfo /*P*/.class);
    if ((MSInfo != null)) {
      return MSInfo.getTemplateSpecializationKind();
    }
    
    return TemplateSpecializationKind.TSK_Undeclared;
  }

  
  /// \brief Determine what kind of template instantiation this function
  /// represents.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::setTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3289,
   FQN="clang::FunctionDecl::setTemplateSpecializationKind", NM="_ZN5clang12FunctionDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK) {
    setTemplateSpecializationKind(TSK, 
                               new SourceLocation());
  }
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK, 
                               SourceLocation PointOfInstantiation/*= SourceLocation()*/) {
    {
      FunctionTemplateSpecializationInfo /*P*/ FTSInfo = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
      if ((FTSInfo != null)) {
        FTSInfo.setTemplateSpecializationKind(TSK);
        if (TSK != TemplateSpecializationKind.TSK_ExplicitSpecialization
           && PointOfInstantiation.isValid()
           && FTSInfo.getPointOfInstantiation().isInvalid()) {
          FTSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
        }
      } else {
        MemberSpecializationInfo /*P*/ MSInfo = TemplateOrSpecialization.dyn_cast(MemberSpecializationInfo /*P*/.class);
        if ((MSInfo != null)) {
          MSInfo.setTemplateSpecializationKind(TSK);
          if (TSK != TemplateSpecializationKind.TSK_ExplicitSpecialization
             && PointOfInstantiation.isValid()
             && MSInfo.getPointOfInstantiation().isInvalid()) {
            MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
          }
        } else {
          throw new llvm_unreachable("Function cannot have a template specialization kind");
        }
      }
    }
  }

  
  /// \brief Retrieve the (first) point of instantiation of a function template
  /// specialization or a member of a class template specialization.
  ///
  /// \returns the first point of instantiation, if this function was
  /// instantiated from a template; otherwise, returns an invalid source
  /// location.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3311,
   FQN="clang::FunctionDecl::getPointOfInstantiation", NM="_ZNK5clang12FunctionDecl23getPointOfInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl23getPointOfInstantiationEv")
  //</editor-fold>
  public SourceLocation getPointOfInstantiation() /*const*/ {
    {
      FunctionTemplateSpecializationInfo /*P*/ FTSInfo = TemplateOrSpecialization.dyn_cast(FunctionTemplateSpecializationInfo /*P*/.class);
      if ((FTSInfo != null)) {
        return FTSInfo.getPointOfInstantiation();
      } else {
        MemberSpecializationInfo /*P*/ MSInfo = TemplateOrSpecialization.dyn_cast(MemberSpecializationInfo /*P*/.class);
        if ((MSInfo != null)) {
          return MSInfo.getPointOfInstantiation();
        }
      }
    }
    
    return new SourceLocation();
  }

  
  /// \brief Determine whether this is or was instantiated from an out-of-line
  /// definition of a member function.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::isOutOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3323,
   FQN="clang::FunctionDecl::isOutOfLine", NM="_ZNK5clang12FunctionDecl11isOutOfLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl11isOutOfLineEv")
  //</editor-fold>
  @Override public boolean isOutOfLine() /*const*//* override*/ {
    if (super.isOutOfLine()) {
      return true;
    }
    {
      
      // If this function was instantiated from a member function of a 
      // class template, check whether that member function was defined out-of-line.
      FunctionDecl /*P*/ FD = getInstantiatedFromMemberFunction();
      if ((FD != null)) {
        type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
        if (FD.hasBody(Definition)) {
          return Definition.$deref().isOutOfLine();
        }
      }
    }
    {
      
      // If this function was instantiated from a function template,
      // check whether that function template was defined out-of-line.
      FunctionTemplateDecl /*P*/ FunTmpl = getPrimaryTemplate();
      if ((FunTmpl != null)) {
        type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
        if (FunTmpl.getTemplatedDecl().hasBody(Definition)) {
          return Definition.$deref().isOutOfLine();
        }
      }
    }
    
    return false;
  }

  
  /// \brief Identify a memory copying or setting function.
  /// If the given function is a memory copy or setting function, returns
  /// the corresponding Builtin ID. If the function is not a memory function,
  /// returns 0.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::getMemoryFunctionKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3350,
   FQN="clang::FunctionDecl::getMemoryFunctionKind", NM="_ZNK5clang12FunctionDecl21getMemoryFunctionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12FunctionDecl21getMemoryFunctionKindEv")
  //</editor-fold>
  public /*uint*/int getMemoryFunctionKind() /*const*/ {
    IdentifierInfo /*P*/ FnInfo = getIdentifier();
    if (!(FnInfo != null)) {
      return 0;
    }
    
    // Builtin handling.
    switch (Builtin.ID.valueOf(getBuiltinID())) {
     case BI__builtin_memset:
     case BI__builtin___memset_chk:
     case BImemset:
      return Builtin.ID.BImemset.getValue();
     case BI__builtin_memcpy:
     case BI__builtin___memcpy_chk:
     case BImemcpy:
      return Builtin.ID.BImemcpy.getValue();
     case BI__builtin_memmove:
     case BI__builtin___memmove_chk:
     case BImemmove:
      return Builtin.ID.BImemmove.getValue();
     case BIstrlcpy:
     case BI__builtin___strlcpy_chk:
      return Builtin.ID.BIstrlcpy.getValue();
     case BIstrlcat:
     case BI__builtin___strlcat_chk:
      return Builtin.ID.BIstrlcat.getValue();
     case BI__builtin_memcmp:
     case BImemcmp:
      return Builtin.ID.BImemcmp.getValue();
     case BI__builtin_strncpy:
     case BI__builtin___strncpy_chk:
     case BIstrncpy:
      return Builtin.ID.BIstrncpy.getValue();
     case BI__builtin_strncmp:
     case BIstrncmp:
      return Builtin.ID.BIstrncmp.getValue();
     case BI__builtin_strncasecmp:
     case BIstrncasecmp:
      return Builtin.ID.BIstrncasecmp.getValue();
     case BI__builtin_strncat:
     case BI__builtin___strncat_chk:
     case BIstrncat:
      return Builtin.ID.BIstrncat.getValue();
     case BI__builtin_strndup:
     case BIstrndup:
      return Builtin.ID.BIstrndup.getValue();
     case BI__builtin_strlen:
     case BIstrlen:
      return Builtin.ID.BIstrlen.getValue();
     default:
      if (isExternC()) {
        if (FnInfo.isStr(/*KEEP_STR*/"memset")) {
          return Builtin.ID.BImemset.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"memcpy")) {
          return Builtin.ID.BImemcpy.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"memmove")) {
          return Builtin.ID.BImemmove.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"memcmp")) {
          return Builtin.ID.BImemcmp.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"strncpy")) {
          return Builtin.ID.BIstrncpy.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"strncmp")) {
          return Builtin.ID.BIstrncmp.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"strncasecmp")) {
          return Builtin.ID.BIstrncasecmp.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"strncat")) {
          return Builtin.ID.BIstrncat.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"strndup")) {
          return Builtin.ID.BIstrndup.getValue();
        } else if (FnInfo.isStr(/*KEEP_STR*/"strlen")) {
          return Builtin.ID.BIstrlen.getValue();
        }
      }
      break;
    }
    return 0;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2275,
   FQN="clang::FunctionDecl::classof", NM="_ZN5clang12FunctionDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2276,
   FQN="clang::FunctionDecl::classofKind", NM="_ZN5clang12FunctionDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstFunction.getValue() && K.getValue() <= Kind.lastFunction.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2279,
   FQN="clang::FunctionDecl::castToDeclContext", NM="_ZN5clang12FunctionDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ FunctionDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/FunctionDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2282,
   FQN="clang::FunctionDecl::castFromDeclContext", NM="_ZN5clang12FunctionDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static FunctionDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/FunctionDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionDecl::~FunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1561,
   FQN="clang::FunctionDecl::~FunctionDecl", NM="_ZN5clang12FunctionDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12FunctionDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final FunctionDecl getPreviousDecl() { 
    return (FunctionDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final FunctionDecl getPreviousDecl$Const() { 
    return (FunctionDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public/*derived non-final*/ FunctionDecl getMostRecentDecl() { 
    return (FunctionDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public/*derived non-final*/ FunctionDecl getMostRecentDecl$Const() { 
    return (FunctionDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 

  private static final type$ptr<ParmVarDecl/*P*/> EMPTY_PARAMS = create_const_type$const_ptr((ParmVarDecl[])null);
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    std.string Buffer = new std.string("");
    raw_string_ostream OS = new raw_string_ostream(Buffer);
    ASTDumper Dumper = new ASTDumper(OS, getASTContext().getCommentCommandTraits(), getASTContext().getSourceManager());
    Dumper.dumpDeclRef(this);
    return OS.str().toJavaString();
//    return "" + "ParamInfo=" + ParamInfo // NOI18N
//              + ", DeclsInPrototypeScope=" + DeclsInPrototypeScope // NOI18N
//              + ", Body=" + Body // NOI18N
//              + ", SClass=" + StorageClass.valueOf($uchar2uint(SClass)) // NOI18N
//              + ", IsInline=" + IsInline // NOI18N
//              + ", IsInlineSpecified=" + IsInlineSpecified // NOI18N
//              + ", IsVirtualAsWritten=" + IsVirtualAsWritten // NOI18N
//              + ", IsPure=" + IsPure // NOI18N
//              + ", HasInheritedPrototype=" + HasInheritedPrototype // NOI18N
//              + ", HasWrittenPrototype=" + HasWrittenPrototype // NOI18N
//              + ", IsDeleted=" + IsDeleted // NOI18N
//              + ", IsTrivial=" + IsTrivial // NOI18N
//              + ", IsDefaulted=" + IsDefaulted // NOI18N
//              + ", IsExplicitlyDefaulted=" + IsExplicitlyDefaulted // NOI18N
//              + ", HasImplicitReturnZero=" + HasImplicitReturnZero // NOI18N
//              + ", IsLateTemplateParsed=" + IsLateTemplateParsed // NOI18N
//              + ", IsConstexpr=" + IsConstexpr // NOI18N
//              + ", UsesSEHTry=" + UsesSEHTry // NOI18N
//              + ", HasSkippedBody=" + HasSkippedBody // NOI18N
//              + ", EndRangeLoc=" + EndRangeLoc // NOI18N
//              + ", TemplateOrSpecialization=" + TemplateOrSpecialization // NOI18N
//              + ", DNLoc=" + DNLoc // NOI18N
//              + super.toString(); // NOI18N
  }
}

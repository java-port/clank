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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clank.java.std;
import org.llvm.support.TrailingObjects.*;


/// \brief A qualified reference to a name whose declaration cannot
/// yet be resolved.
///
/// DependentScopeDeclRefExpr is similar to DeclRefExpr in that
/// it expresses a reference to a declaration such as
/// X<T>::value. The difference, however, is that an
/// DependentScopeDeclRefExpr node is used only within C++ templates when
/// the qualification (e.g., X<T>::) refers to a dependent type. In
/// this case, X<T>::value cannot resolve to a declaration because the
/// declaration will differ from one instantiation of X<T> to the
/// next. Therefore, DependentScopeDeclRefExpr keeps track of the
/// qualifier (X<T>::) and the name of the entity being referenced
/// ("value"). Such expressions will instantiate to a DeclRefExpr once the
/// declaration can be found.
//<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2791,
 FQN="clang::DependentScopeDeclRefExpr", NM="_ZN5clang25DependentScopeDeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25DependentScopeDeclRefExprE")
//</editor-fold>
public final class DependentScopeDeclRefExpr extends /*public*/ Expr implements /*private*/ TrailingObjects2<DependentScopeDeclRefExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc> {
  /// \brief The nested-name-specifier that qualifies this unresolved
  /// declaration name.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief The name of the entity we will be referencing.
  /*friend*/public DeclarationNameInfo NameInfo;
  
  /// \brief Whether the name includes info for explicit template
  /// keyword and arguments.
  /*friend*/public boolean HasTemplateKWAndArgsInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2807,
   FQN="clang::DependentScopeDeclRefExpr::numTrailingObjects", NM="_ZNK5clang25DependentScopeDeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<ASTTemplateKWAndArgsInfo> $Prm0) /*const*/ {
    return HasTemplateKWAndArgsInfo ? 1 : 0;
  }

  
  
  // DependentScopeDeclRefExpr
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::DependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 342,
   FQN="clang::DependentScopeDeclRefExpr::DependentScopeDeclRefExpr", NM="_ZN5clang25DependentScopeDeclRefExprC1ENS_8QualTypeENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25DependentScopeDeclRefExprC1ENS_8QualTypeENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  private DependentScopeDeclRefExpr(QualType T, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateKWLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      /*const*/ TemplateArgumentListInfo /*P*/ Args) {
    // : Expr(DependentScopeDeclRefExprClass, T, VK_LValue, OK_Ordinary, true, true, (NameInfo.isInstantiationDependent() || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->isInstantiationDependent())), (NameInfo.containsUnexpandedParameterPack() || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->containsUnexpandedParameterPack()))), TrailingObjects<DependentScopeDeclRefExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), QualifierLoc(QualifierLoc), NameInfo(NameInfo), HasTemplateKWAndArgsInfo(Args != null || TemplateKWLoc.isValid()) 
    //START JInit
    super(StmtClass.DependentScopeDeclRefExprClass, new QualType(T), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        true, true, 
        (NameInfo.isInstantiationDependent()
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().isInstantiationDependent())), 
        (NameInfo.containsUnexpandedParameterPack()
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().
            containsUnexpandedParameterPack())));
    $TrailingObjects();
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.NameInfo = new DeclarationNameInfo(NameInfo);
    this.HasTemplateKWAndArgsInfo = Args != null || TemplateKWLoc.isValid();
    //END JInit
    if ((Args != null)) {
      bool$ref Dependent = create_bool$ref(true);
      bool$ref InstantiationDependent = create_bool$ref(true);
      bool$ref ContainsUnexpandedParameterPack = create_bool$ref(Unnamed_field.ExprBits.ContainsUnexpandedParameterPack);
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc), $Deref(Args), this.<TemplateArgumentLoc>getTrailingObjects(TemplateArgumentLoc.class), 
          Dependent, InstantiationDependent, ContainsUnexpandedParameterPack);
      Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = ContainsUnexpandedParameterPack.$deref();
    } else if (TemplateKWLoc.isValid()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 374,
   FQN="clang::DependentScopeDeclRefExpr::Create", NM="_ZN5clang25DependentScopeDeclRefExpr6CreateERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25DependentScopeDeclRefExpr6CreateERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static DependentScopeDeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        /*const*/ TemplateArgumentListInfo /*P*/ Args) {
    assert (QualifierLoc.$bool()) : "should be created for dependent qualifiers";
    boolean HasTemplateKWAndArgsInfo = (Args != null) || TemplateKWLoc.isValid();
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), (Args != null) ? Args.size() : 0);
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size,
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>((HasTemplateKWAndArgsInfo ? 1 : 0), ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>((Args != null) ? Args.size() : 0, ()->new TemplateArgumentLoc())
    );
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new DependentScopeDeclRefExpr(C.DependentTy.$QualType(), new NestedNameSpecifierLoc(QualifierLoc), 
                new SourceLocation(TemplateKWLoc), NameInfo, Args);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 390,
   FQN="clang::DependentScopeDeclRefExpr::CreateEmpty", NM="_ZN5clang25DependentScopeDeclRefExpr11CreateEmptyERKNS_10ASTContextEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25DependentScopeDeclRefExpr11CreateEmptyERKNS_10ASTContextEbj")
  //</editor-fold>
  public static DependentScopeDeclRefExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             boolean HasTemplateKWAndArgsInfo, 
             /*uint*/int NumTemplateArgs) {
    assert (NumTemplateArgs == 0 || HasTemplateKWAndArgsInfo);
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), NumTemplateArgs);
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size,
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>((HasTemplateKWAndArgsInfo ? 1 : 0), ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>(NumTemplateArgs, ()->new TemplateArgumentLoc())
    );
    DependentScopeDeclRefExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new DependentScopeDeclRefExpr(new QualType(), new NestedNameSpecifierLoc(), 
                new SourceLocation(), 
                new DeclarationNameInfo(), (/*const*/ TemplateArgumentListInfo /*P*/ )null);
     });
    E.HasTemplateKWAndArgsInfo = HasTemplateKWAndArgsInfo;
    return E;
  }

  
  /// \brief Retrieve the name that this expression refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2829,
   FQN="clang::DependentScopeDeclRefExpr::getNameInfo", NM="_ZNK5clang25DependentScopeDeclRefExpr11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr11getNameInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameInfo /*&*/ getNameInfo() /*const*/ {
    return NameInfo;
  }

  
  /// \brief Retrieve the name that this expression refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getDeclName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2832,
   FQN="clang::DependentScopeDeclRefExpr::getDeclName", NM="_ZNK5clang25DependentScopeDeclRefExpr11getDeclNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr11getDeclNameEv")
  //</editor-fold>
  public DeclarationName getDeclName() /*const*/ {
    return NameInfo.getName();
  }

  
  /// \brief Retrieve the location of the name within the expression.
  ///
  /// For example, in "X<T>::value" this is the location of "value".
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2837,
   FQN="clang::DependentScopeDeclRefExpr::getLocation", NM="_ZNK5clang25DependentScopeDeclRefExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return NameInfo.getLoc();
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the
  /// name, with source location information.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2841,
   FQN="clang::DependentScopeDeclRefExpr::getQualifierLoc", NM="_ZNK5clang25DependentScopeDeclRefExpr15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies this
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2845,
   FQN="clang::DependentScopeDeclRefExpr::getQualifier", NM="_ZNK5clang25DependentScopeDeclRefExpr12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  /// \brief Retrieve the location of the template keyword preceding
  /// this name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2851,
   FQN="clang::DependentScopeDeclRefExpr::getTemplateKeywordLoc", NM="_ZNK5clang25DependentScopeDeclRefExpr21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().TemplateKWLoc);
  }

  
  /// \brief Retrieve the location of the left angle bracket starting the
  /// explicit template argument list following the name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2858,
   FQN="clang::DependentScopeDeclRefExpr::getLAngleLoc", NM="_ZNK5clang25DependentScopeDeclRefExpr12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().LAngleLoc);
  }

  
  /// \brief Retrieve the location of the right angle bracket ending the
  /// explicit template argument list following the name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2865,
   FQN="clang::DependentScopeDeclRefExpr::getRAngleLoc", NM="_ZNK5clang25DependentScopeDeclRefExpr12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().RAngleLoc);
  }

  
  /// Determines whether the name was preceded by the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::hasTemplateKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2871,
   FQN="clang::DependentScopeDeclRefExpr::hasTemplateKeyword", NM="_ZNK5clang25DependentScopeDeclRefExpr18hasTemplateKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr18hasTemplateKeywordEv")
  //</editor-fold>
  public boolean hasTemplateKeyword() /*const*/ {
    return getTemplateKeywordLoc().isValid();
  }

  
  /// Determines whether this lookup had explicit template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::hasExplicitTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2874,
   FQN="clang::DependentScopeDeclRefExpr::hasExplicitTemplateArgs", NM="_ZNK5clang25DependentScopeDeclRefExpr23hasExplicitTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr23hasExplicitTemplateArgsEv")
  //</editor-fold>
  public boolean hasExplicitTemplateArgs() /*const*/ {
    return getLAngleLoc().isValid();
  }

  
  /// \brief Copies the template arguments (if present) into the given
  /// structure.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::copyTemplateArgumentsInto">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2878,
   FQN="clang::DependentScopeDeclRefExpr::copyTemplateArgumentsInto", NM="_ZNK5clang25DependentScopeDeclRefExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void copyTemplateArgumentsInto(final TemplateArgumentListInfo /*&*/ List) /*const*/ {
    if (hasExplicitTemplateArgs()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().copyInto(this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class), List);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2884,
   FQN="clang::DependentScopeDeclRefExpr::getTemplateArgs", NM="_ZNK5clang25DependentScopeDeclRefExpr15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return null;
    }
    
    return this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getNumTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2891,
   FQN="clang::DependentScopeDeclRefExpr::getNumTemplateArgs", NM="_ZNK5clang25DependentScopeDeclRefExpr18getNumTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr18getNumTemplateArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return 0;
    }
    
    return this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().NumTemplateArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2898,
   FQN="clang::DependentScopeDeclRefExpr::template_arguments", NM="_ZNK5clang25DependentScopeDeclRefExpr18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgumentLoc> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgumentLoc>(getTemplateArgs(), getNumTemplateArgs(), false)/* }*/;
  }

  
  /// Note: getLocStart() is the start of the whole DependentScopeDeclRefExpr,
  /// and differs from getLocation().getStart().
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2904,
   FQN="clang::DependentScopeDeclRefExpr::getLocStart", NM="_ZNK5clang25DependentScopeDeclRefExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return QualifierLoc.getBeginLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2907,
   FQN="clang::DependentScopeDeclRefExpr::getLocEnd", NM="_ZNK5clang25DependentScopeDeclRefExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25DependentScopeDeclRefExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (hasExplicitTemplateArgs()) {
      return getRAngleLoc();
    }
    return getLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2913,
   FQN="clang::DependentScopeDeclRefExpr::classof", NM="_ZN5clang25DependentScopeDeclRefExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25DependentScopeDeclRefExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.DependentScopeDeclRefExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentScopeDeclRefExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2917,
   FQN="clang::DependentScopeDeclRefExpr::children", NM="_ZN5clang25DependentScopeDeclRefExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25DependentScopeDeclRefExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  TrailingObjects<DependentScopeDeclRefExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
  }
  
  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ASTTemplateKWAndArgsInfo.class 
            || clazz == TemplateArgumentLoc.class;
    if (clazz == ASTTemplateKWAndArgsInfo.class) {
      return 0;
    }
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "QualifierLoc=" + QualifierLoc // NOI18N
              + ", NameInfo=" + NameInfo // NOI18N
              + ", HasTemplateKWAndArgsInfo=" + HasTemplateKWAndArgsInfo // NOI18N
              + super.toString(); // NOI18N
  }
}

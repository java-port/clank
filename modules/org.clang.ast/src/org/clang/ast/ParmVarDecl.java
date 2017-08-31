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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// ParmVarDecl - Represents a parameter to a function.
//<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1377,
 FQN="clang::ParmVarDecl", NM="_ZN5clang11ParmVarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDeclE")
//</editor-fold>
public class ParmVarDecl extends /*public*/ VarDecl implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1379,
   FQN="clang::ParmVarDecl::(anonymous)", NM="_ZN5clang11ParmVarDeclE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDeclE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int MaxFunctionScopeDepth = 255;
  /*}*/;
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1380,
   FQN="clang::ParmVarDecl::(anonymous)", NM="_ZN5clang11ParmVarDeclE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDeclE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int MaxFunctionScopeIndex = 255;
  /*}*/;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::ParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1383,
   FQN="clang::ParmVarDecl::ParmVarDecl", NM="_ZN5clang11ParmVarDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEPNS_4ExprE")
  //</editor-fold>
  protected ParmVarDecl(Kind DK, final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, QualType T, 
      TypeSourceInfo /*P*/ TInfo, StorageClass S, Expr /*P*/ DefArg) {
    // : VarDecl(DK, C, DC, StartLoc, IdLoc, Id, T, TInfo, S) 
    //START JInit
    super(DK, C, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, new QualType(T), TInfo, S);
    //END JInit
    assert (Unnamed_field1.ParmVarDeclBits.HasInheritedDefaultArg == false);
    assert (Unnamed_field1.ParmVarDeclBits.DefaultArgKind == $int2uint_2bits(DefaultArgKind.DAK_None.getValue()));
    assert (Unnamed_field1.ParmVarDeclBits.IsKNRPromoted == false);
    assert (Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam == false);
    setDefaultArg(DefArg);
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // ParmVarDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2328,
   FQN="clang::ParmVarDecl::Create", NM="_ZN5clang11ParmVarDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEPNS_4ExprE")
  //</editor-fold>
  public static ParmVarDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        StorageClass S, Expr /*P*/ DefArg) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ParmVarDecl(Kind.ParmVar, C, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, new QualType(T), TInfo, 
                S, DefArg);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2345,
   FQN="clang::ParmVarDecl::CreateDeserialized", NM="_ZN5clang11ParmVarDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ParmVarDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ParmVarDecl(Kind.ParmVar, C, (DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, new QualType(), (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, (Expr /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2351,
   FQN="clang::ParmVarDecl::getSourceRange", NM="_ZNK5clang11ParmVarDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (!hasInheritedDefaultArg()) {
      SourceRange ArgRange = getDefaultArgRange();
      if (ArgRange.isValid()) {
        return new SourceRange(getOuterLocStart(), ArgRange.getEnd());
      }
    }
    
    // DeclaratorDecl considers the range of postfix types as overlapping with the
    // declaration name, but this is not the case with parameters in ObjC methods.
    if (isa_ObjCMethodDecl(getDeclContext$Const())) {
      return new SourceRange(super.getLocStart(), getLocation());
    }
    
    return super.getSourceRange();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setObjCMethodScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1405,
   FQN="clang::ParmVarDecl::setObjCMethodScopeInfo", NM="_ZN5clang11ParmVarDecl22setObjCMethodScopeInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl22setObjCMethodScopeInfoEj")
  //</editor-fold>
  public void setObjCMethodScopeInfo(/*uint*/int parameterIndex) {
    Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam = true;
    setParameterIndex(parameterIndex);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1410,
   FQN="clang::ParmVarDecl::setScopeInfo", NM="_ZN5clang11ParmVarDecl12setScopeInfoEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl12setScopeInfoEjj")
  //</editor-fold>
  public void setScopeInfo(/*uint*/int scopeDepth, /*uint*/int parameterIndex) {
    assert (!Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam);
    
    Unnamed_field1.ParmVarDeclBits.ScopeDepthOrObjCQuals = $uint2uint_7bits(scopeDepth);
    assert (Unnamed_field1.ParmVarDeclBits.ScopeDepthOrObjCQuals == $uint2uint_7bits(scopeDepth)) : "truncation!";
    
    setParameterIndex(parameterIndex);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::isObjCMethodParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1420,
   FQN="clang::ParmVarDecl::isObjCMethodParameter", NM="_ZNK5clang11ParmVarDecl21isObjCMethodParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl21isObjCMethodParameterEv")
  //</editor-fold>
  public boolean isObjCMethodParameter() /*const*/ {
    return Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getFunctionScopeDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1424,
   FQN="clang::ParmVarDecl::getFunctionScopeDepth", NM="_ZNK5clang11ParmVarDecl21getFunctionScopeDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl21getFunctionScopeDepthEv")
  //</editor-fold>
  public /*uint*/int getFunctionScopeDepth() /*const*/ {
    if (Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam) {
      return 0;
    }
    return Unnamed_field1.ParmVarDeclBits.ScopeDepthOrObjCQuals;
  }

  
  /// Returns the index of this parameter in its prototype or method scope.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getFunctionScopeIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1430,
   FQN="clang::ParmVarDecl::getFunctionScopeIndex", NM="_ZNK5clang11ParmVarDecl21getFunctionScopeIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl21getFunctionScopeIndexEv")
  //</editor-fold>
  public /*uint*/int getFunctionScopeIndex() /*const*/ {
    return getParameterIndex();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1434,
   FQN="clang::ParmVarDecl::getObjCDeclQualifier", NM="_ZNK5clang11ParmVarDecl20getObjCDeclQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl20getObjCDeclQualifierEv")
  //</editor-fold>
  public /*ObjCDeclQualifier*//*uint*/int getObjCDeclQualifier() /*const*/ {
    if (!Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam) {
      return ObjCDeclQualifier.OBJC_TQ_None;
    }
    return ((/*ObjCDeclQualifier*//*uint*/int)(Unnamed_field1.ParmVarDeclBits.ScopeDepthOrObjCQuals));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1438,
   FQN="clang::ParmVarDecl::setObjCDeclQualifier", NM="_ZN5clang11ParmVarDecl20setObjCDeclQualifierENS_4Decl17ObjCDeclQualifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl20setObjCDeclQualifierENS_4Decl17ObjCDeclQualifierE")
  //</editor-fold>
  public void setObjCDeclQualifier(/*ObjCDeclQualifier*//*uint*/int QTVal) {
    assert Native.$bool(Unnamed_field1.ParmVarDeclBits.IsObjCMethodParam);
    Unnamed_field1.ParmVarDeclBits.ScopeDepthOrObjCQuals = $uint2uint_7bits(QTVal);
  }

  
  /// True if the value passed to this parameter must undergo
  /// K&R-style default argument promotion:
  ///
  /// C99 6.5.2.2.
  ///   If the expression that denotes the called function has a type
  ///   that does not include a prototype, the integer promotions are
  ///   performed on each argument, and arguments that have type float
  ///   are promoted to double.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::isKNRPromoted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1451,
   FQN="clang::ParmVarDecl::isKNRPromoted", NM="_ZNK5clang11ParmVarDecl13isKNRPromotedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl13isKNRPromotedEv")
  //</editor-fold>
  public boolean isKNRPromoted() /*const*/ {
    return Unnamed_field1.ParmVarDeclBits.IsKNRPromoted;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setKNRPromoted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1454,
   FQN="clang::ParmVarDecl::setKNRPromoted", NM="_ZN5clang11ParmVarDecl14setKNRPromotedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl14setKNRPromotedEb")
  //</editor-fold>
  public void setKNRPromoted(boolean promoted) {
    Unnamed_field1.ParmVarDeclBits.IsKNRPromoted = promoted;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2366,
   FQN="clang::ParmVarDecl::getDefaultArg", NM="_ZN5clang11ParmVarDecl13getDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl13getDefaultArgEv")
  //</editor-fold>
  public Expr /*P*/ getDefaultArg() {
    assert (!hasUnparsedDefaultArg()) : "Default argument is not yet parsed!";
    assert (!hasUninstantiatedDefaultArg()) : "Default argument is not yet instantiated!";
    
    Expr /*P*/ Arg = getInit();
    {
      ExprWithCleanups /*P*/ E = dyn_cast_or_null_ExprWithCleanups(Arg);
      if ((E != null)) {
        return E.getSubExpr();
      }
    }
    
    return Arg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1459,
   FQN="clang::ParmVarDecl::getDefaultArg", NM="_ZNK5clang11ParmVarDecl13getDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl13getDefaultArgEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getDefaultArg$Const() /*const*/ {
    return ((/*const_cast*/ParmVarDecl /*P*/ )(this)).getDefaultArg();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setDefaultArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2378,
   FQN="clang::ParmVarDecl::setDefaultArg", NM="_ZN5clang11ParmVarDecl13setDefaultArgEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl13setDefaultArgEPNS_4ExprE")
  //</editor-fold>
  public void setDefaultArg(Expr /*P*/ defarg) {
    Unnamed_field1.ParmVarDeclBits.DefaultArgKind = $uint2uint_2bits(DefaultArgKind.DAK_Normal.getValue());
    Init.$assign_T$C$R(Stmt /*P*/.class, defarg);
  }

  
  /// \brief Retrieve the source range that covers the entire default
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getDefaultArgRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2383,
   FQN="clang::ParmVarDecl::getDefaultArgRange", NM="_ZNK5clang11ParmVarDecl18getDefaultArgRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl18getDefaultArgRangeEv")
  //</editor-fold>
  public SourceRange getDefaultArgRange() /*const*/ {
    switch (DefaultArgKind.valueOf(Unnamed_field1.ParmVarDeclBits.DefaultArgKind)) {
     case DAK_None:
     case DAK_Unparsed:
      // Nothing we can do here.
      return new SourceRange();
     case DAK_Uninstantiated:
      return getUninstantiatedDefaultArg$Const().getSourceRange();
     case DAK_Normal:
      {
        /*const*/ Expr /*P*/ E = getInit$Const();
        if ((E != null)) {
          return E.getSourceRange();
        }
      }
      
      // Missing an actual expression, may be invalid.
      return new SourceRange();
    }
    throw new llvm_unreachable("Invalid default argument kind.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setUninstantiatedDefaultArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2403,
   FQN="clang::ParmVarDecl::setUninstantiatedDefaultArg", NM="_ZN5clang11ParmVarDecl27setUninstantiatedDefaultArgEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl27setUninstantiatedDefaultArgEPNS_4ExprE")
  //</editor-fold>
  public void setUninstantiatedDefaultArg(Expr /*P*/ arg) {
    Unnamed_field1.ParmVarDeclBits.DefaultArgKind = $uint2uint_2bits(DefaultArgKind.DAK_Uninstantiated.getValue());
    Init.$assign_T$C$R(Stmt /*P*/.class, arg);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getUninstantiatedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2408,
   FQN="clang::ParmVarDecl::getUninstantiatedDefaultArg", NM="_ZN5clang11ParmVarDecl27getUninstantiatedDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl27getUninstantiatedDefaultArgEv")
  //</editor-fold>
  public Expr /*P*/ getUninstantiatedDefaultArg() {
    assert (hasUninstantiatedDefaultArg()) : "Wrong kind of initialization expression!";
    return cast_or_null_Expr(Init.get(Stmt /*P*/.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getUninstantiatedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1470,
   FQN="clang::ParmVarDecl::getUninstantiatedDefaultArg", NM="_ZNK5clang11ParmVarDecl27getUninstantiatedDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl27getUninstantiatedDefaultArgEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getUninstantiatedDefaultArg$Const() /*const*/ {
    return ((/*const_cast*/ParmVarDecl /*P*/ )(this)).getUninstantiatedDefaultArg();
  }

  
  /// hasDefaultArg - Determines whether this parameter has a default argument,
  /// either parsed or not.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::hasDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2414,
   FQN="clang::ParmVarDecl::hasDefaultArg", NM="_ZNK5clang11ParmVarDecl13hasDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl13hasDefaultArgEv")
  //</editor-fold>
  public boolean hasDefaultArg() /*const*/ {
    // FIXME: We should just return false for DAK_None here once callers are
    // prepared for the case that we encountered an invalid default argument and
    // were unable to even build an invalid expression.
    return hasUnparsedDefaultArg() || hasUninstantiatedDefaultArg()
       || !Init.isNull();
  }

  
  /// hasUnparsedDefaultArg - Determines whether this parameter has a
  /// default argument that has not yet been parsed. This will occur
  /// during the processing of a C++ class whose member functions have
  /// default arguments, e.g.,
  /// @code
  ///   class X {
  ///   public:
  ///     void f(int x = 17); // x has an unparsed default argument now
  ///   }; // x has a regular default argument now
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::hasUnparsedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1488,
   FQN="clang::ParmVarDecl::hasUnparsedDefaultArg", NM="_ZNK5clang11ParmVarDecl21hasUnparsedDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl21hasUnparsedDefaultArgEv")
  //</editor-fold>
  public boolean hasUnparsedDefaultArg() /*const*/ {
    return Unnamed_field1.ParmVarDeclBits.DefaultArgKind == $int2uint_2bits(DefaultArgKind.DAK_Unparsed.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::hasUninstantiatedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1492,
   FQN="clang::ParmVarDecl::hasUninstantiatedDefaultArg", NM="_ZNK5clang11ParmVarDecl27hasUninstantiatedDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl27hasUninstantiatedDefaultArgEv")
  //</editor-fold>
  public boolean hasUninstantiatedDefaultArg() /*const*/ {
    return Unnamed_field1.ParmVarDeclBits.DefaultArgKind == $int2uint_2bits(DefaultArgKind.DAK_Uninstantiated.getValue());
  }

  
  /// setUnparsedDefaultArg - Specify that this parameter has an
  /// unparsed default argument. The argument will be replaced with a
  /// real default argument via setDefaultArg when the class
  /// definition enclosing the function declaration that owns this
  /// default argument is completed.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setUnparsedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1501,
   FQN="clang::ParmVarDecl::setUnparsedDefaultArg", NM="_ZN5clang11ParmVarDecl21setUnparsedDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl21setUnparsedDefaultArgEv")
  //</editor-fold>
  public void setUnparsedDefaultArg() {
    Unnamed_field1.ParmVarDeclBits.DefaultArgKind = $uint2uint_2bits(DefaultArgKind.DAK_Unparsed.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::hasInheritedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1505,
   FQN="clang::ParmVarDecl::hasInheritedDefaultArg", NM="_ZNK5clang11ParmVarDecl22hasInheritedDefaultArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl22hasInheritedDefaultArgEv")
  //</editor-fold>
  public boolean hasInheritedDefaultArg() /*const*/ {
    return Unnamed_field1.ParmVarDeclBits.HasInheritedDefaultArg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setHasInheritedDefaultArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1509,
   FQN="clang::ParmVarDecl::setHasInheritedDefaultArg", NM="_ZN5clang11ParmVarDecl25setHasInheritedDefaultArgEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl25setHasInheritedDefaultArgEb")
  //</editor-fold>
  public void setHasInheritedDefaultArg() {
    setHasInheritedDefaultArg(true);
  }
  public void setHasInheritedDefaultArg(boolean I/*= true*/) {
    Unnamed_field1.ParmVarDeclBits.HasInheritedDefaultArg = I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getOriginalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2337,
   FQN="clang::ParmVarDecl::getOriginalType", NM="_ZNK5clang11ParmVarDecl15getOriginalTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl15getOriginalTypeEv")
  //</editor-fold>
  public QualType getOriginalType() /*const*/ {
    TypeSourceInfo /*P*/ TSI = getTypeSourceInfo();
    QualType T = (TSI != null) ? TSI.getType() : getType();
    {
      /*const*/ DecayedType /*P*/ DT = dyn_cast_DecayedType(T);
      if ((DT != null)) {
        return DT.getOriginalType();
      }
    }
    return T;
  }

  
  /// \brief Determine whether this parameter is actually a function
  /// parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::isParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2422,
   FQN="clang::ParmVarDecl::isParameterPack", NM="_ZNK5clang11ParmVarDecl15isParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl15isParameterPackEv")
  //</editor-fold>
  public boolean isParameterPack() /*const*/ {
    return isa_PackExpansionType(getType());
  }

  
  /// setOwningFunction - Sets the function declaration that owns this
  /// ParmVarDecl. Since ParmVarDecls are often created before the
  /// FunctionDecls that own them, this routine is required to update
  /// the DeclContext appropriately.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setOwningFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1523,
   FQN="clang::ParmVarDecl::setOwningFunction", NM="_ZN5clang11ParmVarDecl17setOwningFunctionEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl17setOwningFunctionEPNS_11DeclContextE")
  //</editor-fold>
  public void setOwningFunction(DeclContext /*P*/ FD) {
    setDeclContext(FD);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1526,
   FQN="clang::ParmVarDecl::classof", NM="_ZN5clang11ParmVarDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1527,
   FQN="clang::ParmVarDecl::classofKind", NM="_ZN5clang11ParmVarDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ParmVar;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1530,
   FQN="clang::ParmVarDecl::(anonymous)", NM="_ZN5clang11ParmVarDeclE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDeclE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int ParameterIndexSentinel = (1 << NumParameterIndexBits) - 1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setParameterIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1532,
   FQN="clang::ParmVarDecl::setParameterIndex", NM="_ZN5clang11ParmVarDecl17setParameterIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl17setParameterIndexEj")
  //</editor-fold>
  private void setParameterIndex(/*uint*/int parameterIndex) {
    if ($greatereq_uint(parameterIndex, ParameterIndexSentinel)) {
      setParameterIndexLarge(parameterIndex);
      return;
    }
    
    Unnamed_field1.ParmVarDeclBits.ParameterIndex = $uint2uint_8bits(parameterIndex);
    assert (Unnamed_field1.ParmVarDeclBits.ParameterIndex == $uint2uint_8bits(parameterIndex)) : "truncation!";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getParameterIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1541,
   FQN="clang::ParmVarDecl::getParameterIndex", NM="_ZNK5clang11ParmVarDecl17getParameterIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl17getParameterIndexEv")
  //</editor-fold>
  private /*uint*/int getParameterIndex() /*const*/ {
    /*uint*/int d = Unnamed_field1.ParmVarDeclBits.ParameterIndex;
    return d == ParameterIndexSentinel ? getParameterIndexLarge() : d;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::setParameterIndexLarge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2426,
   FQN="clang::ParmVarDecl::setParameterIndexLarge", NM="_ZN5clang11ParmVarDecl22setParameterIndexLargeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDecl22setParameterIndexLargeEj")
  //</editor-fold>
  private void setParameterIndexLarge(/*uint*/int parameterIndex) {
    getASTContext().setParameterIndex(this, parameterIndex);
    Unnamed_field1.ParmVarDeclBits.ParameterIndex = $uint2uint_8bits(ParameterIndexSentinel);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::getParameterIndexLarge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2431,
   FQN="clang::ParmVarDecl::getParameterIndexLarge", NM="_ZNK5clang11ParmVarDecl22getParameterIndexLargeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang11ParmVarDecl22getParameterIndexLargeEv")
  //</editor-fold>
  private /*uint*/int getParameterIndexLarge() /*const*/ {
    return getASTContext().getParameterIndex(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParmVarDecl::~ParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1377,
   FQN="clang::ParmVarDecl::~ParmVarDecl", NM="_ZN5clang11ParmVarDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang11ParmVarDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}

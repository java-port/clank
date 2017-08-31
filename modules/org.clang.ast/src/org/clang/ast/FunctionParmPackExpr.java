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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief Represents a reference to a function parameter pack that has been
/// substituted but not yet expanded.
///
/// When a pack expansion contains multiple parameter packs at different levels,
/// this node is used to represent a function parameter pack at an outer level
/// which we have already substituted to refer to expanded parameters, but where
/// the containing pack expansion cannot yet be expanded.
///
/// \code
/// template<typename...Ts> struct S {
///   template<typename...Us> auto f(Ts ...ts) -> decltype(g(Us(ts)...));
/// };
/// template struct S<int, int>;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3884,
 FQN="clang::FunctionParmPackExpr", NM="_ZN5clang20FunctionParmPackExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20FunctionParmPackExprE")
//</editor-fold>
public final class FunctionParmPackExpr extends /*public*/ Expr implements /*private*/ TrailingObjects<FunctionParmPackExpr, ParmVarDecl /*P*/ > {
  /// \brief The function parameter pack which was referenced.
  /*friend*/public ParmVarDecl /*P*/ ParamPack;
  
  /// \brief The location of the function parameter pack reference.
  /*friend*/public SourceLocation NameLoc;
  
  /// \brief The number of expansions of this pack.
  /*friend*/public /*uint*/int NumParameters;
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::FunctionParmPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1342,
   FQN="clang::FunctionParmPackExpr::FunctionParmPackExpr", NM="_ZN5clang20FunctionParmPackExprC1ENS_8QualTypeEPNS_11ParmVarDeclENS_14SourceLocationEjPKS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20FunctionParmPackExprC1ENS_8QualTypeEPNS_11ParmVarDeclENS_14SourceLocationEjPKS3_")
  //</editor-fold>
  private FunctionParmPackExpr(QualType T, ParmVarDecl /*P*/ ParamPack, 
      SourceLocation NameLoc, 
      /*uint*/int NumParams, 
      type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> Params) {
    // : Expr(FunctionParmPackExprClass, T, VK_LValue, OK_Ordinary, true, true, true, true), TrailingObjects<FunctionParmPackExpr, ParmVarDecl * >(), ParamPack(ParamPack), NameLoc(NameLoc), NumParameters(NumParams) 
    //START JInit
    super(StmtClass.FunctionParmPackExprClass, new QualType(T), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, true, true, 
        true, true);
    $TrailingObjects();
    this.ParamPack = ParamPack;
    this.NameLoc = new SourceLocation(NameLoc);
    this.NumParameters = NumParams;
    //END JInit
    if (Native.$bool(Params)) {
      std.uninitialized_copy(Params, Params.$add(NumParams), 
          this.<ParmVarDecl /*P*/ >getTrailingObjects(ParmVarDecl.class));
    }
  }

  
  /*friend  TrailingObjects<FunctionParmPackExpr, ParmVarDecl *>*/
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1354,
   FQN="clang::FunctionParmPackExpr::Create", NM="_ZN5clang20FunctionParmPackExpr6CreateERKNS_10ASTContextENS_8QualTypeEPNS_11ParmVarDeclENS_14SourceLocationEN4llvm8ArrayRefIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20FunctionParmPackExpr6CreateERKNS_10ASTContextENS_8QualTypeEPNS_11ParmVarDeclENS_14SourceLocationEN4llvm8ArrayRefIS6_EE")
  //</editor-fold>
  public static FunctionParmPackExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, QualType T, 
        ParmVarDecl /*P*/ ParamPack, SourceLocation NameLoc, 
        ArrayRef<ParmVarDecl /*P*/ > Params) {
    return /*NEW_EXPR [Stmt::new]*//*new (Context.Allocate(totalSizeToAlloc<ParmVarDecl *>(Params.size())))*/ Stmt.$new(Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(ParmVarDecl.class, Params.size())), (type$ptr<?> Mem)->{
        return new FunctionParmPackExpr(new QualType(T), ParamPack, new SourceLocation(NameLoc), Params.size(), Params.data());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1362,
   FQN="clang::FunctionParmPackExpr::CreateEmpty", NM="_ZN5clang20FunctionParmPackExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20FunctionParmPackExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static FunctionParmPackExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ Context, 
             /*uint*/int NumParams) {
    return /*NEW_EXPR [Stmt::new]*//*new (Context.Allocate(totalSizeToAlloc<ParmVarDecl *>(NumParams)))*/ Stmt.$new(Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(ParmVarDecl.class, NumParams)), (type$ptr<?> Mem)->{
        return new FunctionParmPackExpr(new QualType(), (ParmVarDecl /*P*/ )null, new SourceLocation(), 0, (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/>)null);
     });
  }

  
  /// \brief Get the parameter pack which this expression refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::getParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3913,
   FQN="clang::FunctionParmPackExpr::getParameterPack", NM="_ZNK5clang20FunctionParmPackExpr16getParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr16getParameterPackEv")
  //</editor-fold>
  public ParmVarDecl /*P*/ getParameterPack() /*const*/ {
    return ParamPack;
  }

  
  /// \brief Get the location of the parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::getParameterPackLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3916,
   FQN="clang::FunctionParmPackExpr::getParameterPackLocation", NM="_ZNK5clang20FunctionParmPackExpr24getParameterPackLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr24getParameterPackLocationEv")
  //</editor-fold>
  public SourceLocation getParameterPackLocation() /*const*/ {
    return new SourceLocation(NameLoc);
  }

  
  /// \brief Iterators over the parameters which the parameter pack expanded
  /// into.
  /*typedef ParmVarDecl *const *iterator*/
//  public final class iterator extends type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3921,
   FQN="clang::FunctionParmPackExpr::begin", NM="_ZNK5clang20FunctionParmPackExpr5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr5beginEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> begin() /*const*/ {
    return this.<ParmVarDecl /*P*/ >getTrailingObjects$Const(ParmVarDecl.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3922,
   FQN="clang::FunctionParmPackExpr::end", NM="_ZNK5clang20FunctionParmPackExpr3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr3endEv")
  //</editor-fold>
  public type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> end() /*const*/ {
    return begin().$add(NumParameters);
  }

  
  /// \brief Get the number of parameters in this parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::getNumExpansions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3925,
   FQN="clang::FunctionParmPackExpr::getNumExpansions", NM="_ZNK5clang20FunctionParmPackExpr16getNumExpansionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr16getNumExpansionsEv")
  //</editor-fold>
  public /*uint*/int getNumExpansions() /*const*/ {
    return NumParameters;
  }

  
  /// \brief Get an expansion of the parameter pack by index.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::getExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3928,
   FQN="clang::FunctionParmPackExpr::getExpansion", NM="_ZNK5clang20FunctionParmPackExpr12getExpansionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr12getExpansionEj")
  //</editor-fold>
  public ParmVarDecl /*P*/ getExpansion(/*uint*/int I) /*const*/ {
    return begin().$at(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3930,
   FQN="clang::FunctionParmPackExpr::getLocStart", NM="_ZNK5clang20FunctionParmPackExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3931,
   FQN="clang::FunctionParmPackExpr::getLocEnd", NM="_ZNK5clang20FunctionParmPackExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20FunctionParmPackExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(NameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3933,
   FQN="clang::FunctionParmPackExpr::classof", NM="_ZN5clang20FunctionParmPackExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20FunctionParmPackExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.FunctionParmPackExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionParmPackExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3937,
   FQN="clang::FunctionParmPackExpr::children", NM="_ZN5clang20FunctionParmPackExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20FunctionParmPackExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ParmVarDecl.class;
    return 0;
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ParamPack=" + ParamPack // NOI18N
              + ", NameLoc=" + NameLoc // NOI18N
              + ", NumParameters=" + NumParameters // NOI18N
              + super.toString(); // NOI18N
  }
}

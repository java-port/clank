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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;
import org.llvm.support.TrailingObjects.*;


/// \brief A type trait used in the implementation of various C++11 and
/// Library TR1 trait templates.
///
/// \code
///   __is_pod(int) == true
///   __is_enum(std::string) == false
///   __is_trivially_constructible(vector<int>, int*, int*)
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2272,
 FQN="clang::TypeTraitExpr", NM="_ZN5clang13TypeTraitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExprE")
//</editor-fold>
public final class TypeTraitExpr extends /*public*/ Expr implements /*private*/ TrailingObjects<TypeTraitExpr, TypeSourceInfo /*P*/ > {
  /// \brief The location of the type trait keyword.
  /*friend*/public SourceLocation Loc;
  
  /// \brief  The location of the closing parenthesis.
  /*friend*/public SourceLocation RParenLoc;
  
  // Note: The TypeSourceInfos for the arguments are allocated after the
  // TypeTraitExpr.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::TypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1388,
   FQN="clang::TypeTraitExpr::TypeTraitExpr", NM="_ZN5clang13TypeTraitExprC1ENS_8QualTypeENS_14SourceLocationENS_9TypeTraitEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExprC1ENS_8QualTypeENS_14SourceLocationENS_9TypeTraitEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_b")
  //</editor-fold>
  private TypeTraitExpr(QualType T, SourceLocation Loc, TypeTrait Kind, 
      ArrayRef<TypeSourceInfo /*P*/ > Args, 
      SourceLocation RParenLoc, 
      boolean Value) {
    // : Expr(TypeTraitExprClass, T, VK_RValue, OK_Ordinary, /*TypeDependent=*/ false, /*ValueDependent=*/ false, /*InstantiationDependent=*/ false, /*ContainsUnexpandedParameterPack=*/ false), TrailingObjects<TypeTraitExpr, TypeSourceInfo * >(), Loc(Loc), RParenLoc(RParenLoc) 
    //START JInit
    super(StmtClass.TypeTraitExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, 
        false, 
        false, 
        false);
    $TrailingObjects();
    this.Loc = new SourceLocation(Loc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    //END JInit
    Unnamed_field.TypeTraitExprBits.Kind = $uint2uint_8bits(Kind.getValue());
    Unnamed_field.TypeTraitExprBits.Value = Value;
    Unnamed_field.TypeTraitExprBits.NumArgs = $uint2uint_7bits(Args.size());
    
    type$ptr<TypeSourceInfo /*P*/ /*P*/> ToArgs = $tryClone(this.<TypeSourceInfo /*P*/ >getTrailingObjects(TypeSourceInfo.class));
    
    for (/*uint*/int I = 0, N = Args.size(); I != N; ++I) {
      if (Args.$at(I).getType().$arrow().isDependentType()) {
        setValueDependent(true);
      }
      if (Args.$at(I).getType().$arrow().isInstantiationDependentType()) {
        setInstantiationDependent(true);
      }
      if (Args.$at(I).getType().$arrow().containsUnexpandedParameterPack()) {
        setContainsUnexpandedParameterPack(true);
      }
      
      ToArgs.$set(I, Args.$at(I));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::TypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2289,
   FQN="clang::TypeTraitExpr::TypeTraitExpr", NM="_ZN5clang13TypeTraitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private TypeTraitExpr(EmptyShell Empty) {
    // : Expr(TypeTraitExprClass, Empty), TrailingObjects<TypeTraitExpr, TypeSourceInfo * >(), Loc(), RParenLoc() 
    //START JInit
    super(StmtClass.TypeTraitExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.Loc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2291,
   FQN="clang::TypeTraitExpr::numTrailingObjects", NM="_ZNK5clang13TypeTraitExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_14TypeSourceInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_14TypeSourceInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<TypeSourceInfo /*P*/ > $Prm0) /*const*/ {
    return getNumArgs();
  }

/*public:*/
  /// \brief Create a new type trait expression.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1417,
   FQN="clang::TypeTraitExpr::Create", NM="_ZN5clang13TypeTraitExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationENS_9TypeTraitEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationENS_9TypeTraitEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES5_b")
  //</editor-fold>
  public static TypeTraitExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, 
        SourceLocation Loc, 
        TypeTrait Kind, 
        ArrayRef<TypeSourceInfo /*P*/ > Args, 
        SourceLocation RParenLoc, 
        boolean Value) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(TypeSourceInfo.class, Args.size()));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new TypeTraitExpr(new QualType(T), new SourceLocation(Loc), Kind, new ArrayRef<TypeSourceInfo /*P*/ >(Args), new SourceLocation(RParenLoc), Value);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1427,
   FQN="clang::TypeTraitExpr::CreateDeserialized", NM="_ZN5clang13TypeTraitExpr18CreateDeserializedERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExpr18CreateDeserializedERKNS_10ASTContextEj")
  //</editor-fold>
  public static TypeTraitExpr /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ C, 
                    /*uint*/int NumArgs) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(TypeSourceInfo.class, NumArgs));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new TypeTraitExpr(new EmptyShell());
     });
  }

  
  /// \brief Determine which type trait this expression uses.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2307,
   FQN="clang::TypeTraitExpr::getTrait", NM="_ZNK5clang13TypeTraitExpr8getTraitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr8getTraitEv")
  //</editor-fold>
  public TypeTrait getTrait() /*const*/ {
    return /*static_cast*/TypeTrait.valueOf($8bits_uint2uint(Unnamed_field.TypeTraitExprBits.Kind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2311,
   FQN="clang::TypeTraitExpr::getValue", NM="_ZNK5clang13TypeTraitExpr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr8getValueEv")
  //</editor-fold>
  public boolean getValue() /*const*/ {
    assert (!isValueDependent());
    return Unnamed_field.TypeTraitExprBits.Value;
  }

  
  /// \brief Determine the number of arguments to this type trait.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2317,
   FQN="clang::TypeTraitExpr::getNumArgs", NM="_ZNK5clang13TypeTraitExpr10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return Unnamed_field.TypeTraitExprBits.NumArgs;
  }

  
  /// \brief Retrieve the Ith argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2320,
   FQN="clang::TypeTraitExpr::getArg", NM="_ZNK5clang13TypeTraitExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr6getArgEj")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getArg(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumArgs())) : "Argument out-of-range";
    return getArgs().$at(I);
  }

  
  /// \brief Retrieve the argument types.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2326,
   FQN="clang::TypeTraitExpr::getArgs", NM="_ZNK5clang13TypeTraitExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr7getArgsEv")
  //</editor-fold>
  public ArrayRef<TypeSourceInfo /*P*/ > getArgs() /*const*/ {
    return llvm.makeArrayRef(this.<TypeSourceInfo /*P*/ >getTrailingObjects$Const(TypeSourceInfo.class), 
        getNumArgs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2331,
   FQN="clang::TypeTraitExpr::getLocStart", NM="_ZNK5clang13TypeTraitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2332,
   FQN="clang::TypeTraitExpr::getLocEnd", NM="_ZNK5clang13TypeTraitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13TypeTraitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2334,
   FQN="clang::TypeTraitExpr::classof", NM="_ZN5clang13TypeTraitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.TypeTraitExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTraitExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2339,
   FQN="clang::TypeTraitExpr::children", NM="_ZN5clang13TypeTraitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13TypeTraitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  TrailingObjects<TypeTraitExpr, TypeSourceInfo *>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == TypeSourceInfo.class;
    return 0;
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}

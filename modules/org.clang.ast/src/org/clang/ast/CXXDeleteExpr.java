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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a \c delete expression for memory deallocation and
/// destructor calls, e.g. "delete[] pArray".
//<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2008,
 FQN="clang::CXXDeleteExpr", NM="_ZN5clang13CXXDeleteExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXDeleteExprE")
//</editor-fold>
public class CXXDeleteExpr extends /*public*/ Expr {
  /// Points to the operator delete overload that is used. Could be a member.
  /*friend*/public FunctionDecl /*P*/ OperatorDelete;
  /// The pointer expression to be deleted.
  /*friend*/public Stmt /*P*/ Argument;
  /// Location of the expression.
  /*friend*/public SourceLocation Loc;
  /// Is this a forced global delete, i.e. "::delete"?
  /*friend*/public /*JBIT bool*/ boolean GlobalDelete /*: 1*/;
  /// Is this the array form of delete, i.e. "delete[]"?
  /*friend*/public /*JBIT bool*/ boolean ArrayForm /*: 1*/;
  /// ArrayFormAsWritten can be different from ArrayForm if 'delete' is applied
  /// to pointer-to-array type (ArrayFormAsWritten will be false while ArrayForm
  /// will be true).
  /*friend*/public /*JBIT bool*/ boolean ArrayFormAsWritten /*: 1*/;
  /// Does the usual deallocation function for the element type require
  /// a size_t argument?
  /*friend*/public /*JBIT bool*/ boolean UsualArrayDeleteWantsSize /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::CXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2027,
   FQN="clang::CXXDeleteExpr::CXXDeleteExpr", NM="_ZN5clang13CXXDeleteExprC1ENS_8QualTypeEbbbbPNS_12FunctionDeclEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXDeleteExprC1ENS_8QualTypeEbbbbPNS_12FunctionDeclEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public CXXDeleteExpr(QualType ty, boolean globalDelete, boolean arrayForm, 
      boolean arrayFormAsWritten, boolean usualArrayDeleteWantsSize, 
      FunctionDecl /*P*/ operatorDelete, Expr /*P*/ arg, SourceLocation loc) {
    // : Expr(CXXDeleteExprClass, ty, VK_RValue, OK_Ordinary, false, false, arg->isInstantiationDependent(), arg->containsUnexpandedParameterPack()), OperatorDelete(operatorDelete), Argument(arg), Loc(loc), GlobalDelete(globalDelete), ArrayForm(arrayForm), ArrayFormAsWritten(arrayFormAsWritten), UsualArrayDeleteWantsSize(usualArrayDeleteWantsSize) 
    //START JInit
    super(StmtClass.CXXDeleteExprClass, new QualType(ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        arg.isInstantiationDependent(), 
        arg.containsUnexpandedParameterPack());
    this.OperatorDelete = operatorDelete;
    this.Argument = arg;
    this.Loc = new SourceLocation(loc);
    this.GlobalDelete = globalDelete;
    this.ArrayForm = arrayForm;
    this.ArrayFormAsWritten = arrayFormAsWritten;
    this.UsualArrayDeleteWantsSize = usualArrayDeleteWantsSize;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::CXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2037,
   FQN="clang::CXXDeleteExpr::CXXDeleteExpr", NM="_ZN5clang13CXXDeleteExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXDeleteExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXDeleteExpr(EmptyShell Shell) {
    // : Expr(CXXDeleteExprClass, Shell), OperatorDelete(null), Argument(null), Loc() 
    //START JInit
    super(StmtClass.CXXDeleteExprClass, new EmptyShell(Shell));
    this.OperatorDelete = null;
    this.Argument = null;
    this.Loc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::isGlobalDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2041,
   FQN="clang::CXXDeleteExpr::isGlobalDelete", NM="_ZNK5clang13CXXDeleteExpr14isGlobalDeleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr14isGlobalDeleteEv")
  //</editor-fold>
  public boolean isGlobalDelete() /*const*/ {
    return GlobalDelete;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::isArrayForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2042,
   FQN="clang::CXXDeleteExpr::isArrayForm", NM="_ZNK5clang13CXXDeleteExpr11isArrayFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr11isArrayFormEv")
  //</editor-fold>
  public boolean isArrayForm() /*const*/ {
    return ArrayForm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::isArrayFormAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2043,
   FQN="clang::CXXDeleteExpr::isArrayFormAsWritten", NM="_ZNK5clang13CXXDeleteExpr20isArrayFormAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr20isArrayFormAsWrittenEv")
  //</editor-fold>
  public boolean isArrayFormAsWritten() /*const*/ {
    return ArrayFormAsWritten;
  }

  
  /// Answers whether the usual array deallocation function for the
  /// allocated type expects the size of the allocation as a
  /// parameter.  This can be true even if the actual deallocation
  /// function that we're using doesn't want a size.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::doesUsualArrayDeleteWantSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2049,
   FQN="clang::CXXDeleteExpr::doesUsualArrayDeleteWantSize", NM="_ZNK5clang13CXXDeleteExpr28doesUsualArrayDeleteWantSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr28doesUsualArrayDeleteWantSizeEv")
  //</editor-fold>
  public boolean doesUsualArrayDeleteWantSize() /*const*/ {
    return UsualArrayDeleteWantsSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::getOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2053,
   FQN="clang::CXXDeleteExpr::getOperatorDelete", NM="_ZNK5clang13CXXDeleteExpr17getOperatorDeleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr17getOperatorDeleteEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getOperatorDelete() /*const*/ {
    return OperatorDelete;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::getArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2055,
   FQN="clang::CXXDeleteExpr::getArgument", NM="_ZN5clang13CXXDeleteExpr11getArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXDeleteExpr11getArgumentEv")
  //</editor-fold>
  public Expr /*P*/ getArgument() {
    return cast_Expr(Argument);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::getArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2056,
   FQN="clang::CXXDeleteExpr::getArgument", NM="_ZNK5clang13CXXDeleteExpr11getArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr11getArgumentEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArgument$Const() /*const*/ {
    return cast_Expr(Argument);
  }

  
  /// \brief Retrieve the type being destroyed. 
  ///
  /// If the type being destroyed is a dependent type which may or may not
  /// be a pointer, return an invalid type.
  
  // CXXDeleteExpr
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::getDestroyedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 144,
   FQN="clang::CXXDeleteExpr::getDestroyedType", NM="_ZNK5clang13CXXDeleteExpr16getDestroyedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr16getDestroyedTypeEv")
  //</editor-fold>
  public QualType getDestroyedType() /*const*/ {
    /*const*/ Expr /*P*/ Arg = getArgument$Const();
    // The type-to-delete may not be a pointer if it's a dependent type.
    /*const*/ QualType ArgType = Arg.getType();
    if (ArgType.$arrow().isDependentType() && !ArgType.$arrow().isPointerType()) {
      return new QualType();
    }
    
    return ArgType.$arrow().getAs(PointerType.class).getPointeeType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2064,
   FQN="clang::CXXDeleteExpr::getLocStart", NM="_ZNK5clang13CXXDeleteExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2065,
   FQN="clang::CXXDeleteExpr::getLocEnd", NM="_ZNK5clang13CXXDeleteExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13CXXDeleteExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Argument.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2067,
   FQN="clang::CXXDeleteExpr::classof", NM="_ZN5clang13CXXDeleteExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXDeleteExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXDeleteExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDeleteExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2072,
   FQN="clang::CXXDeleteExpr::children", NM="_ZN5clang13CXXDeleteExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13CXXDeleteExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Argument))), new StmtIterator(create_type$ptr($AddrOf(Argument)).$add(1)));
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "OperatorDelete=" + OperatorDelete // NOI18N
              + ", Argument=" + Argument // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", GlobalDelete=" + GlobalDelete // NOI18N
              + ", ArrayForm=" + ArrayForm // NOI18N
              + ", ArrayFormAsWritten=" + ArrayFormAsWritten // NOI18N
              + ", UsualArrayDeleteWantsSize=" + UsualArrayDeleteWantsSize // NOI18N
              + super.toString(); // NOI18N
  }
}

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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// \brief Represents the body of a coroutine. This wraps the normal function
/// body and holds the additional semantic context required to set up and tear
/// down the coroutine frame.
//<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 299,
 FQN="clang::CoroutineBodyStmt", NM="_ZN5clang17CoroutineBodyStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang17CoroutineBodyStmtE")
//</editor-fold>
public class CoroutineBodyStmt extends /*public*/ Stmt {
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::SubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 300,
   FQN="clang::CoroutineBodyStmt::SubStmt", NM="_ZN5clang17CoroutineBodyStmt7SubStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang17CoroutineBodyStmt7SubStmtE")
  //</editor-fold>
  private enum SubStmt implements Native.ComparableLower {
    Body(0), ///< The body of the coroutine.
    Promise(Body.getValue() + 1), ///< The promise statement.
    InitSuspend(Promise.getValue() + 1), ///< The initial suspend statement, run before the body.
    FinalSuspend(InitSuspend.getValue() + 1), ///< The final suspend statement, run after the body.
    OnException(FinalSuspend.getValue() + 1), ///< Handler for exceptions thrown in the body.
    OnFallthrough(OnException.getValue() + 1), ///< Handler for control flow falling off the body.
    ReturnValue(OnFallthrough.getValue() + 1), ///< Return value for thunk function.
    FirstParamMove(ReturnValue.getValue() + 1); ///< First offset for move construction of parameter copies.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SubStmt valueOf(int val) {
      SubStmt out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SubStmt[] VALUES;
      private static final SubStmt[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SubStmt kind : SubStmt.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SubStmt[min < 0 ? (1-min) : 0];
        VALUES = new SubStmt[max >= 0 ? (1+max) : 0];
        for (SubStmt kind : SubStmt.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SubStmt(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SubStmt)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SubStmt)obj).value);}
    //</editor-fold>
  };
  private Stmt /*P*/ SubStmts[/*7*/] = new Stmt /*P*/  [7];
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::CoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 314,
   FQN="clang::CoroutineBodyStmt::CoroutineBodyStmt", NM="_ZN5clang17CoroutineBodyStmtC1EPNS_4StmtES2_S2_S2_S2_S2_PNS_4ExprEN4llvm8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang17CoroutineBodyStmtC1EPNS_4StmtES2_S2_S2_S2_S2_PNS_4ExprEN4llvm8ArrayRefIS4_EE")
  //</editor-fold>
  public CoroutineBodyStmt(Stmt /*P*/ Body, Stmt /*P*/ Promise, Stmt /*P*/ InitSuspend, 
      Stmt /*P*/ FinalSuspend, Stmt /*P*/ OnException, Stmt /*P*/ OnFallthrough, 
      Expr /*P*/ ReturnValue, ArrayRef<Expr /*P*/ > ParamMoves) {
    // : Stmt(CoroutineBodyStmtClass) 
    //START JInit
    super(StmtClass.CoroutineBodyStmtClass);
    //END JInit
    SubStmts[CoroutineBodyStmt.SubStmt.Body.getValue()] = Body;
    SubStmts[CoroutineBodyStmt.SubStmt.Promise.getValue()] = Promise;
    SubStmts[CoroutineBodyStmt.SubStmt.InitSuspend.getValue()] = InitSuspend;
    SubStmts[CoroutineBodyStmt.SubStmt.FinalSuspend.getValue()] = FinalSuspend;
    SubStmts[CoroutineBodyStmt.SubStmt.OnException.getValue()] = OnException;
    SubStmts[CoroutineBodyStmt.SubStmt.OnFallthrough.getValue()] = OnFallthrough;
    SubStmts[CoroutineBodyStmt.SubStmt.ReturnValue.getValue()] = ReturnValue;
    // FIXME: Tail-allocate space for parameter move expressions and store them.
    assert (ParamMoves.empty()) : "not implemented yet";
  }

  
  /// \brief Retrieve the body of the coroutine as written. This will be either
  /// a CompoundStmt or a TryStmt.
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 331,
   FQN="clang::CoroutineBodyStmt::getBody", NM="_ZNK5clang17CoroutineBodyStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() /*const*/ {
    return SubStmts[SubStmt.Body.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getPromiseDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 335,
   FQN="clang::CoroutineBodyStmt::getPromiseDeclStmt", NM="_ZNK5clang17CoroutineBodyStmt18getPromiseDeclStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt18getPromiseDeclStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getPromiseDeclStmt() /*const*/ {
    return SubStmts[SubStmt.Promise.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getPromiseDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 336,
   FQN="clang::CoroutineBodyStmt::getPromiseDecl", NM="_ZNK5clang17CoroutineBodyStmt14getPromiseDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt14getPromiseDeclEv")
  //</editor-fold>
  public VarDecl /*P*/ getPromiseDecl() /*const*/ {
    return cast_VarDecl(cast_DeclStmt(getPromiseDeclStmt()).getSingleDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getInitSuspendStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 340,
   FQN="clang::CoroutineBodyStmt::getInitSuspendStmt", NM="_ZNK5clang17CoroutineBodyStmt18getInitSuspendStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt18getInitSuspendStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getInitSuspendStmt() /*const*/ {
    return SubStmts[SubStmt.InitSuspend.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getFinalSuspendStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 341,
   FQN="clang::CoroutineBodyStmt::getFinalSuspendStmt", NM="_ZNK5clang17CoroutineBodyStmt19getFinalSuspendStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt19getFinalSuspendStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getFinalSuspendStmt() /*const*/ {
    return SubStmts[SubStmt.FinalSuspend.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getExceptionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 343,
   FQN="clang::CoroutineBodyStmt::getExceptionHandler", NM="_ZNK5clang17CoroutineBodyStmt19getExceptionHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt19getExceptionHandlerEv")
  //</editor-fold>
  public Stmt /*P*/ getExceptionHandler() /*const*/ {
    return SubStmts[SubStmt.OnException.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getFallthroughHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 344,
   FQN="clang::CoroutineBodyStmt::getFallthroughHandler", NM="_ZNK5clang17CoroutineBodyStmt21getFallthroughHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt21getFallthroughHandlerEv")
  //</editor-fold>
  public Stmt /*P*/ getFallthroughHandler() /*const*/ {
    return SubStmts[SubStmt.OnFallthrough.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getReturnValueInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 348,
   FQN="clang::CoroutineBodyStmt::getReturnValueInit", NM="_ZNK5clang17CoroutineBodyStmt18getReturnValueInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt18getReturnValueInitEv")
  //</editor-fold>
  public Expr /*P*/ getReturnValueInit() /*const*/ {
    return cast_Expr(SubStmts[SubStmt.ReturnValue.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 352,
   FQN="clang::CoroutineBodyStmt::getLocStart", NM="_ZNK5clang17CoroutineBodyStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBody().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 355,
   FQN="clang::CoroutineBodyStmt::getLocEnd", NM="_ZNK5clang17CoroutineBodyStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang17CoroutineBodyStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getBody().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 359,
   FQN="clang::CoroutineBodyStmt::children", NM="_ZN5clang17CoroutineBodyStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang17CoroutineBodyStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(SubStmts), new StmtIterator(SubStmts,SubStmt.FirstParamMove.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoroutineBodyStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 363,
   FQN="clang::CoroutineBodyStmt::classof", NM="_ZN5clang17CoroutineBodyStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang17CoroutineBodyStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CoroutineBodyStmtClass;
  }

  
  @Override public String toString() {
    return "" + "SubStmts=" + SubStmts // NOI18N
              + super.toString(); // NOI18N
  }
}

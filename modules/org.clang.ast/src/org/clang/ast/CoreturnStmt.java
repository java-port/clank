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
import org.clang.basic.*;


/// \brief Represents a 'co_return' statement in the C++ Coroutines TS.
///
/// This statament models the initialization of the coroutine promise
/// (encapsulating the eventual notional return value) from an expression
/// (or braced-init-list), followed by termination of the coroutine.
///
/// This initialization is modeled by the evaluation of the operand
/// followed by a call to one of:
///   <promise>.return_value(<operand>)
///   <promise>.return_void()
/// which we name the "promise call".
//<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 379,
 FQN="clang::CoreturnStmt", NM="_ZN5clang12CoreturnStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CoreturnStmtE")
//</editor-fold>
public class CoreturnStmt extends /*public*/ Stmt {
  private SourceLocation CoreturnLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::SubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 382,
   FQN="clang::CoreturnStmt::SubStmt", NM="_ZN5clang12CoreturnStmt7SubStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CoreturnStmt7SubStmtE")
  //</editor-fold>
  private enum SubStmt implements Native.ComparableLower {
    Operand(0),
    PromiseCall(Operand.getValue() + 1),
    Count(PromiseCall.getValue() + 1);

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
  private Stmt /*P*/ SubStmts[/*2*/] = new Stmt /*P*/  [2];
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::CoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 387,
   FQN="clang::CoreturnStmt::CoreturnStmt", NM="_ZN5clang12CoreturnStmtC1ENS_14SourceLocationEPNS_4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CoreturnStmtC1ENS_14SourceLocationEPNS_4StmtES3_")
  //</editor-fold>
  public CoreturnStmt(SourceLocation CoreturnLoc, Stmt /*P*/ Operand, Stmt /*P*/ PromiseCall) {
    // : Stmt(CoreturnStmtClass), CoreturnLoc(CoreturnLoc) 
    //START JInit
    super(StmtClass.CoreturnStmtClass);
    this.CoreturnLoc = new SourceLocation(CoreturnLoc);
    //END JInit
    SubStmts[SubStmt.Operand.getValue()] = Operand;
    SubStmts[SubStmt.PromiseCall.getValue()] = PromiseCall;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::getKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 393,
   FQN="clang::CoreturnStmt::getKeywordLoc", NM="_ZNK5clang12CoreturnStmt13getKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CoreturnStmt13getKeywordLocEv")
  //</editor-fold>
  public SourceLocation getKeywordLoc() /*const*/ {
    return new SourceLocation(CoreturnLoc);
  }

  
  /// \brief Retrieve the operand of the 'co_return' statement. Will be nullptr
  /// if none was specified.
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 397,
   FQN="clang::CoreturnStmt::getOperand", NM="_ZNK5clang12CoreturnStmt10getOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CoreturnStmt10getOperandEv")
  //</editor-fold>
  public Expr /*P*/ getOperand() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(SubStmts[SubStmt.Operand.getValue()]));
  }

  
  /// \brief Retrieve the promise call that results from this 'co_return'
  /// statement. Will be nullptr if either the coroutine has not yet been
  /// finalized or the coroutine has no eventual return type.
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::getPromiseCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 402,
   FQN="clang::CoreturnStmt::getPromiseCall", NM="_ZNK5clang12CoreturnStmt14getPromiseCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CoreturnStmt14getPromiseCallEv")
  //</editor-fold>
  public Expr /*P*/ getPromiseCall() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(SubStmts[SubStmt.PromiseCall.getValue()]));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 406,
   FQN="clang::CoreturnStmt::getLocStart", NM="_ZNK5clang12CoreturnStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CoreturnStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(CoreturnLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 407,
   FQN="clang::CoreturnStmt::getLocEnd", NM="_ZNK5clang12CoreturnStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CoreturnStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getOperand().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 411,
   FQN="clang::CoreturnStmt::children", NM="_ZN5clang12CoreturnStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CoreturnStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(SubStmts), new StmtIterator(SubStmts,SubStmt.Count.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoreturnStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 415,
   FQN="clang::CoreturnStmt::classof", NM="_ZN5clang12CoreturnStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CoreturnStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CoreturnStmtClass;
  }

  
  @Override public String toString() {
    return "" + "CoreturnLoc=" + CoreturnLoc // NOI18N
              + ", SubStmts=" + SubStmts // NOI18N
              + super.toString(); // NOI18N
  }
}

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
import static org.clank.support.Casts.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1844,
 FQN="clang::SEHExceptStmt", NM="_ZN5clang13SEHExceptStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmtE")
//</editor-fold>
public class SEHExceptStmt extends /*public*/ Stmt {
  /*friend*/public SourceLocation Loc;
  /*friend*/public Stmt /*P*/ Children[/*2*/] = new Stmt /*P*/  [2];
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1848,
   FQN="clang::SEHExceptStmt::(anonymous)", NM="_ZN5clang13SEHExceptStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmtE_Unnamed_enum")
  //</editor-fold>
  /*friend*/public enum Unnamed_enum implements Native.ComparableLower {
    FILTER_EXPR(0),
    BLOCK(FILTER_EXPR.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::SEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 932,
   FQN="clang::SEHExceptStmt::SEHExceptStmt", NM="_ZN5clang13SEHExceptStmtC1ENS_14SourceLocationEPNS_4ExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmtC1ENS_14SourceLocationEPNS_4ExprEPNS_4StmtE")
  //</editor-fold>
  private SEHExceptStmt(SourceLocation Loc, 
      Expr /*P*/ FilterExpr, 
      Stmt /*P*/ Block) {
    // : Stmt(SEHExceptStmtClass), Loc(Loc) 
    //START JInit
    super(StmtClass.SEHExceptStmtClass);
    this.Loc = new SourceLocation(Loc);
    //END JInit
    Children[Unnamed_enum.FILTER_EXPR.getValue()] = FilterExpr;
    Children[Unnamed_enum.BLOCK.getValue()] = Block;
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::SEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1856,
   FQN="clang::SEHExceptStmt::SEHExceptStmt", NM="_ZN5clang13SEHExceptStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ SEHExceptStmt(EmptyShell E) {
    // : Stmt(SEHExceptStmtClass, E), Loc() 
    //START JInit
    super(StmtClass.SEHExceptStmtClass, new EmptyShell(E));
    this.Loc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 942,
   FQN="clang::SEHExceptStmt::Create", NM="_ZN5clang13SEHExceptStmt6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmt6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprEPNS_4StmtE")
  //</editor-fold>
  public static SEHExceptStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation Loc, 
        Expr /*P*/ FilterExpr, Stmt /*P*/ Block) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new SEHExceptStmt(new SourceLocation(Loc), FilterExpr, Block);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1864,
   FQN="clang::SEHExceptStmt::getLocStart", NM="_ZNK5clang13SEHExceptStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang13SEHExceptStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getExceptLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1865,
   FQN="clang::SEHExceptStmt::getLocEnd", NM="_ZNK5clang13SEHExceptStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang13SEHExceptStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getEndLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::getExceptLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1867,
   FQN="clang::SEHExceptStmt::getExceptLoc", NM="_ZNK5clang13SEHExceptStmt12getExceptLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang13SEHExceptStmt12getExceptLocEv")
  //</editor-fold>
  public SourceLocation getExceptLoc() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1868,
   FQN="clang::SEHExceptStmt::getEndLoc", NM="_ZNK5clang13SEHExceptStmt9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang13SEHExceptStmt9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return getBlock().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::getFilterExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1870,
   FQN="clang::SEHExceptStmt::getFilterExpr", NM="_ZNK5clang13SEHExceptStmt13getFilterExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang13SEHExceptStmt13getFilterExprEv")
  //</editor-fold>
  public Expr /*P*/ getFilterExpr() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, Children[Unnamed_enum.FILTER_EXPR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::getBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1874,
   FQN="clang::SEHExceptStmt::getBlock", NM="_ZNK5clang13SEHExceptStmt8getBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang13SEHExceptStmt8getBlockEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getBlock() /*const*/ {
    return cast_CompoundStmt(Children[Unnamed_enum.BLOCK.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1878,
   FQN="clang::SEHExceptStmt::children", NM="_ZN5clang13SEHExceptStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Children), new StmtIterator(Children,(2)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHExceptStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1882,
   FQN="clang::SEHExceptStmt::classof", NM="_ZN5clang13SEHExceptStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang13SEHExceptStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.SEHExceptStmtClass;
  }

  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", Children=" + Children // NOI18N
              + super.toString(); // NOI18N
  }
}

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
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1922,
 FQN="clang::SEHTryStmt", NM="_ZN5clang10SEHTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmtE")
//</editor-fold>
public class SEHTryStmt extends /*public*/ Stmt {
  /*friend*/public boolean IsCXXTry;
  /*friend*/public SourceLocation TryLoc;
  /*friend*/public Stmt /*P*/ Children[/*2*/] = new Stmt /*P*/  [2];
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1927,
   FQN="clang::SEHTryStmt::(anonymous)", NM="_ZN5clang10SEHTryStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmtE_Unnamed_enum")
  //</editor-fold>
  /*friend*/public enum Unnamed_enum implements Native.ComparableLower {
    TRY(0),
    HANDLER(1);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::SEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 906,
   FQN="clang::SEHTryStmt::SEHTryStmt", NM="_ZN5clang10SEHTryStmtC1EbNS_14SourceLocationEPNS_4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmtC1EbNS_14SourceLocationEPNS_4StmtES3_")
  //</editor-fold>
  private SEHTryStmt(boolean IsCXXTry, 
      SourceLocation TryLoc, 
      Stmt /*P*/ TryBlock, 
      Stmt /*P*/ Handler) {
    // : Stmt(SEHTryStmtClass), IsCXXTry(IsCXXTry), TryLoc(TryLoc) 
    //START JInit
    super(StmtClass.SEHTryStmtClass);
    this.IsCXXTry = IsCXXTry;
    this.TryLoc = new SourceLocation(TryLoc);
    //END JInit
    Children[Unnamed_enum.TRY.getValue()] = TryBlock;
    Children[Unnamed_enum.HANDLER.getValue()] = Handler;
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::SEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1936,
   FQN="clang::SEHTryStmt::SEHTryStmt", NM="_ZN5clang10SEHTryStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ SEHTryStmt(EmptyShell E) {
    // : Stmt(SEHTryStmtClass, E), TryLoc() 
    //START JInit
    super(StmtClass.SEHTryStmtClass, new EmptyShell(E));
    this.TryLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 918,
   FQN="clang::SEHTryStmt::Create", NM="_ZN5clang10SEHTryStmt6CreateERKNS_10ASTContextEbNS_14SourceLocationEPNS_4StmtES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmt6CreateERKNS_10ASTContextEbNS_14SourceLocationEPNS_4StmtES6_")
  //</editor-fold>
  public static SEHTryStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ C, boolean IsCXXTry, 
        SourceLocation TryLoc, Stmt /*P*/ TryBlock, 
        Stmt /*P*/ Handler) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new SEHTryStmt(IsCXXTry, new SourceLocation(TryLoc), TryBlock, Handler);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1943,
   FQN="clang::SEHTryStmt::getLocStart", NM="_ZNK5clang10SEHTryStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getTryLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1944,
   FQN="clang::SEHTryStmt::getLocEnd", NM="_ZNK5clang10SEHTryStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getEndLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getTryLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1946,
   FQN="clang::SEHTryStmt::getTryLoc", NM="_ZNK5clang10SEHTryStmt9getTryLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt9getTryLocEv")
  //</editor-fold>
  public SourceLocation getTryLoc() /*const*/ {
    return new SourceLocation(TryLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1947,
   FQN="clang::SEHTryStmt::getEndLoc", NM="_ZNK5clang10SEHTryStmt9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return Children[Unnamed_enum.HANDLER.getValue()].getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getIsCXXTry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1949,
   FQN="clang::SEHTryStmt::getIsCXXTry", NM="_ZNK5clang10SEHTryStmt11getIsCXXTryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt11getIsCXXTryEv")
  //</editor-fold>
  public boolean getIsCXXTry() /*const*/ {
    return IsCXXTry;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getTryBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1951,
   FQN="clang::SEHTryStmt::getTryBlock", NM="_ZNK5clang10SEHTryStmt11getTryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt11getTryBlockEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getTryBlock() /*const*/ {
    return cast_CompoundStmt(Children[Unnamed_enum.TRY.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1955,
   FQN="clang::SEHTryStmt::getHandler", NM="_ZNK5clang10SEHTryStmt10getHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt10getHandlerEv")
  //</editor-fold>
  public Stmt /*P*/ getHandler() /*const*/ {
    return Children[Unnamed_enum.HANDLER.getValue()];
  }

  
  /// Returns 0 if not defined
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getExceptHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 924,
   FQN="clang::SEHTryStmt::getExceptHandler", NM="_ZNK5clang10SEHTryStmt16getExceptHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt16getExceptHandlerEv")
  //</editor-fold>
  public SEHExceptStmt /*P*/ getExceptHandler() /*const*/ {
    return dyn_cast_SEHExceptStmt(getHandler());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::getFinallyHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 928,
   FQN="clang::SEHTryStmt::getFinallyHandler", NM="_ZNK5clang10SEHTryStmt17getFinallyHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SEHTryStmt17getFinallyHandlerEv")
  //</editor-fold>
  public SEHFinallyStmt /*P*/ getFinallyHandler() /*const*/ {
    return dyn_cast_SEHFinallyStmt(getHandler());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1961,
   FQN="clang::SEHTryStmt::children", NM="_ZN5clang10SEHTryStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Children), new StmtIterator(Children,(2)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SEHTryStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1965,
   FQN="clang::SEHTryStmt::classof", NM="_ZN5clang10SEHTryStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SEHTryStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.SEHTryStmtClass;
  }

  
  @Override public String toString() {
    return "" + "IsCXXTry=" + IsCXXTry // NOI18N
              + ", TryLoc=" + TryLoc // NOI18N
              + ", Children=" + Children // NOI18N
              + super.toString(); // NOI18N
  }
}

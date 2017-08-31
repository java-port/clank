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
import static org.clank.support.Casts.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents Objective-C's \@synchronized statement.
///
/// Example:
/// \code
///   @synchronized (sem) {
///     do-something;
///   }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 262,
 FQN="clang::ObjCAtSynchronizedStmt", NM="_ZN5clang22ObjCAtSynchronizedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmtE")
//</editor-fold>
public class ObjCAtSynchronizedStmt extends /*public*/ Stmt {
/*private:*/
  private SourceLocation AtSynchronizedLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 265,
   FQN="clang::ObjCAtSynchronizedStmt::(anonymous)", NM="_ZN5clang22ObjCAtSynchronizedStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    SYNC_EXPR(0),
    SYNC_BODY(SYNC_EXPR.getValue() + 1),
    END_EXPR(SYNC_BODY.getValue() + 1);

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
  private Stmt /*P*/ SubStmts[/*2*/] = new Stmt /*P*/  [2];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::ObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 269,
   FQN="clang::ObjCAtSynchronizedStmt::ObjCAtSynchronizedStmt", NM="_ZN5clang22ObjCAtSynchronizedStmtC1ENS_14SourceLocationEPNS_4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmtC1ENS_14SourceLocationEPNS_4StmtES3_")
  //</editor-fold>
  public ObjCAtSynchronizedStmt(SourceLocation atSynchronizedLoc, Stmt /*P*/ synchExpr, 
      Stmt /*P*/ synchBody) {
    // : Stmt(ObjCAtSynchronizedStmtClass), AtSynchronizedLoc() 
    //START JInit
    super(StmtClass.ObjCAtSynchronizedStmtClass);
    this.AtSynchronizedLoc = new SourceLocation();
    //END JInit
    SubStmts[Unnamed_enum.SYNC_EXPR.getValue()] = synchExpr;
    SubStmts[Unnamed_enum.SYNC_BODY.getValue()] = synchBody;
    AtSynchronizedLoc.$assign(atSynchronizedLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::ObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 276,
   FQN="clang::ObjCAtSynchronizedStmt::ObjCAtSynchronizedStmt", NM="_ZN5clang22ObjCAtSynchronizedStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCAtSynchronizedStmt(EmptyShell Empty) {
    // : Stmt(ObjCAtSynchronizedStmtClass, Empty), AtSynchronizedLoc() 
    //START JInit
    super(StmtClass.ObjCAtSynchronizedStmtClass, new EmptyShell(Empty));
    this.AtSynchronizedLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getAtSynchronizedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 279,
   FQN="clang::ObjCAtSynchronizedStmt::getAtSynchronizedLoc", NM="_ZNK5clang22ObjCAtSynchronizedStmt20getAtSynchronizedLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang22ObjCAtSynchronizedStmt20getAtSynchronizedLocEv")
  //</editor-fold>
  public SourceLocation getAtSynchronizedLoc() /*const*/ {
    return new SourceLocation(AtSynchronizedLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::setAtSynchronizedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 280,
   FQN="clang::ObjCAtSynchronizedStmt::setAtSynchronizedLoc", NM="_ZN5clang22ObjCAtSynchronizedStmt20setAtSynchronizedLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt20setAtSynchronizedLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtSynchronizedLoc(SourceLocation Loc) {
    AtSynchronizedLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getSynchBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 282,
   FQN="clang::ObjCAtSynchronizedStmt::getSynchBody", NM="_ZNK5clang22ObjCAtSynchronizedStmt12getSynchBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang22ObjCAtSynchronizedStmt12getSynchBodyEv")
  //</editor-fold>
  public /*const*/ CompoundStmt /*P*/ getSynchBody$Const() /*const*/ {
    return reinterpret_cast(CompoundStmt /*P*/ .class, SubStmts[Unnamed_enum.SYNC_BODY.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getSynchBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 285,
   FQN="clang::ObjCAtSynchronizedStmt::getSynchBody", NM="_ZN5clang22ObjCAtSynchronizedStmt12getSynchBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt12getSynchBodyEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getSynchBody() {
    return reinterpret_cast(CompoundStmt /*P*/ .class, SubStmts[Unnamed_enum.SYNC_BODY.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::setSynchBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 288,
   FQN="clang::ObjCAtSynchronizedStmt::setSynchBody", NM="_ZN5clang22ObjCAtSynchronizedStmt12setSynchBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt12setSynchBodyEPNS_4StmtE")
  //</editor-fold>
  public void setSynchBody(Stmt /*P*/ S) {
    SubStmts[Unnamed_enum.SYNC_BODY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getSynchExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 290,
   FQN="clang::ObjCAtSynchronizedStmt::getSynchExpr", NM="_ZNK5clang22ObjCAtSynchronizedStmt12getSynchExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang22ObjCAtSynchronizedStmt12getSynchExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSynchExpr$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubStmts[Unnamed_enum.SYNC_EXPR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getSynchExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 293,
   FQN="clang::ObjCAtSynchronizedStmt::getSynchExpr", NM="_ZN5clang22ObjCAtSynchronizedStmt12getSynchExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt12getSynchExprEv")
  //</editor-fold>
  public Expr /*P*/ getSynchExpr() {
    return reinterpret_cast(Expr /*P*/ .class, SubStmts[Unnamed_enum.SYNC_EXPR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::setSynchExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 296,
   FQN="clang::ObjCAtSynchronizedStmt::setSynchExpr", NM="_ZN5clang22ObjCAtSynchronizedStmt12setSynchExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt12setSynchExprEPNS_4StmtE")
  //</editor-fold>
  public void setSynchExpr(Stmt /*P*/ S) {
    SubStmts[Unnamed_enum.SYNC_EXPR.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 298,
   FQN="clang::ObjCAtSynchronizedStmt::getLocStart", NM="_ZNK5clang22ObjCAtSynchronizedStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang22ObjCAtSynchronizedStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtSynchronizedLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 299,
   FQN="clang::ObjCAtSynchronizedStmt::getLocEnd", NM="_ZNK5clang22ObjCAtSynchronizedStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang22ObjCAtSynchronizedStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getSynchBody$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 303,
   FQN="clang::ObjCAtSynchronizedStmt::classof", NM="_ZN5clang22ObjCAtSynchronizedStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAtSynchronizedStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtSynchronizedStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 307,
   FQN="clang::ObjCAtSynchronizedStmt::children", NM="_ZN5clang22ObjCAtSynchronizedStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang22ObjCAtSynchronizedStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubStmts)), new StmtIterator($AddrOf(SubStmts),(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "AtSynchronizedLoc=" + AtSynchronizedLoc // NOI18N
              + ", SubStmts=" + SubStmts // NOI18N
              + super.toString(); // NOI18N
  }
}

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
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// ForStmt - This represents a 'for (init;cond;inc)' stmt.  Note that any of
/// the init/cond/inc parts of the ForStmt will be null if they were not
/// specified in the source.
///
//<editor-fold defaultstate="collapsed" desc="clang::ForStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1153,
 FQN="clang::ForStmt", NM="_ZN5clang7ForStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmtE")
//</editor-fold>
public class ForStmt extends /*public*/ Stmt {
  private SourceLocation ForLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1155,
   FQN="clang::ForStmt::(anonymous)", NM="_ZN5clang7ForStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    INIT(0),
    CONDVAR(INIT.getValue() + 1),
    COND(CONDVAR.getValue() + 1),
    INC(COND.getValue() + 1),
    BODY(INC.getValue() + 1),
    END_EXPR(BODY.getValue() + 1);

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
  private Stmt /*P*/ SubExprs[/*5*/] = new Stmt /*P*/  [5]; // SubExprs[INIT] is an expression or declstmt.
  private SourceLocation LParenLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::ForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 797,
   FQN="clang::ForStmt::ForStmt", NM="_ZN5clang7ForStmtC1ERKNS_10ASTContextEPNS_4StmtEPNS_4ExprEPNS_7VarDeclES7_S5_NS_14SourceLocationESA_SA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmtC1ERKNS_10ASTContextEPNS_4StmtEPNS_4ExprEPNS_7VarDeclES7_S5_NS_14SourceLocationESA_SA_")
  //</editor-fold>
  public ForStmt(final /*const*/ ASTContext /*&*/ C, Stmt /*P*/ Init, Expr /*P*/ Cond, VarDecl /*P*/ condVar, 
      Expr /*P*/ Inc, Stmt /*P*/ Body, SourceLocation FL, SourceLocation LP, 
      SourceLocation RP) {
    // : Stmt(ForStmtClass), ForLoc(FL), LParenLoc(LP), RParenLoc(RP) 
    //START JInit
    super(StmtClass.ForStmtClass);
    this.ForLoc = new SourceLocation(FL);
    this.LParenLoc = new SourceLocation(LP);
    this.RParenLoc = new SourceLocation(RP);
    //END JInit
    SubExprs[Unnamed_enum.INIT.getValue()] = Init;
    setConditionVariable(C, condVar);
    SubExprs[Unnamed_enum.COND.getValue()] = Cond;
    SubExprs[Unnamed_enum.INC.getValue()] = Inc;
    SubExprs[Unnamed_enum.BODY.getValue()] = Body;
  }

  
  /// \brief Build an empty for statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::ForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1165,
   FQN="clang::ForStmt::ForStmt", NM="_ZN5clang7ForStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ForStmt(EmptyShell Empty) {
    // : Stmt(ForStmtClass, Empty), ForLoc(), LParenLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ForStmtClass, new EmptyShell(Empty));
    this.ForLoc = new SourceLocation();
    this.LParenLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1167,
   FQN="clang::ForStmt::getInit", NM="_ZN5clang7ForStmt7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7getInitEv")
  //</editor-fold>
  public Stmt /*P*/ getInit() {
    return SubExprs[Unnamed_enum.INIT.getValue()];
  }

  
  /// \brief Retrieve the variable declared in this "for" statement, if any.
  ///
  /// In the following example, "y" is the condition variable.
  /// \code
  /// for (int x = random(); int y = mangle(x); ++x) {
  ///   // ...
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 809,
   FQN="clang::ForStmt::getConditionVariable", NM="_ZNK5clang7ForStmt20getConditionVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt20getConditionVariableEv")
  //</editor-fold>
  public VarDecl /*P*/ getConditionVariable() /*const*/ {
    if (!(SubExprs[Unnamed_enum.CONDVAR.getValue()] != null)) {
      return null;
    }
    
    DeclStmt /*P*/ DS = cast_DeclStmt(SubExprs[Unnamed_enum.CONDVAR.getValue()]);
    return cast_VarDecl(DS.getSingleDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 817,
   FQN="clang::ForStmt::setConditionVariable", NM="_ZN5clang7ForStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE")
  //</editor-fold>
  public void setConditionVariable(final /*const*/ ASTContext /*&*/ C, VarDecl /*P*/ V) {
    if (!(V != null)) {
      SubExprs[Unnamed_enum.CONDVAR.getValue()] = null;
      return;
    }
    
    SourceRange VarRange = V.getSourceRange();
    SubExprs[Unnamed_enum.CONDVAR.getValue()] = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new DeclStmt(new DeclGroupRef(V), VarRange.getBegin(), 
                VarRange.getEnd());
     });
  }

  
  /// If this ForStmt has a condition variable, return the faux DeclStmt
  /// associated with the creation of that condition variable.
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getConditionVariableDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1182,
   FQN="clang::ForStmt::getConditionVariableDeclStmt", NM="_ZNK5clang7ForStmt28getConditionVariableDeclStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt28getConditionVariableDeclStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getConditionVariableDeclStmt() /*const*/ {
    return reinterpret_cast(DeclStmt /*P*/ .class, SubExprs[Unnamed_enum.CONDVAR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1186,
   FQN="clang::ForStmt::getCond", NM="_ZN5clang7ForStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1187,
   FQN="clang::ForStmt::getInc", NM="_ZN5clang7ForStmt6getIncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt6getIncEv")
  //</editor-fold>
  public Expr /*P*/ getInc() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.INC.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1188,
   FQN="clang::ForStmt::getBody", NM="_ZN5clang7ForStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1190,
   FQN="clang::ForStmt::getInit", NM="_ZNK5clang7ForStmt7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt7getInitEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getInit$Const() /*const*/ {
    return SubExprs[Unnamed_enum.INIT.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1191,
   FQN="clang::ForStmt::getCond", NM="_ZNK5clang7ForStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt7getCondEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCond$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1192,
   FQN="clang::ForStmt::getInc", NM="_ZNK5clang7ForStmt6getIncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt6getIncEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInc$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.INC.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1193,
   FQN="clang::ForStmt::getBody", NM="_ZNK5clang7ForStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1195,
   FQN="clang::ForStmt::setInit", NM="_ZN5clang7ForStmt7setInitEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7setInitEPNS_4StmtE")
  //</editor-fold>
  public void setInit(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.INIT.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1196,
   FQN="clang::ForStmt::setCond", NM="_ZN5clang7ForStmt7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1197,
   FQN="clang::ForStmt::setInc", NM="_ZN5clang7ForStmt6setIncEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt6setIncEPNS_4ExprE")
  //</editor-fold>
  public void setInc(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.INC.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1198,
   FQN="clang::ForStmt::setBody", NM="_ZN5clang7ForStmt7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getForLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1200,
   FQN="clang::ForStmt::getForLoc", NM="_ZNK5clang7ForStmt9getForLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt9getForLocEv")
  //</editor-fold>
  public SourceLocation getForLoc() /*const*/ {
    return new SourceLocation(ForLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setForLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1201,
   FQN="clang::ForStmt::setForLoc", NM="_ZN5clang7ForStmt9setForLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt9setForLocENS_14SourceLocationE")
  //</editor-fold>
  public void setForLoc(SourceLocation L) {
    ForLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1202,
   FQN="clang::ForStmt::getLParenLoc", NM="_ZNK5clang7ForStmt12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1203,
   FQN="clang::ForStmt::setLParenLoc", NM="_ZN5clang7ForStmt12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation L) {
    LParenLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1204,
   FQN="clang::ForStmt::getRParenLoc", NM="_ZNK5clang7ForStmt12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1205,
   FQN="clang::ForStmt::setRParenLoc", NM="_ZN5clang7ForStmt12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1207,
   FQN="clang::ForStmt::getLocStart", NM="_ZNK5clang7ForStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(ForLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1208,
   FQN="clang::ForStmt::getLocEnd", NM="_ZNK5clang7ForStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7ForStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()].getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1212,
   FQN="clang::ForStmt::classof", NM="_ZN5clang7ForStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ForStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ForStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1217,
   FQN="clang::ForStmt::children", NM="_ZN5clang7ForStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7ForStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "ForLoc=" + ForLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", LParenLoc=" + LParenLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}

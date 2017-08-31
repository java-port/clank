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

/// IfStmt - This represents an if/then/else.
///
//<editor-fold defaultstate="collapsed" desc="clang::IfStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 881,
 FQN="clang::IfStmt", NM="_ZN5clang6IfStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmtE")
//</editor-fold>
public class IfStmt extends /*public*/ Stmt {
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 882,
   FQN="clang::IfStmt::(anonymous)", NM="_ZN5clang6IfStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    INIT(0),
    VAR(INIT.getValue() + 1),
    COND(VAR.getValue() + 1),
    THEN(COND.getValue() + 1),
    ELSE(THEN.getValue() + 1),
    END_EXPR(ELSE.getValue() + 1);

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
  private Stmt /*P*/ SubExprs[/*5*/] = new Stmt /*P*/  [5];
  
  private SourceLocation IfLoc;
  private SourceLocation ElseLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::IfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 766,
   FQN="clang::IfStmt::IfStmt", NM="_ZN5clang6IfStmtC1ERKNS_10ASTContextENS_14SourceLocationEbPNS_4StmtEPNS_7VarDeclEPNS_4ExprES6_S4_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmtC1ERKNS_10ASTContextENS_14SourceLocationEbPNS_4StmtEPNS_7VarDeclEPNS_4ExprES6_S4_S6_")
  //</editor-fold>
  public IfStmt(final /*const*/ ASTContext /*&*/ C, SourceLocation IL, boolean IsConstexpr, 
      Stmt /*P*/ init, VarDecl /*P*/ var, Expr /*P*/ cond, Stmt /*P*/ then) {
    this(C, IL, IsConstexpr, 
      init, var, cond, then, 
      new SourceLocation(), (Stmt /*P*/ )null);
  }
  public IfStmt(final /*const*/ ASTContext /*&*/ C, SourceLocation IL, boolean IsConstexpr, 
      Stmt /*P*/ init, VarDecl /*P*/ var, Expr /*P*/ cond, Stmt /*P*/ then, 
      SourceLocation EL/*= SourceLocation()*/) {
    this(C, IL, IsConstexpr, 
      init, var, cond, then, 
      EL, (Stmt /*P*/ )null);
  }
  public IfStmt(final /*const*/ ASTContext /*&*/ C, SourceLocation IL, boolean IsConstexpr, 
      Stmt /*P*/ init, VarDecl /*P*/ var, Expr /*P*/ cond, Stmt /*P*/ then, 
      SourceLocation EL/*= SourceLocation()*/, Stmt /*P*/ elsev/*= null*/) {
    // : Stmt(IfStmtClass), IfLoc(IL), ElseLoc(EL) 
    //START JInit
    super(StmtClass.IfStmtClass);
    this.IfLoc = new SourceLocation(IL);
    this.ElseLoc = new SourceLocation(EL);
    //END JInit
    setConstexpr(IsConstexpr);
    setConditionVariable(C, var);
    SubExprs[Unnamed_enum.INIT.getValue()] = init;
    SubExprs[Unnamed_enum.COND.getValue()] = cond;
    SubExprs[Unnamed_enum.THEN.getValue()] = then;
    SubExprs[Unnamed_enum.ELSE.getValue()] = elsev;
  }

  
  /// \brief Build an empty if/then/else statement
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::IfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 895,
   FQN="clang::IfStmt::IfStmt", NM="_ZN5clang6IfStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ IfStmt(EmptyShell Empty) {
    // : Stmt(IfStmtClass, Empty), IfLoc(), ElseLoc() 
    //START JInit
    super(StmtClass.IfStmtClass, new EmptyShell(Empty));
    this.IfLoc = new SourceLocation();
    this.ElseLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Retrieve the variable declared in this "if" statement, if any.
  ///
  /// In the following example, "x" is the condition variable.
  /// \code
  /// if (int x = foo()) {
  ///   printf("x is %d", x);
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 778,
   FQN="clang::IfStmt::getConditionVariable", NM="_ZNK5clang6IfStmt20getConditionVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt20getConditionVariableEv")
  //</editor-fold>
  public VarDecl /*P*/ getConditionVariable() /*const*/ {
    if (!(SubExprs[Unnamed_enum.VAR.getValue()] != null)) {
      return null;
    }
    
    DeclStmt /*P*/ DS = cast_DeclStmt(SubExprs[Unnamed_enum.VAR.getValue()]);
    return cast_VarDecl(DS.getSingleDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 786,
   FQN="clang::IfStmt::setConditionVariable", NM="_ZN5clang6IfStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE")
  //</editor-fold>
  public void setConditionVariable(final /*const*/ ASTContext /*&*/ C, VarDecl /*P*/ V) {
    if (!(V != null)) {
      SubExprs[Unnamed_enum.VAR.getValue()] = null;
      return;
    }
    
    SourceRange VarRange = V.getSourceRange();
    SubExprs[Unnamed_enum.VAR.getValue()] = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new DeclStmt(new DeclGroupRef(V), VarRange.getBegin(), 
                VarRange.getEnd());
     });
  }

  
  /// If this IfStmt has a condition variable, return the faux DeclStmt
  /// associated with the creation of that condition variable.
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getConditionVariableDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 910,
   FQN="clang::IfStmt::getConditionVariableDeclStmt", NM="_ZNK5clang6IfStmt28getConditionVariableDeclStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt28getConditionVariableDeclStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getConditionVariableDeclStmt() /*const*/ {
    return reinterpret_cast(DeclStmt /*P*/ .class, SubExprs[Unnamed_enum.VAR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 914,
   FQN="clang::IfStmt::getInit", NM="_ZN5clang6IfStmt7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7getInitEv")
  //</editor-fold>
  public Stmt /*P*/ getInit() {
    return SubExprs[Unnamed_enum.INIT.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 915,
   FQN="clang::IfStmt::getInit", NM="_ZNK5clang6IfStmt7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt7getInitEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getInit$Const() /*const*/ {
    return SubExprs[Unnamed_enum.INIT.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 916,
   FQN="clang::IfStmt::setInit", NM="_ZN5clang6IfStmt7setInitEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7setInitEPNS_4StmtE")
  //</editor-fold>
  public void setInit(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.INIT.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 917,
   FQN="clang::IfStmt::getCond", NM="_ZNK5clang6IfStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt7getCondEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCond$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 918,
   FQN="clang::IfStmt::setCond", NM="_ZN5clang6IfStmt7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getThen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 919,
   FQN="clang::IfStmt::getThen", NM="_ZNK5clang6IfStmt7getThenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt7getThenEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getThen$Const() /*const*/ {
    return SubExprs[Unnamed_enum.THEN.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setThen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 920,
   FQN="clang::IfStmt::setThen", NM="_ZN5clang6IfStmt7setThenEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7setThenEPNS_4StmtE")
  //</editor-fold>
  public void setThen(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.THEN.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getElse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 921,
   FQN="clang::IfStmt::getElse", NM="_ZNK5clang6IfStmt7getElseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt7getElseEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getElse$Const() /*const*/ {
    return SubExprs[Unnamed_enum.ELSE.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setElse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 922,
   FQN="clang::IfStmt::setElse", NM="_ZN5clang6IfStmt7setElseEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7setElseEPNS_4StmtE")
  //</editor-fold>
  public void setElse(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.ELSE.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 924,
   FQN="clang::IfStmt::getCond", NM="_ZN5clang6IfStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getThen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 925,
   FQN="clang::IfStmt::getThen", NM="_ZN5clang6IfStmt7getThenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7getThenEv")
  //</editor-fold>
  public Stmt /*P*/ getThen() {
    return SubExprs[Unnamed_enum.THEN.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getElse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 926,
   FQN="clang::IfStmt::getElse", NM="_ZN5clang6IfStmt7getElseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7getElseEv")
  //</editor-fold>
  public Stmt /*P*/ getElse() {
    return SubExprs[Unnamed_enum.ELSE.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getIfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 928,
   FQN="clang::IfStmt::getIfLoc", NM="_ZNK5clang6IfStmt8getIfLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt8getIfLocEv")
  //</editor-fold>
  public SourceLocation getIfLoc() /*const*/ {
    return new SourceLocation(IfLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setIfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 929,
   FQN="clang::IfStmt::setIfLoc", NM="_ZN5clang6IfStmt8setIfLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt8setIfLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIfLoc(SourceLocation L) {
    IfLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getElseLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 930,
   FQN="clang::IfStmt::getElseLoc", NM="_ZNK5clang6IfStmt10getElseLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt10getElseLocEv")
  //</editor-fold>
  public SourceLocation getElseLoc() /*const*/ {
    return new SourceLocation(ElseLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setElseLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 931,
   FQN="clang::IfStmt::setElseLoc", NM="_ZN5clang6IfStmt10setElseLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt10setElseLocENS_14SourceLocationE")
  //</editor-fold>
  public void setElseLoc(SourceLocation L) {
    ElseLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::isConstexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 933,
   FQN="clang::IfStmt::isConstexpr", NM="_ZNK5clang6IfStmt11isConstexprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt11isConstexprEv")
  //</editor-fold>
  public boolean isConstexpr() /*const*/ {
    return Unnamed_field.IfStmtBits.IsConstexpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::setConstexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 934,
   FQN="clang::IfStmt::setConstexpr", NM="_ZN5clang6IfStmt12setConstexprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt12setConstexprEb")
  //</editor-fold>
  public void setConstexpr(boolean C) {
    Unnamed_field.IfStmtBits.IsConstexpr = C;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 936,
   FQN="clang::IfStmt::getLocStart", NM="_ZNK5clang6IfStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(IfLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 937,
   FQN="clang::IfStmt::getLocEnd", NM="_ZNK5clang6IfStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang6IfStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if ((SubExprs[Unnamed_enum.ELSE.getValue()] != null)) {
      return SubExprs[Unnamed_enum.ELSE.getValue()].getLocEnd();
    } else {
      return SubExprs[Unnamed_enum.THEN.getValue()].getLocEnd();
    }
  }

  
  // Iterators over subexpressions.  The iterators will include iterating
  // over the initialization expression referenced by the condition variable.
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 946,
   FQN="clang::IfStmt::children", NM="_ZN5clang6IfStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),(Unnamed_enum.END_EXPR.getValue())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IfStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 950,
   FQN="clang::IfStmt::classof", NM="_ZN5clang6IfStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang6IfStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.IfStmtClass;
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", IfLoc=" + IfLoc // NOI18N
              + ", ElseLoc=" + ElseLoc // NOI18N
              + super.toString(); // NOI18N
  }
}

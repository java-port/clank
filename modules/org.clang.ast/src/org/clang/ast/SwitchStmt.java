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
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// SwitchStmt - This represents a 'switch' stmt.
///
//<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 957,
 FQN="clang::SwitchStmt", NM="_ZN5clang10SwitchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmtE")
//</editor-fold>
public class SwitchStmt extends /*public*/ Stmt {
  private SourceLocation SwitchLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 959,
   FQN="clang::SwitchStmt::(anonymous)", NM="_ZN5clang10SwitchStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    INIT(0),
    VAR(INIT.getValue() + 1),
    COND(VAR.getValue() + 1),
    BODY(COND.getValue() + 1),
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
  private Stmt /*P*/ SubExprs[/*4*/] = new Stmt /*P*/  [4];
  // This points to a linked list of case and default statements and, if the
  // SwitchStmt is a switch on an enum value, records whether all the enum
  // values were covered by CaseStmts.  The coverage information value is meant
  // to be a hint for possible clients.
  private PointerBoolPair<SwitchCase /*P*/ > FirstCase;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::SwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 828,
   FQN="clang::SwitchStmt::SwitchStmt", NM="_ZN5clang10SwitchStmtC1ERKNS_10ASTContextEPNS_4StmtEPNS_7VarDeclEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmtC1ERKNS_10ASTContextEPNS_4StmtEPNS_7VarDeclEPNS_4ExprE")
  //</editor-fold>
  public SwitchStmt(final /*const*/ ASTContext /*&*/ C, Stmt /*P*/ init, VarDecl /*P*/ Var, 
      Expr /*P*/ cond) {
    // : Stmt(SwitchStmtClass), SwitchLoc(), FirstCase(null, false) 
    //START JInit
    super(StmtClass.SwitchStmtClass);
    this.SwitchLoc = new SourceLocation();
    this.FirstCase = new PointerBoolPair<SwitchCase /*P*/ >((SwitchCase /*P*/ )null, false);
    //END JInit
    setConditionVariable(C, Var);
    SubExprs[Unnamed_enum.INIT.getValue()] = init;
    SubExprs[Unnamed_enum.COND.getValue()] = cond;
    SubExprs[Unnamed_enum.BODY.getValue()] = null;
  }

  
  /// \brief Build a empty switch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::SwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 971,
   FQN="clang::SwitchStmt::SwitchStmt", NM="_ZN5clang10SwitchStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ SwitchStmt(EmptyShell Empty) {
    // : Stmt(SwitchStmtClass, Empty), SwitchLoc(), FirstCase() 
    //START JInit
    super(StmtClass.SwitchStmtClass, new EmptyShell(Empty));
    this.SwitchLoc = new SourceLocation();
    this.FirstCase = new PointerBoolPair<SwitchCase /*P*/ >();
    //END JInit
  }

  
  /// \brief Retrieve the variable declared in this "switch" statement, if any.
  ///
  /// In the following example, "x" is the condition variable.
  /// \code
  /// switch (int x = foo()) {
  ///   case 0: break;
  ///   // ...
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 837,
   FQN="clang::SwitchStmt::getConditionVariable", NM="_ZNK5clang10SwitchStmt20getConditionVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt20getConditionVariableEv")
  //</editor-fold>
  public VarDecl /*P*/ getConditionVariable() /*const*/ {
    if (!(SubExprs[Unnamed_enum.VAR.getValue()] != null)) {
      return null;
    }
    
    DeclStmt /*P*/ DS = cast_DeclStmt(SubExprs[Unnamed_enum.VAR.getValue()]);
    return cast_VarDecl(DS.getSingleDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 845,
   FQN="clang::SwitchStmt::setConditionVariable", NM="_ZN5clang10SwitchStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE")
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

  
  /// If this SwitchStmt has a condition variable, return the faux DeclStmt
  /// associated with the creation of that condition variable.
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getConditionVariableDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 987,
   FQN="clang::SwitchStmt::getConditionVariableDeclStmt", NM="_ZNK5clang10SwitchStmt28getConditionVariableDeclStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt28getConditionVariableDeclStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getConditionVariableDeclStmt() /*const*/ {
    return reinterpret_cast(DeclStmt /*P*/ .class, SubExprs[Unnamed_enum.VAR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 991,
   FQN="clang::SwitchStmt::getInit", NM="_ZN5clang10SwitchStmt7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7getInitEv")
  //</editor-fold>
  public Stmt /*P*/ getInit() {
    return SubExprs[Unnamed_enum.INIT.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 992,
   FQN="clang::SwitchStmt::getInit", NM="_ZNK5clang10SwitchStmt7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt7getInitEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getInit$Const() /*const*/ {
    return SubExprs[Unnamed_enum.INIT.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 993,
   FQN="clang::SwitchStmt::setInit", NM="_ZN5clang10SwitchStmt7setInitEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7setInitEPNS_4StmtE")
  //</editor-fold>
  public void setInit(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.INIT.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 994,
   FQN="clang::SwitchStmt::getCond", NM="_ZNK5clang10SwitchStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt7getCondEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCond$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 995,
   FQN="clang::SwitchStmt::getBody", NM="_ZNK5clang10SwitchStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getSwitchCaseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 996,
   FQN="clang::SwitchStmt::getSwitchCaseList", NM="_ZNK5clang10SwitchStmt17getSwitchCaseListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt17getSwitchCaseListEv")
  //</editor-fold>
  public /*const*/ SwitchCase /*P*/ getSwitchCaseList$Const() /*const*/ {
    return FirstCase.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 998,
   FQN="clang::SwitchStmt::getCond", NM="_ZN5clang10SwitchStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 999,
   FQN="clang::SwitchStmt::setCond", NM="_ZN5clang10SwitchStmt7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1000,
   FQN="clang::SwitchStmt::getBody", NM="_ZN5clang10SwitchStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1001,
   FQN="clang::SwitchStmt::setBody", NM="_ZN5clang10SwitchStmt7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getSwitchCaseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1002,
   FQN="clang::SwitchStmt::getSwitchCaseList", NM="_ZN5clang10SwitchStmt17getSwitchCaseListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt17getSwitchCaseListEv")
  //</editor-fold>
  public SwitchCase /*P*/ getSwitchCaseList() {
    return FirstCase.getPointer();
  }

  
  /// \brief Set the case list for this switch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setSwitchCaseList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1005,
   FQN="clang::SwitchStmt::setSwitchCaseList", NM="_ZN5clang10SwitchStmt17setSwitchCaseListEPNS_10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt17setSwitchCaseListEPNS_10SwitchCaseE")
  //</editor-fold>
  public void setSwitchCaseList(SwitchCase /*P*/ SC) {
    FirstCase.setPointer(SC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getSwitchLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1007,
   FQN="clang::SwitchStmt::getSwitchLoc", NM="_ZNK5clang10SwitchStmt12getSwitchLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt12getSwitchLocEv")
  //</editor-fold>
  public SourceLocation getSwitchLoc() /*const*/ {
    return new SourceLocation(SwitchLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setSwitchLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1008,
   FQN="clang::SwitchStmt::setSwitchLoc", NM="_ZN5clang10SwitchStmt12setSwitchLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt12setSwitchLocENS_14SourceLocationE")
  //</editor-fold>
  public void setSwitchLoc(SourceLocation L) {
    SwitchLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1010,
   FQN="clang::SwitchStmt::setBody", NM="_ZN5clang10SwitchStmt7setBodyEPNS_4StmtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7setBodyEPNS_4StmtENS_14SourceLocationE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S, SourceLocation SL) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
    SwitchLoc.$assign(SL);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::addSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1014,
   FQN="clang::SwitchStmt::addSwitchCase", NM="_ZN5clang10SwitchStmt13addSwitchCaseEPNS_10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt13addSwitchCaseEPNS_10SwitchCaseE")
  //</editor-fold>
  public void addSwitchCase(SwitchCase /*P*/ SC) {
    assert (!(SC.getNextSwitchCase() != null)) : "case/default already added to a switch";
    SC.setNextSwitchCase(FirstCase.getPointer());
    FirstCase.setPointer(SC);
  }

  
  /// Set a flag in the SwitchStmt indicating that if the 'switch (X)' is a
  /// switch over an enum value then all cases have been explicitly covered.
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::setAllEnumCasesCovered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1023,
   FQN="clang::SwitchStmt::setAllEnumCasesCovered", NM="_ZN5clang10SwitchStmt22setAllEnumCasesCoveredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt22setAllEnumCasesCoveredEv")
  //</editor-fold>
  public void setAllEnumCasesCovered() {
    FirstCase.setInt(true);
  }

  
  /// Returns true if the SwitchStmt is a switch of an enum value and all cases
  /// have been explicitly covered.
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::isAllEnumCasesCovered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1027,
   FQN="clang::SwitchStmt::isAllEnumCasesCovered", NM="_ZNK5clang10SwitchStmt21isAllEnumCasesCoveredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt21isAllEnumCasesCoveredEv")
  //</editor-fold>
  public boolean isAllEnumCasesCovered() /*const*/ {
    return FirstCase.getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1029,
   FQN="clang::SwitchStmt::getLocStart", NM="_ZNK5clang10SwitchStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(SwitchLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1030,
   FQN="clang::SwitchStmt::getLocEnd", NM="_ZNK5clang10SwitchStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return (SubExprs[Unnamed_enum.BODY.getValue()] != null) ? SubExprs[Unnamed_enum.BODY.getValue()].getLocEnd() : SubExprs[Unnamed_enum.COND.getValue()].getLocEnd();
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1035,
   FQN="clang::SwitchStmt::children", NM="_ZN5clang10SwitchStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),(Unnamed_enum.END_EXPR.getValue())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1039,
   FQN="clang::SwitchStmt::classof", NM="_ZN5clang10SwitchStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.SwitchStmtClass;
  }

  
  @Override public String toString() {
    return "" + "SwitchLoc=" + SwitchLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", FirstCase=" + FirstCase // NOI18N
              + super.toString(); // NOI18N
  }
}

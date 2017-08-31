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

/// WhileStmt - This represents a 'while' stmt.
///
//<editor-fold defaultstate="collapsed" desc="clang::WhileStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1047,
 FQN="clang::WhileStmt", NM="_ZN5clang9WhileStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmtE")
//</editor-fold>
public class WhileStmt extends /*public*/ Stmt {
  private SourceLocation WhileLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1049,
   FQN="clang::WhileStmt::(anonymous)", NM="_ZN5clang9WhileStmtE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmtE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    VAR(0),
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
  private Stmt /*P*/ SubExprs[/*3*/] = new Stmt /*P*/  [3];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::WhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 862,
   FQN="clang::WhileStmt::WhileStmt", NM="_ZN5clang9WhileStmtC1ERKNS_10ASTContextEPNS_7VarDeclEPNS_4ExprEPNS_4StmtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmtC1ERKNS_10ASTContextEPNS_7VarDeclEPNS_4ExprEPNS_4StmtENS_14SourceLocationE")
  //</editor-fold>
  public WhileStmt(final /*const*/ ASTContext /*&*/ C, VarDecl /*P*/ Var, Expr /*P*/ cond, Stmt /*P*/ body, 
      SourceLocation WL) {
    // : Stmt(WhileStmtClass), WhileLoc() 
    //START JInit
    super(StmtClass.WhileStmtClass);
    this.WhileLoc = new SourceLocation();
    //END JInit
    setConditionVariable(C, Var);
    SubExprs[Unnamed_enum.COND.getValue()] = cond;
    SubExprs[Unnamed_enum.BODY.getValue()] = body;
    WhileLoc.$assign(WL);
  }

  
  /// \brief Build an empty while statement.
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::WhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1056,
   FQN="clang::WhileStmt::WhileStmt", NM="_ZN5clang9WhileStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ WhileStmt(EmptyShell Empty) {
    // : Stmt(WhileStmtClass, Empty), WhileLoc() 
    //START JInit
    super(StmtClass.WhileStmtClass, new EmptyShell(Empty));
    this.WhileLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Retrieve the variable declared in this "while" statement, if any.
  ///
  /// In the following example, "x" is the condition variable.
  /// \code
  /// while (int x = random()) {
  ///   // ...
  /// }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 871,
   FQN="clang::WhileStmt::getConditionVariable", NM="_ZNK5clang9WhileStmt20getConditionVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt20getConditionVariableEv")
  //</editor-fold>
  public VarDecl /*P*/ getConditionVariable() /*const*/ {
    if (!(SubExprs[Unnamed_enum.VAR.getValue()] != null)) {
      return null;
    }
    
    DeclStmt /*P*/ DS = cast_DeclStmt(SubExprs[Unnamed_enum.VAR.getValue()]);
    return cast_VarDecl(DS.getSingleDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::setConditionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 879,
   FQN="clang::WhileStmt::setConditionVariable", NM="_ZN5clang9WhileStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt20setConditionVariableERKNS_10ASTContextEPNS_7VarDeclE")
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

  
  /// If this WhileStmt has a condition variable, return the faux DeclStmt
  /// associated with the creation of that condition variable.
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getConditionVariableDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1071,
   FQN="clang::WhileStmt::getConditionVariableDeclStmt", NM="_ZNK5clang9WhileStmt28getConditionVariableDeclStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt28getConditionVariableDeclStmtEv")
  //</editor-fold>
  public /*const*/ DeclStmt /*P*/ getConditionVariableDeclStmt() /*const*/ {
    return reinterpret_cast(DeclStmt /*P*/ .class, SubExprs[Unnamed_enum.VAR.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1075,
   FQN="clang::WhileStmt::getCond", NM="_ZN5clang9WhileStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1076,
   FQN="clang::WhileStmt::getCond", NM="_ZNK5clang9WhileStmt7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt7getCondEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCond$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, SubExprs[Unnamed_enum.COND.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::setCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1077,
   FQN="clang::WhileStmt::setCond", NM="_ZN5clang9WhileStmt7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt7setCondEPNS_4ExprE")
  //</editor-fold>
  public void setCond(Expr /*P*/ E) {
    SubExprs[Unnamed_enum.COND.getValue()] = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1078,
   FQN="clang::WhileStmt::getBody", NM="_ZN5clang9WhileStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1079,
   FQN="clang::WhileStmt::getBody", NM="_ZNK5clang9WhileStmt7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody$Const() /*const*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()];
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::setBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1080,
   FQN="clang::WhileStmt::setBody", NM="_ZN5clang9WhileStmt7setBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt7setBodyEPNS_4StmtE")
  //</editor-fold>
  public void setBody(Stmt /*P*/ S) {
    SubExprs[Unnamed_enum.BODY.getValue()] = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getWhileLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1082,
   FQN="clang::WhileStmt::getWhileLoc", NM="_ZNK5clang9WhileStmt11getWhileLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt11getWhileLocEv")
  //</editor-fold>
  public SourceLocation getWhileLoc() /*const*/ {
    return new SourceLocation(WhileLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::setWhileLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1083,
   FQN="clang::WhileStmt::setWhileLoc", NM="_ZN5clang9WhileStmt11setWhileLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt11setWhileLocENS_14SourceLocationE")
  //</editor-fold>
  public void setWhileLoc(SourceLocation L) {
    WhileLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1085,
   FQN="clang::WhileStmt::getLocStart", NM="_ZNK5clang9WhileStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(WhileLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1086,
   FQN="clang::WhileStmt::getLocEnd", NM="_ZNK5clang9WhileStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9WhileStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExprs[Unnamed_enum.BODY.getValue()].getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1090,
   FQN="clang::WhileStmt::classof", NM="_ZN5clang9WhileStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.WhileStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::WhileStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1095,
   FQN="clang::WhileStmt::children", NM="_ZN5clang9WhileStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9WhileStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(SubExprs)), new StmtIterator($AddrOf(SubExprs),(Unnamed_enum.END_EXPR.getValue())));
  }

  
  @Override public String toString() {
    return "" + "WhileLoc=" + WhileLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + super.toString(); // NOI18N
  }
}

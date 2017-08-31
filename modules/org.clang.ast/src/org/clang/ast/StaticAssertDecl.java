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
import static org.llvm.adt.ADTAliases.*;
import org.clang.basic.*;


/// \brief Represents a C++11 static_assert declaration.
//<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3327,
 FQN="clang::StaticAssertDecl", NM="_ZN5clang16StaticAssertDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDeclE")
//</editor-fold>
public class StaticAssertDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2302,
   FQN="clang::StaticAssertDecl::anchor", NM="_ZN5clang16StaticAssertDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  /*friend*/public PointerBoolPair<Expr /*P*/ > AssertExprAndFailed;
  /*friend*/public StringLiteral /*P*/ Message;
  /*friend*/public SourceLocation RParenLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::StaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3333,
   FQN="clang::StaticAssertDecl::StaticAssertDecl", NM="_ZN5clang16StaticAssertDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES3_b")
  //</editor-fold>
  private StaticAssertDecl(DeclContext /*P*/ DC, SourceLocation StaticAssertLoc, 
      Expr /*P*/ AssertExpr, StringLiteral /*P*/ Message, 
      SourceLocation RParenLoc, boolean Failed) {
    // : Decl(StaticAssert, DC, StaticAssertLoc), AssertExprAndFailed(AssertExpr, Failed), Message(Message), RParenLoc(RParenLoc) 
    //START JInit
    super(Kind.StaticAssert, DC, new SourceLocation(StaticAssertLoc));
    this.AssertExprAndFailed = new PointerBoolPair<Expr /*P*/ >(AssertExpr, Failed);
    this.Message = Message;
    this.RParenLoc = new SourceLocation(RParenLoc);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2304,
   FQN="clang::StaticAssertDecl::Create", NM="_ZN5clang16StaticAssertDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES5_b")
  //</editor-fold>
  public static StaticAssertDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StaticAssertLoc, 
        Expr /*P*/ AssertExpr, 
        StringLiteral /*P*/ Message, 
        SourceLocation RParenLoc, 
        boolean Failed) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new StaticAssertDecl(DC, new SourceLocation(StaticAssertLoc), AssertExpr, Message, 
                new SourceLocation(RParenLoc), Failed);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2314,
   FQN="clang::StaticAssertDecl::CreateDeserialized", NM="_ZN5clang16StaticAssertDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static StaticAssertDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new StaticAssertDecl((DeclContext /*P*/ )null, new SourceLocation(), (Expr /*P*/ )null, 
                (StringLiteral /*P*/ )null, new SourceLocation(), false);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::getAssertExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3347,
   FQN="clang::StaticAssertDecl::getAssertExpr", NM="_ZN5clang16StaticAssertDecl13getAssertExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl13getAssertExprEv")
  //</editor-fold>
  public Expr /*P*/ getAssertExpr() {
    return AssertExprAndFailed.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::getAssertExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3348,
   FQN="clang::StaticAssertDecl::getAssertExpr", NM="_ZNK5clang16StaticAssertDecl13getAssertExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang16StaticAssertDecl13getAssertExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getAssertExpr$Const() /*const*/ {
    return AssertExprAndFailed.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3350,
   FQN="clang::StaticAssertDecl::getMessage", NM="_ZN5clang16StaticAssertDecl10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl10getMessageEv")
  //</editor-fold>
  public StringLiteral /*P*/ getMessage() {
    return Message;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3351,
   FQN="clang::StaticAssertDecl::getMessage", NM="_ZNK5clang16StaticAssertDecl10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang16StaticAssertDecl10getMessageEv")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getMessage$Const() /*const*/ {
    return Message;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::isFailed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3353,
   FQN="clang::StaticAssertDecl::isFailed", NM="_ZNK5clang16StaticAssertDecl8isFailedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang16StaticAssertDecl8isFailedEv")
  //</editor-fold>
  public boolean isFailed() /*const*/ {
    return AssertExprAndFailed.getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3355,
   FQN="clang::StaticAssertDecl::getRParenLoc", NM="_ZNK5clang16StaticAssertDecl12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang16StaticAssertDecl12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3357,
   FQN="clang::StaticAssertDecl::getSourceRange", NM="_ZNK5clang16StaticAssertDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang16StaticAssertDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(getLocation(), getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3361,
   FQN="clang::StaticAssertDecl::classof", NM="_ZN5clang16StaticAssertDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3362,
   FQN="clang::StaticAssertDecl::classofKind", NM="_ZN5clang16StaticAssertDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.StaticAssert;
  }

  
  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::StaticAssertDecl::~StaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3327,
   FQN="clang::StaticAssertDecl::~StaticAssertDecl", NM="_ZN5clang16StaticAssertDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang16StaticAssertDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AssertExprAndFailed=" + AssertExprAndFailed // NOI18N
              + ", Message=" + Message // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}

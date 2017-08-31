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
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3423,
 FQN="clang::FileScopeAsmDecl", NM="_ZN5clang16FileScopeAsmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDeclE")
//</editor-fold>
public class FileScopeAsmDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4185,
   FQN="clang::FileScopeAsmDecl::anchor", NM="_ZN5clang16FileScopeAsmDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  private StringLiteral /*P*/ AsmString;
  private SourceLocation RParenLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::FileScopeAsmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3427,
   FQN="clang::FileScopeAsmDecl::FileScopeAsmDecl", NM="_ZN5clang16FileScopeAsmDeclC1EPNS_11DeclContextEPNS_13StringLiteralENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDeclC1EPNS_11DeclContextEPNS_13StringLiteralENS_14SourceLocationES5_")
  //</editor-fold>
  private FileScopeAsmDecl(DeclContext /*P*/ DC, StringLiteral /*P*/ asmstring, 
      SourceLocation StartL, SourceLocation EndL) {
    // : Decl(FileScopeAsm, DC, StartL), AsmString(asmstring), RParenLoc(EndL) 
    //START JInit
    super(Kind.FileScopeAsm, DC, new SourceLocation(StartL));
    this.AsmString = asmstring;
    this.RParenLoc = new SourceLocation(EndL);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4187,
   FQN="clang::FileScopeAsmDecl::Create", NM="_ZN5clang16FileScopeAsmDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_13StringLiteralENS_14SourceLocationES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_13StringLiteralENS_14SourceLocationES7_")
  //</editor-fold>
  public static FileScopeAsmDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        StringLiteral /*P*/ Str, 
        SourceLocation AsmLoc, 
        SourceLocation RParenLoc) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new FileScopeAsmDecl(DC, Str, new SourceLocation(AsmLoc), new SourceLocation(RParenLoc));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4194,
   FQN="clang::FileScopeAsmDecl::CreateDeserialized", NM="_ZN5clang16FileScopeAsmDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static FileScopeAsmDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new FileScopeAsmDecl((DeclContext /*P*/ )null, (StringLiteral /*P*/ )null, new SourceLocation(), 
                new SourceLocation());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::getAsmLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3437,
   FQN="clang::FileScopeAsmDecl::getAsmLoc", NM="_ZNK5clang16FileScopeAsmDecl9getAsmLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16FileScopeAsmDecl9getAsmLocEv")
  //</editor-fold>
  public SourceLocation getAsmLoc() /*const*/ {
    return getLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3438,
   FQN="clang::FileScopeAsmDecl::getRParenLoc", NM="_ZNK5clang16FileScopeAsmDecl12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16FileScopeAsmDecl12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3439,
   FQN="clang::FileScopeAsmDecl::setRParenLoc", NM="_ZN5clang16FileScopeAsmDecl12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3440,
   FQN="clang::FileScopeAsmDecl::getSourceRange", NM="_ZNK5clang16FileScopeAsmDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16FileScopeAsmDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(getAsmLoc(), getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::getAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3444,
   FQN="clang::FileScopeAsmDecl::getAsmString", NM="_ZNK5clang16FileScopeAsmDecl12getAsmStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16FileScopeAsmDecl12getAsmStringEv")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getAsmString$Const() /*const*/ {
    return AsmString;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::getAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3445,
   FQN="clang::FileScopeAsmDecl::getAsmString", NM="_ZN5clang16FileScopeAsmDecl12getAsmStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl12getAsmStringEv")
  //</editor-fold>
  public StringLiteral /*P*/ getAsmString() {
    return AsmString;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::setAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3446,
   FQN="clang::FileScopeAsmDecl::setAsmString", NM="_ZN5clang16FileScopeAsmDecl12setAsmStringEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl12setAsmStringEPNS_13StringLiteralE")
  //</editor-fold>
  public void setAsmString(StringLiteral /*P*/ Asm) {
    AsmString = Asm;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3448,
   FQN="clang::FileScopeAsmDecl::classof", NM="_ZN5clang16FileScopeAsmDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3449,
   FQN="clang::FileScopeAsmDecl::classofKind", NM="_ZN5clang16FileScopeAsmDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.FileScopeAsm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileScopeAsmDecl::~FileScopeAsmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3423,
   FQN="clang::FileScopeAsmDecl::~FileScopeAsmDecl", NM="_ZN5clang16FileScopeAsmDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16FileScopeAsmDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AsmString=" + AsmString // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}

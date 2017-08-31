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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clank.java.std;


/// \brief Represents a `#pragma comment` line. Always a child of
/// TranslationUnitDecl.
//<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 109,
 FQN="clang::PragmaCommentDecl", NM="_ZN5clang17PragmaCommentDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDeclE")
//</editor-fold>
public final class PragmaCommentDecl extends /*public*/ Decl implements /*private*/ TrailingObjects$Char<PragmaCommentDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3924,
   FQN="clang::PragmaCommentDecl::anchor", NM="_ZN5clang17PragmaCommentDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  /*friend*/public PragmaMSCommentKind CommentKind;
  
  /*friend  TrailingObjects<PragmaCommentDecl, char>*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::PragmaCommentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 120,
   FQN="clang::PragmaCommentDecl::PragmaCommentDecl", NM="_ZN5clang17PragmaCommentDeclC1EPNS_19TranslationUnitDeclENS_14SourceLocationENS_19PragmaMSCommentKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDeclC1EPNS_19TranslationUnitDeclENS_14SourceLocationENS_19PragmaMSCommentKindE")
  //</editor-fold>
  private PragmaCommentDecl(TranslationUnitDecl /*P*/ TU, SourceLocation CommentLoc, 
      PragmaMSCommentKind CommentKind) {
    // : Decl(PragmaComment, TU, CommentLoc), TrailingObjects<PragmaCommentDecl, char>(), CommentKind(CommentKind) 
    //START JInit
    super(Kind.PragmaComment, TU, new SourceLocation(CommentLoc));
    $TrailingObjects();
    this.CommentKind = CommentKind;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3926,
   FQN="clang::PragmaCommentDecl::Create", NM="_ZN5clang17PragmaCommentDecl6CreateERKNS_10ASTContextEPNS_19TranslationUnitDeclENS_14SourceLocationENS_19PragmaMSCommentKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDecl6CreateERKNS_10ASTContextEPNS_19TranslationUnitDeclENS_14SourceLocationENS_19PragmaMSCommentKindEN4llvm9StringRefE")
  //</editor-fold>
  public static PragmaCommentDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        TranslationUnitDecl /*P*/ DC, 
        SourceLocation CommentLoc, 
        PragmaMSCommentKind CommentKind, 
        StringRef Arg) {
    // JAVA: MEMORY
    final int NumChars = Arg.size() + 1;
    char$ptr arg$chars = $toConst(create_char$ptr(new$char(NumChars)));
    final int Extra = TrailingObjects$Char.additionalSizeToAlloc$Same(byte.class, NumChars);
    assert Extra == 1 : "we use only one slot for char$ptr";
    PragmaCommentDecl /*P*/ PCD = /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<charbyte>(Arg.size() + 1))*/Decl.$new(C, DC, Extra, (type$ptr<?> New$Mem)->{
        return new PragmaCommentDecl(DC, new SourceLocation(CommentLoc), CommentKind);
     },
        new std.pairIntPtr<>(Extra, ()->arg$chars) // for char *
    );
    assert PCD.getTrailingObjects(/*char byte.class*/) == arg$chars;
    memcpy(PCD.getTrailingObjects(/*char byte.class*/), Arg.data(), Arg.size());
    PCD.getTrailingObjects(/*char byte.class*/).$set(Arg.size(), $$TERM);
    return PCD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3939,
   FQN="clang::PragmaCommentDecl::CreateDeserialized", NM="_ZN5clang17PragmaCommentDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static PragmaCommentDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID, 
                    /*uint*/int ArgSize) {
    // JAVA: MEMORY
    final int NumChars = ArgSize + 1;
    char$ptr arg$chars = $toConst(create_char$ptr(new$char(NumChars)));
    final int Extra = TrailingObjects$Char.additionalSizeToAlloc$Same(byte.class, NumChars);
    assert Extra == 1 : "we use only one slot for char$ptr";
    PragmaCommentDecl /*P*/ PCD =  /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<charbyte>(ArgSize + 1))*/ Decl.$new(C, ID, Extra, (type$ptr<?> New$Mem)->{
        return new PragmaCommentDecl((TranslationUnitDecl /*P*/ )null, new SourceLocation(), PragmaMSCommentKind.PCK_Unknown);
     },
        new std.pairIntPtr<>(Extra, ()->arg$chars) // for char *
    );
    assert PCD.getTrailingObjects(/*char byte.class*/) == arg$chars;
    return PCD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::getCommentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 132,
   FQN="clang::PragmaCommentDecl::getCommentKind", NM="_ZNK5clang17PragmaCommentDecl14getCommentKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17PragmaCommentDecl14getCommentKindEv")
  //</editor-fold>
  public PragmaMSCommentKind getCommentKind() /*const*/ {
    return CommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::getArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 134,
   FQN="clang::PragmaCommentDecl::getArg", NM="_ZNK5clang17PragmaCommentDecl6getArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17PragmaCommentDecl6getArgEv")
  //</editor-fold>
  public StringRef getArg() /*const*/ {
    return new StringRef(getTrailingObjects$Const());
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 137,
   FQN="clang::PragmaCommentDecl::classof", NM="_ZN5clang17PragmaCommentDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 138,
   FQN="clang::PragmaCommentDecl::classofKind", NM="_ZN5clang17PragmaCommentDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.PragmaComment;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaCommentDecl::~PragmaCommentDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 109,
   FQN="clang::PragmaCommentDecl::~PragmaCommentDecl", NM="_ZN5clang17PragmaCommentDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17PragmaCommentDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TrailingObjects$Char.super.$destroy$TrailingObjects();
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public char$ptr getTrailingObjects() {
    // char$ptr is in the cell after $this, see PragmaCommentDecl::Create*
    return (char$ptr)super.$This$Ptr().$add(1).$star();
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void $TrailingObjects() {
    assert getTrailingObjects() != null : "must be initialized in Create methods";
  }
  
  @Override public String toString() {
    return "" + "CommentKind=" + CommentKind // NOI18N
             + "[" + getArg() +"]"
              + super.toString(); // NOI18N
  }
}

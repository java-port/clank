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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2229,
 FQN="clang::EnableIfAttr", NM="_ZN5clang12EnableIfAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12EnableIfAttrE")
//</editor-fold>
public class EnableIfAttr extends /*public*/ InheritableAttr {
  private Expr /*P*/ cond;
  
  private /*uint*/int messageLength;
  private char$ptr/*char P*/ message;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2236,
   FQN="clang::EnableIfAttr::CreateImplicit", NM="_ZN5clang12EnableIfAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12EnableIfAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static EnableIfAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ Cond, StringRef Message) {
    return CreateImplicit(Ctx, Cond, Message, new SourceRange());
  }
  public static EnableIfAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ Cond, StringRef Message, SourceRange Loc/*= SourceRange()*/) {
    EnableIfAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new EnableIfAttr(new SourceRange(Loc), Ctx, Cond, new StringRef(Message), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::EnableIfAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2242,
   FQN="clang::EnableIfAttr::EnableIfAttr", NM="_ZN5clang12EnableIfAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12EnableIfAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEN4llvm9StringRefEj")
  //</editor-fold>
  public EnableIfAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ Cond, 
      StringRef Message, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::EnableIf, R, SI, false, false), cond(Cond), messageLength(Message.size()), message(new (Ctx, 1) new char [messageLength]) 
    //START JInit
    super(attr.Kind.EnableIf, new SourceRange(R), SI, false, false);
    this.cond = Cond;
    this.messageLength = Message.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(messageLength));
    //END JInit
    if (!Message.empty()) {
      std.memcpy(message, Message.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2056,
   FQN="clang::EnableIfAttr::clone", NM="_ZNK5clang12EnableIfAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12EnableIfAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public EnableIfAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    EnableIfAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new EnableIfAttr(new SourceRange(getLocation()), C, cond, getMessage(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2064,
   FQN="clang::EnableIfAttr::printPretty", NM="_ZNK5clang12EnableIfAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12EnableIfAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((enable_if(").$out(getCond()).$out(/*KEEP_STR*/", \"").$out(getMessage()).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2076,
   FQN="clang::EnableIfAttr::getSpelling", NM="_ZNK5clang12EnableIfAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12EnableIfAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("enable_if");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2259,
   FQN="clang::EnableIfAttr::getCond", NM="_ZNK5clang12EnableIfAttr7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12EnableIfAttr7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() /*const*/ {
    return cond;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2263,
   FQN="clang::EnableIfAttr::getMessage", NM="_ZNK5clang12EnableIfAttr10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12EnableIfAttr10getMessageEv")
  //</editor-fold>
  public StringRef getMessage() /*const*/ {
    return new StringRef(message, messageLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::getMessageLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2266,
   FQN="clang::EnableIfAttr::getMessageLength", NM="_ZNK5clang12EnableIfAttr16getMessageLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12EnableIfAttr16getMessageLengthEv")
  //</editor-fold>
  public /*uint*/int getMessageLength() /*const*/ {
    return messageLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::setMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2269,
   FQN="clang::EnableIfAttr::setMessage", NM="_ZN5clang12EnableIfAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12EnableIfAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setMessage(final ASTContext /*&*/ C, StringRef S) {
    messageLength = S.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(messageLength));
    if (!S.empty()) {
      std.memcpy(this.message, S.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnableIfAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2278,
   FQN="clang::EnableIfAttr::classof", NM="_ZN5clang12EnableIfAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12EnableIfAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.EnableIf;
  }

  
  @Override public String toString() {
    return "" + "cond=" + cond // NOI18N
              + ", messageLength=" + messageLength // NOI18N
              + ", message=" + message // NOI18N
              + super.toString(); // NOI18N
  }
}

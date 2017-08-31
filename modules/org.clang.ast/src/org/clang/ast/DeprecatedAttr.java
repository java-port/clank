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

//<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2066,
 FQN="clang::DeprecatedAttr", NM="_ZN5clang14DeprecatedAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttrE")
//</editor-fold>
public class DeprecatedAttr extends /*public*/ InheritableAttr {
  private /*uint*/int messageLength;
  private char$ptr/*char P*/ message;
  
  private /*uint*/int replacementLength;
  private char$ptr/*char P*/ replacement;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2074,
   FQN="clang::DeprecatedAttr::CreateImplicit", NM="_ZN5clang14DeprecatedAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefES4_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefES4_NS_11SourceRangeE")
  //</editor-fold>
  public static DeprecatedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Message, StringRef Replacement) {
    return CreateImplicit(Ctx, Message, Replacement, new SourceRange());
  }
  public static DeprecatedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Message, StringRef Replacement, SourceRange Loc/*= SourceRange()*/) {
    DeprecatedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new DeprecatedAttr(new SourceRange(Loc), Ctx, new StringRef(Message), new StringRef(Replacement), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::DeprecatedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2080,
   FQN="clang::DeprecatedAttr::DeprecatedAttr", NM="_ZN5clang14DeprecatedAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefES5_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefES5_j")
  //</editor-fold>
  public DeprecatedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Message, 
      StringRef Replacement, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Deprecated, R, SI, false, false), messageLength(Message.size()), message(new (Ctx, 1) new char [messageLength]), replacementLength(Replacement.size()), replacement(new (Ctx, 1) new char [replacementLength]) 
    //START JInit
    super(attr.Kind.Deprecated, new SourceRange(R), SI, false, false);
    this.messageLength = Message.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(messageLength));
    this.replacementLength = Replacement.size();
    this.replacement = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(replacementLength));
    //END JInit
    if (!Message.empty()) {
      std.memcpy(message, Message.data(), messageLength);
    }
    if (!Replacement.empty()) {
      std.memcpy(replacement, Replacement.data(), replacementLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::DeprecatedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2095,
   FQN="clang::DeprecatedAttr::DeprecatedAttr", NM="_ZN5clang14DeprecatedAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public DeprecatedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Deprecated, R, SI, false, false), messageLength(0), message(null), replacementLength(0), replacement(null) 
    //START JInit
    super(attr.Kind.Deprecated, new SourceRange(R), SI, false, false);
    this.messageLength = 0;
    this.message = null;
    this.replacementLength = 0;
    this.replacement = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1901,
   FQN="clang::DeprecatedAttr::clone", NM="_ZNK5clang14DeprecatedAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public DeprecatedAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    DeprecatedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new DeprecatedAttr(new SourceRange(getLocation()), C, getMessage(), getReplacement(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1909,
   FQN="clang::DeprecatedAttr::printPretty", NM="_ZNK5clang14DeprecatedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((deprecated(\"").$out(getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
        if (!getReplacement().empty()) {
          OS.$out(/*KEEP_STR*/", \"").$out(getReplacement()).$out(/*KEEP_STR*/$DBL_QUOTE);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::deprecated(\"").$out(getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __declspec(deprecated(\"").$out(getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
        OS.$out(/*KEEP_STR*/"))");
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" [[deprecated(\"").$out(getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1938,
   FQN="clang::DeprecatedAttr::getSpelling", NM="_ZNK5clang14DeprecatedAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("deprecated");
     case 1:
      return $("deprecated");
     case 2:
      return $("deprecated");
     case 3:
      return $("deprecated");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2108,
   FQN="clang::DeprecatedAttr::getMessage", NM="_ZNK5clang14DeprecatedAttr10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr10getMessageEv")
  //</editor-fold>
  public StringRef getMessage() /*const*/ {
    return new StringRef(message, messageLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::getMessageLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2111,
   FQN="clang::DeprecatedAttr::getMessageLength", NM="_ZNK5clang14DeprecatedAttr16getMessageLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr16getMessageLengthEv")
  //</editor-fold>
  public /*uint*/int getMessageLength() /*const*/ {
    return messageLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::setMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2114,
   FQN="clang::DeprecatedAttr::setMessage", NM="_ZN5clang14DeprecatedAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setMessage(final ASTContext /*&*/ C, StringRef S) {
    messageLength = S.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(messageLength));
    if (!S.empty()) {
      std.memcpy(this.message, S.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::getReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2121,
   FQN="clang::DeprecatedAttr::getReplacement", NM="_ZNK5clang14DeprecatedAttr14getReplacementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr14getReplacementEv")
  //</editor-fold>
  public StringRef getReplacement() /*const*/ {
    return new StringRef(replacement, replacementLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::getReplacementLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2124,
   FQN="clang::DeprecatedAttr::getReplacementLength", NM="_ZNK5clang14DeprecatedAttr20getReplacementLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14DeprecatedAttr20getReplacementLengthEv")
  //</editor-fold>
  public /*uint*/int getReplacementLength() /*const*/ {
    return replacementLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::setReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2127,
   FQN="clang::DeprecatedAttr::setReplacement", NM="_ZN5clang14DeprecatedAttr14setReplacementERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttr14setReplacementERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setReplacement(final ASTContext /*&*/ C, StringRef S) {
    replacementLength = S.size();
    this.replacement = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(replacementLength));
    if (!S.empty()) {
      std.memcpy(this.replacement, S.data(), replacementLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeprecatedAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2136,
   FQN="clang::DeprecatedAttr::classof", NM="_ZN5clang14DeprecatedAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14DeprecatedAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Deprecated;
  }

  
  @Override public String toString() {
    return "" + "messageLength=" + messageLength // NOI18N
              + ", message=" + message // NOI18N
              + ", replacementLength=" + replacementLength // NOI18N
              + ", replacement=" + replacement // NOI18N
              + super.toString(); // NOI18N
  }
}

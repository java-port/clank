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

//<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6871,
 FQN="clang::UnavailableAttr", NM="_ZN5clang15UnavailableAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttrE")
//</editor-fold>
public class UnavailableAttr extends /*public*/ InheritableAttr {
  private /*uint*/int messageLength;
  private char$ptr/*char P*/ message;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::ImplicitReason">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6876,
   FQN="clang::UnavailableAttr::ImplicitReason", NM="_ZN5clang15UnavailableAttr14ImplicitReasonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttr14ImplicitReasonE")
  //</editor-fold>
  public enum ImplicitReason implements Native.ComparableLower {
    IR_None(0),
    IR_ARCForbiddenType(IR_None.getValue() + 1),
    IR_ForbiddenWeak(IR_ARCForbiddenType.getValue() + 1),
    IR_ARCForbiddenConversion(IR_ForbiddenWeak.getValue() + 1),
    IR_ARCInitReturnsUnrelated(IR_ARCForbiddenConversion.getValue() + 1),
    IR_ARCFieldWithOwnership(IR_ARCInitReturnsUnrelated.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ImplicitReason valueOf(int val) {
      ImplicitReason out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ImplicitReason[] VALUES;
      private static final ImplicitReason[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ImplicitReason kind : ImplicitReason.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ImplicitReason[min < 0 ? (1-min) : 0];
        VALUES = new ImplicitReason[max >= 0 ? (1+max) : 0];
        for (ImplicitReason kind : ImplicitReason.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ImplicitReason(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ImplicitReason)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ImplicitReason)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private ImplicitReason implicitReason;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6888,
   FQN="clang::UnavailableAttr::CreateImplicit", NM="_ZN5clang15UnavailableAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS0_14ImplicitReasonENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS0_14ImplicitReasonENS_11SourceRangeE")
  //</editor-fold>
  public static UnavailableAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Message, ImplicitReason ImplicitReason) {
    return CreateImplicit(Ctx, Message, ImplicitReason, new SourceRange());
  }
  public static UnavailableAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Message, ImplicitReason ImplicitReason, SourceRange Loc/*= SourceRange()*/) {
    UnavailableAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new UnavailableAttr(new SourceRange(Loc), Ctx, new StringRef(Message), ImplicitReason, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6894,
   FQN="clang::UnavailableAttr::CreateImplicit", NM="_ZN5clang15UnavailableAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static UnavailableAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Message) {
    return CreateImplicit(Ctx, Message, new SourceRange());
  }
  public static UnavailableAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Message, SourceRange Loc/*= SourceRange()*/) {
    UnavailableAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new UnavailableAttr(new SourceRange(Loc), Ctx, new StringRef(Message), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::UnavailableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6900,
   FQN="clang::UnavailableAttr::UnavailableAttr", NM="_ZN5clang15UnavailableAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefENS0_14ImplicitReasonEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefENS0_14ImplicitReasonEj")
  //</editor-fold>
  public UnavailableAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Message, 
      ImplicitReason ImplicitReason, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Unavailable, R, SI, false, false), messageLength(Message.size()), message(new (Ctx, 1) new char [messageLength]), implicitReason(ImplicitReason) 
    //START JInit
    super(attr.Kind.Unavailable, new SourceRange(R), SI, false, false);
    this.messageLength = Message.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(messageLength));
    this.implicitReason = ImplicitReason;
    //END JInit
    if (!Message.empty()) {
      std.memcpy(message, Message.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::UnavailableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6913,
   FQN="clang::UnavailableAttr::UnavailableAttr", NM="_ZN5clang15UnavailableAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public UnavailableAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Message, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Unavailable, R, SI, false, false), messageLength(Message.size()), message(new (Ctx, 1) new char [messageLength]), implicitReason(ImplicitReason(0)) 
    //START JInit
    super(attr.Kind.Unavailable, new SourceRange(R), SI, false, false);
    this.messageLength = Message.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(messageLength));
    this.implicitReason = ImplicitReason.valueOf(0);
    //END JInit
    if (!Message.empty()) {
      std.memcpy(message, Message.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::UnavailableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6925,
   FQN="clang::UnavailableAttr::UnavailableAttr", NM="_ZN5clang15UnavailableAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public UnavailableAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Unavailable, R, SI, false, false), messageLength(0), message(null), implicitReason(ImplicitReason(0)) 
    //START JInit
    super(attr.Kind.Unavailable, new SourceRange(R), SI, false, false);
    this.messageLength = 0;
    this.message = null;
    this.implicitReason = ImplicitReason.valueOf(0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6475,
   FQN="clang::UnavailableAttr::clone", NM="_ZNK5clang15UnavailableAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15UnavailableAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public UnavailableAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    UnavailableAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new UnavailableAttr(new SourceRange(getLocation()), C, getMessage(), implicitReason, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6483,
   FQN="clang::UnavailableAttr::printPretty", NM="_ZNK5clang15UnavailableAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15UnavailableAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((unavailable(\"").$out(getMessage()).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6495,
   FQN="clang::UnavailableAttr::getSpelling", NM="_ZNK5clang15UnavailableAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15UnavailableAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("unavailable");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6938,
   FQN="clang::UnavailableAttr::getMessage", NM="_ZNK5clang15UnavailableAttr10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15UnavailableAttr10getMessageEv")
  //</editor-fold>
  public StringRef getMessage() /*const*/ {
    return new StringRef(message, messageLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::getMessageLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6941,
   FQN="clang::UnavailableAttr::getMessageLength", NM="_ZNK5clang15UnavailableAttr16getMessageLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15UnavailableAttr16getMessageLengthEv")
  //</editor-fold>
  public /*uint*/int getMessageLength() /*const*/ {
    return messageLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::setMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6944,
   FQN="clang::UnavailableAttr::setMessage", NM="_ZN5clang15UnavailableAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setMessage(final ASTContext /*&*/ C, StringRef S) {
    messageLength = S.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(messageLength));
    if (!S.empty()) {
      std.memcpy(this.message, S.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::getImplicitReason">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6951,
   FQN="clang::UnavailableAttr::getImplicitReason", NM="_ZNK5clang15UnavailableAttr17getImplicitReasonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang15UnavailableAttr17getImplicitReasonEv")
  //</editor-fold>
  public ImplicitReason getImplicitReason() /*const*/ {
    return implicitReason;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnavailableAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6957,
   FQN="clang::UnavailableAttr::classof", NM="_ZN5clang15UnavailableAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang15UnavailableAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Unavailable;
  }

  
  @Override public String toString() {
    return "" + "messageLength=" + messageLength // NOI18N
              + ", message=" + message // NOI18N
              + ", implicitReason=" + implicitReason // NOI18N
              + super.toString(); // NOI18N
  }
}

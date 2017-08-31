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
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1002,
 FQN="clang::AvailabilityAttr", NM="_ZN5clang16AvailabilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttrE")
//</editor-fold>
public class AvailabilityAttr extends /*public*/ InheritableAttr {
  private IdentifierInfo /*P*/ platform;
  
  private VersionTuple introduced;
  
  private VersionTuple deprecated;
  
  private VersionTuple obsoleted;
  
  private boolean unavailable;
  
  private /*uint*/int messageLength;
  private char$ptr/*char P*/ message;
  
  private boolean strict;
  
  private /*uint*/int replacementLength;
  private char$ptr/*char P*/ replacement;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1025,
   FQN="clang::AvailabilityAttr::CreateImplicit", NM="_ZN5clang16AvailabilityAttr14CreateImplicitERNS_10ASTContextEPNS_14IdentifierInfoENS_12VersionTupleES5_S5_bN4llvm9StringRefEbS7_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr14CreateImplicitERNS_10ASTContextEPNS_14IdentifierInfoENS_12VersionTupleES5_S5_bN4llvm9StringRefEbS7_NS_11SourceRangeE")
  //</editor-fold>
  public static AvailabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, IdentifierInfo /*P*/ Platform, VersionTuple Introduced, VersionTuple Deprecated, VersionTuple Obsoleted, boolean Unavailable, StringRef Message, boolean Strict, StringRef Replacement) {
    return CreateImplicit(Ctx, Platform, Introduced, Deprecated, Obsoleted, Unavailable, Message, Strict, Replacement, new SourceRange());
  }
  public static AvailabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, IdentifierInfo /*P*/ Platform, VersionTuple Introduced, VersionTuple Deprecated, VersionTuple Obsoleted, boolean Unavailable, StringRef Message, boolean Strict, StringRef Replacement, SourceRange Loc/*= SourceRange()*/) {
    AvailabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AvailabilityAttr(new SourceRange(Loc), Ctx, Platform, new VersionTuple(Introduced), new VersionTuple(Deprecated), new VersionTuple(Obsoleted), Unavailable, new StringRef(Message), Strict, new StringRef(Replacement), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::AvailabilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1031,
   FQN="clang::AvailabilityAttr::AvailabilityAttr", NM="_ZN5clang16AvailabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoENS_12VersionTupleES6_S6_bN4llvm9StringRefEbS8_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoENS_12VersionTupleES6_S6_bN4llvm9StringRefEbS8_j")
  //</editor-fold>
  public AvailabilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ Platform, 
      VersionTuple Introduced, 
      VersionTuple Deprecated, 
      VersionTuple Obsoleted, 
      boolean Unavailable, 
      StringRef Message, 
      boolean Strict, 
      StringRef Replacement, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Availability, R, SI, false, true), platform(Platform), introduced(Introduced), deprecated(Deprecated), obsoleted(Obsoleted), unavailable(Unavailable), messageLength(Message.size()), message(new (Ctx, 1) new char [messageLength]), strict(Strict), replacementLength(Replacement.size()), replacement(new (Ctx, 1) new char [replacementLength]) 
    //START JInit
    super(attr.Kind.Availability, new SourceRange(R), SI, false, true);
    this.platform = Platform;
    this.introduced = new VersionTuple(Introduced);
    this.deprecated = new VersionTuple(Deprecated);
    this.obsoleted = new VersionTuple(Obsoleted);
    this.unavailable = Unavailable;
    this.messageLength = Message.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(messageLength));
    this.strict = Strict;
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 880,
   FQN="clang::AvailabilityAttr::clone", NM="_ZNK5clang16AvailabilityAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AvailabilityAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AvailabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AvailabilityAttr(new SourceRange(getLocation()), C, platform, getIntroduced(), getDeprecated(), getObsoleted(), unavailable, getMessage(), strict, getReplacement(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 888,
   FQN="clang::AvailabilityAttr::printPretty", NM="_ZNK5clang16AvailabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((availability(").$out(getPlatform().getName());
        if (getStrict()) {
          OS.$out(/*KEEP_STR*/", strict");
        }
        if (!getIntroduced().empty()) {
          $out_raw_ostream_VersionTuple$C(OS.$out(/*KEEP_STR*/", introduced="), getIntroduced());
        }
        if (!getDeprecated().empty()) {
          $out_raw_ostream_VersionTuple$C(OS.$out(/*KEEP_STR*/", deprecated="), getDeprecated());
        }
        if (!getObsoleted().empty()) {
          $out_raw_ostream_VersionTuple$C(OS.$out(/*KEEP_STR*/", obsoleted="), getObsoleted());
        }
        if (getUnavailable()) {
          OS.$out(/*KEEP_STR*/", unavailable");
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 906,
   FQN="clang::AvailabilityAttr::getSpelling", NM="_ZNK5clang16AvailabilityAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("availability");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getPlatform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1062,
   FQN="clang::AvailabilityAttr::getPlatform", NM="_ZNK5clang16AvailabilityAttr11getPlatformEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr11getPlatformEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getPlatform() /*const*/ {
    return platform;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getIntroduced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1066,
   FQN="clang::AvailabilityAttr::getIntroduced", NM="_ZNK5clang16AvailabilityAttr13getIntroducedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr13getIntroducedEv")
  //</editor-fold>
  public VersionTuple getIntroduced() /*const*/ {
    return new VersionTuple(introduced);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::setIntroduced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1069,
   FQN="clang::AvailabilityAttr::setIntroduced", NM="_ZN5clang16AvailabilityAttr13setIntroducedERNS_10ASTContextENS_12VersionTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr13setIntroducedERNS_10ASTContextENS_12VersionTupleE")
  //</editor-fold>
  public void setIntroduced(final ASTContext /*&*/ C, VersionTuple V) {
    introduced.$assign(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getDeprecated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1073,
   FQN="clang::AvailabilityAttr::getDeprecated", NM="_ZNK5clang16AvailabilityAttr13getDeprecatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr13getDeprecatedEv")
  //</editor-fold>
  public VersionTuple getDeprecated() /*const*/ {
    return new VersionTuple(deprecated);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::setDeprecated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1076,
   FQN="clang::AvailabilityAttr::setDeprecated", NM="_ZN5clang16AvailabilityAttr13setDeprecatedERNS_10ASTContextENS_12VersionTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr13setDeprecatedERNS_10ASTContextENS_12VersionTupleE")
  //</editor-fold>
  public void setDeprecated(final ASTContext /*&*/ C, VersionTuple V) {
    deprecated.$assign(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getObsoleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1080,
   FQN="clang::AvailabilityAttr::getObsoleted", NM="_ZNK5clang16AvailabilityAttr12getObsoletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr12getObsoletedEv")
  //</editor-fold>
  public VersionTuple getObsoleted() /*const*/ {
    return new VersionTuple(obsoleted);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::setObsoleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1083,
   FQN="clang::AvailabilityAttr::setObsoleted", NM="_ZN5clang16AvailabilityAttr12setObsoletedERNS_10ASTContextENS_12VersionTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr12setObsoletedERNS_10ASTContextENS_12VersionTupleE")
  //</editor-fold>
  public void setObsoleted(final ASTContext /*&*/ C, VersionTuple V) {
    obsoleted.$assign(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getUnavailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1087,
   FQN="clang::AvailabilityAttr::getUnavailable", NM="_ZNK5clang16AvailabilityAttr14getUnavailableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr14getUnavailableEv")
  //</editor-fold>
  public boolean getUnavailable() /*const*/ {
    return unavailable;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1091,
   FQN="clang::AvailabilityAttr::getMessage", NM="_ZNK5clang16AvailabilityAttr10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr10getMessageEv")
  //</editor-fold>
  public StringRef getMessage() /*const*/ {
    return new StringRef(message, messageLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getMessageLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1094,
   FQN="clang::AvailabilityAttr::getMessageLength", NM="_ZNK5clang16AvailabilityAttr16getMessageLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr16getMessageLengthEv")
  //</editor-fold>
  public /*uint*/int getMessageLength() /*const*/ {
    return messageLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::setMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1097,
   FQN="clang::AvailabilityAttr::setMessage", NM="_ZN5clang16AvailabilityAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr10setMessageERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setMessage(final ASTContext /*&*/ C, StringRef S) {
    messageLength = S.size();
    this.message = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(messageLength));
    if (!S.empty()) {
      std.memcpy(this.message, S.data(), messageLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getStrict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1104,
   FQN="clang::AvailabilityAttr::getStrict", NM="_ZNK5clang16AvailabilityAttr9getStrictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr9getStrictEv")
  //</editor-fold>
  public boolean getStrict() /*const*/ {
    return strict;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1108,
   FQN="clang::AvailabilityAttr::getReplacement", NM="_ZNK5clang16AvailabilityAttr14getReplacementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr14getReplacementEv")
  //</editor-fold>
  public StringRef getReplacement() /*const*/ {
    return new StringRef(replacement, replacementLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getReplacementLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1111,
   FQN="clang::AvailabilityAttr::getReplacementLength", NM="_ZNK5clang16AvailabilityAttr20getReplacementLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AvailabilityAttr20getReplacementLengthEv")
  //</editor-fold>
  public /*uint*/int getReplacementLength() /*const*/ {
    return replacementLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::setReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1114,
   FQN="clang::AvailabilityAttr::setReplacement", NM="_ZN5clang16AvailabilityAttr14setReplacementERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr14setReplacementERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setReplacement(final ASTContext /*&*/ C, StringRef S) {
    replacementLength = S.size();
    this.replacement = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(replacementLength));
    if (!S.empty()) {
      std.memcpy(this.replacement, S.data(), replacementLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::getPrettyPlatformName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1121,
   FQN="clang::AvailabilityAttr::getPrettyPlatformName", NM="_ZN5clang16AvailabilityAttr21getPrettyPlatformNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr21getPrettyPlatformNameEN4llvm9StringRefE")
  //</editor-fold>
  public static StringRef getPrettyPlatformName(StringRef Platform) {
    return new StringSwitchStringRef(/*NO_COPY*/Platform).
        Case(/*KEEP_STR*/"android", /*STRINGREF_STR*/"Android").
        Case(/*KEEP_STR*/"ios", /*STRINGREF_STR*/"iOS").
        Case(/*KEEP_STR*/"macos", /*STRINGREF_STR*/"macOS").
        Case(/*KEEP_STR*/"tvos", /*STRINGREF_STR*/"tvOS").
        Case(/*KEEP_STR*/"watchos", /*STRINGREF_STR*/"watchOS").
        Case(/*KEEP_STR*/"ios_app_extension", /*STRINGREF_STR*/"iOS (App Extension)").
        Case(/*KEEP_STR*/"macos_app_extension", /*STRINGREF_STR*/"macOS (App Extension)").
        Case(/*KEEP_STR*/"tvos_app_extension", /*STRINGREF_STR*/"tvOS (App Extension)").
        Case(/*KEEP_STR*/"watchos_app_extension", /*STRINGREF_STR*/"watchOS (App Extension)").
        Default(new StringRef());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1135,
   FQN="clang::AvailabilityAttr::classof", NM="_ZN5clang16AvailabilityAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AvailabilityAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Availability;
  }

  
  @Override public String toString() {
    return "" + "platform=" + platform // NOI18N
              + ", introduced=" + introduced // NOI18N
              + ", deprecated=" + deprecated // NOI18N
              + ", obsoleted=" + obsoleted // NOI18N
              + ", unavailable=" + unavailable // NOI18N
              + ", messageLength=" + messageLength // NOI18N
              + ", message=" + message // NOI18N
              + ", strict=" + strict // NOI18N
              + ", replacementLength=" + replacementLength // NOI18N
              + ", replacement=" + replacement // NOI18N
              + super.toString(); // NOI18N
  }
}

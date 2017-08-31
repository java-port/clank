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

//<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4018,
 FQN="clang::NoSanitizeAttr", NM="_ZN5clang14NoSanitizeAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14NoSanitizeAttrE")
//</editor-fold>
public class NoSanitizeAttr extends /*public*/ InheritableAttr {
  private /*uint*/int sanitizers_Size;
  private type$ptr<StringRef/*P*/> sanitizers_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4023,
   FQN="clang::NoSanitizeAttr::CreateImplicit", NM="_ZN5clang14NoSanitizeAttr14CreateImplicitERNS_10ASTContextEPN4llvm9StringRefEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14NoSanitizeAttr14CreateImplicitERNS_10ASTContextEPN4llvm9StringRefEjNS_11SourceRangeE")
  //</editor-fold>
  public static NoSanitizeAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, type$ptr<StringRef/*P*/> Sanitizers, /*uint*/int SanitizersSize) {
    return CreateImplicit(Ctx, Sanitizers, SanitizersSize, new SourceRange());
  }
  public static NoSanitizeAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, type$ptr<StringRef/*P*/> Sanitizers, /*uint*/int SanitizersSize, SourceRange Loc/*= SourceRange()*/) {
    NoSanitizeAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new NoSanitizeAttr(new SourceRange(Loc), Ctx, Sanitizers, SanitizersSize, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::NoSanitizeAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4029,
   FQN="clang::NoSanitizeAttr::NoSanitizeAttr", NM="_ZN5clang14NoSanitizeAttrC1ENS_11SourceRangeERNS_10ASTContextEPN4llvm9StringRefEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14NoSanitizeAttrC1ENS_11SourceRangeERNS_10ASTContextEPN4llvm9StringRefEjj")
  //</editor-fold>
  public NoSanitizeAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      type$ptr<StringRef/*P*/> Sanitizers, /*uint*/int SanitizersSize, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::NoSanitize, R, SI, false, false), sanitizers_Size(SanitizersSize), sanitizers_(new (Ctx, 16) new StringRef [sanitizers_Size]) 
    //START JInit
    super(attr.Kind.NoSanitize, new SourceRange(R), SI, false, false);
    this.sanitizers_Size = SanitizersSize;
    this.sanitizers_ = create_type$ptr(new$T(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new StringRef [sanitizers_Size], StringRef::new));
    //END JInit
    for (/*size_t*/int I = 0, E = sanitizers_Size; I != E;
         ++I) {
      StringRef Ref = new StringRef(Sanitizers.$at(I));
      if (!Ref.empty()) {
        char$ptr/*char P*/ Mem = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(Ref.size()));
        std.memcpy(Mem, Ref.data(), Ref.size());
        sanitizers_.$at(I).$assignMove(new StringRef(Mem, Ref.size()));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::NoSanitizeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4047,
   FQN="clang::NoSanitizeAttr::NoSanitizeAttr", NM="_ZN5clang14NoSanitizeAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14NoSanitizeAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public NoSanitizeAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::NoSanitize, R, SI, false, false), sanitizers_Size(0), sanitizers_(null) 
    //START JInit
    super(attr.Kind.NoSanitize, new SourceRange(R), SI, false, false);
    this.sanitizers_Size = 0;
    this.sanitizers_ = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3802,
   FQN="clang::NoSanitizeAttr::clone", NM="_ZNK5clang14NoSanitizeAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public NoSanitizeAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    NoSanitizeAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new NoSanitizeAttr(new SourceRange(getLocation()), C, sanitizers_, sanitizers_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3810,
   FQN="clang::NoSanitizeAttr::printPretty", NM="_ZNK5clang14NoSanitizeAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((no_sanitize(");
        boolean isFirst = true;
        for (final /*const*/ StringRef /*&*/ Val : sanitizers()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(/*KEEP_STR*/$DBL_QUOTE).$out(/*NO_COPY*/Val).$out(/*KEEP_STR*/$DBL_QUOTE);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[clang::no_sanitize(");
        boolean isFirst = true;
        for (final /*const*/ StringRef /*&*/ Val : sanitizers()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(/*KEEP_STR*/$DBL_QUOTE).$out(/*NO_COPY*/Val).$out(/*KEEP_STR*/$DBL_QUOTE);
        }
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3840,
   FQN="clang::NoSanitizeAttr::getSpelling", NM="_ZNK5clang14NoSanitizeAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("no_sanitize");
     case 1:
      return $("no_sanitize");
    }
  }

  /*typedef StringRef *sanitizers_iterator*/
//  public final class sanitizers_iterator extends type$ptr<StringRef/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::sanitizers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4060,
   FQN="clang::NoSanitizeAttr::sanitizers_begin", NM="_ZNK5clang14NoSanitizeAttr16sanitizers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr16sanitizers_beginEv")
  //</editor-fold>
  public type$ptr<StringRef>/*sanitizers_iterator*/ sanitizers_begin() /*const*/ {
    return sanitizers_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::sanitizers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4061,
   FQN="clang::NoSanitizeAttr::sanitizers_end", NM="_ZNK5clang14NoSanitizeAttr14sanitizers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr14sanitizers_endEv")
  //</editor-fold>
  public type$ptr<StringRef>/*sanitizers_iterator*/ sanitizers_end() /*const*/ {
    return sanitizers_.$add(sanitizers_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::sanitizers_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4062,
   FQN="clang::NoSanitizeAttr::sanitizers_size", NM="_ZNK5clang14NoSanitizeAttr15sanitizers_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr15sanitizers_sizeEv")
  //</editor-fold>
  public /*uint*/int sanitizers_size() /*const*/ {
    return sanitizers_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::sanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4063,
   FQN="clang::NoSanitizeAttr::sanitizers", NM="_ZNK5clang14NoSanitizeAttr10sanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr10sanitizersEv")
  //</editor-fold>
  public iterator_range<StringRef/*sanitizers_iterator*/> sanitizers() /*const*/ {
    return llvm.make_range(sanitizers_begin(), sanitizers_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::getMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4067,
   FQN="clang::NoSanitizeAttr::getMask", NM="_ZNK5clang14NoSanitizeAttr7getMaskEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14NoSanitizeAttr7getMaskEv")
  //</editor-fold>
  public long/*uint64_t*/ getMask() /*const*/ {
    long/*uint64_t*/ Mask = 0;
    for (StringRef SanitizerName : sanitizers()) {
      long/*uint64_t*/ ParsedMask = parseSanitizerValue(new StringRef(SanitizerName), /*AllowGroups=*/ true);
      Mask |= expandSanitizerGroups(ParsedMask);
    }
    return Mask;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NoSanitizeAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4078,
   FQN="clang::NoSanitizeAttr::classof", NM="_ZN5clang14NoSanitizeAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14NoSanitizeAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.NoSanitize;
  }

  
  @Override public String toString() {
    return "" + "sanitizers_Size=" + sanitizers_Size // NOI18N
              + ", sanitizers_=" + sanitizers_ // NOI18N
              + super.toString(); // NOI18N
  }
}

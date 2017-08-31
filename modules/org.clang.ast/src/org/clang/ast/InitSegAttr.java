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

//<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2819,
 FQN="clang::InitSegAttr", NM="_ZN5clang11InitSegAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11InitSegAttrE")
//</editor-fold>
public class InitSegAttr extends /*public*/ Attr {
  private /*uint*/int sectionLength;
  private char$ptr/*char P*/ section;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2824,
   FQN="clang::InitSegAttr::CreateImplicit", NM="_ZN5clang11InitSegAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11InitSegAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static InitSegAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Section) {
    return CreateImplicit(Ctx, Section, new SourceRange());
  }
  public static InitSegAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Section, SourceRange Loc/*= SourceRange()*/) {
    InitSegAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new InitSegAttr(new SourceRange(Loc), Ctx, new StringRef(Section), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::InitSegAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2830,
   FQN="clang::InitSegAttr::InitSegAttr", NM="_ZN5clang11InitSegAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11InitSegAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public InitSegAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Section, 
      /*uint*/int SI) {
    // : Attr(attr::InitSeg, R, SI, false, false), sectionLength(Section.size()), section(new (Ctx, 1) new char [sectionLength]) 
    //START JInit
    super(attr.Kind.InitSeg, new SourceRange(R), SI, false, false);
    this.sectionLength = Section.size();
    this.section = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(sectionLength));
    //END JInit
    if (!Section.empty()) {
      std.memcpy(section, Section.data(), sectionLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2669,
   FQN="clang::InitSegAttr::clone", NM="_ZNK5clang11InitSegAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11InitSegAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public InitSegAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    InitSegAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new InitSegAttr(new SourceRange(getLocation()), C, getSection(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2677,
   FQN="clang::InitSegAttr::printPretty", NM="_ZNK5clang11InitSegAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11InitSegAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/"#pragma init_seg ");
        printPrettyPragma(OS, Policy);
        OS.$out(/*KEEP_STR*/$LF);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2690,
   FQN="clang::InitSegAttr::getSpelling", NM="_ZNK5clang11InitSegAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11InitSegAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("init_seg");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::getSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2845,
   FQN="clang::InitSegAttr::getSection", NM="_ZNK5clang11InitSegAttr10getSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11InitSegAttr10getSectionEv")
  //</editor-fold>
  public StringRef getSection() /*const*/ {
    return new StringRef(section, sectionLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::getSectionLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2848,
   FQN="clang::InitSegAttr::getSectionLength", NM="_ZNK5clang11InitSegAttr16getSectionLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11InitSegAttr16getSectionLengthEv")
  //</editor-fold>
  public /*uint*/int getSectionLength() /*const*/ {
    return sectionLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::setSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2851,
   FQN="clang::InitSegAttr::setSection", NM="_ZN5clang11InitSegAttr10setSectionERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11InitSegAttr10setSectionERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setSection(final ASTContext /*&*/ C, StringRef S) {
    sectionLength = S.size();
    this.section = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(sectionLength));
    if (!S.empty()) {
      std.memcpy(this.section, S.data(), sectionLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::printPrettyPragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2859,
   FQN="clang::InitSegAttr::printPrettyPragma", NM="_ZNK5clang11InitSegAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11InitSegAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPrettyPragma(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    OS.$out_char($$LPAREN).$out(getSection()).$out_char($$RPAREN);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitSegAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2864,
   FQN="clang::InitSegAttr::classof", NM="_ZN5clang11InitSegAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11InitSegAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.InitSeg;
  }

  
  @Override public String toString() {
    return "" + "sectionLength=" + sectionLength // NOI18N
              + ", section=" + section // NOI18N
              + super.toString(); // NOI18N
  }
}

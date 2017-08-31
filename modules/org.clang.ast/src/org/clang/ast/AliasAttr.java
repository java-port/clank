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

//<editor-fold defaultstate="collapsed" desc="clang::AliasAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 364,
 FQN="clang::AliasAttr", NM="_ZN5clang9AliasAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9AliasAttrE")
//</editor-fold>
public class AliasAttr extends /*public*/ Attr {
  private /*uint*/int aliaseeLength;
  private char$ptr/*char P*/ aliasee;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 369,
   FQN="clang::AliasAttr::CreateImplicit", NM="_ZN5clang9AliasAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9AliasAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static AliasAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Aliasee) {
    return CreateImplicit(Ctx, Aliasee, new SourceRange());
  }
  public static AliasAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Aliasee, SourceRange Loc/*= SourceRange()*/) {
    AliasAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AliasAttr(new SourceRange(Loc), Ctx, new StringRef(Aliasee), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::AliasAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 375,
   FQN="clang::AliasAttr::AliasAttr", NM="_ZN5clang9AliasAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9AliasAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public AliasAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Aliasee, 
      /*uint*/int SI) {
    // : Attr(attr::Alias, R, SI, false, false), aliaseeLength(Aliasee.size()), aliasee(new (Ctx, 1) new char [aliaseeLength]) 
    //START JInit
    super(attr.Kind.Alias, new SourceRange(R), SI, false, false);
    this.aliaseeLength = Aliasee.size();
    this.aliasee = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(aliaseeLength));
    //END JInit
    if (!Aliasee.empty()) {
      std.memcpy(aliasee, Aliasee.data(), aliaseeLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 325,
   FQN="clang::AliasAttr::clone", NM="_ZNK5clang9AliasAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9AliasAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AliasAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AliasAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AliasAttr(new SourceRange(getLocation()), C, getAliasee(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 333,
   FQN="clang::AliasAttr::printPretty", NM="_ZNK5clang9AliasAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9AliasAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((alias(\"").$out(getAliasee()).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::alias(\"").$out(getAliasee()).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 349,
   FQN="clang::AliasAttr::getSpelling", NM="_ZNK5clang9AliasAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9AliasAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("alias");
     case 1:
      return $("alias");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::getAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 390,
   FQN="clang::AliasAttr::getAliasee", NM="_ZNK5clang9AliasAttr10getAliaseeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9AliasAttr10getAliaseeEv")
  //</editor-fold>
  public StringRef getAliasee() /*const*/ {
    return new StringRef(aliasee, aliaseeLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::getAliaseeLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 393,
   FQN="clang::AliasAttr::getAliaseeLength", NM="_ZNK5clang9AliasAttr16getAliaseeLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9AliasAttr16getAliaseeLengthEv")
  //</editor-fold>
  public /*uint*/int getAliaseeLength() /*const*/ {
    return aliaseeLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::setAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 396,
   FQN="clang::AliasAttr::setAliasee", NM="_ZN5clang9AliasAttr10setAliaseeERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9AliasAttr10setAliaseeERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setAliasee(final ASTContext /*&*/ C, StringRef S) {
    aliaseeLength = S.size();
    this.aliasee = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(aliaseeLength));
    if (!S.empty()) {
      std.memcpy(this.aliasee, S.data(), aliaseeLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AliasAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 405,
   FQN="clang::AliasAttr::classof", NM="_ZN5clang9AliasAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9AliasAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Alias;
  }

  
  @Override public String toString() {
    return "" + "aliaseeLength=" + aliaseeLength // NOI18N
              + ", aliasee=" + aliasee // NOI18N
              + super.toString(); // NOI18N
  }
}

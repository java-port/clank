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

//<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 768,
 FQN="clang::AsmLabelAttr", NM="_ZN5clang12AsmLabelAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AsmLabelAttrE")
//</editor-fold>
public class AsmLabelAttr extends /*public*/ InheritableAttr {
  private /*uint*/int labelLength;
  private char$ptr/*char P*/ label;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 773,
   FQN="clang::AsmLabelAttr::CreateImplicit", NM="_ZN5clang12AsmLabelAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AsmLabelAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static AsmLabelAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Label) {
    return CreateImplicit(Ctx, Label, new SourceRange());
  }
  public static AsmLabelAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Label, SourceRange Loc/*= SourceRange()*/) {
    AsmLabelAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AsmLabelAttr(new SourceRange(Loc), Ctx, new StringRef(Label), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::AsmLabelAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 779,
   FQN="clang::AsmLabelAttr::AsmLabelAttr", NM="_ZN5clang12AsmLabelAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AsmLabelAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public AsmLabelAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Label, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::AsmLabel, R, SI, false, false), labelLength(Label.size()), label(new (Ctx, 1) new char [labelLength]) 
    //START JInit
    super(attr.Kind.AsmLabel, new SourceRange(R), SI, false, false);
    this.labelLength = Label.size();
    this.label = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(labelLength));
    //END JInit
    if (!Label.empty()) {
      std.memcpy(label, Label.data(), labelLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 686,
   FQN="clang::AsmLabelAttr::clone", NM="_ZNK5clang12AsmLabelAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AsmLabelAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AsmLabelAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AsmLabelAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AsmLabelAttr(new SourceRange(getLocation()), C, getLabel(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 694,
   FQN="clang::AsmLabelAttr::printPretty", NM="_ZNK5clang12AsmLabelAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AsmLabelAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" asm(\"").$out(getLabel()).$out(/*KEEP_STR*/"\")");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" __asm__(\"").$out(getLabel()).$out(/*KEEP_STR*/"\")");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 710,
   FQN="clang::AsmLabelAttr::getSpelling", NM="_ZNK5clang12AsmLabelAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AsmLabelAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $asm;
     case 1:
      return $__asm__;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 794,
   FQN="clang::AsmLabelAttr::getLabel", NM="_ZNK5clang12AsmLabelAttr8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AsmLabelAttr8getLabelEv")
  //</editor-fold>
  public StringRef getLabel() /*const*/ {
    return new StringRef(label, labelLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::getLabelLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 797,
   FQN="clang::AsmLabelAttr::getLabelLength", NM="_ZNK5clang12AsmLabelAttr14getLabelLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AsmLabelAttr14getLabelLengthEv")
  //</editor-fold>
  public /*uint*/int getLabelLength() /*const*/ {
    return labelLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::setLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 800,
   FQN="clang::AsmLabelAttr::setLabel", NM="_ZN5clang12AsmLabelAttr8setLabelERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AsmLabelAttr8setLabelERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setLabel(final ASTContext /*&*/ C, StringRef S) {
    labelLength = S.size();
    this.label = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(labelLength));
    if (!S.empty()) {
      std.memcpy(this.label, S.data(), labelLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmLabelAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 809,
   FQN="clang::AsmLabelAttr::classof", NM="_ZN5clang12AsmLabelAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AsmLabelAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.AsmLabel;
  }

  
  @Override public String toString() {
    return "" + "labelLength=" + labelLength // NOI18N
              + ", label=" + label // NOI18N
              + super.toString(); // NOI18N
  }
}

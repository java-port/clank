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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3371,
 FQN="clang::MSP430InterruptAttr", NM="_ZN5clang19MSP430InterruptAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19MSP430InterruptAttrE")
//</editor-fold>
public class MSP430InterruptAttr extends /*public*/ InheritableAttr {
  private /*uint*/int number;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3375,
   FQN="clang::MSP430InterruptAttr::CreateImplicit", NM="_ZN5clang19MSP430InterruptAttr14CreateImplicitERNS_10ASTContextEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19MSP430InterruptAttr14CreateImplicitERNS_10ASTContextEjNS_11SourceRangeE")
  //</editor-fold>
  public static MSP430InterruptAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int Number) {
    return CreateImplicit(Ctx, Number, new SourceRange());
  }
  public static MSP430InterruptAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int Number, SourceRange Loc/*= SourceRange()*/) {
    MSP430InterruptAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new MSP430InterruptAttr(new SourceRange(Loc), Ctx, Number, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::MSP430InterruptAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3381,
   FQN="clang::MSP430InterruptAttr::MSP430InterruptAttr", NM="_ZN5clang19MSP430InterruptAttrC1ENS_11SourceRangeERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19MSP430InterruptAttrC1ENS_11SourceRangeERNS_10ASTContextEjj")
  //</editor-fold>
  public MSP430InterruptAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int Number, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::MSP430Interrupt, R, SI, false, false), number(Number) 
    //START JInit
    super(attr.Kind.MSP430Interrupt, new SourceRange(R), SI, false, false);
    this.number = Number;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3052,
   FQN="clang::MSP430InterruptAttr::clone", NM="_ZNK5clang19MSP430InterruptAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19MSP430InterruptAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public MSP430InterruptAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    MSP430InterruptAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new MSP430InterruptAttr(new SourceRange(getLocation()), C, number, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3060,
   FQN="clang::MSP430InterruptAttr::printPretty", NM="_ZNK5clang19MSP430InterruptAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19MSP430InterruptAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((interrupt(").$out_uint(getNumber()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3072,
   FQN="clang::MSP430InterruptAttr::getSpelling", NM="_ZNK5clang19MSP430InterruptAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19MSP430InterruptAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("interrupt");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::getNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3394,
   FQN="clang::MSP430InterruptAttr::getNumber", NM="_ZNK5clang19MSP430InterruptAttr9getNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19MSP430InterruptAttr9getNumberEv")
  //</editor-fold>
  public /*uint*/int getNumber() /*const*/ {
    return number;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSP430InterruptAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3400,
   FQN="clang::MSP430InterruptAttr::classof", NM="_ZN5clang19MSP430InterruptAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19MSP430InterruptAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.MSP430Interrupt;
  }

  
  @Override public String toString() {
    return "" + "number=" + number // NOI18N
              + super.toString(); // NOI18N
  }
}

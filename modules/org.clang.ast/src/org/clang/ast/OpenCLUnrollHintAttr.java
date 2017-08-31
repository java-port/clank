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

//<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5147,
 FQN="clang::OpenCLUnrollHintAttr", NM="_ZN5clang20OpenCLUnrollHintAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20OpenCLUnrollHintAttrE")
//</editor-fold>
public class OpenCLUnrollHintAttr extends /*public*/ InheritableAttr {
  private /*uint*/int unrollHint;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5151,
   FQN="clang::OpenCLUnrollHintAttr::CreateImplicit", NM="_ZN5clang20OpenCLUnrollHintAttr14CreateImplicitERNS_10ASTContextEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20OpenCLUnrollHintAttr14CreateImplicitERNS_10ASTContextEjNS_11SourceRangeE")
  //</editor-fold>
  public static OpenCLUnrollHintAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int UnrollHint) {
    return CreateImplicit(Ctx, UnrollHint, new SourceRange());
  }
  public static OpenCLUnrollHintAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int UnrollHint, SourceRange Loc/*= SourceRange()*/) {
    OpenCLUnrollHintAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new OpenCLUnrollHintAttr(new SourceRange(Loc), Ctx, UnrollHint, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::OpenCLUnrollHintAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5157,
   FQN="clang::OpenCLUnrollHintAttr::OpenCLUnrollHintAttr", NM="_ZN5clang20OpenCLUnrollHintAttrC1ENS_11SourceRangeERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20OpenCLUnrollHintAttrC1ENS_11SourceRangeERNS_10ASTContextEjj")
  //</editor-fold>
  public OpenCLUnrollHintAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int UnrollHint, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::OpenCLUnrollHint, R, SI, false, false), unrollHint(UnrollHint) 
    //START JInit
    super(attr.Kind.OpenCLUnrollHint, new SourceRange(R), SI, false, false);
    this.unrollHint = UnrollHint;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4744,
   FQN="clang::OpenCLUnrollHintAttr::clone", NM="_ZNK5clang20OpenCLUnrollHintAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20OpenCLUnrollHintAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public OpenCLUnrollHintAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    OpenCLUnrollHintAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new OpenCLUnrollHintAttr(new SourceRange(getLocation()), C, unrollHint, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4752,
   FQN="clang::OpenCLUnrollHintAttr::printPretty", NM="_ZNK5clang20OpenCLUnrollHintAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20OpenCLUnrollHintAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((opencl_unroll_hint(").$out_uint(getUnrollHint()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4764,
   FQN="clang::OpenCLUnrollHintAttr::getSpelling", NM="_ZNK5clang20OpenCLUnrollHintAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20OpenCLUnrollHintAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("opencl_unroll_hint");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::getUnrollHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5170,
   FQN="clang::OpenCLUnrollHintAttr::getUnrollHint", NM="_ZNK5clang20OpenCLUnrollHintAttr13getUnrollHintEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20OpenCLUnrollHintAttr13getUnrollHintEv")
  //</editor-fold>
  public /*uint*/int getUnrollHint() /*const*/ {
    return unrollHint;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLUnrollHintAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5176,
   FQN="clang::OpenCLUnrollHintAttr::classof", NM="_ZN5clang20OpenCLUnrollHintAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20OpenCLUnrollHintAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.OpenCLUnrollHint;
  }

  
  @Override public String toString() {
    return "" + "unrollHint=" + unrollHint // NOI18N
              + super.toString(); // NOI18N
  }
}

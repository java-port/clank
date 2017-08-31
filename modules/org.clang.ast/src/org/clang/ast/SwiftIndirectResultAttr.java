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

//<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6383,
 FQN="clang::SwiftIndirectResultAttr", NM="_ZN5clang23SwiftIndirectResultAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23SwiftIndirectResultAttrE")
//</editor-fold>
public class SwiftIndirectResultAttr extends /*public*/ ParameterABIAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6385,
   FQN="clang::SwiftIndirectResultAttr::CreateImplicit", NM="_ZN5clang23SwiftIndirectResultAttr14CreateImplicitERNS_10ASTContextENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23SwiftIndirectResultAttr14CreateImplicitERNS_10ASTContextENS_11SourceRangeE")
  //</editor-fold>
  public static SwiftIndirectResultAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx) {
    return CreateImplicit(Ctx, new SourceRange());
  }
  public static SwiftIndirectResultAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, SourceRange Loc/*= SourceRange()*/) {
    SwiftIndirectResultAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new SwiftIndirectResultAttr(new SourceRange(Loc), Ctx, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr::SwiftIndirectResultAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6391,
   FQN="clang::SwiftIndirectResultAttr::SwiftIndirectResultAttr", NM="_ZN5clang23SwiftIndirectResultAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23SwiftIndirectResultAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public SwiftIndirectResultAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : ParameterABIAttr(attr::SwiftIndirectResult, R, SI, false, false) 
    //START JInit
    super(attr.Kind.SwiftIndirectResult, new SourceRange(R), SI, false, false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6045,
   FQN="clang::SwiftIndirectResultAttr::clone", NM="_ZNK5clang23SwiftIndirectResultAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23SwiftIndirectResultAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public SwiftIndirectResultAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    SwiftIndirectResultAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new SwiftIndirectResultAttr(new SourceRange(getLocation()), C, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6053,
   FQN="clang::SwiftIndirectResultAttr::printPretty", NM="_ZNK5clang23SwiftIndirectResultAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23SwiftIndirectResultAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((swift_indirect_result))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::swift_indirect_result]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6069,
   FQN="clang::SwiftIndirectResultAttr::getSpelling", NM="_ZNK5clang23SwiftIndirectResultAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23SwiftIndirectResultAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("swift_indirect_result");
     case 1:
      return $("swift_indirect_result");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwiftIndirectResultAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6404,
   FQN="clang::SwiftIndirectResultAttr::classof", NM="_ZN5clang23SwiftIndirectResultAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23SwiftIndirectResultAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.SwiftIndirectResult;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}

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

//<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1764,
 FQN="clang::CleanupAttr", NM="_ZN5clang11CleanupAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11CleanupAttrE")
//</editor-fold>
public class CleanupAttr extends /*public*/ InheritableAttr {
  private FunctionDecl /*P*/ functionDecl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1768,
   FQN="clang::CleanupAttr::CreateImplicit", NM="_ZN5clang11CleanupAttr14CreateImplicitERNS_10ASTContextEPNS_12FunctionDeclENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11CleanupAttr14CreateImplicitERNS_10ASTContextEPNS_12FunctionDeclENS_11SourceRangeE")
  //</editor-fold>
  public static CleanupAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, FunctionDecl /*P*/ FunctionDecl) {
    return CreateImplicit(Ctx, FunctionDecl, new SourceRange());
  }
  public static CleanupAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, FunctionDecl /*P*/ FunctionDecl, SourceRange Loc/*= SourceRange()*/) {
    CleanupAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new CleanupAttr(new SourceRange(Loc), Ctx, FunctionDecl, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::CleanupAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1774,
   FQN="clang::CleanupAttr::CleanupAttr", NM="_ZN5clang11CleanupAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_12FunctionDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11CleanupAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_12FunctionDeclEj")
  //</editor-fold>
  public CleanupAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      FunctionDecl /*P*/ FunctionDecl, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Cleanup, R, SI, false, false), functionDecl(FunctionDecl) 
    //START JInit
    super(attr.Kind.Cleanup, new SourceRange(R), SI, false, false);
    this.functionDecl = FunctionDecl;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1535,
   FQN="clang::CleanupAttr::clone", NM="_ZNK5clang11CleanupAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11CleanupAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public CleanupAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    CleanupAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new CleanupAttr(new SourceRange(getLocation()), C, functionDecl, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1543,
   FQN="clang::CleanupAttr::printPretty", NM="_ZNK5clang11CleanupAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11CleanupAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((cleanup(").$out(getFunctionDecl().getNameInfo().getAsString()).$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::cleanup(").$out(getFunctionDecl().getNameInfo().getAsString()).$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1559,
   FQN="clang::CleanupAttr::getSpelling", NM="_ZNK5clang11CleanupAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11CleanupAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("cleanup");
     case 1:
      return $("cleanup");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::getFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1787,
   FQN="clang::CleanupAttr::getFunctionDecl", NM="_ZNK5clang11CleanupAttr15getFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11CleanupAttr15getFunctionDeclEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getFunctionDecl() /*const*/ {
    return functionDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1793,
   FQN="clang::CleanupAttr::classof", NM="_ZN5clang11CleanupAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11CleanupAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Cleanup;
  }

  
  @Override public String toString() {
    return "" + "functionDecl=" + functionDecl // NOI18N
              + super.toString(); // NOI18N
  }
}

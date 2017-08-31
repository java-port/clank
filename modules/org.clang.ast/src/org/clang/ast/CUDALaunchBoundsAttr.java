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

//<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1480,
 FQN="clang::CUDALaunchBoundsAttr", NM="_ZN5clang20CUDALaunchBoundsAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20CUDALaunchBoundsAttrE")
//</editor-fold>
public class CUDALaunchBoundsAttr extends /*public*/ InheritableAttr {
  private Expr /*P*/ maxThreads;
  
  private Expr /*P*/ minBlocks;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1486,
   FQN="clang::CUDALaunchBoundsAttr::CreateImplicit", NM="_ZN5clang20CUDALaunchBoundsAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprES4_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20CUDALaunchBoundsAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprES4_NS_11SourceRangeE")
  //</editor-fold>
  public static CUDALaunchBoundsAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ MaxThreads, Expr /*P*/ MinBlocks) {
    return CreateImplicit(Ctx, MaxThreads, MinBlocks, new SourceRange());
  }
  public static CUDALaunchBoundsAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ MaxThreads, Expr /*P*/ MinBlocks, SourceRange Loc/*= SourceRange()*/) {
    CUDALaunchBoundsAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new CUDALaunchBoundsAttr(new SourceRange(Loc), Ctx, MaxThreads, MinBlocks, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::CUDALaunchBoundsAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1492,
   FQN="clang::CUDALaunchBoundsAttr::CUDALaunchBoundsAttr", NM="_ZN5clang20CUDALaunchBoundsAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprES5_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20CUDALaunchBoundsAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprES5_j")
  //</editor-fold>
  public CUDALaunchBoundsAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ MaxThreads, 
      Expr /*P*/ MinBlocks, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::CUDALaunchBounds, R, SI, false, false), maxThreads(MaxThreads), minBlocks(MinBlocks) 
    //START JInit
    super(attr.Kind.CUDALaunchBounds, new SourceRange(R), SI, false, false);
    this.maxThreads = MaxThreads;
    this.minBlocks = MinBlocks;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::CUDALaunchBoundsAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1503,
   FQN="clang::CUDALaunchBoundsAttr::CUDALaunchBoundsAttr", NM="_ZN5clang20CUDALaunchBoundsAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20CUDALaunchBoundsAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj")
  //</editor-fold>
  public CUDALaunchBoundsAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ MaxThreads, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::CUDALaunchBounds, R, SI, false, false), maxThreads(MaxThreads), minBlocks(implicit Expr * ()) 
    //START JInit
    super(attr.Kind.CUDALaunchBounds, new SourceRange(R), SI, false, false);
    this.maxThreads = MaxThreads;
    this.minBlocks = /*implicit-init*/((Expr /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1309,
   FQN="clang::CUDALaunchBoundsAttr::clone", NM="_ZNK5clang20CUDALaunchBoundsAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20CUDALaunchBoundsAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public CUDALaunchBoundsAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    CUDALaunchBoundsAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new CUDALaunchBoundsAttr(new SourceRange(getLocation()), C, maxThreads, minBlocks, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1317,
   FQN="clang::CUDALaunchBoundsAttr::printPretty", NM="_ZNK5clang20CUDALaunchBoundsAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20CUDALaunchBoundsAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((launch_bounds(").$out(getMaxThreads()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(getMinBlocks()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1329,
   FQN="clang::CUDALaunchBoundsAttr::getSpelling", NM="_ZNK5clang20CUDALaunchBoundsAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20CUDALaunchBoundsAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("launch_bounds");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::getMaxThreads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1517,
   FQN="clang::CUDALaunchBoundsAttr::getMaxThreads", NM="_ZNK5clang20CUDALaunchBoundsAttr13getMaxThreadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20CUDALaunchBoundsAttr13getMaxThreadsEv")
  //</editor-fold>
  public Expr /*P*/ getMaxThreads() /*const*/ {
    return maxThreads;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::getMinBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1521,
   FQN="clang::CUDALaunchBoundsAttr::getMinBlocks", NM="_ZNK5clang20CUDALaunchBoundsAttr12getMinBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20CUDALaunchBoundsAttr12getMinBlocksEv")
  //</editor-fold>
  public Expr /*P*/ getMinBlocks() /*const*/ {
    return minBlocks;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDALaunchBoundsAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1527,
   FQN="clang::CUDALaunchBoundsAttr::classof", NM="_ZN5clang20CUDALaunchBoundsAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20CUDALaunchBoundsAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.CUDALaunchBounds;
  }

  
  @Override public String toString() {
    return "" + "maxThreads=" + maxThreads // NOI18N
              + ", minBlocks=" + minBlocks // NOI18N
              + super.toString(); // NOI18N
  }
}
